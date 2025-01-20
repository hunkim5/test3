package com.airpremia.eosh.committee.controller.request;

import java.time.LocalDateTime;

import com.airpremia.eosh.committee.dto.MeetingAttendUserDto;
import com.airpremia.eosh.committee.enums.CommitteeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingAttendUserRequest {
    @Schema(description = "회의 참석 사용자 시퀀스")
    private Long meetingAttendUserSeq;
    @Schema(description = "회의 시퀀스")
    private Long meetingSeq;
    @Schema(description = "위원회 ENUM")
    private CommitteeEnum committeeEnum;
    @Schema(description = "외부 여부")
    private boolean externalBool;
    @Schema(description = "외부 업체 이름")
    private String externalCompanyName;
    @Schema(description = "회의 참석 사용자 아이디")
    private String meetingAttendUserId;
    @Schema(description = "회의 참석 사용자 이름")
    private String meetingAttendUserName;
    @Schema(description = "회의 참석 부서 아이디")
    private String meetingAttendDepartmentId;
    @Schema(description = "회의 참석 부서 이름")
    private String meetingAttendDepartmentName;
    @Schema(description = "직책")
    private String office;
    @Schema(description = "확인 여부")
    private boolean checkBool;
    @Schema(description = "확인 일시")
    private LocalDateTime checkDtm;
    @Schema(description = "위원회 구분 코드")
    private String committeeDivisionCode;

    public MeetingAttendUserRequest(MeetingAttendUserDto req) {
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
}

