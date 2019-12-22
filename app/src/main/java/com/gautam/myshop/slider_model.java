package com.gautam.myshop;

public class slider_model {
    private int banner;
    private String backgroundcolor;

    public slider_model(int banner, String backgroundcolor) {
        this.banner = banner;
        this.backgroundcolor = backgroundcolor;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }
}
