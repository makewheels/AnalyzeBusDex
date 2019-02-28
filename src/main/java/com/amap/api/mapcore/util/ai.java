package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public class ai extends SQLiteOpenHelper {
    /* renamed from: a */
    static final String f1942a = "a";
    /* renamed from: b */
    static final String f1943b = "b";
    /* renamed from: c */
    static final String f1944c = "c";
    /* renamed from: d */
    static final String f1945d = "d";
    /* renamed from: e */
    static final String f1946e = "e";
    /* renamed from: f */
    static final String f1947f = "a1";
    /* renamed from: g */
    static final String f1948g = "a2";
    /* renamed from: h */
    static final String f1949h = "a3";
    /* renamed from: i */
    static final String f1950i = "a4";
    /* renamed from: j */
    static final String f1951j = "a5";
    /* renamed from: k */
    static final String f1952k = "a6";
    /* renamed from: l */
    static final String f1953l = "b1";
    /* renamed from: m */
    static final String f1954m = "b2";
    /* renamed from: n */
    static final String f1955n = "b3";
    /* renamed from: o */
    static final String f1956o = "c1";
    /* renamed from: p */
    static final String f1957p = "c2";
    /* renamed from: q */
    static final String f1958q = "c3";
    /* renamed from: r */
    private static final String f1959r = ("CREATE TABLE IF NOT EXISTS " + f1942a + " (_id integer primary key autoincrement, " + f1947f + "  varchar(20), " + f1948g + " varchar(10)," + f1949h + " varchar(50)," + f1950i + " varchar(100)," + f1951j + " varchar(20)," + f1952k + " integer);");
    /* renamed from: s */
    private static final String f1960s = ("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement," + f1953l + " varchar(40), " + f1954m + " integer," + f1955n + "  integer," + f1947f + "  varchar(20));");
    /* renamed from: t */
    private static final String f1961t = ("CREATE TABLE IF NOT EXISTS " + f1946e + " (_id integer primary key autoincrement," + f1956o + " integer," + f1957p + " integer," + f1958q + " integer);");

    public ai(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f1959r);
            sQLiteDatabase.execSQL(String.format(f1960s, new Object[]{f1943b}));
            sQLiteDatabase.execSQL(String.format(f1960s, new Object[]{f1944c}));
            sQLiteDatabase.execSQL(String.format(f1960s, new Object[]{f1945d}));
            sQLiteDatabase.execSQL(f1961t);
        } catch (Throwable th) {
            az.m3143a(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
