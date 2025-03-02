package com.spring.qudorat.model.mapper;

import com.spring.qudorat.model.dto.ProjectInvoiceResponse;
import com.spring.qudorat.model.dto.ProjectResponse;
import com.spring.qudorat.model.dto.TestResponseInvoice;
import com.spring.qudorat.model.entity.Project;
import com.spring.qudorat.model.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final ClientMapper clientMapper;
//    private final TestMapper  testMapper;

    public ProjectResponse map(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .client(clientMapper.map(project.getClient()))
                .numberOfTests(project.getTests().size())
                .build();
    }

    public ProjectInvoiceResponse mapInvoice(Project project) {
        return ProjectInvoiceResponse.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .client(clientMapper.map(project.getClient()))
                .tests(mapTest(project.getTests()))
                .build();
    }

    public TestResponseInvoice mapTest(Test test){
        return TestResponseInvoice.builder()
                .id(test.getId())
                .date(test.getDate())
                .price(test.getPrice())
                .testManager(test.getTestManager())
                .build();
    }

    public List<TestResponseInvoice> mapTest(List<Test> tests){
        List<TestResponseInvoice> testResponseInvoices = new ArrayList<>();
        for (Test test : tests) {
            testResponseInvoices.add(mapTest(test));
        }
        return testResponseInvoices;
    }

    public List<ProjectResponse> map(List<Project> projects) {
        List<ProjectResponse> projectResponses = new ArrayList<>();
        for (Project project : projects)
            projectResponses.add(map(project));
        return projectResponses;
    }
}
