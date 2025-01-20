package com.airpremia.eosh.personaldetail.health.repository;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.health.dto.RealTimePublicNormalExaminationDto;

@Repository
public interface RealTimePublicNormalExaminationRepository {

    RealTimePublicNormalExaminationDto selectRealTimePublicNormalExamination(String birthDtName);

    int insertRealTimePublicNormalExamination(RealTimePublicNormalExaminationDto dto);

    int deleteRealTimePublicNormalExamination();


}
