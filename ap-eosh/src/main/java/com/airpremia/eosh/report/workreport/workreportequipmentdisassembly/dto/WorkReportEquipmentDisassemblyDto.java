package com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller.WorkReportEquipmentDisassemblyRequest;
import com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller.WorkReportEquipmentDisassemblyResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportEquipmentDisassemblyDto {

    private Long workReportEquipmentDisassemblySeq;

    private String reportNo;

    private String subject;

    private String protectionDeviceName;

    private String disassemblyReason;

    private String addComment;

    private String multipleFileUuid;

    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;

    private String rejectReason;

    private String insertIp;

    private String insertUserId;

    private String updateIp;

    private String updateUserId;

    public WorkReportEquipmentDisassemblyDto(WorkReportEquipmentDisassemblyRequest req) {
        this.workReportEquipmentDisassemblySeq = req.getWorkReportEquipmentDisassemblySeq();
        this.reportNo = req.getReportNo();
        this.subject = req.getSubject();
        this.protectionDeviceName = req.getProtectionDeviceName();
        this.disassemblyReason = req.getDisassemblyReason();
        this.addComment = req.getAddComment();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.rejectReason = req.getRejectReason();
    }

    public WorkReportEquipmentDisassemblyResponse convertWorkReportEquipmentDisassemblyResponse() {
        WorkReportEquipmentDisassemblyResponse data = new WorkReportEquipmentDisassemblyResponse();
        data.setWorkReportEquipmentDisassemblySeq(this.workReportEquipmentDisassemblySeq);
        data.setReportNo(this.reportNo);
        data.setSubject(this.subject);
        data.setProtectionDeviceName(this.protectionDeviceName);
        data.setDisassemblyReason(this.disassemblyReason);
        data.setAddComment(this.addComment);
        data.setMultipleFileUuid(this.multipleFileUuid);
        data.setApprovalWorkReportStatusEnum(this.approvalWorkReportStatusEnum);
        data.setReportNo(this.reportNo);
        data.setRejectReason(this.rejectReason);
        return data;
    }
}

