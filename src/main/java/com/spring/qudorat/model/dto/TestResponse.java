package com.spring.qudorat.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestResponse {


    private int id;

    private float price;

    private boolean isPaid;

    private LocalDate date;

    private ProjectResponse project;

    private TestManagerResponse testManager;

    private List<SieveAnalysisResponse> sieveAnalyses;
}
