package com.airpremia.eosh.risk.request;

import java.util.List;

import com.airpremia.eosh.risk.dto.likelihood.CodeRiskLikelihoodClassificationDto;
import com.airpremia.eosh.risk.dto.severity.CodeRiskSeverityClassificationDto;
import com.airpremia.eosh.risk.entities.CodeRiskEntity;
import com.airpremia.eosh.risk.entities.VersionRiskEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiskCodeDetailRequest {
    @Schema(description = "RISK 버전 시퀀스")
    private Long riskVersionSeq;
    @Schema(description = "RISK 버전 년도")
    private String riskVersionYyyy;
    @Schema(description = "리스크 목록")
    private List<CodeRiskEntity> riskCodeList;
    @Schema(description = "가능성 목록")
    private List<CodeRiskLikelihoodClassificationDto> likelihoodClassificationList;
    @Schema(description = "심각성 목록")
    private List<CodeRiskSeverityClassificationDto> severityClassificationList;

    public VersionRiskEntity toVerseVersionRiskEntity() {
        VersionRiskEntity entity = new VersionRiskEntity();

        entity.setRiskVersionSeq(this.riskVersionSeq);
        entity.setRiskVersionYyyy(this.riskVersionYyyy);

        return entity;
    }
}
