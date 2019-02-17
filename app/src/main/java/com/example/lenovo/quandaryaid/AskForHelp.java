package com.example.lenovo.quandaryaid;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AskForHelp extends Fragment {


    public AskForHelp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Ask For Help");
        View some=inflater.inflate(R.layout.fragment_ask_for_help, container, false);
        // Inflate the layout for this fragment
        FloatingActionButton fab = (FloatingActionButton) some.findViewById(R.id.help);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TypesHelp.class));
            }
});
        return some;
    }

}
