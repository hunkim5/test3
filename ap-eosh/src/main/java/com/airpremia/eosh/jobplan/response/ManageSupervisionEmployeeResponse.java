package com.airpremia.eosh.jobplan.response;

import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.dto.ManageSupervisionEmployeeDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ManageSupervisionEmployeeResponse {
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

    public ManageSupervisionEmployeeResponse(ManageSupervisionEmployeeDto req) {
        this.manageSupervisionEmployeeSeq = req.getManageSupervisionEmployeeSeq();
        this.toolBoxMeetingSeq = req.getToolBoxMeetingSeq();
        this.jobSeq = req.getJobSeq();
        this.manageSupervisionEmployeeNumber = req.getManageSupervisionEmployeeNumber();
        this.employeeName = req.getEmployeeName();
        this.departmentCode = req.getDepartmentCode();
        this.departmentName = req.getDepartmentName();
        this.mainBool = req.isMainBool();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }
}

