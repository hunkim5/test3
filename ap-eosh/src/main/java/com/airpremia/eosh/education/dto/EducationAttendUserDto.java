package com.airpremia.eosh.education.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.controller.EducationAttendUserRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationAttendUserDto {

    private Long educationAttendUserSeq;
    private Long educationSeq;
    private String userId;
    private String userName;
    private String departmentId;
    private String departmentName;
    private boolean signatureBool;
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

    private CourseSurveyDto courseSurveyDto;
    private InstructorEvaluationDto instructorEvaluationDto;

    private String postName;

    public EducationAttendUserDto(EducationAttendUserRequest req) {
        if (req.getCourseSurveyRequest() != null) {
            this.courseSurveyDto = req.getCourseSurveyRequest().convertCourseSurveyDto();
        }
        if (req.getInstructorEvaluationRequest() != null) {
            this.instructorEvaluationDto = req.getInstructorEvaluationRequest().convertInstructorEvaluationDto();
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
    }

}

