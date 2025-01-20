package com.airpremia.eosh.ca.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "SubscribeCaTargetEnum")
@Getter
@AllArgsConstructor
public enum SubscribeCaTargetEnum {
    ISSUE,
    FOQA;
}
