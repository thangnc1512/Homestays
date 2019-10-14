package com.tnt.homestays.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tnt.homestays.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etEmail;
    private EditText etPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {

    }


    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void initView() {
        etUser = (EditText) findViewById(R.id.etUser);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }
}
