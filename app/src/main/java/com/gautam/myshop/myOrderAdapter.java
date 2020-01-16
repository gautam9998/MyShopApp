package com.gautam.myshop;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myOrderAdapter extends RecyclerView.Adapter<myOrderAdapter.Viewholder> {

    private List<myOrderItemModel> myOrderItemModelList;


    public myOrderAdapter(List<myOrderItemModel> myOrderItemModelList) {
        this.myOrderItemModelList = myOrderItemModelList;
    }

    @NonNull
    @Override
    public myOrderAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_item_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int resource = myOrderItemModelList.get(position).getProductImage();
        int rating = myOrderItemModelList.get(position).getRating();
        String title = myOrderItemModelList.get(position).getProdictTitle();
        String deliverydate = myOrderItemModelList.get(position).getDeliveryStatus();

        holder.setData(resource,title,deliverydate,rating);
    }


    @Override
    public int getItemCount() {
        return myOrderItemModelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private ImageView orderIndicator;
        private TextView productTitle;
        private TextView deliveryStatus;

        private LinearLayout rateNowContainer;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            orderIndicator = itemView.findViewById(R.id.order_indicator);
            deliveryStatus = itemView.findViewById(R.id.order_delivered_date);

            rateNowContainer = itemView.findViewById(R.id.rate_now_container);
        }


        private void setData(int resource, String title, String deliverydate, int rating){
            productImage.setImageResource(resource);
            productTitle.setText(title);

            if(deliverydate.equals("Cancelled")){
                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorPrimary)));
            }
            else{
                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.successGreen)));
            }
            deliveryStatus.setText(deliverydate);

            ///rating Layout
            setRating(rating);


            for(int x = 0; x < rateNowContainer.getChildCount(); x++){

                final int starPosition = x;

                rateNowContainer.getChildAt(x).setOnClickListener((View.OnClickListener) (v) -> {
                    setRating(starPosition);
                });
            }



        }

        private void setRating(int starPositon){

            for(int x = 0; x < rateNowContainer.getChildCount(); x++){

                ImageView starBtn = (ImageView)rateNowContainer.getChildAt(x);
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));

                if( x <= starPositon){
                    starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
                }
            }
        }



    }
}

