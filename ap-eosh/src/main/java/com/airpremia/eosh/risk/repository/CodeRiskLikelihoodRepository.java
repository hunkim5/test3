package com.airpremia.eosh.risk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.risk.entities.CodeRiskLikelihoodClassificationEntity;


@Repository
public interface CodeRiskLikelihoodRepository {
    List<CodeRiskLikelihoodClassificationEntity> selectRiskLikelihoodClassificationList(Long riskVersionSeq);

    int deleteRiskLikelihoodClassificationList(
        CodeRiskLikelihoodClassificationEntity codeRiskLikelihoodClassificationEntity,
        List<Long> excludeLikelihoodClassificationSeqList);

    int insertRiskLikelihoodClassification(
        CodeRiskLikelihoodClassificationEntity codeRiskLikelihoodClassificationEntity);

    int updateRiskLikelihoodClassification(
        CodeRiskLikelihoodClassificationEntity codeRiskLikelihoodClassificationEntity);

}
