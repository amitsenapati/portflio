package com.amit.portfolio.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.amit.portfolio.holding.Holding;
import com.amit.portfolio.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // TABLE name
    public static final String HOLDINGS_TABLE = "HOLDINGS";
    // Table Columns
    public static final String _ID = "_id";
    public static final String INSTRUMENT = "instrument";
    public static final String TYPE = "type";
    public static final String ISIN = "isin";
    public static final String UNITS = "units";
    public static final String PRICE_DATE = "price_date";
    public static final String PRICE = "price";
    public static final String MV = "mv";
    // Database Information
    static final String DB_NAME = "HOLDINGS.DB";
    // database version
    static final int DB_VERSION = 1;
    // Creating table query
    private static final String CREATE_TABLE = "create table " + HOLDINGS_TABLE + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + INSTRUMENT + " TEXT NOT NULL, "
            + TYPE + " TEXT, "
            + ISIN + " TEXT, "
            + UNITS + " TEXT, "
            + PRICE_DATE + " TEXT, "
            + PRICE + " TEXT, "
            + MV + " TEXT);";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HOLDINGS_TABLE);
        onCreate(db);
    }

    public List<Holding> dummyHoldings() {
        List<Holding> holdingList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Holding.HoldingBuilder holdingsBuilder = Holding.builder();
            holdingsBuilder.id(i);
            holdingsBuilder.instrument("hdfc" + i);
            holdingsBuilder.price(String.valueOf(i * 10));
            holdingsBuilder.mv(String.valueOf(i * 100));
            holdingsBuilder.type("stock");
            holdingList.add(holdingsBuilder.build());
        }
        return holdingList;
    }

    public List<Transaction> dummyTransactins() {
        List<Transaction> transactionList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Transaction.TransactionBuilder builder = Transaction.builder();
            builder.id(i);
            builder.instrument("icici" + i);
            builder.price(String.valueOf(i * 10));
            builder.mv(String.valueOf(i * 100));
            builder.type("stock");
            transactionList.add(builder.build());
        }
        return transactionList;
    }

    List<Holding> listHoldings() {
        String sql = "select * from " + HOLDINGS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Holding> holdingList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String instrument = cursor.getString(1);
                String type = cursor.getString(2);
                String isin = cursor.getString(2);
                String units = cursor.getString(2);
                String priceDate = cursor.getString(2);
                String price = cursor.getString(2);
                String mv = cursor.getString(2);
                holdingList.add(new Holding(id, instrument, type, isin, units, priceDate, price, mv));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return holdingList;
    }
}
