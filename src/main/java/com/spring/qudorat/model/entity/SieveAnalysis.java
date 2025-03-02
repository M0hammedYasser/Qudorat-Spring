package com.spring.qudorat.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class SieveAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int totalWeigh;

    private double massRetainedA;
    private double massRetainedB;
    private double massRetainedC;
    private double massRetainedD;
    private double massRetainedE;
    private double massRetainedF;
    private double massRetainedG;
    private double massRetainedH;

    private int cvcMinA;
    private int cvcMinB;
    private int cvcMinC;
    private int cvcMinD;
    private int cvcMinE;
    private int cvcMinF;
    private int cvcMinG;
    private int cvcMinH;

    private int cvcMaxA;
    private int cvcMaxB;
    private int cvcMaxC;
    private int cvcMaxD;
    private int cvcMaxE;
    private int cvcMaxF;
    private int cvcMaxG;
    private int cvcMaxH;

    @ManyToOne
    private Test test;



}
