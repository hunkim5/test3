package com.airpremia.eosh.risk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.risk.entities.VersionRiskEntity;


@Repository
public interface VersionRiskRepository {
    VersionRiskEntity selectRiskDetail(Long riskVersionSeq);

    List<VersionRiskEntity> selectRiskVersionList();

    int insertRiskVersion(VersionRiskEntity saveDto);
}
