package com.airpremia.eosh.risk.dto.risk;

import com.airpremia.eosh.risk.entities.CodeRiskEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodeRiskDto {
    @Schema(description = "RISK 버전 시퀀스")
    private Long riskVersionSeq;
    @Schema(description = "RISK 코드")
    private String riskCode;
    @Schema(description = "RISK 등급 코드")
    private String riskGradeCode;

    public CodeRiskDto(CodeRiskEntity codeRiskEntity) {
        this.riskVersionSeq = codeRiskEntity.getRiskVersionSeq();
        this.riskCode = codeRiskEntity.getRiskCode();
        this.riskGradeCode = codeRiskEntity.getRiskGradeCode();
    }
}
