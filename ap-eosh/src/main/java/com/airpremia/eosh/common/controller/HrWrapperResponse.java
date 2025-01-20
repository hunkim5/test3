package com.airpremia.eosh.common.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrWrapperResponse<T> {
    private T data;
}
