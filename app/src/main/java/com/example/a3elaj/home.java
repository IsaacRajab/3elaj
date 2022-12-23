package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    private Context mContext;

    private ArrayList<Drugs> drugsList;
    private RecyclerView recyclerView;
    private DrugsAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.Productss);
        drugsList = new ArrayList<>();

        setDrugsData();
        setAdapter();

    }


    private void setAdapter() {
        setOnClikListner();

        DrugsAdapter adapter = new DrugsAdapter(drugsList,listener);
        RecyclerView.LayoutManager layoutManager  = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClikListner() {
        listener = new DrugsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int postion) {
                Intent intent = new Intent(getApplicationContext(),ProductPage.class);
                intent.putExtra("productName",drugsList.get(postion).getName());
                intent.putExtra("productImg",drugsList.get(postion).getImg());
                intent.putExtra("productPrice" , drugsList.get(postion).getPrice());
                intent.putExtra("productDisc" , drugsList.get(postion).getDetails());
                intent.putExtra("productQuantity" , drugsList.get(postion).getQuantity());



                startActivity(intent);
            }
        };
    }

    private void setDrugsData() {
        drugsList.add(new Drugs(0,"Trofeen","For head pain after food",
                R.drawable.truffen,"19",5));
        drugsList.add(new Drugs(0,"Banadol","For head pain after food",
                R.drawable.truffen,"19",5));
        drugsList.add(new Drugs(0,"Trofeen","For head pain after food",
                R.drawable.truffen,"19",5));
    }



    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
}