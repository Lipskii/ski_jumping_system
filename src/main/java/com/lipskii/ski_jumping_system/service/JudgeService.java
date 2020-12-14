package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.JudgeRepository;
import com.lipskii.ski_jumping_system.entity.Judge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JudgeService implements ServiceInterface {

    private final JudgeRepository judgeRepository;

    @Autowired
    public JudgeService(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    @Override
    public List<Judge> findAll() {
        return judgeRepository.findAll();
    }

    @Override
    public Optional<Judge> findById(int id) {
        return judgeRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        judgeRepository.save((Judge) obj);
    }

    @Override
    public void deleteById(int id) {
        judgeRepository.deleteById(id);
    }
}
