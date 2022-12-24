package com.example.a3elaj;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrugsAdapter extends RecyclerView.Adapter<DrugsAdapter.MyViewHolder>{

    private ArrayList<Drugs> drugsList;
    private RecyclerViewClickListener listener;

    public DrugsAdapter(ArrayList<Drugs> drugsList, RecyclerViewClickListener listener){
        this.drugsList = drugsList;
        this.listener = listener;
    }

    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView pName;
        private ImageView pImg;
        private TextView pPrice;

        public MyViewHolder(final View view){
            super(view);
            pName = view.findViewById(R.id.productName);
            pImg = view.findViewById(R.id.productImg);
            pPrice = view.findViewById(R.id.productPrice);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());

        }
    }

    @NonNull
    @Override
    public DrugsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrugsAdapter.MyViewHolder holder, int position) {

    String productName = drugsList.get(position).getName();
    int productImage = drugsList.get(position).getImg();
    String productPrice = drugsList.get(position).getPrice();

    holder.pName.setText(productName);
    holder.pImg.setImageResource(productImage);
    holder.pPrice.setText(productPrice+" ₪");


    }

    @Override
    public int getItemCount() {
        return drugsList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int postion);
    }
}
