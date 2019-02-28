package com.alipay.security.mobile.module.p012b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.alipay.security.mobile.module.p010a.C0159a;
import java.io.File;

/* renamed from: com.alipay.security.mobile.module.b.c */
public final class C0165c {
    /* renamed from: a */
    private static C0165c f485a = new C0165c();

    private C0165c() {
    }

    /* renamed from: a */
    public static C0165c m593a() {
        return f485a;
    }

    /* renamed from: a */
    private static String m594a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (Exception e) {
            return str2;
        }
    }

    /* renamed from: a */
    public static boolean m595a(Context context) {
        try {
            if (Build.HARDWARE.contains("goldfish") || Build.PRODUCT.contains("sdk") || Build.FINGERPRINT.contains("generic")) {
                return true;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                Object obj;
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    int length = deviceId.length();
                    if (length != 0) {
                        int i = 0;
                        while (i < length) {
                            if (!Character.isWhitespace(deviceId.charAt(i)) && deviceId.charAt(i) != '0') {
                                obj = null;
                                break;
                            }
                            i++;
                        }
                        i = 1;
                        if (obj != null) {
                            return true;
                        }
                    }
                }
                obj = 1;
                if (obj != null) {
                    return true;
                }
            }
            return C0159a.m556a(Secure.getString(context.getContentResolver(), "android_id"));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static String m596b() {
        return "android";
    }

    /* renamed from: c */
    public static boolean m597c() {
        String[] strArr = new String[]{"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 5) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    return true;
                }
                i++;
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* renamed from: d */
    public static String m598d() {
        return Build.BOARD;
    }

    /* renamed from: e */
    public static String m599e() {
        return Build.BRAND;
    }

    /* renamed from: f */
    public static String m600f() {
        return Build.DEVICE;
    }

    /* renamed from: g */
    public static String m601g() {
        return Build.DISPLAY;
    }

    /* renamed from: h */
    public static String m602h() {
        return VERSION.INCREMENTAL;
    }

    /* renamed from: i */
    public static String m603i() {
        return Build.MANUFACTURER;
    }

    /* renamed from: j */
    public static String m604j() {
        return Build.MODEL;
    }

    /* renamed from: k */
    public static String m605k() {
        return Build.PRODUCT;
    }

    /* renamed from: l */
    public static String m606l() {
        return VERSION.RELEASE;
    }

    /* renamed from: m */
    public static String m607m() {
        return VERSION.SDK;
    }

    /* renamed from: n */
    public static String m608n() {
        return Build.TAGS;
    }

    /* renamed from: o */
    public static String m609o() {
        return C0165c.m594a("ro.kernel.qemu", "0");
    }
}
