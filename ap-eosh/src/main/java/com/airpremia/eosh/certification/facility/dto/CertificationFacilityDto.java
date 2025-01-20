package com.airpremia.eosh.certification.facility.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.certification.facility.controller.CertificationFacilityRequest;
import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkFacilityClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CertificationFacilityDto {
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
    private String storageDepartment;
    private String reportNo;
    private String rejectReason;

    public CertificationFacilityDto(CertificationFacilityRequest req) {
        this.facilitySeq = req.getFacilitySeq();
        this.workFacilityClassificationEnum = req.getWorkFacilityClassificationEnum();
        this.title = req.getTitle();
        this.introductionCode = req.getIntroductionCode();
        this.introductionFacilityCode = req.getIntroductionFacilityCode();
        this.productName = req.getProductName();
        this.modelName = req.getModelName();
        this.modelNumber = req.getModelNumber();
        this.quantity = req.getQuantity();
        this.productManufacturerName = req.getProductManufacturerName();
        this.safetyInspectionDt = req.getSafetyInspectionDt();
        this.safetyCertificationBool = req.isSafetyCertificationBool();
        this.autonomySafetyCheckReportBool = req.isAutonomySafetyCheckReportBool();
        this.safetyInspectionBool = req.isSafetyInspectionBool();
        this.etcBool = req.isEtcBool();
        this.movementAreaRegistrationNo = req.getMovementAreaRegistrationNo();
        this.registrationDt = req.getRegistrationDt();
        this.expirationDt = req.getExpirationDt();
        this.firstTimeInspectionDt = req.getFirstTimeInspectionDt();
        this.productManufacturerPhoneno = req.getProductManufacturerPhoneno();
        this.productManufacturerEmail = req.getProductManufacturerEmail();
        this.safetyInspectionExpirationDt = req.getSafetyInspectionExpirationDt();
        this.newIntroductionLocation = req.getNewIntroductionLocation();
        this.addComment = req.getAddComment();
        this.multipleFileSafetycertificationUuid = req.getMultipleFileSafetycertificationUuid();
        this.multipleFileSafetyinspectionUuid = req.getMultipleFileSafetyinspectionUuid();
        this.multipleFileAutonomysafetyUuid = req.getMultipleFileAutonomysafetyUuid();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.requestDepartment = req.getRequestDepartment();
        this.storageDepartment = req.getStorageDepartment();
        this.reportNo = req.getReportNo();
        this.rejectReason = req.getRejectReason();
    }

}
