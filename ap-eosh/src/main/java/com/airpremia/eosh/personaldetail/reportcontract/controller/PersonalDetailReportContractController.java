package com.airpremia.eosh.personaldetail.reportcontract.controller;

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

import com.airpremia.eosh.personaldetail.reportcontract.controller.request.EvaluationTargetChecklistRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.request.PersonalDetailReportContractRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.request.PersonalDetailReportContractSearchRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.request.SafetyHealthCheckChecklistRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.EvaluationTargetChecklistResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.PersonalDetailContractCompanyResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.PersonalDetailReportContractPageResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.PersonalDetailReportContractResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.SafetyHealthCheckChecklistResponse;
import com.airpremia.eosh.personaldetail.reportcontract.service.PersonalDetailReportContractService;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/personal-detail/work-report-contract")
@Tag(name = "협력업체")
@Slf4j
@AllArgsConstructor
public class PersonalDetailReportContractController {
    private final PersonalDetailReportContractService personalDetailReportContractService;

    @Operation(summary = "협력업체 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<PersonalDetailReportContractPageResponse>> selectReportContractPage(
        @ParameterObject PersonalDetailReportContractSearchRequest searchRequest, Pageable pageable) {
        Page<PersonalDetailReportContractPageResponse> page =
            personalDetailReportContractService.selectReportContractPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }


    @Operation(summary = "협력업체 상세")
    @GetMapping(value = "/{contractSeq}")
    public ResponseEntity<PersonalDetailReportContractResponse> selectReportContract(
        @PathVariable Long contractSeq) {
        PersonalDetailReportContractResponse res =
            personalDetailReportContractService.selectReportContract(
                contractSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "상위업체 리스트 조회")
    @GetMapping(value = "/top-company/{companyGradeEnum}")
    public ResponseEntity<List<PersonalDetailContractCompanyResponse>> selectContractCompany(
        @PathVariable CompanyGradeEnum companyGradeEnum) {
        List<PersonalDetailContractCompanyResponse> res =
            personalDetailReportContractService.selectContractCompany(
                companyGradeEnum);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "협력업체 수정")
    @PutMapping(value = "/{contractSeq}")
    public ResponseEntity<PersonalDetailReportContractResponse> updateReportContract(
        @PathVariable Long contractSeq,
        @RequestBody PersonalDetailReportContractRequest request) {
        return ResponseEntity.ok(personalDetailReportContractService.updateReportContract(contractSeq, request));
    }

    @Operation(summary = "협력업체 안전보건 점검 체크리스트 조회")
    @GetMapping(value = "/health-check/{contractSeq}")
    public ResponseEntity<List<SafetyHealthCheckChecklistResponse>> selectSafetyHealthCheckChecklist(
        @PathVariable Long contractSeq) {
        List<SafetyHealthCheckChecklistResponse> res =
            personalDetailReportContractService.selectSafetyHealthCheckChecklist(
                contractSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "협력업체 안전보건점검 체크리스트 생성")
    @PostMapping(value = "/health-check")
    public ResponseEntity<List<SafetyHealthCheckChecklistResponse>> insertSafetyHealthCheckChecklist(
        @RequestBody List<SafetyHealthCheckChecklistRequest> requestList) {
        return ResponseEntity.ok(
            personalDetailReportContractService.insertSafetyHealthCheckChecklist(requestList));
    }

    @Operation(summary = "협력업체 안전보건점검 체크리스트 업데이트")
    @PutMapping(value = "/health-check")
    public ResponseEntity<List<SafetyHealthCheckChecklistResponse>> updateSafetyHealthCheckChecklist(
        @RequestBody List<SafetyHealthCheckChecklistRequest> requestList) {
        return ResponseEntity.ok(
            personalDetailReportContractService.updateSafetyHealthCheckChecklist(requestList));
    }

    @Operation(summary = "협력업체 안전보건점검 체크리스트 삭제")
    @DeleteMapping(value = "/health-check/{contractSeq}")
    public ResponseEntity<Integer> deleteSafetyHealthCheckChecklist(
        @PathVariable Long contractSeq) {
        return ResponseEntity.ok(
            personalDetailReportContractService.deleteSafetyHealthCheckChecklist(contractSeq));
    }

    @Operation(summary = "협력업체 평가대상 체크리스트 조회")
    @GetMapping(value = "/evaluation-check/{contractSeq}")
    public ResponseEntity<List<EvaluationTargetChecklistResponse>> selectEvaluationTargetChecklist(
        @PathVariable Long contractSeq) {
        List<EvaluationTargetChecklistResponse> res =
            personalDetailReportContractService.selectEvaluationTargetChecklist(
                contractSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "협력업체 평가대상 체크리스트 생성")
    @PostMapping(value = "/evaluation-check")
    public ResponseEntity<List<EvaluationTargetChecklistResponse>> insertEvaluationTargetChecklist(
        @RequestBody List<EvaluationTargetChecklistRequest> requestList) {
        return ResponseEntity.ok(
            personalDetailReportContractService.insertEvaluationTargetChecklist(requestList));
    }

    @Operation(summary = "협력업체 평가대상 체크리스트 업데이트")
    @PutMapping(value = "/evaluation-check")
    public ResponseEntity<List<EvaluationTargetChecklistResponse>> updateEvaluationTargetChecklist(
        @RequestBody List<EvaluationTargetChecklistRequest> requestList) {
        return ResponseEntity.ok(
            personalDetailReportContractService.updateEvaluationTargetChecklist(requestList));
    }

    @Operation(summary = "협력업체 평가대상 체크리스트 삭제")
    @DeleteMapping(value = "/evaluation-check/{contractSeq}")
    public ResponseEntity<Integer> deleteEvaluationTargetChecklist(
        @PathVariable Long contractSeq) {
        return ResponseEntity.ok(
            personalDetailReportContractService.deleteEvaluationTargetChecklist(contractSeq));
    }
}
