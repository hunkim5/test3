package com.airpremia.eosh.personaldetail.health.controller;

import java.time.LocalDate;

import com.airpremia.eosh.common.controller.HrEmpResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@NoArgsConstructor
public class HealthResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "Hr 정보")
    private HrEmpResponse hrEmpResponse;
    @Schema(description = "실시간 보험공단자료")
    private RealTimePublicNormalExaminationResponse realTimePublicNormalExaminationResponse;
    @Schema(description = "사용자 일반검진")
    private UserNormalExaminationResponse userNormalExaminationResponse;
    @Schema(description = "사용자 특수검진")
    private UserSpecialExaminationResponse userSpecialExaminationResponse;
    @Schema(description = "사용자 우주방사선검진")
    private UserCosmicRadiationExaminationResponse userCosmicRadiationExaminationResponse;
    @Schema(description = "사용자 뇌심혈관검진")
    private UserCerebrocardiovascularExaminationResponse userCerebrocardiovascularExaminationResponse;
    @Schema(description = "스트레스 점수")
    private double stressScore;
    @Schema(description = "이름")
    private String empNm;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "사용자 입사일")
    private LocalDate hireYmd;
    @Schema(description = "사용자 생년월일")
    private LocalDate birthYmd;
    @Schema(description = "사용자 이메일")
    private String email;
    @Schema(description = "사용자 핸드폰번호")
    private String handphone;
    @Schema(description = "사번")
    private String empNo;

}

