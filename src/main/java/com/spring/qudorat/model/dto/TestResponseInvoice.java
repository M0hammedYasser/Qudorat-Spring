package com.spring.qudorat.model.dto;

import com.spring.qudorat.model.entity.TestManager;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestResponseInvoice {

    private int id;

    private float price;

    private LocalDate date;

    private TestManager testManager;

}
