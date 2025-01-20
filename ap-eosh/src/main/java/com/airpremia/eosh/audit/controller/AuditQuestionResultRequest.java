package com.airpremia.eosh.audit.controller;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditQuestionResultRequest {

    @Schema(description = "심사 점검표 문항 결과 시퀀스")
    private Long auditChecklistQuestionResultSeq;

    @Schema(description = "심사 점검표 시퀀스")
    private Long auditChecklistSeq;

    @Schema(description = "1 depth 문항 코드")
    private String oneDepthQuestionCode;

    @Schema(description = "2 depth 문항 코드")
    private String twoDepthQuestionCode;

    @Schema(description = "3 depth 문항 코드")
    private String threeDepthQuestionCode;

    @Schema(description = "이행 여부")
    private Boolean practiceBool;

    @Schema(description = "비고")
    private String remark;

    @Schema(description = "예산")
    private Integer budget;

    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;

    @Schema(description = "삽입 IP")
    private String insertIp;

    @Schema(description = "삽입 날짜")
    private LocalDateTime insertDtm;

    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;

    @Schema(description = "수정 IP")
    private String updateIp;

    @Schema(description = "수정 날짜")
    private LocalDateTime updateDtm;
}
