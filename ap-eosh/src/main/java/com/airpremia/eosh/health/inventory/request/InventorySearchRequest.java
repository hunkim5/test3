package com.airpremia.eosh.health.inventory.request;

import java.time.LocalDate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.airpremia.eosh.health.inventory.dto.InventorySearchDto;
import com.airpremia.eosh.health.inventory.enums.ClassificationCodeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventorySearchRequest {
    @Schema(description = "구분 코드")
    private String divisionCode;
    @Schema(description = "분류 코드 Enum")
    private ClassificationCodeEnum classificationCodeEnum;
    @Schema(description = "직렬 번호")
    private String serialNo;
    @Schema(description = "만료일 시작 날짜")
    private LocalDate expirationStartDt;
    @Schema(description = "만료일 끝 날짜")
    private LocalDate expirationEndDt;
    @Schema(description = "최종 점검 시작 날짜")
    private LocalDate finalCheckStartDt;
    @Schema(description = "최종 점검 끝 날짜")
    private LocalDate finalCheckEndDt;
    @Schema(description = "건강관리실 대분류")
    private String healthManageLargeCategory;
    @Schema(description = "등록 기호")
    private String registrationMark;
    @Schema(description = "규격")
    private String standard;
    @Schema(description = "수량")
    private Integer quantity;
    @Schema(description = "내용물 검색 코드")
    private String subClassificationCode;
    @Schema(description = "메세지")
    private String message;

    @Schema(description = "Sort 처리")
    Sort sort = Sort.unsorted();
    @Schema(description = "페이징처리 n번째 0부터시작", example = "0")
    Integer page = 0;
    @Schema(description = "페이징의 사이즈(row 의 개수)", example = "20")
    Integer size = 20;

    public Pageable getPageable() {
        return PageRequest.of(page, size, sort);
    }

    public InventorySearchDto toDto() {
        InventorySearchDto dto = new InventorySearchDto();
        dto.setDivisionCode(this.getDivisionCode());
        dto.setClassificationCodeEnum(this.getClassificationCodeEnum());
        dto.setSerialNo(concat(this.getSerialNo()));
        dto.setExpirationStartDt(this.getExpirationStartDt());
        dto.setExpirationEndDt(this.getExpirationEndDt());
        dto.setFinalCheckStartDt(this.getFinalCheckStartDt());
        dto.setFinalCheckEndDt(this.getFinalCheckEndDt());
        dto.setHealthManageLargeCategory(concat(this.getHealthManageLargeCategory()));
        dto.setRegistrationMark(this.getRegistrationMark());
        dto.setStandard(this.getStandard());
        dto.setQuantity(this.getQuantity());
        dto.setSubClassificationCode(this.getSubClassificationCode());
        dto.setMessage(concat(this.getMessage()));
        return dto;
    }

    private String concat(String str) {
        return str != null && !str.trim().isEmpty() ? "%" + str.trim() + "%" : null;
    }
}
