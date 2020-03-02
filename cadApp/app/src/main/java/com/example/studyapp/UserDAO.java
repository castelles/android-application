package com.example.studyapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserDAO
{
    private SQLiteDatabase itbamDB;

    public UserDAO(Context context) {
        this.itbamDB = (new Database(context)).getWritableDatabase();
    }

    public User getUser(String login, String pass) {
        User user = null;

        String sqlQuery = "SELECT * FROM Users WHERE login='" + login +
                "' AND pass='" + pass + "'";

        Cursor cursor = this.itbamDB.rawQuery(sqlQuery,null);

        if (cursor.moveToNext()) {
            user = new User(cursor.getString(0), cursor.getString(1),
                    cursor.getString(2), cursor.getInt(3));
        }

        cursor.close();
        return user;
    }

    public boolean addUSer(User userToAcess) {
        try {
            String sqlCmd = "INSERT INTO Users VALUES ('" + userToAcess.getLogin() +
                    "', '" + userToAcess.getName() + "', '" + userToAcess.getPass() +
                    "', " + userToAcess.getType() + ")";
            this.itbamDB.execSQL(sqlCmd);
            return true;
        }
        catch(SQLException e) {
            Log.e("UserDAO ERROR", e.getMessage());
            return false;
        }
    }

    public Cursor getUsers() {
        return this.itbamDB.rawQuery("SELECT rowid AS _id, login,name, CASE WHEN " +
                "type=1 THEN 'Aluno' ELSE 'Professor' END AS type FROM Users ORDER " +
                "BY login", null);
    }
}
