package com.airpremia.eosh.audit.controller;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditRequest {

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

    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;

    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;

    @Schema(description = "삽입 IP")
    private String insertIp;

    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;

    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;

    @Schema(description = "수정 IP")
    private String updateIp;
}
