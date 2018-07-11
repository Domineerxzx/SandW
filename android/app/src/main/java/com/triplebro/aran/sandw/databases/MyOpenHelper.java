package com.triplebro.aran.sandw.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.triplebro.aran.sandw.properties.AppProperties;

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context) {
        super(context, "SandW", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ AppProperties.LOVES_TABLE +"(_id Integer primary key autoincrement,commodityId varchar(20))");
        final ContentValues contentValues = new ContentValues();
        contentValues.put("commodityId","21");
        db.insert(AppProperties.LOVES_TABLE,null,contentValues);
        db.insert(AppProperties.LOVES_TABLE,null,contentValues);
        db.insert(AppProperties.LOVES_TABLE,null,contentValues);
        db.insert(AppProperties.LOVES_TABLE,null,contentValues);
        db.insert(AppProperties.LOVES_TABLE,null,contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
