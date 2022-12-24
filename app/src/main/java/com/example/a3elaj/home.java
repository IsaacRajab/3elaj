package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    private Context mContext;

    private ArrayList<Drugs> drugsList;
    private RecyclerView recyclerView;
    private DrugsAdapter.RecyclerViewClickListener listener;
    private Button logOut ;
    private Button goCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.Productss);
        logOut = findViewById(R.id.logOut);

        logOut.setOnClickListener(v -> logOutF());
        drugsList = new ArrayList<>();
        goCart = findViewById(R.id.goCart);
        setDrugsData();
        setAdapter();

        onClikeCart();
    }

    private void onClikeCart() {
        goCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent2);
            }
        });
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
                intent.putExtra("productPrice" , drugsList.get(postion).getPrice()+" ₪");
                intent.putExtra("productDisc" , drugsList.get(postion).getDetails());
                intent.putExtra("productQuantity" , drugsList.get(postion).getQuantity());
                intent.putExtra("productId" , drugsList.get(postion).getId());


                startActivity(intent);
            }
        };
    }



    private void setDrugsData() {
        drugsList.add(new Drugs(0,"Trofeen","For head pain after food",
                R.drawable.truffen,"19",5));
        drugsList.add(new Drugs(0,"Banadol","Panadol is a medicinal product for use in pain" +
                " of various origins, such as headache, migraine,",
                R.drawable.panadol,"30",10));
        drugsList.add(new Drugs(0,"Panadol Extra","Panadol Extra Advance Tablets provides extra effective " +
                "pain relief from headaches, period pain and the aches & pains associated with colds & flu. Contains" +
                " Paracetamol and Caffeine.",
                R.drawable.panadolred,"40",30));
    }



    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
    public void logOutF(){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        boolean rememberMe = sharedPreferences.getBoolean("rememberMe",false);
        if (rememberMe == true){
            rememberMe=false;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("rememberMe",false);
            editor.commit();
        }
        Intent intent = new Intent(home.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}