package com.airpremia.eosh.risk.entities;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CodeRiskSeverityClassificationEntity {
    @Schema(description = "심각도 분류 시퀀스")
    private Long severityClassificationSeq;
    @Schema(description = "RISK 버전 시퀀스")
    private Long riskVersionSeq;
    @Schema(description = "심각도 제목")
    private String severitySubject;
    @Schema(description = "최저 심각도 내용")
    private String lowestSeverityContent;
    @Schema(description = "낮은 심각도 내용")
    private String lowSeverityContent;
    @Schema(description = "중간 심각도 내용")
    private String mediumSeverityContent;
    @Schema(description = "높은 심각도 내용")
    private String highSeverityContent;
    @Schema(description = "최고 심각도 내용")
    private String highestSeverityContent;
    @Schema(description = "삭제 여부")
    private boolean deleteBool;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;
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
