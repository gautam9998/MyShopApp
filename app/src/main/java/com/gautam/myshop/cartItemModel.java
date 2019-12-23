package com.gautam.myshop;

public class cartItemModel  {
    public static final  int CART_ITEM=0;
    public static final int TOTAL_AMOUNT=1;
    private int type;

    ////////////cart item

private int productImage;
private String title;
private int freeCoupons;
private String productPrice;
private String cuttedPrice;
private int productQuantity;
private int offersAPPlied;
private int couponsApplied;

        public cartItemModel(int type, int productImage, String title, int freeCoupons, String productPrice, String cuttedPrice, int productQuantity, int offersAPPlied, int couponsApplied) {
        this.type = type;
        this.productImage = productImage;
        this.title = title;
        this.freeCoupons = freeCoupons;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuantity = productQuantity;
        this.offersAPPlied = offersAPPlied;
        this.couponsApplied = couponsApplied;
    }

    public static int getCartItem() {
        return CART_ITEM;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFreeCoupons() {
        return freeCoupons;
    }

    public void setFreeCoupons(int freeCoupons) {
        this.freeCoupons = freeCoupons;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOffersAPPlied() {
        return offersAPPlied;
    }

    public void setOffersAPPlied(int offersAPPlied) {
        this.offersAPPlied = offersAPPlied;
    }

    public int getCouponsApplied() {
        return couponsApplied;
    }

    public void setCouponsApplied(int couponsApplied) {
        this.couponsApplied = couponsApplied;
    }

    ////////////cart item





    /////////cart
private String totalItems;
    private String totalItemPrice;
    private String delivryPrice;
    private String savedAmount;
    private String totalAmount;

    public cartItemModel(int type, String totalItems, String totalItemPrice, String delivryPrice, String savedAmount, String totalAmount) {
        this.type = type;
        this.totalItems = totalItems;
        this.totalItemPrice = totalItemPrice;
        this.delivryPrice = delivryPrice;
        this.savedAmount = savedAmount;
        this.totalAmount = totalAmount;

    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getDelivryPrice() {
        return delivryPrice;
    }

    public void setDelivryPrice(String delivryPrice) {
        this.delivryPrice = delivryPrice;
    }

    public String getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(String savedAmount) {
        this.savedAmount = savedAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
/////////cart total


}
