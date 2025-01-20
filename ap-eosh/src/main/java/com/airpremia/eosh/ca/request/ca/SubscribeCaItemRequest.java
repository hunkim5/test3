package com.airpremia.eosh.ca.request.ca;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.ca.entities.SubscribeCaItemEntity;
import com.airpremia.eosh.ca.enums.CaAppvalprcEnum;
import com.airpremia.eosh.ca.request.incharge.SubscribeCaItemInchargeRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubscribeCaItemRequest {
    @Schema(description = "담당자 목록")
    List<SubscribeCaItemInchargeRequest> inchargeList;
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
    @Schema(description = "CA 수정 여부")
    private Boolean editBool;

    public SubscribeCaItemEntity toEntity() {
        SubscribeCaItemEntity entity = new SubscribeCaItemEntity();

        entity.setSubscribeCaItemSeq(this.subscribeCaItemSeq);
        entity.setSubscribeCaUuid(this.subscribeCaUuid);
        entity.setCaId(this.caId);
        entity.setCaAppvalprcEnum(this.caAppvalprcEnum);
        entity.setInchargeUserId(this.inchargeUserId);
        entity.setInchargeUserName(this.inchargeUserName);
        entity.setInchargeDepartmentId(this.inchargeDepartmentId);
        entity.setInchargeDepartmentName(this.inchargeDepartmentName);
        entity.setCaSubject(this.caSubject);
        entity.setCaContent(this.caContent);
        entity.setCaDeadlineDt(this.caDeadlineDt);
        entity.setCapContent(this.capContent);
        entity.setCapRootCauseContent(this.capRootCauseContent);
        entity.setCapMultipleFileUuid(this.capMultipleFileUuid);
        entity.setCapExpectCompleteDt(this.capExpectCompleteDt);
        entity.setCaiContent(this.caiContent);
        entity.setCaiCompleteDt(this.caiCompleteDt);
        entity.setCaiMultipleFileUuid(this.caiMultipleFileUuid);
        entity.setFeedbackContent(this.feedbackContent);

        return entity;
    }
}
