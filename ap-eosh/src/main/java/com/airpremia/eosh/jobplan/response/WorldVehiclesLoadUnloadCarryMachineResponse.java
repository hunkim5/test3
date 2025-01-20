package com.airpremia.eosh.jobplan.response;

import com.airpremia.eosh.jobplan.dto.WorldVehiclesLoadUnloadCarryMachineDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorldVehiclesLoadUnloadCarryMachineResponse {
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "작성 분류 코드")
    private String writeClassificationCode;
    @Schema(description = "제한속도")
    private int speedLimit;
    @Schema(description = "기계 코드")
    private String machineCode;
    @Schema(description = "기계 기타")
    private String machineEtc;
    @Schema(description = "기계 번호")
    private String machineNo;
    @Schema(description = "모델 이름")
    private String modelName;
    @Schema(description = "기계 규격")
    private String machineStandard;
    @Schema(description = "작업 능력")
    private String jobAbility;
    @Schema(description = "검사 여부")
    private boolean inspectionBool;
    @Schema(description = "보험 기간")
    private String insurancePeriod;
    @Schema(description = "품명")
    private String productName;
    @Schema(description = "화물형상")
    private String cargoShape;
    @Schema(description = "화물규격")
    private String freightSpecification;
    @Schema(description = "화물중량")
    private String cargoWeight;
    @Schema(description = "운반중량")
    private String carryWeight;
    @Schema(description = "작업 순서 내용")
    private String jobOrderContent;
    @Schema(description = "위험 요소")
    private String dangerElement;
    @Schema(description = "안전 작업 방법")
    private String safetyJobMethod;
    @Schema(description = "비고")
    private String remark;
    @Schema(description = "운행 경로 첨부 UUID")
    private String operationPathAttachUuid;
    @Schema(description = "점검표 코드")
    private String checklistCode;
    @Schema(description = "점검표 작성 여부")
    private boolean checklistWriteBool;
    @Schema(description = "다중 첨부파일 UUID")
    private String multipleAttachfileUuid;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 IP")
    private String updateIp;

    public WorldVehiclesLoadUnloadCarryMachineResponse(WorldVehiclesLoadUnloadCarryMachineDto req) {
        this.jobSeq = req.getJobSeq();
        this.writeClassificationCode = req.getWriteClassificationCode();
        this.speedLimit = req.getSpeedLimit();
        this.machineCode = req.getMachineCode();
        this.machineEtc = req.getMachineEtc();
        this.machineNo = req.getMachineNo();
        this.modelName = req.getModelName();
        this.machineStandard = req.getMachineStandard();
        this.jobAbility = req.getJobAbility();
        this.inspectionBool = req.isInspectionBool();
        this.insurancePeriod = req.getInsurancePeriod();
        this.productName = req.getProductName();
        this.cargoShape = req.getCargoShape();
        this.freightSpecification = req.getFreightSpecification();
        this.cargoWeight = req.getCargoWeight();
        this.carryWeight = req.getCarryWeight();
        this.jobOrderContent = req.getJobOrderContent();
        this.dangerElement = req.getDangerElement();
        this.safetyJobMethod = req.getSafetyJobMethod();
        this.remark = req.getRemark();
        this.operationPathAttachUuid = req.getOperationPathAttachUuid();
        this.checklistCode = req.getChecklistCode();
        this.checklistWriteBool = req.isChecklistWriteBool();
        this.multipleAttachfileUuid = req.getMultipleAttachfileUuid();
        this.insertUserId = req.getInsertUserId();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateIp = req.getUpdateIp();
    }
}
