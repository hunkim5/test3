package com.airpremia.eosh.audit.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.audit.controller.AuditQuestionResultRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditResultDto {
    private Long auditChecklistQuestionResultSeq;
    private Long auditChecklistSeq;
    private String oneDepthQuestionCode;
    private String twoDepthQuestionCode;
    private String threeDepthQuestionCode;
    private Boolean practiceBool;
    private String remark;
    private Integer budget;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public AuditResultDto(AuditQuestionResultRequest req) {
        this.auditChecklistQuestionResultSeq = req.getAuditChecklistQuestionResultSeq();
        this.auditChecklistSeq = req.getAuditChecklistSeq();
        this.oneDepthQuestionCode = req.getOneDepthQuestionCode();
        this.twoDepthQuestionCode = req.getTwoDepthQuestionCode();
        this.threeDepthQuestionCode = req.getThreeDepthQuestionCode();
        this.practiceBool = req.getPracticeBool();
        this.budget = req.getBudget();
        this.remark = req.getRemark();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

}
