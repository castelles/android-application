package com.caiotelles.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view) {
        ImageView bugImage = findViewById(R.id.imageView);
        bugImage.setImageResource(R.drawable.logobughackers);
//        EditText myEditText = findViewById(R.id.myEditText);
//        EditText userField = findViewById(R.id.userField);
//        EditText passField = findViewById(R.id.passField);
//
//        Toast.makeText(this,"Hi there!",Toast.LENGTH_SHORT).show();
//
//        Log.i("Clicked Info","Your username is " + userField.getText().toString() + "!" +
//                " And your password is " + passField.getText().toString());


    }
}
