package com.airpremia.eosh.common.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiWrapperListDto<T> {
    private List<T> data;
    private int totalElements;
    private int totalPages;
    private int size;
    private int status;
}
