package com.autonavi.tbt;

import android.content.ContentValues;
import android.database.Cursor;

/* compiled from: LogEntity */
/* renamed from: com.autonavi.tbt.y */
public abstract class C0632y implements ac<C0639z> {
    /* renamed from: a */
    private static final String f3846a = C0635u.f3862l;
    /* renamed from: b */
    private static final String f3847b = C0635u.f3863m;
    /* renamed from: c */
    private static final String f3848c = C0635u.f3864n;
    /* renamed from: d */
    private static final String f3849d = C0635u.f3856f;
    /* renamed from: e */
    private C0639z f3850e = null;

    /* renamed from: b */
    public /* synthetic */ Object mo740b(Cursor cursor) {
        return m4959a(cursor);
    }

    /* renamed from: b */
    public ContentValues mo739b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f3850e == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f3846a, this.f3850e.m4981b());
                contentValues2.put(f3847b, Integer.valueOf(this.f3850e.m4978a()));
                contentValues2.put(f3849d, ad.m4667a(this.f3850e.m4984c()));
                contentValues2.put(f3848c, Integer.valueOf(this.f3850e.m4985d()));
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
    public C0639z m4959a(Cursor cursor) {
        Throwable th;
        C0639z c0639z = null;
        if (cursor == null) {
            return null;
        }
        try {
            String string = cursor.getString(1);
            int i = cursor.getInt(2);
            String string2 = cursor.getString(4);
            int i2 = cursor.getInt(3);
            C0639z c0639z2 = new C0639z();
            try {
                c0639z2.m4980a(string);
                c0639z2.m4979a(i);
                c0639z2.m4983b(ad.m4668b(string2));
                c0639z2.m4982b(i2);
                return c0639z2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                c0639z = c0639z2;
                th = th3;
                th.printStackTrace();
                return c0639z;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return c0639z;
        }
    }

    /* renamed from: a */
    public void m4960a(C0639z c0639z) {
        this.f3850e = c0639z;
    }

    /* renamed from: a */
    public static String m4958a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(f3846a).append("='").append(str).append("'");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
