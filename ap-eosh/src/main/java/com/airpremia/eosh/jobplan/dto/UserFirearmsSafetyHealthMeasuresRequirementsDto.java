package com.airpremia.eosh.jobplan.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.request.UserFirearmsSafetyHealthMeasuresRequirementsRequest;
import com.airpremia.eosh.jobplan.response.UserFirearmsSafetyHealthMeasuresRequirementsResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserFirearmsSafetyHealthMeasuresRequirementsDto {
    private Long userFirearmsSafetyHealthMeasuresRequirementsSeq;
    private Long jobSeq;
    private String employeeNumber;
    private String employeeName;
    private Long jobEmployeeSeq;
    private boolean contentRemovalBool;
    private boolean depressionGasReplaceBool;
    private boolean bowlOpenPressureReleaseBool;
    private boolean bowlInternalCleaningBool;
    private boolean flammabilitySubstanceRemovalBool;
    private boolean fireExtinguisherFunctionCheck;
    private boolean safetyNetInstallationBool;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public UserFirearmsSafetyHealthMeasuresRequirementsDto(UserFirearmsSafetyHealthMeasuresRequirementsRequest req) {
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

    public UserFirearmsSafetyHealthMeasuresRequirementsResponse convertUserFirearmsSafetyHealthMeasuresRequirementsResponse() {
        UserFirearmsSafetyHealthMeasuresRequirementsResponse data =
            new UserFirearmsSafetyHealthMeasuresRequirementsResponse();
        data.setUserFirearmsSafetyHealthMeasuresRequirementsSeq(this.userFirearmsSafetyHealthMeasuresRequirementsSeq);
        data.setJobSeq(this.jobSeq);
        data.setEmployeeNumber(this.employeeNumber);
        data.setEmployeeName(this.employeeName);
        data.setJobEmployeeSeq(this.jobEmployeeSeq);
        data.setContentRemovalBool(this.contentRemovalBool);
        data.setDepressionGasReplaceBool(this.depressionGasReplaceBool);
        data.setBowlOpenPressureReleaseBool(this.bowlOpenPressureReleaseBool);
        data.setBowlInternalCleaningBool(this.bowlInternalCleaningBool);
        data.setFlammabilitySubstanceRemovalBool(this.flammabilitySubstanceRemovalBool);
        data.setFireExtinguisherFunctionCheck(this.fireExtinguisherFunctionCheck);
        data.setSafetyNetInstallationBool(this.safetyNetInstallationBool);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }

}
