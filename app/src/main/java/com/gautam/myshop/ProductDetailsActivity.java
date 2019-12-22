package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    private ViewPager productIMgesViewPager;
    private TabLayout viewPagerIndicator;
    private FloatingActionButton addToWishListButton;
    private static boolean ALLREADY_ADDED_TO_WISHLIST=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        productIMgesViewPager=findViewById(R.id.product_images_viewpager);
        viewPagerIndicator=findViewById(R.id.viewpager_indicator);
        viewPagerIndicator.setupWithViewPager(productIMgesViewPager,true);

List<Integer> productImages= new ArrayList<>();
productImages.add(R.drawable.shopping);

        productImages.add(R.drawable.banner);
        productImages.add(R.drawable.my_wishlist);
        productImages.add(R.drawable.carts);
        productImages.add(R.drawable.my_account);


        ProductImagesAdapter productImagesAdapter =new ProductImagesAdapter(productImages);
        productIMgesViewPager.setAdapter(productImagesAdapter);
viewPagerIndicator.setupWithViewPager(productIMgesViewPager,true);


        addToWishListButton=findViewById(R.id.add_to_wishlist_button);

        addToWishListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ALLREADY_ADDED_TO_WISHLIST)
                {
                    ALLREADY_ADDED_TO_WISHLIST=false;
                    addToWishListButton.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                }
                else {
                    ALLREADY_ADDED_TO_WISHLIST=true;
                    addToWishListButton.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorAccents));

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==R.id.main_search_icon)
        {
            return true;
        }
        else if(id==android.R.id.home)
        {
            finish();
            return true;
        }

        else if(id==R.id.main_cart_icon)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
