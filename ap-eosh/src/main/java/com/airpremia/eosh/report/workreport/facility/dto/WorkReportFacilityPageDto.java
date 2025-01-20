package com.airpremia.eosh.report.workreport.facility.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkFacilityClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportFacilityPageDto {
    private Long facilitySeq;
    private WorkFacilityClassificationEnum workFacilityClassificationEnum;
    private String title;
    private String introductionCode;
    private String introductionFacilityCode;
    private String productName;
    private String modelName;
    private String modelNumber;
    private int quantity;
    private String productManufacturerName;
    private LocalDate safetyInspectionDt;
    private boolean safetyCertificationBool;
    private boolean autonomySafetyCheckReportBool;
    private boolean safetyInspectionBool;
    private boolean etcBool;
    private String movementAreaRegistrationNo;
    private LocalDate registrationDt;
    private LocalDate expirationDt;
    private LocalDate firstTimeInspectionDt;
    private String productManufacturerPhoneno;
    private String productManufacturerEmail;
    private LocalDate safetyInspectionExpirationDt;
    private String newIntroductionLocation;
    private String addComment;
    private String multipleFileSafetycertificationUuid;
    private String multipleFileSafetyinspectionUuid;
    private String multipleFileAutonomysafetyUuid;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    private String requestDepartment;
    private String storageDepartmentCode;
    private String reportNo;
    private String rejectReason;
}

