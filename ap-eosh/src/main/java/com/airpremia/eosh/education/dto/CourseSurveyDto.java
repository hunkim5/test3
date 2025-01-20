package com.airpremia.eosh.education.dto;

import java.time.LocalDateTime;

import com.airpremia.eosh.education.controller.CourseSurveyRequest;
import com.airpremia.eosh.education.controller.CourseSurveyResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CourseSurveyDto {

    private Long courseSurveySeq;
    private Long educationAttendUserSeq;
    private Long educationSeq;
    private String courseSurveyQuestionCode;
    private String courseSurveyQuestionDetailCode;
    private String questionAnswer;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public CourseSurveyDto(CourseSurveyRequest req) {
        this.courseSurveySeq = req.getCourseSurveySeq();
        this.educationAttendUserSeq = req.getEducationAttendUserSeq();
        this.educationSeq = req.getEducationSeq();
        this.courseSurveyQuestionCode = req.getCourseSurveyQuestionCode();
        this.courseSurveyQuestionDetailCode = req.getCourseSurveyQuestionDetailCode();
        this.questionAnswer = req.getQuestionAnswer();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

    public CourseSurveyResponse convertCourseSurveyResponse() {
        CourseSurveyResponse data = new CourseSurveyResponse();
        data.setCourseSurveySeq(this.courseSurveySeq);
        data.setEducationAttendUserSeq(this.educationAttendUserSeq);
        data.setEducationSeq(this.educationSeq);
        data.setCourseSurveyQuestionCode(this.courseSurveyQuestionCode);
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

