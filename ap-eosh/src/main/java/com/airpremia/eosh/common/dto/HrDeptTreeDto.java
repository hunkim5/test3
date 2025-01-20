package com.airpremia.eosh.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HrDeptTreeDto {
    private String deptUpCd;
    private long level;
    private String deptCd;
    private String deptNm;
    private String deptTree;
}
