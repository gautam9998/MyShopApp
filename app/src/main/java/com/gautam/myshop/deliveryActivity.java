package com.gautam.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class deliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerView;
    private Button changeOraddNewAddressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");


        deliveryRecyclerView = findViewById(R.id.delivery_recyclerView);

        changeOraddNewAddressButton = findViewById(R.id.change_or_add_address_button);


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);


        List<cartItemModel> cartItemModelList=new ArrayList<>();


        cartItemModelList.add(new cartItemModel(0,R.drawable.shopping,"Iphone 11",0,"RS 49999/-","rs 59999",1,0,0));
        cartItemModelList.add(new cartItemModel(0,R.drawable.shopping,"Iphone 11",1,"RS 49999/-","rs 59999",2,1,1));
        cartItemModelList.add(new cartItemModel(0,R.drawable.shopping,"Iphone 11",2,"RS 49999/-","rs 59999",1,2,2));
        cartItemModelList.add(new cartItemModel(1,"Price (5 items) ","Rs 1234","free","123","11111111"));
        cartAdapter cartAdapter=new cartAdapter(cartItemModelList);
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();


        changeOraddNewAddressButton.setVisibility(View.VISIBLE);
        changeOraddNewAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myaddressIntent = new Intent(deliveryActivity.this,alladressesactivity.class);
                startActivity((myaddressIntent));
            }
        });

    }


    public boolean onOptionsItemSelected(MenuItem item)
    {


        int id=item.getItemId();

        if(id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
