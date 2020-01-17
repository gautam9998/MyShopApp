package com.gautam.myshop.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gautam.myshop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSpecificationFragment extends Fragment {


    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView productSpecificationRecylerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_specification, container, false);

        productSpecificationRecylerView = view.findViewById(R.id.product_specification_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productSpecificationRecylerView.setLayoutManager(linearLayoutManager);

        List<productSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new productSpecificationModel("RAM","4GB"));
        productSpecificationModelList.add(new productSpecificationModel("RAM","4GB"));
        productSpecificationModelList.add(new productSpecificationModel("RAM","4GB"));
        productSpecificationModelList.add(new productSpecificationModel("RAM","4GB"));
        productSpecificationModelList.add(new productSpecificationModel("RAM","4GB"));
        productSpecificationModelList.add(new productSpecificationModel("RAM","4GB"));
        productSpecificationModelList.add(new productSpecificationModel("RAM","4GB"));

        productSpecificationAdapter productspecificationAdapter = new productSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecylerView.setAdapter(productspecificationAdapter);
        productspecificationAdapter.notifyDataSetChanged();
        return view;
    }

}
