package com.airpremia.eosh.personaldetail.health.dto;

import com.airpremia.eosh.personaldetail.health.controller.HealthRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserCerebrocardiovascularExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserCosmicRadiationExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserNormalExaminationRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserSpecialExaminationRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HealthSaveDto {
    private String responseKey;
    private Long userNormalSeq;
    private Long userSpecialSeq;
    private Long userCosmicSeq;
    private Long userCerebrovascularSeq;
    private String standardYyyy;

    private UserNormalExaminationDto userNormalExaminationDto;

    private UserSpecialExaminationDto userSpecialExaminationDto;

    private UserCosmicRadiationExaminationDto userCosmicRadiationExaminationDto;

    private UserCerebrocardiovascularExaminationDto userCerebrocardiovascularExaminationDto;

    public HealthSaveDto(HealthRequest req) {
        if (req.getUserNormalExaminationRequest() == null) {
            req.setUserNormalExaminationRequest(new UserNormalExaminationRequest());
        }
        this.userNormalExaminationDto = req.getUserNormalExaminationRequest().convertUserNormalExaminationDto();
        if (req.getUserSpecialExaminationRequest() == null) {
            req.setUserSpecialExaminationRequest(new UserSpecialExaminationRequest());
        }
        this.userSpecialExaminationDto = req.getUserSpecialExaminationRequest().convertUserSpecialExaminationDto();
        if (req.getUserCosmicRadiationExaminationRequest() == null) {
            req.setUserCosmicRadiationExaminationRequest(new UserCosmicRadiationExaminationRequest());
        }
        this.userCosmicRadiationExaminationDto =
            req.getUserCosmicRadiationExaminationRequest().convertUserCosmicRadiationExaminationDto();
        if (req.getUserCerebrocardiovascularExaminationRequest() == null) {
            req.setUserCerebrocardiovascularExaminationRequest(new UserCerebrocardiovascularExaminationRequest());
        }
        this.userCerebrocardiovascularExaminationDto =
            req.getUserCerebrocardiovascularExaminationRequest().convertUserCerebrocardiovascularExaminationDto();
        this.userNormalSeq = req.getUserNormalSeq();
        this.userSpecialSeq = req.getUserSpecialSeq();
        this.userCosmicSeq = req.getUserCosmicSeq();
        this.userCerebrovascularSeq = req.getUserCerebrovascularSeq();
        this.standardYyyy = req.getStandardYyyy();
        this.responseKey = req.getResponseKey();
    }
}

