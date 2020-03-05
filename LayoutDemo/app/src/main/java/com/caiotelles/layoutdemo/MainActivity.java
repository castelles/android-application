package com.caiotelles.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {

    int animationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ImageView simpsons = findViewById(R.id.simpsonsImage);
        simpsons.setTranslationX(-1000f);
        */
    }

    public void fadeImage(View view) {

        ImageView simpsons = findViewById(R.id.simpsonsImage);
//        ImageView bart = findViewById(R.id.bart);

        switch (animationId) {
            case 0:
                simpsons.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
                animationId++;
                break;
            case 1:
                simpsons.animate().translationXBy(-100f).setDuration(1000);
                animationId++;
                break;
            case 2:
                simpsons.animate().translationXBy(200f).setDuration(1000);
                animationId++;
                break;
            case 3:
                simpsons.animate().translationXBy(-100f).setDuration(1000);
                animationId++;
                break;
            default:
                simpsons.setScaleX(1f);
                simpsons.setScaleY(1f);
                Toast.makeText(this, "Animations is done!", Toast.LENGTH_LONG).show();
                animationId = 0;
                break;
        }

//        simpsons.animate().rotation(1800f).setDuration(2000);

//        simpsons.animate().translationXBy(1000f).setDuration(2000);
//        simpsons.setImageResource(R.drawable.homer);
        
//        if (simpsons.getAlpha() == 1f) {
//            simpsons.animate().alpha(0f).setDuration(2000);
//            bart.animate().alpha(1f).setDuration(4000);
//        } else {
//            bart.animate().alpha(0f).setDuration(2000);
//            simpsons.animate().alpha(1f).setDuration(4000);
//        }
    }
}
