package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    ArrayList<Drugs> drugsListCart;
    private RecyclerView recyclerView;
    private DrugsAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.cartRecycler);
        drugsListCart = new ArrayList<>();
        setDrugsData();
        setAdapter();

    }

    private void setAdapter() {
        setOnClikListner();

        DrugsAdapter adapter = new DrugsAdapter(ProductPage.drugsListCart,listener);
        RecyclerView.LayoutManager layoutManager  = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClikListner() {
        listener = new DrugsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int postion) {
                ProductPage.drugsListCart.remove(0);
            }
        };
    }




    private void setDrugsData() {

        drugsListCart.add(new Drugs(0,"Panadol Extra","Panadol Extra Advance Tablets provides extra effective " +
                "pain relief from headaches, period pain and the aches & pains associated with colds & flu. Contains" +
                " Paracetamol and Caffeine.",
                R.drawable.panadolred,"40",30));
    }
}