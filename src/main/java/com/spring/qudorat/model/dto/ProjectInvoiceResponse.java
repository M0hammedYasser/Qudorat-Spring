package com.spring.qudorat.model.dto;

import com.spring.qudorat.model.entity.Test;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProjectInvoiceResponse {

    private int id;
    private String projectName;

    private ClientResponse client;

    private List<TestResponseInvoice> tests;
}
