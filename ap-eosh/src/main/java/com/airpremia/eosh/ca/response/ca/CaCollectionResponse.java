package com.airpremia.eosh.ca.response.ca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.ca.dto.SubscribeCaItemWithSourceDto;
import com.airpremia.eosh.ca.entities.SubscribeCaItemEntity;
import com.airpremia.eosh.ca.enums.CaAppvalprcEnum;
import com.airpremia.eosh.ca.enums.SubscribeCaTargetEnum;
import com.airpremia.eosh.ca.response.incharge.SubscribeCaItemInchargeResponse;
import com.airpremia.eosh.issue.enums.IssueTargetEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CaCollectionResponse {
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
    @Schema(description = "삭제 여부")
    private boolean deleteBool = false;
    @Schema(description = "삭제 사용자 아이디")
    private String deleteUserId;
    @Schema(description = "삭제 일시")
    private LocalDateTime deleteDtm;
    @Schema(description = "삭제 IP")
    private String deleteIp;
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
    @Schema(description = "구독 시정조치 대상 ENUM")
    private SubscribeCaTargetEnum subscribeCaTargetEnum;
    @Schema(description = "ISSUE 아이디")
    private String issueId;
    @Schema(description = "ISSUE 대상 ENUM")
    private IssueTargetEnum issueTargetEnum;
    @Schema(description = "ISSUE 출처 아이디")
    private String issueSourceId;

    public CaCollectionResponse(SubscribeCaItemEntity entity) {
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
        this.deleteBool = entity.isDeleteBool();
        this.deleteUserId = entity.getDeleteUserId();
        this.deleteDtm = entity.getDeleteDtm();
        this.deleteIp = entity.getDeleteIp();
        this.insertUserId = entity.getInsertUserId();
        this.insertDtm = entity.getInsertDtm();
        this.insertIp = entity.getInsertIp();
        this.updateUserId = entity.getUpdateUserId();
        this.updateDtm = entity.getUpdateDtm();
        this.updateIp = entity.getUpdateIp();
    }

    public CaCollectionResponse(SubscribeCaItemWithSourceDto dto) {
        this.subscribeCaItemSeq = dto.getSubscribeCaItemSeq();
        this.subscribeCaUuid = dto.getSubscribeCaUuid();
        this.caId = dto.getCaId();
        this.caAppvalprcEnum = dto.getCaAppvalprcEnum();
        this.inchargeUserId = dto.getInchargeUserId();
        this.inchargeUserName = dto.getInchargeUserName();
        this.inchargeDepartmentId = dto.getInchargeDepartmentId();
        this.inchargeDepartmentName = dto.getInchargeDepartmentName();
        this.caSubject = dto.getCaSubject();
        this.caContent = dto.getCaContent();
        this.caDeadlineDt = dto.getCaDeadlineDt();
        this.capContent = dto.getCapContent();
        this.capRootCauseContent = dto.getCapRootCauseContent();
        this.capMultipleFileUuid = dto.getCapMultipleFileUuid();
        this.capExpectCompleteDt = dto.getCapExpectCompleteDt();
        this.caiContent = dto.getCaiContent();
        this.caiCompleteDt = dto.getCaiCompleteDt();
        this.caiMultipleFileUuid = dto.getCaiMultipleFileUuid();
        this.feedbackContent = dto.getFeedbackContent();
        this.deleteBool = dto.isDeleteBool();
        this.deleteUserId = dto.getDeleteUserId();
        this.deleteDtm = dto.getDeleteDtm();
        this.deleteIp = dto.getDeleteIp();
        this.insertUserId = dto.getInsertUserId();
        this.insertDtm = dto.getInsertDtm();
        this.insertIp = dto.getInsertIp();
        this.updateUserId = dto.getUpdateUserId();
        this.updateDtm = dto.getUpdateDtm();
        this.updateIp = dto.getUpdateIp();
        this.subscribeCaTargetEnum = dto.getSubscribeCaTargetEnum();
        this.issueId = dto.getIssueId();
        this.issueSourceId = dto.getIssueSourceId();
    }
}
