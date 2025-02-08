package com.spring.qudorat.security.controller;

import com.spring.qudorat.security.model.entity.AppUser;
import com.spring.qudorat.security.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServices services;

    @GetMapping
    public List<AppUser> findAll() {
        return services.findAll();
    }

    @GetMapping("/{id}")
    public AppUser findById(@PathVariable int id) {
        return services.findById(id);
    }

}