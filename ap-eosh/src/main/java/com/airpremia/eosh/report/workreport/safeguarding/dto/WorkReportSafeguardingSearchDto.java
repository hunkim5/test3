package com.airpremia.eosh.report.workreport.safeguarding.dto;

import org.apache.commons.lang3.StringUtils;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.safeguarding.controller.WorkReportSafeguardingSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportSafeguardingSearchDto {
    private String requestDepartment;
    private String storageDepartmentCode;
    private String jobDivisionCode;
    private String newDivisionCode;
    private String safeguardingCode;
    private String protectGearCode;
    private String protectGearDetailCode;
    private String productManufacturerName;
    private String productManufacturerPhoneno;
    private String productName;
    private String productModelName;
    private String reportNo;
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    private String requestUserId;
    private boolean safetyCertificationBool;
    private boolean autonomySafetyCheckReportBool;
    private boolean safetyInspectionBool;
    private boolean etcBool;

    public WorkReportSafeguardingSearchDto(WorkReportSafeguardingSearchRequest req) {
        this.requestDepartment = req.getRequestDepartment();
        this.storageDepartmentCode = req.getStorageDepartmentCode();
        this.jobDivisionCode = req.getJobDivisionCode();
        this.newDivisionCode = req.getNewDivisionCode();
        this.safeguardingCode = req.getSafeguardingCode();
        this.protectGearCode = req.getProtectGearCode();
        this.protectGearDetailCode = req.getProtectGearDetailCode();
        this.productManufacturerName = req.getProductManufacturerName();
        this.productManufacturerPhoneno = req.getProductManufacturerPhoneno();
        this.productName = req.getProductName();
        this.productModelName = req.getProductModelName();
        this.reportNo = searchValue(req.getReportNo());
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.requestUserId = req.getRequestUserId();
        this.safetyCertificationBool = req.isSafetyCertificationBool();
        this.autonomySafetyCheckReportBool = req.isAutonomySafetyCheckReportBool();
        this.safetyInspectionBool = req.isSafetyInspectionBool();
        this.etcBool = req.isEtcBool();
    }

    private String searchValue(String value) {
        if (!StringUtils.isEmpty(value)) {
            return "%".concat(value).concat("%");
        } else {
            return null;
        }
    }
}

