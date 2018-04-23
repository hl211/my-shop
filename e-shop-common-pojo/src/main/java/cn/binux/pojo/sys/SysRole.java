package cn.binux.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private Integer roleUpdateUser;

    private String roleCreateDate;

    private Date roleUpdateDate;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public Integer getRoleUpdateUser() {
        return roleUpdateUser;
    }

    public void setRoleUpdateUser(Integer roleUpdateUser) {
        this.roleUpdateUser = roleUpdateUser;
    }

    public String getRoleCreateDate() {
        return roleCreateDate;
    }

    public void setRoleCreateDate(String roleCreateDate) {
        this.roleCreateDate = roleCreateDate == null ? null : roleCreateDate.trim();
    }

    public Date getRoleUpdateDate() {
        return roleUpdateDate;
    }

    public void setRoleUpdateDate(Date roleUpdateDate) {
        this.roleUpdateDate = roleUpdateDate;
    }
}