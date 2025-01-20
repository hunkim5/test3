package com.airpremia.eosh.risk.entities;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CodeRiskEntity {
    @Schema(description = "RISK 버전 시퀀스")
    private Long riskVersionSeq;
    @Schema(description = "RISK 코드")
    private String riskCode;
    @Schema(description = "RISK 등급 코드")
    private String riskGradeCode;
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
