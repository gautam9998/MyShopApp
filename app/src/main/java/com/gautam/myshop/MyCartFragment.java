package com.gautam.myshop;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment {

    private Button continueButton;
    private RecyclerView cartItemRecyclerView;


    public MyCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);

        continueButton = view.findViewById(R.id.cart_continue_button);

        cartItemRecyclerView=view.findViewById(R.id.cart_item_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemRecyclerView.setLayoutManager(layoutManager);


        List<cartItemModel> cartItemModelList=new ArrayList<>();


        cartItemModelList.add(new cartItemModel(0,R.drawable.shopping,"Iphone 11",0,"RS 49999/-","rs 59999",1,0,0));
        cartItemModelList.add(new cartItemModel(0,R.drawable.shopping,"Iphone 11",1,"RS 49999/-","rs 59999",2,1,1));
        cartItemModelList.add(new cartItemModel(0,R.drawable.shopping,"Iphone 11",2,"RS 49999/-","rs 59999",1,2,2));
        cartItemModelList.add(new cartItemModel(1,"Price (5 items) ","Rs 1234","free","123","11111111"));

        cartAdapter cartAdapter=new cartAdapter(cartItemModelList);
        cartItemRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();



        continueButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent deliveryIntent = new Intent(getContext(),deliveryActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });


        return view;
    }

}
