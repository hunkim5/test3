package com.airpremia.eosh.report.workreport.safeguarding.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProtectiondeviceRequest {
    @Schema(description = "사용자 방호장치 현황 시퀀스")
    private Long userProtectiondeviceStatusSeq;
    @Schema(description = "안전방호코드")
    private String safeguardingCode;
    @Schema(description = "수량")
    private int quantity;
    @Schema(description = "기존 수량")
    private int originalQuantity;
    @Schema(description = "보관 부서 코드")
    private String storageDepartmentCode;
    @Schema(description = "제조날짜")
    private LocalDate manufacturingDt;
    @Schema(description = "폐기날짜")
    private LocalDate disposalDt;
    @Schema(description = "사용자아이디")
    private String userId;
    @Schema(description = "사용자이름")
    private String userName;
    @Schema(description = "부서이름")
    private String departmentName;
    @Schema(description = "서명여부")
    private boolean signatureBool;

}

