package com.airpremia.eosh.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrWrapperDto<T> {
    private T data;
    private int status;
}
