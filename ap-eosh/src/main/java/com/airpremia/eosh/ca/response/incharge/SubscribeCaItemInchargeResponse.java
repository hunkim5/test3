package com.airpremia.eosh.ca.response.incharge;


import com.airpremia.eosh.ca.entities.SubscribeCaItemInchargeEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SubscribeCaItemInchargeResponse {
    @Schema(description = "구독 시정조치 항목 담당 시퀀스")
    private Long subscribeCaItemInchargeSeq;
    @Schema(description = "구독 시정조치 UUID")
    private String subscribeCaUuid;
    @Schema(description = "구독 시정조치 항목 시퀀스")
    private Long subscribeCaItemSeq;
    @Schema(description = "메인 여부")
    private boolean mainBool = false;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당 사용자 이름")
    private String inchargeUserName;
    @Schema(description = "담당 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "담당 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "비고 내용")
    private String remarkContent;

    public SubscribeCaItemInchargeResponse(SubscribeCaItemInchargeEntity entity) {
        this.subscribeCaItemInchargeSeq = entity.getSubscribeCaItemInchargeSeq();
        this.subscribeCaUuid = entity.getSubscribeCaUuid();
        this.subscribeCaItemSeq = entity.getSubscribeCaItemSeq();
        this.mainBool = entity.isMainBool();
        this.inchargeUserId = entity.getInchargeUserId();
        this.inchargeUserName = entity.getInchargeUserName();
        this.inchargeDepartmentId = entity.getInchargeDepartmentId();
        this.inchargeDepartmentName = entity.getInchargeDepartmentName();
        this.remarkContent = entity.getRemarkContent();
    }
}
