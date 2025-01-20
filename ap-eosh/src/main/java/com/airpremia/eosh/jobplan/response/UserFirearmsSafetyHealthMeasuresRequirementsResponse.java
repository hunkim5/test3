package com.airpremia.eosh.jobplan.response;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.dto.UserFirearmsSafetyHealthMeasuresRequirementsDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserFirearmsSafetyHealthMeasuresRequirementsResponse {
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

    public UserFirearmsSafetyHealthMeasuresRequirementsResponse(UserFirearmsSafetyHealthMeasuresRequirementsDto req) {
        this.userFirearmsSafetyHealthMeasuresRequirementsSeq = req.getUserFirearmsSafetyHealthMeasuresRequirementsSeq();
        this.jobSeq = req.getJobSeq();
        this.employeeNumber = req.getEmployeeNumber();
        this.employeeName = req.getEmployeeName();
        this.jobEmployeeSeq = req.getJobEmployeeSeq();
        this.contentRemovalBool = req.isContentRemovalBool();
        this.depressionGasReplaceBool = req.isDepressionGasReplaceBool();
        this.bowlOpenPressureReleaseBool = req.isBowlOpenPressureReleaseBool();
        this.bowlInternalCleaningBool = req.isBowlInternalCleaningBool();
        this.flammabilitySubstanceRemovalBool = req.isFlammabilitySubstanceRemovalBool();
        this.fireExtinguisherFunctionCheck = req.isFireExtinguisherFunctionCheck();
        this.safetyNetInstallationBool = req.isSafetyNetInstallationBool();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }
}
