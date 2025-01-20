package com.airpremia.eosh.components.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SendMessageResponse {
    @Schema(description = "전체 전송 수량")
    private int entireSendQuantity;
    @Schema(description = "성공 전송 수량")
    private int successSendQuantity;
    @Schema(description = "실패 전송 수량")
    private int failSendQuantity;
}
