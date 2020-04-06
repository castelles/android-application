package com.example.sharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);

//        sharedPreferences.edit().putString("username","caio").apply();
//        String username = sharedPreferences.getString("username","");
//        Log.i("username",username);

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Monica");
        friends.add("Chandler");
        friends.add("Joe");

        try {
            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<>();

        try {
            newFriends = (ArrayList<String>) ObjectSerializer
                    .deserialize(sharedPreferences
                    .getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("newfriends",newFriends.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                Log.i("Menu item selected", "Settings");
                break;
            case R.id.help:
                Log.i("Menu item selected", "Help");
                break;
            default:
                return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
