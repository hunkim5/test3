package com.airpremia.eosh.education.controller;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.dto.CourseSurveyDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CourseSurveyRequest {

    @Schema(description = "과정 설문 시퀀스")
    private Long courseSurveySeq;
    @Schema(description = "교육 참석 사용자 시퀀스")
    private Long educationAttendUserSeq;
    @Schema(description = "교육 시퀀스")
    private Long educationSeq;
    @Schema(description = "과정 설문 문항 코드")
    private String courseSurveyQuestionCode;
    @Schema(description = "과정 설문 문항 상세 코드")
    private String courseSurveyQuestionDetailCode;
    @Schema(description = "문항 답변")
    private String questionAnswer;
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

    public CourseSurveyDto convertCourseSurveyDto() {
        CourseSurveyDto data = new CourseSurveyDto();
        data.setCourseSurveySeq(this.courseSurveySeq);
        data.setEducationAttendUserSeq(this.educationAttendUserSeq);
        data.setEducationSeq(this.educationSeq);
        data.setCourseSurveyQuestionCode(this.courseSurveyQuestionCode);
        data.setCourseSurveyQuestionDetailCode(this.courseSurveyQuestionDetailCode);
        data.setQuestionAnswer(this.questionAnswer);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}

