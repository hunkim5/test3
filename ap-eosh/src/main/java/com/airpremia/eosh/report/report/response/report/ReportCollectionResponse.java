package com.airpremia.eosh.report.report.response.report;


import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.issue.dto.issue.MainToReportMappingDto;
import com.airpremia.eosh.issue.enums.IssueProcessingEnum;
import com.airpremia.esmsfos.core.enums.OwnerSystemClassificationEnum;
import com.airpremia.esmsfos.core.enums.PastOwnerSystemClassificationEnum;
import com.airpremia.esmsfos.core.enums.ReportAppvalprcEnum;
import com.airpremia.esmsfos.core.enums.ReportClassificationEnum;
import com.airpremia.esmsfos.core.enums.ReportMandatoryEnum;
import com.airpremia.esmsfos.core.enums.ReportStatusEnum;
import com.airpremia.esmsfos.core.enums.StandardSystemClassificationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportCollectionResponse {
    @Schema(description = "보고서 UUID")
    private String reportUuid;
    @Schema(description = "보고서 아이디")
    private String reportId;
    @Schema(description = "보고서 상태 ENUM")
    private ReportStatusEnum reportStatusEnum;
    @Schema(description = "복사 보고서 UUID")
    private String copyReportUuid;
    @Schema(description = "기준 시스템 분류 ENUM")
    private StandardSystemClassificationEnum standardSystemClassificationEnum;
    @Schema(description = "소유자 시스템 분류 ENUM")
    private OwnerSystemClassificationEnum ownerSystemClassificationEnum;
    @Schema(description = "과거 소유자 시스템 분류 ENUM")
    private PastOwnerSystemClassificationEnum pastOwnerSystemClassificationEnum;
    @Schema(description = "구독 운항 정보 UUID")
    private String subscribeFlightInformationUuid;
    @Schema(description = "구독 다중 파일 UUID")
    private String subscribeMultipleFileUuid;
    @Schema(description = "보고서 승인절차 ENUM")
    private ReportAppvalprcEnum reportAppvalprcEnum;
    @Schema(description = "보고서 승인절차 거부 내용")
    private String reportAppvalprcRejectContent;
    @Schema(description = "보고서 승인절차 FEEDBACK 내용")
    private String reportAppvalprcFeedbackContent;
    @Schema(description = "보고서 분류 ENUM")
    private ReportClassificationEnum reportClassificationEnum;
    @Schema(description = "보고서 의무 ENUM")
    private ReportMandatoryEnum reportMandatoryEnum;
    @Schema(description = "ESMS 보고서 출처 코드")
    private String esmsReportSourceCode;
    @Schema(description = "SEMS 보고서 출처 코드")
    private String semsReportSourceCode;
    @Schema(description = "EOSH 보고서 분야 코드")
    private String eoshReportFieldCode;
    @Schema(description = "ESMS 보고서 분야 코드")
    private String esmsReportFieldCode;
    @Schema(description = "SEMS 보고서 분야 코드")
    private String semsReportFieldCode;
    @Schema(description = "ISSUE 여부")
    private boolean issueBool = false;
    @Schema(description = "조사 여부")
    private boolean investigationBool = false;
    @Schema(description = "보고서 제목")
    private String reportSubject;
    @Schema(description = "보고서 내용")
    private String reportContent;
    @Schema(description = "보고서 사용자 아이디")
    private String reportUserId;
    @Schema(description = "보고서 부서 아이디")
    private String reportDepartmentId;
    @Schema(description = "보고서 사건 일시")
    private LocalDateTime reportEventDtm;
    @Schema(description = "보고서 사건 일시 ZONEID 코드")
    private String reportEventDtmZoneidCode;
    @Schema(description = "보고서 장소 comment")
    private String reportLocationComment;
    @Schema(description = "'지상고도' 수량")
    private Long aglQuantity;
    @Schema(description = "'지상고도' 단위 코드")
    private String aglUnitCode;
    @Schema(description = "야생생물 크기 코드")
    private String wildlifeSizeCode;
    @Schema(description = "야생생물 분류 comment")
    private String wildlifeClassificationComment;
    @Schema(description = "보여진 야생생물 수량 범위 코드")
    private String seenWildlifeQuantityScopeCode;
    @Schema(description = "충돌된 야생생물 수량 범위 코드")
    private String struckWildlifeQuantityScopeCode;
    @Schema(description = "수평 대상 관찰 방위 코드 ")
    private String horizontalTargetObserveAzimuthCode;
    @Schema(description = "수평 대상 방향 방위 코드")
    private String horizontalTargetDirectionAzimuthCode;
    @Schema(description = "수직 대상 관찰 방위 코드")
    private String verticalTargetObserveAzimuthCode;
    @Schema(description = "보고서 자문가 분류 코드")
    private String reportAdviserClassificationCode;
    @Schema(description = "회피 조치 여부")
    private boolean avoidingActionBool = false;
    @Schema(description = "'RA' 규정준수 여부")
    private boolean raComplianceBool = false;
    @Schema(description = "'항공교통관제' 알림 여부")
    private boolean atcAlarmBool = false;
    @Schema(description = "위험물 UN 번호")
    private Long dgUnNo;
    @Schema(description = "위험물 운송 이름")
    private String dgShippingName;
    @Schema(description = "위험물 분류 코드")
    private String dgClassificationCode;
    @Schema(description = "위험물 운송 분류 코드")
    private String dgShippingClassificationCode;
    @Schema(description = "위험물 포장 분류 코드")
    private String dgPackingClassificationCode;
    @Schema(description = "위험물 운송 분류 아이디")
    private String dgShippingClassificationId;
    @Schema(description = "위험물 위탁자 이름")
    private String dgConsignorName;
    @Schema(description = "부수적인 위험물 분류 코드")
    private String subsidiaryDgClassificationCode;
    @Schema(description = "위험물 수량")
    private Long dgQuantity;
    @Schema(description = "위험물 포장 그룹 코드")
    private String dgPackingGroupCode;
    @Schema(description = "위험물 운송 단계 코드")
    private String dgShippingPhaseCode;
    @Schema(description = "위험물 수취인 이름")
    private String dgConsigneeName;
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
    @Schema(description = "보고자")
    private String reportUserNm;
    @Schema(description = "보고 부서")
    private String reportDepartmentNm;
    @Schema(description = "ISSUE 처리 상태 ENUM")
    private IssueProcessingEnum issueProcessingEnum;
    @Schema(description = "ISSUE 기관 보고 여부")
    private Boolean issueOrganizationAlarmBool;
    @Schema(description = "연관 보고서 UUID 목록")
    private List<String> relatedReportUuidList;
    @Schema(description = "재해사고 여부")
    private boolean disasterAccidentBool;
    @Schema(description = "아차사고 여부")
    private boolean nearMissBool;
    @Schema(description = "산재 여부")
    private boolean industrialAccidentBool;
    @Schema(description = "발생가능성 수준")
    private Integer likelihoodLevel;
    @Schema(description = "심각도 수준")
    private Integer severityLevel;
    @Schema(description = "출퇴근 재해 여부")
    private boolean commuteAccidentBool;
    @Schema(description = "부상 또는 질병 발생 여부")
    private boolean injuredBool;
    @Schema(description = "관리 감독자 아이디")
    private String manageSupervisionEmployeeId;
    @Schema(description = "부상자 또는 질병자 정보")
    private String injuredRelatedInfo;
    @Schema(description = "보고서 비고 내용")
    private String reportRemarkContent;
    @Schema(description = "익명 여부")
    private boolean anonymousBool;

    public void applyNewIssueInformation(MainToReportMappingDto issue) {
        this.issueProcessingEnum = issue.getIssueProcessingEnum();
        this.relatedReportUuidList = issue.getRelateReportUuidList();
        this.issueOrganizationAlarmBool = issue.isOrganizationAlarmBool();
    }
}
