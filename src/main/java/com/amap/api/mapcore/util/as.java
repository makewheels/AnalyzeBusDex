package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: UpdateLogEntity */
public class as implements aq<at> {
    /* renamed from: b */
    private static final String f1980b = ai.f1956o;
    /* renamed from: c */
    private static final String f1981c = ai.f1957p;
    /* renamed from: d */
    private static final String f1982d = ai.f1958q;
    /* renamed from: a */
    private at f1983a = null;

    /* renamed from: b */
    public /* synthetic */ Object mo591b(Cursor cursor) {
        return m3114a(cursor);
    }

    /* renamed from: b */
    public ContentValues mo590b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f1983a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f1980b, Boolean.valueOf(this.f1983a.m3121a()));
                contentValues2.put(f1981c, Boolean.valueOf(this.f1983a.m3123b()));
                contentValues2.put(f1982d, Boolean.valueOf(this.f1983a.m3125c()));
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
    public at m3114a(Cursor cursor) {
        at atVar;
        Throwable th;
        boolean z = true;
        try {
            boolean z2;
            boolean z3;
            int i = cursor.getInt(1);
            int i2 = cursor.getInt(2);
            int i3 = cursor.getInt(3);
            if (i == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (i2 == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (i3 == 0) {
                z = false;
            }
            atVar = new at();
            try {
                atVar.m3120a(z2);
                atVar.m3124c(z);
                atVar.m3122b(z3);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return atVar;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            atVar = null;
            th = th4;
            th.printStackTrace();
            return atVar;
        }
        return atVar;
    }

    /* renamed from: a */
    public void m3116a(at atVar) {
        this.f1983a = atVar;
    }

    /* renamed from: a */
    public String mo592a() {
        return ai.f1946e;
    }
}
