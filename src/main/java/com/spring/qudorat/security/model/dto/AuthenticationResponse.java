package com.spring.qudorat.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class AuthenticationResponse {

    private int id;
    private String Token;

}
