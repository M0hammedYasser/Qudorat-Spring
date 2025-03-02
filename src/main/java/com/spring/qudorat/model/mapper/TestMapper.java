package com.spring.qudorat.model.mapper;

import com.spring.qudorat.model.dto.TestResponse;
import com.spring.qudorat.model.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestMapper {

    private final ProjectMapper projectMapper;
    private final TestManagerMapper testManagerMapper;
    private final SieveAnalysisMapper sieveAnalysisMapper;

    public TestResponse map(Test test) {
        return TestResponse.builder()
                .id(test.getId())
                .price(test.getPrice())
                .isPaid(test.isPaid())
                .date(test.getDate())
                .project(projectMapper.map(test.getProject()))
                .testManager(testManagerMapper.map(test.getTestManager()))
                .sieveAnalyses(sieveAnalysisMapper.map(test.getSieveAnalyses()))
                .build();
    }

    public List<TestResponse> map(List<Test> tests) {
        List<TestResponse> responses = new ArrayList<>();
        for (Test test : tests)
            responses.add(map(test));
        return responses;
    }
}
