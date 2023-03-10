package com.example.a3elaj;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    EditText email;
    EditText password;
    Button logIn;
    CheckBox rememberMe;
    private RequestQueue queue;
    public static boolean bRememberMe = false;
    ArrayList<String> todos = new ArrayList<>();
    ArrayList<UserData> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupIU();
        queue = Volley.newRequestQueue(this);
        logIn.setOnClickListener(v -> checkUsername());

    }




    private void setupIU(){
        email = findViewById(R.id.username);
        password =findViewById(R.id.password);
        logIn=findViewById(R.id.logIN);
        rememberMe = findViewById(R.id.rememberMe);
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkUsername() {
         String inputEmail =email.getText().toString();
        String inputPass =password.getText().toString();

        boolean isValid = true;
        if (isEmpty(email)) {
            email.setError("You must enter username to login!");
            isValid = false;
        } else {
            if (!isEmail(email)) {
                email.setError("Enter valid email!");
                isValid = false;
            }
        }

        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        }



        if (isValid) {
            SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
            String storedEmail = sharedPreferences.getString(inputEmail, "");
            String storedPass = sharedPreferences.getString(inputEmail+"_pass", "");

            if (inputEmail.equals(storedEmail) && inputPass.equals(storedPass)) {
                //everything checked we open new activity
                if (rememberMe.isChecked()){
                    bRememberMe = true;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("rememberMe",true);
                    editor.apply();
                }
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(login.this, SplashActivity.class);
                startActivity(i);
                finish();
            } else {
                Toast t = Toast.makeText(this, "Wrong email or password!", Toast.LENGTH_SHORT);
                t.show();
            }
        }



    }

}