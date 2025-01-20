package com.airpremia.eosh.jobplan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.checklist.repository.ChecklistRepository;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.jobplan.dto.ConfinedPlaceJobPlanPermissionDto;
import com.airpremia.eosh.jobplan.dto.FirearmsJobPlanPermissionDto;
import com.airpremia.eosh.jobplan.dto.JobEmployeeDto;
import com.airpremia.eosh.jobplan.dto.JobEmployeeProtectGearCheckDto;
import com.airpremia.eosh.jobplan.dto.JobPlanDto;
import com.airpremia.eosh.jobplan.dto.JobWalkieTalkieDto;
import com.airpremia.eosh.jobplan.dto.ManageSupervisionEmployeeDto;
import com.airpremia.eosh.jobplan.dto.SafetyHealthMeasuresRequirementsDto;
import com.airpremia.eosh.jobplan.dto.WorldVehiclesLoadUnloadCarryMachineDto;
import com.airpremia.eosh.jobplan.repository.ConfinedPlaceJobPlanPermissionRepository;
import com.airpremia.eosh.jobplan.repository.FirearmsJobPlanPermissionRepository;
import com.airpremia.eosh.jobplan.repository.JobEmployeeProtectGearCheckRepository;
import com.airpremia.eosh.jobplan.repository.JobEmployeeRepository;
import com.airpremia.eosh.jobplan.repository.JobPlanRepository;
import com.airpremia.eosh.jobplan.repository.JobWalkieTalkieRepository;
import com.airpremia.eosh.jobplan.repository.ManageSupervisionEmployeeRepository;
import com.airpremia.eosh.jobplan.repository.SafetyHealthMeasuresRequirementsRepository;
import com.airpremia.eosh.jobplan.repository.WorldVehiclesLoadUnloadCarryMachineRepository;
import com.airpremia.eosh.jobplan.request.ConfinedPlaceJobPlanPermissionRequest;
import com.airpremia.eosh.jobplan.request.FirearmsJobPlanPermissionRequest;
import com.airpremia.eosh.jobplan.request.JobEmployeeProtectGearCheckRequest;
import com.airpremia.eosh.jobplan.request.JobEmployeeRequest;
import com.airpremia.eosh.jobplan.request.JobPlanRequest;
import com.airpremia.eosh.jobplan.request.JobPlanSearchRequest;
import com.airpremia.eosh.jobplan.request.JobWalkieTalkieRequest;
import com.airpremia.eosh.jobplan.request.ManageSupervisionEmployeeRequest;
import com.airpremia.eosh.jobplan.request.SafetyHealthMeasuresRequirementsRequest;
import com.airpremia.eosh.jobplan.request.WorldVehiclesLoadUnloadCarryMachineRequest;
import com.airpremia.eosh.jobplan.response.ConfinedPlaceJobPlanPermissionResponse;
import com.airpremia.eosh.jobplan.response.FirearmsJobPlanPermissionResponse;
import com.airpremia.eosh.jobplan.response.JobEmployeeProtectGearCheckResponse;
import com.airpremia.eosh.jobplan.response.JobEmployeeResponse;
import com.airpremia.eosh.jobplan.response.JobPlanResponse;
import com.airpremia.eosh.jobplan.response.JobWalkieTalkieResponse;
import com.airpremia.eosh.jobplan.response.ManageSupervisionEmployeeResponse;
import com.airpremia.eosh.jobplan.response.SafetyHealthMeasuresRequirementsResponse;
import com.airpremia.eosh.jobplan.response.WorldVehiclesLoadUnloadCarryMachineResponse;
import com.airpremia.eosh.personaldetail.basicinfo.controller.UserQualificationItemResponse;
import com.airpremia.eosh.personaldetail.basicinfo.dto.UserQualificationItemDto;
import com.airpremia.eosh.personaldetail.basicinfo.repository.UserQualificationItemRepository;
import com.airpremia.eosh.toolboxmeeting.dto.ToolBoxMeetingDto;
import com.airpremia.eosh.toolboxmeeting.repository.ToolBoxMeetingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobPlanService {
    private final JobPlanRepository jobPlanRepository;
    private final JobEmployeeRepository jobEmployeeRepository;
    private final ManageSupervisionEmployeeRepository manageSupervisionEmployeeRepository;
    private final JobEmployeeProtectGearCheckRepository jobEmployeeProtectGearCheckRepository;
    private final UserQualificationItemRepository userQualificationItemRepository;
    private final JobWalkieTalkieRepository jobWalkieTalkieRepository;
    private final SafetyHealthMeasuresRequirementsRepository safetyHealthMeasuresRequirementsRepository;
    private final ConfinedPlaceJobPlanPermissionRepository confinedPlaceJobPlanPermissionRepository;
    private final FirearmsJobPlanPermissionRepository firearmsJobPlanPermissionRepository;
    private final WorldVehiclesLoadUnloadCarryMachineRepository worldVehiclesLoadUnloadCarryMachineRepository;
    private final ToolBoxMeetingRepository toolBoxMeetingRepository;
    private final ChecklistRepository checklistRepository;

    public Page<JobPlanResponse> selectJobPlanPage(
        JobPlanSearchRequest req, Pageable pageable) {

        JobPlanDto dto = new JobPlanDto(req);
        Page<JobPlanDto> pageDto = jobPlanRepository.selectJobPlanPage(dto, pageable);

        return pageDto.map(JobPlanResponse::new);
    }

    public JobPlanResponse selectJobPlanDetail(Long jobSeq) {
        JobPlanDto dto = jobPlanRepository.selectJobPlan(jobSeq);
        List<ManageSupervisionEmployeeResponse> managerList =
            manageSupervisionEmployeeRepository.selectManageSupervisionEmployeeJobList(jobSeq).stream()
                .map(ManageSupervisionEmployeeDto::convertManageSupervisionEmployeeResponse).toList();

        List<JobEmployeeResponse> employeeList =
            jobEmployeeRepository.selectJobEmployeeJobList(jobSeq).stream()
                .map(JobEmployeeDto::convertJobEmployeeResponse).toList();

        List<JobEmployeeProtectGearCheckResponse> employeeProtectGearList =
            jobEmployeeRepository.jobEmployeeProtectGearList(jobSeq).stream()
                .map(JobEmployeeProtectGearCheckDto::convertJobEmployeeProtectGearCheckResponse).toList();

        List<JobWalkieTalkieResponse> jobWalkieTalkieList =
            jobWalkieTalkieRepository.selectJobWalkieTalkie(jobSeq).stream()
                .map(JobWalkieTalkieDto::convertJobWalkieTalkieResponse).toList();

        List<SafetyHealthMeasuresRequirementsResponse> safetyRequirementList =
            safetyHealthMeasuresRequirementsRepository.selectSafetyHealthMeasuresRequirements(jobSeq).stream()
                .map(SafetyHealthMeasuresRequirementsDto::convertSafetyHealthMeasuresRequirementsResponse).toList();

        ConfinedPlaceJobPlanPermissionResponse confinedPlacePermission =
            Optional.ofNullable(confinedPlaceJobPlanPermissionRepository.selectConfinedPlaceJobPlanPermission(jobSeq))
                .map(ConfinedPlaceJobPlanPermissionDto::convertConfinedPlaceJobPlanPermissionResponse)
                .orElse(null);

        FirearmsJobPlanPermissionResponse firearmsPermission =
            Optional.ofNullable(firearmsJobPlanPermissionRepository.selectFirearmsJobPlanPermission(jobSeq))
                .map(FirearmsJobPlanPermissionDto::convertFirearmsJobPlanPermissionResponse)
                .orElse(null);

        WorldVehiclesLoadUnloadCarryMachineResponse vehiclesJobPlan =
            Optional.ofNullable(
                    worldVehiclesLoadUnloadCarryMachineRepository.selectWorldVehiclesLoadUnloadCarryMachine(jobSeq))
                .map(WorldVehiclesLoadUnloadCarryMachineDto::convertWorldVehiclesLoadUnloadCarryMachineResponse)
                .orElse(null);

        JobPlanResponse response = new JobPlanResponse(dto);
        response.setChecklistSeq(checklistRepository.selectChecklistByJobPlanSeq(jobSeq));
        response.setManagerList(managerList);
        response.setEmployeeList(employeeList);
        response.setEmployeeProtectGearList(employeeProtectGearList);
        response.setJobWalkieTalkieList(jobWalkieTalkieList);
        response.setSafetyRequirementList(safetyRequirementList);
        response.setConfinedPlacePermission(confinedPlacePermission);
        response.setFirearmsPermission(firearmsPermission);
        response.setVehiclesJobPlan(vehiclesJobPlan);
        return response;
    }

    public Long getJobEmployeeSeq(String userSeq, Long jobSeq) {
        return Optional.ofNullable(jobEmployeeRepository.getJobEmployeeSeq(userSeq, jobSeq)).orElse(null);
    }

    @Transactional
    public Long insertJobPlan(JobPlanRequest request) {
        JobPlanDto dto = new JobPlanDto(request);
        jobPlanRepository.insertJobPlan(dto);

        processJobPlanRelationsForInsert(request, dto.getJobSeq());

        return dto.getJobSeq();
    }

    private void processJobPlanRelationsForInsert(JobPlanRequest request, long jobSeq) {
        saveManageSupervisionEmployeeFunction(request.getManagerList(), jobSeq);
        saveJobEmployeeFunction(request.getEmployeeList(), jobSeq);

        processEmployeeProtectGear(jobSeq);
        processJobClassificationSpecificTasks(request, jobSeq);
    }

    private void processEmployeeProtectGear(long jobSeq) {
        List<JobEmployeeProtectGearCheckDto> insertList = findInsertProtectGearList(jobSeq);
        if (!insertList.isEmpty()) {
            insertJobEmployeeProtectGear(insertList);
        }
    }

    @Transactional
    public int updateJobPlan(JobPlanRequest request) {
        JobPlanDto dto = new JobPlanDto(request);
        int result = 0;
        result += jobPlanRepository.updateJobPlan(dto);

        result += processJobPlanRelationsForUpdate(request, dto.getJobSeq());

        return result;
    }

    private int processJobPlanRelationsForUpdate(JobPlanRequest request, long jobSeq) {
        int result = 0;
        result += saveManageSupervisionEmployeeFunction(request.getManagerList(), jobSeq);
        result += saveJobEmployeeFunction(request.getEmployeeList(), jobSeq);
        result += saveJobEmployeeProtectGearCheckFunction(request.getEmployeeProtectGearList(), jobSeq);
        result += saveJobWalkieTalkieFunction(request.getJobWalkieTalkieList(), jobSeq);
        result += saveFirearmsSafetyRequirementFunction(request.getSafetyRequirementList(), jobSeq);

        result += processJobClassificationSpecificTasks(request, jobSeq);
        return result;
    }

    private int processJobClassificationSpecificTasks(JobPlanRequest request, long jobSeq) {
        int result = 0;
        if (request.getJobClassificationEnum().isConfinedPlace()) {
            result += saveConfinedPlaceJobPlanPermissionFunction(request.getConfinedPlacePermission(), jobSeq);
        }
        if (request.getJobClassificationEnum().isFirearmsJob()) {
            result += saveFirearmsJobPlanPermissionFunction(request.getFirearmsPermission(), jobSeq);
        }
        if (request.getJobClassificationEnum().isWorldVechicles()) {
            result += saveWorldVehiclesLoadUnloadCarryMachineFunction(request.getVehiclesJobPlan(), jobSeq);
        }
        return result;
    }

    private int saveManageSupervisionEmployeeFunction(List<ManageSupervisionEmployeeRequest> managerList, long jobSeq) {
        int result = 0;
        if (managerList == null || managerList.isEmpty()) {
            return result;
        }

        List<ManageSupervisionEmployeeDto> convertList = managerList.stream().map(request -> {
            ManageSupervisionEmployeeDto dto = request.convertManageSupervisionEmployeeDto();
            dto.setJobSeq(jobSeq);
            return dto;
        }).toList();

        List<ManageSupervisionEmployeeDto> insertList = convertList.stream()
            .filter(item -> item.getManageSupervisionEmployeeSeq() == null).toList();

        List<ManageSupervisionEmployeeDto> updateList = convertList.stream()
            .filter(item -> item.getManageSupervisionEmployeeSeq() != null).toList();

        List<Long> deleteList =
            manageSupervisionEmployeeRepository.selectManageSupervisionEmployeeJobList(jobSeq).stream()
                .map(ManageSupervisionEmployeeDto::getManageSupervisionEmployeeSeq)
                .filter(
                    seq -> managerList.stream().noneMatch(front -> seq.equals(front.getManageSupervisionEmployeeSeq())))
                .toList();

        if (!deleteList.isEmpty()) {
            result += deleteManageSupervisionEmployee(deleteList);
        }

        if (!updateList.isEmpty()) {
            result += updateManageSupervisionEmployee(updateList);
        }
        if (!insertList.isEmpty()) {
            result += insertManageSupervisionEmployeeList(insertList);
        }
        return result;
    }

    private int deleteManageSupervisionEmployee(List<Long> deleteList) {
        if (deleteList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return manageSupervisionEmployeeRepository.deleteManageSupervisionEmployeeList(deleteList);
    }

    private int updateManageSupervisionEmployee(List<ManageSupervisionEmployeeDto> updateList) {
        if (updateList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return updateList.stream()
            .map(manageSupervisionEmployeeRepository::updateManageSupervisionEmployee)
            .reduce(0, Integer::sum);
    }

    private int insertManageSupervisionEmployeeList(List<ManageSupervisionEmployeeDto> insertList) {
        if (insertList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return manageSupervisionEmployeeRepository.insertManageSupervisionEmployeeList(insertList);
    }

    private int saveJobEmployeeFunction(List<JobEmployeeRequest> employeeList, long jobSeq) {
        int result = 0;
        if (employeeList == null || employeeList.isEmpty()) {
            return result;
        }
        List<JobEmployeeDto> convertList = employeeList.stream().map(request -> {
            JobEmployeeDto dto = request.convertJobEmployeeDto();
            dto.setJobSeq(jobSeq);
            return dto;
        }).toList();

        List<JobEmployeeDto> insertList =
            convertList.stream().filter(item -> item.getJobEmployeeSeq() == null).toList();

        List<JobEmployeeDto> updateList =
            convertList.stream().filter(item -> item.getJobEmployeeSeq() != null).toList();

        List<Long> deleteList = jobEmployeeRepository.selectJobEmployeeJobList(jobSeq).stream()
            .map(JobEmployeeDto::getJobEmployeeSeq)
            .filter(seq -> employeeList.stream().noneMatch(front -> seq.equals(front.getJobEmployeeSeq()))).toList();

        if (!deleteList.isEmpty()) {
            result += deleteJobEmployee(deleteList);
        }

        if (!updateList.isEmpty()) {
            result += updateJobEmployee(updateList);
        }
        if (!insertList.isEmpty()) {
            result += insertJobEmployeeList(insertList);
        }
        return result;
    }

    private int deleteJobEmployee(List<Long> deleteList) {
        if (deleteList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return jobEmployeeRepository.deleteJobEmployeeList(deleteList);
    }

    private int updateJobEmployee(List<JobEmployeeDto> updateList) {
        if (updateList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return updateList.stream()
            .map(jobEmployeeRepository::updateJobEmployee)
            .reduce(0, Integer::sum);
    }

    private int insertJobEmployeeList(List<JobEmployeeDto> insertList) {
        if (insertList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return jobEmployeeRepository.insertJobEmployeeList(insertList);
    }

    private int saveJobEmployeeProtectGearCheckFunction(
        List<JobEmployeeProtectGearCheckRequest> employeeProtectGearList, long jobSeq) {
        int result = 0;
        if (employeeProtectGearList == null || employeeProtectGearList.isEmpty()) {
            return result;
        }

        List<JobEmployeeProtectGearCheckDto> convertList = employeeProtectGearList.stream().map(request -> {
            JobEmployeeProtectGearCheckDto dto = request.convertJobEmployeeProtectGearCheckDto();
            dto.setJobSeq(jobSeq);
            return dto;
        }).toList();

        List<JobEmployeeProtectGearCheckDto> insertList = findInsertProtectGearList(jobSeq);

        List<JobEmployeeProtectGearCheckDto> updateList =
            convertList.stream().filter(dto -> dto.getProtectGearCheckSeq() != null).toList();

        List<Long> deleteList = jobEmployeeRepository.jobEmployeeProtectGearList(jobSeq).stream()
            .map(JobEmployeeProtectGearCheckDto::getProtectGearCheckSeq)
            .filter(seq -> convertList.stream().noneMatch(dto -> seq.equals(dto.getProtectGearCheckSeq()))).toList();

        if (!deleteList.isEmpty()) {
            result += deleteJobEmployeeProtectGear(deleteList);
        }
        if (!updateList.isEmpty()) {
            result += updateJobEmployeeProtectGear(updateList);
        }
        if (!insertList.isEmpty()) {
            result += insertJobEmployeeProtectGear(insertList);
        }
        return result;
    }

    private List<JobEmployeeProtectGearCheckDto> findInsertProtectGearList(long jobSeq) {
        List<JobEmployeeDto> registeredEmployeeList = jobEmployeeRepository.selectJobEmployeeJobList(jobSeq);
        List<JobEmployeeProtectGearCheckDto> registeredGearCheckList =
            jobEmployeeProtectGearCheckRepository.selectJobEmployeeProtectGearCheckList(jobSeq);

        return registeredEmployeeList.stream()
            .filter(data -> registeredGearCheckList.stream()
                .noneMatch(n -> data.getJobEmployeeSeq().equals(n.getJobEmployeeSeq())))
            .map(data -> new JobEmployeeProtectGearCheckDto(jobSeq, data.getJobEmployeeSeq(), false))
            .toList();
    }

    private int deleteJobEmployeeProtectGear(List<Long> deleteList) {
        if (deleteList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return jobEmployeeProtectGearCheckRepository.deleteJobEmployeeProtectGearCheckList(deleteList);
    }

    private int updateJobEmployeeProtectGear(List<JobEmployeeProtectGearCheckDto> updateList) {
        if (updateList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return updateList.stream()
            .map(jobEmployeeProtectGearCheckRepository::updateJobEmployeeProtectGearCheck)
            .reduce(0, Integer::sum);
    }

    private int insertJobEmployeeProtectGear(List<JobEmployeeProtectGearCheckDto> registeredEmployeeList) {
        if (registeredEmployeeList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return jobEmployeeProtectGearCheckRepository.insertJobEmployeeProtectGearCheckList(registeredEmployeeList);
    }

    private int saveJobWalkieTalkieFunction(List<JobWalkieTalkieRequest> jobWalkieTalkieList, long jobSeq) {
        int result = 0;
        if (jobWalkieTalkieList == null || jobWalkieTalkieList.isEmpty()) {
            return result;
        }

        List<JobWalkieTalkieDto> convertList = jobWalkieTalkieList.stream().map(request -> {
            JobWalkieTalkieDto dto = request.convertJobWalkieTalkieDto();
            dto.setJobSeq(jobSeq);
            return dto;
        }).toList();

        List<JobWalkieTalkieDto> insertList =
            convertList.stream().filter(dto -> dto.getJobWalkieTalkieSeq() == null).toList();

        List<JobWalkieTalkieDto> updateList =
            convertList.stream().filter(dto -> dto.getJobWalkieTalkieSeq() != null).toList();

        List<Long> deleteList = jobWalkieTalkieRepository.selectJobWalkieTalkie(jobSeq).stream()
            .map(JobWalkieTalkieDto::getJobWalkieTalkieSeq)
            .filter(seq -> convertList.stream().noneMatch(dto -> seq.equals(dto.getJobWalkieTalkieSeq()))).toList();

        if (!deleteList.isEmpty()) {
            result += deleteJobWalkieTalkie(deleteList);
        }
        if (!updateList.isEmpty()) {
            result += updateJobWalkieTalkie(updateList);
        }
        if (!insertList.isEmpty()) {
            result += insertJobWalkieTalkie(insertList);
        }
        return result;
    }

    private int deleteJobWalkieTalkie(List<Long> deleteList) {
        if (deleteList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return jobWalkieTalkieRepository.deleteJobWalkieTalkieList(deleteList);
    }

    private int updateJobWalkieTalkie(List<JobWalkieTalkieDto> updateList) {
        if (updateList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return updateList.stream().map(jobWalkieTalkieRepository::updateJobWalkieTalkie).reduce(0, Integer::sum);
    }

    private int insertJobWalkieTalkie(List<JobWalkieTalkieDto> insertList) {
        if (insertList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return jobWalkieTalkieRepository.insertJobWalkieTalkieList(insertList);
    }

    private int saveFirearmsSafetyRequirementFunction(
        List<SafetyHealthMeasuresRequirementsRequest> safetyRequirementList, long jobSeq) {
        int result = 0;
        if (safetyRequirementList == null || safetyRequirementList.isEmpty()) {
            return result;
        }

        List<SafetyHealthMeasuresRequirementsDto> convertList = safetyRequirementList.stream().map(request -> {
            SafetyHealthMeasuresRequirementsDto dto = request.convertSafetyHealthMeasuresRequirementsDto();
            dto.setJobSeq(jobSeq);
            return dto;
        }).toList();

        List<SafetyHealthMeasuresRequirementsDto> insertList =
            convertList.stream().filter(dto -> dto.getSafetyHealthMeasuresRequirementsSeq() == null).toList();

        List<SafetyHealthMeasuresRequirementsDto> updateList =
            convertList.stream().filter(dto -> dto.getSafetyHealthMeasuresRequirementsSeq() != null).toList();

        List<Long> deleteList =
            safetyHealthMeasuresRequirementsRepository.selectSafetyHealthMeasuresRequirements(jobSeq).stream()
                .map(SafetyHealthMeasuresRequirementsDto::getSafetyHealthMeasuresRequirementsSeq)
                .filter(seq -> convertList.stream()
                    .noneMatch(dto -> seq.equals(dto.getSafetyHealthMeasuresRequirementsSeq()))).toList();

        if (!deleteList.isEmpty()) {
            result += deleteSafetyRequirements(deleteList);
        }
        if (!updateList.isEmpty()) {
            result += updateSafetyRequirements(updateList);
        }
        if (!insertList.isEmpty()) {
            result += insertSafetyRequirements(insertList);
        }
        return result;
    }

    private int deleteSafetyRequirements(List<Long> deleteList) {
        if (deleteList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return safetyHealthMeasuresRequirementsRepository.deleteSafetyHealthMeasuresRequirementsList(deleteList);
    }

    private int updateSafetyRequirements(List<SafetyHealthMeasuresRequirementsDto> updateList) {
        if (updateList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return updateList.stream()
            .map(safetyHealthMeasuresRequirementsRepository::updateSafetyHealthMeasuresRequirements)
            .reduce(0, Integer::sum);
    }

    private int insertSafetyRequirements(List<SafetyHealthMeasuresRequirementsDto> insertList) {
        if (insertList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }
        return safetyHealthMeasuresRequirementsRepository.insertSafetyHealthMeasuresRequirementsList(insertList);
    }

    private int saveConfinedPlaceJobPlanPermissionFunction(
        ConfinedPlaceJobPlanPermissionRequest confinedPlacePermission, long jobSeq) {
        int result = 0;
        if (confinedPlacePermission == null) {
            return result;
        }
        confinedPlacePermission.setJobSeq(jobSeq);
        ConfinedPlaceJobPlanPermissionDto confinedPlaceJobPlan =
            confinedPlaceJobPlanPermissionRepository.selectConfinedPlaceJobPlanPermission(jobSeq);
        if (confinedPlaceJobPlan == null) {
            result += confinedPlaceJobPlanPermissionRepository.insertConfinedPlaceJobPlanPermission(
                confinedPlacePermission.convertConfinedPlaceJobPlanPermissionDto());
        } else {
            result += confinedPlaceJobPlanPermissionRepository.updateConfinedPlaceJobPlanPermissionHarmful(
                confinedPlacePermission.convertConfinedPlaceJobPlanPermissionDto());
        }
        return result;
    }

    private int saveFirearmsJobPlanPermissionFunction(
        FirearmsJobPlanPermissionRequest firearmsPermission, long jobSeq) {
        int result = 0;
        if (firearmsPermission == null) {
            return result;
        }
        firearmsPermission.setJobSeq(jobSeq);
        FirearmsJobPlanPermissionDto firearmsJobPlan =
            firearmsJobPlanPermissionRepository.selectFirearmsJobPlanPermission(jobSeq);
        if (firearmsJobPlan == null) {
            result += firearmsJobPlanPermissionRepository.insertFirearmsJobPlanPermission(
                firearmsPermission.convertFirearmsJobPlanPermissionDto());
        } else {
            result += firearmsJobPlanPermissionRepository.updateFirearmsJobPlanPermission(
                firearmsPermission.convertFirearmsJobPlanPermissionDto());
        }
        return result;
    }

    private int saveWorldVehiclesLoadUnloadCarryMachineFunction(
        WorldVehiclesLoadUnloadCarryMachineRequest vehiclesJobPlan, long jobSeq) {
        int result = 0;
        if (vehiclesJobPlan == null) {
            return result;
        }
        vehiclesJobPlan.setJobSeq(jobSeq);
        WorldVehiclesLoadUnloadCarryMachineDto vehiclesMachineJobPlan =
            worldVehiclesLoadUnloadCarryMachineRepository.selectWorldVehiclesLoadUnloadCarryMachine(jobSeq);
        if (vehiclesMachineJobPlan == null) {
            result += worldVehiclesLoadUnloadCarryMachineRepository.insertWorldVehiclesLoadUnloadCarryMachine(
                vehiclesJobPlan.convertWorldVehiclesLoadUnloadCarryMachineDto());
        } else {
            result += worldVehiclesLoadUnloadCarryMachineRepository.updateWorldVehiclesLoadUnloadCarryMachine(
                vehiclesJobPlan.convertWorldVehiclesLoadUnloadCarryMachineDto());
        }
        return result;
    }

    public int updateJobEmployeeProtectGearCheck(JobEmployeeProtectGearCheckRequest req) {
        JobEmployeeProtectGearCheckDto dto = new JobEmployeeProtectGearCheckDto(req);
        return jobEmployeeProtectGearCheckRepository.updateJobEmployeeProtectGearCheck(dto);
    }

    public List<JobEmployeeProtectGearCheckDto> jobEmployeeProtectGearList(Long jobSeq) {
        return jobEmployeeRepository.jobEmployeeProtectGearList(jobSeq);
    }

    public List<UserQualificationItemResponse> selectUserQualificationItemByUserId(String userSeq) {
        return userQualificationItemRepository.selectUserQualificationItemByUserId(userSeq).stream()
            .map(UserQualificationItemDto::convertUserQualificationItemResponse).toList();
    }

    public int updateJobEmployeeSignature(JobEmployeeRequest req) {
        JobEmployeeDto dto = new JobEmployeeDto(req);
        return jobEmployeeRepository.updateJobEmployeeSignature(dto);
    }

    @Transactional
    public int createToolBoxMeeting(JobPlanRequest request) {
        int result = 0;
        ToolBoxMeetingDto tbmDto = new ToolBoxMeetingDto(request);
        result += toolBoxMeetingRepository.insertToolBoxMeeting(tbmDto);

        request.getManagerList().forEach(req -> req.setToolBoxMeetingSeq(tbmDto.getToolBoxMeetingSeq()));
        request.getEmployeeList().forEach(req -> req.setToolBoxMeetingSeq(tbmDto.getToolBoxMeetingSeq()));

        result += saveManageSupervisionEmployeeFunction(request.getManagerList(), request.getJobSeq());
        result += saveJobEmployeeFunction(request.getEmployeeList(), request.getJobSeq());

        return result;
    }

    @Transactional
    public int deleteJobPlan(List<JobPlanRequest> deleteList) {
        List<Long> deleteSeqList = deleteList.stream().map(JobPlanRequest::getJobSeq).toList();
        int result = 0;

        result += jobEmployeeRepository.deleteJobEmployeeList(deleteSeqList);
        result += manageSupervisionEmployeeRepository.deleteManageSupervisionEmployeeList(deleteSeqList);
        result += jobEmployeeProtectGearCheckRepository.deleteJobEmployeeProtectGearCheckList(deleteSeqList);
        result += jobWalkieTalkieRepository.deleteJobWalkieTalkieListByJobPlanSeq(deleteSeqList);
        result +=
            worldVehiclesLoadUnloadCarryMachineRepository.deleteWorldVehiclesLoadUnloadCarryMachine(deleteSeqList);
        result +=
            firearmsJobPlanPermissionRepository.deleteFirearmsJobPlanPermission(deleteSeqList);
        result +=
            confinedPlaceJobPlanPermissionRepository.deleteConfinedPlaceJobPlanPermission(deleteSeqList);
        result += jobPlanRepository.deleteJobPlan(deleteSeqList);

        return result;
    }
}
