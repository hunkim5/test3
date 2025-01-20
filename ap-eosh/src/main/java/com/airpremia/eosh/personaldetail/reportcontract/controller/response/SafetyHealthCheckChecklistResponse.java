package com.airpremia.eosh.personaldetail.reportcontract.controller.response;

import java.time.LocalDateTime;

import com.airpremia.eosh.personaldetail.reportcontract.dto.SafetyHealthCheckChecklistDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SafetyHealthCheckChecklistResponse {

    @Schema(description = "안전 보건 점검 체크리스트 시퀀스")
    private Long safetyHealthCheckChecklistSeq;
    @Schema(description = "계약 시퀀스")
    private Long contractSeq;
    @Schema(description = "체크리스트 코드")
    private String checklistCode;
    @Schema(description = "점수")
    private int score;
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

    public SafetyHealthCheckChecklistResponse(SafetyHealthCheckChecklistDto req) {
        this.safetyHealthCheckChecklistSeq = req.getSafetyHealthCheckChecklistSeq();
        this.contractSeq = req.getContractSeq();
        this.checklistCode = req.getChecklistCode();
        this.score = req.getScore();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }
}
