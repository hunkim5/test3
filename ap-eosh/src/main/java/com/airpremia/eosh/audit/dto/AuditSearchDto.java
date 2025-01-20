package com.airpremia.eosh.audit.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.audit.controller.AuditSearchRequest;
import com.airpremia.eosh.audit.enums.StatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class AuditSearchDto {

    private Long auditSeq;
    private Integer standardYyyy;
    private Integer standardMonth;
    private String processStrategyCode;
    private String inspectorName;
    private StatusEnum statusEnum;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public AuditSearchDto(AuditSearchRequest req) {
        this.auditSeq = req.getAuditSeq();
        this.standardYyyy = req.getStandardYyyy();
        this.standardMonth = req.getStandardMonth();
        this.processStrategyCode = req.getProcessStrategyCode();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.updateUserId = req.getUpdateUserId();
        this.inspectorName = req.getInspectorName();
        this.statusEnum = req.getStatusEnum();
    }

}
