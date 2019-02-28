package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.smtt.sdk.TbsConfig;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.v */
public class C1158v {
    /* renamed from: a */
    private static String f5162a = "9397";
    /* renamed from: b */
    private static String f5163b = bi_常量类.f6358b_空串;
    /* renamed from: c */
    private static String f5164c = "PP";
    /* renamed from: d */
    private static String f5165d = "PPVC";
    /* renamed from: e */
    private static boolean f5166e = false;
    /* renamed from: f */
    private static boolean f5167f = false;

    /* renamed from: a */
    private static String m8045a() {
        return f5162a;
    }

    /* renamed from: a */
    public static String m8046a(Context context) {
        if (!f5163b.equals(bi_常量类.f6358b_空串)) {
            return f5163b;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            f5164c = applicationInfo.packageName;
            f5165d = String.valueOf(packageInfo.versionCode);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        String str = "0";
        String str2 = TbsConfig.TBS_SDK_VERSIONNAME;
        String str3 = null;
        if (f5164c.equals("com.tencent.mm")) {
            str3 = C1135b.m7949a(context.getApplicationContext(), "com.tencent.mm.BuildInfo.CLIENT_VERSION");
        }
        f5163b = C1158v.m8047a(context, (byte) 0, str, true, str2, f5164c, str3 != null ? str3 : f5165d);
        return f5163b;
    }

    /* renamed from: a */
    private static String m8047a(Context context, byte b, String str, boolean z, String str2, String str3, String str4) {
        Object obj = null;
        String str5 = "x5Version";
        Object obj2 = null;
        String str6 = "blinkVersion";
        switch (b) {
            case (byte) 1:
                int i = 1;
                str5 = str;
                break;
            case (byte) 2:
                int i2 = 1;
                str6 = str;
                break;
        }
        String str7 = "QBVersion";
        String str8 = "1.1";
        CharSequence charSequence = "11111";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QV").append("=").append("2");
        C1158v.m8049a(stringBuilder, "PL", "ADR");
        if (z) {
            C1158v.m8049a(stringBuilder, "PR", "TBS");
        } else {
            C1158v.m8049a(stringBuilder, "PR", "QB");
        }
        C1158v.m8049a(stringBuilder, "PB", "GE");
        C1158v.m8049a(stringBuilder, "VE", "B1");
        if (z) {
            C1158v.m8049a(stringBuilder, "VN", str2);
        } else {
            C1158v.m8049a(stringBuilder, "VN", str7);
        }
        if (obj != null) {
            C1158v.m8049a(stringBuilder, "CO", "X5");
            C1158v.m8049a(stringBuilder, "COVN", str5);
        } else if (obj2 != null) {
            C1158v.m8049a(stringBuilder, "CO", "Blink");
            C1158v.m8049a(stringBuilder, "COVN", str6);
        } else {
            C1158v.m8049a(stringBuilder, "CO", "AMTT");
            C1158v.m8049a(stringBuilder, "COVN", str);
        }
        C1158v.m8049a(stringBuilder, "RF", "PRI");
        if (z) {
            C1158v.m8049a(stringBuilder, "PP", str3);
            C1158v.m8049a(stringBuilder, "PPVC", str4);
        }
        C1158v.m8049a(stringBuilder, "RL", C1158v.m8050b(context) + "*" + C1158v.m8052c(context));
        String b2 = C1158v.m8051b();
        try {
            Object str9 = new String(b2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str6 = b2;
        }
        if (!TextUtils.isEmpty(str9)) {
            C1158v.m8049a(stringBuilder, "MO", str9);
        }
        if (C1158v.m8055e(context)) {
            C1158v.m8049a(stringBuilder, "DE", "PAD");
        } else {
            C1158v.m8049a(stringBuilder, "DE", "PHONE");
        }
        b2 = VERSION.RELEASE;
        try {
            str9 = new String(b2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            str6 = b2;
        }
        if (!TextUtils.isEmpty(str9)) {
            C1158v.m8049a(stringBuilder, "OS", str9);
        }
        C1158v.m8049a(stringBuilder, "API", VERSION.SDK_INT + bi_常量类.f6358b_空串);
        b2 = "CHID";
        if (TextUtils.isEmpty(charSequence)) {
            str6 = "0";
        } else {
            CharSequence charSequence2 = charSequence;
        }
        C1158v.m8049a(stringBuilder, b2, str6);
        C1158v.m8049a(stringBuilder, "LCID", C1158v.m8045a());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static String m8048a(String str) {
        String str2 = bi_常量类.f6358b_空串;
        try {
            str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
            return str2 != null ? str2 : str2;
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: a */
    private static void m8049a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append("&").append(str).append("=").append(str2);
    }

    /* renamed from: b */
    private static int m8050b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: b */
    private static String m8051b() {
        return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", bi_常量类.f6358b_空串) + " ";
    }

    /* renamed from: c */
    private static int m8052c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    /* renamed from: c */
    private static String m8053c() {
        return C1158v.m8048a("ro.build.version.newbee.display");
    }

    /* renamed from: d */
    private static int m8054d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    /* renamed from: e */
    private static boolean m8055e(Context context) {
        if (f5166e) {
            return f5167f;
        }
        f5167f = (Math.min(C1158v.m8050b(context), C1158v.m8052c(context)) * 160) / C1158v.m8054d(context) >= 700;
        f5166e = true;
        return f5167f;
    }
}
