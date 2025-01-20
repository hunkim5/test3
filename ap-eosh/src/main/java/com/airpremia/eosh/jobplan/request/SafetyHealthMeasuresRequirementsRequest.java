package com.airpremia.eosh.jobplan.request;

import java.time.LocalDate;

import com.airpremia.eosh.jobplan.dto.SafetyHealthMeasuresRequirementsDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SafetyHealthMeasuresRequirementsRequest {
    @Schema(description = "안전 건강 대책 요구사항 시퀀스")
    private Long safetyHealthMeasuresRequirementsSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "근로자 시퀀스")
    private Long jobEmployeeSeq;
    @Schema(description = "확인 항목 코드")
    private String checkItemCode;
    @Schema(description = "확인 항목 여부")
    private boolean checkItemBool;
    @Schema(description = "확인 항목 비고")
    private String checkItemRemark;
    @Schema(description = "확인 날짜")
    private LocalDate checkDt;

    public SafetyHealthMeasuresRequirementsDto convertSafetyHealthMeasuresRequirementsDto() {
        SafetyHealthMeasuresRequirementsDto dto = new SafetyHealthMeasuresRequirementsDto();
        dto.setSafetyHealthMeasuresRequirementsSeq(this.safetyHealthMeasuresRequirementsSeq);
        dto.setJobSeq(this.jobSeq);
        dto.setJobEmployeeSeq(this.jobEmployeeSeq);
        dto.setCheckItemCode(this.checkItemCode);
        dto.setCheckItemBool(this.checkItemBool);
        dto.setCheckItemRemark(this.checkItemRemark);
        dto.setCheckDt(this.checkDt);
        return dto;
    }
}
