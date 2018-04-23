package cn.binux.pojo.sys;

public class SysPermission {
    private Long permId;

    private String permName;

    private String permDataUrl;

    private String permParentId;

    private String permType;

    private String permCreateDate;

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getPermDataUrl() {
        return permDataUrl;
    }

    public void setPermDataUrl(String permDataUrl) {
        this.permDataUrl = permDataUrl == null ? null : permDataUrl.trim();
    }

    public String getPermParentId() {
        return permParentId;
    }

    public void setPermParentId(String permParentId) {
        this.permParentId = permParentId == null ? null : permParentId.trim();
    }

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType == null ? null : permType.trim();
    }

    public String getPermCreateDate() {
        return permCreateDate;
    }

    public void setPermCreateDate(String permCreateDate) {
        this.permCreateDate = permCreateDate == null ? null : permCreateDate.trim();
    }
}