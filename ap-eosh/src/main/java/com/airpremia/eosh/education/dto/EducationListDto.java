package com.airpremia.eosh.education.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationListDto {

    private Long educationSeq;
    private String educationClassificationCode;
    private LocalDate educationDt;
    private String inChargeCode;
    private String educationData;
    private String educationContent;
    private String multipleFileUuid;
    private boolean deleteBool;
    private String deleteUserId;
    private LocalDateTime deleteDtm;
    private String deleteIp;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
    private int courseSurveyCnt;
    private int instructorEvaluationCnt;
    private List<EducationInstructorUserNamesDto> instructorUserNames;

}

