package com.airpremia.eosh.ca.response.ca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.ca.entities.SubscribeCaItemEntity;
import com.airpremia.eosh.ca.enums.CaAppvalprcEnum;
import com.airpremia.eosh.ca.response.incharge.SubscribeCaItemInchargeResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SubscribeCaItemResponse {
    @Schema(description = "담당자 목록")
    List<SubscribeCaItemInchargeResponse> inchargeList;
    @Schema(description = "구독 시정조치 항목 시퀀스")
    private Long subscribeCaItemSeq;
    @Schema(description = "구독 시정조치 UUID")
    private String subscribeCaUuid;
    @Schema(description = "시정조치 아이디")
    private String caId;
    @Schema(description = "시정조치 승인절차 ENUM")
    private CaAppvalprcEnum caAppvalprcEnum;
    @Schema(description = "담당 사용자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당 사용자 이름")
    private String inchargeUserName;
    @Schema(description = "담당 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "담당 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "시정조치 제목")
    private String caSubject;
    @Schema(description = "시정조치 내용")
    private String caContent;
    @Schema(description = "시정조치 마감 날짜")
    private LocalDate caDeadlineDt;
    @Schema(description = "시정조치계획 내용")
    private String capContent;
    @Schema(description = "시정조치계획 ROOT 원인 내용")
    private String capRootCauseContent;
    @Schema(description = "시정조치계획 다중 파일 UUID")
    private String capMultipleFileUuid;
    @Schema(description = "시정조치계획 예상 완료 날짜")
    private LocalDate capExpectCompleteDt;
    @Schema(description = "시정조치검사 내용")
    private String caiContent;
    @Schema(description = "시정조치검사 완료 날짜")
    private LocalDate caiCompleteDt;
    @Schema(description = "시정조치검사 다중 파일 UUID")
    private String caiMultipleFileUuid;
    @Schema(description = "FEEDBACK 내용")
    private String feedbackContent;
    @Schema(description = "삽입 일자")
    private LocalDateTime insertDtm;


    public SubscribeCaItemResponse(SubscribeCaItemEntity entity) {
        this.subscribeCaItemSeq = entity.getSubscribeCaItemSeq();
        this.subscribeCaUuid = entity.getSubscribeCaUuid();
        this.caId = entity.getCaId();
        this.caAppvalprcEnum = entity.getCaAppvalprcEnum();
        this.inchargeUserId = entity.getInchargeUserId();
        this.inchargeUserName = entity.getInchargeUserName();
        this.inchargeDepartmentId = entity.getInchargeDepartmentId();
        this.inchargeDepartmentName = entity.getInchargeDepartmentName();
        this.caSubject = entity.getCaSubject();
        this.caContent = entity.getCaContent();
        this.caDeadlineDt = entity.getCaDeadlineDt();
        this.capContent = entity.getCapContent();
        this.capRootCauseContent = entity.getCapRootCauseContent();
        this.capMultipleFileUuid = entity.getCapMultipleFileUuid();
        this.capExpectCompleteDt = entity.getCapExpectCompleteDt();
        this.caiContent = entity.getCaiContent();
        this.caiCompleteDt = entity.getCaiCompleteDt();
        this.caiMultipleFileUuid = entity.getCaiMultipleFileUuid();
        this.feedbackContent = entity.getFeedbackContent();
        this.insertDtm = entity.getInsertDtm();
    }
}
