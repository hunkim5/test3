package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserCosmicRadiationExaminationRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "사용자 생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사번")
    private String empNo;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "검진 상태 ENUM")
    private ExaminationStatusEnum examinationStatusEnum;
    @Schema(description = "근무 구분 ENUM")
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    @Schema(description = "검진 날짜")
    private LocalDate examinationDt;
    @Schema(description = "'혈색소' comment")
    private String hemoglobinComment;
    @Schema(description = "'백혈구' comment")
    private String whiteBloodCellComment;
    @Schema(description = "'혈소판' comment")
    private String plateletComment;
    @Schema(description = "판정 의견 comment")
    private String diagnosisOpinionComment;
    @Schema(description = "'휴직' 날짜")
    private LocalDate leaveOfAbsenceDt;
    @Schema(description = "'복직' 날짜")
    private LocalDate returnToWorkDt;
    @Schema(description = "'재검' comment")
    private String reexaminationComment;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "1차 특이사항")
    private String firstSpecialNote;
    @Schema(description = "재검 특이사항")
    private String reexaminationSpecialNote;


    public UserCosmicRadiationExaminationDto convertUserCosmicRadiationExaminationDto() {
        UserCosmicRadiationExaminationDto data = new UserCosmicRadiationExaminationDto();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setEmpNm(this.empNm);
        data.setDeptNm(this.deptNm);
        data.setBirthYmd(this.birthYmd);
        data.setEmpNo(this.empNo);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
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

    public UserCosmicRadiationExaminationResponse convertUserCosmicRadiationExaminationResponse() {
        UserCosmicRadiationExaminationResponse data = new UserCosmicRadiationExaminationResponse();
        data.setUserSeq(this.userSeq);
        data.setUserId(this.userId);
        data.setEmpNm(this.empNm);
        data.setDeptNm(this.deptNm);
        data.setBirthYmd(this.birthYmd);
        data.setEmpNo(this.empNo);
        data.setStandardYyyy(this.standardYyyy);
        data.setExaminationStatusEnum(this.examinationStatusEnum);
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

