package com.airpremia.eosh.jobplan.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SafetyHealthMeasuresRequirementsResponse {
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
}
