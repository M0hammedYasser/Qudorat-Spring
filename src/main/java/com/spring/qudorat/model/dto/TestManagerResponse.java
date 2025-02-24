package com.spring.qudorat.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestManagerResponse {

    private int id;
    private String name;
    private double price;
}
