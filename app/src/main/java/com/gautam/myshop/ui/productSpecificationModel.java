package com.gautam.myshop.ui;

public class productSpecificationModel {

    private String featureName;
    private String featureValue;

    public productSpecificationModel(String featureName, String featureValue) {
    }

    public String getFeatureName() {
        return featureName;
    }


    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}