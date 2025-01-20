package com.airpremia.eosh.personaldetail.health.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class HealthDeleteResponse {
    private int health;
    private int userSpecialExamination;
    private int userCosmicRadiation;
    private int userCerebrocardiovascular;
}
