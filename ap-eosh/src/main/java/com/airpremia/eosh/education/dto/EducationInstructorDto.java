package com.airpremia.eosh.education.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.education.controller.EducationInstructorRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationInstructorDto {

    private Long educationInstructorSeq;
    private Long instructorSeq;
    private Long educationSeq;
    private boolean externalBool;
    private String userId;
    private String userName;
    private String departmentId;
    private String departmentName;
    private LocalDate appointDt;
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

    private InstructorSelfEvaluationPaperDto instructorSelfEvaluationPaperDto;

    private String lectureName;
    private String remark;
    private LocalDateTime educationDtm;
    private String postName;

    public EducationInstructorDto(EducationInstructorRequest req) {
        if (req.getInstructorSelfEvaluationPaperRequest() != null) {
            this.instructorSelfEvaluationPaperDto =
                req.getInstructorSelfEvaluationPaperRequest().convertInstructorSelfEvaluationPaper();
        }
        this.educationInstructorSeq = req.getEducationInstructorSeq();
        this.instructorSeq = req.getInstructorSeq();
        this.educationSeq = req.getEducationSeq();
        this.externalBool = req.isExternalBool();
        this.userId = req.getUserId();
        this.userName = req.getUserName();
        this.departmentId = req.getDepartmentId();
        this.departmentName = req.getDepartmentName();
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
        this.lectureName = req.getLectureName();
        this.educationDtm = req.getEducationDtm();
        this.remark = req.getRemark();
    }

}

