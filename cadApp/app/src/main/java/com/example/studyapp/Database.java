package com.example.studyapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "transiredb";
    private static final String SQL_CREATE_TABLES = "CREATE TABLE Users(login TEXT PRIMARY KEY, name TEXT, pass TEXT, type INT)";
    private static final String SQL_POPULATE_DATABASE =  "INSERT INTO Users VALUES ('caio', 'Caio', '123', 2)";
    private static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS Users";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLES);
        db.execSQL(SQL_POPULATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLES);
        onCreate(db);
    }
}
