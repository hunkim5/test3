package com.airpremia.eosh.issue.request;

import java.time.LocalDateTime;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class IssueCollectionSearchRequest {
    @Schema(description = "Sort 처리")
    Sort sort = Sort.unsorted();
    @Schema(description = "페이징처리 n번째 0부터시작", example = "0")
    Integer page = 0;
    @Schema(description = "페이징의 사이즈(row 의 개수)", example = "20")
    Integer size = 20;

    @Schema(description = "Issue 출처 분류")
    private String sourceClassification;
    @Schema(description = "Issue 출처 ID")
    private String sourceId;
    @Schema(description = "검색 시작 보고일시 ")
    private LocalDateTime searchFromReportInsertDtm;
    @Schema(description = "검색 끝 보고일시 ")
    private LocalDateTime searchToReportInsertDtm;
    @Schema(description = "Issue 주제")
    private String issueSubject;


    public Pageable getPageable() {
        return PageRequest.of(page != null ? page : 0, size != null ? size : 20, sort != null ? sort : Sort.unsorted());
    }

}
