package com.spring.qudorat.service;

import com.spring.qudorat.model.dto.TestResponse;
import com.spring.qudorat.model.entity.Test;
import com.spring.qudorat.model.mapper.TestMapper;
import com.spring.qudorat.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository repository;
    private final TestMapper mapper;

    public List<TestResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public TestResponse findById(int id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new RuntimeException("Test not found")));
    }

    public TestResponse save(Test test) {
        return mapper.map(repository.save(test));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
