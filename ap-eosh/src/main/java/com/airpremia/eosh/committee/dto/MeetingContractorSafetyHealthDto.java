package com.airpremia.eosh.committee.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.committee.controller.request.MeetingContractorSafetyHealthRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingContractorSafetyHealthDto {
    private Long meetingAttendUserSeq;
    private boolean contractorBool;
    private boolean safetyHealthActionBool;
    private boolean safetyAuthTargetProcBool;
    private String cleanInstallPlace;
    private String hazardProcShare;
    private String hireChangeEdu;
    private String regularSpecialEdu;
    private String managerEdu;
    private String managerRepairEdu;
    private String workRestAdjTime;
    private String workPlacePhoneBuild;
    private String disasterOccurrenceEvacuationMethod;
    private String interchangePhoneWork;
    private String workChangeEdu;
    private String regularSpecial;
    private String specialSafetyEdu;
    private String opinionComment;
    private String insertUserId;
    private String multipleFileUuid;
    private String pictureMultipleFileUuid;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public MeetingContractorSafetyHealthDto(MeetingContractorSafetyHealthRequest req) {
        this.meetingAttendUserSeq = req.getMeetingAttendUserSeq();
        this.contractorBool = req.isContractorBool();
        this.safetyHealthActionBool = req.isSafetyHealthActionBool();
        this.safetyAuthTargetProcBool = req.isSafetyAuthTargetProcBool();
        this.cleanInstallPlace = req.getCleanInstallPlace();
        this.hazardProcShare = req.getHazardProcShare();
        this.hireChangeEdu = req.getHireChangeEdu();
        this.regularSpecialEdu = req.getRegularSpecialEdu();
        this.managerEdu = req.getManagerEdu();
        this.managerRepairEdu = req.getManagerRepairEdu();
        this.workRestAdjTime = req.getWorkRestAdjTime();
        this.workPlacePhoneBuild = req.getWorkPlacePhoneBuild();
        this.disasterOccurrenceEvacuationMethod = req.getDisasterOccurrenceEvacuationMethod();
        this.interchangePhoneWork = req.getInterchangePhoneWork();
        this.workChangeEdu = req.getWorkChangeEdu();
        this.specialSafetyEdu = req.getSpecialSafetyEdu();
        this.opinionComment = req.getOpinionComment();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.pictureMultipleFileUuid = req.getPictureMultipleFileUuid();
    }

}

