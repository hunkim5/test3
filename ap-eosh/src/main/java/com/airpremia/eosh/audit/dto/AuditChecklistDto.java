package com.airpremia.eosh.audit.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.audit.controller.AuditChecklistRequest;
import com.airpremia.eosh.audit.controller.AuditChecklistResponse;
import com.airpremia.eosh.audit.controller.AuditQuestionResultResponse;
import com.airpremia.eosh.audit.enums.StatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuditChecklistDto {

    private Long auditChecklistSeq;
    private Long auditSeq;
    private String checklistClassificationCode;
    private String inspectorId;
    private String inspectorName;
    private LocalDate checkDt;
    private String opinion;
    private StatusEnum statusEnum;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
    private List<AuditResultDto> auditResultDto;


    public AuditChecklistDto(AuditChecklistRequest req) {
        this.auditChecklistSeq = req.getAuditChecklistSeq();
        this.auditSeq = req.getAuditSeq();
        this.checklistClassificationCode = req.getChecklistClassificationCode();
        this.inspectorId = req.getInspectorId();
        this.inspectorName = req.getInspectorName();
        this.checkDt = req.getCheckDt();
        this.opinion = req.getOpinion();
        this.statusEnum = req.getStatusEnum();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
        this.auditResultDto = req.getAuditQuestionResultRequest().stream()
            .map(AuditResultDto::new).toList();
    }

    public AuditChecklistResponse convertAuditListResponse() {
        AuditChecklistResponse data = new AuditChecklistResponse();
        data.setAuditQuestionResultResponse(
            this.auditResultDto.stream().map(AuditQuestionResultResponse::new).toList());
        data.setAuditChecklistSeq(this.auditChecklistSeq);
        data.setAuditSeq(this.auditSeq);
        data.setChecklistClassificationCode(this.checklistClassificationCode);
        data.setInspectorId(this.inspectorId);
        data.setInspectorName(this.inspectorName);
        data.setCheckDt(this.checkDt);
        data.setOpinion(this.opinion);
        data.setStatusEnum(this.statusEnum);
        return data;
    }
}
