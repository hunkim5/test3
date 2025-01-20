package com.airpremia.eosh.education.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.education.controller.InstructorRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InstructorDto {

    private Long instructorSeq;
    private String userId;
    private String userName;
    private String departmentId;
    private String departmentName;
    private boolean externalBool;
    private LocalDate appointDt;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String insertUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
    private String updateUserId;

    public InstructorDto(InstructorRequest request) {
        this.instructorSeq = request.getInstructorSeq();
        this.userId = request.getUserId();
        this.userName = request.getUserName();
        this.departmentId = request.getDepartmentId();
        this.departmentName = request.getDepartmentName();
        this.appointDt = LocalDate.now();
        this.insertDtm = request.getInsertDtm();
        this.insertIp = request.getInsertIp();
        this.insertUserId = request.getInsertUserId();
        this.updateDtm = request.getUpdateDtm();
        this.updateIp = request.getUpdateIp();
        this.updateUserId = request.getUpdateUserId();
    }
}
