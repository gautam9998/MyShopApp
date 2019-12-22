package com.gautam.myshop;

import java.util.List;

public class HomePageModel {
    private int type;

    public static final int BANNERSLIDER=0;
    public static final int STRIP_AD_BANNER=1;
    public static final int HORIZONTAL_PRODUCT_VIEW=2;
    public static final int GRID_PRODUCT_VIEW=3;



    ////////////banner
    private List<slider_model> sliderModelList;

    public HomePageModel(int type, List<slider_model> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<slider_model> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<slider_model> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    ////////banner







    /////////////////stripad

private int resource;
    private String backgroungColor;

    public HomePageModel(int type, int resource, String backgroungColor) {
        this.type = type;

        this.resource = resource;
        this.backgroungColor = backgroungColor;
    }



    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getBackgroungColor() {
        return backgroungColor;
    }

    public void setBackgroungColor(String backgroungColor) {
        this.backgroungColor = backgroungColor;
    }
    /////////////////stripad







    //////////////////horizontal


private String title;
    private List<horizontal_product_scroll_model> horizontalProductScrollModelList;

    public HomePageModel(int type, String title, List<horizontal_product_scroll_model> horizontalProductScrollModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<horizontal_product_scroll_model> getHorizontalProductScrollModelList() {
        return horizontalProductScrollModelList;
    }

    public void setHorizontalProductScrollModelList(List<horizontal_product_scroll_model> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }
    //////////////////horizontal












}
