package com.airpremia.eosh.jobplan.request;

import java.time.LocalDate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.airpremia.eosh.jobplan.enums.JobClassificationCodeEnum;
import com.airpremia.eosh.jobplan.enums.JobPlanPerformEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobPlanSearchRequest {
    @Schema(description = "Sort 처리")
    Sort sort = Sort.unsorted();
    @Schema(description = "페이징처리 n번째 0부터시작", example = "0")
    Integer page = 0;
    @Schema(description = "페이징의 사이즈(row 의 개수)", example = "20")
    Integer size = 20;
    @Schema(description = "작업 분류 코드")
    private JobClassificationCodeEnum jobClassificationEnum;
    @Schema(description = "작업 제목")
    private String jobSubject;
    @Schema(description = "작업 시작 날짜")
    private LocalDate jobStartDt;
    @Schema(description = "작업 종료 날짜")
    private LocalDate jobEndDt;
    @Schema(description = "작업 내용")
    private String jobContent;
    @Schema(description = "'작업계획서' 수행 ENUM")
    private JobPlanPerformEnum jobPlanPerformEnum;
    @Schema(description = "작성자 아이디")
    private String inchargeUserId;
    @Schema(description = "작성자 이름")
    private String inchargeUserName;
    @Schema(description = "작성자 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "작성자 부서 이름")
    private String inchargeDepartmentName;
    @Schema(description = "사원명")
    private String employeeName;
    @Schema(description = "부서명")
    private String departmentName;

    public Pageable getPageable() {
        return PageRequest.of(page != null ? page : 0, size != null ? size : 20, sort != null ? sort : Sort.unsorted());
    }
}

