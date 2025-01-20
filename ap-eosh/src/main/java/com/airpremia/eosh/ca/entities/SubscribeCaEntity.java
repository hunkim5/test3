package com.airpremia.eosh.ca.entities;

import java.time.LocalDateTime;

import com.airpremia.eosh.ca.enums.SubscribeCaTargetEnum;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SubscribeCaEntity {
    private String subscribeCaUuid;
    private SubscribeCaTargetEnum subscribeCaTargetEnum;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
}
