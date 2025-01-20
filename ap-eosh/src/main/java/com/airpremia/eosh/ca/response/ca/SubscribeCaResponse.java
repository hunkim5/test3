package com.airpremia.eosh.ca.response.ca;

import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.ca.entities.SubscribeCaEntity;
import com.airpremia.eosh.ca.enums.SubscribeCaTargetEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SubscribeCaResponse {
    @Schema(description = "ca 항목 정보")
    List<SubscribeCaItemResponse> itemList;
    @Schema(description = "구독 시정조치 UUID")
    private String subscribeCaUuid;
    @Schema(description = "구독 시정조치 대상 ENUM")
    private SubscribeCaTargetEnum subscribeCaTargetEnum;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;

    public SubscribeCaResponse(SubscribeCaEntity entity) {
        this.subscribeCaUuid = entity.getSubscribeCaUuid();
        this.subscribeCaTargetEnum = entity.getSubscribeCaTargetEnum();
        this.insertUserId = entity.getInsertUserId();
        this.insertDtm = entity.getInsertDtm();
        this.insertIp = entity.getInsertIp();
        this.updateUserId = entity.getUpdateUserId();
        this.updateDtm = entity.getUpdateDtm();
        this.updateIp = entity.getUpdateIp();
    }
}
