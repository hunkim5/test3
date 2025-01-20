package com.airpremia.eosh.health.healthdailylog.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.health.healthdailylog.dto.HealthDailyLogDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthDailyLogResponse {

    @Schema(description = "보건 '일지' 시퀀스")
    private Long healthDailyLogSeq;
    @Schema(description = "보건 일자")
    private LocalDate healthDt;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 이름")
    private String userName;
    @Schema(description = "부서 아이디")
    private String departmentId;
    @Schema(description = "부서 이름")
    private String departmentName;
    @Schema(description = "증상 내용")
    private String symptomsContent;
    @Schema(description = "기타 내용")
    private String etcContent;
    @Schema(description = "사용 제품 내용")
    private String useProductContent;
    @Schema(description = "사용 수량 comment")
    private String useQuantityComment;
    @Schema(description = "삭제 여부")
    private boolean deleteBool;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;
    @Schema(description = "년도별 검색 시작")
    private LocalDate searchFromDt;
    @Schema(description = "년도별 검색 끝")
    private LocalDate searchToDt;

    public HealthDailyLogResponse(HealthDailyLogDto req) {
        this.healthDailyLogSeq = req.getHealthDailyLogSeq();
        this.healthDt = req.getHealthDt();
        this.userId = req.getUserId();
        this.userName = req.getUserName();
        this.departmentId = req.getDepartmentId();
        this.departmentName = req.getDepartmentName();
        this.symptomsContent = req.getSymptomsContent();
        this.etcContent = req.getEtcContent();
        this.useProductContent = req.getUseProductContent();
        this.useQuantityComment = req.getUseQuantityComment();
        this.deleteBool = req.isDeleteBool();
        this.deleteUserId = req.getDeleteUserId();
        this.deleteDtm = req.getDeleteDtm();
        this.deleteIp = req.getDeleteIp();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
        this.searchFromDt = req.getSearchFromDt();
        this.searchToDt = req.getSearchToDt();
    }
}

