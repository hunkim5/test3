package com.airpremia.eosh.mainpage.dto;

import java.time.LocalDate;

import com.airpremia.eosh.mainpage.controller.request.MainPageEducationSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MainPageEducationSearchDto {
    private LocalDate educationDtStart;
    private LocalDate educationDtEnd;
    private String userId;

    public MainPageEducationSearchDto(MainPageEducationSearchRequest request) {
        this.educationDtStart = request.getEducationDtStart();
        this.educationDtEnd = request.getEducationDtEnd();
        this.userId = request.getUserId();
    }
}
