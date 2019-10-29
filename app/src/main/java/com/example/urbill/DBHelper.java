package com.example.urbill;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {


    private static final String TAG = "com.example.urbill.DBHelper";
    private static final int VERSION = 1;
    private static final String DB_NAME = "UrBill";
    public static final String TB_NAME = "Bill";
    private static final String CREATE_TB_BILL= "create table Bill("
            + "id integer primary key autoincrement,"
            + "uuid text,"
            + "type integer,"
            + "category text,"
            + "amount real,"
            + "remark text,"
            + "time integer,"
            + "date date)";
    public DBHelper(Context context){
        super(context,DB_NAME,null,VERSION);
        Log.d(TAG, "com.example.urbill.DBHelper: DB init");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TB_BILL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
