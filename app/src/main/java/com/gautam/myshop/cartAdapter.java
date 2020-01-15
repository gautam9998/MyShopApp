package com.gautam.myshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cartAdapter extends RecyclerView.Adapter {


    private List<cartItemModel> cartItemModelList;

    public cartAdapter(List<cartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
  switch (cartItemModelList.get(position).getType()){

      case 0:
          return cartItemModel.CART_ITEM;
      case 1:
          return cartItemModel.TOTAL_AMOUNT;
          default:return -1;// tset
  }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        switch (viewType) {
            case cartItemModel.CART_ITEM:
                View cartItemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
                return new cartItemViewHolder(cartItemview);

            case cartItemModel.TOTAL_AMOUNT:
                View cartTotalView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout,parent,false);
                return new cartTotalAmountViewHolder(cartTotalView);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (cartItemModelList.get(position).getType()){
            case cartItemModel.CART_ITEM:
                int resource=cartItemModelList.get(position).getProductImage();
                String title=cartItemModelList.get(position).getTitle();
                int freecoupons=cartItemModelList.get(position).getFreeCoupons();
                String productPrice=cartItemModelList.get(position).getProductPrice();
                String cuttedPrice=cartItemModelList.get(position).getCuttedPrice();
                int offersapplied=cartItemModelList.get(position).getOffersAPPlied();
                ((cartItemViewHolder)holder).setItemDetails(resource,title,freecoupons,productPrice,cuttedPrice,offersapplied);
            break;
            case  cartItemModel.TOTAL_AMOUNT:

                String totalItems=cartItemModelList.get(position).getTotalItems();
                String totalItemPrice=cartItemModelList.get(position).getTotalItemPrice();
                String deliveryPrice=cartItemModelList.get(position).getDelivryPrice();
                String totalAmount=cartItemModelList.get(position).getTotalAmount();
                String savedAmount=cartItemModelList.get(position).getSavedAmount();



                ((cartTotalAmountViewHolder)holder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount,savedAmount);
                break;
                default:
                    return;
        }


    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }



    class cartItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private ImageView freeCouponIcon;
        private TextView productTitle;
        private TextView freeCoupons;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView couponsApplied;
        private TextView productQuantity;

        public cartItemViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            offersApplied=itemView.findViewById(R.id.offers_applied);
            freeCouponIcon=itemView.findViewById(R.id.free_coupon_icon);
            freeCoupons=itemView.findViewById(R.id.tv_free_coupon);
            productPrice=itemView.findViewById(R.id.product_price);
            cuttedPrice=itemView.findViewById(R.id.cutted_price);
            offersApplied=itemView.findViewById(R.id.offers_applied);
            couponsApplied=itemView.findViewById(R.id.coupons_applied);
            productQuantity=itemView.findViewById(R.id.product_quantity);


        }

        private void setItemDetails(int resource,String title,int freeCouponsno,String productPriceText,String cuttedPriceText,int offersAppliedNo){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if(freeCouponsno>0)
            {
                freeCouponIcon.setVisibility(View.INVISIBLE);
                freeCoupons.setVisibility(View.INVISIBLE);
                if(freeCouponsno==1)
                freeCoupons.setText("free "+ freeCouponsno +" Coupon" );
                else
                    freeCoupons.setText("free "+ freeCouponsno +" Coupon" );
            }
            else {
                freeCouponIcon.setVisibility(View.INVISIBLE);
                freeCoupons.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);


            if(offersAppliedNo>0)
            {
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersAppliedNo+ " offers applied");
            }
            else{
                offersApplied.setVisibility(View.INVISIBLE);
            }
            //offersApplied.setText(offersAppliedNo);



        }


    }
    class cartTotalAmountViewHolder extends RecyclerView.ViewHolder{
        private TextView totalItems,totalItemPrice,delivryPrice,totalAmount,savedAmount;
        public cartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItems=itemView.findViewById(R.id.total_items);
            totalItemPrice=itemView.findViewById(R.id.total_items_price);
            delivryPrice=itemView.findViewById(R.id.delivery_price);
            totalAmount=itemView.findViewById(R.id.total_price);
            savedAmount=itemView.findViewById(R.id.saved_amount);
        }

        private void setTotalAmount(String totalItemtxt,String totalItemPricetxt,String deliveryPriceTxt,String totalAmountTxt,String savedAmountTxt){
            totalItems.setText(totalItemtxt);
            totalItemPrice.setText(totalItemPricetxt);
            delivryPrice.setText(deliveryPriceTxt);
            totalAmount.setText(totalAmountTxt);
            savedAmount.setText(savedAmountTxt);
        }
    }

}
