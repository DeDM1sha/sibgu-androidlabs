package com.example.androidlabs;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Lab1 extends Fragment {

    TextView Title;
    TextView Procent_TextView;
    TextView Tip_TextView_Title;
    TextView Tip_TextView;
    TextView Total_TextView_Title;
    TextView Total_TextView;

    EditText InputText;

    SeekBar Procent_seekBar;

    Button Result_Button;

    private int Procent_Number = 0;

    public Fragment_Lab1() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_lab1, container, false);

        Title = (TextView) view.findViewById (R.id.Title);
        InputText = (EditText) view.findViewById (R.id.et_amount);

        Procent_TextView = (TextView) view.findViewById (R.id.procent_TextView);
        Procent_TextView.setText("0%");

        Procent_seekBar  = (SeekBar) view.findViewById(R.id.procent_seekBar);
        Tip_TextView_Title = (TextView) view.findViewById (R.id.Tip_TextView_Title);
        Tip_TextView = (TextView) view.findViewById (R.id.Tip_TextView);
        Total_TextView_Title = (TextView) view.findViewById (R.id.total_TextView_Title);
        Total_TextView = (TextView) view.findViewById (R.id.total_TextView);
        Result_Button = (Button) view.findViewById (R.id.result_button);


        Result_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double billAmount = Double.parseDouble (InputText.getText().toString());
                double percent = new Double (Procent_Number);

                Calc tipCalc = new Calc(billAmount, percent);

                Tip_TextView.setText("" + tipCalc.calculateTip(tipCalc.getBillAmount(), tipCalc.getPercent()));
                Total_TextView.setText ("" + tipCalc.calculateTotal(tipCalc.getBillAmount(), tipCalc.getPercent()));
            }
        });

        Procent_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Procent_Number = progress;
                Procent_TextView.setText(String.valueOf(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }
}
