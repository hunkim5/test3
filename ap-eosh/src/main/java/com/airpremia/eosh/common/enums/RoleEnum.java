package com.airpremia.eosh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    SUPER_ADMIN("ROLE_EOSH_SUPER_ADMIN"),
    ADMIN("ROLE_EOSH_ADMIN"),
    MASTER("ROLE_EOSH_MASTER"),
    MANAGER("ROLE_EOSH_MANAGER"),
    USER("ROLE_EOSH_USER");

    private final String roleName;

    public static RoleEnum fromRoleName(String roleName) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getRoleName().equals(roleName)) {
                return roleEnum;
            }
        }
        throw new IllegalArgumentException("잘못된 ROLE 비교 입니다.");
    }

    public boolean isSuperAdmin() {
        return this == SUPER_ADMIN;
    }

    public boolean isAdmin() {
        return this == ADMIN;
    }

    public boolean isMaster() {
        return this == MASTER;
    }

    public boolean isManager() {
        return this == MANAGER;
    }

    public boolean isUser() {
        return this == USER;
    }
}
