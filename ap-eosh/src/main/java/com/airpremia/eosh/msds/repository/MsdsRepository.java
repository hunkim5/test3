package com.airpremia.eosh.msds.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.msds.dto.MsdsDto;
import com.airpremia.eosh.msds.dto.MsdsSearchDto;


@Repository
public interface MsdsRepository {

    int insertMsds(MsdsDto insertDto);

    int updateMsds(MsdsDto updateDto);

    int deleteMsds(Long msdsSeq);

    Page<MsdsDto> selectMsdsPage(
        @Param(value = "searchDto") MsdsSearchDto dto, Pageable pageable);

    MsdsDto selectMsds(Long msdsSeq);
}
