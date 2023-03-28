package com.example.ucvme;
//import statements
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    //Constant declarations of tables to save retyping
    public static final String UserTable = "UserTable";
    public static final String UserIDCol = "UserID";
    public static final String NameCol = "Name";
    public static final String SurnameCol = "Surname";
    public static final String DobCol = "DOB";
    public static final String BioCol = "Bio";
    public static final String LocationCol = "Location";
    public static final String CountyCol = "County";
    public static final String StatusCol = "Status";
    public static final String PictureCol = "PictureLink";
    public static final String VideoCol = "VideoLink";
    public static final String PasswordCol = "Password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    //Called the first time we try access a database object
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table when app if first launched
        String createTableStatement = "CREATE TABLE " + UserTable + " (" + UserIDCol + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NameCol + " Text," +
                SurnameCol + " Text," +
                DobCol + " Text," +
                BioCol + " Text," +
                LocationCol + " Text," +
                CountyCol + " Text," +
                StatusCol + " Text," +
                PictureCol + " Text," +
                VideoCol + " Text," +
                PasswordCol + " Text)";

        //execute SQL
        db.execSQL(createTableStatement);
    }

    //Called if the database version number changes, prevents previous versions from breaking if something is changed
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    //SQL Goes Here
}//end class
