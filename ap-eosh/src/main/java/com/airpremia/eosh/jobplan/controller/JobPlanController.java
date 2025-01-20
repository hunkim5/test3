package com.airpremia.eosh.jobplan.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.jobplan.dto.JobEmployeeProtectGearCheckDto;
import com.airpremia.eosh.jobplan.request.JobEmployeeProtectGearCheckRequest;
import com.airpremia.eosh.jobplan.request.JobEmployeeRequest;
import com.airpremia.eosh.jobplan.request.JobPlanRequest;
import com.airpremia.eosh.jobplan.request.JobPlanSearchRequest;
import com.airpremia.eosh.jobplan.response.JobPlanResponse;
import com.airpremia.eosh.jobplan.service.JobPlanService;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/job-plan")
@Tag(name = "작업계획")
@Slf4j
@AllArgsConstructor
public class JobPlanController {
    private final JobPlanService jobPlanService;

    @Operation(summary = "작업계획 페이지 검색")
    @GetMapping
    public ResponseEntity<Page<JobPlanResponse>> selectJobPlanPage(
        @ParameterObject JobPlanSearchRequest searchRequest, Pageable pageable) {
        Page<JobPlanResponse> page =
            jobPlanService.selectJobPlanPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "작업계획 상세")
    @GetMapping(value = "/{jobSeq}")
    public ResponseEntity<JobPlanResponse> selectJobPlanDetail(
        @PathVariable Long jobSeq) {
        JobPlanResponse res =
            jobPlanService.selectJobPlanDetail(jobSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "보호구 확인사항 리스트")
    @GetMapping(value = "/job-employee-protect-gear-check")
    public ResponseEntity<List<JobEmployeeProtectGearCheckDto>> jobEmployeeProtectGearList(
        @PathVariable Long jobSeq) {
        return ResponseEntity.ok(jobPlanService.jobEmployeeProtectGearList(jobSeq));
    }

    @Operation(summary = "사용자 자격증 리스트(userSeq:사번+생년월일(-제거,P제거))")
    @GetMapping(value = "/user-qualification-item/{userSeq}")
    public ResponseEntity<List<UserQualificationItemResponse>> selectUserQualificationItemByUserId(
        @PathVariable String userSeq) {
        return ResponseEntity.ok(jobPlanService.selectUserQualificationItemByUserId(userSeq));
    }

    @Operation(summary = "job 에 포함된 사용자 employee_seq 조회")
    @GetMapping(value = "/user/{userSeq}/job/{jobSeq}")
    public ResponseEntity<Long> getJobEmployeeSeq(
        @PathVariable String userSeq, @PathVariable Long jobSeq) {
        return ResponseEntity.ok(jobPlanService.getJobEmployeeSeq(userSeq, jobSeq));
    }

    @Operation(summary = "작업계획 저장")
    @PostMapping
    public ResponseEntity<Long> insertJobPlan(@RequestBody JobPlanRequest request) {
        return ResponseEntity.ok(jobPlanService.insertJobPlan(request));
    }

    @Operation(summary = "작업계획 수정")
    @PutMapping
    public ResponseEntity<Integer> updateJobPlan(@RequestBody JobPlanRequest request) {
        return ResponseEntity.ok(jobPlanService.updateJobPlan(request));
    }

    @Operation(summary = "ToolBoxMeeting 생성")
    @PostMapping(value = "/tool-box")
    public ResponseEntity<Integer> createToolBoxMeeting(
        @RequestBody JobPlanRequest request) {
        return ResponseEntity.ok(jobPlanService.createToolBoxMeeting(request));
    }

    @Operation(summary = "보호구 확인")
    @PutMapping(value = "/job-employee-protect-gear-check/{protectGearCheckSeq}")
    public ResponseEntity<Integer> updateJobEmployeeProtectGearCheckCheckBool(
        @PathVariable Long protectGearCheckSeq, @RequestBody JobEmployeeProtectGearCheckRequest request) {
        request.setProtectGearCheckSeq(protectGearCheckSeq);
        return ResponseEntity.ok(jobPlanService.updateJobEmployeeProtectGearCheck(request));
    }

    @Operation(summary = "작업 서명 확인 및 퇴장시간 업데이트")
    @PutMapping(value = "/job-employee/signature")
    public ResponseEntity<Integer> updateJobEmployeeSignature(
        @RequestBody
        JobEmployeeRequest request) {
        return ResponseEntity.ok(jobPlanService.updateJobEmployeeSignature(request));
    }

    @Operation(summary = "작업계획 삭제")
    @DeleteMapping
    public ResponseEntity<Integer> deleteJobPlan(
        @RequestBody List<JobPlanRequest> deleteList) {
        return ResponseEntity.ok(jobPlanService.deleteJobPlan(deleteList));
    }
}
