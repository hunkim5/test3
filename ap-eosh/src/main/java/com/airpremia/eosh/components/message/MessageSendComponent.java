package com.airpremia.eosh.components.message;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import com.airpremia.eosh.common.enums.MessageSendMethodEnum;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageSendComponent {
    private final RestClient messageClient;
    private final UserTokenService userTokenService;

    @Transactional
    public SendMessageResponse sendMessage(
        @Schema(description = "메세지 전송 방법") List<MessageSendMethodEnum> messageSendMethodList,
        @Schema(description = "메세지 수신자 empNo 리스트") List<String> empNoList,
        @Schema(description = "메세지 수신자 deptCd 리스트") List<String> deptCdList,
        @Schema(description = "메시지 제목") String messageSubject,
        @Schema(description = "메시지 내용") String messageContent) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setMessageSendMethodList(messageSendMethodList);
        sendMessageRequest.setEmpNoList(empNoList);
        sendMessageRequest.setDeptCdList(deptCdList);
        sendMessageRequest.setMessageSubject(messageSubject);
        sendMessageRequest.setMessageContent(messageContent);


        return messageClient.post()
            .uri(uriBuilder -> uriBuilder.path("/send").build())
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(sendMessageRequest)
            .retrieve().body(new ParameterizedTypeReference<SendMessageResponse>() {
            });
    }
}
