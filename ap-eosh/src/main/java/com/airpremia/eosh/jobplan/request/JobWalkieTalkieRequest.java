package com.airpremia.eosh.jobplan.request;

import com.airpremia.eosh.jobplan.dto.JobWalkieTalkieDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobWalkieTalkieRequest {
    @Schema(description = "작업 워키토키 시퀀스")
    private Long jobWalkieTalkieSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "사번")
    private String employeeNumber;
    @Schema(description = "사원명")
    private String employeeName;
    @Schema(description = "구분")
    private String division;
    @Schema(description = "확인 사번")
    private String checkEmployeeNumber;
    @Schema(description = "확인 여부")
    private boolean checkBool;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 IP")
    private String updateIp;

    public JobWalkieTalkieDto convertJobWalkieTalkieDto() {
        JobWalkieTalkieDto dto = new JobWalkieTalkieDto();
        dto.setJobWalkieTalkieSeq(this.jobWalkieTalkieSeq);
        dto.setJobSeq(this.jobSeq);
        dto.setEmployeeNumber(this.employeeNumber);
        dto.setEmployeeName(this.employeeName);
        dto.setDivision(this.division);
        dto.setCheckEmployeeNumber(this.checkEmployeeNumber);
        dto.setCheckBool(this.checkBool);
        dto.setInsertIp(this.insertIp);
        dto.setUpdateUserId(this.updateUserId);
        dto.setUpdateIp(this.updateIp);
        return dto;
    }
}
