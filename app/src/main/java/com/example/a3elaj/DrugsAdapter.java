package com.example.a3elaj;
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

public class DrugsAdapter extends RecyclerView.Adapter<DrugsAdapter.ViewHolder>{
    private String[] pName;
    private int[] pImg;
    private String[] pPrice;
    Context context;

    public DrugsAdapter(String[] pName, int[] pImg, String[] pPrice) {
        this.pName = pName;
        this.pImg = pImg;
        this.pPrice = pPrice;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        CardView card = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout
        ,parent,
                false);
        return new ViewHolder(card);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    CardView card = holder.cardView;

    // Image Druge
        ImageView img = card.findViewById(R.id.productImg);
        Drawable dr = ContextCompat.getDrawable(card.getContext(),pImg[position]);
        img.setImageDrawable(dr);

        TextView name,price;
        // Name Druge
        name = card.findViewById(R.id.productName);
        name.setText(pName[position]);
        // Price Druge
        price = card.findViewById(R.id.productPrice);
        price.setText(pPrice[position]);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ProductPage productPage = new ProductPage(img,name,price);
//
//                productPage.getpName().setText(pName[position]);
                Intent i = new Intent(v.getContext(), ProductPage.class);
                v.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pName.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }
    }
}
