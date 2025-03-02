package com.spring.qudorat.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private float price;

    private boolean isPaid;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    private Project project;

    @ManyToOne
    private TestManager testManager;

    @OneToMany(mappedBy = "test")
    private List<SieveAnalysis> sieveAnalyses;

}
