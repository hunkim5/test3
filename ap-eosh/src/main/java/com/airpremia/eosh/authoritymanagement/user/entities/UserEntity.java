package com.airpremia.eosh.authoritymanagement.user.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.authoritymanagement.user.enums.Sex;
import com.airpremia.eosh.authoritymanagement.user.enums.UserGradeEnum;
import com.airpremia.eosh.authoritymanagement.user.enums.UserStatusEnum;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {
    private Long userSeq;
    private String userId;
    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;
    private String safetyOfficeCode;
    private UserStatusEnum userStatusEnum;
    private UserGradeEnum userGradeEnum;
    private boolean requestAuthorityBool;
    private LocalDate requestPeriodStart;
    private LocalDate requestPeriodEnd;
    private Sex sex;
    private String deptCd;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
}
