package com.airpremia.eosh.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthObjectDto {
    String userId;
    String userPsswrd;
    String fcmToken;
    Boolean isRemember = false;
    String refreshToken;
    String thirdPartyTokenType;
    String thirdPartyAccessToken;
    Long endUserSeq;
}
