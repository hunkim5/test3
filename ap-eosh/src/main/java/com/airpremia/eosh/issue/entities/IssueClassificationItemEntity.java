package com.airpremia.eosh.issue.entities;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class IssueClassificationItemEntity {
    @Schema(description = "코드 분류")
    private String codeClassification;
    @Schema(description = "공통 코드")
    private String commonCode;
    @Schema(description = "ISSUE 시퀀스")
    private Long issueSeq;
    @Schema(description = "메인 여부")
    private boolean mainBool = false;
    @Schema(description = "비고 comment")
    private String remarkComment;
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
}
