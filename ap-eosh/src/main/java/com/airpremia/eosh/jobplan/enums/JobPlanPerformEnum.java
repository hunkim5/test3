package com.airpremia.eosh.jobplan.enums;

import lombok.Getter;

@Getter
public enum JobPlanPerformEnum {
    PLAN_SUBMIT, PLAN_REQUEST, PLAN_APPROVAL, PREPARE_SUBMIT, PREPARE_REQUEST, PREPARE_APPROVAL, WORK_BEFORE_DRAFT,
    WORK_BEFORE_SUBMIT, FINAL_DRAFT, FINAL_END;

    public boolean isPlanSubmit() {
        return this == PLAN_SUBMIT;
    }

    public boolean isPlanRequest() {
        return this == PLAN_REQUEST;
    }

    public boolean isPlanApproval() {
        return this == PLAN_APPROVAL;
    }

    public boolean isPrepareSubmit() {
        return this == PREPARE_SUBMIT;
    }

    public boolean isPrepareRequest() {
        return this == PREPARE_REQUEST;
    }

    public boolean isPrepareApproval() {
        return this == PREPARE_APPROVAL;
    }

    public boolean isWorkBeforeDraft() {
        return this == WORK_BEFORE_DRAFT;
    }

    public boolean isWorkBeforeSubmit() {
        return this == WORK_BEFORE_SUBMIT;
    }

    public boolean isFinalDraft() {
        return this == FINAL_DRAFT;
    }

    public boolean isFinalEnd() {
        return this == FINAL_END;
    }
}
