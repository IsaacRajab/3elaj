package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductPage extends AppCompatActivity {
    DrugsAdapter drugsAdapter;

    private ImageView pImg;
    private TextView pName;
    private TextView pPrice;
    private TextView pDetails;
    private TextView pQuantity;
    private Button addToCart;
    private Button buyNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        pImg = findViewById(R.id.pImgSingl);
        pName = findViewById(R.id.pNameSingl);
        pDetails = findViewById(R.id.pDetailsSingl);
        pQuantity = findViewById(R.id.quantity);
        addToCart = findViewById(R.id.addToCartSingle);
        pPrice = findViewById(R.id.pPriceSingl);

        String productName = "there is no Name ";
        int productImage = 0;
        String productPrice = "0";
        String productDisc = " ";
        int productQuantity = 0;

        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            productName = extras.getString("productName");
            productImage = getIntent().getIntExtra("productImg",0);
            productPrice = extras.getString("productPrice");
            productDisc = extras.getString("productDisc");
            productQuantity = extras.getInt("productQuantity");

        }



        pName.setText(productName);
        pImg.setImageResource(productImage);
        pPrice.setText(productPrice);
        pDetails.setText(productDisc);
        pQuantity.setText(String.valueOf(productQuantity));

    }






    public ImageView getpImg() {
        return pImg;
    }

    public void setpImg(ImageView pImg) {
        this.pImg = pImg;
    }

    public TextView getpName() {
        return pName;
    }

    public void setpName(TextView pName) {
        this.pName = pName;
    }

    public TextView getpDetails() {
        return pDetails;
    }

    public void setpDetails(TextView pDetails) {
        this.pDetails = pDetails;
    }

    public TextView getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(TextView pQuantity) {
        this.pQuantity = pQuantity;
    }

    public Button getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(Button addToCart) {
        this.addToCart = addToCart;
    }

    public Button getBuyNow() {
        return buyNow;
    }

    public void setBuyNow(Button buyNow) {
        this.buyNow = buyNow;
    }
}