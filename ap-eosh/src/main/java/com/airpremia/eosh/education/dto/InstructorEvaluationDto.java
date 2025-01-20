package com.airpremia.eosh.education.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.controller.InstructorEvaluationRequest;
import com.airpremia.eosh.education.controller.InstructorEvaluationResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InstructorEvaluationDto {

    private Long instructorEvaluationSeq;
    private Long educationAttendUserSeq;
    private Long educationSeq;
    private Long educationInstructorSeq;
    private String oneDepthItemCode;
    private String twoDepthQuestionCode;
    private int score;
    private String remark;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public InstructorEvaluationDto(InstructorEvaluationRequest req) {
        this.instructorEvaluationSeq = req.getInstructorEvaluationSeq();
        this.educationAttendUserSeq = req.getEducationAttendUserSeq();
        this.educationInstructorSeq = req.getEducationInstructorSeq();
        this.educationSeq = req.getEducationSeq();
        this.oneDepthItemCode = req.getOneDepthItemCode();
        this.twoDepthQuestionCode = req.getTwoDepthQuestionCode();
        this.score = req.getScore();
        this.remark = req.getRemark();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

    public InstructorEvaluationResponse convertInstructorEvaluationResponse() {
        InstructorEvaluationResponse data = new InstructorEvaluationResponse();
        data.setInstructorEvaluationSeq(this.instructorEvaluationSeq);
        data.setEducationAttendUserSeq(this.educationAttendUserSeq);
        data.setEducationSeq(this.educationSeq);
        data.setEducationInstructorSeq(this.educationInstructorSeq);
        data.setOneDepthItemCode(this.oneDepthItemCode);
        data.setTwoDepthQuestionCode(this.twoDepthQuestionCode);
        data.setScore(this.score);
        data.setRemark(this.remark);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }

    public InstructorEvaluationDto(Long educationSeq, Long educationAttendUserSeq, InstructorEvaluationRequest req) {
        this.instructorEvaluationSeq = req.getInstructorEvaluationSeq();
        this.educationAttendUserSeq = educationAttendUserSeq;
        this.educationInstructorSeq = req.getEducationInstructorSeq();
        this.educationSeq = educationSeq;
        this.oneDepthItemCode = req.getOneDepthItemCode();
        this.twoDepthQuestionCode = req.getTwoDepthQuestionCode();
        this.score = req.getScore();
        this.remark = req.getRemark();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }
}

