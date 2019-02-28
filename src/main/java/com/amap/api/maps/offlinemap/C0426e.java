package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: OfflineDBHelper */
/* renamed from: com.amap.api.maps.offlinemap.e */
class C0426e extends SQLiteOpenHelper {
    /* renamed from: d */
    private static C0426e f2472d = null;
    /* renamed from: a */
    private String f2473a;
    /* renamed from: b */
    private String f2474b;
    /* renamed from: c */
    private String f2475c;

    /* renamed from: a */
    public static synchronized C0426e m3676a(Context context) {
        C0426e c0426e;
        synchronized (C0426e.class) {
            if (f2472d == null) {
                f2472d = new C0426e(context);
            }
            c0426e = f2472d;
        }
        return c0426e;
    }

    public C0426e(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f2473a = "CREATE TABLE 'update_item' (   '_id'\tINTEGER PRIMARY KEY AUTOINCREMENT,   'title'\tTEXT,'url'\tTEXT,'mAdcode' \tTEXT,'fileName'\tTEXT,'version'\tTEXT,'lLocalLength'\tINTEGER,'lRemoteLength'\tINTEGER,'localPath'\tTEXT,'mIndex'\tINTEGER,'isProvince'\tINTEGER NOT NULL,'mCompleteCode'\tINTEGER,'mCityCode'\tTEXT ,'mState' INTEGER, UNIQUE(mAdcode) );";
        this.f2474b = "CREATE TABLE 'update_item_file' (   '_id'\tINTEGER PRIMARY KEY AUTOINCREMENT,    'mAdcode'\tTEXT,'file'\tTEXT);";
        this.f2475c = "CREATE TABLE 'update_item_download_info' (  '_id'\tINTEGER PRIMARY KEY AUTOINCREMENT,  'mAdcode'\tTEXT,'fileLength'\tINTEGER,'splitter'\tINTEGER,'nStartPos0'\tINTEGER,'nEndPos0'\tINTEGER,'nStartPos1'\tINTEGER,'nEndPos1'\tINTEGER,'nStartPos2'\tINTEGER,'nEndPos2'\tINTEGER,'nStartPos3'\tINTEGER,'nEndPos3'\tINTEGER,'nStartPos4'\tINTEGER,'nEndPos4'\tINTEGER);";
    }

    public C0426e(Context context) {
        this(context, "offline.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.f2473a);
        sQLiteDatabase.execSQL(this.f2474b);
        sQLiteDatabase.execSQL(this.f2475c);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
