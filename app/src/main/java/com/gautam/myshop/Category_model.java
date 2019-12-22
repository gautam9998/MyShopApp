package com.gautam.myshop;

public class Category_model {
    private String Category_icon_link;
    private String category_name;

    public Category_model(String category_icon_link, String category_name) {
        Category_icon_link = category_icon_link;
        this.category_name = category_name;
    }

    public String getCategory_icon_link() {
        return Category_icon_link;
    }

    public void setCategory_icon_link(String category_icon_link) {
        Category_icon_link = category_icon_link;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
