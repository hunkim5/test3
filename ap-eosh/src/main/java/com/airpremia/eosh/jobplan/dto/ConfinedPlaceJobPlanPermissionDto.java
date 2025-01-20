package com.airpremia.eosh.jobplan.dto;

import java.time.LocalDate;

import com.airpremia.eosh.jobplan.request.ConfinedPlaceJobPlanPermissionRequest;
import com.airpremia.eosh.jobplan.response.ConfinedPlaceJobPlanPermissionResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ConfinedPlaceJobPlanPermissionDto {
    private Long jobSeq;
    private boolean firstAidKitCheckBool;
    private boolean fireExtinguisherCheckBool;
    private boolean eyewashSolutionBool;
    private String remark;
    private boolean noEntryUnauthorizedPersonConfinedSpaceWorkBool;
    private boolean constructionMeasuresBool;
    private boolean tbmProcessBool;
    private boolean calibrationProcessBool;
    private boolean obstacleRemovalActionBool;
    private boolean walkieTalkieCheckBool;
    private boolean protectGearStatusCheckBool;
    private String harmfulGasesStartMeasurementPoint;
    private boolean harmfulGasesStartMeasurementConcentrationBool;
    private String harmfulGasesStartOpinion;
    private String harmfulGasesDropMeasurementPoint;
    private boolean harmfulGasesDropMeasurementConcentrationBool;
    private String harmfulGasesDropOpinion;
    private String harmfulGasesProcessMeasurementPoint;
    private boolean harmfulGasesProcessMeasurementConcentrationBool;
    private String harmfulGasesProcessOpinion;
    private LocalDate ventialationCarriedOutStartDt;
    private LocalDate ventialationCarriedOutDropDt;
    private LocalDate ventialationCarriedOutProcessDt;
    private String ventialationCarriedOutStartOpinion;
    private String ventialationCarriedOutDropOpinion;
    private String ventialationCarriedOutProcessOpinion;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public ConfinedPlaceJobPlanPermissionDto(ConfinedPlaceJobPlanPermissionRequest req) {
        this.jobSeq = req.getJobSeq();
        this.firstAidKitCheckBool = req.isFirstAidKitCheckBool();
        this.fireExtinguisherCheckBool = req.isFireExtinguisherCheckBool();
        this.eyewashSolutionBool = req.isEyewashSolutionBool();
        this.remark = req.getRemark();
        this.noEntryUnauthorizedPersonConfinedSpaceWorkBool = req.isNoEntryUnauthorizedPersonConfinedSpaceWorkBool();
        this.constructionMeasuresBool = req.isConstructionMeasuresBool();
        this.tbmProcessBool = req.isTbmProcessBool();
        this.calibrationProcessBool = req.isCalibrationProcessBool();
        this.obstacleRemovalActionBool = req.isObstacleRemovalActionBool();
        this.walkieTalkieCheckBool = req.isWalkieTalkieCheckBool();
        this.protectGearStatusCheckBool = req.isProtectGearStatusCheckBool();
        this.harmfulGasesStartMeasurementPoint = req.getHarmfulGasesStartMeasurementPoint();
        this.harmfulGasesStartMeasurementConcentrationBool = req.isHarmfulGasesStartMeasurementConcentrationBool();
        this.harmfulGasesStartOpinion = req.getHarmfulGasesStartOpinion();
        this.harmfulGasesDropMeasurementPoint = req.getHarmfulGasesDropMeasurementPoint();
        this.harmfulGasesDropMeasurementConcentrationBool = req.isHarmfulGasesDropMeasurementConcentrationBool();
        this.harmfulGasesDropOpinion = req.getHarmfulGasesDropOpinion();
        this.harmfulGasesProcessMeasurementPoint = req.getHarmfulGasesProcessMeasurementPoint();
        this.harmfulGasesProcessMeasurementConcentrationBool = req.isHarmfulGasesProcessMeasurementConcentrationBool();
        this.harmfulGasesProcessOpinion = req.getHarmfulGasesProcessOpinion();
        this.ventialationCarriedOutStartDt = req.getVentialationCarriedOutStartDt();
        this.ventialationCarriedOutDropDt = req.getVentialationCarriedOutDropDt();
        this.ventialationCarriedOutProcessDt = req.getVentialationCarriedOutProcessDt();
        this.ventialationCarriedOutStartOpinion = req.getVentialationCarriedOutStartOpinion();
        this.ventialationCarriedOutDropOpinion = req.getVentialationCarriedOutDropOpinion();
        this.ventialationCarriedOutProcessOpinion = req.getVentialationCarriedOutProcessOpinion();
        this.insertUserId = req.getInsertUserId();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }

    public ConfinedPlaceJobPlanPermissionResponse convertConfinedPlaceJobPlanPermissionResponse() {
        ConfinedPlaceJobPlanPermissionResponse data = new ConfinedPlaceJobPlanPermissionResponse();
        data.setJobSeq(this.jobSeq);
        data.setFirstAidKitCheckBool(this.firstAidKitCheckBool);
        data.setFireExtinguisherCheckBool(this.fireExtinguisherCheckBool);
        data.setEyewashSolutionBool(this.eyewashSolutionBool);
        data.setRemark(this.remark);
        data.setNoEntryUnauthorizedPersonConfinedSpaceWorkBool(this.noEntryUnauthorizedPersonConfinedSpaceWorkBool);
        data.setConstructionMeasuresBool(this.constructionMeasuresBool);
        data.setTbmProcessBool(this.tbmProcessBool);
        data.setCalibrationProcessBool(this.calibrationProcessBool);
        data.setObstacleRemovalActionBool(this.obstacleRemovalActionBool);
        data.setWalkieTalkieCheckBool(this.walkieTalkieCheckBool);
        data.setProtectGearStatusCheckBool(this.protectGearStatusCheckBool);
        data.setHarmfulGasesStartMeasurementPoint(this.harmfulGasesStartMeasurementPoint);
        data.setHarmfulGasesStartMeasurementConcentrationBool(this.harmfulGasesStartMeasurementConcentrationBool);
        data.setHarmfulGasesStartOpinion(this.harmfulGasesStartOpinion);
        data.setHarmfulGasesDropMeasurementPoint(this.harmfulGasesDropMeasurementPoint);
        data.setHarmfulGasesDropMeasurementConcentrationBool(this.harmfulGasesDropMeasurementConcentrationBool);
        data.setHarmfulGasesDropOpinion(this.harmfulGasesDropOpinion);
        data.setHarmfulGasesProcessMeasurementPoint(this.harmfulGasesProcessMeasurementPoint);
        data.setHarmfulGasesProcessMeasurementConcentrationBool(this.harmfulGasesProcessMeasurementConcentrationBool);
        data.setHarmfulGasesProcessOpinion(this.harmfulGasesProcessOpinion);
        data.setVentialationCarriedOutStartDt(this.ventialationCarriedOutStartDt);
        data.setVentialationCarriedOutDropDt(this.ventialationCarriedOutDropDt);
        data.setVentialationCarriedOutProcessDt(this.ventialationCarriedOutProcessDt);
        data.setVentialationCarriedOutStartOpinion(this.ventialationCarriedOutStartOpinion);
        data.setVentialationCarriedOutDropOpinion(this.ventialationCarriedOutDropOpinion);
        data.setVentialationCarriedOutProcessOpinion(this.ventialationCarriedOutProcessOpinion);
        data.setInsertUserId(this.insertUserId);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateIp(this.updateIp);
        return data;
    }

}
