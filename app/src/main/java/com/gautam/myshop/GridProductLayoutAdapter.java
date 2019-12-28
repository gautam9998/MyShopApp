package com.gautam.myshop;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<horizontal_product_scroll_model> horizontalProductScrollModelList;

    public GridProductLayoutAdapter(List<horizontal_product_scroll_model> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @Override
    public int getCount() {
        return horizontalProductScrollModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if(convertView==null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            ImageView productImage=view.findViewById(R.id.hs_product_image);
            TextView productTitle=view.findViewById(R.id.hs_product_title);
            TextView productDescription=view.findViewById(R.id.hs_product_description);
            TextView productPrice=view.findViewById(R.id.hs_product_price);

            productImage.setImageResource(horizontalProductScrollModelList.get(position).getProductImage());
            productTitle.setText(horizontalProductScrollModelList.get(position).getProductTitle());
            productDescription.setText(horizontalProductScrollModelList.get(position).getProductDescription());
            productPrice.setText(horizontalProductScrollModelList.get(position).getProductPrice());
        }
        else {
            view=convertView;
        }
        return view;
    }






    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.hs_product_image);
            productTitle=itemView.findViewById(R.id.hs_product_title);
            productDescription=itemView.findViewById(R.id.hs_product_description);
            productPrice=itemView.findViewById(R.id.hs_product_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
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
