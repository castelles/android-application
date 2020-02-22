package com.example.studyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.sobre:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("Login Transire").setNeutralButton("Tabom amor",null).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void entrarClicado(View view) {
        Toast.makeText(this, "Olá!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,WelcomeActivity.class);
        startActivity(intent);
    }
}
