package com.airpremia.eosh.health.inventory.response;

import java.time.LocalDate;

import com.airpremia.eosh.health.inventory.entities.InventoryContentEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryContentResponse {
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

    public InventoryContentResponse(InventoryContentEntity entity) {
        this.contentSeq = entity.getContentSeq();
        this.inventorySeq = entity.getInventorySeq();
        this.subClassificationCode = entity.getSubClassificationCode();
        this.subClassificationText = entity.getSubClassificationText();
        this.content = entity.getContent();
        this.contentText = entity.getContentText();
        this.quantity = entity.getQuantity();
        this.expirationDt = entity.getExpirationDt();
    }

}
