package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jsonapp.Service.DownloadTask;

public class MainActivity extends AppCompatActivity {

    private Button bttWeather;
    private EditText cityName;
    public TextView weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();

//        DownloadTask task = new DownloadTask();
//        task.execute("https://samples.openweathermap.org/data/2.5/weather?q="+ cityName.getText().toString() +"&appid=b6907d289e10d714a6e88b30761fae22");

    }

    public void setComponents() {
        bttWeather = findViewById(R.id.bttWeather);
        cityName = findViewById(R.id.cityName);
        weatherInfo = findViewById(R.id.weatherInfo);
    }


    public void whatsTheWeather(View view) {
        DownloadTask task = new DownloadTask();
        task.execute("https://samples.openweathermap.org/data/2.5/weather?q="+ cityName.getText().toString() + "&appid=b6907d289e10d714a6e88b30761fae22");
    }



}
