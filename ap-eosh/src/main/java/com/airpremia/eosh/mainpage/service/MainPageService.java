package com.airpremia.eosh.mainpage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airpremia.eosh.mainpage.controller.request.MainPageEducationSearchRequest;
import com.airpremia.eosh.mainpage.controller.response.CalendarDataResponse;
import com.airpremia.eosh.mainpage.dto.MainPageEducationDto;
import com.airpremia.eosh.mainpage.dto.MainPageEducationSearchDto;
import com.airpremia.eosh.mainpage.repository.MainPageEducationRepository;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainPageService {
    private final UserTokenService userTokenService;
    private final MainPageEducationRepository mainPageEducationRepository;

    public List<CalendarDataResponse> selectCalendar(MainPageEducationSearchRequest request) {
        UserTokenDto userTokenDto = userTokenService.getUserToken();
        request.setUserId(userTokenDto.getEmpNo());
        MainPageEducationSearchDto dto = new MainPageEducationSearchDto(request);
        List<MainPageEducationDto> list = mainPageEducationRepository.selectEducationList(dto);
        return list.stream().map(CalendarDataResponse::new).toList();

    }
}
