package com.spring.qudorat.controller;

import com.spring.qudorat.model.dto.SieveAnalysisResponse;
import com.spring.qudorat.model.entity.SieveAnalysis;
import com.spring.qudorat.repository.SieveAnalysisRepository;
import com.spring.qudorat.service.SieveAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sieve-analysis")
@RequiredArgsConstructor
public class SieveAnalysisController {

    private final SieveAnalysisService service;

    @GetMapping
    public List<SieveAnalysisResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SieveAnalysisResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public SieveAnalysis save(@RequestBody SieveAnalysis sieveAnalysis) {
        return service.save(sieveAnalysis);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Integer id) {
        service.deleteById(id);
    }

}
