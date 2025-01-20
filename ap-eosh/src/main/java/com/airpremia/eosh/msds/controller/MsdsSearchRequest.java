package com.airpremia.eosh.msds.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MsdsSearchRequest {
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
    @Schema(description = "법적 규제")
    private String lawCode;
}
