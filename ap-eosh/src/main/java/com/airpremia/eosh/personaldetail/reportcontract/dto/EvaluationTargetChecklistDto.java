package com.airpremia.eosh.personaldetail.reportcontract.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.reportcontract.controller.request.EvaluationTargetChecklistRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EvaluationTargetChecklistDto {

    private Long evaluationTargetChecklistSeq;
    private Long contractSeq;
    private String checklistCode;
    private int checklistResult;
    private String remark;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public EvaluationTargetChecklistDto(EvaluationTargetChecklistRequest req) {
        this.evaluationTargetChecklistSeq = req.getEvaluationTargetChecklistSeq();
        this.contractSeq = req.getContractSeq();
        this.checklistCode = req.getChecklistCode();
        this.checklistResult = req.getChecklistResult();
        this.remark = req.getRemark();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }
}

