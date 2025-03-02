package com.spring.qudorat.service;

import com.spring.qudorat.model.dto.SieveAnalysisResponse;
import com.spring.qudorat.model.entity.SieveAnalysis;
import com.spring.qudorat.model.mapper.SieveAnalysisMapper;
import com.spring.qudorat.repository.SieveAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SieveAnalysisService {

    private final SieveAnalysisRepository repository;
    private final SieveAnalysisMapper mapper;


    public List<SieveAnalysisResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public SieveAnalysisResponse findById(int id) {
        return mapper.map(repository.findById(id).orElse(null));
    }

    public SieveAnalysis save(SieveAnalysis sieveAnalysis) {
        return repository.save(sieveAnalysis);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }





}
