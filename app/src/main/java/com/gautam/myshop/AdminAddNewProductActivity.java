package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class AdminAddNewProductActivity extends AppCompatActivity {


    private ImageView tshirts,sports,femaleDresses,sweaters;
    private ImageView glasses,hatsCaps,walletsBagsPurse,shoes;
    private ImageView headPhones,Laptops,watches,mobilePhone;
   // private ImageView tshirts,sports,femaleDresses,sweaters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);
        Toast.makeText(this,"Welcome  Admin",Toast.LENGTH_SHORT).show();
    }

 
}
