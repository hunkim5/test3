package com.airpremia.eosh.education.controller;

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

import com.airpremia.eosh.education.service.EducationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/education")
@Tag(name = "교육")
@Slf4j
@AllArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @Operation(summary = "교육 상세 등록")
    @PostMapping
    public ResponseEntity<Long> insertEducationDetail(@RequestBody EducationRequest request) {
        return ResponseEntity.ok(educationService.insertEducationDetail(request));
    }

    @Operation(summary = "교육 상세 수정")
    @PutMapping("/{educationSeq}")
    public ResponseEntity<Long> updateEducationDetail(
        @PathVariable Long educationSeq, @RequestBody EducationRequest request) {
        return ResponseEntity.ok(educationService.updateEducationDetail(educationSeq, request));
    }

    @Operation(summary = "교육 상세")
    @GetMapping(value = "/{educationSeq}")
    public ResponseEntity<EducationResponse> selectEducation(
        @PathVariable Long educationSeq) {
        EducationResponse res =
            educationService.selectEducation(
                educationSeq);
        return ResponseEntity.ok(res);
    }

    @Operation(summary = "교육 강사 저장")
    @PutMapping("/education-instructor/{educationSeq}")
    public ResponseEntity<Integer> saveEducationInstructors(
        @PathVariable Long educationSeq, @RequestBody List<EducationInstructorRequest> request) {
        return ResponseEntity.ok(educationService.saveEducationInstructors(educationSeq, request));
    }

    @Operation(summary = "교육 강사 삭제")
    @DeleteMapping("/education-instructor")
    public ResponseEntity<Integer> delEducationInstructors(
        @RequestBody List<Long> educationInstructorSeqs) {
        return ResponseEntity.ok(educationService.delEducationInstructors(educationInstructorSeqs));
    }

    @Operation(summary = "교육 대상자 저장")
    @PostMapping("/education-attend-user/{educationSeq}")
    public ResponseEntity<Integer> insertEducationAttendUsers(
        @PathVariable Long educationSeq, @RequestBody List<EducationAttendUserRequest> request) {
        return ResponseEntity.ok(educationService.insertEducationAttendUsers(educationSeq, request));
    }

    @Operation(summary = "교육 대상자 삭제")
    @DeleteMapping("/education-attend-user")
    public ResponseEntity<Integer> delEducationAttendUsers(
        @RequestBody List<EducationAttendUserRequest> deleteEducationAttendUsers) {
        return ResponseEntity.ok(educationService.delEducationAttendUsers(deleteEducationAttendUsers));
    }

    @Operation(summary = "교육 페이지 검색")
    @GetMapping()
    public ResponseEntity<Page<EducationListResponse>> selectEducation(
        @ParameterObject EducationSearchRequest searchRequest, Pageable pageable) {
        Page<EducationListResponse> page =
            educationService.selectEducationPage(searchRequest, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "교육 삭제")
    @DeleteMapping(value = "/{educationSeq}")
    public ResponseEntity<Integer> deleteEducation(
        @PathVariable Long educationSeq) {
        return ResponseEntity.ok(
            educationService.deleteEducation(
                educationSeq));
    }

    @Operation(summary = "교육 강사 가지 평가 등록")
    @PostMapping("/self-evaluation/{educationSeq}")
    public ResponseEntity<Integer> insertInstructorSelfEvaluation(
        @PathVariable Long educationSeq, @RequestBody SaveInstructorSelfEvaluationPaperRequest request) {
        return ResponseEntity.ok(educationService.insertInstructorSelfEvaluation(educationSeq, request));
    }

    @Operation(summary = "교육 강사 자기 평가 수정")
    @PutMapping("/self-evaluation/{educationSeq}")
    public ResponseEntity<Integer> updateInstructorSelfEvaluation(
        @PathVariable Long educationSeq, @RequestBody SaveInstructorSelfEvaluationPaperRequest request) {
        return ResponseEntity.ok(educationService.updateInstructorSelfEvaluation(educationSeq, request));
    }

    @Operation(summary = "교육 강사 자기 평가 조회")
    @GetMapping("/self-evaluation/{educationInstructorSeq}")
    public ResponseEntity<List<InstructorSelfEvaluationPaperResponse>> selectInstructorSelfEvaluationPaperAnswer(
        @PathVariable Long educationInstructorSeq) {
        return ResponseEntity.ok(educationService.selectInstructorSelfEvaluationPaperAnswer(educationInstructorSeq));
    }

    @Operation(summary = "과정 평가서 등록")
    @PostMapping("/course-survey")
    public ResponseEntity<Integer> insertCourseSurvey(
        @RequestBody List<CourseSurveyRequest> requestList) {
        return ResponseEntity.ok(educationService.insertCourseSurvey(requestList));
    }

    @Operation(summary = "과정 평가서 수정")
    @PutMapping("/course-survey")
    public ResponseEntity<Integer> updateCourseSurvey(
        @RequestBody List<CourseSurveyRequest> requestList) {
        return ResponseEntity.ok(educationService.updateCourseSurvey(requestList));
    }

    @Operation(summary = "과정 평가서 조회")
    @GetMapping("/course-survey/{educationAttendUserSeq}")
    public ResponseEntity<List<CourseSurveyResponse>> selectCourseSurveyAnswer(
        @PathVariable Long educationAttendUserSeq) {
        return ResponseEntity.ok(educationService.selectCourseSurveyAnswer(educationAttendUserSeq));
    }

    @Operation(summary = "강사 평가서 등록")
    @PostMapping("/instructor-evaluation/{educationSeq}")
    public ResponseEntity<Integer> insertInstructorEvaluation(
        @PathVariable Long educationSeq, @RequestBody SaveInstructorEvaluationRequest request) {
        return ResponseEntity.ok(educationService.insertInstructorEvaluation(educationSeq, request));
    }

    @Operation(summary = "강사 평가서 수정")
    @PutMapping("/instructor-evaluation/{educationSeq}")
    public ResponseEntity<Integer> updateInstructorEvaluation(
        @PathVariable Long educationSeq, @RequestBody SaveInstructorEvaluationRequest request) {
        return ResponseEntity.ok(educationService.updateInstructorEvaluation(educationSeq, request));
    }

    @Operation(summary = "강사 평가서 조회")
    @GetMapping("/instructor-evaluation/{educationSeq}/{educationAttendUserSeq}")
    public ResponseEntity<List<InstructorEvaluationResponse>> selectInstructorEvaluationAnswer(
        @PathVariable Long educationSeq, @PathVariable Long educationAttendUserSeq) {
        return ResponseEntity.ok(educationService.selectInstructorEvaluationAnswer(educationSeq, educationAttendUserSeq));
    }

}
