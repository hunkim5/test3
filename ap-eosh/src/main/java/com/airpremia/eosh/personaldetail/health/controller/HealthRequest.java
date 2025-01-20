package com.airpremia.eosh.personaldetail.health.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthRequest {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 일반검진 시퀀스")
    private Long userNormalSeq;
    @Schema(description = "사용자 특별검진 시퀀스")
    private Long userSpecialSeq;
    @Schema(description = "사용자 우주방사선 시퀀스")
    private Long userCosmicSeq;
    @Schema(description = "사용자 뇌심혈관 시퀀스")
    private Long userCerebrovascularSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "기준 년도")
    private String standardYyyy;
    @Schema(description = "사용자 일반검진")
    private UserNormalExaminationRequest userNormalExaminationRequest;
    @Schema(description = "사용자 특수검진")
    private UserSpecialExaminationRequest userSpecialExaminationRequest;
    @Schema(description = "사용자 우주방사선검진")
    private UserCosmicRadiationExaminationRequest userCosmicRadiationExaminationRequest;
    @Schema(description = "사용자 뇌심혈관검진")
    private UserCerebrocardiovascularExaminationRequest userCerebrocardiovascularExaminationRequest;
    @Schema(description = "사용자 ID 키")
    private String responseKey;
}

