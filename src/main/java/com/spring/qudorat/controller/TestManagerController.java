package com.spring.qudorat.controller;

import com.spring.qudorat.model.dto.TestManagerResponse;
import com.spring.qudorat.model.entity.TestManager;
import com.spring.qudorat.repository.TestManagerRepository;
import com.spring.qudorat.service.TestManagerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test-manager")
@RequiredArgsConstructor
public class TestManagerController {

    private final TestManagerService service;

    @GetMapping
    private List<TestManagerResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TestManagerResponse findById(@PathVariable int id){
        return service.findById(id);
    }

    @PostMapping
    public TestManagerResponse insert(@RequestBody TestManager testManager){
        return service.save(testManager);
    }

    @PutMapping("/{id}")
    public TestManagerResponse update(@RequestBody TestManager testManager , @PathVariable int id){
        testManager.setId(id);
        return service.save(testManager);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
         service.deleteById(id);
    }
}
