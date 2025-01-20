package com.airpremia.eosh.committee.controller;

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

import com.airpremia.eosh.committee.controller.request.CommitteeRequest;
import com.airpremia.eosh.committee.controller.request.MeetingSearchRequest;
import com.airpremia.eosh.committee.controller.response.CommitteeResponse;
import com.airpremia.eosh.committee.controller.response.MeetingResponse;
import com.airpremia.eosh.committee.service.CommitteeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/committee")
@Tag(name = "위원회")
@Slf4j
@RequiredArgsConstructor
public class CommitteeController {
    private final CommitteeService committeeService;

    @Operation(summary = "회의록 저장")
    @PostMapping(value = "/meeting/content")
    public ResponseEntity<CommitteeResponse> insertMeeting(
        @RequestBody CommitteeRequest insertRequest) {
        return ResponseEntity.ok(committeeService.insertMeeting(insertRequest));
    }

    @Operation(summary = "회의록 수정")
    @PutMapping(value = "/meeting/content")
    public ResponseEntity<CommitteeResponse> updateMeeting(
        @RequestBody CommitteeRequest insertRequest) {
        return ResponseEntity.ok(committeeService.updateMeeting(insertRequest));
    }

    @Operation(summary = "회의 상세")
    @GetMapping(value = "/{meetingSeq}")
    public ResponseEntity<CommitteeResponse> selectCommittee(@PathVariable Long meetingSeq) {
        CommitteeResponse res = committeeService.selectCommittee(meetingSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "회의 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<MeetingResponse>> selectMeetingPage(
        @ParameterObject MeetingSearchRequest searchRequest, Pageable pageable) {
        Page<MeetingResponse> page = committeeService.selectMeetingPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "회의록 참여위원 확인")
    @PutMapping(value = "/meeting/content/{meetingAttendUserSeq}")
    public ResponseEntity<Integer> updateUserCheck(
        @PathVariable Long meetingAttendUserSeq) {
        return ResponseEntity.ok(committeeService.updateUserCheck(meetingAttendUserSeq));
    }
}
