package com.airpremia.eosh.personaldetail.basicinfo.controller;

import java.util.List;

import com.airpremia.eosh.personaldetail.basicinfo.dto.BasicInfoDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BasicInfoResponse {
    @Schema(description = "사용자 정보")
    private BasicInfoDto basicInfoDto;
    @Schema(description = "안전보건관리조직")
    private List<UserSafetyOfficeLogResponse> userSafetyOfficeLogResponse;
    @Schema(description = "자격증")
    private List<UserQualificationItemResponse> userQualificationItemResponse;
}

