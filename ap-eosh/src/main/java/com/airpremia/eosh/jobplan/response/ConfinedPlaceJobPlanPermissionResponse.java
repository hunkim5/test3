package com.airpremia.eosh.jobplan.response;

import java.time.LocalDate;

import com.airpremia.eosh.jobplan.dto.ConfinedPlaceJobPlanPermissionDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ConfinedPlaceJobPlanPermissionResponse {
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

    public ConfinedPlaceJobPlanPermissionResponse(ConfinedPlaceJobPlanPermissionDto req) {
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
}
