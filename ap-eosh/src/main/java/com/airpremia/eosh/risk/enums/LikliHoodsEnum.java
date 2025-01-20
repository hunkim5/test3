package com.airpremia.eosh.risk.enums;

import org.springframework.context.annotation.Description;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Description("Risk Matrix 의 LikliHood 레벨 Enum")
public enum LikliHoodsEnum {
    LEVEL_1(1), LEVEL_2(2), LEVEL_3(3), LEVEL_4(4), LEVEL_5(5);

    final int level;

    public static int getTotalCount() {
        return LikliHoodsEnum.values().length;
    }
}
