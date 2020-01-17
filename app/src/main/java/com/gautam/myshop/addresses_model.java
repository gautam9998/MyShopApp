package com.gautam.myshop;

public class addresses_model {

    public addresses_model(String fullname, String addresses, String pincode) {
        this.fullname = fullname;
        this.addresses = addresses;
        this.pincode = pincode;
    }

    private String fullname;
    private String addresses;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    private String pincode;

}
