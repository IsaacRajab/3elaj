package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductPage extends AppCompatActivity {
    private ImageView pImg;
    private TextView pName;
    private TextView pDetails;
    private TextView pQuantity;
    private Button addToCart;
    private Button buyNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        defin();
    }

    private void defin() {
        pImg = findViewById(R.id.pImgSingl);
        pName = findViewById(R.id.pNameSingl);
        pDetails = findViewById(R.id.pDetailsSingl);
        pQuantity = findViewById(R.id.pQuantitySingle);
        addToCart = findViewById(R.id.addToCartSingle);
        //pImg = findViewById(R.id.pImgSingl);
    }
}