package com.airpremia.eosh.report.workreport.facility.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityRequest;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityResponse;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilityUpdateQuantityRequest;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkFacilityClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportFacilityDto {
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

    public WorkReportFacilityDto(WorkReportFacilityRequest req) {
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
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.requestDepartment = req.getRequestDepartment();
        this.storageDepartmentCode = req.getStorageDepartmentCode();
        this.reportNo = req.getReportNo();
        this.rejectReason = req.getRejectReason();
    }

    public WorkReportFacilityDto(WorkReportFacilityUpdateQuantityRequest req) {
        this.facilitySeq = req.getFacilitySeq();
        this.quantity = req.getQuantity();
    }

    public WorkReportFacilityResponse convertWorkReportFacilityResponse() {
        WorkReportFacilityResponse data = new WorkReportFacilityResponse();
        data.setFacilitySeq(this.facilitySeq);
        data.setWorkFacilityClassificationEnum(this.workFacilityClassificationEnum);
        data.setTitle(this.title);
        data.setIntroductionCode(this.introductionCode);
        data.setIntroductionFacilityCode(this.introductionFacilityCode);
        data.setProductName(this.productName);
        data.setModelName(this.modelName);
        data.setModelNumber(this.modelNumber);
        data.setQuantity(this.quantity);
        data.setProductManufacturerName(this.productManufacturerName);
        data.setSafetyInspectionDt(this.safetyInspectionDt);
        data.setSafetyCertificationBool(this.safetyCertificationBool);
        data.setAutonomySafetyCheckReportBool(this.autonomySafetyCheckReportBool);
        data.setSafetyInspectionBool(this.safetyInspectionBool);
        data.setEtcBool(this.etcBool);
        data.setMovementAreaRegistrationNo(this.movementAreaRegistrationNo);
        data.setRegistrationDt(this.registrationDt);
        data.setExpirationDt(this.expirationDt);
        data.setFirstTimeInspectionDt(this.firstTimeInspectionDt);
        data.setProductManufacturerPhoneno(this.productManufacturerPhoneno);
        data.setProductManufacturerEmail(this.productManufacturerEmail);
        data.setSafetyInspectionExpirationDt(this.safetyInspectionExpirationDt);
        data.setNewIntroductionLocation(this.newIntroductionLocation);
        data.setAddComment(this.addComment);
        data.setMultipleFileSafetycertificationUuid(this.multipleFileSafetycertificationUuid);
        data.setMultipleFileSafetyinspectionUuid(this.multipleFileSafetyinspectionUuid);
        data.setMultipleFileAutonomysafetyUuid(this.multipleFileAutonomysafetyUuid);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        data.setApprovalWorkReportStatusEnum(this.approvalWorkReportStatusEnum);
        data.setRequestDepartment(this.requestDepartment);
        data.setStorageDepartmentCode(this.storageDepartmentCode);
        data.setReportNo(this.reportNo);
        data.setRejectReason(this.rejectReason);
        return data;
    }

}

