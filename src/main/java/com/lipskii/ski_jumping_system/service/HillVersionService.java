package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.HillVersionRepository;
import com.lipskii.ski_jumping_system.dto.HillRecordDTO;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HillVersionService implements ServiceInterface {

    private final HillVersionRepository hillVersionRepository;
    private final ResultService resultService;
    private final TeamResultIndividualService teamResultIndividualService;

    @Autowired
    public HillVersionService(HillVersionRepository hillVersionRepository, ResultService resultService, TeamResultIndividualService teamResultIndividualService) {
        this.hillVersionRepository = hillVersionRepository;
        this.resultService = resultService;
        this.teamResultIndividualService = teamResultIndividualService;
    }


    public List<HillVersion> get(Specification<HillVersion> spec, Sort sort) {
        return hillVersionRepository.findAll(spec, sort);
    }

    public List<HillRecordDTO> getHillRecords(int hillVersionId) {
        List<Result> results = new ArrayList<>();
        List<TeamResultIndividual> teamResultIndividuals = new ArrayList<>();
        for(int i = 1; i<12; i++){
            if(i != 7 && i != 8){
                if(i == 2 || i == 4 || i == 6 || i == 11){
                   teamResultIndividuals.addAll(teamResultIndividualService.findAllByHillVersionIdAndSeriesMajorId(hillVersionId,i));
                } else {
                    results.addAll(resultService.findAllByHillVersionIdAndCompetitionSeriesMajorId(hillVersionId,i));
                }

            }
        }

        List<HillRecordDTO> hillRecordDTOS = new ArrayList<>();

        BigDecimal hillRecord = BigDecimal.valueOf(0);
        for (Result result : results) {
            List<BigDecimal> distances = new ArrayList<>();
            if (result.getFirstRoundDistance() != null) {
                distances.add(result.getFirstRoundDistance());
            }
            if (result.getSecondRoundDistance() != null) {
                distances.add(result.getSecondRoundDistance());
            }
            if (result.getThirdRoundDistance() != null) {
                distances.add(result.getThirdRoundDistance());
            }
            if (result.getFourthRoundDistance() != null) {
                distances.add(result.getFourthRoundDistance());
            }
            for (BigDecimal distance : distances) {
                if (distance.doubleValue() > hillRecord.doubleValue()) {
                    hillRecordDTOS.clear();
                    hillRecordDTOS.add(convertToHillRecordDTO(result.getCompetition(),result.getSkiJumper(),distance));
                    hillRecord = distance;
                } else if (distance.doubleValue() == hillRecord.doubleValue()) {
                    hillRecordDTOS.add(convertToHillRecordDTO(result.getCompetition(),result.getSkiJumper(),distance));
                }
            }
        }

        for (TeamResultIndividual result : teamResultIndividuals) {
            List<BigDecimal> distances = new ArrayList<>();
            if (result.getFirstRoundDistance() != null) {
                distances.add(result.getFirstRoundDistance());
            }
            if (result.getSecondRoundDistance() != null) {
                distances.add(result.getSecondRoundDistance());
            }
            for (BigDecimal distance : distances) {
                if (distance.doubleValue() > hillRecord.doubleValue()) {
                    hillRecordDTOS.clear();
                    hillRecordDTOS.add(convertToHillRecordDTO(result.getTeamResult().getCompetition(),result.getSkiJumper(),distance));
                    hillRecord = distance;
                } else if (distance.doubleValue() == hillRecord.doubleValue()) {
                    hillRecordDTOS.add(convertToHillRecordDTO(result.getTeamResult().getCompetition(),result.getSkiJumper(),distance));
                }
            }
        }
        return hillRecordDTOS;
    }

    private HillRecordDTO convertToHillRecordDTO(Competition competition,SkiJumper skiJumper, BigDecimal distance) {
        HillRecordDTO hillRecordDTO = new HillRecordDTO();
        hillRecordDTO.setHillRecord(distance);
        hillRecordDTO.setCompetition(competition);
        hillRecordDTO.setSkiJumper(skiJumper);
        return hillRecordDTO;
    }


    @Override
    public List<HillVersion> findAll() {
        return hillVersionRepository.findAll();
    }

    @Override
    public Optional<HillVersion> findById(int id) {
        return hillVersionRepository.findById(id);
    }

    @Override
    public HillVersion save(Object obj) {
        return hillVersionRepository.save((HillVersion) obj);
    }

    @Override
    public void deleteById(int id) {
        hillVersionRepository.deleteById(id);
    }
}
