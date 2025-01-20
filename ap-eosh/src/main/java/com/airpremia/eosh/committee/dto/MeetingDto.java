package com.airpremia.eosh.committee.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.committee.controller.request.MeetingRequest;
import com.airpremia.eosh.committee.controller.response.MeetingResponse;
import com.airpremia.eosh.committee.enums.CommitteeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingDto {
    private Long meetingSeq;
    private CommitteeEnum committeeEnum;
    private String representativeMeetingUserName;
    private LocalDate meetingDt;
    private LocalDate meetingCheckDt;
    private String meetingSubject;
    private String meetingContent;
    private String meetingLocationComment;
    private String attachMultipleFileUuid;
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

    public MeetingDto(MeetingRequest req) {
        this.meetingSeq = req.getMeetingSeq();
        this.committeeEnum = req.getCommitteeEnum();
        this.representativeMeetingUserName = req.getRepresentativeMeetingUserName();
        this.meetingDt = req.getMeetingDt();
        this.meetingCheckDt = req.getMeetingCheckDt();
        this.meetingSubject = req.getMeetingSubject();
        this.meetingContent = req.getMeetingContent();
        this.meetingLocationComment = req.getMeetingLocationComment();
        this.attachMultipleFileUuid = req.getAttachMultipleFileUuid();
        this.deleteBool = req.isDeleteBool();
        this.deleteUserId = req.getDeleteUserId();
        this.deleteDtm = req.getDeleteDtm();
        this.deleteIp = req.getDeleteIp();
    }

    public MeetingResponse convertMeetingResponse() {
        MeetingResponse res = new MeetingResponse();
        res.setMeetingSeq(this.meetingSeq);
        res.setCommitteeEnum(this.committeeEnum);
        res.setRepresentativeMeetingUserName(this.representativeMeetingUserName);
        res.setMeetingDt(this.meetingDt);
        res.setMeetingCheckDt(this.meetingCheckDt);
        res.setMeetingSubject(this.meetingSubject);
        res.setMeetingContent(this.meetingContent);
        res.setMeetingLocationComment(this.meetingLocationComment);
        res.setAttachMultipleFileUuid(this.attachMultipleFileUuid);
        res.setDeleteBool(this.deleteBool);
        res.setDeleteUserId(this.deleteUserId);
        res.setDeleteDtm(this.deleteDtm);
        res.setDeleteIp(this.deleteIp);
        return res;
    }
}

