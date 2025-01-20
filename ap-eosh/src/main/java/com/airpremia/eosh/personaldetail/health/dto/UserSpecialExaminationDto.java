package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.controller.UserSpecialExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserSpecialExaminationResponse;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSpecialExaminationDto extends UserExaminationPageDto {
    private Long userSeq;
    private String empNo;
    private String empNm;
    private String deptNm;
    private String userId;
    private String standardYyyy;
    private LocalDate birthYmd;
    private ExaminationStatusEnum examinationStatusEnum;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    private LocalDate examinationDt;
    private String specialExamComment;
    private LocalDate specialExamDt;
    private String examinationResultContent;
    private String externalExaminationRecordContent;
    private String multipleFileUuid;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public UserSpecialExaminationDto(UserSpecialExaminationRequest req) {
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
        this.specialExamComment = req.getSpecialExamComment();
        this.specialExamDt = req.getSpecialExamDt();
        this.examinationResultContent = req.getExaminationResultContent();
        this.externalExaminationRecordContent = req.getExternalExaminationRecordContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
    }

    public UserSpecialExaminationResponse convertUserSpecialExaminationResponse() {
        UserSpecialExaminationResponse data = new UserSpecialExaminationResponse();
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
        data.setSpecialExamComment(this.specialExamComment);
        data.setSpecialExamDt(this.specialExamDt);
        data.setExaminationResultContent(this.examinationResultContent);
        data.setExternalExaminationRecordContent(this.externalExaminationRecordContent);
        data.setMultipleFileUuid(this.multipleFileUuid);
        return data;
    }

    public void mergeInfo(UserSpecialExaminationDto dto, HrEmpDto empDto) {
        dto.setEmpNm(empDto.getEmpNm());
        dto.setDeptNm(empDto.getDeptNm());
        dto.setBirthYmd(empDto.getBirthYmd());
        dto.setUserJobClassificationClassificationEnum(empDto.getUserJobClassificationClassificationEnum());
    }
}

