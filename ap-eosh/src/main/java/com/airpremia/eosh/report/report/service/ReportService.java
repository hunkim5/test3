package com.airpremia.eosh.report.report.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;

import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.external.report.component.ExternalReportClient;
import com.airpremia.eosh.issue.component.IssueComponent;
import com.airpremia.eosh.issue.dto.issue.IssueCreateInitialPropertyDto;
import com.airpremia.eosh.issue.dto.issue.MainToReportMappingDto;
import com.airpremia.eosh.report.report.request.issue.ReportIssueRequest;
import com.airpremia.eosh.report.report.request.report.ReportCollectionRequest;
import com.airpremia.eosh.report.report.request.report.ReportRequest;
import com.airpremia.eosh.report.report.request.transfer.ReportSystemTransferRequest;
import com.airpremia.eosh.report.report.response.report.ReportCollectionResponse;
import com.airpremia.eosh.report.report.response.report.ReportResponse;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final RestClient reportClient;
    private final ExternalReportClient reportComponent;
    private final IssueComponent issueComponent;
    private final UserTokenService userTokenService;
    private final String adminApiPath = "/admin";

    private URI getReportSearchParamUri(
        ReportCollectionRequest request, UriBuilder uriBuilder, String path) {
        if (path != null) {
            uriBuilder.path(path);
        }
        Optional.ofNullable(request.getReportClassificationEnumList())
            .ifPresent(list -> uriBuilder.queryParam("reportClassificationEnumList", list.toArray()));
        Optional.ofNullable(request.getReportUserId())
            .ifPresent(userId -> uriBuilder.queryParam("reportUserId", userId));
        Optional.ofNullable(request.getReportDepartmentId())
            .ifPresent(departmentId -> uriBuilder.queryParam("reportDepartmentId", departmentId));
        Optional.ofNullable(request.getReportFieldCode())
            .ifPresent(fieldCode -> uriBuilder.queryParam("reportFieldCode", fieldCode));
        Optional.ofNullable(request.getReportAppvalprcEnum())
            .ifPresent(appvalprcEnum -> uriBuilder.queryParam("reportAppvalprcEnum", appvalprcEnum));
        Optional.ofNullable(request.getSearchDateTypeEnum())
            .ifPresent(dateTypeEnum -> uriBuilder.queryParam("searchDateTypeEnum", dateTypeEnum));
        Optional.ofNullable(request.getOwnerSystemClassificationEnum())
            .ifPresent(
                classificationEnum -> uriBuilder.queryParam("ownerSystemClassificationEnum", classificationEnum));
        Optional.ofNullable(request.getPastOwnerSystemClassificationEnum())
            .ifPresent(
                pastOwnerSystemClassificationEnum -> uriBuilder.queryParam("pastOwnerSystemClassificationEnum",
                    pastOwnerSystemClassificationEnum));
        Optional.ofNullable(request.getReportSubject())
            .ifPresent(subject -> uriBuilder.queryParam("reportSubject", subject));
        Optional.ofNullable(request.getInvestigationBool())
            .ifPresent(investigation -> uriBuilder.queryParam("investigationBool", investigation));
        Optional.ofNullable(request.getEtcReportSourceCodeList())
            .ifPresent(list -> uriBuilder.queryParam("etcReportSourceCodeList", list.toArray()));
        Optional.ofNullable(request.getStartDtm())
            .ifPresent(startDtm -> uriBuilder.queryParam("startDtm", startDtm));
        Optional.ofNullable(request.getEndDtm())
            .ifPresent(endDtm -> uriBuilder.queryParam("endDtm", endDtm));
        Optional.ofNullable(request.getPage())
            .ifPresent(page -> uriBuilder.queryParam("page", page));
        Optional.ofNullable(request.getSize())
            .ifPresent(size -> uriBuilder.queryParam("size", size));
        Optional.ofNullable(request.getReportSourceEnum())
            .ifPresent(reportSourceEnum -> uriBuilder.queryParam("reportSourceEnum", reportSourceEnum));
        Optional.ofNullable(request.getOnlyUnissuedBool())
            .ifPresent(onlyUnissuedBool -> uriBuilder.queryParam("onlyUnissuedBool", onlyUnissuedBool));
        Optional.ofNullable(request.getExcludeUuidList())
            .ifPresent(excludeUuidList -> uriBuilder.queryParam("excludeUuidList", excludeUuidList.toArray()));
        Optional.ofNullable(request.getReportQueryTypeEnum())
            .ifPresent(reportQueryTypeEnum -> uriBuilder.queryParam("reportQueryTypeEnum", reportQueryTypeEnum));
        Optional.ofNullable(request.getAccessibleDepartmentCdList())
            .ifPresent(accessibleDepartmentCdList -> uriBuilder.queryParam("accessibleDepartmentCdList",
                accessibleDepartmentCdList.toArray()));

        return uriBuilder.build();
    }

    private void processMatchingIssue(
        ReportCollectionResponse report, List<MainToReportMappingDto> issueInformationList) {

        for (MainToReportMappingDto issue : issueInformationList) {
            if (report.getReportUuid().equals(issue.getMainReportUuid())) {
                report.applyNewIssueInformation(issue);
                break;
            }
        }
    }

    private List<ReportCollectionResponse> fetchAndProcessingReportList(ReportCollectionRequest request, String path) {
        List<ReportCollectionResponse> reportList = reportClient.get()
            .uri(uriBuilder -> getReportSearchParamUri(request, uriBuilder, path))
            .header("Authorization", userTokenService.getBearerAccessToken())
            .retrieve()
            .body(new ParameterizedTypeReference<List<ReportCollectionResponse>>() {
            });


        List<MainToReportMappingDto> issueInformationList = issueComponent.getIssueInformationByReportUuids(
            reportList.stream().filter(ReportCollectionResponse::isIssueBool)
                .map(ReportCollectionResponse::getReportUuid).toList());

        for (ReportCollectionResponse report : reportList) {
            if (report.isIssueBool()) {
                processMatchingIssue(report, issueInformationList);
            }
        }

        if (request.getIssueProcessingEnum() != null) {
            reportList = reportList.stream()
                .filter(report -> report.getIssueProcessingEnum() != null
                                  && report.getIssueProcessingEnum().equals(request.getIssueProcessingEnum())).toList();
        }

        return reportList;
    }


    public Page<ReportCollectionResponse> paginateReportList(
        ReportCollectionRequest request, List<ReportCollectionResponse> reportList) {
        int fromIndex = request.getPage() * request.getSize();
        int toIndex = Math.min(fromIndex + request.getSize(), reportList.size());

        return new PageImpl<>(
            reportList.subList(fromIndex, toIndex),
            request.getPageable(),
            reportList.size()
        );
    }

    public Page<ReportCollectionResponse> selectReportPage(ReportCollectionRequest request) {
        List<ReportCollectionResponse> reportList = fetchAndProcessingReportList(request, null);
        return paginateReportList(request, reportList);
    }

    public List<ReportCollectionResponse> selectAdminReportList(ReportCollectionRequest request) {
        return fetchAndProcessingReportList(request, adminApiPath);
    }

    public Page<ReportCollectionResponse> selectAdminReportPage(ReportCollectionRequest request) {
        List<ReportCollectionResponse> reportList = fetchAndProcessingReportList(request, adminApiPath);
        return paginateReportList(request, reportList);
    }

    public List<ReportCollectionResponse> selectRelatedReport(List<String> reportUuidList) {
        return reportComponent.selectRelatedReportList(reportUuidList);
    }

    public ReportResponse selectReportDetail(String reportUuid) {
        return reportComponent.selectReportDetail(reportUuid);
    }

    public Integer deleteReportList(List<ReportRequest> reportList) {
        reportList.forEach(report -> {
            if (report.isIssueBool()) {
                issueComponent.issueDropByReportUuid(report.getReportUuid());
            }
        });

        return reportComponent.deleteReportList(reportList);
    }


    @Transactional
    public List<Long> insertIssueList(List<ReportIssueRequest> reportIssueRequestList) {
        List<Long> resultList = new ArrayList<>();
        List<ReportRequest> reportList = new ArrayList<>();

        if (reportIssueRequestList == null || reportIssueRequestList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }

        for (ReportIssueRequest reportIssueRequest : reportIssueRequestList) {
            IssueCreateInitialPropertyDto issueCreateDto = reportIssueRequest.toIssueCreateDto();

            Long issueSeq = issueComponent.createIssueByReport(issueCreateDto);

            ReportRequest reportRequest = new ReportRequest();
            reportRequest.setReportUuid(reportIssueRequest.getReportUuid());
            reportRequest.setIssueBool(reportIssueRequest.getIssueBool());

            if (issueSeq != null) {
                reportList.add(reportRequest);
                resultList.add(issueSeq);
            }
        }

        if (!reportList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }

        reportComponent.updateReportListIssueBool(reportList);

        return resultList;
    }

    public List<ReportCollectionResponse> updateReportSystemTransfer(List<ReportSystemTransferRequest> request) {
        return reportComponent.updateReportSystemTransfer(request);
    }

    public List<ReportCollectionResponse> sharedReportList(List<ReportSystemTransferRequest> request) {
        return reportComponent.sharedReportList(request);
    }

    public List<ReportCollectionResponse> updateReportIndustrialAccident(List<ReportRequest> request) {
        return reportComponent.updateReportIndustrialAccident(request);
    }
}
