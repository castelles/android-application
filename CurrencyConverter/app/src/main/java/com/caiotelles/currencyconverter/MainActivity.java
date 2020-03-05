package com.caiotelles.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view) {
        EditText currencyField = findViewById(R.id.currencyField);
        Double currencyToConvert = Double.parseDouble(currencyField.getText().toString());

        Double dollars = currencyToConvert * 4.48;

        Toast.makeText(this,"R$ " + String.format("%.2f",dollars),Toast.LENGTH_LONG).show();
    }
}
