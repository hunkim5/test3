package com.airpremia.eosh.ca.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "CapAcceptableEnum")
@Getter
@AllArgsConstructor
public enum CapAcceptableEnum {
    UNWRITTEN,
    ACCEPTABLE,
    UNACCEPTABLE;
}
