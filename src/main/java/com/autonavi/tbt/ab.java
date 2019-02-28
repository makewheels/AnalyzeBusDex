package com.autonavi.tbt;

import android.content.ContentValues;
import android.database.Cursor;
import com.autonavi.tbt.C0629p.C0628a;

/* compiled from: SDKEntity */
public class ab implements ac<C0629p> {
    /* renamed from: a */
    private static String f3676a = C0635u.f3856f;
    /* renamed from: b */
    private static String f3677b = C0635u.f3857g;
    /* renamed from: c */
    private static String f3678c = C0635u.f3861k;
    /* renamed from: d */
    private static String f3679d = C0635u.f3858h;
    /* renamed from: e */
    private static String f3680e = C0635u.f3859i;
    /* renamed from: f */
    private static String f3681f = C0635u.f3860j;
    /* renamed from: g */
    private C0629p f3682g = null;

    /* renamed from: b */
    public /* synthetic */ Object mo740b(Cursor cursor) {
        return m4663a(cursor);
    }

    /* renamed from: b */
    public ContentValues mo739b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f3682g == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f3676a, ad.m4667a(this.f3682g.m4938a()));
                contentValues2.put(f3677b, ad.m4667a(this.f3682g.m4939b()));
                contentValues2.put(f3678c, Boolean.valueOf(this.f3682g.m4942e()));
                contentValues2.put(f3679d, ad.m4667a(this.f3682g.m4940c()));
                contentValues2.put(f3681f, ad.m4667a(this.f3682g.m4941d()));
                contentValues2.put(f3680e, ad.m4667a(m4660a(this.f3682g.m4943f())));
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
    public C0629p m4663a(Cursor cursor) {
        boolean z = true;
        C0629p c0629p = null;
        try {
            String b = ad.m4668b(cursor.getString(1));
            String b2 = ad.m4668b(cursor.getString(2));
            String b3 = ad.m4668b(cursor.getString(3));
            String[] a = m4661a(ad.m4668b(cursor.getString(4)));
            String b4 = ad.m4668b(cursor.getString(5));
            if (cursor.getInt(6) == 0) {
                z = false;
            }
            c0629p = new C0628a(b, b2, b3).m4935a(z).m4934a(b4).m4936a(a).m4937a();
        } catch (C0618h e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return c0629p;
    }

    /* renamed from: a */
    public String mo738a() {
        return C0635u.f3851a;
    }

    /* renamed from: a */
    private String[] m4661a(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m4660a(String[] strArr) {
        String str = null;
        if (strArr != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                for (String append : strArr) {
                    stringBuilder.append(append).append(";");
                }
                str = stringBuilder.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: c */
    public static String m4662c() {
        return f3678c + "=1";
    }
}
