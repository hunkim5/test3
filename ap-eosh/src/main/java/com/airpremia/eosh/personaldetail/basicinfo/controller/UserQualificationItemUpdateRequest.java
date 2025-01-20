package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserQualificationItemUpdateRequest {
    @Schema(description = "첨부 파일 UUID")
    private String attachFileUuid;
    @Schema(description = "자격 코드")
    private String qualificationCode;
    @Schema(description = "자격 만료 날짜")
    private LocalDate qualificationExpirationDt;
    @Schema(description = "사용자 아이디")
    private String userId;
}

