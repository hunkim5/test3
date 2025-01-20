package com.airpremia.eosh.ca.request.incharge;


import com.airpremia.eosh.ca.entities.SubscribeCaItemInchargeEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubscribeCaItemInchargeRequest {
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
    @Schema(description = "삭제 여부")
    private boolean deleteBool = false;

    public SubscribeCaItemInchargeEntity toEntity() {
        SubscribeCaItemInchargeEntity entity = new SubscribeCaItemInchargeEntity();

        entity.setSubscribeCaItemInchargeSeq(this.subscribeCaItemInchargeSeq);
        entity.setSubscribeCaUuid(this.subscribeCaUuid);
        entity.setSubscribeCaItemSeq(this.subscribeCaItemSeq);
        entity.setMainBool(this.mainBool);
        entity.setInchargeUserId(this.inchargeUserId);
        entity.setInchargeUserName(this.inchargeUserName);
        entity.setInchargeDepartmentId(this.inchargeDepartmentId);
        entity.setInchargeDepartmentName(this.inchargeDepartmentName);
        entity.setRemarkContent(this.remarkContent);
        entity.setDeleteBool(this.deleteBool);

        return entity;
    }

}
