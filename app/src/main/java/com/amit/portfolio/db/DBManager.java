package com.amit.portfolio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String instrument, String type, String isin, String units, String date, String price, String mv) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.INSTRUMENT, instrument);
        contentValue.put(DatabaseHelper.TYPE, type);
        contentValue.put(DatabaseHelper.ISIN, isin);
        contentValue.put(DatabaseHelper.UNITS, units);
        contentValue.put(DatabaseHelper.PRICE_DATE, date);
        contentValue.put(DatabaseHelper.PRICE, price);
        contentValue.put(DatabaseHelper.MV, mv);
        database.insert(DatabaseHelper.HOLDINGS_TABLE, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.INSTRUMENT, DatabaseHelper.TYPE, DatabaseHelper.ISIN,
                DatabaseHelper.UNITS, DatabaseHelper.PRICE_DATE, DatabaseHelper.PRICE, DatabaseHelper.MV};
        Cursor cursor = database.query(DatabaseHelper.HOLDINGS_TABLE, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String instrument, String type) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.INSTRUMENT, instrument);
        contentValues.put(DatabaseHelper.TYPE, type);
        int i = database.update(DatabaseHelper.HOLDINGS_TABLE, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.HOLDINGS_TABLE, DatabaseHelper._ID + "=" + _id, null);
    }


}
