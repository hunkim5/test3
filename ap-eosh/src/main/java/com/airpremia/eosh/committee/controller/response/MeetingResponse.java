package com.airpremia.eosh.committee.controller.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.committee.controller.request.MeetingRequest;
import com.airpremia.eosh.committee.dto.MeetingDto;
import com.airpremia.eosh.committee.enums.CommitteeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingResponse {
    @Schema(description = "회의 시퀀스")
    private Long meetingSeq;
    @Schema(description = "위원회 ENUM")
    private CommitteeEnum committeeEnum;
    @Schema(description = "대표 회의 사용자 이름")
    private String representativeMeetingUserName;
    @Schema(description = "회의 날짜")
    private LocalDate meetingDt;
    @Schema(description = "회의 확인 날짜")
    private LocalDate meetingCheckDt;
    @Schema(description = "회의 제목")
    private String meetingSubject;
    @Schema(description = "회의 내용")
    private String meetingContent;
    @Schema(description = "회의 장소 comment")
    private String meetingLocationComment;
    @Schema(description = "첨부 다중 파일 UUID")
    private String attachMultipleFileUuid;
    @Schema(description = "삭제 여부")
    private boolean deleteBool;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;

    public MeetingResponse(MeetingRequest data) {
        this.meetingSeq = data.getMeetingSeq();
        this.committeeEnum = data.getCommitteeEnum();
        this.representativeMeetingUserName = data.getRepresentativeMeetingUserName();
        this.meetingDt = data.getMeetingDt();
        this.meetingCheckDt = data.getMeetingCheckDt();
        this.meetingSubject = data.getMeetingSubject();
        this.meetingContent = data.getMeetingContent();
        this.meetingLocationComment = data.getMeetingLocationComment();
        this.attachMultipleFileUuid = data.getAttachMultipleFileUuid();
        this.deleteBool = data.isDeleteBool();
        this.deleteUserId = data.getDeleteUserId();
        this.deleteDtm = data.getDeleteDtm();
        this.deleteIp = data.getDeleteIp();
    }

    public MeetingResponse(MeetingDto data) {
        this.meetingSeq = data.getMeetingSeq();
        this.committeeEnum = data.getCommitteeEnum();
        this.representativeMeetingUserName = data.getRepresentativeMeetingUserName();
        this.meetingDt = data.getMeetingDt();
        this.meetingCheckDt = data.getMeetingCheckDt();
        this.meetingSubject = data.getMeetingSubject();
        this.meetingContent = data.getMeetingContent();
        this.meetingLocationComment = data.getMeetingLocationComment();
        this.attachMultipleFileUuid = data.getAttachMultipleFileUuid();
        this.deleteBool = data.isDeleteBool();
        this.deleteUserId = data.getDeleteUserId();
        this.deleteDtm = data.getDeleteDtm();
        this.deleteIp = data.getDeleteIp();
    }
}

