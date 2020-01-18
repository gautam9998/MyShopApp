package com.gautam.myshop.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class product_details_adapter extends FragmentPagerAdapter {

    private int tab;
    public product_details_adapter(FragmentManager fm,int tab){
        super(fm);
        this.tab = tab;
    }

    public Fragment getItem(int i) {
        switch (i){
            case 0:
                productDescriptionFragment productDescriptionFragment1 = new productDescriptionFragment();
                return productDescriptionFragment1;
            case 1:
                productDescriptionFragment productDescriptionFragment2 = new productDescriptionFragment();
                return productDescriptionFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tab;
    }
}
