package com.airpremia.eosh.msds.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.msds.controller.MsdsRequest;
import com.airpremia.eosh.msds.controller.MsdsResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MsdsDto {

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
    private String englishLanguageFileUuid;
    private String koreanLanguageFileUuid;
    private String warningSignFileUuid;
    private boolean deleteBool;
    private String deleteUserId;
    private LocalDateTime deleteDtm;
    private String deleteIp;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public MsdsDto(MsdsRequest req) {
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
        this.englishLanguageFileUuid = req.getEnglishLanguageFileUuid();
        this.koreanLanguageFileUuid = req.getKoreanLanguageFileUuid();
        this.warningSignFileUuid = req.getWarningSignFileUuid();
        this.deleteBool = req.isDeleteBool();
        this.deleteUserId = req.getDeleteUserId();
        this.deleteDtm = req.getDeleteDtm();
        this.deleteIp = req.getDeleteIp();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

    public MsdsResponse convertMsdsResponse() {
        MsdsResponse data = new MsdsResponse();
        data.setMsdsSeq(this.msdsSeq);
        data.setMsdsDivision(this.msdsDivision);
        data.setChemistrySubstanceName(this.chemistrySubstanceName);
        data.setCasId(this.casId);
        data.setHazardousSubstancesSubjectManagementCode(this.hazardousSubstancesSubjectManagementCode);
        data.setSpecialManagementSubstancesCode(this.specialManagementSubstancesCode);
        data.setExposureCriteriaSettingSubstancesCode(this.exposureCriteriaSettingSubstancesCode);
        data.setProhibitedSubstances(this.prohibitedSubstances);
        data.setProcessSafetyReportCode(this.processSafetyReportCode);
        data.setSpecialHealthHazard(this.specialHealthHazard);
        data.setWorkEnvironmentHazard(this.workEnvironmentHazard);
        data.setMsdsPost(this.msdsPost);
        data.setMsdsEducationComment(this.msdsEducationComment);
        data.setContactComment(this.contactComment);
        data.setProviderComment(this.providerComment);
        data.setEnglishLanguageFileUuid(this.englishLanguageFileUuid);
        data.setKoreanLanguageFileUuid(this.koreanLanguageFileUuid);
        data.setWarningSignFileUuid(this.warningSignFileUuid);
        data.setDeleteBool(this.deleteBool);
        data.setDeleteUserId(this.deleteUserId);
        data.setDeleteDtm(this.deleteDtm);
        data.setDeleteIp(this.deleteIp);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}

