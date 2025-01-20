package com.airpremia.eosh.common.dto;

import java.time.LocalDate;

import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HrEmpDto {
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
    private String responseKey;
    private LocalDate hireYmdFrom;
    private LocalDate hireYmdTo;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;

    public HrEmpDto getHrEmpDtoWithUserId() {
        if (empNo == null || birthYmd == null) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }

        this.userId = empNo.substring(1, 7) + String.valueOf(birthYmd).replace("-", "");
        return this;
    }
}

