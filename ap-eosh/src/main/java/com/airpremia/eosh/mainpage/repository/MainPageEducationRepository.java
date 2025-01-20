package com.airpremia.eosh.mainpage.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.mainpage.dto.MainPageEducationDto;
import com.airpremia.eosh.mainpage.dto.MainPageEducationSearchDto;


@Repository
public interface MainPageEducationRepository {
    List<MainPageEducationDto> selectEducationList(MainPageEducationSearchDto dto);

}
