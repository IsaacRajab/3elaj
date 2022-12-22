package com.example.a3elaj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<Product> productDataArrayList;
    private Context mcontext;
    public View view;

    public RecyclerViewAdapter(ArrayList<Product> recyclerDataArrayList, Context mcontext) {
        this.productDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        Product recyclerData = productDataArrayList.get(position);
        holder.productName.setText(recyclerData.getProduct());
        holder.imgProduct.setImageResource(recyclerData.getImgid());
        holder.ProductPrice.setText(recyclerData.getAmount());

    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return productDataArrayList.size();
    }



    public void ViewHolder(View v) {
        view = v;
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(mcontext.getApplicationContext(), "ssss", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView productName;
        private ImageView imgProduct;
        private TextView ProductPrice;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            imgProduct = itemView.findViewById(R.id.productImg);
            ProductPrice= itemView.findViewById(R.id.productPrice);
        }
    }
}
