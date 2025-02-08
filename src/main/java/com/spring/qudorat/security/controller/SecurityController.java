package com.spring.qudorat.security.controller;

import com.spring.qudorat.security.model.dto.AuthenticationRequest;
import com.spring.qudorat.security.model.dto.AuthenticationResponse;
import com.spring.qudorat.security.model.entity.AppUser;
import com.spring.qudorat.security.service.AuthenticationService;
import com.spring.qudorat.security.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SecurityController {

    private final AuthenticationService authenticationService;
    private final UserServices userServices;

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws Exception {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        for (AppUser users : userServices.findAll()) {
            if (users.getUsername().equals(user.getUsername())) {
                throw new RuntimeException("This username ( " + user.getUsername() + " ) is exist");
            }
        }
        userServices.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/active")
    public ResponseEntity<?> active(@RequestParam int id) {
        userServices.activeAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/un-active")
    public ResponseEntity<?> nonActive(@RequestParam int id) {
        userServices.unActive(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

