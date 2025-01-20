package com.airpremia.eosh.components.jwt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Payload {
    private String email;
    private String name;
    private String empNo;
    private String deptCd;
    private String deptNm;
    private String deptFnCd;
    private LocalDate birthYmd;
    private String groups;

    public Payload(Claims claims) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        this.email = String.valueOf(claims.get(PayloadEnum.EMAIL.getValue()));
        this.name = String.valueOf(claims.get(PayloadEnum.NAME.getValue()));
        this.empNo = String.valueOf(claims.get(PayloadEnum.EMP_NO.getValue()));
        this.deptCd = String.valueOf(claims.get(PayloadEnum.DEPT_CD.getValue()));
        this.deptNm = String.valueOf(claims.get(PayloadEnum.DEPT_NM.getValue()));
        this.deptFnCd = String.valueOf(claims.get(PayloadEnum.DEPT_FN_CD.getValue()));
        this.birthYmd = LocalDate.from(formatter.parse(String.valueOf(claims.get(PayloadEnum.BIRTH_YMD.getValue()))));
        this.groups = String.valueOf(claims.get(PayloadEnum.GROUPS.getValue()));
    }
}
