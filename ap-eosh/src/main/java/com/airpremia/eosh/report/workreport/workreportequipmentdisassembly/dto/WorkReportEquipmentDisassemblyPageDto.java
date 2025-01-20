package com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportEquipmentDisassemblyPageDto {

    private Long workReportEquipmentDisassemblySeq;

    private String reportNo;

    private String subject;

    private String protectionDeviceName;

    private String disassemblyReason;

    private String addComment;

    private String multipleFileUuid;

    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;

    private LocalDateTime insertDtm;

}

