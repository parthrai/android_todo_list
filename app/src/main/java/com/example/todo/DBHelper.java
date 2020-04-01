package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName = "todo.db";
    public static final String TBLName = "tasks";
    public static final String COL0 = "ID";
    public static final String COL1 = "Task";

    public DBHelper(Context context){
        super(context,DBName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+ TBLName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Task TEXT)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS "+ TBLName ;

        db.execSQL(query);
    }

    public boolean addData(String task){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL1,task);

        long result =   db.insert(TBLName,null,cv);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){

        SQLiteDatabase db = this.getWritableDatabase();


        String query = "SELECT * from " +TBLName;

        Cursor data = db.rawQuery(query,null);

        return data;

    }
}
