package com.airpremia.eosh.committee.controller.request;

import com.airpremia.eosh.committee.enums.CommitteeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingExternalUserRequest {
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
    @Schema(description = "회의 참석 사용자 이름")
    private String meetingAttendUserName;
    @Schema(description = "회의 참석 부서 이름")
    private String meetingAttendDepartmentName;
    @Schema(description = "직책")
    private String office;
    @Schema(description = "도급업체 안전보건 조치")
    private MeetingContractorSafetyHealthRequest meetingContractorSafetyHealth;

}

