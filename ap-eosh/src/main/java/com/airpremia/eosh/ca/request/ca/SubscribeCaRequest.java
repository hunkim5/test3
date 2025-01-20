package com.airpremia.eosh.ca.request.ca;

import java.util.List;

import com.airpremia.eosh.ca.entities.SubscribeCaEntity;
import com.airpremia.eosh.ca.enums.SubscribeCaTargetEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubscribeCaRequest {
    @Schema(description = "ca 항목 정보 목록")
    List<SubscribeCaItemRequest> itemList;
    @Schema(description = "ca 항목 삭제 처리할 목록")
    List<SubscribeCaItemRequest> deleteTargetList;
    @Schema(description = "구독 시정조치 UUID")
    private String subscribeCaUuid;
    @Schema(description = "구독 시정조치 대상 ENUM")
    private SubscribeCaTargetEnum subscribeCaTargetEnum;

    public SubscribeCaEntity toEntity() {
        SubscribeCaEntity entity = new SubscribeCaEntity();

        entity.setSubscribeCaUuid(this.subscribeCaUuid);
        entity.setSubscribeCaTargetEnum(this.subscribeCaTargetEnum);

        return entity;
    }
}
