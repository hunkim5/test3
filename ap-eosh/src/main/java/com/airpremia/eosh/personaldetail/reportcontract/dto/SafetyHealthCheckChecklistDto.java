package com.airpremia.eosh.personaldetail.reportcontract.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.reportcontract.controller.request.SafetyHealthCheckChecklistRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SafetyHealthCheckChecklistDto {

    private Long safetyHealthCheckChecklistSeq;
    private Long contractSeq;
    private String checklistCode;
    private int score;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public SafetyHealthCheckChecklistDto(SafetyHealthCheckChecklistRequest req) {
        this.safetyHealthCheckChecklistSeq = req.getSafetyHealthCheckChecklistSeq();
        this.contractSeq = req.getContractSeq();
        this.checklistCode = req.getChecklistCode();
        this.score = req.getScore();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

}
