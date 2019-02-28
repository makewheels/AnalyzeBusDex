package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: LogEntity */
public abstract class am implements aq<an> {
    /* renamed from: a */
    private static final String f1937a = ai.f1953l;
    /* renamed from: b */
    private static final String f1938b = ai.f1954m;
    /* renamed from: c */
    private static final String f1939c = ai.f1955n;
    /* renamed from: d */
    private static final String f1940d = ai.f1947f;
    /* renamed from: e */
    private an f1941e = null;

    /* renamed from: b */
    public /* synthetic */ Object mo591b(Cursor cursor) {
        return m3067a(cursor);
    }

    /* renamed from: b */
    public ContentValues mo590b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f1941e == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f1937a, this.f1941e.m3093b());
                contentValues2.put(f1938b, Integer.valueOf(this.f1941e.m3090a()));
                contentValues2.put(f1940d, au.m3126a(this.f1941e.m3096c()));
                contentValues2.put(f1939c, Integer.valueOf(this.f1941e.m3097d()));
                return contentValues2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                contentValues = contentValues2;
                th = th3;
                th.printStackTrace();
                return contentValues;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return contentValues;
        }
    }

    /* renamed from: a */
    public an m3067a(Cursor cursor) {
        Throwable th;
        an anVar = null;
        if (cursor == null) {
            return null;
        }
        try {
            String string = cursor.getString(1);
            int i = cursor.getInt(2);
            String string2 = cursor.getString(4);
            int i2 = cursor.getInt(3);
            an anVar2 = new an();
            try {
                anVar2.m3092a(string);
                anVar2.m3091a(i);
                anVar2.m3095b(au.m3127b(string2));
                anVar2.m3094b(i2);
                return anVar2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                anVar = anVar2;
                th = th3;
                th.printStackTrace();
                return anVar;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return anVar;
        }
    }

    /* renamed from: a */
    public void m3068a(an anVar) {
        this.f1941e = anVar;
    }

    /* renamed from: a */
    public static String m3066a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(f1937a).append("='").append(str).append("'");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static String m3065a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(f1938b).append("=").append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
