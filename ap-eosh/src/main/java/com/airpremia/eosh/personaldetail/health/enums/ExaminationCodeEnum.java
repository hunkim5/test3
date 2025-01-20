package com.airpremia.eosh.personaldetail.health.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExaminationCodeEnum {
    DONE("수검완료"),
    NOT_YET("미수검"),
    NOT_TARGET("대상아님");

    private final String value;

    public static ExaminationCodeEnum findByValue(String other) {
        for (ExaminationCodeEnum code : ExaminationCodeEnum.values()) {
            if (code.value.equals(other)) {
                return code;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + other);
    }
}
