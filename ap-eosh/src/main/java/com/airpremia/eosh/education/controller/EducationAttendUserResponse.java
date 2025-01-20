package com.airpremia.eosh.education.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.dto.EducationAttendUserDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationAttendUserResponse {

    @Schema(description = "교육 참석 사용자 시퀀스")
    private Long educationAttendUserSeq;
    @Schema(description = "교육 시퀀스")
    private Long educationSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 이름")
    private String userName;
    @Schema(description = "부서 아이디")
    private String departmentId;
    @Schema(description = "부서 이름")
    private String departmentName;
    @Schema(description = "서명 여부")
    private boolean signatureBool;
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

    @Schema(description = "과정 설문지")
    private CourseSurveyResponse courseSurveyResponse;
    @Schema(description = "강사 평가서")
    private InstructorEvaluationResponse instructorEvaluationResponse;

    @Schema(description = "직책")
    private String postName;

    public EducationAttendUserResponse(EducationAttendUserDto req) {
        if (req.getCourseSurveyDto() != null) {
            this.courseSurveyResponse = req.getCourseSurveyDto().convertCourseSurveyResponse();
        }
        if (req.getInstructorEvaluationDto() != null) {
            this.instructorEvaluationResponse = req.getInstructorEvaluationDto().convertInstructorEvaluationResponse();
        }

        this.educationAttendUserSeq = req.getEducationAttendUserSeq();
        this.educationSeq = req.getEducationSeq();
        this.userId = req.getUserId();
        this.userName = req.getUserName();
        this.departmentId = req.getDepartmentId();
        this.departmentName = req.getDepartmentName();
        this.signatureBool = req.isSignatureBool();
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
        this.postName = req.getPostName();
    }
}

