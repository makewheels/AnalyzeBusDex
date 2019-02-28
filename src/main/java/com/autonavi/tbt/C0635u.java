package com.autonavi.tbt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
/* renamed from: com.autonavi.tbt.u */
public class C0635u extends SQLiteOpenHelper {
    /* renamed from: a */
    static final String f3851a = "a";
    /* renamed from: b */
    static final String f3852b = "b";
    /* renamed from: c */
    static final String f3853c = "c";
    /* renamed from: d */
    static final String f3854d = "d";
    /* renamed from: e */
    static final String f3855e = "e";
    /* renamed from: f */
    static final String f3856f = "a1";
    /* renamed from: g */
    static final String f3857g = "a2";
    /* renamed from: h */
    static final String f3858h = "a3";
    /* renamed from: i */
    static final String f3859i = "a4";
    /* renamed from: j */
    static final String f3860j = "a5";
    /* renamed from: k */
    static final String f3861k = "a6";
    /* renamed from: l */
    static final String f3862l = "b1";
    /* renamed from: m */
    static final String f3863m = "b2";
    /* renamed from: n */
    static final String f3864n = "b3";
    /* renamed from: o */
    static final String f3865o = "c1";
    /* renamed from: p */
    static final String f3866p = "c2";
    /* renamed from: q */
    static final String f3867q = "c3";
    /* renamed from: r */
    private static final String f3868r = ("CREATE TABLE IF NOT EXISTS " + f3851a + " (_id integer primary key autoincrement, " + f3856f + "  varchar(20), " + f3857g + " varchar(10)," + f3858h + " varchar(50)," + f3859i + " varchar(100)," + f3860j + " varchar(20)," + f3861k + " integer);");
    /* renamed from: s */
    private static final String f3869s = ("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement," + f3862l + " varchar(40), " + f3863m + " integer," + f3864n + "  integer," + f3856f + "  varchar(20));");
    /* renamed from: t */
    private static final String f3870t = ("CREATE TABLE IF NOT EXISTS " + f3855e + " (_id integer primary key autoincrement," + f3865o + " integer," + f3866p + " integer," + f3867q + " integer);");

    public C0635u(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f3868r);
            sQLiteDatabase.execSQL(String.format(f3869s, new Object[]{f3852b}));
            sQLiteDatabase.execSQL(String.format(f3869s, new Object[]{f3853c}));
            sQLiteDatabase.execSQL(String.format(f3869s, new Object[]{f3854d}));
            sQLiteDatabase.execSQL(f3870t);
        } catch (Throwable th) {
            ae.m4671a(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
