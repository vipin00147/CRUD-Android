package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dbdemo.dbhandler.dbhandler;
import com.example.dbdemo.student.student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhandler obj = new dbhandler(MainActivity.this);

        student s1 = new student();
        s1.setName("Vipin");
        s1.setCourse("BCA");
        obj.addData(s1);

        obj.updateData("Abhishek","B.tech", 2);
        obj.deleteData(3);
        Cursor cursor = obj.getData();
        cursor.moveToFirst();
        do{
            Toast.makeText(this, "Id : "+cursor.getString(0), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Name : "+cursor.getString(1), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Course : "+cursor.getString(2), Toast.LENGTH_SHORT).show();
        } while(cursor.moveToNext());
    }
}