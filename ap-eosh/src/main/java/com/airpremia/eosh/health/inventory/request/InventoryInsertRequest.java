package com.airpremia.eosh.health.inventory.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airpremia.eosh.health.inventory.entities.InventoryEntity;
import com.airpremia.eosh.health.inventory.enums.ClassificationCodeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryInsertRequest {
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
    private int quantity;
    @Schema(description = "이월수량")
    private Integer carryOverQuantity;
    @Schema(description = "구입수량")
    private Integer buyQuantity;
    @Schema(description = "건강관리실 대분류")
    private String healthManageLargeCategory;
    @Schema(description = "규격")
    private String standard;
    @Schema(description = "내용물 리스트")
    private List<InventoryContentRequest> inventoryContentList = new ArrayList<>();

    public InventoryEntity toEntity() {
        InventoryEntity entity = new InventoryEntity();
        entity.setInventorySeq(this.getInventorySeq());
        entity.setDivisionCode(this.getDivisionCode());
        entity.setClassificationCodeEnum(this.getClassificationCodeEnum());
        entity.setSerialNo(this.getSerialNo());
        entity.setFinalCheckDt(this.getFinalCheckDt());
        entity.setRegistrationMark(this.getRegistrationMark());
        entity.setMessage(this.getMessage());
        entity.setQuantity(this.getQuantity());
        entity.setCarryOverQuantity(this.getCarryOverQuantity());
        entity.setBuyQuantity(this.getBuyQuantity());
        entity.setHealthManageLargeCategory(this.getHealthManageLargeCategory());
        entity.setStandard(this.getStandard());
        return entity;
    }
}
