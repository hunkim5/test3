package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class HealthCheckDetailSecondDto {
    private String userId;
    private String standardYyyy;
    private String riskGroupClassificationCode;
    private String hemoglobinComment;
    private String whiteBloodCellComment;
    private String plateletComment;
    private LocalDate examinationDt;
    private String reexaminationComment;
    private String firstSpecialNote;
    private LocalDate healthDt;
    private String symptomsContent;
    private String etcContent;
    private String useProductContent;
    private String useQuantityComment;
    private LocalDate health_dt;
}
