package com.internship.project.bankingapp.Helper;

import android.util.Log;

public class SendToUserDataModel {
    private String UserName;
    private String accountNo;
    private String availableBalanceOfUser;
    private String fromUserName;
    private String fromUserAcNo;
    private String fromUserAcBalance;


    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserAcNo() {
        return fromUserAcNo;
    }

    public void setFromUserAcNo(String fromUserAcNo) {
        this.fromUserAcNo = fromUserAcNo;
    }

    public String getFromUserAcBalance() {
        return fromUserAcBalance;
    }

    public void setFromUserAcBalance(String fromUserAcBalance) {
        this.fromUserAcBalance = fromUserAcBalance;
    }


    public String getAvailableBalanceOfUser() {
        return availableBalanceOfUser;
    }

    public void setAvailableBalanceOfUser(String availableBalanceOfUser) {
        this.availableBalanceOfUser = availableBalanceOfUser;
    }

    public SendToUserDataModel(String userName, String accountNo, String availableBalanceOfUser, String fromUserName, String fromUserAcNo, String fromUserAcBalance) {
        UserName = userName;
        this.accountNo = accountNo;
        this.availableBalanceOfUser = availableBalanceOfUser;
        this.fromUserName = fromUserName;
        this.fromUserAcNo = fromUserAcNo;
        this.fromUserAcBalance = fromUserAcBalance;
/*
        Log.i("Fuser acNo" , " : "+fromUserAcNo);
        Log.i("Fuser acBalance" , " : "+fromUserAcBalance);*/
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
