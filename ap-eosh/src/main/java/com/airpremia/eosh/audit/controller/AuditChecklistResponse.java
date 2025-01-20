package com.airpremia.eosh.audit.controller;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.audit.enums.StatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditChecklistResponse {

    @Schema(description = "심사 점검표 시퀀스")
    private Long auditChecklistSeq;

    @Schema(description = "심사 시퀀스")
    private Long auditSeq;

    @Schema(description = "점검표 분류 코드")
    private String checklistClassificationCode;

    @Schema(description = "점검자 아이디")
    private String inspectorId;

    @Schema(description = "점검자 이름")
    private String inspectorName;

    @Schema(description = "점검 날짜")
    private LocalDate checkDt;

    @Schema(description = "의견")
    private String opinion;

    @Schema(description = "심사 설문 저장 상태 ENUM")
    private StatusEnum statusEnum;

    @Schema(description = "점검표 설문답")
    private List<AuditQuestionResultResponse> auditQuestionResultResponse;
}
