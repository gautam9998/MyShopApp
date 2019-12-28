package com.gautam.myshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView=findViewById(R.id.grid_view);


int layout_code=getIntent().getIntExtra("layout_code",-1);

if(layout_code==1) {
    List<horizontal_product_scroll_model> horizontalProductScrollModelList = new ArrayList<>();
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.profile, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_rewards, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.app_icon, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.profile, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_rewards, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.app_icon, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist, "Iphone 11 ", "Triple camera", "Rs 100000"));
    horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping, "Iphone 11 ", "Triple camera", "Rs 100000"));
    gridView.setVisibility(View.VISIBLE);
    GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
    gridView.setAdapter(gridProductLayoutAdapter);
}

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
