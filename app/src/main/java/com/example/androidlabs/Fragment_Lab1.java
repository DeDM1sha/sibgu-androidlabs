package com.example.androidlabs;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Lab1 extends Fragment {

    TextView textView;


    public Fragment_Lab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_lab1, container, false);
        // Inflate the layout for this fragment
        textView = (TextView) view.findViewById(R.id.textView);

        return view;
    }


    public void onClick(View v) {



    }

}
