package com.airpremia.eosh.education.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.education.dto.EducationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationResponse {
    @Schema(description = "교육 시퀀스")
    private Long educationSeq;
    @Schema(description = "교육 분류 코드")
    private String educationClassificationCode;
    @Schema(description = "교육 날짜")
    private LocalDate educationDt;
    @Schema(description = "주관 코드")
    private String inChargeCode;
    @Schema(description = "교육 자료")
    private String educationData;
    @Schema(description = "교육 내용")
    private String educationContent;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "삭제 여부")
    private boolean deleteBool;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;
    @Schema(description = "과정설문서 개수")
    private int courseSurveyCnt;
    @Schema(description = "강사평가서 개수")
    private int instructorEvaluationCnt;
    @Schema(description = "교육강사")
    private List<EducationInstructorResponse> educationInstructorResponses;
    @Schema(description = "교육참석 사용자")
    private List<EducationAttendUserResponse> educationAttendUserResponses;

    public EducationResponse(EducationDto req) {
        if (req.getEducationInstructorDtos() != null) {
            this.educationInstructorResponses =
                req.getEducationInstructorDtos().stream().map(EducationInstructorResponse::new).toList();
        }
        if (req.getEducationAttendUserDtos() != null) {
            this.educationAttendUserResponses =
                req.getEducationAttendUserDtos().stream().map(EducationAttendUserResponse::new).toList();
        }
        this.educationSeq = req.getEducationSeq();
        this.educationClassificationCode = req.getEducationClassificationCode();
        this.educationDt = req.getEducationDt();
        this.inChargeCode = req.getInChargeCode();
        this.educationData = req.getEducationData();
        this.educationContent = req.getEducationContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.deleteBool = req.isDeleteBool();
        this.deleteUserId = req.getDeleteUserId();
        this.deleteDtm = req.getDeleteDtm();
        this.deleteIp = req.getDeleteIp();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
        this.courseSurveyCnt = req.getCourseSurveyCnt();
        this.instructorEvaluationCnt = req.getInstructorEvaluationCnt();
    }
}

