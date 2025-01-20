package com.airpremia.eosh.components.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PayloadEnum {
    EMP_NO("empNo"), EMAIL("email"), NAME("name"),
    DEPT_CD("deptCd"), DEPT_NM("deptNm"), DEPT_FN_CD("deptFnCd"),
    BIRTH_YMD("birthYmd"), GROUPS("groups");

    private final String value;
}
