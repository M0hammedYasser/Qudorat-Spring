package com.spring.qudorat.security.service;

import com.spring.qudorat.security.model.entity.Authority;
import com.spring.qudorat.security.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    public void insert(Authority authority){
        authorityRepository.save(authority);
    }

    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }
}
