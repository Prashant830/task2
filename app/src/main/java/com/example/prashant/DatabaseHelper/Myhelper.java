package com.example.prashant.DatabaseHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.prashant.DatabaseHelper.UserContract.UserEntry;


public class Myhelper extends SQLiteOpenHelper {
    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public Myhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Prashant Singh', 'ps@gmail.com','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1240,'celina Baz', 'celina@gmail.com','7892345238', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3250,'user1', 'user1@gmail.com','8795641238', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4356,'user2', 'user2@gmail.com','9995641238', 4000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3454,'user3', 'user3@gmail.com','9865641238', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7658,'user4', 'user4@gmail.com','7795641238', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9878,'user5', 'user5@gmail.com','7595641238', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3845,'user6', 'user6@gmail.com','7495641238', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1276,'user7', 'user7@gmail.com','7895646538', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3454,'user8', 'user8@gmail.com','9345641238', 11000)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
