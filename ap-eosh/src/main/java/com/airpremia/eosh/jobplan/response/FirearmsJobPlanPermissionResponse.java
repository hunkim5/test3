package com.airpremia.eosh.jobplan.response;

import com.airpremia.eosh.jobplan.dto.FirearmsJobPlanPermissionDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FirearmsJobPlanPermissionResponse {
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "구급함 확인 여부")
    private boolean firstAidKitCheckBool;
    @Schema(description = "소화기 확인 여부")
    private boolean fireExtinguisherCheckBool;
    @Schema(description = "눈세척액")
    private boolean eyewashSolutionBool;
    @Schema(description = "비고")
    private String remark;
    @Schema(description = "밀페공간작업관계자외출입금지표지판설치 여부")
    private boolean noEntryUnauthorizedPersonConfinedSpaceWorkBool;

    public FirearmsJobPlanPermissionResponse(FirearmsJobPlanPermissionDto req) {
        this.jobSeq = req.getJobSeq();
        this.firstAidKitCheckBool = req.isFirstAidKitCheckBool();
        this.fireExtinguisherCheckBool = req.isFireExtinguisherCheckBool();
        this.eyewashSolutionBool = req.isEyewashSolutionBool();
        this.remark = req.getRemark();
        this.noEntryUnauthorizedPersonConfinedSpaceWorkBool = req.isNoEntryUnauthorizedPersonConfinedSpaceWorkBool();
    }
}
