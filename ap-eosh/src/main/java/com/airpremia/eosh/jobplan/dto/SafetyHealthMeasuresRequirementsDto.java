package com.airpremia.eosh.jobplan.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.response.SafetyHealthMeasuresRequirementsResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SafetyHealthMeasuresRequirementsDto {
    private Long safetyHealthMeasuresRequirementsSeq;
    private Long jobSeq;
    private Long jobEmployeeSeq;
    private String checkItemCode;
    private boolean checkItemBool;
    private String checkItemRemark;
    private LocalDate checkDt;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public SafetyHealthMeasuresRequirementsResponse convertSafetyHealthMeasuresRequirementsResponse() {
        SafetyHealthMeasuresRequirementsResponse data = new SafetyHealthMeasuresRequirementsResponse();
        data.setSafetyHealthMeasuresRequirementsSeq(this.safetyHealthMeasuresRequirementsSeq);
        data.setJobSeq(this.jobSeq);
        data.setJobEmployeeSeq(this.jobEmployeeSeq);
        data.setCheckItemCode(this.checkItemCode);
        data.setCheckItemBool(this.checkItemBool);
        data.setCheckItemRemark(this.checkItemRemark);
        data.setCheckDt(this.checkDt);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}
