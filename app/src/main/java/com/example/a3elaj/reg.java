package com.example.a3elaj;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reg extends AppCompatActivity {
    EditText name;
    EditText username;
    EditText email;
    EditText pass;
    Button register;
    UsersData users[]=new UsersData[20];
    int counter=0;
    boolean value=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        name =findViewById(R.id.name);
        username =findViewById(R.id.username);
        email =findViewById(R.id.email);
        pass =findViewById(R.id.password);
        register =findViewById(R.id.logIN);
        register.setOnClickListener(v -> checkDataEntered());
    }
    boolean isEmail(EditText text){
        CharSequence email =text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    boolean isEmpty(EditText text){
        CharSequence str =text.getText().toString();
        return TextUtils.isEmpty(str);
    }
     void checkDataEntered() {
        if(isEmpty(username)){
            Toast t =Toast.makeText(this,"you must Enter username to register!",Toast.LENGTH_SHORT);
            value=false;
            t.show();
        }
        if(isEmpty(name)){
            name.setError("name is required");
            value=false;
            }
        if(!isEmail(email)){
            email.setError("Enter Valid Email");
            value=false;
        }
        if(pass.getText().toString().length()<4){
            pass.setError("password must be at least 4 char !");
            value=false;
        }
        if(value) {
            users[counter] = new UsersData(toString(name), toString(email), toString(username), toString(pass));
            counter++;
        }
    }
    public String toString(EditText s){
        return s.getText().toString();

    }


}