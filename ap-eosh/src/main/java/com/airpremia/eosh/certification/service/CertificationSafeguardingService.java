package com.airpremia.eosh.certification.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.certification.controller.CertificationSafeguardingRequest;
import com.airpremia.eosh.certification.controller.CertificationSafeguardingResponse;
import com.airpremia.eosh.certification.controller.CertificationSafeguardingSearchRequest;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingSearchDto;
import com.airpremia.eosh.certification.dto.CertificationSafeguardingUpdateDto;
import com.airpremia.eosh.certification.repository.CertificationSafeguardingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificationSafeguardingService {

    private final CertificationSafeguardingRepository certificationSafeguardingRepository;

    public Page<CertificationSafeguardingResponse> selectCertificationSafeguardingPage(
        CertificationSafeguardingSearchRequest searchRequest, Pageable pageable) {

        CertificationSafeguardingSearchDto searchDto = new CertificationSafeguardingSearchDto(searchRequest);

        Page<CertificationSafeguardingDto> pageList = certificationSafeguardingRepository.selectCertificationSafeguardingPage(searchDto, pageable);

        return pageList.map(CertificationSafeguardingResponse::new);
    }

    public CertificationSafeguardingResponse selectCertificationSafeguarding(Long safeguardingSeq) {
        CertificationSafeguardingDto dto = certificationSafeguardingRepository.selectCertificationSafeguarding(safeguardingSeq);
        if (dto == null) {
            dto = new CertificationSafeguardingDto();
        }
        return new CertificationSafeguardingResponse(dto);
    }

    public int updateCertificationSafeguarding(CertificationSafeguardingRequest request, Long safeguardingSeq) {
        CertificationSafeguardingUpdateDto dto = new CertificationSafeguardingUpdateDto(request);
        dto.setSafeguardingSeq(safeguardingSeq);
        return certificationSafeguardingRepository.updateCertificationSafeguarding(dto);
    }
}
