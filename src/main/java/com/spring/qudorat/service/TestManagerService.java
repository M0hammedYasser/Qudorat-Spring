package com.spring.qudorat.service;

import com.spring.qudorat.model.dto.TestManagerResponse;
import com.spring.qudorat.model.entity.TestManager;
import com.spring.qudorat.model.mapper.TestManagerMapper;
import com.spring.qudorat.repository.TestManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestManagerService {

    private final TestManagerRepository repository;
    private final TestManagerMapper mapper;

    public List<TestManagerResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public TestManagerResponse findById(int id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new RuntimeException("Test not found")));
    }

    public TestManagerResponse save(TestManager testManager) {
        return mapper.map(repository.save(testManager));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
