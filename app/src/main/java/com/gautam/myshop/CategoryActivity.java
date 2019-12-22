package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryRecyclerView = findViewById(R.id.category_recycler_view);


        ////////////////








       List<slider_model>   sliderModelList =new ArrayList<slider_model>();





        sliderModelList.add(new slider_model(R.drawable.my_rewards,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.search,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.app_icon,"#077AE4"));







        sliderModelList.add(new slider_model(R.drawable.banner,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.profile,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_order,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_wishlist,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_rewards,"#077AE4"));







        sliderModelList.add(new slider_model(R.drawable.search,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.app_icon,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.profile,"#077AE4"));


        ////////////






        ///////////////////////////////*








        ///////////////////////////////*





















        //////////////////**





        List<horizontal_product_scroll_model> horizontalProductScrollModelList=new ArrayList<>();
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.profile,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_rewards,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.app_icon,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));







//////////////////***







        //////////////////***




        //////////////////**









        ///////////////test


        LinearLayoutManager testLayoutManager=new LinearLayoutManager(CategoryActivity.this);
        testLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       categoryRecyclerView.setLayoutManager(testLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();


        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ff0000"));
        //homePageModelList.add(new HomePageModel(1,R.drawable.app_icon,"#000000"));

        homePageModelList.add(new HomePageModel(2,"  DEALS OF THE DAY",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"DEALS OF THE DAY",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));

        // homePageModelList.add(new HomePageModel(0,sliderModelList));
        // homePageModelList.add(new HomePageModel(1,R.drawable.shopping,"#ffff00"));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);


        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
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
        else if (id==android.R.id.home)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

