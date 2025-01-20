package com.airpremia.eosh.jobplan.dto;

import com.airpremia.eosh.jobplan.request.FirearmsJobPlanPermissionRequest;
import com.airpremia.eosh.jobplan.response.FirearmsJobPlanPermissionResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FirearmsJobPlanPermissionDto {
    private Long jobSeq;
    private boolean firstAidKitCheckBool;
    private boolean fireExtinguisherCheckBool;
    private boolean eyewashSolutionBool;
    private String remark;
    private boolean noEntryUnauthorizedPersonConfinedSpaceWorkBool;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public FirearmsJobPlanPermissionDto(FirearmsJobPlanPermissionRequest req) {
        this.jobSeq = req.getJobSeq();
        this.firstAidKitCheckBool = req.isFirstAidKitCheckBool();
        this.fireExtinguisherCheckBool = req.isFireExtinguisherCheckBool();
        this.eyewashSolutionBool = req.isEyewashSolutionBool();
        this.remark = req.getRemark();
        this.noEntryUnauthorizedPersonConfinedSpaceWorkBool = req.isNoEntryUnauthorizedPersonConfinedSpaceWorkBool();
    }

    public FirearmsJobPlanPermissionResponse convertFirearmsJobPlanPermissionResponse() {
        FirearmsJobPlanPermissionResponse data = new FirearmsJobPlanPermissionResponse();
        data.setJobSeq(this.jobSeq);
        data.setFirstAidKitCheckBool(this.firstAidKitCheckBool);
        data.setFireExtinguisherCheckBool(this.fireExtinguisherCheckBool);
        data.setEyewashSolutionBool(this.eyewashSolutionBool);
        data.setRemark(this.remark);
        data.setNoEntryUnauthorizedPersonConfinedSpaceWorkBool(this.noEntryUnauthorizedPersonConfinedSpaceWorkBool);
        return data;
    }

}
