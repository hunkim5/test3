package com.airpremia.eosh.personaldetail.basicinfo.dto;

import java.time.LocalDate;

import com.airpremia.eosh.authoritymanagement.authoritymanagement.enums.AuthorityManagementUserGradeEnum;
import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoSearchRequest;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BasicInfoDto {

    private Long userSeq;

    private String userId;

    private AuthorityManagementUserGradeEnum userGradeEnum;

    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;

    private String empNm;

    private String postNm;

    private String deptNm;

    private LocalDate hireYmdFrom;

    private LocalDate hireYmdTo;

    private LocalDate hireYmd;

    private LocalDate birthYmd;

    private String email;

    private String handphone;

    private String empNo;

    public BasicInfoDto(BasicInfoSearchRequest req) {
        this.userId = req.getUserId();
        this.userGradeEnum = req.getUserGradeEnum();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
        this.empNm = req.getEmpNm();
        this.postNm = req.getPostNm();
        this.deptNm = req.getDeptNm();
        this.hireYmdFrom = req.getHireYmdFrom();
        this.hireYmdTo = req.getHireYmdTo();
        this.hireYmd = req.getHireYmd();
        this.birthYmd = req.getBirthYmd();
    }
}

