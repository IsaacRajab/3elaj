package com.example.a3elaj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Spinner spinner= findViewById(R.id.feedback);
        TextView textView =findViewById(R.id.msg);
        String text = spinner.getSelectedItem().toString();
        Button btn=findViewById(R.id.send);
        btn.setOnClickListener(v -> {
            Intent i =new Intent(Intent.ACTION_SEND);
            i.setType("message/html");
            i.putExtra(Intent.EXTRA_EMAIL, "test@test.com");
            i.putExtra(Intent.EXTRA_SUBJECT,"Feedback From app");
            i.putExtra(Intent.EXTRA_TEXT,"Feedback type:"+text+"\n Message :"+textView.getText());
            try {
                startActivity(Intent.createChooser(i,"Please Select Email"));
            }catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(ContactUS.this,"There are no Email Clients",Toast.LENGTH_SHORT).show();
            }
        });


    }
}