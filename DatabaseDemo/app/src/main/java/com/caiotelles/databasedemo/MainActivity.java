package com.caiotelles.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase myDB = this.openOrCreateDatabase("Users",MODE_PRIVATE, null);

            myDB.execSQL("DROP TABLE IF EXISTS users");

            myDB.execSQL("CREATE TABLE IF NOT EXISTS users (id_ INTEGER NOT NULL PRIMARY KEY, " +
                    "name VARCHAR(45), age INT UNSIGNED)");

            myDB.execSQL("INSERT INTO users(name, age) VALUES ('Caio', 23)");
            myDB.execSQL("INSERT INTO users (name, age) VALUES ('Leticia', 20)");
            myDB.execSQL("INSERT INTO users (name, age) VALUES ('Samara', 20)");
            myDB.execSQL("INSERT INTO users (name, age) VALUES ('Francys', 49)");

            Cursor c = myDB.rawQuery("SELECT * FROM users WHERE age > 22", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id_");

//            c.moveToFirst();

            if (c.moveToFirst()) {
                do {
                    Log.i("name", c.getString(nameIndex));
                    Log.i("age",Integer.toString(c.getInt(ageIndex)));
                    Log.i("id", Integer.toString(c.getInt(idIndex)));
                } while (c.moveToNext());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
