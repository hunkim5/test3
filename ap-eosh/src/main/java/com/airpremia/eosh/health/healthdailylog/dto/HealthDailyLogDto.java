package com.airpremia.eosh.health.healthdailylog.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.health.healthdailylog.controller.HealthDailyLogRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthDailyLogDto {

    private Long healthDailyLogSeq;
    private LocalDate healthDt;
    private String userId;
    private String userName;
    private String departmentId;
    private String departmentName;
    private String symptomsContent;
    private String etcContent;
    private String useProductContent;
    private String useQuantityComment;
    private boolean deleteBool;
    private String deleteUserId;
    private LocalDateTime deleteDtm;
    private String deleteIp;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
    private LocalDate searchFromDt;
    private LocalDate searchToDt;


    public HealthDailyLogDto(HealthDailyLogRequest req) {
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

