package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.ResultRepository;
import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.Result;
import com.lipskii.ski_jumping_system.controllers.FilesPaths;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.math.BigDecimal;
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

    @Override
    public void deleteById(int id) {
        resultRepository.deleteById(id);
    }

    public void saveFromCSV(String fileName, int competitionId) {
        try (CSVReader reader = new CSVReader(new FileReader(FilesPaths.RESULTS_PATH + fileName))) {
            List<String[]> results = reader.readAll();
            int numOfColumns = results.get(0).length;
            switch(numOfColumns){
                case 9:
                    saveTwoRoundsMPMPT(results, competitionId);
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void saveTwoRoundsMPMPT(List<String[]> results, int competitionId) {
        results.forEach(resultData -> {
            Result result = new Result();
            Competition competition = competitionService.findById(competitionId).orElseThrow(() ->
                    new ResourceNotFoundException("no competition found for id = " + competitionId));
            result.setCompetition(competition);
            int skiJumperId = Integer.parseInt(resultData[1]);
            result.setSkiJumper(skiJumperService.findById(skiJumperId)
                    .orElseThrow(() -> new ResourceNotFoundException("no ski jumper found for id = "
                            + skiJumperId)));
            int dsqTypeId = Integer.parseInt(resultData[7]);
            result.setDisqualificationType(disqualificationTypeService.findById(dsqTypeId)
                    .orElseThrow(() -> new ResourceNotFoundException("no dsq type found for id = "
                            + dsqTypeId)));
            result.setFirstRoundDistance(BigDecimal.valueOf(Double.parseDouble(resultData[2])));
            result.setFirstRoundTotal(BigDecimal.valueOf(Double.parseDouble(resultData[3])));
            result.setSecondRoundDistance(BigDecimal.valueOf(Double.parseDouble(resultData[4])));
            result.setSecondRoundTotal(BigDecimal.valueOf(Double.parseDouble(resultData[5])));
            result.setTotalPoints(BigDecimal.valueOf(Double.parseDouble(resultData[6])));
            result.setTotalRank(Integer.parseInt((resultData[8])));
            resultRepository.save(result);
        });

    }
}
