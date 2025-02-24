package com.spring.qudorat.controller;

import com.spring.qudorat.model.dto.TestResponse;
import com.spring.qudorat.model.entity.Test;
import com.spring.qudorat.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @GetMapping
    public List<TestResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TestResponse findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public TestResponse insert(@RequestBody Test test) {
        return service.save(test);
    }

    @PutMapping("/{id}")
    public TestResponse update(@PathVariable int id, @RequestBody Test test) {
        test.setId(id);
        return service.save(test);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}
