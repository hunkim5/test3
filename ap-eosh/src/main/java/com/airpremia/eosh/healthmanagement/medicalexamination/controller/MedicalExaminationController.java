package com.airpremia.eosh.healthmanagement.medicalexamination.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpremia.eosh.healthmanagement.medicalexamination.service.MedicalExaminationService;
import com.airpremia.eosh.personaldetail.health.controller.UserCerebrocardiovascularExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserCerebrocardiovascularExaminationResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserNormalExaminationResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserNormalExaminationSearchRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserSpecialExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserSpecialExaminationResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/medical-examination")
@Tag(name = "건강검진관리")
@Slf4j
@RequiredArgsConstructor
public class MedicalExaminationController {
    private final MedicalExaminationService medicalExaminationService;

    @Operation(summary = "일반검진 페이지 검색")
    @GetMapping(value = "/user-normal-examination")
    public ResponseEntity<Page<UserNormalExaminationResponse>> selectUserNormalExaminationPage(
        @ParameterObject UserNormalExaminationSearchRequest searchRequest, Pageable pageable) {
        return ResponseEntity.ok(medicalExaminationService.selectUserNormalExaminationPage(searchRequest, pageable));
    }

    @Operation(summary = "특수검진 페이지 검색")
    @GetMapping(value = "/user-special-examination")
    public ResponseEntity<Page<UserSpecialExaminationResponse>> selectUserSpecialExaminationPage(
        @ParameterObject UserSpecialExaminationRequest searchRequest, Pageable pageable) {
        return ResponseEntity.ok(medicalExaminationService.selectUserSpecialExaminationPage(searchRequest, pageable));
    }

    @Operation(summary = "우주방사선 페이지 검색")
    @GetMapping(value = "/user-cosmic-radiation-examination")
    public ResponseEntity<Page<UserCosmicRadiationExaminationResponse>> selectUserCosmicRadiationExaminationPage(
        @ParameterObject UserCosmicRadiationExaminationRequest searchRequest, Pageable pageable) {
        return ResponseEntity.ok(
            medicalExaminationService.selectUserCosmicRadiationExaminationPage(searchRequest, pageable));
    }

    @Operation(summary = "뇌혈관 페이지 검색")
    @GetMapping(value = "/user-cerebrocardiovascular-examination")
    public ResponseEntity<Page<UserCerebrocardiovascularExaminationResponse>> selectUserCerebrocardiovascularExaminationPage(
        @ParameterObject UserCerebrocardiovascularExaminationRequest searchRequest, Pageable pageable) {
        return ResponseEntity.ok(
            medicalExaminationService.selectUserCerebrocardiovascularExaminationPage(searchRequest, pageable));
    }
}
