package com.airpremia.eosh.jobplan.request;

import java.time.LocalDate;

import com.airpremia.eosh.jobplan.dto.ConfinedPlaceJobPlanPermissionDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ConfinedPlaceJobPlanPermissionRequest {
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
    @Schema(description = "시건조치 여부")
    private boolean constructionMeasuresBool;
    @Schema(description = "TBM 실시 여부")
    private boolean tbmProcessBool;
    @Schema(description = "검교정 실시 여부")
    private boolean calibrationProcessBool;
    @Schema(description = "장애물 제거 조치 여부")
    private boolean obstacleRemovalActionBool;
    @Schema(description = "워키토키 확인 여부")
    private boolean walkieTalkieCheckBool;
    @Schema(description = "보호구 상태 확인 여부")
    private boolean protectGearStatusCheckBool;
    @Schema(description = "유해가스 시작 측정지점")
    private String harmfulGasesStartMeasurementPoint;
    @Schema(description = "유해가스 시작 측정농도 여부")
    private boolean harmfulGasesStartMeasurementConcentrationBool;
    @Schema(description = "유해가스 시작 의견")
    private String harmfulGasesStartOpinion;
    @Schema(description = "유해가스 중단 측정지점")
    private String harmfulGasesDropMeasurementPoint;
    @Schema(description = "유해가스 중단 측정농도 여부")
    private boolean harmfulGasesDropMeasurementConcentrationBool;
    @Schema(description = "유해가스 중단 의견")
    private String harmfulGasesDropOpinion;
    @Schema(description = "유해가스 작업중 측정지점")
    private String harmfulGasesProcessMeasurementPoint;
    @Schema(description = "유해가스 작업중 측정농도 여부")
    private boolean harmfulGasesProcessMeasurementConcentrationBool;
    @Schema(description = "유해가스 작업중 의견")
    private String harmfulGasesProcessOpinion;
    @Schema(description = "환기실시 시작 날짜")
    private LocalDate ventialationCarriedOutStartDt;
    @Schema(description = "환기실시 중단 날짜")
    private LocalDate ventialationCarriedOutDropDt;
    @Schema(description = "환기실시 작업중 날짜")
    private LocalDate ventialationCarriedOutProcessDt;
    @Schema(description = "환기실시 시작 의견사항")
    private String ventialationCarriedOutStartOpinion;
    @Schema(description = "환기실시 중단 의견사항")
    private String ventialationCarriedOutDropOpinion;
    @Schema(description = "환기실시 작업중 의견사항")
    private String ventialationCarriedOutProcessOpinion;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 IP")
    private String updateIp;

    public ConfinedPlaceJobPlanPermissionDto convertConfinedPlaceJobPlanPermissionDto() {
        ConfinedPlaceJobPlanPermissionDto data = new ConfinedPlaceJobPlanPermissionDto();
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
