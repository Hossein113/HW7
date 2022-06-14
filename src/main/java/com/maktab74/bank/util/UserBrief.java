package com.maktab74.bank.util;

public class UserBrief {


    private String userName;

    private String pasword;

    public UserBrief(String userName, String pasword) {
        this.userName = userName;
        this.pasword = pasword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}


