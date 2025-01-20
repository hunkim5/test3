package com.airpremia.eosh.committee.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.committee.controller.request.MeetingAttendUserRequest;
import com.airpremia.eosh.committee.controller.request.MeetingExternalUserRequest;
import com.airpremia.eosh.committee.enums.CommitteeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingAttendUserDto {

    private Long meetingAttendUserSeq;

    private Long meetingSeq;

    private CommitteeEnum committeeEnum;

    private boolean externalBool;

    private String externalCompanyName;

    private String meetingAttendUserId;

    private String meetingAttendUserName;

    private String meetingAttendDepartmentId;

    private String meetingAttendDepartmentName;

    private String office;

    private boolean checkBool;

    private LocalDateTime checkDtm;

    private String committeeDivisionCode;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public MeetingAttendUserDto(MeetingAttendUserRequest req) {
        this.meetingAttendUserSeq = req.getMeetingAttendUserSeq();
        this.meetingSeq = req.getMeetingSeq();
        this.committeeEnum = req.getCommitteeEnum();
        this.externalBool = req.isExternalBool();
        this.externalCompanyName = req.getExternalCompanyName();
        this.meetingAttendUserId = req.getMeetingAttendUserId();
        this.meetingAttendUserName = req.getMeetingAttendUserName();
        this.meetingAttendDepartmentId = req.getMeetingAttendDepartmentId();
        this.meetingAttendDepartmentName = req.getMeetingAttendDepartmentName();
        this.office = req.getOffice();
        this.checkBool = req.isCheckBool();
        this.checkDtm = req.getCheckDtm();
        this.committeeDivisionCode = req.getCommitteeDivisionCode();
    }

    public MeetingAttendUserDto(MeetingExternalUserRequest req) {
        this.meetingAttendUserSeq = req.getMeetingAttendUserSeq();
        this.meetingSeq = req.getMeetingSeq();
        this.committeeEnum = req.getCommitteeEnum();
        this.externalBool = req.isExternalBool();
        this.externalCompanyName = req.getExternalCompanyName();
        this.meetingAttendUserName = req.getMeetingAttendUserName();
        this.meetingAttendDepartmentName = req.getMeetingAttendDepartmentName();
        this.office = req.getOffice();
    }

}

