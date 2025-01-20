package com.airpremia.eosh.certification.facility.dto;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.airpremia.eosh.certification.facility.controller.CertificationFacilityRequest;
import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkFacilityClassificationEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificationFacilitySearchDto {
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
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    private String requestDepartment;
    private String storageDepartment;
    private String reportNo;
    private String rejectReason;
    public CertificationFacilitySearchDto(CertificationFacilityRequest req) {
        this.facilitySeq = req.getFacilitySeq();
        this.workFacilityClassificationEnum = req.getWorkFacilityClassificationEnum();
        this.title = req.getTitle();
        this.introductionCode = req.getIntroductionCode();
        this.introductionFacilityCode = req.getIntroductionFacilityCode();
        this.productName = searchValue(req.getProductName());
        this.modelName = searchValue(req.getModelName());
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
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.requestDepartment = req.getRequestDepartment();
        this.storageDepartment = req.getStorageDepartment();
        this.reportNo = req.getReportNo();
        this.rejectReason = req.getRejectReason();
    }

    private String searchValue(String value) {
        if (!StringUtils.isEmpty(value)) {
            return "%".concat(value).concat("%");
        } else {
            return null;
        }
    }
}
