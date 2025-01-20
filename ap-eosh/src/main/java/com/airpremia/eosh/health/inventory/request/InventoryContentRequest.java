package com.airpremia.eosh.health.inventory.request;

import java.time.LocalDate;

import com.airpremia.eosh.health.inventory.entities.InventoryContentEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InventoryContentRequest {
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

    public InventoryContentEntity toEntity() {
        InventoryContentEntity entity = new InventoryContentEntity();
        entity.setContentSeq(this.getContentSeq());
        entity.setInventorySeq(this.getInventorySeq());
        entity.setSubClassificationCode(this.getSubClassificationCode());
        entity.setSubClassificationText(this.getSubClassificationText());
        entity.setContent(this.getContent());
        entity.setContentText(this.getContentText());
        entity.setQuantity(this.getQuantity());
        entity.setExpirationDt(this.getExpirationDt());
        return entity;
    }
}

