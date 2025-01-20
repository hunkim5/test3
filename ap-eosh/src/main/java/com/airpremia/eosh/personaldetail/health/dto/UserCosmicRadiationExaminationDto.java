package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationResponse;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserCosmicRadiationExaminationDto {
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
    private String whiteBloodCellComment;
    private String plateletComment;
    private String diagnosisOpinionComment;
    private String hemoglobinComment;
    private String firstSpecialNote;
    private LocalDate leaveOfAbsenceDt;
    private LocalDate returnToWorkDt;
    private String reexaminationComment;
    private String reexaminationSpecialNote;
    private String multipleFileUuid;
    private String insertIp;
    private String insertUserId;
    private String updateIp;
    private String updateUserId;

    public UserCosmicRadiationExaminationDto(UserCosmicRadiationExaminationRequest req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.empNo = req.getEmpNo();
        this.empNm = req.getEmpNm();
        this.deptNm = req.getDeptNm();
        this.birthYmd = req.getBirthYmd();
        this.standardYyyy = req.getStandardYyyy();
        this.examinationStatusEnum = req.getExaminationStatusEnum();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.examinationDt = req.getExaminationDt();
        this.whiteBloodCellComment = req.getWhiteBloodCellComment();
        this.plateletComment = req.getPlateletComment();
        this.diagnosisOpinionComment = req.getDiagnosisOpinionComment();
        this.leaveOfAbsenceDt = req.getLeaveOfAbsenceDt();
        this.returnToWorkDt = req.getReturnToWorkDt();
        this.hemoglobinComment = req.getHemoglobinComment();
        this.firstSpecialNote = req.getFirstSpecialNote();
        this.reexaminationSpecialNote = req.getReexaminationSpecialNote();
        this.reexaminationComment = req.getReexaminationComment();
        this.multipleFileUuid = req.getMultipleFileUuid();
    }

    public UserCosmicRadiationExaminationResponse convertUserCosmicRadiationExaminationResponse() {
        UserCosmicRadiationExaminationResponse data = new UserCosmicRadiationExaminationResponse();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setEmpNo(this.empNo);
        data.setEmpNm(this.empNm);
        data.setDeptNm(this.deptNm);
        data.setBirthYmd(this.birthYmd);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
        data.setUserJobClassificationClassificationEnum(this.userJobClassificationClassificationEnum);
        data.setExaminationDt(this.examinationDt);
        data.setWhiteBloodCellComment(this.whiteBloodCellComment);
        data.setPlateletComment(this.plateletComment);
        data.setDiagnosisOpinionComment(this.diagnosisOpinionComment);
        data.setLeaveOfAbsenceDt(this.leaveOfAbsenceDt);
        data.setReturnToWorkDt(this.returnToWorkDt);
        data.setReexaminationComment(this.reexaminationComment);
        data.setMultipleFileUuid(this.multipleFileUuid);
        data.setFirstSpecialNote(this.firstSpecialNote);
        data.setReexaminationSpecialNote(this.reexaminationSpecialNote);
        data.setHemoglobinComment(this.hemoglobinComment);

        return data;
    }
}

