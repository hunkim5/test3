package com.airpremia.eosh.audit.controller;

import com.airpremia.eosh.audit.dto.AuditResultDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditQuestionResultResponse {

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


    public AuditQuestionResultResponse(AuditResultDto req) {
        this.auditChecklistQuestionResultSeq = req.getAuditChecklistQuestionResultSeq();
        this.auditChecklistSeq = req.getAuditChecklistSeq();
        this.oneDepthQuestionCode = req.getOneDepthQuestionCode();
        this.twoDepthQuestionCode = req.getTwoDepthQuestionCode();
        this.threeDepthQuestionCode = req.getThreeDepthQuestionCode();
        this.practiceBool = req.getPracticeBool();
        this.remark = req.getRemark();
        this.budget = req.getBudget();
    }
}
