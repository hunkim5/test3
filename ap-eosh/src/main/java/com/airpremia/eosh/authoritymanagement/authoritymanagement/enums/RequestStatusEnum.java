package com.airpremia.eosh.authoritymanagement.authoritymanagement.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "요청레벨")
@Getter
@AllArgsConstructor
public enum RequestStatusEnum {
    DRAFT, REQUEST, APPROVAL, REJECT
}
