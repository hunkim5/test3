package com.airpremia.eosh.committee.controller.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommitteeResponse {
    @Schema(description = "회의 시퀀스")
    private Long meetingSeq;
    @Schema(description = "회의록 관리")
    private MeetingResponse meetingResponse;
    @Schema(description = "회의 안건 결과")
    private List<MeetingResultResponse> meetingResultResponseList;
    @Schema(description = "회의 안건 참석자")
    private List<MeetingAttendUserResponse> meetingAttendUserResponseList;
    @Schema(description = "회의 안건 외부 업체 참석자")
    private List<MeetingExternalUserResponse> meetingExternalUserRequestList;
}

