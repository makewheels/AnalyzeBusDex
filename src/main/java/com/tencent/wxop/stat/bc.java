package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.wxop.stat.common.C1198q;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

class bc extends SQLiteOpenHelper {
    /* renamed from: a */
    private String f5420a = bi_常量类.f6358b_空串;
    /* renamed from: b */
    private Context f5421b = null;

    public bc(Context context, String str) {
        super(context, str, null, 3);
        this.f5420a = str;
        this.f5421b = context.getApplicationContext();
        if (StatConfig.isDebugEnable()) {
            au.f5383h.m8243i("SQLiteOpenHelper " + this.f5420a);
        }
    }

    /* renamed from: a */
    private void m8237a(SQLiteDatabase sQLiteDatabase) {
        Cursor query;
        Throwable th;
        String str = null;
        try {
            query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put("uid", C1198q.m8334b(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    au.f5383h.m8242e(th);
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private void m8238b(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        try {
            query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            try {
                List<bd> arrayList = new ArrayList();
                while (query.moveToNext()) {
                    arrayList.add(new bd(query.getLong(0), query.getString(1), query.getInt(2), query.getInt(3)));
                }
                ContentValues contentValues = new ContentValues();
                for (bd bdVar : arrayList) {
                    contentValues.put("content", C1198q.m8334b(bdVar.f5423b));
                    sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(bdVar.f5422a)});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        au.f5383h.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m8237a(sQLiteDatabase);
            m8238b(sQLiteDatabase);
        }
        if (i == 2) {
            m8237a(sQLiteDatabase);
            m8238b(sQLiteDatabase);
        }
    }
}
