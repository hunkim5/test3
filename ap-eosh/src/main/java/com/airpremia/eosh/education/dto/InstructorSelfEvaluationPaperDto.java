package com.airpremia.eosh.education.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.controller.InstructorSelfEvaluationPaperRequest;
import com.airpremia.eosh.education.controller.InstructorSelfEvaluationPaperResponse;
import com.airpremia.eosh.education.enums.EvaluationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InstructorSelfEvaluationPaperDto {

    private Long instructorSelfEvaluationSeq;
    private Long educationSeq;
    private Long educationInstructorSeq;
    private String divisionCode;
    private String checklistCode;
    private EvaluationEnum evaluationEnum;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public InstructorSelfEvaluationPaperDto(InstructorSelfEvaluationPaperRequest req) {
        this.instructorSelfEvaluationSeq = req.getInstructorSelfEvaluationSeq();
        this.educationSeq = req.getEducationSeq();
        this.educationInstructorSeq = req.getEducationInstructorSeq();
        this.divisionCode = req.getDivisionCode();
        this.checklistCode = req.getChecklistCode();
        this.evaluationEnum = req.getEvaluationEnum();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

    public InstructorSelfEvaluationPaperDto(Long educationSeq, Long educationInstructorSeq, InstructorSelfEvaluationPaperRequest req) {
        this.instructorSelfEvaluationSeq = req.getInstructorSelfEvaluationSeq();
        this.educationSeq = educationSeq;
        this.educationInstructorSeq = educationInstructorSeq;
        this.divisionCode = req.getDivisionCode();
        this.checklistCode = req.getChecklistCode();
        this.evaluationEnum = req.getEvaluationEnum();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

    public InstructorSelfEvaluationPaperResponse convertInstructorSelfEvaluationPaperResponse() {
        InstructorSelfEvaluationPaperResponse data = new InstructorSelfEvaluationPaperResponse();
        data.setInstructorSelfEvaluationSeq(this.instructorSelfEvaluationSeq);
        data.setEducationSeq(this.educationSeq);
        data.setEducationInstructorSeq(this.educationInstructorSeq);
        data.setDivisionCode(this.divisionCode);
        data.setChecklistCode(this.checklistCode);
        data.setEvaluationEnum(this.evaluationEnum);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }

}

