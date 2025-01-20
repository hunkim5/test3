package com.airpremia.eosh.health.inventory.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryContentEntity {
    @Schema(description = "내용물 시퀀스")
    private Long contentSeq;
    @Schema(description = "재고 시퀀스")
    private Long inventorySeq;
    @Schema(description = "소분류 코드")
    private String subClassificationCode;
    @Schema(description = "소분류 text")
    private String subClassificationText;
    @Schema(description = "내용물 코드")
    private String content;
    @Schema(description = "내용물 text")
    private String contentText;
    @Schema(description = "수량")
    private int quantity;
    @Schema(description = "만료 날짜")
    private LocalDate expirationDt;
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
