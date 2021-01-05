package com.example.android.dbsample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

public class DBManager {
    private SQLiteDatabase sqlDatabase;
    static final String DBName = "Students";
    static final String TableName = "Logins";
    static final String ColID = "ID";
    static final String ColUsername = "Username";
    static final String ColPassword = "Password";
    static final int DBVersion = 1;

    static final String CreateTable = "CREATE TABLE IF NOT EXISTS " + TableName +" (" +
            ColID + " integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
            ColUsername + " text NOT NULL," +
            ColPassword + " text NOT NULL);";

    static class DBHelper extends SQLiteOpenHelper {
        Context context;

        DBHelper(Context context) {
            super(context, DBName, null, DBVersion);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CreateTable);
            Toast.makeText(context, "Table is created.", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TableName);
            onCreate(sqLiteDatabase);
        }
    }

    public DBManager(Context context) {
        DBHelper db = new DBHelper(context);
        sqlDatabase = db.getWritableDatabase();
    }

    public long Insert(ContentValues values) {
        long ID = sqlDatabase.insert(TableName, "", values);
        // insert user id otherwise id <= 0;
        return ID;
    }

    // SELECT * FROM Logins WHERE ID = 1;
    public Cursor getData(String[] projection, String selection, String[] selectionArgs, String orderBy) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(TableName);

        Cursor cursor = queryBuilder.query(sqlDatabase, projection, selection, selectionArgs, null, null, orderBy);
        return cursor;
    }

}
