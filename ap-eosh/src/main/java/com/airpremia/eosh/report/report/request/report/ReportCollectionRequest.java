package com.airpremia.eosh.report.report.request.report;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.airpremia.eosh.issue.enums.IssueProcessingEnum;
import com.airpremia.esmsfos.core.enums.OwnerSystemClassificationEnum;
import com.airpremia.esmsfos.core.enums.PastOwnerSystemClassificationEnum;
import com.airpremia.esmsfos.core.enums.ReportAppvalprcEnum;
import com.airpremia.esmsfos.core.enums.ReportClassificationEnum;
import com.airpremia.esmsfos.core.enums.ReportQueryTypeEnum;
import com.airpremia.esmsfos.core.enums.ReportSourceEnum;
import com.airpremia.esmsfos.core.enums.SearchDateTypeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportCollectionRequest {
    @Schema(description = "리포트 uuid")
    private List<String> reportUuidList;
    @Schema(description = "보고서 분류 ENUM")
    private List<ReportClassificationEnum> reportClassificationEnumList;
    @Schema(description = "보고서 사용자 아이디")
    private String reportUserId;
    @Schema(description = "보고서 부서 아이디")
    private String reportDepartmentId;
    @Schema(description = "보고서 분야 코드")
    private String reportFieldCode;
    @Schema(description = "보고서 승인절차 ENUM")
    private ReportAppvalprcEnum reportAppvalprcEnum;
    @Schema(description = "검색 날짜 타입 ENUM")
    private SearchDateTypeEnum searchDateTypeEnum;
    @Schema(description = "시스템 분류 ENUM")
    private OwnerSystemClassificationEnum ownerSystemClassificationEnum;
    @Schema(description = "이전 시스템 분류 ENUM")
    private PastOwnerSystemClassificationEnum pastOwnerSystemClassificationEnum;
    @Schema(description = "Report 제목")
    private String reportSubject;
    @Schema(description = "조사 여부")
    private Boolean investigationBool;
    @Schema(description = "기타보고서 출처 코드")
    private List<String> etcReportSourceCodeList;
    @Schema(description = "보고서 출처 ENUM")
    private ReportSourceEnum reportSourceEnum;
    @Schema(description = "Issue 처리 상태 ENUM")
    private IssueProcessingEnum issueProcessingEnum;
    @Schema(description = "이슈처리 되지 않은 보고서만 조회 여부")
    private Boolean onlyUnissuedBool;
    @Schema(description = "조회 제외 대상 보고서 UUID")
    private List<String> excludeUuidList;
    @Schema(description = "보고서 조회 유형 ENUM")
    private ReportQueryTypeEnum reportQueryTypeEnum;
    @Schema(description = "조회가능 부서 목록")
    private List<String> accessibleDepartmentCdList;

    @Schema(description = "검색 시작 일시")
    private LocalDateTime startDtm;
    @Schema(description = "검색 종료 일시")
    private LocalDateTime endDtm;

    @Schema(description = "Sort 처리")
    private Sort sort = Sort.unsorted();
    @Schema(description = "페이징처리 n번째 0부터시작", example = "0")
    private Integer page = 0;
    @Schema(description = "페이징의 사이즈(row 의 개수)", example = "20")
    private Integer size = 20;

    public Pageable getPageable() {
        return PageRequest.of(page != null ? page : 0, size != null ? size : 20, sort != null ? sort : Sort.unsorted());
    }
}
