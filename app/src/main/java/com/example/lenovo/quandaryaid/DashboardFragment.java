package com.example.lenovo.quandaryaid;


import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment{

    private final int PICK_IMAGE = 1;
    private final int PERMISSION_IMAGE = 1;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.nav_dash);

        View dashb= inflater.inflate(R.layout.fragment_dashboard, container, false);
        CardView cardView = dashb.findViewById(R.id.view2);
        cardView.setCardBackgroundColor(Color.TRANSPARENT);
        cardView.setCardElevation(0);
        SharedPreferences pref =this.getActivity().getSharedPreferences(Functions.PREF,MODE_PRIVATE);
        if (pref == null) return dashb;
        ((TextView)dashb.findViewById(R.id.name)).setText(pref.getString(Functions.NAME,"default"));
        ((TextView)dashb.findViewById(R.id.contact_no)).setText(pref.getString(Functions.CONTACT,"default"));
        ((TextView)dashb.findViewById(R.id.email_id)).setText(pref.getString(Functions.EMAIL,"default"));
        ((TextView)dashb.findViewById(R.id.emp_code)).setText(pref.getString(Functions.LOGINID,"default"));

        //if(json.equals(""))
          //  ((ImageView)dashb.findViewById(R.id.imageView1)).setImageDrawable(getResources().getDrawable(R.drawable.photo));
        //else
           // ((ImageView)dashb.findViewById(R.id.imageView1)).setImageBitmap(bitmap);

        dashb.findViewById(R.id.upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectImage();
                }
                else {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_IMAGE);
                }
            }
        });
       dashb.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor log = getActivity().getSharedPreferences(Functions.PREF, MODE_PRIVATE).edit();
                log.clear();
                log.apply();
                Intent lognew = new Intent(getActivity(), MainActivity.class);
                startActivity(lognew);
                getActivity().finish();
            }
        });


        return dashb;
    }


    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        Log.e("Dashboard","Loading Intent");
        startActivityForResult(Intent.createChooser(intent, "Pick Image"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);


    }
}
