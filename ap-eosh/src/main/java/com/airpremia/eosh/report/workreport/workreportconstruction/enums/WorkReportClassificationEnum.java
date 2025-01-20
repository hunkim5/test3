package com.airpremia.eosh.report.workreport.workreportconstruction.enums;

public enum WorkReportClassificationEnum {
    CONSTRUCT("A-A"), FACILITY("A-B"), SAFEGUARD("A-C"), DISASSEMBLY("A-D"),  CONTRACT("A-E");

    private final String value;

    WorkReportClassificationEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
