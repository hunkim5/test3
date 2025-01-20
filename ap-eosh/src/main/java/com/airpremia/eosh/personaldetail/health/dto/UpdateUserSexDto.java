package com.airpremia.eosh.personaldetail.health.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UpdateUserSexDto {
    @Schema(description = "사용자 시퀀스")
    private Long userSeq;
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "성별")
    private String sex;

    public UpdateUserSexDto(String userId, String sex) {
        this.userId = userId;
        this.sex = sex;
    }

    public UpdateUserSexDto(Long userSeq, String sex) {
        this.userSeq = userSeq;
        this.sex = sex;
    }
}

