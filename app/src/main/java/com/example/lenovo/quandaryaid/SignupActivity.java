package com.example.lenovo.quandaryaid;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SignupActivity extends AppCompatActivity {

    private boolean email = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.signup_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.user_id)).getText().toString();
                if(name.equals("")) {
                    Functions.showToast(SignupActivity.this,R.string.empty_fields);
                return;}
                startActivity(new Intent(SignupActivity.this, com.example.lenovo.quandaryaid.DashboardActivity.class));
                finish();

            }
        });

        findViewById(R.id.signup_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.user_id)).getText().toString();
                if(name.equals("")) {
                    Functions.showToast(SignupActivity.this,R.string.empty_fields);
                return;}
                startActivity(new Intent(SignupActivity.this, com.example.lenovo.quandaryaid.DashboardActivity.class));
                finish();

            }
        });
    }


}
