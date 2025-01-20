package com.airpremia.eosh.audit.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.audit.controller.AuditRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditDto {

    private Long auditSeq;
    private Integer standardYyyy;
    private Integer standardMonth;
    private String processStrategyCode;
    private String processResult;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public AuditDto(AuditRequest req) {
        this.auditSeq = req.getAuditSeq();
        this.standardYyyy = req.getStandardYyyy();
        this.standardMonth = req.getStandardMonth();
        this.processStrategyCode = req.getProcessStrategyCode();
        this.processResult = req.getProcessResult();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

}


