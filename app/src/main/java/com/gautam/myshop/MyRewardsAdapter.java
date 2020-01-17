package com.gautam.myshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRewardsAdapter extends RecyclerView.Adapter<MyRewardsAdapter.Viewholder> {

    private List<RewardModel> rewardModelList;

    public MyRewardsAdapter(List<RewardModel> rewardModelList) {
        this.rewardModelList = rewardModelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rewards_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewHolder, int position) {
        String title = rewardModelList.get(position).getTitle();
        String date= rewardModelList.get(position).getExpiryDate();
        String body = rewardModelList.get(position).getCooupenBody();
        viewHolder.setData(title,date,body);
    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

         private TextView coupenTitle;
         private TextView coupenExpiryDate;
         private TextView coupenBody;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            coupenTitle=itemView.findViewById(R.id.coupen_title);
            coupenExpiryDate= itemView.findViewById(R.id.coupen_validity);
            coupenBody=itemView.findViewById(R.id.coupen_body);
        }
        private void setData(String title, String date,String body){
            coupenTitle.setText(title);
            coupenExpiryDate.setText(date);
            coupenBody.setText(body);
        }
    }
}
