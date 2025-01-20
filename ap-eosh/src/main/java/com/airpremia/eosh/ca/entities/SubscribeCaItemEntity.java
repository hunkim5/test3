package com.airpremia.eosh.ca.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.ca.enums.CaAppvalprcEnum;
import com.airpremia.eosh.ca.request.ca.SubscribeCaItemRequest;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SubscribeCaItemEntity {
    private Long subscribeCaItemSeq;
    private String subscribeCaUuid;
    private String caId;
    private CaAppvalprcEnum caAppvalprcEnum;
    private String inchargeUserId;
    private String inchargeUserName;
    private String inchargeDepartmentId;
    private String inchargeDepartmentName;
    private String caSubject;
    private String caContent;
    private LocalDate caDeadlineDt;
    private String capContent;
    private String capRootCauseContent;
    private String capMultipleFileUuid;
    private LocalDate capExpectCompleteDt;
    private String caiContent;
    private LocalDate caiCompleteDt;
    private String caiMultipleFileUuid;
    private String feedbackContent;
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


    public void applyCurrentInchargeUserInfo(UserTokenDto userToken) {
        this.inchargeUserId = userToken.getEmpNo();
        this.inchargeUserName = userToken.getEmpName();
        this.inchargeDepartmentId = userToken.getDeptCd();
        this.inchargeDepartmentName = userToken.getDeptNm();
    }

    public void applyNewCapInfo(SubscribeCaItemRequest request) {
        this.caAppvalprcEnum = request.getCaAppvalprcEnum();
        this.capContent = request.getCapContent();
        this.capExpectCompleteDt = request.getCapExpectCompleteDt();
        this.capMultipleFileUuid = request.getCapMultipleFileUuid();
        this.capRootCauseContent = request.getCapRootCauseContent();
    }

    public void applyNewCaiInfo(SubscribeCaItemRequest request) {
        this.caiCompleteDt = request.getCaiCompleteDt();
        this.caiContent = request.getCaiContent();
        this.caAppvalprcEnum = request.getCaAppvalprcEnum();
    }
}
