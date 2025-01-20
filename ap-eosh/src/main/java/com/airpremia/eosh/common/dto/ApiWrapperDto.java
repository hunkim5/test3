package com.airpremia.eosh.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiWrapperDto<T> {
    private T data;
    private int status;
}
