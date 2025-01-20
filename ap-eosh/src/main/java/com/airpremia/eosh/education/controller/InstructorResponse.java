package com.airpremia.eosh.education.controller;

import java.time.LocalDate;

import com.airpremia.eosh.education.dto.InstructorDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InstructorResponse {

    @Schema(description = "강사 시퀀스")
    private Long instructorSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 이름")
    private String userName;
    @Schema(description = "부서 아이디")
    private String departmentId;
    @Schema(description = "부서 이름")
    private String departmentName;
    @Schema(description = "임명 날짜")
    private LocalDate appointDt;

    public InstructorResponse(InstructorDto dto) {
        this.instructorSeq = dto.getInstructorSeq();
        this.userId = dto.getUserId();
        this.userName = dto.getUserName();
        this.departmentId = dto.getDepartmentId();
        this.departmentName = dto.getDepartmentName();
        this.appointDt = dto.getAppointDt();
    }

}
