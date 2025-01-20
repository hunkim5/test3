package com.airpremia.eosh.education.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationSearchRequest {
    @Schema(description = "교육 분류 코드")
    private String educationClassificationCode;
    @Schema(description = "교육 날짜 시작")
    private LocalDate educationDtStart;
    @Schema(description = "교육 날짜 종료")
    private LocalDate educationDtEnd;
    @Schema(description = "주관 코드")
    private String inChargeCode;
    @Schema(description = "강사 아이디")
    private String userId;
}

