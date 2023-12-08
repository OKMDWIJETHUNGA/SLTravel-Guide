package com.example.sltravelguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
// create table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = " create table users(username text, password text ,email text) ";
        sqLiteDatabase.execSQL(qry1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    //method for signup
    public void signup(String username, String password, String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, contentValues);
    }
    //method for login
    public int login(String username, String password){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?",str);
        if (cursor.moveToFirst()){
            result = 1;
        }
        return result;
    }
    //method for conform
    public boolean conform(String username, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.update("users",contentValues,"username = ?",new String[] {username});
        return true;
    }
}
