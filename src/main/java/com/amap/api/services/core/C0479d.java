package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import p054u.aly.bi_常量类;

/* compiled from: ClientInfoUtil */
/* renamed from: com.amap.api.services.core.d */
public class C0479d {
    /* renamed from: a */
    private static C0479d f2935a = null;
    /* renamed from: b */
    private static Context f2936b = null;
    /* renamed from: c */
    private static TelephonyManager f2937c;
    /* renamed from: d */
    private static ConnectivityManager f2938d;
    /* renamed from: e */
    private static String f2939e;
    /* renamed from: f */
    private static String f2940f;
    /* renamed from: g */
    private static String f2941g;
    /* renamed from: h */
    private static String f2942h;
    /* renamed from: i */
    private static String f2943i = bi_常量类.f6358b_空串;
    /* renamed from: j */
    private static String f2944j = bi_常量类.f6358b_空串;

    /* renamed from: a */
    public static C0479d m3999a(Context context) {
        if (f2935a == null) {
            f2935a = new C0479d();
            f2936b = context;
            f2937c = (TelephonyManager) f2936b.getSystemService("phone");
            f2938d = (ConnectivityManager) f2936b.getSystemService("connectivity");
            f2939e = f2936b.getApplicationContext().getPackageName();
            f2940f = C0479d.m4003j();
            f2941g = C0479d.m4001g();
            f2942h = C0479d.m4002i();
            f2943i = C0479d.m4000b(f2936b);
            f2944j = C0480e.m4022b(f2936b);
        }
        return f2935a;
    }

    /* renamed from: j */
    private static String m4003j() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) f2936b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        f2940f = i2 > i ? i + "*" + i2 : i2 + "*" + i;
        return f2940f;
    }

    private C0479d() {
    }

    /* renamed from: a */
    public String m4004a() {
        KeyGenerator instance;
        Exception e;
        try {
            instance = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            instance = null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        try {
            Object a = C0483h.m4034a(encoded, C0483h.m4032a(f2936b));
            Object a2 = C0483h.m4035a(encoded, m4005b().getBytes("utf-8"));
            encoded = new byte[(a.length + a2.length)];
            try {
                System.arraycopy(a, 0, encoded, 0, a.length);
                System.arraycopy(a2, 0, encoded, a.length, a2.length);
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return C0483h.m4036b(C0483h.m4033a(encoded));
            }
        } catch (Exception e4) {
            Exception exception = e4;
            encoded = null;
            e = exception;
            e.printStackTrace();
            return C0483h.m4036b(C0483h.m4033a(encoded));
        }
        return C0483h.m4036b(C0483h.m4033a(encoded));
    }

    /* renamed from: b */
    public String m4005b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ia=1&");
        if (f2943i != null && f2943i.length() > 0) {
            stringBuilder.append("key=");
            stringBuilder.append(f2943i);
            stringBuilder.append("&");
        }
        stringBuilder.append("ct=android");
        String deviceId = f2937c.getDeviceId();
        String subscriberId = f2937c.getSubscriberId();
        stringBuilder.append("&ime=" + deviceId);
        stringBuilder.append("&sim=" + subscriberId);
        stringBuilder.append("&pkg=" + f2939e);
        stringBuilder.append("&mod=");
        stringBuilder.append(m4007d());
        stringBuilder.append("&sv=");
        stringBuilder.append(m4006c());
        stringBuilder.append("&nt=");
        stringBuilder.append(m4008e());
        deviceId = f2937c.getNetworkOperatorName();
        stringBuilder.append("&np=");
        stringBuilder.append(deviceId);
        stringBuilder.append("&ctm=" + System.currentTimeMillis());
        stringBuilder.append("&re=" + f2940f);
        stringBuilder.append("&av=V2.3.0");
        stringBuilder.append("&apn=" + f2941g);
        stringBuilder.append("&apv=" + f2942h);
        stringBuilder.append("&pro=sea");
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public String m4006c() {
        return VERSION.RELEASE;
    }

    /* renamed from: d */
    public String m4007d() {
        return Build.MODEL;
    }

    /* renamed from: e */
    public String m4008e() {
        if (f2936b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return bi_常量类.f6358b_空串;
        }
        if (f2938d == null) {
            return bi_常量类.f6358b_空串;
        }
        NetworkInfo activeNetworkInfo = f2938d.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return bi_常量类.f6358b_空串;
        }
        return activeNetworkInfo.getTypeName();
    }

    /* renamed from: f */
    public String m4009f() {
        return f2943i;
    }

    /* renamed from: b */
    public static String m4000b(Context context) {
        if (f2943i == null || f2943i.equals(bi_常量类.f6358b_空串)) {
            try {
                f2943i = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.amap.api.v2.apikey");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f2943i;
    }

    /* renamed from: g */
    public static String m4001g() {
        String str = bi_常量类.f6358b_空串;
        try {
            PackageManager packageManager = f2936b.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(f2936b.getPackageName(), 0));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: h */
    public String m4010h() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f2944j).append(f2939e);
        return stringBuffer.toString();
    }

    /* renamed from: i */
    public static String m4002i() {
        PackageManager packageManager = f2936b.getPackageManager();
        String str = bi_常量类.f6358b_空串;
        try {
            return packageManager.getPackageInfo(f2936b.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }
}
