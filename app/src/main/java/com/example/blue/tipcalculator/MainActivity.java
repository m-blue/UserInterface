package com.example.blue.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    double cost = 0;
    Object percentageChoice;
    double[] percentages = {.05, .10, .15, .20, .25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txt_cost = findViewById(R.id.txt_cost);
        final Spinner spinner_percentage = findViewById(R.id.spinner_percentage);
        Button btn_calculate = findViewById(R.id.btn_calculate);


        spinner_percentage.setOnItemSelectedListener(this);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt_result = findViewById(R.id.txt_result);
                String costString = txt_cost.getText().toString();
                try{
                    cost = Double.parseDouble(costString);
                }catch (NumberFormatException d){
                    cost = 0;
                }

                double tip = Double.parseDouble(percentageChoice.toString());
                double result = cost * tip;
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                String percentage = spinner_percentage.getSelectedItem().toString();
                txt_result.setText("A " + percentage + " tip of " + costString + ": " + currency.format(result) );

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        percentageChoice = percentages[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
