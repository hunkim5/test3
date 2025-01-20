package com.airpremia.eosh.ca.dto;


import com.airpremia.eosh.ca.entities.SubscribeCaItemEntity;
import com.airpremia.eosh.ca.enums.SubscribeCaTargetEnum;
import com.airpremia.esmsfos.core.enums.ReportClassificationEnum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;

@Getter
@Setter
public class SubscribeCaItemWithSourceDto {
    @Delegate
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    SubscribeCaItemEntity subscribeCaItemEntity = new SubscribeCaItemEntity();
    private SubscribeCaTargetEnum subscribeCaTargetEnum;
    private String issueId;
    private ReportClassificationEnum reportClassificationEnum;
    private String issueSourceId;
}
