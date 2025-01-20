package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserQualificationItemInsertResponse {
    @Schema(description = "첨부 파일 UUID")
    private String attachFileUuid;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "자격 코드")
    private String qualificationCode;
    @Schema(description = "자격 만료 날짜")
    private LocalDate qualificationExpirationDt;
    @Schema(description = "사용자 아이디")
    private String userId;
}

