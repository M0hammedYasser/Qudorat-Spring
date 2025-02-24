package com.spring.qudorat.model.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestResponse {


    private int id;

    private float price;

    private LocalDate date;

    private ProjectResponse project;

    private TestManagerResponse testManager;
}
