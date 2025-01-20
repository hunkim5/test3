package com.airpremia.eosh.authoritymanagement.user.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "사용자 상태 ENUM")
public enum UserStatusEnum {
    ACTIVE, INACTIVE;
}
