package com.gautam.myshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class horizontal_product_scroll_adapter extends RecyclerView.Adapter<horizontal_product_scroll_adapter.ViewHolder> {
    private List<horizontal_product_scroll_model> horizontalProductScrollModelList;

    public horizontal_product_scroll_adapter(List<horizontal_product_scroll_model> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @NonNull
    @Override
    public horizontal_product_scroll_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull horizontal_product_scroll_adapter.ViewHolder holder, int position) {



        int resource=horizontalProductScrollModelList.get(position).getProductImage();
        String title=horizontalProductScrollModelList.get(position).getProductTitle();
        String description=horizontalProductScrollModelList.get(position).getProductDescription();
        String price=horizontalProductScrollModelList.get(position).getProductPrice();
        holder.setProductImage(resource);
        holder.setProductTitle(title);
        holder.setProductDescription(description);
        holder.setProductPrice(price);


    }

    @Override
    public int getItemCount() {
        if(horizontalProductScrollModelList.size()>8)
        {
            return 8;
        }
        else {


            return horizontalProductScrollModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.hs_product_image);
            productTitle=itemView.findViewById(R.id.hs_product_title);
            productDescription=itemView.findViewById(R.id.hs_product_description);
            productPrice=itemView.findViewById(R.id.hs_product_price);
        }


        private void setProductImage(int resource)
        {
            productImage.setImageResource(resource);
        }
        private void setProductTitle(String title)
        {
            productTitle.setText(title);
        }
        private void setProductDescription(String description)
        {
            productTitle.setText(description);
        }
        private void setProductPrice(String title)
        {
            productTitle.setText(title);
        }
    }
}
