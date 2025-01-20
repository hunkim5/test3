package com.airpremia.eosh.education.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.dto.InstructorSelfEvaluationPaperDto;
import com.airpremia.eosh.education.enums.EvaluationEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InstructorSelfEvaluationPaperResponse {

    @Schema(description = "교육 강사 자기 평가 시퀀스")
    private Long instructorSelfEvaluationSeq;
    @Schema(description = "교육 시퀀스")
    private Long educationSeq;
    @Schema(description = "교육 강사 시퀀스")
    private Long educationInstructorSeq;
    @Schema(description = "구분 코드")
    private String divisionCode;
    @Schema(description = "체크리스트 코드")
    private String checklistCode;
    @Schema(description = "평가 ENUM")
    private EvaluationEnum evaluationEnum;
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

    public InstructorSelfEvaluationPaperResponse(InstructorSelfEvaluationPaperDto dto) {
        this.instructorSelfEvaluationSeq = dto.getInstructorSelfEvaluationSeq();
        this.educationSeq = dto.getEducationSeq();
        this.educationInstructorSeq = dto.getEducationInstructorSeq();
        this.divisionCode = dto.getDivisionCode();
        this.checklistCode = dto.getChecklistCode();
        this.evaluationEnum = dto.getEvaluationEnum();
    }

}

