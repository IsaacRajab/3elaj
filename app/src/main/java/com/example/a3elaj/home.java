package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Product> recyclerDataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.Productss);

        String[] pName = new String[Drugs.drugs.length];
        int[] pImg = new int[Drugs.drugs.length];
        String[] pPrice = new String[Drugs.drugs.length];

        for (int i=0 ; i< pName.length;i++){
            pName[i] = Drugs.drugs[i].getName();
            pImg[i] = Drugs.drugs[i].getImg();
            pPrice[i] = Drugs.drugs[i].getPrice();
        }

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        DrugsAdapter adapter = new DrugsAdapter(pName, pImg , pPrice);
        recyclerView.setAdapter(adapter);


    }
}