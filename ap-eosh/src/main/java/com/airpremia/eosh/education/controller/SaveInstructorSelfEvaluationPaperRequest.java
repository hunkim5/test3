package com.airpremia.eosh.education.controller;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SaveInstructorSelfEvaluationPaperRequest {

    private EducationInstructorRequest educationInstructorSelectData;
    private List<InstructorSelfEvaluationPaperRequest> instructorSelfEvaluationPaperList;

}
