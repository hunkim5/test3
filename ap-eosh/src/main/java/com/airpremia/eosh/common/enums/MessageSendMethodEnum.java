package com.airpremia.eosh.common.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "MessageSendMethodEnum")
public enum MessageSendMethodEnum {
    EMAIL, SMS, FCM, SLACK;
}
