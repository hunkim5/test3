package com.airpremia.eosh.education.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.dto.InstructorEvaluationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InstructorEvaluationRequest {

    @Schema(description = "강사 평가 시퀀스")
    private Long instructorEvaluationSeq;
    @Schema(description = "교육 참석 사용자 시퀀스")
    private Long educationAttendUserSeq;
    @Schema(description = "교육 강사 시퀀스")
    private Long educationInstructorSeq;
    @Schema(description = "교육 시퀀스")
    private Long educationSeq;
    @Schema(description = "1 depth 항목 코드")
    private String oneDepthItemCode;
    @Schema(description = "2 depth 문항 코드")
    private String twoDepthQuestionCode;
    @Schema(description = "점수")
    private int score;
    @Schema(description = "비고")
    private String remark;
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

    public InstructorEvaluationDto convertInstructorEvaluationDto() {
        InstructorEvaluationDto data = new InstructorEvaluationDto();
        data.setInstructorEvaluationSeq(this.instructorEvaluationSeq);
        data.setEducationAttendUserSeq(this.educationAttendUserSeq);
        data.setEducationSeq(this.educationSeq);
        data.setEducationInstructorSeq(this.educationInstructorSeq);
        data.setOneDepthItemCode(this.oneDepthItemCode);
        data.setTwoDepthQuestionCode(this.twoDepthQuestionCode);
        data.setScore(this.score);
        data.setRemark(this.remark);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}

