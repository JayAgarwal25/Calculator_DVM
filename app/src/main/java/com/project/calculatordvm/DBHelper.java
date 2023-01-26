package com.project.calculatordvm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Calchistory.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Calcdetails(resultsTV TEXT primary key, workingsTV TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Calcdetails");
        onCreate(DB);

    }
    public void insertcalchistory(String resultsTV,String workingsTV)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("resultsTV",resultsTV);
        contentValues.put("workingsTV",workingsTV);
        DB.insert("Calcdetails",null, contentValues);

    }
    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Calcdetails",null);
        return cursor;
    }

    public void deletecalchistory()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Calcdetails", null);
        if (cursor.getCount()>0)
        {
            DB.delete("Calcdetails",null,null);
        }
    }
}

