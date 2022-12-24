package com.example.a3elaj;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText email;
    EditText password;
    Button logIn;
    CheckBox rememberMe;
    public static boolean bRememberMe = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupIU();
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