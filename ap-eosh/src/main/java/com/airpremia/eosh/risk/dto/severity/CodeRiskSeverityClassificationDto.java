package com.airpremia.eosh.risk.dto.severity;

import com.airpremia.eosh.risk.entities.CodeRiskSeverityClassificationEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodeRiskSeverityClassificationDto {
    private Long severityClassificationSeq;
    private Long riskVersionSeq;
    private String severitySubject;
    private String lowestSeverityContent;
    private String lowSeverityContent;
    private String mediumSeverityContent;
    private String highSeverityContent;
    private String highestSeverityContent;

    public CodeRiskSeverityClassificationDto(CodeRiskSeverityClassificationEntity entity) {
        this.severityClassificationSeq = entity.getSeverityClassificationSeq();
        this.riskVersionSeq = entity.getRiskVersionSeq();
        this.severitySubject = entity.getSeveritySubject();
        this.lowestSeverityContent = entity.getLowestSeverityContent();
        this.lowSeverityContent = entity.getLowSeverityContent();
        this.mediumSeverityContent = entity.getMediumSeverityContent();
        this.highSeverityContent = entity.getHighSeverityContent();
        this.highestSeverityContent = entity.getHighestSeverityContent();
    }

    public CodeRiskSeverityClassificationEntity toCodeRiskSeverityClassificationEntity() {
        CodeRiskSeverityClassificationEntity entity = new CodeRiskSeverityClassificationEntity();
        entity.setSeverityClassificationSeq(this.severityClassificationSeq);
        entity.setRiskVersionSeq(this.riskVersionSeq);
        entity.setSeveritySubject(this.severitySubject);
        entity.setLowestSeverityContent(this.lowestSeverityContent);
        entity.setLowSeverityContent(this.lowSeverityContent);
        entity.setMediumSeverityContent(this.mediumSeverityContent);
        entity.setHighSeverityContent(this.highSeverityContent);
        entity.setHighestSeverityContent(this.highestSeverityContent);
        return entity;
    }

}
