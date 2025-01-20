package com.airpremia.eosh.mainpage.controller.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MainPageEducationSearchRequest {
    private LocalDate educationDtStart;
    private LocalDate educationDtEnd;
    private String userId;
}
