package com.example.androidlabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_Lab2 extends Fragment {

    private int K = 1;

    private TextView ListsCount_TextView;
    private EditText ListsCount_EditText;
    private RadioButton A4_RadioButton;
    private RadioButton A3_RadioButton;
    private RadioButton A1_RadioButton;
    private Button Result_Button;
    private TextView Result_TextView;

    public Fragment_Lab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_lab2, container, false);

        ListsCount_TextView = (TextView) view.findViewById (R.id.ListsCount_TextView);
        ListsCount_EditText = (EditText) view.findViewById (R.id.ListsCount_EditText);
        A4_RadioButton = (RadioButton) view.findViewById (R.id.A4_RadioButton);
        A3_RadioButton = (RadioButton) view.findViewById (R.id.A4_RadioButton);
        A1_RadioButton = (RadioButton) view.findViewById (R.id.A4_RadioButton);
        Result_Button = (Button) view.findViewById (R.id.Result_Button);
        Result_TextView = (TextView) view.findViewById (R.id.Result_TextView);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.A4_RadioButton:
                        K = 10;
                        break;
                    case R.id.A3_RadioButton:
                        K = 30;
                        break;
                    case R.id.A1_RadioButton:
                        K = 100;
                        break;
                }
            }
        });

        Result_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String Num = ListsCount_EditText.getText().toString();

                    if (Num.length() > 0) {

                        int Sum = Integer.parseInt(Num) * K;

                        Result_TextView.setText("Результат: " + Sum + " руб.");

                    }

            }

        });

        return view;
    }

}
