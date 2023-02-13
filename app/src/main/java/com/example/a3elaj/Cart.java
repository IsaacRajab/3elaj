package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private RequestQueue mQueue;
    private RecyclerView recyclerView;
    CartAdapter adapter;
    ArrayList<Drugs> drugsListCart;

    private DrugsAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.cartRecycler);

        drugsListCart = new ArrayList<>();

        adapter = new CartAdapter(this,ProductPage.drugsListCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        mQueue = Volley.newRequestQueue(this);
       // parseJSON();
    }

//    private void parseJSON() {
//        String url = "your_product_data_API_url";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("products");
//
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject product = jsonArray.getJSONObject(i);
//
//                                String productName = product.getString("product_name");
//                                String productDescription = product.getString("product_description");
//                                String productImage = product.getString("product_image");
//
//                                mProductList.add(new Product(productName, productDescription, productImage));
//                            }
//
//                            mProductAdapter = new ProductAdapter(ProductDataActivity.this, mProductList);
//                            mRecyclerView.setAdapter(mProductAdapter);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        mQueue.add(request);
//    }









}