package com.airpremia.eosh.education.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.education.dto.EducationInstructorDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationInstructorResponse {

    @Schema(description = "교육강사 시퀀스")
    private Long educationInstructorSeq;
    @Schema(description = "강사 시퀀스")
    private Long instructorSeq;
    @Schema(description = "교육 시퀀스")
    private Long educationSeq;
    @Schema(description = "외부 여부")
    private boolean externalBool;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 이름")
    private String userName;
    @Schema(description = "부서 아이디")
    private String departmentId;
    @Schema(description = "부서 이름")
    private String departmentName;
    @Schema(description = "임명 날짜")
    private LocalDate appointDt;
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
    @Schema(description = "강사 자기 평가서")
    private InstructorSelfEvaluationPaperResponse instructorSelfEvaluationPaperResponse;
    @Schema(description = "강의명")
    private String lectureName;
    @Schema(description = "교육일시")
    private LocalDateTime educationDtm;
    @Schema(description = "비고")
    private String remark;
    @Schema(description = "직책")
    private String postName;

    public EducationInstructorResponse(EducationInstructorDto req) {
        if (req.getInstructorSelfEvaluationPaperDto() != null) {
            this.instructorSelfEvaluationPaperResponse =
                req.getInstructorSelfEvaluationPaperDto().convertInstructorSelfEvaluationPaperResponse();
        }
        this.educationInstructorSeq = req.getEducationInstructorSeq();
        this.instructorSeq = req.getInstructorSeq();
        this.educationSeq = req.getEducationSeq();
        this.externalBool = req.isExternalBool();
        this.userId = req.getUserId();
        this.userName = req.getUserName();
        this.departmentId = req.getDepartmentId();
        this.departmentName = req.getDepartmentName();
        this.educationDtm = req.getEducationDtm();
        this.lectureName = req.getLectureName();
        this.appointDt = req.getAppointDt();
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
        this.remark = req.getRemark();
        this.postName = req.getPostName();
    }
}

