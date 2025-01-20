package com.airpremia.eosh.certification.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CertificationSafeguardingDto {
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
}
