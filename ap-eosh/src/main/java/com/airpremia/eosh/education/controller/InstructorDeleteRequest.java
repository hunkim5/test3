package com.airpremia.eosh.education.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InstructorDeleteRequest {

    @Schema(description = "강사 시퀀스")
    private Long instructorSeq;

}
