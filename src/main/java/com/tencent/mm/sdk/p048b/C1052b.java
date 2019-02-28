package com.tencent.mm.sdk.p048b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.mm.sdk.b.b */
public final class C1052b {
    private static C1051a aG;
    private static C1051a aH;
    private static final String aI;
    private static int level = 6;

    /* renamed from: com.tencent.mm.sdk.b.b$a */
    public interface C1051a {
        /* renamed from: f */
        void mo1707f(String str, String str2);

        /* renamed from: g */
        void mo1708g(String str, String str2);

        int getLogLevel();

        /* renamed from: h */
        void mo1710h(String str, String str2);

        /* renamed from: i */
        void mo1711i(String str, String str2);
    }

    static {
        C1051a c1053c = new C1053c();
        aG = c1053c;
        aH = c1053c;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        aI = stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m7514a(String str, String str2, Object... objArr) {
        if (aH != null && aH.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = bi_常量类.f6358b;
            }
            C1051a c1051a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c1051a.mo1711i(str, format);
        }
    }

    /* renamed from: b */
    public static void m7515b(String str, String str2) {
        C1052b.m7514a(str, str2, null);
    }

    /* renamed from: c */
    public static void m7516c(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 3) {
            C1051a c1051a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c1051a.mo1710h(str, str2);
        }
    }

    /* renamed from: d */
    public static void m7517d(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 2) {
            C1051a c1051a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c1051a.mo1707f(str, str2);
        }
    }

    /* renamed from: e */
    public static void m7518e(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 1) {
            if (str2 == null) {
                str2 = bi_常量类.f6358b;
            }
            C1051a c1051a = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            c1051a.mo1708g(str, str2);
        }
    }
}
