package com.airpremia.eosh.report.report.request.flightinformation;


import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportFlightInformationRequest {
    @Schema(description = "구독 운항 정보 UUID")
    private String subscribeFlightInformationUuid;
    @Schema(description = "운항 시퀀스")
    private Long flightSeq;
    @Schema(description = "발생 공항 코드")
    private String occurrenceAirportCode;
    @Schema(description = "출발지 공항 코드")
    private String originAirportCode;
    @Schema(description = "도착지 공항 코드")
    private String destinationAirportCode;
    @Schema(description = "회항지 공항 코드")
    private String divertAirportCode;
    @Schema(description = "항공기 형식 코드")
    private String aircraftTypeCode;
    @Schema(description = "항공기 등록 기호")
    private String aircraftRegistrationMark;
    @Schema(description = "승객 수량")
    private Long passengerQuantity;
    @Schema(description = "운항승무원 수량")
    private Long flightcrewQuantity;
    @Schema(description = "운항 단계 코드")
    private String flightPhaseCode;
    @Schema(description = "객실승무원 수량")
    private Long cabincrewQuantity;
    @Schema(description = "기타 수량")
    private Long etcQuantity;
    @Schema(description = "기타 수량 comment")
    private String etcComment;
    @Schema(description = "운항 날짜")
    private LocalDate flightDt;
    @Schema(description = "운항 날짜 ZONEID")
    private String flightDtZoneid;
    @Schema(description = "'운항번호'")
    private String flightNumber;
}
