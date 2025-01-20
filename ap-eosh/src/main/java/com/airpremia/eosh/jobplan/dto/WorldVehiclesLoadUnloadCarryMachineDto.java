package com.airpremia.eosh.jobplan.dto;

import com.airpremia.eosh.jobplan.request.WorldVehiclesLoadUnloadCarryMachineRequest;
import com.airpremia.eosh.jobplan.response.WorldVehiclesLoadUnloadCarryMachineResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class WorldVehiclesLoadUnloadCarryMachineDto {
    private Long jobSeq;
    private String writeClassificationCode;
    private int speedLimit;
    private String machineCode;
    private String machineEtc;
    private String machineNo;
    private String modelName;
    private String machineStandard;
    private String jobAbility;
    private boolean inspectionBool;
    private String insurancePeriod;
    private String productName;
    private String cargoShape;
    private String freightSpecification;
    private String cargoWeight;
    private String carryWeight;
    private String jobOrderContent;
    private String dangerElement;
    private String safetyJobMethod;
    private String remark;
    private String operationPathAttachUuid;
    private String checklistCode;
    private boolean checklistWriteBool;
    private String multipleAttachfileUuid;
    private String insertUserId;
    private String insertIp;
    private String updateUserId;
    private String updateIp;

    public WorldVehiclesLoadUnloadCarryMachineDto(WorldVehiclesLoadUnloadCarryMachineRequest req) {
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

    public WorldVehiclesLoadUnloadCarryMachineResponse convertWorldVehiclesLoadUnloadCarryMachineResponse() {
        WorldVehiclesLoadUnloadCarryMachineResponse data = new WorldVehiclesLoadUnloadCarryMachineResponse();
        data.setJobSeq(this.jobSeq);
        data.setWriteClassificationCode(this.writeClassificationCode);
        data.setSpeedLimit(this.speedLimit);
        data.setMachineCode(this.machineCode);
        data.setMachineEtc(this.machineEtc);
        data.setMachineNo(this.machineNo);
        data.setModelName(this.modelName);
        data.setMachineStandard(this.machineStandard);
        data.setJobAbility(this.jobAbility);
        data.setInspectionBool(this.inspectionBool);
        data.setInsurancePeriod(this.insurancePeriod);
        data.setProductName(this.productName);
        data.setCargoShape(this.cargoShape);
        data.setFreightSpecification(this.freightSpecification);
        data.setCargoWeight(this.cargoWeight);
        data.setCarryWeight(this.carryWeight);
        data.setJobOrderContent(this.jobOrderContent);
        data.setDangerElement(this.dangerElement);
        data.setSafetyJobMethod(this.safetyJobMethod);
        data.setRemark(this.remark);
        data.setOperationPathAttachUuid(this.operationPathAttachUuid);
        data.setChecklistCode(this.checklistCode);
        data.setChecklistWriteBool(this.checklistWriteBool);
        data.setMultipleAttachfileUuid(this.multipleAttachfileUuid);
        data.setInsertUserId(this.insertUserId);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateIp(this.updateIp);
        return data;
    }

}
