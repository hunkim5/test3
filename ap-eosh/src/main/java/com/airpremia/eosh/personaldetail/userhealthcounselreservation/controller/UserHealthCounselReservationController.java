package com.airpremia.eosh.personaldetail.userhealthcounselreservation.controller;

import org.apache.ibatis.annotations.Delete;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.personaldetail.userhealthcounselreservation.service.UserHealthCounselReservationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/my-health-counsel-reservation")
@Tag(name = "건강 상담 예약")
@Slf4j
@AllArgsConstructor
public class UserHealthCounselReservationController {
    private final UserHealthCounselReservationService userHealthCounselReservationService;

    @Operation(summary = "건강 상담 예약 상세")
    @GetMapping(value = "/{userHealthCounselReservationSeq}")
    public ResponseEntity<UserHealthCounselReservationResponse> selectUserHealthCounselReservation(
        @PathVariable long userHealthCounselReservationSeq) {
        UserHealthCounselReservationResponse res =
            userHealthCounselReservationService.selectUserHealthCounselReservation(userHealthCounselReservationSeq);
        return ResponseEntity.ok(res);
    }


    @Operation(summary = "건강 상담 예약 저장")
    @PostMapping()
    public ResponseEntity<Integer> insertUserHealthCounselReservation(
        @RequestBody UserHealthCounselReservationRequest req) {
        int res = userHealthCounselReservationService.insertUserHealthCounselReservation(req);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "건강 상담 예약 수정")
    @PutMapping(value = "/{userHealthCounselReservationSeq}")
    public ResponseEntity<Integer> updateUserHealthCounselReservation(
        @PathVariable long userHealthCounselReservationSeq, @RequestBody UserHealthCounselReservationRequest req) {
        req.setUserHealthCounselReservationSeq(userHealthCounselReservationSeq);
        int res = userHealthCounselReservationService.updateUserHealthCounselReservation(req);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "건강 상담 예약 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<UserHealthCounselReservationResponse>> selectUserHealthCounselReservationPage(
        @ParameterObject UserHealthCounselReservationRequest searchRequest, Pageable pageable) {
        Page<UserHealthCounselReservationResponse> page =
            userHealthCounselReservationService.selectUserHealthCounselReservationPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "건강 상담 예약 삭제")
    @Delete(value = "/{userHealthCounselReservationSeq}")
    public ResponseEntity<Integer> deleteUserHealthCounselReservation(
        @PathVariable long userHealthCounselReservationSeq) {
        Integer res =
            userHealthCounselReservationService.deleteUserHealthCounselReservation(userHealthCounselReservationSeq);
        return ResponseEntity.ok(res);
    }
}
