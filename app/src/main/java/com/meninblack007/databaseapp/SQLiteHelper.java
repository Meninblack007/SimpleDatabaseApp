package com.meninblack007.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by men_in_black007 on 15/11/16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDatabase";
    private static final String TABLE_STUDENT_DETAIL = "studentDetails";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL_ID = "emailId";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_STUDENT_DETAIL + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT, " + EMAIL_ID + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_DETAIL);
        onCreate(db);
    }

    public void addNewStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, student.getName());
        values.put(EMAIL_ID, student.getEmailId());
        db.insert(TABLE_STUDENT_DETAIL, null, values);
        db.close();
    }
}