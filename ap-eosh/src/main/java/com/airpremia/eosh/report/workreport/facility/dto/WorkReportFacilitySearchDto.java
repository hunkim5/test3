package com.airpremia.eosh.report.workreport.facility.dto;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.airpremia.eosh.personaldetail.health.enums.ApprovalWorkReportStatusEnum;
import com.airpremia.eosh.report.workreport.facility.controller.WorkReportFacilitySearchRequest;
import com.airpremia.eosh.report.workreport.workreportconstruction.enums.WorkFacilityClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorkReportFacilitySearchDto {

    private Long facilitySeq;
    private WorkFacilityClassificationEnum workFacilityClassificationEnum;
    private String introductionCode;
    private String introductionFacilityCode;
    private String introductionDepartment;
    private String productName;
    private String modelName;
    private String modelNumber;
    private String title;
    private int quantity;
    private String productManufacturerName;
    private LocalDate safetyInspectionDt;
    private String productManufacturerPhoneno;
    private LocalDate safetyInspectionExpirationDt;
    private String newIntroductionLocation;
    private String addComment;
    private String multipleFileSafetycertificationUuid;
    private String multipleFileSafetyinspectionUuid;
    private String multipleFileAutonomysafetyUuid;
    private ApprovalWorkReportStatusEnum approvalWorkReportStatusEnum;
    private String reportNo;
    private String searchUserId;

    public WorkReportFacilitySearchDto(WorkReportFacilitySearchRequest req) {
        this.facilitySeq = req.getFacilitySeq();
        this.workFacilityClassificationEnum = req.getWorkFacilityClassificationEnum();
        this.introductionCode = req.getIntroductionCode();
        this.introductionFacilityCode = req.getIntroductionFacilityCode();
        this.introductionDepartment = req.getIntroductionDepartment();
        this.productName = searchValue(req.getProductName());
        this.modelName = searchValue(req.getModelName());
        this.modelNumber = req.getModelNumber();
        this.title = searchValue(req.getTitle());
        this.quantity = req.getQuantity();
        this.productManufacturerName = req.getProductManufacturerName();
        this.safetyInspectionDt = req.getSafetyInspectionDt();
        this.productManufacturerPhoneno = req.getProductManufacturerPhoneno();
        this.safetyInspectionExpirationDt = req.getSafetyInspectionExpirationDt();
        this.newIntroductionLocation = req.getNewIntroductionLocation();
        this.addComment = req.getAddComment();
        this.approvalWorkReportStatusEnum = req.getApprovalWorkReportStatusEnum();
        this.reportNo = searchValue(req.getReportNo());
    }

    private String searchValue(String value) {
        if (!StringUtils.isEmpty(value)) {
            return "%".concat(value).concat("%");
        } else {
            return null;
        }
    }
}

