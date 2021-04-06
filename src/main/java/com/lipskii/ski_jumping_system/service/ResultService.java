package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.ResultRepository;
import com.lipskii.ski_jumping_system.db_data.FetchedResultsObject;
import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.Result;
import com.lipskii.ski_jumping_system.controllers.FilesPaths;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultService implements ServiceInterface {

    private final ResultRepository resultRepository;
    private final CompetitionService competitionService;
    private final SkiJumperService skiJumperService;
    private final DisqualificationTypeService disqualificationTypeService;

    @Autowired
    public ResultService(ResultRepository resultRepository, CompetitionService competitionService, SkiJumperService skiJumperService, DisqualificationTypeService disqualificationTypeService) {
        this.resultRepository = resultRepository;
        this.competitionService = competitionService;
        this.skiJumperService = skiJumperService;
        this.disqualificationTypeService = disqualificationTypeService;
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    public List<Result> findAllByCompetitionId(int competitionId) {
        return resultRepository.findAllByCompetitionIdOrderByTotalRank(competitionId);
    }


    @Override
    public Optional<Result> findById(int id) {
        return resultRepository.findById(id);
    }

    @Override
    public Result save(Object obj) {
        return resultRepository.save((Result) obj);
    }

    public void saveFromLink(String link, int competitionId) {
        link = link.replace("%3A", ":");
        link = link.replace("%2F", "/");
        link = link.replace("%3F", "?");

        Competition competition = competitionService
                .findById(competitionId)
                .orElseThrow(() -> new ResourceNotFoundException("no competition found for id = " + competitionId));

        if(!competition.getResults().isEmpty()){
            for(Result result : competition.getResults()){
                resultRepository.deleteById(result.getId());
            }
        }
        List<String[]> resultsArray = fetchResultsIntoStringArray(link);
        Path pathCsv = Paths.get(FilesPaths.RESULTS_PATH + competitionId + "_" + competition.getDate1().toString() + ".csv");
        try {
            csvWriterAll(resultsArray, pathCsv);
            saveFromCSV(pathCsv, competition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFromCSV(Path path, Competition competition) {
        try (CSVReader reader = new CSVReader(new FileReader(path.toString()))) {
            List<String[]> results = reader.readAll();
            int numOfColumns = results.get(0).length;
            switch (numOfColumns) {
                case 7:
                    saveTwoRoundsRCMPMPT(results, competition);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveTwoRoundsRCMPMPT(List<String[]> results, Competition competition) {
        results.forEach(resultData -> {
            Result result = new Result();
            result.setCompetition(competition);
            result.setTotalRank(Integer.parseInt(resultData[0]));
            String skiJumperCode = resultData[1];
            SkiJumper skiJumper = skiJumperService.findByCode(skiJumperCode);
            if (skiJumper != null) {
                result.setSkiJumper(skiJumper);
                result.setFirstRoundDistance(BigDecimal.valueOf(Double.parseDouble(resultData[2])));
                result.setFirstRoundTotal(BigDecimal.valueOf(Double.parseDouble(resultData[3])));
                result.setSecondRoundDistance(BigDecimal.valueOf(Double.parseDouble(resultData[4])));
                result.setSecondRoundTotal(BigDecimal.valueOf(Double.parseDouble(resultData[5])));
                result.setTotalPoints(BigDecimal.valueOf(Double.parseDouble(resultData[6])));
                result.setDisqualificationType(disqualificationTypeService.findById(1)
                        .orElseThrow(() -> new ResourceNotFoundException("no dsq type found for id = "
                                + 1)));
                resultRepository.save(result);
            }
        });

    }

    @Override
    public void deleteById(int id) {
        resultRepository.deleteById(id);
    }

    public static List<String[]> fetchResultsIntoStringArray(String link) {
        try {
            Document doc = Jsoup.connect(link).get();
            Elements elements = doc.getElementsByClass("table-row");
            List<FetchedResultsObject> fetchedResultsObjects = new ArrayList<>();
            for (Element element : elements) {
                if (!element.getElementsByClass("g-lg g-md g-sm g-xs justify-left bold").text().equals("")) {

                    FetchedResultsObject fetchedResultsObject = new FetchedResultsObject();
                    if (!element.getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right pr-1 gray bold")
                            .text().equals("")) {
                        fetchedResultsObject.setRank(Integer
                                .parseInt(element
                                        .getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right pr-1 gray bold")
                                        .text()));
                    }
                    if (!element.getElementsByClass("g-lg-2 g-md-2 g-sm-2 hidden-xs justify-right gray pr-1")
                            .text().equals("")) {
                        fetchedResultsObject.setCode(Integer
                                .parseInt(element
                                        .getElementsByClass("g-lg-2 g-md-2 g-sm-2 hidden-xs justify-right gray pr-1")
                                        .text()));
                    }
                    if (!element.getElementsByClass("g-row justify-right bold")
                            .text().equals("")) {
                        String[] distances = element.getElementsByClass("g-row justify-right bold")
                                .text().split(" ");

                        if (distances.length == 1) {
                            fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                        } else {
                            fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                            fetchedResultsObject.setSecondRoundDistance(Float.parseFloat(distances[1]));
                        }
                    }
                    if (!element.getElementsByClass("g-lg-24 justify-right bold")
                            .text().equals("")) {
                        String[] points = element.getElementsByClass("g-lg-24 justify-right bold")
                                .text().split(" ");

                        if (points.length == 1) {
                            fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                        } else {
                            fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                            fetchedResultsObject.setSecondRoundPoints(Float.parseFloat(points[1]));
                        }
                    }
                    if (!element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right blue bold ")
                            .text().equals("")) {
                        fetchedResultsObject.setTotalPoints(Float.parseFloat(element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right blue bold ")
                                .text()));
                    }
                    fetchedResultsObjects.add(fetchedResultsObject);
                }

            }

            List<String[]> stringArray = new ArrayList<>();
            for (FetchedResultsObject fetchedResultsObject : fetchedResultsObjects) {
                String[] row = new String[7];
                row[0] = String.valueOf(fetchedResultsObject.getRank());
                row[1] = String.valueOf(fetchedResultsObject.getCode());
                row[2] = String.valueOf(fetchedResultsObject.getFirstRoundDistance());
                row[3] = String.valueOf(fetchedResultsObject.getFirstRoundPoints());
                row[4] = String.valueOf(fetchedResultsObject.getSecondRoundDistance());
                row[5] = String.valueOf(fetchedResultsObject.getSecondRoundPoints());
                row[6] = String.valueOf(fetchedResultsObject.getTotalPoints());
                stringArray.add(row);

            }

            return stringArray;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void csvWriterAll(List<String[]> stringArray, Path path) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(path.toString()));
        writer.writeAll(stringArray);
        writer.close();
    }

}
