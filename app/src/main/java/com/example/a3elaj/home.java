package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.Products);
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.truffen,"20$"));
//        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.ic_gfglogo));
//        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.ic_gfglogo));
//        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.ic_gfglogo));
//        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.ic_gfglogo));

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,this);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}