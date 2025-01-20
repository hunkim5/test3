package com.airpremia.eosh.committee.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.committee.controller.request.MeetingResultRequest;
import com.airpremia.eosh.committee.enums.CommitteeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingResultDto {

    private Long meetingResultSeq;

    private Long meetingSeq;

    private CommitteeEnum committeeEnum;

    private String resultSubject;

    private String resultContent;

    private LocalDate deadlineProcessingDt;

    private String inchargeDepartmentCode;

    private String inchargeUserId;

    private String inchargeDepartmentName;

    private String inchargeUserName;

    private boolean deleteBool;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;


    public MeetingResultDto(MeetingResultRequest req) {
        this.meetingResultSeq = req.getMeetingResultSeq();
        this.meetingSeq = req.getMeetingSeq();
        this.committeeEnum = req.getCommitteeEnum();
        this.resultSubject = req.getResultSubject();
        this.resultContent = req.getResultContent();
        this.deadlineProcessingDt = req.getDeadlineProcessingDt();
        this.inchargeDepartmentCode = req.getInchargeDepartmentCode();
        this.inchargeUserId = req.getInchargeUserId();
        this.inchargeDepartmentName = req.getInchargeDepartmentName();
        this.inchargeUserName = req.getInchargeUserName();
        this.deleteBool = req.isDeleteBool();
    }
}

