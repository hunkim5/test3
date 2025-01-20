package com.airpremia.eosh.authoritymanagement.authoritymanagement.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "사용자 등급")
@Getter
@AllArgsConstructor
public enum AuthorityManagementUserGradeEnum {
    LEVEL1, LEVEL2, LEVEL3, LEVEL4
}
