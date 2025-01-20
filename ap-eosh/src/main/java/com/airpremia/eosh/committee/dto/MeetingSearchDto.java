package com.airpremia.eosh.committee.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.committee.enums.CommitteeEnum;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MeetingSearchDto {

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

}

