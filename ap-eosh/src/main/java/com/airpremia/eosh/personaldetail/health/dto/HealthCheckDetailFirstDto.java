package com.airpremia.eosh.personaldetail.health.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class HealthCheckDetailFirstDto {
    private Long userSeq;
    private String standardYyyy;
    private String userId;
    private String empNm;
    private String empNo;
    private String deptNm;
    private String oralExamBoolCode;
    private String stomachCancerBoolCode;
    private String breastCancerBoolCode;
    private String colonCancerBoolCode;
    private String normalExaminationCode;
    private String cervicalCancerBoolCode;
    private String specialExamComment;
    private String examinationResultContent;
    private String externalExaminationRecordContent;
    private String multipleFileUuid;
    private int averageScore;
}
