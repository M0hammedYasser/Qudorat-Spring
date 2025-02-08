package com.spring.qudorat.security.controller;

import com.spring.qudorat.security.model.entity.Authority;
import com.spring.qudorat.security.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authority")
@RequiredArgsConstructor
public class AuthorityController {

    private final AuthorityService authorityService;

    @GetMapping
    public List<Authority> getAuthority() {
        return authorityService.findAll();
    }
}
