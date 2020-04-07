package com.example.alertdialogdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this
                .getSharedPreferences("com.example.alertdialogdemo", Context.MODE_PRIVATE);

        String language = sharedPreferences.getString("language","");

        if (language == "") {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Choose a language")
                    .setMessage("Which language would you like?")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"It's done!",Toast.LENGTH_SHORT).show();
                            setLanguage("English");
                        }
                    })
                    .setNegativeButton("Português", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setLanguage("Português");
                        }
                    })
                    .show();
        } else {
            setLanguage(language);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.english)
            setLanguage("English");
        else if (item.getItemId() == R.id.port)
            setLanguage("Português");

        return super.onOptionsItemSelected(item);
    }

    public void setLanguage(String language) {
        sharedPreferences.edit().putString("language",language).apply();

        TextView languageText = findViewById(R.id.languageText);
        languageText.setText(language);
    }
}
