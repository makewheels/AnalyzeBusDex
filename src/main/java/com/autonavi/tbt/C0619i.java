package com.autonavi.tbt;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.sdk.WebView;
import java.security.MessageDigest;
import java.util.Locale;
import p054u.aly.bi_常量类;

/* compiled from: AppInfo */
/* renamed from: com.autonavi.tbt.i */
public class C0619i {
    /* renamed from: a */
    private static String f3813a = bi_常量类.f6358b;
    /* renamed from: b */
    private static String f3814b = null;
    /* renamed from: c */
    private static String f3815c = bi_常量类.f6358b;
    /* renamed from: d */
    private static String f3816d;
    /* renamed from: e */
    private static String f3817e = null;

    /* renamed from: a */
    public static String m4862a(Context context) {
        try {
            if (!bi_常量类.f6358b.equals(f3813a)) {
                return f3813a;
            }
            PackageManager packageManager = context.getPackageManager();
            f3813a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f3813a;
        } catch (Throwable e) {
            ae.m4671a(e, "AppInfo", "getApplicationName");
            e.printStackTrace();
        } catch (Throwable e2) {
            ae.m4671a(e2, "AppInfo", "getApplicationName");
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public static String m4863b(Context context) {
        try {
            if (f3814b != null && !bi_常量类.f6358b.equals(f3814b)) {
                return f3814b;
            }
            f3814b = context.getApplicationContext().getPackageName();
            return f3814b;
        } catch (Throwable th) {
            ae.m4671a(th, "AppInfo", "getPackageName");
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public static String m4864c(Context context) {
        try {
            if (!bi_常量类.f6358b.equals(f3815c)) {
                return f3815c;
            }
            f3815c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return f3815c;
        } catch (Throwable e) {
            ae.m4671a(e, "AppInfo", "getApplicationVersion");
            e.printStackTrace();
        } catch (Throwable e2) {
            ae.m4671a(e2, "AppInfo", "getApplicationVersion");
            e2.printStackTrace();
        }
    }

    /* renamed from: d */
    public static String m4865d(Context context) {
        try {
            if (f3817e != null && !bi_常量类.f6358b.equals(f3817e)) {
                return f3817e;
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
            f3817e = stringBuffer.toString();
            return f3817e;
        } catch (Throwable e) {
            ae.m4671a(e, "AppInfo", "getSHA1AndPackage");
            e.printStackTrace();
            return f3817e;
        } catch (Throwable e2) {
            ae.m4671a(e2, "AppInfo", "getSHA1AndPackage");
            e2.printStackTrace();
            return f3817e;
        } catch (Throwable e22) {
            ae.m4671a(e22, "AppInfo", "getSHA1AndPackage");
            e22.printStackTrace();
            return f3817e;
        }
    }

    /* renamed from: g */
    private static String m4868g(Context context) throws NameNotFoundException {
        if (f3816d == null || f3816d.equals(bi_常量类.f6358b)) {
            f3816d = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.amap.api.v2.apikey");
        }
        return f3816d;
    }

    /* renamed from: e */
    public static String m4866e(Context context) {
        try {
            return C0619i.m4868g(context);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return f3816d;
        } catch (Throwable th) {
            th.printStackTrace();
            return f3816d;
        }
    }

    /* renamed from: f */
    public static String m4867f(Context context) {
        try {
            return C0619i.m4868g(context);
        } catch (Throwable e) {
            ae.m4671a(e, "AppInfo", "getKey");
            e.printStackTrace();
            return f3816d;
        } catch (Throwable e2) {
            ae.m4671a(e2, "AppInfo", "getKey");
            e2.printStackTrace();
            return f3816d;
        }
    }
}
