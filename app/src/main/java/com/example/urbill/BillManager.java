package com.example.urbill;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

public class BillManager {
    private static final String TAG = "BillManager";
    private DBHelper dbHelper;
    private String TBNAME;

    public BillManager(Context context){
        dbHelper = new DBHelper(context);
        TBNAME = dbHelper.TB_NAME;
    }

    public void add(BillBean bean){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uuid", bean.getUuid());
        values.put("type", bean.getType());
        values.put("category", bean.getCategory());
        values.put("remark", bean.getRemark());
        values.put("date",bean.getDate());
        values.put("time",bean.getTimeStamp());
        values.clear();
        Log.i(TAG, bean.getUuid()+"--->added");
        db.insert(TBNAME,null,values);
        db.close();
    }

    public void removeBill(String uuid){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,"uuid = ?",new String[]{uuid});
    }

    public List<BillBean> queryBills(String dateStr){
        List<BillBean> bills = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME,null,"where date = ?", new String[]{dateStr},null, null, "order by time");
        if(cursor.moveToFirst()){
            do{
                String uuid = cursor.getString(cursor.getColumnIndex("uuid"));
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
                String remark = cursor.getString(cursor.getColumnIndex("remark"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                long timeStamp = cursor.getLong(cursor.getColumnIndex("time"));
                BillBean bill = new BillBean();
                bill.setUuid(uuid);
                bill.setType(type);
                bill.setCategory(category);
                bill.setAmount(amount);
                bill.setRemark(remark);
                bill.setDate(date);
                bill.setTimeStamp(timeStamp);

                bills.add(bill);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return bills;
    }






}
