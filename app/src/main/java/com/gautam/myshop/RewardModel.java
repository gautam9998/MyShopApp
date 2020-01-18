package com.gautam.myshop;

public class RewardModel {
    private String title;
    private String expiryDate;
    private String coupenBody;

    public RewardModel(String title, String expiryDate, String cooupenBody) {
        this.title = title;
        this.expiryDate = expiryDate;
        this.coupenBody = cooupenBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCooupenBody() {
        return coupenBody;
    }

    public void setCooupenBody(String cooupenBody) {
        this.coupenBody = cooupenBody;
    }

}
