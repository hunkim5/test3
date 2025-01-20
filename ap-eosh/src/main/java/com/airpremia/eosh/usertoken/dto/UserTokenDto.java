package com.airpremia.eosh.usertoken.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserTokenDto {
    private String empNo;
    private String empName;
    private String email;
    private String deptCd;
    private String deptNm;
    private String deptFnCd;
    private LocalDate birthYmd;
    private List<String> roles;

    public List<String> getRoles() {
        if (roles == null) {
            return new ArrayList<>();
        }

        return roles.stream().filter(x -> x.contains("ROLE_EOSH")).toList();
    }
}
