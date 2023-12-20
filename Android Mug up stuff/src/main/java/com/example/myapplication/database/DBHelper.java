package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "details.db";
    private static int VERSION = 1;



    String query = "CREATE TABLE user (name varchar(20) , age integer" +
            " , mnumber integer , gender varchar(20))";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
    }
    public long insert(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" , user.getName());
        cv.put("age" , user.getAge());
        cv.put("mnumber" , user.getmNumber());
        cv.put("gender" , user.getGender());

        long r = db.insert("user" , null , cv);

        return r;

    }

    public List<User> read(){
        List<User> userList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from user",null);

        while(c.moveToNext()){
            User user = new User();
            user.setName(c.getString(0));
            user.setAge(c.getInt(1));
            user.setmNumber(c.getInt(2));
            user.setGender(c.getString(3));
            userList.add(user);
        }

        return userList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
