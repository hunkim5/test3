package com.airpremia.eosh.certification.facility.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.certification.facility.controller.CertificationFacilityRequest;
import com.airpremia.eosh.certification.facility.controller.CertificationFacilityResponse;
import com.airpremia.eosh.certification.facility.dto.CertificationFacilityDto;
import com.airpremia.eosh.certification.facility.dto.CertificationFacilitySearchDto;
import com.airpremia.eosh.certification.facility.repository.CertificationFacilityRepository;
import com.airpremia.eosh.common.CommonFunction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificationFacilityService {

    private final CertificationFacilityRepository certificationFacilityRepository;
    private final CommonFunction commonFunction;

    public Page<CertificationFacilityResponse> selectCertificationFacilityPage(
        CertificationFacilityRequest searchRequest, Pageable pageable) {

        CertificationFacilitySearchDto searchDto = new CertificationFacilitySearchDto(searchRequest);

        Page<CertificationFacilityDto> pageList = certificationFacilityRepository.selectCertificationFacilityPage(searchDto, pageable);

        return pageList.map(CertificationFacilityResponse::new);
    }

    public CertificationFacilityResponse selectCertificationFacility(long facilitySeq) {
        CertificationFacilityDto dto = certificationFacilityRepository.selectCertificationFacility(facilitySeq);
        if (dto == null) {
            dto = new CertificationFacilityDto();
        }
        return new CertificationFacilityResponse(dto);
    }

    public int updateCertificationFacility(CertificationFacilityRequest req) {
        CertificationFacilityDto dto = new CertificationFacilityDto(req);
        return certificationFacilityRepository.updateCertificationFacility(dto);
    }
}
