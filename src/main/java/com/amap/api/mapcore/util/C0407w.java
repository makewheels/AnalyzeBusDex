package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.sdk.WebView;
import java.security.MessageDigest;
import java.util.Locale;
import p054u.aly.bi_常量类;

/* compiled from: AppInfo */
/* renamed from: com.amap.api.mapcore.util.w */
public class C0407w {
    /* renamed from: a */
    private static String f2193a = bi_常量类.f6358b;
    /* renamed from: b */
    private static String f2194b = null;
    /* renamed from: c */
    private static String f2195c = bi_常量类.f6358b;
    /* renamed from: d */
    private static String f2196d;
    /* renamed from: e */
    private static String f2197e = null;

    /* renamed from: a */
    public static String m3489a(Context context) {
        try {
            if (!bi_常量类.f6358b.equals(f2193a)) {
                return f2193a;
            }
            PackageManager packageManager = context.getPackageManager();
            f2193a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f2193a;
        } catch (Throwable e) {
            az.m3143a(e, "AppInfo", "getApplicationName");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.m3143a(e2, "AppInfo", "getApplicationName");
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public static String m3491b(Context context) {
        try {
            if (f2194b != null && !bi_常量类.f6358b.equals(f2194b)) {
                return f2194b;
            }
            f2194b = context.getApplicationContext().getPackageName();
            return f2194b;
        } catch (Throwable th) {
            az.m3143a(th, "AppInfo", "getPackageName");
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public static String m3492c(Context context) {
        try {
            if (!bi_常量类.f6358b.equals(f2195c)) {
                return f2195c;
            }
            f2195c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return f2195c;
        } catch (Throwable e) {
            az.m3143a(e, "AppInfo", "getApplicationVersion");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.m3143a(e2, "AppInfo", "getApplicationVersion");
            e2.printStackTrace();
        }
    }

    /* renamed from: d */
    public static String m3493d(Context context) {
        try {
            if (f2197e != null && !bi_常量类.f6358b.equals(f2197e)) {
                return f2197e;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toUpperCase = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(":");
            }
            stringBuffer.append(packageInfo.packageName);
            f2197e = stringBuffer.toString();
            return f2197e;
        } catch (Throwable e) {
            az.m3143a(e, "AppInfo", "getSHA1AndPackage");
            e.printStackTrace();
            return f2197e;
        } catch (Throwable e2) {
            az.m3143a(e2, "AppInfo", "getSHA1AndPackage");
            e2.printStackTrace();
            return f2197e;
        } catch (Throwable e22) {
            az.m3143a(e22, "AppInfo", "getSHA1AndPackage");
            e22.printStackTrace();
            return f2197e;
        }
    }

    /* renamed from: a */
    static void m3490a(String str) {
        f2196d = str;
    }

    /* renamed from: g */
    private static String m3496g(Context context) throws NameNotFoundException {
        if (f2196d == null || f2196d.equals(bi_常量类.f6358b)) {
            f2196d = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.amap.api.v2.apikey");
        }
        return f2196d;
    }

    /* renamed from: e */
    public static String m3494e(Context context) {
        try {
            return C0407w.m3496g(context);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return f2196d;
        } catch (Throwable th) {
            th.printStackTrace();
            return f2196d;
        }
    }

    /* renamed from: f */
    public static String m3495f(Context context) {
        try {
            return C0407w.m3496g(context);
        } catch (Throwable e) {
            az.m3143a(e, "AppInfo", "getKey");
            e.printStackTrace();
            return f2196d;
        } catch (Throwable e2) {
            az.m3143a(e2, "AppInfo", "getKey");
            e2.printStackTrace();
            return f2196d;
        }
    }
}
