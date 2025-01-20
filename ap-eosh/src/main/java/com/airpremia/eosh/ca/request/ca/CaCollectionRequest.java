package com.airpremia.eosh.ca.request.ca;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.ca.dto.CaCollectionSearchDto;
import com.airpremia.eosh.ca.enums.CaAppvalprcEnum;
import com.airpremia.eosh.ca.enums.PageRoleEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaCollectionRequest {
    @Schema(description = "담당자 아이디")
    private String inchargeUserId;
    @Schema(description = "담당자 부서 아이디")
    private String inchargeDepartmentId;
    @Schema(description = "시정조치 제목")
    private String caSubject;
    @Schema(description = "발행일 검색 시작 일시")
    private LocalDateTime startInsertDtm;
    @Schema(description = "발행일 검색 종료 일시")
    private LocalDateTime endInsertDtm;
    @Schema(description = "시정조치 완료예정일 검색 시작일")
    private LocalDate startCapExpectCompleteDt;
    @Schema(description = "시정조치 완료예정일 검색 종료일")
    private LocalDate endCapExpectCompleteDt;
    @Schema(description = "시정조치 완료일 검색 시작일")
    private LocalDate startCaiCompleteDt;
    @Schema(description = "시정조치 완료일 검색 종료일")
    private LocalDate endCaiCompleteDt;
    @Schema(description = "시정조치 승인상태 ENUM")
    private CaAppvalprcEnum caAppvalprcEnum;
    @Schema(description = "page 유형 구분 ENUM")
    private PageRoleEnum pageRoleEnum;

    public CaCollectionSearchDto toSearchDto() {
        CaCollectionSearchDto searchDto = new CaCollectionSearchDto();
        searchDto.setInchargeUserId(this.inchargeUserId);
        searchDto.setInchargeDepartmentId(this.inchargeDepartmentId);
        searchDto.setCaSubject(this.caSubject != null ? String.format("%%%s%%", this.caSubject) : null);
        searchDto.setStartInsertDtm(this.startInsertDtm);
        searchDto.setEndInsertDtm(this.endInsertDtm);
        searchDto.setStartCapExpectCompleteDt(this.startCapExpectCompleteDt);
        searchDto.setEndCapExpectCompleteDt(this.endCapExpectCompleteDt);
        searchDto.setStartCaiCompleteDt(this.startCaiCompleteDt);
        searchDto.setEndCaiCompleteDt(this.endCaiCompleteDt);
        searchDto.setCaAppvalprcEnum(this.caAppvalprcEnum);

        return searchDto;
    }
}
