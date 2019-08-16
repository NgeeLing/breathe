package com.example.assignment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RelaxFragment extends Fragment {

    Button button_nav_breathe;

    public RelaxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relax, container, false);
        button_nav_breathe = view.findViewById(R.id.button_nav_breathe);
        button_nav_breathe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Breathe.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
