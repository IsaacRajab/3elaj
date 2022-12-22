package com.example.a3elaj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button logIn;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupIU();
        sharedPreferences = getSharedPreferences("userSRF",MODE_PRIVATE);
        logIn.setOnClickListener(v -> checkUsername());
    }
    private void setupIU(){
        username = findViewById(R.id.username);
        password =findViewById(R.id.password);
        logIn=findViewById(R.id.logIN);
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
        boolean isValid = true;
        if (isEmpty(username)) {
            username.setError("You must enter username to login!");
            isValid = false;
        } else {
            if (!isEmail(username)) {
                username.setError("Enter valid email!");
                isValid = false;
            }
        }

        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        }

        if (isValid) {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            SharedPreferences.Editor myedit = sharedPreferences.edit();
            myedit.putString("username",usernameValue);
            myedit.putString("password",passwordValue);
            myedit.commit();

            if (usernameValue.equals("project@project.com") && passwordValue.equals("12345")) {
                //everything checked we open new activity

                Intent i = new Intent(login.this, home.class);
                startActivity(i);

            } else {
                Toast t = Toast.makeText(this, "Wrong email or password!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
}