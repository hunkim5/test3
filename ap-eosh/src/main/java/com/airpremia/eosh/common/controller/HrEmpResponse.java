package com.airpremia.eosh.common.controller;

import java.time.LocalDate;

import com.airpremia.eosh.common.dto.HrEmpDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HrEmpResponse {
    private String empNo;
    private String empNm;
    private String email;
    private String userId;
    private String handphone;
    private String postNm;
    private String deptCd;
    private String deptNm;
    private String deptFnCd;
    private String deptFnNm;
    private LocalDate birthYmd;
    private LocalDate hireYmd;

    public HrEmpResponse(HrEmpDto hrEmpDto) {
        this.empNo = hrEmpDto.getEmpNo();
        this.empNm = hrEmpDto.getEmpNm();
        this.email = hrEmpDto.getEmail();
        this.userId = hrEmpDto.getUserId();
        this.handphone = hrEmpDto.getHandphone();
        this.postNm = hrEmpDto.getPostNm();
        this.deptCd = hrEmpDto.getDeptCd();
        this.deptNm = hrEmpDto.getDeptNm();
        this.deptFnCd = hrEmpDto.getDeptFnCd();
        this.deptFnNm = hrEmpDto.getDeptFnNm();
        this.birthYmd = hrEmpDto.getBirthYmd();
        this.hireYmd = hrEmpDto.getHireYmd();
    }
}

