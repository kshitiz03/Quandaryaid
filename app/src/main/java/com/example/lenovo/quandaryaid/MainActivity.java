    package com.example.lenovo.quandaryaid;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            SharedPreferences pref = getSharedPreferences(com.example.lenovo.quandaryaid.Functions.PREF,MODE_PRIVATE);
            if(pref.contains(com.example.lenovo.quandaryaid.Functions.LOGINID)) {
                Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);

                finish();
            }

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            //startActivity(new Intent(MainActivity.this, WelcomeActivity.class));

            findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    startActivity(new Intent(MainActivity.this, com.example.lenovo.quandaryaid.SignupActivity.class));
                    finish();
                }
            });

            findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = ((EditText)findViewById(R.id.username)).getText().toString();
                    if(name.equals("")) {
                        Functions.showToast(MainActivity.this,R.string.empty_fields);}
                        else if(name.equals("int1")) {
                        startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                        finish();
                    }
                    else{
                        Functions.showToast(MainActivity.this,R.string.incorrect_fields);}


                }
            });
        }
}
