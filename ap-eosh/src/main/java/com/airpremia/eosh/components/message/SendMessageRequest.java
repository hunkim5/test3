package com.airpremia.eosh.components.message;

import java.util.List;

import com.airpremia.eosh.common.enums.MessageSendMethodEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageRequest {
    @Schema(description = "메세지 전송 방법")
    private List<MessageSendMethodEnum> messageSendMethodList;
    @Schema(description = "메세지 수신자 empNo 리스트")
    private List<String> empNoList;
    @Schema(description = "메세지 수신자 deptCd 리스트")
    private List<String> deptCdList;
    @Schema(description = "메시지 제목")
    private String messageSubject;
    @Schema(description = "메시지 내용")
    private String messageContent;
    @Schema(description = "메시지 FCM 추가의 JSON")
    private String messageFcmExtraJson;
}
