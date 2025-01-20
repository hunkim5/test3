package com.airpremia.eosh.certification.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.certification.dto.CertificationSafeguardingDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingSearchDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingUpdateDto;

@Repository
public interface CertificationSafeguardingRepository {

    Page<CertificationSafeguardingDto> selectCertificationSafeguardingPage(CertificationSafeguardingSearchDto searchDto, Pageable pageable);

    CertificationSafeguardingDto selectCertificationSafeguarding(Long safeguardingSeq);

    int updateCertificationSafeguarding(CertificationSafeguardingUpdateDto updateDto);

}
