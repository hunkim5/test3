package com.airpremia.eosh.risk.response;

import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.risk.dto.likelihood.CodeRiskLikelihoodClassificationDto;
import com.airpremia.eosh.risk.dto.risk.CodeRiskDto;
import com.airpremia.eosh.risk.dto.severity.CodeRiskSeverityClassificationDto;
import com.airpremia.eosh.risk.entities.VersionRiskEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RiskCodeDetailResponse {
    @Schema(description = "RISK 버전 시퀀스")
    private Long riskVersionSeq;
    @Schema(description = "RISK 버전 년도")
    private String riskVersionYyyy;
    @Schema(description = "리스크 목록")
    private List<CodeRiskDto> riskCodeList;
    @Schema(description = "가능성 목록")
    private List<CodeRiskLikelihoodClassificationDto> likelihoodClassificationList;
    @Schema(description = "심각성 목록")
    private List<CodeRiskSeverityClassificationDto> severityClassificationList;
    @Schema(description = "삭제 여부")
    private boolean deleteBool = false;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;

    public RiskCodeDetailResponse(VersionRiskEntity versionRiskEntity) {
        this.riskVersionSeq = versionRiskEntity.getRiskVersionSeq();
        this.riskVersionYyyy = versionRiskEntity.getRiskVersionYyyy();
    }

}
