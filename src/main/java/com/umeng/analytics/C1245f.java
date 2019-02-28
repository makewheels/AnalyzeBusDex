package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import p054u.aly.bi_常量类;
import p054u.aly.bj;
import p054u.aly.bv;

/* compiled from: StoreHelper */
/* renamed from: com.umeng.analytics.f */
public final class C1245f {
    /* renamed from: a */
    private static C1245f f5629a = new C1245f();
    /* renamed from: b */
    private static Context f5630b = null;
    /* renamed from: c */
    private static String f5631c = null;
    /* renamed from: d */
    private static long f5632d = 1209600000;
    /* renamed from: e */
    private static long f5633e = 2097152;
    /* renamed from: f */
    private static final String f5634f = "age";
    /* renamed from: g */
    private static final String f5635g = "sex";
    /* renamed from: h */
    private static final String f5636h = "id";
    /* renamed from: i */
    private static final String f5637i = "url";
    /* renamed from: j */
    private static final String f5638j = "mobclick_agent_user_";
    /* renamed from: k */
    private static final String f5639k = "mobclick_agent_online_setting_";
    /* renamed from: l */
    private static final String f5640l = "mobclick_agent_header_";
    /* renamed from: m */
    private static final String f5641m = "mobclick_agent_update_";
    /* renamed from: n */
    private static final String f5642n = "mobclick_agent_state_";
    /* renamed from: o */
    private static final String f5643o = "mobclick_agent_cached_";
    /* renamed from: p */
    private static final String f5644p = "mobclick_agent_sealed_";

    /* renamed from: a */
    public static C1245f m8407a(Context context) {
        if (f5630b == null) {
            f5630b = context.getApplicationContext();
        }
        if (f5631c == null) {
            f5631c = context.getPackageName();
        }
        return f5629a;
    }

    /* renamed from: a */
    private static boolean m8408a(File file) {
        long length = file.length();
        if (!file.exists() || length <= f5633e) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m8414a(String str, String str2, int i, int i2) {
        Editor edit = m8409k().edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(f5636h, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(f5637i, str2);
        }
        if (i > 0) {
            edit.putInt(f5634f, i);
        }
        edit.putInt(f5635g, i2);
        edit.commit();
    }

    /* renamed from: b */
    public Object[] m8419b(Context context) {
        SharedPreferences k = m8409k();
        Object[] objArr = new Object[4];
        if (k.contains(f5636h)) {
            objArr[0] = k.getString(f5636h, null);
        }
        if (k.contains(f5637i)) {
            objArr[1] = k.getString(f5637i, null);
        }
        if (k.contains(f5634f)) {
            objArr[2] = Integer.valueOf(k.getInt(f5634f, -1));
        }
        if (k.contains(f5635g)) {
            objArr[3] = Integer.valueOf(k.getInt(f5635g, -1));
        }
        return objArr;
    }

    /* renamed from: a */
    public int[] m8416a() {
        SharedPreferences g = m8424g();
        int[] iArr = new int[2];
        if (g.getInt(C1233a.f5592h, -1) != -1) {
            iArr[0] = g.getInt(C1233a.f5592h, 1);
            iArr[1] = (int) g.getLong(C1233a.f5593i, 0);
        } else {
            iArr[0] = g.getInt(C1233a.f5595k, 1);
            iArr[1] = (int) g.getLong(C1233a.f5596l, 0);
        }
        return iArr;
    }

    /* renamed from: a */
    public void m8413a(int i, int i2) {
        Editor edit = C1245f.m8407a(f5630b).m8424g().edit();
        edit.putInt(C1233a.f5592h, i);
        edit.putLong(C1233a.f5593i, (long) i2);
        edit.commit();
    }

    /* renamed from: b */
    public byte[] m8418b() {
        Exception e;
        Throwable th;
        byte[] bArr = null;
        String m = m8411m();
        File file = new File(f5630b.getFilesDir(), m);
        if (C1245f.m8408a(file)) {
            file.delete();
        } else if (file.exists()) {
            InputStream openFileInput;
            try {
                openFileInput = f5630b.openFileInput(m);
                try {
                    bArr = bv.m10063b(openFileInput);
                    bv.m10065c(openFileInput);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        bv.m10065c(openFileInput);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        bv.m10065c(openFileInput);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openFileInput = bArr;
                e.printStackTrace();
                bv.m10065c(openFileInput);
                return bArr;
            } catch (Throwable th3) {
                openFileInput = bArr;
                th = th3;
                bv.m10065c(openFileInput);
                throw th;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public void m8415a(byte[] bArr) {
        try {
            bv.m10059a(new File(f5630b.getFilesDir(), m8411m()), bArr);
        } catch (Exception e) {
            bj.m10002b(C1233a.f5589e, e.getMessage());
        }
    }

    /* renamed from: c */
    public void m8420c() {
        f5630b.deleteFile(m8410l());
        f5630b.deleteFile(m8411m());
    }

    /* renamed from: d */
    public byte[] m8421d() {
        InputStream openFileInput;
        Exception e;
        Throwable th;
        String n = m8412n();
        File file = new File(f5630b.getFilesDir(), n);
        try {
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            try {
                openFileInput = f5630b.openFileInput(n);
            } catch (Exception e2) {
                e = e2;
                openFileInput = null;
                try {
                    e.printStackTrace();
                    bv.m10065c(openFileInput);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bv.m10065c(openFileInput);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                openFileInput = null;
                bv.m10065c(openFileInput);
                throw th;
            }
            try {
                byte[] b = bv.m10063b(openFileInput);
                bv.m10065c(openFileInput);
                return b;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                bv.m10065c(openFileInput);
                return null;
            }
        } catch (Exception e4) {
            file.delete();
            e4.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m8417b(byte[] bArr) {
        try {
            bv.m10059a(new File(f5630b.getFilesDir(), m8412n()), bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m8422e() {
        bj.m10000a("--->", "delete envelope:" + f5630b.deleteFile(m8412n()));
    }

    /* renamed from: f */
    public boolean m8423f() {
        File file = new File(f5630b.getFilesDir(), m8412n());
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: k */
    private SharedPreferences m8409k() {
        return f5630b.getSharedPreferences(f5638j + f5631c, 0);
    }

    /* renamed from: g */
    public SharedPreferences m8424g() {
        return f5630b.getSharedPreferences(f5639k + f5631c, 0);
    }

    /* renamed from: h */
    public SharedPreferences m8425h() {
        return f5630b.getSharedPreferences(f5640l + f5631c, 0);
    }

    /* renamed from: i */
    public SharedPreferences m8426i() {
        return f5630b.getSharedPreferences(f5641m + f5631c, 0);
    }

    /* renamed from: j */
    public SharedPreferences m8427j() {
        return f5630b.getSharedPreferences(f5642n + f5631c, 0);
    }

    /* renamed from: l */
    private String m8410l() {
        return f5640l + f5631c;
    }

    /* renamed from: m */
    private String m8411m() {
        return f5643o + f5631c + bi_常量类.m9978c(f5630b);
    }

    /* renamed from: n */
    private String m8412n() {
        return f5644p + f5631c;
    }
}
