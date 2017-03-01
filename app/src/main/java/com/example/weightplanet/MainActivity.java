package com.example.weightplanet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView pText;
    Spinner pSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        pText = (TextView) findViewById(R.id.pText);
        pSpinner = (Spinner) findViewById(R.id.pSpinner);
        pSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String planetSelected="";
                planetSelected = parent.getItemAtPosition(position).toString();
                calculate(planetSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void calculate(String planetSelected) {
        if("".equalsIgnoreCase(editText.getText().toString())){
            pText.setText("Enter Weight");
        }
        else{


            double ogweight = Double.parseDouble(editText.getText().toString());
            double ogmass = ogweight / 9.81;
            double newweight = 0;
            switch (planetSelected){
                case "Mercury": newweight = ogmass * 3.7;
                    break;
                case "Venus": newweight = ogmass * 8.87;
                    break;
                case "Earth": newweight = ogmass * 9.81;
                    break;
                case "Mars": newweight = ogmass * 3.71;
                    break;
                case "Jupiter": newweight = ogmass * 24.92;
                    break;
                case "Saturn": newweight = ogmass * 10.44;
                    break;
                case "Uranus": newweight = ogmass * 8.87;
                    break;
                case "Neptune": newweight = ogmass * 11.15;
                    break;
            }
            String temp = String.format("%.2f",newweight);
            pText.setText("Your weight on " + planetSelected + " is " + temp + " kg");
        }
    }

}

