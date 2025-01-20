package com.airpremia.eosh.authoritymanagement.authoritymanagement.controller;

import org.springframework.data.domain.Sort;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AuthorityManagementRequest {
    @Schema(description = "변화 관리 시퀀스")
    private Long companySeq;
    @Schema(description = "변화 관리 시퀀스")
    private String insertUserId;
    @Schema(description = "변화 관리 시퀀스")
    private String insertIp;
    @Schema(description = "변화 관리 시퀀스")
    private String updateUserId;
    @Schema(description = "변화 관리 시퀀스")
    private String updateIp;
    @Schema(description = "Sort 처리")
    Sort sort = Sort.unsorted();
    @Schema(description = "페이징처리 n번째 0부터시작", example = "0")
    Integer page = 0;
    @Schema(description = "페이징의 사이즈(row 의 개수)", example = "20")
    Integer size = 20;
}
