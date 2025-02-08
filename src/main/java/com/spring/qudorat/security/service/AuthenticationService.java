package com.spring.qudorat.security.service;

import com.spring.qudorat.exception.exceptions.RecordNotFountException;
import com.spring.qudorat.security.model.dto.AuthenticationRequest;
import com.spring.qudorat.security.model.dto.AuthenticationResponse;
import com.spring.qudorat.security.model.entity.AppUser;
import com.spring.qudorat.security.repository.UserRepository;
import com.spring.qudorat.security.jwt.JwtServices;
import com.spring.qudorat.security.model.AppUserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final JwtServices jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        AppUser user = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RecordNotFountException("اسم المستخدم غير صحيح"));
        if (user.getIsActive() == 0)
            throw new RecordNotFountException("هذا المستخدم غير مفعل برجاء مراجعة مسئول البرنامج");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new RecordNotFountException("الرقم السري غير صحيح");
        }


        var jwtToken = jwtService.generateToken(new AppUserDetail(user));

        return AuthenticationResponse.builder()
                .id(user.getId())
                .Token(jwtToken)
                .build();
    }
}