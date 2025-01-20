package com.airpremia.eosh.personaldetail.basicinfo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserJobClassificationClassificationEnum {
    OFFICE("사무직"),
    NOT_OFFICE("비사무직");

    private final String value;

    public static UserJobClassificationClassificationEnum findByValue(String value) {
        for (UserJobClassificationClassificationEnum classification : values()) {
            if (classification.value.equals(value)) {
                return classification;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}

