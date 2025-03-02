package com.spring.qudorat.model.mapper;

import com.spring.qudorat.model.dto.SieveAnalysisResponse;
import com.spring.qudorat.model.entity.SieveAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SieveAnalysisMapper {


    public SieveAnalysisResponse map(SieveAnalysis sieveAnalysis) {
        double a = sieveAnalysis.getMassRetainedA();
        double b = a + sieveAnalysis.getMassRetainedB();
        double c = b + sieveAnalysis.getMassRetainedC();
        double d = c + sieveAnalysis.getMassRetainedD();
        double e = d + sieveAnalysis.getMassRetainedE();
        double f = e + sieveAnalysis.getMassRetainedF();
        double g = f + sieveAnalysis.getMassRetainedG();
        double h = g + sieveAnalysis.getMassRetainedH();
        boolean bool = sieveAnalysis.getMassRetainedH() != 0;
        String status = bool ? "Completed" : "Pending";
        boolean isSuccess =
                (100 - a >= sieveAnalysis.getCvcMinA() && 100 - a <= sieveAnalysis.getCvcMaxA()) &&
                        (100 - b >= sieveAnalysis.getCvcMinB() && 100-a <= sieveAnalysis.getCvcMaxB()) &&
                        (100 - c >= sieveAnalysis.getCvcMinC() && 100-b <= sieveAnalysis.getCvcMaxC()) &&
                        (100 - d >= sieveAnalysis.getCvcMinD() && 100-c <= sieveAnalysis.getCvcMaxD()) &&
                        (100 - e >= sieveAnalysis.getCvcMinE() && 100-d <= sieveAnalysis.getCvcMaxE()) &&
                        (100 - f >= sieveAnalysis.getCvcMinF() && 100-e <= sieveAnalysis.getCvcMaxF()) &&
                        (100 - g >= sieveAnalysis.getCvcMinG() && 100-f <= sieveAnalysis.getCvcMaxG()) &&
                        (100 - h >= sieveAnalysis.getCvcMinH() && 100-g <= sieveAnalysis.getCvcMaxH());
        return SieveAnalysisResponse.builder()
                .id(sieveAnalysis.getId())
                .status(status)
                .isSuccess(isSuccess)
                .projectName(sieveAnalysis.getTest().getProject().getProjectName())
                .t(sieveAnalysis.getTest().getTestManager().getName())
                .totalWeigh(sieveAnalysis.getTotalWeigh())
                .massRetainedA(sieveAnalysis.getMassRetainedA())
                .massRetainedB(sieveAnalysis.getMassRetainedB())
                .massRetainedC(sieveAnalysis.getMassRetainedC())
                .massRetainedD(sieveAnalysis.getMassRetainedD())
                .massRetainedE(sieveAnalysis.getMassRetainedE())
                .massRetainedF(sieveAnalysis.getMassRetainedF())
                .massRetainedG(sieveAnalysis.getMassRetainedG())
                .massRetainedH(sieveAnalysis.getMassRetainedH())
                .rMassRetainedA(a)
                .rMassRetainedB(b)
                .rMassRetainedC(c)
                .rMassRetainedD(d)
                .rMassRetainedE(e)
                .rMassRetainedF(f)
                .rMassRetainedG(g)
                .rMassRetainedH(h)
                .retainedA( a / sieveAnalysis.getTotalWeigh() * 100)
                .retainedB( b / sieveAnalysis.getTotalWeigh() * 100)
                .retainedC( c / sieveAnalysis.getTotalWeigh() * 100)
                .retainedD( d / sieveAnalysis.getTotalWeigh() * 100)
                .retainedE( e / sieveAnalysis.getTotalWeigh() * 100)
                .retainedF( f / sieveAnalysis.getTotalWeigh() * 100)
                .retainedG( g / sieveAnalysis.getTotalWeigh() * 100)
                .retainedH( h / sieveAnalysis.getTotalWeigh() * 100)
                .cvcMinA(sieveAnalysis.getCvcMinA())
                .cvcMinB(sieveAnalysis.getCvcMinB())
                .cvcMinC(sieveAnalysis.getCvcMinC())
                .cvcMinD(sieveAnalysis.getCvcMinD())
                .cvcMinE(sieveAnalysis.getCvcMinE())
                .cvcMinF(sieveAnalysis.getCvcMinF())
                .cvcMinG(sieveAnalysis.getCvcMinG())
                .cvcMinH(sieveAnalysis.getCvcMinH())
                .cvcMaxA(sieveAnalysis.getCvcMaxA())
                .cvcMaxB(sieveAnalysis.getCvcMaxB())
                .cvcMaxC(sieveAnalysis.getCvcMaxC())
                .cvcMaxD(sieveAnalysis.getCvcMaxD())
                .cvcMaxE(sieveAnalysis.getCvcMaxE())
                .cvcMaxF(sieveAnalysis.getCvcMaxF())
                .cvcMaxG(sieveAnalysis.getCvcMaxG())
                .cvcMaxH(sieveAnalysis.getCvcMaxH())
                .build();
    }

    public List<SieveAnalysisResponse> map(List<SieveAnalysis> sieveAnalysis) {
        return sieveAnalysis.stream().map(this::map).collect(Collectors.toList());
    }
}
