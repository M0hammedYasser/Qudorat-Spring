package com.spring.qudorat.controller;

import com.spring.qudorat.model.dto.ProjectResponse;
import com.spring.qudorat.model.entity.Project;
import com.spring.qudorat.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @GetMapping
    public List<ProjectResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProjectResponse findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public ProjectResponse insert(@RequestBody Project project) {
        return service.save(project);
    }

    @PutMapping("/{id}")
    public ProjectResponse update(@RequestBody Project project , @PathVariable int id) {
        project.setId(id);
        return service.save(project);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
