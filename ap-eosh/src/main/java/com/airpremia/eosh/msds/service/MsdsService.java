package com.airpremia.eosh.msds.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.airpremia.eosh.msds.controller.MsdsRequest;
import com.airpremia.eosh.msds.controller.MsdsResponse;
import com.airpremia.eosh.msds.controller.MsdsSearchRequest;
import com.airpremia.eosh.msds.dto.MsdsDto;
import com.airpremia.eosh.msds.dto.MsdsSearchDto;
import com.airpremia.eosh.msds.repository.MsdsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MsdsService {

    private final MsdsRepository msdsRepository;

    public Page<MsdsResponse> selectMsdsPage(
        MsdsSearchRequest msdsSearchRequest, Pageable pageable) {

        MsdsSearchDto dto =
            new MsdsSearchDto(msdsSearchRequest);
        Page<MsdsDto> pageDto =
            msdsRepository.selectMsdsPage(dto, pageable);

        return pageDto.map(MsdsResponse::new);
    }

    public MsdsResponse selectMsds(
        Long msdsSeq) {
        MsdsDto dto =
            msdsRepository.selectMsds(
                msdsSeq);
        if (dto == null) {
            dto = new MsdsDto();
        }
        return dto.convertMsdsResponse();
    }

    public int updateMsds(MsdsRequest req) {
        MsdsDto dto = new MsdsDto(req);
        return msdsRepository.updateMsds(dto);
    }

    public int insertMsds(MsdsRequest req) {
        MsdsDto dto = new MsdsDto(req);
        return msdsRepository.insertMsds(dto);
    }

    public int deleteMsds(Long msdsSeq) {
        return msdsRepository.deleteMsds(
            msdsSeq);
    }
}
