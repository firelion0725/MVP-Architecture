package com.leo.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.leo.data.dao.db.MessageDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo, ZhangWei
 * @date 2018/4/25
 * @function
 */
public class SqlHelper extends SQLiteOpenHelper {

    private static final String MESSAGE = "message";

    private final static String DB_NAME = "message.db";
    private final static int VERSION = 1;
    private static SqlHelper instance = null;
    private SQLiteDatabase db;

    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table message (_id integer primary key autoincrement,message_id text,title text,name text,content text,mct_id text,is_read text,ctime text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists message");
        onCreate(db);
    }

    public static SqlHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SqlHelper(context, DB_NAME, null, VERSION);
        }
        return instance;
    }

    private void openDatabase() {
        if (db == null) {
            db = getWritableDatabase();
        }
    }

    /**
     * 添加一条数据
     */
    public long saveMessage(MessageDAO pro) {
        openDatabase();
        ContentValues value = new ContentValues();
        value.put("message_id", pro.getMessage_id());
        value.put("title", pro.getTitle());
        value.put("content", pro.getContent());
        value.put("mct_id", pro.getMct_id());
        value.put("is_read", pro.getIs_read());
        value.put("ctime", pro.getCtime());
        return db.insert(MESSAGE, null, value);
    }

    /**
     * 查询所有数据
     * 根据编码查询数据
     */
    public List<MessageDAO> getAllData() {
        List<MessageDAO> list = new ArrayList<>();
        openDatabase();
        Cursor cursor = db.query(MESSAGE, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            MessageDAO pro = new MessageDAO();
            pro.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            pro.setMessage_id(cursor.getString(cursor.getColumnIndex("message_id")));
            pro.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            pro.setContent(cursor.getString(cursor.getColumnIndex("content")));
            pro.setMct_id(cursor.getString(cursor.getColumnIndex("mct_id")));
            pro.setIs_read(cursor.getString(cursor.getColumnIndex("is_read")));
            pro.setCtime(cursor.getString(cursor.getColumnIndex("ctime")));
            list.add(pro);
        }
        cursor.close();
        return list;
    }


}
