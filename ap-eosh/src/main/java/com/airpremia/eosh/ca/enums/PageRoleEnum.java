package com.airpremia.eosh.ca.enums;

public enum PageRoleEnum {
    ADMIN, USER;

    public boolean isAdminPage() {
        return this == ADMIN;
    }

    public boolean isUserPage() {
        return this == USER;
    }
}
