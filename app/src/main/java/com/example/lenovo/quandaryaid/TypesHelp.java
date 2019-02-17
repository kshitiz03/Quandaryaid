package com.example.lenovo.quandaryaid;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
public class TypesHelp extends AppCompatActivity{
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    double lat,lon;
    int c=0;
    String phoneNo, message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_types_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Type of Help");
        Context context = this;
        GPSTracker mGPS = new GPSTracker(this);
        if(mGPS.canGetLocation ){
            mGPS.getLocation();
//            lat=mGPS.getLatitude();
//            lon=mGPS.getLongitude();
            lat=28.9730;
            lon=77.6410;
        }else{

            System.out.println("Unable");
        }

        findViewById(R.id.nonemergency).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNo = "9557987775";
                message = "https://www.google.com/maps/search/?api=1&query=28.9730,77.6410";
                sendSMSMessage();
//
            }
        });


        findViewById(R.id.emergency).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNo = "9557987775";
                message = "I am in an accident. Please help me!! \n This is my Location https://www.google.com/maps/search/?api=1&query=28.9730,77.6410";
                sendSMSMessage();
//                GPStracker g = new GPStracker(getApplicationContext());
//                Location l = g.getLocation();

            }
        });

        findViewById(R.id.women).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNo = "9557987775";
                message = "I am in an unsafe situation. Please help me!! \n WOMAN ALERT!! \n This is my Location https://www.google.com/maps/search/?api=1&query=28.9730,77.6410";
                sendSMSMessage();
//
            }
        });

    }
    protected void sendSMSMessage() {
        if(c==1){SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    c=1;
                    SmsManager smsManager = SmsManager.getDefault();
                    StringBuffer smsBody = new StringBuffer();
                    smsBody.append(Uri.parse(message));
                    android.telephony.SmsManager.getDefault().sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent."+lat+lon,
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }

}
