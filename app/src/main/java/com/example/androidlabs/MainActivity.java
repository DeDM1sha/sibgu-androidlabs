package com.example.androidlabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


class Calc {

    private double billAmount;
    private double percent;
    private double tip;
    private double total;

    Calc (double Amount, double per) {

        billAmount = Amount;
        percent = per;
        tip = 0.0;
        total = 0.0;

    }

    public double calculateTip(double billAmount, double percent) {

        return billAmount*percent/100;

    }

    public double calculateTotal(double billAmount, double percent) {

        return billAmount+(billAmount*percent/100);

    }

    public double getBillAmount() {

        return billAmount;

    }

    public void setBillAmount(double billAmount) {

        this.billAmount = billAmount;

    }

    public double getPercent() {

        return percent;

    }

    public void setPercent(double percent) {

        this.percent = percent;

    }

    public double getTip() {

        return tip;

    }

    public void setTip(double tip) {

        this.tip = tip;

    }

    public double getTotal() {

        return total;

    }

    public void setTotal(double total) {

        this.total = total;

    }

};

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment_Lab1 Fragment_Lab1;

    TextView Title;
    EditText InputText;
    TextView Procent_TextView;
    SeekBar Procent_seekBar;
    TextView Tip_TextView_Title;
    TextView Tip_TextView;
    TextView Total_TextView_Title;
    TextView Total_TextView;

    int Procent_Number = 0;

    Button Result_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment_Lab1 = new Fragment_Lab1();

        Title = (TextView) findViewById (R.id.Title);

        InputText = (EditText) findViewById (R.id.et_amount);

        Procent_TextView = (TextView) findViewById (R.id.procent_TextView);
        Procent_TextView.setText("0%");

        Procent_seekBar  = (SeekBar) findViewById(R.id.procent_seekBar);

        Tip_TextView_Title = (TextView) findViewById (R.id.Tip_TextView_Title);

        Tip_TextView = (TextView) findViewById (R.id.Tip_TextView);

        Total_TextView_Title = (TextView) findViewById (R.id.total_TextView_Title);

        Total_TextView = (TextView) findViewById (R.id.total_TextView);

        Result_Button = (Button) findViewById (R.id.result_button);

        Result_Button.setOnClickListener (this);

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

    }

    @Override
    public void onClick (View v) {

        Double billAmount = Double.parseDouble (InputText.getText().toString());
        double percent = new Double (Procent_Number);

        Calc tipCalc = new Calc(billAmount, percent);

        Tip_TextView.setText("" + tipCalc.calculateTip(tipCalc.getBillAmount(), tipCalc.getPercent()));
        Total_TextView.setText ("" + tipCalc.calculateTotal(tipCalc.getBillAmount(), tipCalc.getPercent()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {

            case R.id.action_launch_lab_1:
                ft.replace(R.id.content, Fragment_Lab1);
                ft.commit();
                break;

            case R.id.action_launch_lab_2:
                break;

            case R.id.action_launch_lab_3:
                break;

            case R.id.action_exit:
                finish ();

        }

        return super.onOptionsItemSelected(item);
    }
}
