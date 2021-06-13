package com.internship.project.bankingapp.Helper;

public class UserDataModel {
    private String FromUserName;
    private String FromUseraccountNo;
    private String FromUserbalance;

    public UserDataModel(String fromUserName, String fromUseraccountNo, String fromUserbalance) {
        FromUserName = fromUserName;
        FromUseraccountNo = fromUseraccountNo;
        FromUserbalance = fromUserbalance;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getFromUseraccountNo() {
        return FromUseraccountNo;
    }

    public void setFromUseraccountNo(String fromUseraccountNo) {
        FromUseraccountNo = fromUseraccountNo;
    }

    public String getFromUserbalance() {
        return FromUserbalance;
    }

    public void setFromUserbalance(String fromUserbalance) {
        FromUserbalance = fromUserbalance;
    }
}
