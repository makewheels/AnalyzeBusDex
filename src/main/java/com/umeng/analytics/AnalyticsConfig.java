package com.umeng.analytics;

import android.content.Context;
import p054u.aly.bi_常量类;

public class AnalyticsConfig {
    public static boolean ACTIVITY_DURATION_OPEN = true;
    public static boolean CATCH_EXCEPTION = true;
    public static boolean COMPRESS_DATA = true;
    public static boolean ENABLE_MEMORY_BUFFER = true;
    public static String GPU_RENDERER = bi_常量类.f6358b_空串;
    public static String GPU_VENDER = bi_常量类.f6358b_空串;
    /* renamed from: a */
    private static String f5562a = null;
    /* renamed from: b */
    private static String f5563b = null;
    /* renamed from: c */
    private static double[] f5564c = null;
    /* renamed from: d */
    private static int[] f5565d;
    public static long kContinueSessionMillis = 30000;
    public static int mVerticalType;
    public static String mWrapperType = null;
    public static String mWrapperVersion = null;
    public static int sAge;
    public static Gender sGender;
    public static String sId;
    public static String sSource;

    public static void setAppkey(String str) {
        f5562a = str;
    }

    public static void setChannel(String str) {
        f5563b = str;
    }

    public static String getAppkey(Context context) {
        if (f5562a == null) {
            f5562a = bi_常量类.m9990o(context);
        }
        return f5562a;
    }

    public static String getChannel(Context context) {
        if (f5563b == null) {
            f5563b = bi_常量类.m9995t(context);
        }
        return f5563b;
    }

    public static double[] getLocation() {
        return f5564c;
    }

    public static void setLocation(double d, double d2) {
        if (f5564c == null) {
            f5564c = new double[2];
        }
        f5564c[0] = d;
        f5564c[1] = d2;
    }

    public static void setReportPolicy(int i, int i2) {
        if (f5565d == null) {
            f5565d = new int[2];
        }
        f5565d[0] = i;
        f5565d[1] = i2;
    }

    public static int[] getReportPolicy(Context context) {
        if (f5565d == null) {
            f5565d = C1245f.m8407a(context).m8416a();
        }
        return f5565d;
    }
}
