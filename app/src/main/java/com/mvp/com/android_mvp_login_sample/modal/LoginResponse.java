package com.mvp.com.android_mvp_login_sample.modal;

public class LoginResponse {

    private String fullName;
    private String userName;
    private String phoneNumber;
    private String userAddress;

    public LoginResponse(String fullName, String userName, String phoneNumber, String userAddress) {
        this.fullName = fullName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }
}
