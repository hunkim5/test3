package com.airpremia.eosh.toolboxmeeting.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.jobplan.request.JobEmployeeRequest;
import com.airpremia.eosh.toolboxmeeting.controller.request.ToolBoxMeetingRequest;
import com.airpremia.eosh.toolboxmeeting.controller.response.ToolBoxMeetingResponse;
import com.airpremia.eosh.toolboxmeeting.service.ToolBoxMeetingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/tool-box-meeting")
@Tag(name = "ToolBoxMeeting")
@Slf4j
@AllArgsConstructor
public class ToolBoxMeetingController {
    private final ToolBoxMeetingService toolBoxMeetingService;

    @Operation(summary = "ToolBoxMeeting 수정 저장")
    @PostMapping()
    public ResponseEntity<Integer> upsertToolBoxMeeting(
        @RequestBody ToolBoxMeetingRequest request) {
        return ResponseEntity.ok(toolBoxMeetingService.updateToolBoxMeeting(request));
    }

    @Operation(summary = "ToolBoxMeeting 상세")
    @GetMapping(value = "/{toolBoxMeetingSeq}")
    public ResponseEntity<ToolBoxMeetingResponse> selectToolBoxMeeting(
        @PathVariable Long toolBoxMeetingSeq) {
        ToolBoxMeetingResponse res =
            toolBoxMeetingService.selectToolBoxMeeting(
                toolBoxMeetingSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "ToolBoxMeeting 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<ToolBoxMeetingResponse>> selectToolBoxMeetingPage(
        @ParameterObject ToolBoxMeetingRequest searchRequest,
        @PageableDefault
        @SortDefault.SortDefaults(value = {
            @SortDefault(sort = "tool_box_meeting_seq", direction = Sort.Direction.ASC)
        }) Pageable pageable) {
        Page<ToolBoxMeetingResponse> page =
            toolBoxMeetingService.selectToolBoxMeetingPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "근로자 확인")
    @PutMapping(value = "/job-employee/signature-tbm")
    public ResponseEntity<Integer> updateJobEmployeeSignature(
        @RequestBody
        JobEmployeeRequest request) {
        return ResponseEntity.ok(toolBoxMeetingService.updateJobEmployeeSignatureTbm(request));
    }

    @Operation(summary = "ToolBoxMeeting 삭제")
    @DeleteMapping(value = "/{toolBoxMeetingSeq}")
    public ResponseEntity<Integer> deleteToolBoxMeeting(
        @PathVariable Long toolBoxMeetingSeq) {
        return ResponseEntity.ok(
            toolBoxMeetingService.deleteToolBoxMeeting(toolBoxMeetingSeq));
    }
}
