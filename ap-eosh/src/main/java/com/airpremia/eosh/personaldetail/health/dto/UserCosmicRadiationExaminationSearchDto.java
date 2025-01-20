package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationRequest;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCosmicRadiationExaminationSearchDto extends UserExaminationSearchDto {
    private Long userSeq;
    private String userId;
    private String empNo;
    private String empNm;
    private String deptNm;
    private LocalDate birthYmd;
    private String standardYyyy;
    private ExaminationStatusEnum examinationStatusEnum;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    private LocalDate examinationDt;
    private String hemoglobinComment;
    private String whiteBloodCellComment;
    private String plateletComment;
    private String diagnosisOpinionComment;
    private LocalDate leaveOfAbsenceDt;
    private LocalDate returnToWorkDt;
    private String reexaminationComment;
    private String multipleFileUuid;

    public UserCosmicRadiationExaminationSearchDto(UserCosmicRadiationExaminationRequest req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.empNo = req.getEmpNo();
        this.empNm = req.getEmpNm();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
        this.examinationStatusEnum = req.getExaminationStatusEnum();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.examinationDt = req.getExaminationDt();
        this.hemoglobinComment = req.getHemoglobinComment();
        this.whiteBloodCellComment = req.getWhiteBloodCellComment();
        this.plateletComment = req.getPlateletComment();
        this.diagnosisOpinionComment = req.getDiagnosisOpinionComment();
    }
}

