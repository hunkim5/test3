package com.airpremia.eosh.checklist.response;

import com.airpremia.eosh.checklist.dto.ChecklistQuestionResultDto;
import com.airpremia.eosh.checklist.enums.SuitableEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ChecklistQuestionResultResponse {

    @Schema(description = "점검표 문항 결과 시퀀스")
    private Long checklistQuestionResultSeq;
    @Schema(description = "점검표 시퀀스")
    private Long checklistSeq;
    @Schema(description = "점검표 문항 코드")
    private String checklistQuestionCode;
    @Schema(description = "적합 ENUM")
    private SuitableEnum suitableEnum;
    @Schema(description = "첨부 파일 UUID")
    private String attachFileUuid;
    @Schema(description = "비고")
    private String remark;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 IP")
    private String updateIp;

    public ChecklistQuestionResultResponse(ChecklistQuestionResultDto req) {
        this.checklistQuestionResultSeq = req.getChecklistQuestionResultSeq();
        this.checklistSeq = req.getChecklistSeq();
        this.checklistQuestionCode = req.getChecklistQuestionCode();
        this.suitableEnum = req.getSuitableEnum();
        this.attachFileUuid = req.getAttachFileUuid();
        this.remark = req.getRemark();
        this.insertUserId = req.getInsertUserId();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }
}
