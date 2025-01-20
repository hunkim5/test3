package com.airpremia.eosh.health.healthcounselresult.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.authoritymanagement.user.enums.Sex;
import com.airpremia.eosh.health.healthcounselresult.controller.UserHealthCounselResultRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserHealthCounselResultDto {

    private Long userHealthCounselResultSeq;
    private Long userHealthCounselReservationSeq;
    private LocalDate counselDt;
    private String inchargeUserId;
    private String inchargeUserName;
    private String inchargeDepartmentId;
    private String inchargeDepartmentName;
    private String counselTargetUserId;
    private String counselTargetUserName;
    private String counselTargetDepartmentId;
    private String counselTargetDepartmentName;
    private LocalDate birthDt;
    private Sex sex;
    private LocalDate hireDt;
    private boolean shiftBool;
    private String contact;
    private boolean normalSpecialBool;
    private LocalDate examinationDt;
    private String hazardAgent;
    private String healthDivision;
    private String examinationComment;
    private String postmortemManageComment;
    private boolean workPerformSuitableBool;
    private String etc;
    private String pastHistrory;
    private String specialNote;
    private String height;
    private int weight;
    private int bmi;
    private String bloodpressure;
    private String drinking;
    private String smoking;
    private String exercise;
    private String sleep;
    private String counselContent;
    private String check;
    private String multipleFileUuid;
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

    public UserHealthCounselResultDto(UserHealthCounselResultRequest req) {
        this.userHealthCounselResultSeq = req.getUserHealthCounselResultSeq();
        this.userHealthCounselReservationSeq = req.getUserHealthCounselReservationSeq();
        this.counselDt = req.getCounselDt();
        this.inchargeUserId = req.getInchargeUserId();
        this.inchargeUserName = req.getInchargeUserName();
        this.inchargeDepartmentId = req.getInchargeDepartmentId();
        this.inchargeDepartmentName = req.getInchargeDepartmentName();
        this.counselTargetUserId = req.getCounselTargetUserId();
        this.counselTargetUserName = req.getCounselTargetUserName();
        this.counselTargetDepartmentId = req.getCounselTargetDepartmentId();
        this.counselTargetDepartmentName = req.getCounselTargetDepartmentName();
        this.birthDt = req.getBirthDt();
        this.sex = req.getSex();
        this.hireDt = req.getHireDt();
        this.shiftBool = req.isShiftBool();
        this.contact = req.getContact();
        this.normalSpecialBool = req.isNormalSpecialBool();
        this.examinationDt = req.getExaminationDt();
        this.hazardAgent = req.getHazardAgent();
        this.healthDivision = req.getHealthDivision();
        this.examinationComment = req.getExaminationComment();
        this.postmortemManageComment = req.getPostmortemManageComment();
        this.workPerformSuitableBool = req.isWorkPerformSuitableBool();
        this.etc = req.getEtc();
        this.pastHistrory = req.getPastHistrory();
        this.specialNote = req.getSpecialNote();
        this.height = req.getHeight();
        this.weight = req.getWeight();
        this.bmi = req.getBmi();
        this.bloodpressure = req.getBloodpressure();
        this.drinking = req.getDrinking();
        this.smoking = req.getSmoking();
        this.exercise = req.getExercise();
        this.sleep = req.getSleep();
        this.counselContent = req.getCounselContent();
        this.check = req.getCheck();
        this.multipleFileUuid = req.getMultipleFileUuid();
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
    }
}
