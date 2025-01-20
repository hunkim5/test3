package com.airpremia.eosh.ca.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "CaAppvalprcEnum")
@Getter
@AllArgsConstructor
public enum CaAppvalprcEnum {
    DRAFT,
    MIT_PROCESS,
    MP_SUBMIT,
    MP_APPROVAL,
    MP_REJECT,
    MP_RE_SUBMIT,
    MI_SUBMIT,
    MI_REJECT,
    MI_RE_SUBMIT,
    MI_APPROVAL,
    MI_CLOSE;
}
