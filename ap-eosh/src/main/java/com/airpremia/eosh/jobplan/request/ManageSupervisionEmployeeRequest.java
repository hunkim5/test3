package com.airpremia.eosh.jobplan.request;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.dto.ManageSupervisionEmployeeDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ManageSupervisionEmployeeRequest {
    @Schema(description = "관리 감독자 시퀀스")
    private Long manageSupervisionEmployeeSeq;
    @Schema(description = "'안전점검회의' 시퀀스")
    private Long toolBoxMeetingSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "관리 감독 사번")
    private String manageSupervisionEmployeeNumber;
    @Schema(description = "사원명")
    private String employeeName;
    @Schema(description = "부서 코드")
    private String departmentCode;
    @Schema(description = "부서 이름")
    private String departmentName;
    @Schema(description = "메인 여부")
    private boolean mainBool;
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

    public ManageSupervisionEmployeeDto convertManageSupervisionEmployeeDto() {
        ManageSupervisionEmployeeDto dto = new ManageSupervisionEmployeeDto();
        dto.setManageSupervisionEmployeeSeq(this.manageSupervisionEmployeeSeq);
        dto.setToolBoxMeetingSeq(this.toolBoxMeetingSeq);
        dto.setJobSeq(this.jobSeq);
        dto.setManageSupervisionEmployeeNumber(this.manageSupervisionEmployeeNumber);
        dto.setEmployeeName(this.employeeName);
        dto.setDepartmentCode(this.departmentCode);
        dto.setDepartmentName(this.departmentName);
        dto.setMainBool(this.mainBool);
        dto.setInsertUserId(this.insertUserId);
        dto.setInsertDtm(this.insertDtm);
        dto.setInsertIp(this.insertIp);
        dto.setUpdateUserId(this.updateUserId);
        dto.setUpdateDtm(this.updateDtm);
        dto.setUpdateIp(this.updateIp);
        return dto;
    }

}

