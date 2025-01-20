package com.airpremia.eosh.checklist.request;

import java.time.LocalDate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChecklistSearchRequest {
    @Schema(description = "Sort 처리")
    Sort sort = Sort.unsorted();
    @Schema(description = "페이징처리 n번째 0부터시작", example = "0")
    Integer page = 0;
    @Schema(description = "페이징의 사이즈(row 의 개수)", example = "20")
    Integer size = 20;
    @Schema(description = "점검표 구분 코드")
    private String checklistDivisionCode;
    @Schema(description = "서식명")
    private String checklistSubject;
    @Schema(description = "점검자 아이디")
    private String inspectorId;
    @Schema(description = "점검자 이름")
    private String inspectorName;
    @Schema(description = "점검자 부서 아이디")
    private String inspectorDepartmentId;
    @Schema(description = "점검자 부서 이름")
    private String inspectorDepartmentName;
    @Schema(description = "점검 시작 날짜")
    private LocalDate checkStartDt;
    @Schema(description = "점검 종료 날짜")
    private LocalDate checkEndDt;

    public Pageable getPageable() {
        return PageRequest.of(page != null ? page : 0, size != null ? size : 20, sort != null ? sort : Sort.unsorted());
    }
}
