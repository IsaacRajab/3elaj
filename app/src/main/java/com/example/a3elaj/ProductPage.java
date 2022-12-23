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

        pImg = findViewById(R.id.pImgSingl);
        pName = findViewById(R.id.pNameSingl);
        pDetails = findViewById(R.id.pDetailsSingl);
        pQuantity = findViewById(R.id.pQuantitySingle);
        addToCart = findViewById(R.id.addToCartSingle);
    }

    public ProductPage(ImageView pImg, TextView pNam, TextView price) {
        this.pImg = pImg;
        this.pName = pNam;

    }

    private void defin() {

        //pImg = findViewById(R.id.pImgSingl);
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