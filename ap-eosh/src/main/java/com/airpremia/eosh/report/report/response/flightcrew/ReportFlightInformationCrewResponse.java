package com.airpremia.eosh.report.report.response.flightcrew;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportFlightInformationCrewResponse {
    @Schema(description = "구독 운항 정보 승무원 시퀀스")
    private Long subscribeFlightInformationCrewSeq;
    @Schema(description = "구독 운항 정보 UUID")
    private String subscribeFlightInformationUuid;
    @Schema(description = "승무원 직책 코드")
    private String crewOfficeCode;
    @Schema(description = "승무원 분류 코드")
    private String crewClassificationCode;
    @Schema(description = "승무원 포지션 코드")
    private String crewPositionCode;
    @Schema(description = "승무원 임무 코드")
    private String crewDutyCode;
    @Schema(description = "승무원 사용자 이름")
    private String crewUserName;
    @Schema(description = "승무원 사용자 아이디")
    private String crewUserId;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
}
