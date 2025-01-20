package com.airpremia.eosh.health.healthdailylog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.health.healthdailylog.dto.HealthDailyLogDto;

@Repository
public interface HealthDailyLogRepository {

    Page<HealthDailyLogDto> selectHealthDailyLogPage(
        @Param(value = "searchDto") HealthDailyLogDto dto, Pageable pageable);

    HealthDailyLogDto selectHealthDailyLog(long userHealthCounselReservationSeq);

    int insertHealthDailyLog(HealthDailyLogDto dto);

    int updateHealthDailyLog(HealthDailyLogDto dto);

    int deleteHealthDailyLog(long userHealthCounselReservationSeq);

    List<HealthDailyLogDto> selectHealthDailyExcelList(@Param(value = "searchDto") HealthDailyLogDto dto);

}
