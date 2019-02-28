package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;
import com.amap.api.mapcore.util.ad.C0356a;

/* compiled from: SDKEntity */
public class ap implements aq<ad> {
    /* renamed from: a */
    private static String f1971a = ai.f1947f;
    /* renamed from: b */
    private static String f1972b = ai.f1948g;
    /* renamed from: c */
    private static String f1973c = ai.f1952k;
    /* renamed from: d */
    private static String f1974d = ai.f1949h;
    /* renamed from: e */
    private static String f1975e = ai.f1950i;
    /* renamed from: f */
    private static String f1976f = ai.f1951j;
    /* renamed from: g */
    private ad f1977g = null;

    /* renamed from: b */
    public /* synthetic */ Object mo591b(Cursor cursor) {
        return m3105a(cursor);
    }

    /* renamed from: b */
    public ContentValues mo590b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.f1977g == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(f1971a, au.m3126a(this.f1977g.m3033a()));
                contentValues2.put(f1972b, au.m3126a(this.f1977g.m3034b()));
                contentValues2.put(f1973c, Boolean.valueOf(this.f1977g.m3037e()));
                contentValues2.put(f1974d, au.m3126a(this.f1977g.m3035c()));
                contentValues2.put(f1976f, au.m3126a(this.f1977g.m3036d()));
                contentValues2.put(f1975e, au.m3126a(m3102a(this.f1977g.m3038f())));
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
    public ad m3105a(Cursor cursor) {
        boolean z = true;
        ad adVar = null;
        try {
            String b = au.m3127b(cursor.getString(1));
            String b2 = au.m3127b(cursor.getString(2));
            String b3 = au.m3127b(cursor.getString(3));
            String[] b4 = m3103b(au.m3127b(cursor.getString(4)));
            String b5 = au.m3127b(cursor.getString(5));
            if (cursor.getInt(6) == 0) {
                z = false;
            }
            adVar = new C0356a(b, b2, b3).m3030a(z).m3029a(b5).m3031a(b4).m3032a();
        } catch (C0406v e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return adVar;
    }

    /* renamed from: a */
    public void m3107a(ad adVar) {
        this.f1977g = adVar;
    }

    /* renamed from: a */
    public String mo592a() {
        return ai.f1942a;
    }

    /* renamed from: b */
    private String[] m3103b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m3102a(String[] strArr) {
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

    /* renamed from: a */
    public static String m3101a(String str) {
        return f1971a + "='" + au.m3126a(str) + "'";
    }

    /* renamed from: c */
    public static String m3104c() {
        return f1973c + "=1";
    }
}
