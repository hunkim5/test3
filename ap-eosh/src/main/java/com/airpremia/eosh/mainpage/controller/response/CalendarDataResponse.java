package com.airpremia.eosh.mainpage.controller.response;

import com.airpremia.eosh.mainpage.dto.MainPageEducationDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CalendarDataResponse {
    private String code;
    private String detailCode;
    private String userId;
    private String title;
    private String content;
    private String date;
    private String targetUserId;
    private Long seq;

    public CalendarDataResponse(MainPageEducationDto dto) {
        this.title = dto.getEducationClassificationCode();
        this.content = dto.getEducationContent();
        this.date = dto.getEducationDt().toString();
        this.seq = dto.getEducationSeq();
    }
}
