package com.spring.qudorat.security.service;

import com.spring.qudorat.security.model.entity.AppUser;
import com.spring.qudorat.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    public AppUser findById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    public AppUser save(AppUser user) {
        user.setIsActive(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void update(AppUser user) {
        userRepository.save(user);
    }


    public void activeAccount(int id) {
        AppUser user = findById(id);
        user.setIsActive(1);
        update(user);

    }

    public void unActive(int id) {
        AppUser user = findById(id);
        user.setIsActive(0);
        update(user);

    }
}
