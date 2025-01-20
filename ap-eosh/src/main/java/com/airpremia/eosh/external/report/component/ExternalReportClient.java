package com.airpremia.eosh.external.report.component;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.airpremia.eosh.report.report.request.report.ReportRequest;
import com.airpremia.eosh.report.report.request.transfer.ReportSystemTransferRequest;
import com.airpremia.eosh.report.report.response.report.ReportCollectionResponse;
import com.airpremia.eosh.report.report.response.report.ReportResponse;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Component

@RequiredArgsConstructor
public class ExternalReportClient {
    private final RestClient reportClient;
    private final UserTokenService userTokenService;


    public List<ReportCollectionResponse> updateReportListIssueBool(List<ReportRequest> reportList) {
        return reportClient
            .patch()
            .uri(uriBuilder ->
                uriBuilder.path("/issue").build()
            )
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(reportList).retrieve().body(new ParameterizedTypeReference<List<ReportCollectionResponse>>() {
            });
    }

    public ReportResponse updateReportAppvalprc(String reportUuid, ReportRequest request) {
        return reportClient
            .patch()
            .uri(uriBuilder ->
                uriBuilder.path("/appvalprc/" + reportUuid).build()
            )
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(request)
            .retrieve().body(new ParameterizedTypeReference<ReportResponse>() {
            });
    }

    public List<ReportCollectionResponse> selectRelatedReportList(List<String> reportUuidList) {
        return reportClient
            .get()
            .uri(uriBuilder -> {
                uriBuilder
                    .path("/related")
                    .queryParam("reportUuidList", reportUuidList);
                return uriBuilder.build();
            })
            .header("Authorization", userTokenService.getBearerAccessToken())
            .retrieve()
            .body(new ParameterizedTypeReference<List<ReportCollectionResponse>>() {
            });
    }

    public ReportResponse selectReportDetail(String reportUuid) {
        return reportClient
            .get()
            .uri(uribuilder -> uribuilder.path("/" + reportUuid).build())
            .header("Authorization", userTokenService.getBearerAccessToken())
            .retrieve()
            .body(new ParameterizedTypeReference<ReportResponse>() {
            });
    }

    public ReportResponse updateInvestigationBool(String reportUuid, Boolean investigationBool) {
        ReportRequest request = new ReportRequest();
        request.setReportUuid(reportUuid);
        request.setInvestigationBool(investigationBool);

        return reportClient
            .patch()
            .uri(uriBuilder -> uriBuilder.path("/investigation/" + reportUuid).build())
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(request)
            .retrieve().body(
                new ParameterizedTypeReference<ReportResponse>() {
                });
    }

    public List<ReportCollectionResponse> updateReportSystemTransfer(List<ReportSystemTransferRequest> request) {
        return reportClient
            .put()
            .uri(uriBuilder ->
                uriBuilder.path("/transfer")
                    .build()
            )
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(request)
            .retrieve()
            .body(new ParameterizedTypeReference<List<ReportCollectionResponse>>() {
            });
    }

    public Integer deleteReportList(List<ReportRequest> reportList) {
        return reportClient.method(HttpMethod.DELETE)
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(reportList).retrieve().body(
                new ParameterizedTypeReference<Integer>() {
                });
    }

    public List<ReportCollectionResponse> sharedReportList(List<ReportSystemTransferRequest> request) {
        return reportClient
            .post()
            .uri(uriBuilder ->
                uriBuilder.path("/share").build()
            )
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(request)
            .retrieve()
            .body(new ParameterizedTypeReference<List<ReportCollectionResponse>>() {
            });
    }

    public ReportResponse updateReportFeedbackContent(String reportUuid, String feedbackContent) {
        ReportRequest request = new ReportRequest();
        request.setReportAppvalprcFeedbackContent(feedbackContent);

        return reportClient
            .patch()
            .uri(uriBuilder -> uriBuilder.path("/" + reportUuid + "/feedback").build())
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(request)
            .retrieve()
            .body(
                new ParameterizedTypeReference<ReportResponse>() {
                });
    }

    public List<ReportCollectionResponse> updateReportIndustrialAccident(List<ReportRequest> request) {
        return reportClient
            .patch()
            .uri(uriBuilder -> uriBuilder.path("/industrial-accident").build())
            .header("Authorization", userTokenService.getBearerAccessToken())
            .body(request)
            .retrieve()
            .body(new ParameterizedTypeReference<List<ReportCollectionResponse>>() {
            });
    }
}

