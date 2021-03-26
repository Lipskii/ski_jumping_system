package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CompetitionRepository;
import com.lipskii.ski_jumping_system.dto.CompetitionDTO;
import com.lipskii.ski_jumping_system.dto.SkiJumperDTO;
import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.Hill;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import com.lipskii.ski_jumping_system.rest.FilesPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
    private final HillService hillService;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository, @Lazy ResultService resultService, HillService hillService) {
        this.competitionRepository = competitionRepository;
        this.resultService = resultService;
        this.hillService = hillService;
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAllByOrderByDate1Desc();
    }

    public List<Competition> get(Specification<Competition> spec, Sort sort) {
        return competitionRepository.findAll(spec, sort);
    }

    public List<Competition> findAllBySeriesId(int seriesId){
        return competitionRepository.findAllBySeriesMajorIdOrderByDate1Desc(seriesId);
    }

    public List<Competition> findAllByHillId(int hillId){
        Hill hill = hillService.findById(hillId).orElseThrow(() -> new ResourceNotFoundException("No hill found for id = " + hillId));
        return competitionRepository.findAllByHillVersionHillOrderByDate1Desc(hill);
    }

    public List<Competition> findAllBySeriesAndHillId(int hillId, int seriesId) {
        Hill hill = hillService.findById(hillId).orElseThrow(() -> new ResourceNotFoundException("No hill found for id = " + hillId));
        return competitionRepository.findAllBySeriesMajorIdAndHillVersionHillOrderByDate1Desc(seriesId,hill);
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
        resultService.saveFromCSV(csvFileName, competitionId);
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

    public List<Competition> findAllBySeasonId(int seasonId) {
        return competitionRepository.findAllBySeasonId(seasonId);
    }


}
