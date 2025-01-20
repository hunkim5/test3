package com.airpremia.eosh.certification.facility.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.certification.facility.dto.CertificationFacilityDto;
import com.airpremia.eosh.certification.facility.dto.CertificationFacilitySearchDto;

@Repository
public interface CertificationFacilityRepository {

    Page<CertificationFacilityDto> selectCertificationFacilityPage(@Param(value = "searchDto") CertificationFacilitySearchDto searchDto, Pageable pageable);

    CertificationFacilityDto selectCertificationFacility(long facilitySeq);

    int updateCertificationFacility(CertificationFacilityDto dto);
}
