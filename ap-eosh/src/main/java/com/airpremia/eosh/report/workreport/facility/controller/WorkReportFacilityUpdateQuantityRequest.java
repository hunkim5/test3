package com.airpremia.eosh.report.workreport.facility.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkReportFacilityUpdateQuantityRequest {
    @Schema(description = "설비 시퀀스")
    private Long facilitySeq;
    @Schema(description = "수량")
    private int quantity;
}

