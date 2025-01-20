package com.airpremia.eosh.personaldetail.basicinfo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.personaldetail.basicinfo.dto.BasicInfoDto;
import com.airpremia.eosh.personaldetail.basicinfo.dto.BasicInfoUpdateDto;

@Repository
public interface BasicInfoRepository {

    BasicInfoDto selectBasicInfo(long userSeq);

    List<BasicInfoDto> selectBasicInfoSearch(BasicInfoDto dto);

    int updateBasicInfo(BasicInfoUpdateDto dto);
}
