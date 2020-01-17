package com.gautam.myshop;

public class WishlistModel {
    private int productImage;
    private String productTitle;
    private int freecoupons;
    private String rating;
    private  int totalRatings;
    private String prodcutPrice;
    private String cuttedPrice;
    private String paymentMethod;

    public WishlistModel(int productImage, String productTitle, int freecoupons, String rating, int totalRatings, String prodcutPrice, String cuttedPrice, String paymentMethod) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freecoupons = freecoupons;
        this.rating = rating;
        //this.totalRatings = totalRatings;
        this.prodcutPrice = prodcutPrice;
        this.cuttedPrice = cuttedPrice;
        this.paymentMethod = paymentMethod;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreecoupons() {
        return freecoupons;
    }

    public void setFreecoupons(int freecoupons) {
        this.freecoupons = freecoupons;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getProdcutPrice() {
        return prodcutPrice;
    }

    public void setProdcutPrice(String prodcutPrice) {
        this.prodcutPrice = prodcutPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
