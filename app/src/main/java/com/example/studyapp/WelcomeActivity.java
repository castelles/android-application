package com.example.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();

        User user = (User) intent.getSerializableExtra("user");

        TextView textWelcome = (TextView) findViewById(R.id.welcomePage);

        textWelcome.setText(Html.fromHtml(
                "Olá <b>" + user.getLogin() + "</b>! Sua senha é <b>" + user.getPass() + "</b> e você é <i>"
                + user.getType() + "</i>.<br><br>Bem vindo!"
        ));
    }
}
