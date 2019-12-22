package com.gautam.myshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Category_adapter extends RecyclerView.Adapter<Category_adapter.ViewHolder> {
    private List<Category_model> category_modelList;

    public Category_adapter(List<Category_model> category_modelList) {
        this.category_modelList = category_modelList;
    }

    @NonNull
    @Override
    public Category_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Category_adapter.ViewHolder holder, int position) {
        String icon=category_modelList.get(position).getCategory_icon_link();
        String name=category_modelList.get(position).getCategory_name();
       holder.setCategoryName(name);


    }

    @Override
    public int getItemCount() {
        return category_modelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
private ImageView categoryIcon;
        private TextView categoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryIcon=itemView.findViewById(R.id.category_icon);
            categoryName=itemView.findViewById(R.id.category_name);



        }
        private void setCategoryIcon()
        {

        }
        private void setCategoryName(String name)
        {
            categoryName.setText(name);
        }

    }
}
