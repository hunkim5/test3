package com.airpremia.eosh.audit.controller;

import com.airpremia.eosh.audit.dto.AuditSearchDto;
import com.airpremia.eosh.audit.enums.StatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditSearchResponse {

    @Schema(description = "심사 시퀀스")
    private Long auditSeq;

    @Schema(description = "기준 년도")
    private Integer standardYyyy;

    @Schema(description = "기준 월")
    private Integer standardMonth;

    @Schema(description = "실행 전략 코드")
    private String processStrategyCode;

    @Schema(description = "실행 결과")
    private String processResult;

    @Schema(description = "점검자 이름")
    private String inspectorName;

    @Schema(description = "심사 설문 저장 상태 ENUM")
    private StatusEnum statusEnum;


    public AuditSearchResponse(AuditSearchDto req) {
        this.auditSeq = req.getAuditSeq();
        this.standardYyyy = req.getStandardYyyy();
        this.standardMonth = req.getStandardMonth();
        this.processStrategyCode = req.getProcessStrategyCode();
        this.inspectorName = req.getInspectorName();
        this.statusEnum = req.getStatusEnum();
    }

}
