package com.airpremia.eosh.personaldetail.health.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExaminationSearchDto {
    private LocalDate birthYmd;
}
