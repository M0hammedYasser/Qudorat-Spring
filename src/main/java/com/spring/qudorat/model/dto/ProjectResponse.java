package com.spring.qudorat.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProjectResponse {

    private int id;
    private String projectName;

    private ClientResponse client;


}
