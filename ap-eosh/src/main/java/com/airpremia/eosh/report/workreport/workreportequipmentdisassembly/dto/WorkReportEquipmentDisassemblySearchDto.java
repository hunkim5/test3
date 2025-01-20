package com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller.WorkReportEquipmentDisassemblySearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportEquipmentDisassemblySearchDto {

    private Long workReportEquipmentDisassemblySeq;

    private String reportNo;

    private String subject;

    private String protectionDeviceName;

    private String disassemblyReason;

    private String addComment;

    private String multipleFileUuid;

    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;

    public WorkReportEquipmentDisassemblySearchDto(WorkReportEquipmentDisassemblySearchRequest req) {
        this.workReportEquipmentDisassemblySeq = req.getWorkReportEquipmentDisassemblySeq();
        this.reportNo = req.getReportNo();
        this.subject = req.getSubject();
        this.protectionDeviceName = req.getProtectionDeviceName();
        this.disassemblyReason = req.getDisassemblyReason();
        this.addComment = req.getAddComment();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
    }

}

