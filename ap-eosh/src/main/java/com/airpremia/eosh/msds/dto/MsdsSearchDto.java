package com.airpremia.eosh.msds.dto;

import com.airpremia.eosh.msds.controller.MsdsSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MsdsSearchDto {

    private Long msdsSeq;
    private String msdsDivision;
    private String chemistrySubstanceName;
    private String casId;
    private String hazardousSubstancesSubjectManagementCode;
    private String specialManagementSubstancesCode;
    private String exposureCriteriaSettingSubstancesCode;
    private String prohibitedSubstances;
    private String processSafetyReportCode;
    private String specialHealthHazard;
    private String workEnvironmentHazard;
    private String msdsPost;
    private String msdsEducationComment;
    private String contactComment;
    private String providerComment;
    private String lawCode;

    public MsdsSearchDto(MsdsSearchRequest req) {
        this.msdsSeq = req.getMsdsSeq();
        this.msdsDivision = req.getMsdsDivision();
        this.chemistrySubstanceName = req.getChemistrySubstanceName();
        this.casId = req.getCasId();
        this.hazardousSubstancesSubjectManagementCode = req.getHazardousSubstancesSubjectManagementCode();
        this.specialManagementSubstancesCode = req.getSpecialManagementSubstancesCode();
        this.exposureCriteriaSettingSubstancesCode = req.getExposureCriteriaSettingSubstancesCode();
        this.prohibitedSubstances = req.getProhibitedSubstances();
        this.processSafetyReportCode = req.getProcessSafetyReportCode();
        this.specialHealthHazard = req.getSpecialHealthHazard();
        this.workEnvironmentHazard = req.getWorkEnvironmentHazard();
        this.msdsPost = req.getMsdsPost();
        this.msdsEducationComment = req.getMsdsEducationComment();
        this.contactComment = req.getContactComment();
        this.providerComment = req.getProviderComment();
        this.lawCode = req.getLawCode();
    }

}

