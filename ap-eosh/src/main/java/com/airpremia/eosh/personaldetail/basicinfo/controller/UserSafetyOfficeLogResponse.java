package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.dto.UserSafetyOfficeLogDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserSafetyOfficeLogResponse {
    @Schema(description = "사용자 안전 직책 로그 시퀀스")
    private Long userSafetyOfficeLogSeq;
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "안전 직책 분류 코드")
    private String safetyOfficeClassificationCode;
    @Schema(description = "임명 날짜")
    private LocalDate appointDt;
    @Schema(description = "해임 날짜")
    private LocalDate dismissDt;

    public UserSafetyOfficeLogResponse(UserSafetyOfficeLogRequest dto) {
        this.userSafetyOfficeLogSeq = dto.getUserSafetyOfficeLogSeq();
        this.userSeq = dto.getUserSeq();
        this.safetyOfficeClassificationCode = dto.getSafetyOfficeClassificationCode();
        this.appointDt = dto.getAppointDt();
        this.dismissDt = dto.getDismissDt();
    }

    public UserSafetyOfficeLogResponse(UserSafetyOfficeLogDto dto) {
        this.userSafetyOfficeLogSeq = dto.getUserSafetyOfficeLogSeq();
        this.userSeq = dto.getUserSeq();
        this.safetyOfficeClassificationCode = dto.getSafetyOfficeClassificationCode();
        this.appointDt = dto.getAppointDt();
        this.dismissDt = dto.getDismissDt();
    }
}

