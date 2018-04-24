package cn.binux.pojo;

public class Address {
    private Integer addressId;

    private String sendPlace;

    private String sendMan;

    private String sendPhone;

    private Integer userId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getSendPlace() {
        return sendPlace;
    }

    public void setSendPlace(String sendPlace) {
        this.sendPlace = sendPlace == null ? null : sendPlace.trim();
    }

    public String getSendMan() {
        return sendMan;
    }

    public void setSendMan(String sendMan) {
        this.sendMan = sendMan == null ? null : sendMan.trim();
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone == null ? null : sendPhone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}