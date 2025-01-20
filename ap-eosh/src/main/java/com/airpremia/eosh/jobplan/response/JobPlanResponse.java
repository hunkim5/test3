package com.airpremia.eosh.jobplan.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.jobplan.dto.JobPlanDto;
import com.airpremia.eosh.jobplan.enums.JobClassificationCodeEnum;
import com.airpremia.eosh.jobplan.enums.JobPlanPerformEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobPlanResponse {
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "'안전점검회의' 시퀀스")
    private Long toolBoxMeetingSeq;
    @Schema(description = "점검표 시퀀스")
    private Long checklistSeq;
    @Schema(description = "작업 분류 코드")
    private JobClassificationCodeEnum jobClassificationEnum;
    @Schema(description = "작업 제목")
    private String jobSubject;
    @Schema(description = "작업 시작 날짜")
    private LocalDate jobStartDt;
    @Schema(description = "작업 종료 날짜")
    private LocalDate jobEndDt;
    @Schema(description = "작업 내용")
    private String jobContent;
    @Schema(description = "사용할 도구 및 장비")
    private String workEquipmentContent;
    @Schema(description = "'작업계획서' 수행 ENUM")
    private JobPlanPerformEnum jobPlanPerformEnum;
    @Schema(description = "작성자 아이디")
    private String inchargeUserId;
    @Schema(description = "작성자 이름")
    private String inchargeUserName;
    @Schema(description = "작성자 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "작성자 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 일시")
    private LocalDateTime insertDtm;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;
    @Schema(description = "관리감독자")
    private List<ManageSupervisionEmployeeResponse> managerList;
    @Schema(description = "근로자")
    private List<JobEmployeeResponse> employeeList;
    @Schema(description = "근로자 보호구 확인")
    private List<JobEmployeeProtectGearCheckResponse> employeeProtectGearList;
    @Schema(description = "워키토키")
    private List<JobWalkieTalkieResponse> jobWalkieTalkieList;
    @Schema(description = "안전보건조치 요구사항")
    private List<SafetyHealthMeasuresRequirementsResponse> safetyRequirementList;
    @Schema(description = "밀폐 공간 작업 계획서 및 허가서")
    private ConfinedPlaceJobPlanPermissionResponse confinedPlacePermission;
    @Schema(description = "화기 작업 계획서 및 허가서")
    private FirearmsJobPlanPermissionResponse firearmsPermission;
    @Schema(description = "차량계 하역 운반 기계 작업 계획서")
    private WorldVehiclesLoadUnloadCarryMachineResponse vehiclesJobPlan;

    public JobPlanResponse(JobPlanDto dto) {
        this.jobSeq = dto.getJobSeq();
        this.toolBoxMeetingSeq = dto.getToolBoxMeetingSeq();
        this.checklistSeq = dto.getChecklistSeq();
        this.jobClassificationEnum = dto.getJobClassificationEnum();
        this.jobSubject = dto.getJobSubject();
        this.jobStartDt = dto.getJobStartDt();
        this.jobEndDt = dto.getJobEndDt();
        this.jobContent = dto.getJobContent();
        this.workEquipmentContent = dto.getWorkEquipmentContent();
        this.jobPlanPerformEnum = dto.getJobPlanPerformEnum();
        this.inchargeUserId = dto.getInchargeUserId();
        this.inchargeUserName = dto.getInchargeUserName();
        this.inchargeDepartmentId = dto.getInchargeDepartmentId();
        this.inchargeDepartmentName = dto.getInchargeDepartmentName();
        this.insertUserId = dto.getInsertUserId();
        this.insertDtm = dto.getInsertDtm();
        this.insertIp = dto.getInsertIp();
        this.updateUserId = dto.getUpdateUserId();
        this.updateDtm = dto.getUpdateDtm();
        this.updateIp = dto.getUpdateIp();
    }
}

