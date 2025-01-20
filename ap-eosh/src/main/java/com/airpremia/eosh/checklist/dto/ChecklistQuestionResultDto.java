package com.airpremia.eosh.checklist.dto;

import com.airpremia.eosh.checklist.enums.SuitableEnum;
import com.airpremia.eosh.checklist.request.ChecklistQuestionResultRequest;
import com.airpremia.eosh.checklist.response.ChecklistQuestionResultResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistQuestionResultDto {
    private Long checklistQuestionResultSeq;
    private Long checklistSeq;
    private String checklistQuestionCode;
    private SuitableEnum suitableEnum;
    private String attachFileUuid;
    private String remark;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public ChecklistQuestionResultDto(ChecklistQuestionResultRequest req) {
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

    public ChecklistQuestionResultResponse convertChecklistQuestionResultResponse() {
        ChecklistQuestionResultResponse data = new ChecklistQuestionResultResponse();
        data.setChecklistQuestionResultSeq(this.checklistQuestionResultSeq);
        data.setChecklistSeq(this.checklistSeq);
        data.setChecklistQuestionCode(this.checklistQuestionCode);
        data.setSuitableEnum(this.suitableEnum);
        data.setAttachFileUuid(this.attachFileUuid);
        data.setRemark(this.remark);
        data.setInsertUserId(this.insertUserId);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}

