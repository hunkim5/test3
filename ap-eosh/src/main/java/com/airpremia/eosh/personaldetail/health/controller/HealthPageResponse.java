package com.airpremia.eosh.personaldetail.health.controller;

import com.airpremia.eosh.personaldetail.health.dto.HealthPageDto;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.ExaminationStatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthPageResponse {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "직위")
    private String postNm;
    @Schema(description = "부서")
    private String deptNm;
    @Schema(description = "스트레스 점수")
    private int score;
    @Schema(description = "사용자 이름")
    private String empNm;
    @Schema(description = "특수 건강검진 여부")
    private boolean userSpecialExamination;
    @Schema(description = "우주방사선 건강검진 여부")
    private boolean userCosmicRadiationExamination;
    @Schema(description = "뇌심혈관 건강검진 위험군")
    private String userCerebrocardiovascularExamination;
    @Schema(description = "검진상태 ENUM")
    private ExaminationStatusEnum examinationStatusEnum;
    @Schema(description = "검진상태 ENUM")
    private ExaminationCodeEnum normalExaminationCode;

    public HealthPageResponse(HealthPageDto req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.standardYyyy = req.getStandardYyyy();
        this.postNm = req.getPostNm();
        this.deptNm = req.getDeptNm();
        this.score = req.getScore();
        this.empNm = req.getEmpNm();
        this.normalExaminationCode = req.getNormalExaminationCode();
    }
}

