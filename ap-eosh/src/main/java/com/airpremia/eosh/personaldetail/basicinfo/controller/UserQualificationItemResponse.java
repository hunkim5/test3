package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.time.LocalDate;

import com.airpremia.eosh.personaldetail.basicinfo.dto.UserQualificationItemDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserQualificationItemResponse {
    @Schema(description = "사용자 자격 항목 시퀀스")
    private Long userQualificationItemSeq;
    @Schema(description = "자격 코드")
    private String qualificationCode;
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "자격 만료 날짜")
    private LocalDate qualificationExpirationDt;
    @Schema(description = "첨부 파일 UUID")
    private String attachFileUuid;

    public UserQualificationItemResponse(UserQualificationItemDto dto) {
        this.userQualificationItemSeq = dto.getUserQualificationItemSeq();
        this.attachFileUuid = dto.getAttachFileUuid();
        this.qualificationCode = dto.getQualificationCode();
        this.qualificationExpirationDt = dto.getQualificationExpirationDt();
        this.userSeq = dto.getUserSeq();
    }

    public UserQualificationItemResponse(UserQualificationItemRequest dto) {
        this.attachFileUuid = dto.getAttachFileUuid();
        this.qualificationCode = dto.getQualificationCode();
        this.qualificationExpirationDt = dto.getQualificationExpirationDt();
        this.userSeq = dto.getUserSeq();
    }
}

