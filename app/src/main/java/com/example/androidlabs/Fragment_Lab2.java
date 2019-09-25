package com.example.androidlabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_Lab2 extends Fragment {

//    TextView textView;


    public Fragment_Lab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_lab2, container, false);
        // Inflate the layout for this fragment
//        textView = (TextView) view.findViewById(R.id.textView);

        return view;
    }


    public void onClick(View v) {



    }
}
