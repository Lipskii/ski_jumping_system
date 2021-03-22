package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CompetitionRepository;
import com.lipskii.ski_jumping_system.dto.CompetitionDTO;
import com.lipskii.ski_jumping_system.dto.SkiJumperDTO;
import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import com.lipskii.ski_jumping_system.rest.FilesPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService implements ServiceInterface {


    private final CompetitionRepository competitionRepository;
    private final ResultService resultService;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository, @Lazy ResultService resultService) {
        this.competitionRepository = competitionRepository;
        this.resultService = resultService;
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAllByOrderByDate1Desc();
    }

    public void assignFiles(MultipartFile csvFile, MultipartFile pdfFile, Competition competition, int competitionId)
            throws IOException {
        byte[] bytesCsv = csvFile.getBytes();
        String csvFileName = +competitionId + "_" + competition.getDate1().toString() + ".csv";
        Path pathCsv = Paths.get(FilesPaths.RESULTS_PATH + csvFileName);
        Files.write(pathCsv, bytesCsv);
        competition.setCsvFile(csvFileName);
        byte[] bytesPdf = pdfFile.getBytes();
        String pdfFileName = +competitionId + "_" + competition.getDate1().toString() + ".pdf";
        Path pathPdf = Paths.get(FilesPaths.RESULTS_PATH + pdfFileName);
        Files.write(pathPdf, bytesPdf);
        competition.setPdfFile(pdfFileName);
        save(competition);
      // resultService.saveFromCSV(csvFileName, competitionId);
    }

    @Override
    public Optional<Competition> findById(int id) {
        return competitionRepository.findById(id);
    }

    @Override
    public Competition save(Object obj) {
        return competitionRepository.save((Competition) obj);
    }

    @Override
    public void deleteById(int id) {
        competitionRepository.deleteById(id);
    }

//    private CompetitionDTO convertToCompetitionDTO(Competition competition) {
//        CompetitionDTO competitionDTO = new CompetitionDTO();
//        competitionDTO.setId(competition.getId());
//        competitionDTO.setSeason(competition.getSeason());
//        competitionDTO.setDate1(competition.getDate1());
//        competitionDTO.setDate2(competition.getDate2());
//        competitionDTO.setSeriesMajor(competition.getSeriesMajor());
//        competitionDTO.setSeriesMinor(competition.getSeriesMinor());
//        competitionDTO.setCountry(competition.getHillVersion().getHill().getVenue().getCity().getRegion().getCountry());
//        competitionDTO.setCity(competition.getHillVersion().getHill().getVenue().getCity());
//        competitionDTO.setVenue(competition.getHillVersion().getHill().getVenue());
//        competitionDTO.setHill(competition.getHillVersion().getHill());
//        competitionDTO.setHillVersion(competition.getHillVersion());
//        competitionDTO.setJudgeA(competition.getJudgeA());
//        return competitionDTO;
//    }
}
