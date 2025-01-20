package com.airpremia.eosh.risk.response;

import com.airpremia.eosh.risk.entities.VersionRiskEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VersionRiskCollectionResponse {
    @Schema(description = "RISK 버전 시퀀스")
    private Long riskVersionSeq;
    @Schema(description = "RISK 버전 년도")
    private String riskVersionYyyy;

    public VersionRiskCollectionResponse(VersionRiskEntity versionRiskEntity) {
        this.riskVersionSeq = versionRiskEntity.getRiskVersionSeq();
        this.riskVersionYyyy = versionRiskEntity.getRiskVersionYyyy();
    }

}
