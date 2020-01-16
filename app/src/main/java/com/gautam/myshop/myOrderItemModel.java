package com.gautam.myshop;

public class myOrderItemModel {

    private int productImage;
    private String prodictTitle;
    private String deliveryStatus;
    private int rating;

    public myOrderItemModel(int productImage, int rating, String prodictTitle, String deliveryStatus) {
        this.productImage = productImage;
        this.prodictTitle = prodictTitle;
        this.deliveryStatus = deliveryStatus;
        this.rating = rating;
    }

    public int getProductImage() {
        return productImage;
    }

    public String getProdictTitle() {
        return prodictTitle;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setProdictTitle(String prodictTitle) {
        this.prodictTitle = prodictTitle;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}

