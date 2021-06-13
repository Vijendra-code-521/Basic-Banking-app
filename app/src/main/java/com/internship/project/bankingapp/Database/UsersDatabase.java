package com.internship.project.bankingapp.Database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsersDatabase extends SQLiteOpenHelper {

    // defining user database schema
    public static final String DATABASE_NAME = "BankDataBase" ;
    public static final String TABLE_NAME = "User" ;
    public static final String Col1 = "AccountNo" ;
    public static final String Col2 = "Name" ;
    public static final String Col3 = "Balance" ;


    public UsersDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating table for user database
        db.execSQL("create table "+TABLE_NAME+" ( "+Col1+" PRIMARY KEY NOT NULL,"+Col2+" VARCHAR ,"+Col3+" INTEGER NOT NULL )");

        // inserting  data into database

        db.execSQL("insert into "+TABLE_NAME+" values (11111 , 'Vijenda Vishwakarma' , '50000')");
        db.execSQL("insert into "+TABLE_NAME+" values (22222 , 'Tanishq Saini' , '10000')");
        db.execSQL("insert into "+TABLE_NAME+" values (33333 , 'Tushar Dhakad' , '20000')");
        db.execSQL("insert into "+TABLE_NAME+" values (44444 , 'Tanmay Godse' , '50000')");
        db.execSQL("insert into "+TABLE_NAME+" values (55555 , 'Vaishali Mandloi' , '70000')");
        db.execSQL("insert into "+TABLE_NAME+" values (66666 , 'Swati patel' , '10000')");
        db.execSQL("insert into "+TABLE_NAME+" values (77777 , 'Tina Dubey' , '5000')");
        db.execSQL("insert into "+TABLE_NAME+" values (88888 , 'Rajkumar Rao' , '11500')");
        db.execSQL("insert into "+TABLE_NAME+" values (99999 , 'Swati Sharma' , '90000')");
        db.execSQL("insert into "+TABLE_NAME+" values (99992 , 'Vinod Kumar' , '50000')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
    // reading all users data
    public Cursor readAllUsersData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME , null);
        return cursor;
    }
    // reading only single user data
    public Cursor readAllUserDataExceptOne(int ACNO){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where "+Col1+" != "+ACNO  , null);
        return cursor;
    }
    public void updateAmount(int accountNo , int amount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update "+TABLE_NAME+" set "+Col3+" = "+ amount+ " where "+Col1+" = "+ accountNo);
    }


}
