package com.example.lenovo.quandaryaid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OurSponsers extends Fragment {


    public OurSponsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Our Sponsers");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_our_sponsers, container, false);
    }

}
