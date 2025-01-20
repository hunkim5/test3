package com.airpremia.eosh.risk.dto.likelihood;

import com.airpremia.eosh.risk.entities.CodeRiskLikelihoodClassificationEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodeRiskLikelihoodClassificationDto {
    private Long likelihoodClassificationSeq;
    private Long riskVersionSeq;
    private String likelihoodSubject;
    private String lowestLikelihoodContent;
    private String lowLikelihoodContent;
    private String mediumLikelihoodContent;
    private String highLikelihoodContent;
    private String highestLikelihoodContent;


    public CodeRiskLikelihoodClassificationDto(CodeRiskLikelihoodClassificationEntity entity) {
        this.likelihoodClassificationSeq = entity.getLikelihoodClassificationSeq();
        this.riskVersionSeq = entity.getRiskVersionSeq();
        this.likelihoodSubject = entity.getLikelihoodSubject();
        this.lowestLikelihoodContent = entity.getLowestLikelihoodContent();
        this.lowLikelihoodContent = entity.getLowLikelihoodContent();
        this.mediumLikelihoodContent = entity.getMediumLikelihoodContent();
        this.highLikelihoodContent = entity.getHighLikelihoodContent();
        this.highestLikelihoodContent = entity.getHighestLikelihoodContent();
    }

    public CodeRiskLikelihoodClassificationEntity toCodeRiskLikelihoodClassificationEntity() {
        CodeRiskLikelihoodClassificationEntity entity = new CodeRiskLikelihoodClassificationEntity();
        entity.setLikelihoodClassificationSeq(this.likelihoodClassificationSeq);
        entity.setRiskVersionSeq(this.riskVersionSeq);
        entity.setLikelihoodSubject(this.likelihoodSubject);
        entity.setLowestLikelihoodContent(this.lowestLikelihoodContent);
        entity.setLowLikelihoodContent(this.lowLikelihoodContent);
        entity.setMediumLikelihoodContent(this.mediumLikelihoodContent);
        entity.setHighLikelihoodContent(this.highLikelihoodContent);
        entity.setHighestLikelihoodContent(this.highestLikelihoodContent);
        return entity;
    }
}
