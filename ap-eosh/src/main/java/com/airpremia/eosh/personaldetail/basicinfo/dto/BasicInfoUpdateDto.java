package com.airpremia.eosh.personaldetail.basicinfo.dto;

import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoUpdateRequest;
import com.airpremia.eosh.personaldetail.basicinfo.controller.BasicInfoUpdateResponse;
import com.airpremia.eosh.personaldetail.basicinfo.enums.UserJobClassificationClassificationEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BasicInfoUpdateDto {

    private Long userSeq;
    private String userId;

    private UserJobClassificationClassificationEnum userJobClassificationClassificationEnum;

    public BasicInfoUpdateDto(BasicInfoUpdateRequest req) {
        this.userSeq = req.getUserSeq();
        this.userId = req.getUserId();
        this.userJobClassificationClassificationEnum = req.getUserJobClassificationClassificationEnum();
    }

    public BasicInfoUpdateResponse convertBasiCinfoResponse() {
        BasicInfoUpdateResponse res = new BasicInfoUpdateResponse();
        res.setUserId(this.userId);
        res.setUserJobClassificationClassificationEnum(this.userJobClassificationClassificationEnum);
        return res;
    }
}

