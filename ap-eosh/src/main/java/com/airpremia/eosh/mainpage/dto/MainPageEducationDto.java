package com.airpremia.eosh.mainpage.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MainPageEducationDto {
    private long educationSeq;
    private LocalDate educationDt;
    private String educationContent;
    private String educationClassificationCode;
}
