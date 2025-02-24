package com.spring.qudorat.model.mapper;

import com.spring.qudorat.model.dto.ProjectResponse;
import com.spring.qudorat.model.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final ClientMapper clientMapper;

    public ProjectResponse map(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .client(clientMapper.map(project.getClient()))
                .build();
    }
    public List<ProjectResponse> map(List<Project> projects) {
        List<ProjectResponse> projectResponses = new ArrayList<>();
        for (Project project : projects)
            projectResponses.add(map(project));
        return projectResponses;
    }
}
