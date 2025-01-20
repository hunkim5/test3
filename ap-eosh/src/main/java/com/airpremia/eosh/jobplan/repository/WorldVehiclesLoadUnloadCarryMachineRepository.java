package com.airpremia.eosh.jobplan.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.jobplan.dto.WorldVehiclesLoadUnloadCarryMachineDto;


@Repository
public interface WorldVehiclesLoadUnloadCarryMachineRepository {

    int insertWorldVehiclesLoadUnloadCarryMachine(WorldVehiclesLoadUnloadCarryMachineDto updateDto);

    int updateWorldVehiclesLoadUnloadCarryMachine(WorldVehiclesLoadUnloadCarryMachineDto updateDto);

    int deleteWorldVehiclesLoadUnloadCarryMachine(List<Long> deleteSeqList);

    WorldVehiclesLoadUnloadCarryMachineDto selectWorldVehiclesLoadUnloadCarryMachine(Long jobSeq);
}
