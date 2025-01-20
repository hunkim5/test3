package com.airpremia.eosh.report.workreport.safeguarding.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingRequest;
import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportSafeguardingDto {
    private Long safeguardingSeq;
    private String requestDepartment;
    private String storageDepartmentCode;
    private String jobDivisionCode;
    private boolean safetyCertificationBool;
    private boolean autonomySafetyCheckReportBool;
    private boolean safetyInspectionBool;
    private boolean etcBool;
    private String movementAreaRegistrationNo;
    private String newDivisionCode;
    private String safeguardingCode;
    private String protectGearCode;
    private String productManufacturerName;
    private String productManufacturerPhoneno;
    private String productManufacturerEmail;
    private String productName;
    private String productModelName;
    private String addDescription;
    private String multipleFileSafetycertificationUuid;
    private String multipleFileSafetyinspectionUuid;
    private String multipleFileAutonomysafetyUuid;
    private int protectionDeviceQuantity;
    private int protectGearQuantity;
    private String requestDepartmentName;
    private String requestUserId;
    private String reportNo;
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    private String protectGearDetailCode;
    private LocalDate registrationDt;
    private LocalDate expirationDt;
    private LocalDate manufacturingDt;
    private LocalDate disposalDt;
    private String replacementRecommendCondition;
    private String rejectReason;
    private String subject;
    private String requestUserName;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public WorkReportSafeguardingDto(WorkReportSafeguardingRequest req) {
        this.safeguardingSeq = req.getSafeguardingSeq();
        this.requestDepartment = req.getRequestDepartment();
        this.storageDepartmentCode = req.getStorageDepartmentCode();
        this.jobDivisionCode = req.getJobDivisionCode();
        this.safetyCertificationBool = req.isSafetyCertificationBool();
        this.autonomySafetyCheckReportBool = req.isAutonomySafetyCheckReportBool();
        this.safetyInspectionBool = req.isSafetyInspectionBool();
        this.etcBool = req.isEtcBool();
        this.movementAreaRegistrationNo = req.getMovementAreaRegistrationNo();
        this.newDivisionCode = req.getNewDivisionCode();
        this.safeguardingCode = req.getSafeguardingCode();
        this.protectGearCode = req.getProtectGearCode();
        this.productManufacturerName = req.getProductManufacturerName();
        this.productManufacturerPhoneno = req.getProductManufacturerPhoneno();
        this.productManufacturerEmail = req.getProductManufacturerEmail();
        this.productName = req.getProductName();
        this.productModelName = req.getProductModelName();
        this.addDescription = req.getAddDescription();
        this.multipleFileSafetycertificationUuid = req.getMultipleFileSafetycertificationUuid();
        this.multipleFileSafetyinspectionUuid = req.getMultipleFileSafetyinspectionUuid();
        this.multipleFileAutonomysafetyUuid = req.getMultipleFileAutonomysafetyUuid();
        this.protectionDeviceQuantity = req.getProtectionDeviceQuantity();
        this.protectGearQuantity = req.getProtectGearQuantity();
        this.requestDepartmentName = req.getRequestDepartmentName();
        this.requestUserId = req.getRequestUserId();
        this.reportNo = req.getReportNo();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.protectGearDetailCode = req.getProtectGearDetailCode();
        this.registrationDt = req.getRegistrationDt();
        this.expirationDt = req.getExpirationDt();
        this.manufacturingDt = req.getManufacturingDt();
        this.disposalDt = req.getDisposalDt();
        this.replacementRecommendCondition = req.getReplacementRecommendCondition();
        this.rejectReason = req.getRejectReason();
        this.subject = req.getSubject();
        this.requestUserName = req.getRequestUserName();
    }

    public WorkReportSafeguardingResponse convertWorkReportSafeguardingResponse() {
        WorkReportSafeguardingResponse data = new WorkReportSafeguardingResponse();
        data.setSafeguardingSeq(this.safeguardingSeq);
        data.setRequestDepartment(this.requestDepartment);
        data.setStorageDepartmentCode(this.storageDepartmentCode);
        data.setJobDivisionCode(this.jobDivisionCode);
        data.setSafetyCertificationBool(this.safetyCertificationBool);
        data.setAutonomySafetyCheckReportBool(this.autonomySafetyCheckReportBool);
        data.setSafetyInspectionBool(this.safetyInspectionBool);
        data.setEtcBool(this.etcBool);
        data.setMovementAreaRegistrationNo(this.movementAreaRegistrationNo);
        data.setNewDivisionCode(this.newDivisionCode);
        data.setSafeguardingCode(this.safeguardingCode);
        data.setProtectGearCode(this.protectGearCode);
        data.setProductManufacturerName(this.productManufacturerName);
        data.setProductManufacturerPhoneno(this.productManufacturerPhoneno);
        data.setProductManufacturerEmail(this.productManufacturerEmail);
        data.setProductName(this.productName);
        data.setProductModelName(this.productModelName);
        data.setAddDescription(this.addDescription);
        data.setMultipleFileSafetycertificationUuid(this.multipleFileSafetycertificationUuid);
        data.setMultipleFileSafetyinspectionUuid(this.multipleFileSafetyinspectionUuid);
        data.setMultipleFileAutonomysafetyUuid(this.multipleFileAutonomysafetyUuid);
        data.setProtectionDeviceQuantity(this.protectionDeviceQuantity);
        data.setProtectGearQuantity(this.protectGearQuantity);
        data.setRequestDepartmentName(this.requestDepartmentName);
        data.setRequestUserId(this.requestUserId);
        data.setReportNo(this.reportNo);
        data.setApprovalWorkReportStatusEnum(this.approvalWorkReportStatusEnum);
        data.setProtectGearDetailCode(this.protectGearDetailCode);
        data.setRegistrationDt(this.registrationDt);
        data.setExpirationDt(this.expirationDt);
        data.setManufacturingDt(this.manufacturingDt);
        data.setDisposalDt(this.disposalDt);
        data.setReplacementRecommendCondition(this.replacementRecommendCondition);
        data.setRejectReason(this.rejectReason);
        data.setSubject(this.subject);
        data.setRequestUserName(this.requestUserName);
        data.setInsertDtm(this.insertDtm);
        return data;
    }
}

