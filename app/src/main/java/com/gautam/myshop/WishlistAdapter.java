package com.gautam.myshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.ViewHolder>{
    private List<WishlistModel>wishlistModelList;

    public WishlistAdapter(List<WishlistModel> wishlistModelList) {
        this.wishlistModelList = wishlistModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wish_list_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = wishlistModelList.get(position).getProductImage();
        String title= wishlistModelList.get(position).getProductTitle();
        int freecoupons= wishlistModelList.get(position).getFreecoupons();
        String rating = wishlistModelList.get(position).getRating();
        int totalRating = wishlistModelList.get(position).getTotalRatings();
        String productPrice = wishlistModelList.get(position).getProdcutPrice();
        String cuttedprice = wishlistModelList.get(position).getCuttedPrice();
        String paymentMethod = wishlistModelList.get(position).getPaymentMethod();
        viewHolder.setData(resource,title,freecoupons,rating,totalRating,productPrice,cuttedprice,paymentMethod);
    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView freecoupons;
        private TextView couponIcon;
        private TextView rating;
        private TextView totalRatings;
        private View priceCut;

        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageButton deletBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            freecoupons=itemView.findViewById(R.id.free_coupon);
            couponIcon=itemView.findViewById(R.id.coupon_icon);
            rating=itemView.findViewById(R.id.tv_prouct_rating_miniview);
            totalRatings=itemView.findViewById(R.id.total_ratings);
            priceCut=itemView.findViewById(R.id.price_cut);
            productPrice=itemView.findViewById(R.id.product_price);
            cuttedPrice=itemView.findViewById(R.id.cutted_price);
            paymentMethod=itemView.findViewById(R.id.payment_method);
            deletBtn=itemView.findViewById(R.id.delete_button);
        }
        private  void setData(int resource, String title, int freecouponsNo, String averageRate, int totalRatingsNo, String price, String cuttedPriceValue, String payMethod){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if(freecouponsNo !=0){
                couponIcon.setVisibility(View.VISIBLE);
                if(freecouponsNo==1){
                    freecoupons.setText("free "+ freecouponsNo + " coupon");
                }else{
                    freecoupons.setText("free "+ freecouponsNo + " coupons");
                }

            }else{
                couponIcon.setVisibility(View.VISIBLE);
                freecoupons.setVisibility(View.INVISIBLE);
            }
            rating.setText(averageRate);
            totalRatings.setText(totalRatingsNo+"(ratings)");
            productPrice.setText(price);
            cuttedPrice.setText(cuttedPriceValue);
            paymentMethod.setText(payMethod);
            deletBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),"delete",Toast.LENGTH_SHORT).show();
                }
            });



        }
    }
}
