package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.ResultRepository;
import com.lipskii.ski_jumping_system.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService implements ServiceInterface {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Optional<Result> findById(int id) {
        return resultRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        resultRepository.save((Result) obj);
    }

    @Override
    public void deleteById(int id) {
        resultRepository.deleteById(id);
    }
}
