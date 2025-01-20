package com.airpremia.eosh.common.dto;

public class AuthUserInfoDto {
    String[] roleList;
    String[] agncList;

    public String[] getRoleList() {
        return roleList;
    }

    public void setRoleList(String[] roleList) {
        this.roleList = roleList;
    }

    public String[] getAgncList() {
        return agncList;
    }

    public void setAgncList(String[] agncList) {
        this.agncList = agncList;
    }

    public void setRoleListStr(String roleListStr) {
        if (roleListStr != null && !roleListStr.isEmpty()) {
            this.roleList = roleListStr.split(",");
        } else {
            this.roleList = null;
        }
    }

    public void setAgncListStr(String agncListStr) {
        if (agncListStr != null && !agncListStr.isEmpty()) {
            this.agncList = agncListStr.split(",");
        } else {
            this.agncList = null;
        }
    }
}
