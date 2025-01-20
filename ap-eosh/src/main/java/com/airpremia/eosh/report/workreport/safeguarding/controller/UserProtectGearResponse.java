package com.airpremia.eosh.report.workreport.safeguarding.controller;

import java.time.LocalDate;

import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.report.workreport.safeguarding.dto.UserProtectGearDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserProtectGearResponse {
    @Schema(description = "사용자 보호구 현황 시퀀스")
    private Long userProtectGearStatusSeq;
    @Schema(description = "보호구코드")
    private String protectGearCode;
    @Schema(description = "보호구세부 코드")
    private String protectGearDetailCode;
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
    @Schema(description = "서명여부")
    private boolean signatureBool;
    @Schema(description = "사용자이름")
    private String userNm;
    @Schema(description = "부서명")
    private String deptNm;

    public UserProtectGearResponse(UserProtectGearDto dto) {
        this.userProtectGearStatusSeq = dto.getUserProtectGearStatusSeq();
        this.protectGearCode = dto.getProtectGearCode();
        this.protectGearDetailCode = dto.getProtectGearDetailCode();
        this.quantity = dto.getQuantity();
        this.storageDepartmentCode = dto.getStorageDepartmentCode();
        this.manufacturingDt = dto.getManufacturingDt();
        this.disposalDt = dto.getDisposalDt();
        this.userId = dto.getUserId();
        this.signatureBool = dto.isSignatureBool();
    }

    public void setHrEmpInfo(HrEmpDto dto) {
        this.userId = dto.getEmpNo().substring(1, 7) + String.valueOf(dto.getBirthYmd()).replace("-", "");
        this.userNm = dto.getEmpNm();
        this.deptNm = dto.getDeptNm();
    }

    public void setUserUserProtectGearInfo(UserProtectGearDto dto) {
        this.manufacturingDt = dto.getManufacturingDt();
        this.disposalDt = dto.getDisposalDt();
        this.signatureBool = dto.isSignatureBool();
    }
}

