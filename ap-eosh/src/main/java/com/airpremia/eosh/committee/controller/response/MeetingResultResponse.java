package com.airpremia.eosh.committee.controller.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.committee.dto.MeetingResultDto;
import com.airpremia.eosh.committee.enums.CommitteeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingResultResponse {
    @Schema(description = "회의 결과 시퀀스")
    private Long meetingResultSeq;
    @Schema(description = "회의 시퀀스")
    private Long meetingSeq;
    @Schema(description = "위원회 ENUM")
    private CommitteeEnum committeeEnum;
    @Schema(description = "결과 제목")
    private String resultSubject;
    @Schema(description = "결과 내용")
    private String resultContent;
    @Schema(description = "마감 처리 날짜")
    private LocalDate deadlineProcessingDt;
    @Schema(description = "담당 부서 코드")
    private String inchargeDepartmentCode;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "담당 사용자 이름")
    private String inchargeUserName;
    @Schema(description = "삭제 여부")
    private boolean deleteBool;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;

    public MeetingResultResponse(MeetingResultDto dto) {
        this.meetingResultSeq = dto.getMeetingResultSeq();
        this.meetingSeq = dto.getMeetingSeq();
        this.committeeEnum = dto.getCommitteeEnum();
        this.resultSubject = dto.getResultSubject();
        this.resultContent = dto.getResultContent();
        this.deadlineProcessingDt = dto.getDeadlineProcessingDt();
        this.inchargeDepartmentCode = dto.getInchargeDepartmentCode();
        this.inchargeUserId = dto.getInchargeUserId();
        this.inchargeDepartmentName = dto.getInchargeDepartmentName();
        this.inchargeUserName = dto.getInchargeUserName();
        this.deleteBool = dto.isDeleteBool();
    }
}

