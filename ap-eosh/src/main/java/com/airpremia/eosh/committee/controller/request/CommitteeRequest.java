package com.airpremia.eosh.committee.controller.request;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommitteeRequest {
    @Schema(description = "회의 시퀀스")
    private Long meetingSeq;
    @Schema(description = "회의록 관리")
    private MeetingRequest meetingRequest;
    @Schema(description = "회의 안건 결과")
    private List<MeetingResultRequest> meetingResultRequestList;
    @Schema(description = "회의 안건 참석자")
    private List<MeetingAttendUserRequest> meetingAttendUserRequestList;
    @Schema(description = "회의 안건 외부 업체 참석자")
    private List<MeetingExternalUserRequest> meetingExternalUserRequestList;

    @Schema(description = "회의 안건 결과 삭제 리스트")
    private List<MeetingResultRequest> meetingResultRequestDeleteList;
    @Schema(description = "회의 안건 참석자 삭제 리스트")
    private List<MeetingAttendUserRequest> meetingAttendUserRequestDeleteList;
    @Schema(description = "회의 안건 외부 업체 참석자 삭제 리스트")
    private List<MeetingExternalUserRequest> meetingExternalUserRequestDeleteList;
}

