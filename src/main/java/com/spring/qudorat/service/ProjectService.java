package com.spring.qudorat.service;

import com.spring.qudorat.model.dto.ProjectInvoiceResponse;
import com.spring.qudorat.model.dto.ProjectResponse;
import com.spring.qudorat.model.dto.TestResponseInvoice;
import com.spring.qudorat.model.entity.Project;
import com.spring.qudorat.model.mapper.ProjectMapper;
import com.spring.qudorat.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapper mapper;

    public List<ProjectResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public ProjectInvoiceResponse findById(int id) {
        return mapper.mapInvoice(repository.findById(id).orElseThrow(() -> new RuntimeException("Project not found")));
    }

    public ProjectResponse save(Project project) {
        return mapper.map(repository.save(project));
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
