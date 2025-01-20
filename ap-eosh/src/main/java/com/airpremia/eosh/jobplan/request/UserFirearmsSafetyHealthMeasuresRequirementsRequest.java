package com.airpremia.eosh.jobplan.request;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.dto.UserFirearmsSafetyHealthMeasuresRequirementsDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserFirearmsSafetyHealthMeasuresRequirementsRequest {
    @Schema(description = "사용자 화기 안전보건조치 요구사항 시퀀스")
    private Long userFirearmsSafetyHealthMeasuresRequirementsSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "사번")
    private String employeeNumber;
    @Schema(description = "사원명")
    private String employeeName;
    @Schema(description = "근로자 시퀀스")
    private Long jobEmployeeSeq;
    @Schema(description = "내용물 제거 여부")
    private boolean contentRemovalBool;
    @Schema(description = "불화성 가스 치환 여부")
    private boolean depressionGasReplaceBool;
    @Schema(description = "용기 개방 압력 방출 여부")
    private boolean bowlOpenPressureReleaseBool;
    @Schema(description = "용기 내부 세정 여부")
    private boolean bowlInternalCleaningBool;
    @Schema(description = "인화성 물질 제거 여부")
    private boolean flammabilitySubstanceRemovalBool;
    @Schema(description = "소화기 기능확인")
    private boolean fireExtinguisherFunctionCheck;
    @Schema(description = "안전망 설치 여부")
    private boolean safetyNetInstallationBool;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;

    public UserFirearmsSafetyHealthMeasuresRequirementsDto convertUserFirearmsSafetyHealthMeasuresRequirementsDto() {
        UserFirearmsSafetyHealthMeasuresRequirementsDto dto = new UserFirearmsSafetyHealthMeasuresRequirementsDto();
        dto.setUserFirearmsSafetyHealthMeasuresRequirementsSeq(this.userFirearmsSafetyHealthMeasuresRequirementsSeq);
        dto.setJobSeq(this.jobSeq);
        dto.setEmployeeNumber(this.employeeNumber);
        dto.setEmployeeName(this.employeeName);
        dto.setJobEmployeeSeq(this.jobEmployeeSeq);
        dto.setContentRemovalBool(this.contentRemovalBool);
        dto.setDepressionGasReplaceBool(this.depressionGasReplaceBool);
        dto.setBowlOpenPressureReleaseBool(this.bowlOpenPressureReleaseBool);
        dto.setBowlInternalCleaningBool(this.bowlInternalCleaningBool);
        dto.setFlammabilitySubstanceRemovalBool(this.flammabilitySubstanceRemovalBool);
        dto.setFireExtinguisherFunctionCheck(this.fireExtinguisherFunctionCheck);
        dto.setSafetyNetInstallationBool(this.safetyNetInstallationBool);
        dto.setInsertUserId(this.insertUserId);
        dto.setInsertDtm(this.insertDtm);
        dto.setInsertIp(this.insertIp);
        dto.setUpdateUserId(this.updateUserId);
        dto.setUpdateDtm(this.updateDtm);
        dto.setUpdateIp(this.updateIp);
        return dto;
    }

}
