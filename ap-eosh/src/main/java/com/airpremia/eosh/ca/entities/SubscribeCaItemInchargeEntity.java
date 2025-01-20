package com.airpremia.eosh.ca.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SubscribeCaItemInchargeEntity {
    private Long subscribeCaItemInchargeSeq;
    private String subscribeCaUuid;
    private Long subscribeCaItemSeq;
    private boolean mainBool = false;
    private String inchargeUserId;
    private String inchargeUserName;
    private String inchargeDepartmentId;
    private String inchargeDepartmentName;
    private String remarkContent;
    private boolean deleteBool = false;
    private String deleteUserId;
    private LocalDateTime deleteDtm;
    private String deleteIp;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
}
