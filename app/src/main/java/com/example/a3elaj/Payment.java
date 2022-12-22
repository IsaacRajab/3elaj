package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        RadioButton card = findViewById(R.id.card);
        RadioButton receive = findViewById(R.id.receive);
        show(card, receive);
    }

    private void show(View view, View view1){
        EditText holderName = findViewById(R.id.holderName);
        EditText cardNumber = findViewById(R.id.cardNumber);
        EditText month = findViewById(R.id.month);
        EditText year = findViewById(R.id.year);
        EditText cvv = findViewById(R.id.cvv);
        boolean checked = ((RadioButton)view).isChecked();
        if(checked) {
            holderName.setVisibility(View.VISIBLE);
            cardNumber.setVisibility(View.VISIBLE);
            month.setVisibility(View.VISIBLE);
            year.setVisibility(View.VISIBLE);
            cvv.setVisibility(View.VISIBLE);
        }
        boolean checked1 = ((RadioButton)view1).isChecked();
        if(checked1) {
            holderName.setVisibility(View.GONE);
            cardNumber.setVisibility(View.GONE);
            month.setVisibility(View.GONE);
            year.setVisibility(View.GONE);
            cvv.setVisibility(View.GONE);
        }
    }
}