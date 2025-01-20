package com.airpremia.eosh.risk.enums;

import org.springframework.context.annotation.Description;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Description("Risk Matrix 의 Serverity 레벨 Enum")
public enum SeverityEnum {
    LEVEL_A("A"), LEVEL_B("B"), LEVEL_C("C"), LEVEL_D("D");

    final String value;

    public static int getTotalCount() {
        return SeverityEnum.values().length;
    }

}
