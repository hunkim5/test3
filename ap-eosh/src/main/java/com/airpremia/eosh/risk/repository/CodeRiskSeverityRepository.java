package com.airpremia.eosh.risk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.risk.entities.CodeRiskSeverityClassificationEntity;

@Repository
public interface CodeRiskSeverityRepository {

    List<CodeRiskSeverityClassificationEntity> selectRiskSeverityClassificationList(Long riskVersionSeq);

    int deleteRiskSeverityClassificationList(
        CodeRiskSeverityClassificationEntity codeRiskSeverityClassificationEntity,
        List<Long> excludeSeverityClassificationSeqList);

    int insertRiskSeverityClassification(CodeRiskSeverityClassificationEntity codeRiskSeverityClassificationEntity);

    int updateRiskSeverityClassification(CodeRiskSeverityClassificationEntity codeRiskSeverityClassificationEntity);
}
