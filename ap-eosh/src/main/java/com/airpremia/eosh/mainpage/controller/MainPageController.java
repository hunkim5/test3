package com.airpremia.eosh.mainpage.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.mainpage.controller.request.MainPageEducationSearchRequest;
import com.airpremia.eosh.mainpage.controller.response.CalendarDataResponse;
import com.airpremia.eosh.mainpage.service.MainPageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/mainpage")
@Tag(name = "MainPage")
@RequiredArgsConstructor
public class MainPageController {
    private final MainPageService mainPageService;

    @Operation(summary = "월별 교육 일정")
    @GetMapping(value = "calendar")
    public ResponseEntity<List<CalendarDataResponse>> selectCalendar(
        @ParameterObject MainPageEducationSearchRequest request
    ) {
        List<CalendarDataResponse> result = mainPageService.selectCalendar(request);
        return ResponseEntity.ok(result);
    }
}
