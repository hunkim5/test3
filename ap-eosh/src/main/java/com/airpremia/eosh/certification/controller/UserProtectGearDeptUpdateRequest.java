package com.airpremia.eosh.certification.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProtectGearDeptUpdateRequest {
    @Schema(description = "사용자 보호구 현황 시퀀스")
    private Long userProtectGearStatusSeq;
    @Schema(description = "보호구 코드")
    private String protectGearCode;
    @Schema(description = "수량")
    private int quantity;
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
    @Schema(description = "부서명")
    private String departmentName;
    @Schema(description = "서명여부")
    private boolean signatureBool;
}
