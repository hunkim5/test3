package com.airpremia.eosh.education.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SaveInstructorEvaluationRequest {

    @Schema(description = "교육 대상자 정보")
    private EducationAttendUserRequest educationAttendUserSelectData;
    @Schema(description = "강사 평가서")
    private List<InstructorEvaluationRequest> instructorEvaluationList;

}
