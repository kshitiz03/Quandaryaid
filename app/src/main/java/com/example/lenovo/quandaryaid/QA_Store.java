package com.example.lenovo.quandaryaid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QA_Store extends Fragment {


    public QA_Store() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("QA Store");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qa__store, container, false);
    }

}
