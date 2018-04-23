package cn.binux.pojo.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUser implements Serializable {
    private Long userId;

    private String userAccount;

    private String userPass;

    private Integer userCount;

    private String userTel;

    private String userEmail;

    private Integer userSex;

    private Integer userStatus;

    private String userBirthday;

    private String userRegisterDate;

    private Date userLastDate;

    private Date userPassDate;

    private List<SysRole> roles=null;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }

    public String getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(String userRegisterDate) {
        this.userRegisterDate = userRegisterDate == null ? null : userRegisterDate.trim();
    }

    public Date getUserLastDate() {
        return userLastDate;
    }

    public void setUserLastDate(Date userLastDate) {
        this.userLastDate = userLastDate;
    }

    public Date getUserPassDate() {
        return userPassDate;
    }

    public void setUserPassDate(Date userPassDate) {
        this.userPassDate = userPassDate;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }



}