package com.example.a.t12_sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by a on 2017-10-25.
 */

public class TestSQLiteHandler {
    TestSQLiteOpenHelper helper;

    public TestSQLiteHandler(Context context){
        helper = new TestSQLiteOpenHelper(context, "people", null, 1);
    }

    public void insert(String name, int age, String address){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age",age);
        values.put("address", address);
        db.insert("student", null,values);
    }

    public void delete(String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[] {name});
    }

    public  void update(String name, int newAge){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", newAge);
        db.update("student", values, "name=?", new String[] {name});
    }

    //kim, 11,seoul  part, 12, incheon
    public  String  selectAll(){
        String res = "";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("student",null, null, null, null,null,null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String address = c.getString((c.getColumnIndex("address")));

            res +="id:"+id+" name:"+name+" age:"+age+" address: "+address;
            res +="Wn";
        }

        return res;
    }

}
