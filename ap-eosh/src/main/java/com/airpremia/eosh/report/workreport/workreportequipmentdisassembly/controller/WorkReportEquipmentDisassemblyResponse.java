package com.airpremia.eosh.report.workreport.workreportequipmentdisassembly.controller;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportEquipmentDisassemblyResponse {
    @Schema(description = "업무 보고서 장비 해체 시퀀스")
    private Long workReportEquipmentDisassemblySeq;
    @Schema(description = "보고서 번호")
    private String reportNo;
    @Schema(description = "제목")
    private String subject;
    @Schema(description = "방호 장치 이름")
    private String protectionDeviceName;
    @Schema(description = "해체 사유")
    private String disassemblyReason;
    @Schema(description = "추가 comment")
    private String addComment;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
    @Schema(description = "승인 업무 보고서 상태 ENUM")
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    @Schema(description = "보완요청 사유")
    private String rejectReason;
}

