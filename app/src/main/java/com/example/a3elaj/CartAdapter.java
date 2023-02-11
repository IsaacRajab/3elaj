package com.example.a3elaj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{

    Context context;
    ArrayList<Drugs> drugsListCart;

    public CartAdapter(Context context , ArrayList<Drugs> drugsListCart){
        this.context = context;
        this.drugsListCart=drugsListCart;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_card_cart,parent,false);

        return new CartAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.MyViewHolder holder, int position) {
        String drugNameCard = drugsListCart.get(position).getName();
        int drugImgCard = drugsListCart.get(position).getImg();
        String drugPriceCard = drugsListCart.get(position).getPrice();
        String drugDescriptionCard = drugsListCart.get(position).getDetails();

        holder.drugNameCard.setText(drugNameCard);
        holder.drugImgCard.setImageResource(drugImgCard);
        holder.drugPriceCard.setText(drugPriceCard);
        holder.drugDescriptionCard.setText(drugDescriptionCard);
    }

    @Override
    public int getItemCount() {
        return drugsListCart.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView drugImgCard;
        TextView drugNameCard,drugDescriptionCard,drugPriceCard, drugQuantityCard;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            drugImgCard = itemView.findViewById(R.id.drugImgCard);
            drugNameCard = itemView.findViewById(R.id.drugNameCard);
            drugDescriptionCard = itemView.findViewById(R.id.drugDescriptionCard);
            drugPriceCard = itemView.findViewById(R.id.drugPriceCard);
            drugQuantityCard = itemView.findViewById(R.id.drugQuantityCard);

        }
    }
}
