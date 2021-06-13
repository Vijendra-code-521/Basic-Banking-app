package com.internship.project.bankingapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsersTransactionsDatabase extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME = "UserTransactions";
    public static  final String TABLE_NAME = "TransactionTable";
    public static  final String SENDER = "from_user";
    public static  final String AMOUNT = "amount";
    public static  final String RECEIVER = "to_user";


    public UsersTransactionsDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // sql query for creating database
        String SQL_FOR_TRANSACTION_DETAILS = "create table "+TABLE_NAME+" ( "+SENDER +" VARCHAR ,"+RECEIVER+" VARCHAR ,"+AMOUNT+" INTEGER NOT NULL )";
        db.execSQL(SQL_FOR_TRANSACTION_DETAILS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
    public Cursor readAllUsersData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME , null);
        return cursor;
    }
    public boolean insertTransferData (String sender, String receiver, int amount ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SENDER , sender) ;
        contentValues.put(RECEIVER , receiver) ;
        contentValues.put(AMOUNT , amount) ;
        long  result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
