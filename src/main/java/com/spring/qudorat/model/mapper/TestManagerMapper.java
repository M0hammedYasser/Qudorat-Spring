package com.spring.qudorat.model.mapper;

import com.spring.qudorat.model.dto.TestManagerResponse;
import com.spring.qudorat.model.entity.TestManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestManagerMapper {

    public TestManagerResponse map(TestManager testManager) {
        return TestManagerResponse.builder()
                .id(testManager.getId())
                .name(testManager.getName())
                .price(testManager.getPrice())
                .build();
    }

    public List<TestManagerResponse> map(List<TestManager> testManagers) {
        List<TestManagerResponse> testManagerResponses = new ArrayList<>();
        for (TestManager testManager : testManagers)
            testManagerResponses.add(map(testManager));
        return testManagerResponses;
    }
}
