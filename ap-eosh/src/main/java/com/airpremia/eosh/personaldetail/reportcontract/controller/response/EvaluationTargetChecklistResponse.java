package com.airpremia.eosh.personaldetail.reportcontract.controller.response;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.reportcontract.dto.EvaluationTargetChecklistDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EvaluationTargetChecklistResponse {

    @Schema(description = "평가 대상 체크 리스트 시퀀스")
    private Long evaluationTargetChecklistSeq;
    @Schema(description = "계약 시퀀스")
    private Long contractSeq;
    @Schema(description = "체크리스트 코드")
    private String checklistCode;
    @Schema(description = "체크리스트 결과")
    private int checklistResult;
    @Schema(description = "비고")
    private String remark;
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

    public EvaluationTargetChecklistResponse(EvaluationTargetChecklistDto req) {
        this.evaluationTargetChecklistSeq = req.getEvaluationTargetChecklistSeq();
        this.contractSeq = req.getContractSeq();
        this.checklistCode = req.getChecklistCode();
        this.checklistResult = req.getChecklistResult();
        this.remark = req.getRemark();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }
}

