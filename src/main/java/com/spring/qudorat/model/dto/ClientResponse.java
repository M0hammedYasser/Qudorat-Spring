package com.spring.qudorat.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClientResponse {

    private int id;

    private String name;

    private String phone;

    private String email;

    private String address;
}
