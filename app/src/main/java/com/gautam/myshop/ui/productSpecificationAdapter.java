package com.gautam.myshop.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gautam.myshop.R;

import java.util.List;

public class productSpecificationAdapter extends RecyclerView.Adapter<productSpecificationAdapter.ViewHolder> {

    private List<productSpecificationModel> productSpecificationModelsList;

    public productSpecificationAdapter(@NonNull List<productSpecificationModel> productSpecificationModelsList) {
        this.productSpecificationModelsList = productSpecificationModelsList;
    }

    public productSpecificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_specification_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productSpecificationAdapter.ViewHolder holder, int position) {
            String featureTitle = productSpecificationModelsList.get(position).getFeatureName();
            String featureDetails = productSpecificationModelsList.get(position).getFeatureValue();
            holder.setFeature(featureTitle,featureDetails);
    }

    @Override
    public int getItemCount() {
        return productSpecificationModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView featureName;
        private  TextView featureValue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            featureName = itemView.findViewById(R.id.feature_name);
            featureValue = itemView.findViewById(R.id.feature_value);
        }
        private void setFeature(String featureTitle,String featureDetails){
            featureName.setText(featureTitle);
            featureValue.setText(featureDetails);
        }
    }
}
