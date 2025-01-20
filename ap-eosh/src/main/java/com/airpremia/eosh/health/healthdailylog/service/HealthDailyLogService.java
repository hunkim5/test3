package com.airpremia.eosh.health.healthdailylog.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.health.healthdailylog.controller.HealthDailyLogRequest;
import com.airpremia.eosh.health.healthdailylog.controller.HealthDailyLogResponse;
import com.airpremia.eosh.health.healthdailylog.dto.HealthDailyLogDto;
import com.airpremia.eosh.health.healthdailylog.repository.HealthDailyLogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class HealthDailyLogService {
    private final HealthDailyLogRepository userHealthCounselReservationRepository;

    public Page<HealthDailyLogResponse> selectHealthDailyLogPage(
        HealthDailyLogRequest request, Pageable pageable) {
        HealthDailyLogDto searchDto = new HealthDailyLogDto(request);
        Page<HealthDailyLogDto> pageList =
            userHealthCounselReservationRepository.selectHealthDailyLogPage(searchDto, pageable);

        return pageList.map(HealthDailyLogResponse::new);
    }

    public HealthDailyLogResponse selectHealthDailyLog(
        long userHealthCounselReservationSeq) {
        HealthDailyLogDto dto =
            userHealthCounselReservationRepository.selectHealthDailyLog(
                userHealthCounselReservationSeq);
        return new HealthDailyLogResponse(dto);
    }

    @Transactional
    public int insertHealthDailyLog(HealthDailyLogRequest request) {
        HealthDailyLogDto dto = new HealthDailyLogDto(request);
        return userHealthCounselReservationRepository.insertHealthDailyLog(dto);
    }

    @Transactional
    public int updateHealthDailyLog(HealthDailyLogRequest request) {
        HealthDailyLogDto dto = new HealthDailyLogDto(request);
        return userHealthCounselReservationRepository.updateHealthDailyLog(dto);
    }

    @Transactional
    public int deleteHealthDailyLog(long userHealthCounselReservationSeq) {
        return userHealthCounselReservationRepository.deleteHealthDailyLog(
            userHealthCounselReservationSeq);
    }

    public List<HealthDailyLogResponse> selectHealthDailyExcelList(HealthDailyLogRequest request) {
        HealthDailyLogDto searchDto = new HealthDailyLogDto(request);
        return userHealthCounselReservationRepository.selectHealthDailyExcelList(searchDto).stream()
            .map(this::healthDailyLogResponse)
            .toList();
    }

    private HealthDailyLogResponse healthDailyLogResponse(HealthDailyLogDto healthDailyLogResponse) {
        HealthDailyLogResponse response = new HealthDailyLogResponse(healthDailyLogResponse);
        return response;
    }
}
