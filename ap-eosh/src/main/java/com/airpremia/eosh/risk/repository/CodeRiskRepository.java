package com.airpremia.eosh.risk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.risk.entities.CodeRiskEntity;


@Repository
public interface CodeRiskRepository {
    List<CodeRiskEntity> selectCodeRiskList(Long riskVersionSeq);

    List<CodeRiskEntity> selectExistsRiskCodeList(Long riskVersionSeq);

    int insertRiskCode(CodeRiskEntity codeRiskEntity);

    int updateRiskCode(CodeRiskEntity codeRiskEntity);
}
