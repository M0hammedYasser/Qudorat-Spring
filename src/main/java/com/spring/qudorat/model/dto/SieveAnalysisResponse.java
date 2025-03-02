package com.spring.qudorat.model.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SieveAnalysisResponse {

    private Integer id;
    private int totalWeigh;
    private String status;
    private boolean isSuccess;
    private String projectName;
    private String testName;


    private double massRetainedA;
    private double massRetainedB;
    private double massRetainedC;
    private double massRetainedD;
    private double massRetainedE;
    private double massRetainedF;
    private double massRetainedG;
    private double massRetainedH;

    private double rMassRetainedA;
    private double rMassRetainedB;
    private double rMassRetainedC;
    private double rMassRetainedD;
    private double rMassRetainedE;
    private double rMassRetainedF;
    private double rMassRetainedG;
    private double rMassRetainedH;

    private double retainedA;
    private double retainedB;
    private double retainedC;
    private double retainedD;
    private double retainedE;
    private double retainedF;
    private double retainedG;
    private double retainedH;

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

}
