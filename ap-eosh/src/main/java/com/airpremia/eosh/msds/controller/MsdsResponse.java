package com.airpremia.eosh.msds.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.msds.dto.MsdsDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MsdsResponse {
    @Schema(description = "MSDS 시퀀스")
    private Long msdsSeq;
    @Schema(description = "MSDS 구분")
    private String msdsDivision;
    @Schema(description = "화학 물질 이름")
    private String chemistrySubstanceName;
    @Schema(description = "CAS 아이디")
    private String casId;
    @Schema(description = "관리대상유해물질 코드")
    private String hazardousSubstancesSubjectManagementCode;
    @Schema(description = "특별관리물질 코드")
    private String specialManagementSubstancesCode;
    @Schema(description = "노출기준설정물질 코드")
    private String exposureCriteriaSettingSubstancesCode;
    @Schema(description = "허가금지물질")
    private String prohibitedSubstances;
    @Schema(description = "공정안전보고서 코드")
    private String processSafetyReportCode;
    @Schema(description = "'특수건강' HAZARD")
    private String specialHealthHazard;
    @Schema(description = "업무 환경 HAZARD")
    private String workEnvironmentHazard;
    @Schema(description = "MSDS 게시")
    private String msdsPost;
    @Schema(description = "MSDS 교육 comment")
    private String msdsEducationComment;
    @Schema(description = "연락처 comment")
    private String contactComment;
    @Schema(description = "공급자 comment")
    private String providerComment;
    @Schema(description = "영문 파일 UUID")
    private String englishLanguageFileUuid;
    @Schema(description = "국문 파일 UUID")
    private String koreanLanguageFileUuid;
    @Schema(description = "경고표지 파일 UUID")
    private String warningSignFileUuid;
    @Schema(description = "삭제 여부")
    private boolean deleteBool;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;

    public MsdsResponse(MsdsDto req) {
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
}

