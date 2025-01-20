package com.airpremia.eosh.jobplan.request;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.dto.JobEmployeeDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobEmployeeRequest {
    @Schema(description = "근로자 시퀀스")
    private Long jobEmployeeSeq;
    @Schema(description = "'안전점검회의' 시퀀스")
    private Long toolBoxMeetingSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "사번")
    private String employeeNumber;
    @Schema(description = "사원명")
    private String employeeName;
    @Schema(description = "부서 코드")
    private String departmentNumber;
    @Schema(description = "부서명")
    private String departmentName;
    @Schema(description = "TBM 여부")
    private boolean tbmBool;
    @Schema(description = "서명 확인")
    private boolean signatureCheck;
    @Schema(description = "입장 일시")
    private LocalDateTime entryDtm;
    @Schema(description = "퇴장 일시")
    private LocalDateTime leaveDtm;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 일시")
    private LocalDateTime updateDtm;
    @Schema(description = "수정 IP")
    private String updateIp;

    public JobEmployeeDto convertJobEmployeeDto() {
        JobEmployeeDto dto = new JobEmployeeDto();
        dto.setJobEmployeeSeq(this.jobEmployeeSeq);
        dto.setToolBoxMeetingSeq(this.toolBoxMeetingSeq);
        dto.setJobSeq(this.jobSeq);
        dto.setEmployeeNumber(this.employeeNumber);
        dto.setEmployeeName(this.employeeName);
        dto.setDepartmentNumber(this.departmentNumber);
        dto.setDepartmentName(this.departmentName);
        dto.setTbmBool(this.tbmBool);
        dto.setSignatureCheck(this.signatureCheck);
        dto.setEntryDtm(this.entryDtm);
        dto.setLeaveDtm(this.leaveDtm);
        dto.setInsertUserId(this.insertUserId);
        dto.setInsertIp(this.insertIp);
        dto.setUpdateUserId(this.updateUserId);
        dto.setUpdateIp(this.updateIp);
        return dto;
    }
}

