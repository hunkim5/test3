package com.airpremia.eosh.health.inventory.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.health.inventory.enums.ClassificationCodeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InventoryEntity {
    @Schema(description = "재고 시퀀스")
    private Long inventorySeq;
    @Schema(description = "구분 코드")
    private String divisionCode;
    @Schema(description = "분류 코드 Enum")
    private ClassificationCodeEnum classificationCodeEnum;
    @Schema(description = "직렬 번호")
    private String serialNo;
    @Schema(description = "최종 점검 날짜")
    private LocalDate finalCheckDt;
    @Schema(description = "등록 기호")
    private String registrationMark;
    @Schema(description = "메시지")
    private String message;
    @Schema(description = "수량")
    private Integer quantity;
    @Schema(description = "이월수량")
    private Integer carryOverQuantity;
    @Schema(description = "구입수량")
    private Integer buyQuantity;
    @Schema(description = "건강관리실 대분류")
    private String healthManageLargeCategory;
    @Schema(description = "규격")
    private String standard;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;
}
