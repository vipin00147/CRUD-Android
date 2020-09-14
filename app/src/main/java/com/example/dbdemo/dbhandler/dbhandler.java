package com.example.dbdemo.dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.dbdemo.data.data;
import com.example.dbdemo.student.student;

public class dbhandler extends SQLiteOpenHelper {
    public dbhandler(Context context){
        super(context, data.DB_NAME,null, data.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table "+data.TABLE_NAME+"("+data.ID+" integer primary key  ,"+
                                        data.NAME+" Text, "+data.COURSE+" Text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    //Insertion.....
    public void addData(student s1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(data.NAME, s1.getName());
        contentValues.put(data.COURSE, s1.getCourse());
        db.insert(data.TABLE_NAME, null, contentValues);
    }

    //Read Data....
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+data.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return  cursor;
    }

    //Update Data....
    public void updateData(String name,String course, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(data.ID,id);
        contentValues.put(data.NAME,name);
        contentValues.put(data.COURSE,course);
        db.update(data.TABLE_NAME,contentValues,data.ID+"=?",new String[]{String.valueOf(id)});
    }

    //Delete data....
    public void deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(data.TABLE_NAME,data.ID+"=?",new String[]{String.valueOf(id)});
    }
}
