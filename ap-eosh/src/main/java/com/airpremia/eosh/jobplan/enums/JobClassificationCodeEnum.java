package com.airpremia.eosh.jobplan.enums;

public enum JobClassificationCodeEnum {
    CONFINED_PLACE, FIREARMS_JOB, WORLD_VECHICLES;

    public boolean isConfinedPlace() {
        return this == CONFINED_PLACE;
    }

    public boolean isFirearmsJob() {
        return this == FIREARMS_JOB;
    }

    public boolean isWorldVechicles() {
        return this == WORLD_VECHICLES;
    }
}
