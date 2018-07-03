package com.example.lenovo.avenge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Score.db";
    private static  final String TABLE_NAME = "Score_table";

    private static final  String COL_1 = "NAME";
    private static final  String COL_2 = "HERO";
    private static final  String COL_3 = "SCORE";




    DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE " + TABLE_NAME + " (NAME TEXT,HERO TEXT,SCORE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public  boolean insertData(String name, String hero, String score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,hero);
        contentValues.put(COL_3,score);
        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();

        return result != -1;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("Select * from " + TABLE_NAME,null);
    }


}
