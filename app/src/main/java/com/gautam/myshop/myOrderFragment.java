package com.gautam.myshop;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class myOrderFragment extends Fragment {


    private myOrderItemModel myOrderAdapter;

    public myOrderFragment() {
        // Required empty public constructor
    }


    private RecyclerView myordersRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_order, container, false);

        myordersRecyclerView = view.findViewById(R.id.my_orders_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager((getContext()));
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myordersRecyclerView.setLayoutManager(layoutManager);

        List<myOrderItemModel> myOrderItemModelList = new ArrayList<>();

        myOrderItemModelList.add(new myOrderItemModel(R.drawable.product_image,2,"Pixel 2XL (BLACK)","Delivered on Monday,25th Jan 2020"));

        myOrderItemModelList.add(new myOrderItemModel(R.drawable.product_image,3,"Pixel 2XL (BLACK)", "Delivered on Monday,25th Jan 2020"));

        myOrderItemModelList.add(new myOrderItemModel(R.drawable.product_image,0,"Pixel 2XL (BLACK)", "Delivered on Monday,25th Jan 2020"));

        myOrderItemModelList.add(new myOrderItemModel(R.drawable.product_image,1,"Pixel 2XL (BLACK)", "Cancelled"));

        myOrderAdapter adapter = new myOrderAdapter(myOrderItemModelList);
        myordersRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;

    }

}

