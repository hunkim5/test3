package com.airpremia.eosh.health.inventory.dto;

import java.time.LocalDate;

import com.airpremia.eosh.health.inventory.enums.ClassificationCodeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventorySearchDto {
    private String divisionCode;
    private ClassificationCodeEnum classificationCodeEnum;
    private String serialNo;
    private LocalDate expirationStartDt;
    private LocalDate expirationEndDt;
    private LocalDate finalCheckStartDt;
    private LocalDate finalCheckEndDt;
    private String healthManageLargeCategory;
    private String registrationMark;
    private String standard;
    private Integer quantity;
    private String subClassificationCode;
    private String message;
}
