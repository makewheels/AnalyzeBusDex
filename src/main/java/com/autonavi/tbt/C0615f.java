package com.autonavi.tbt;

import android.content.Context;
import android.os.Environment;
import android.util.TypedValue;
import com.amap.api.navi.model.NaviLatLng;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import p054u.aly.bi_常量类;

/* compiled from: NaviUtil */
/* renamed from: com.autonavi.tbt.f */
public class C0615f {
    /* renamed from: a */
    public static String f3785a = bi_常量类.f6358b;
    /* renamed from: b */
    public static float f3786b = 1.0f;
    /* renamed from: c */
    public static int[] f3787c = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    /* renamed from: d */
    public static double[] f3788d = new double[]{7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};
    /* renamed from: e */
    private static String[] f3789e = new String[]{"com.amap.api.navi", "com.autonavi.tbt"};
    /* renamed from: f */
    private static int f3790f = 2048;
    /* renamed from: g */
    private static double f3791g = 1.0E-5d;

    /* renamed from: a */
    public static String[] m4836a() {
        return (String[]) f3789e.clone();
    }

    /* renamed from: a */
    public static void m4835a(Object... objArr) {
    }

    /* renamed from: a */
    public static void m4834a(Throwable th) {
    }

    /* renamed from: b */
    public static String m4838b() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /* renamed from: a */
    public static String m4829a(int i) {
        if (i == 0) {
            return "0米";
        }
        if (i < 100) {
            return i + "米";
        }
        if (100 <= i && i < 1000) {
            return i + "米";
        }
        if (1000 <= i && i < 10000) {
            return (((double) ((i / 10) * 10)) / 1000.0d) + "公里";
        }
        if (10000 > i || i >= 100000) {
            return (i / 1000) + "公里";
        }
        return (((double) ((i / 100) * 100)) / 1000.0d) + "公里";
    }

    /* renamed from: a */
    public static String m4830a(int i, String str, String str2) {
        if (i == 0) {
            return "<font color='" + str + "' ><B>0</B></font><font color ='" + str2 + "'>米</font>";
        }
        if (i < 100) {
            return "<font color='" + str + "'><B>" + i + "</B></font><font color ='" + str2 + "'>米</font>";
        }
        if (100 <= i && i < 1000) {
            return "<font color='" + str + "'><B>" + ((i / 10) * 10) + "</B></font><font color ='" + str2 + "'>米</font>";
        }
        if (1000 <= i && i < 10000) {
            return "<font color='" + str + "'><B>" + (((double) ((i / 10) * 10)) / 1000.0d) + "</B></font><font color ='" + str2 + "'>公里</font>";
        }
        if (10000 > i || i >= 100000) {
            return "<font color='" + str + "'><B>" + (i / 1000) + "</B></font><font color ='" + str2 + "'>公里</font>";
        }
        return "<font color='" + str + "'><B>" + (((double) ((i / 100) * 100)) / 1000.0d) + "</B></font><font color ='" + str2 + "'>公里</font>";
    }

    /* renamed from: a */
    public static String m4831a(String str) {
        if (str == null) {
            return bi_常量类.f6358b;
        }
        String[] split = str.split(":");
        StringBuffer stringBuffer = new StringBuffer();
        if (split != null && split.length > 2) {
            int indexOf;
            String str2;
            String substring;
            if (!"00".equals(split[0])) {
                if (split[0].indexOf("0") != -1) {
                    indexOf = split[0].indexOf("0");
                    str2 = bi_常量类.f6358b;
                    if (indexOf + 1 < split[0].length()) {
                        substring = split[0].substring(indexOf + 1);
                    } else {
                        substring = split[0];
                    }
                    stringBuffer.append(substring + "小时");
                } else {
                    stringBuffer.append(split[0] + "小时");
                }
            }
            if (!"00".equals(split[1])) {
                if (split[1].indexOf("0") != -1) {
                    indexOf = split[1].indexOf("0");
                    str2 = bi_常量类.f6358b;
                    if (indexOf + 1 < split[1].length()) {
                        substring = split[1].substring(indexOf + 1);
                    } else {
                        substring = split[1];
                    }
                    stringBuffer.append(substring + "分钟");
                } else {
                    stringBuffer.append(split[1] + "分钟");
                }
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m4832a(String str, String str2, String str3) {
        if (str == null) {
            return bi_常量类.f6358b;
        }
        String[] split = str.split(":");
        StringBuffer stringBuffer = new StringBuffer();
        if (split != null && split.length > 2) {
            int indexOf;
            String str4;
            String str5;
            if (!"00".equals(split[0])) {
                if (split[0].indexOf("0") != -1) {
                    indexOf = split[0].indexOf("0");
                    str4 = bi_常量类.f6358b;
                    if (indexOf != 0 || indexOf + 1 >= split[0].length()) {
                        str5 = split[0];
                    } else {
                        str5 = split[0].substring(indexOf + 1);
                    }
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + str5 + "</B></font><font color ='" + str3 + "'>小时</font>");
                } else {
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + split[0] + "</B></font><font color ='" + str3 + "'>小时</font>");
                }
            }
            if (!"00".equals(split[1])) {
                if (split[1].indexOf("0") != -1) {
                    indexOf = split[1].indexOf("0");
                    str4 = bi_常量类.f6358b;
                    if (indexOf + 1 < split[1].length()) {
                        str5 = split[1].substring(indexOf + 1);
                    } else {
                        str5 = split[1];
                    }
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + str5 + "</B></font><font color ='" + str3 + "'>分钟</font>");
                } else {
                    stringBuffer.append("<font color='" + str2 + "' ><B>" + split[1] + "</B></font><font color ='" + str3 + "'>分钟</font>");
                }
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m4839b(int i) {
        int abs = Math.abs(i);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = abs / 3600;
        if (i2 == 0) {
            stringBuffer.append("00:");
        }
        if (i2 > 0) {
            stringBuffer.append(C0615f.m4840c(i2) + ":");
        }
        abs %= 3600;
        stringBuffer.append(C0615f.m4840c((abs + 59) / 60) + ":");
        stringBuffer.append(C0615f.m4840c(abs % 60));
        return stringBuffer.toString();
    }

    /* renamed from: c */
    private static String m4840c(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return bi_常量类.f6358b + i;
    }

    /* renamed from: a */
    public static NaviLatLng m4827a(double d, double d2, double d3, double d4) {
        double d5;
        double d6 = 0.0d;
        if (d <= 0.0d || d2 <= 0.0d || d3 <= 0.0d || d4 <= 0.0d) {
            d5 = 0.0d;
        } else {
            d5 = (d + d3) / 2.0d;
            d6 = (d2 + d4) / 2.0d;
        }
        return new NaviLatLng(d5, d6);
    }

    /* renamed from: a */
    public static NaviLatLng m4828a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2, double d) {
        double a = (double) C0615f.m4826a(naviLatLng, naviLatLng2);
        NaviLatLng naviLatLng3 = new NaviLatLng();
        a = d / a;
        naviLatLng3.setLatitude(((naviLatLng2.getLatitude() - naviLatLng.getLatitude()) * a) + naviLatLng.getLatitude());
        naviLatLng3.setLongitude((a * (naviLatLng2.getLongitude() - naviLatLng.getLongitude())) + naviLatLng.getLongitude());
        return naviLatLng3;
    }

    /* renamed from: a */
    public static int m4826a(NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        return C0615f.m4837b(naviLatLng.getLongitude(), naviLatLng.getLatitude(), naviLatLng2.getLongitude(), naviLatLng2.getLatitude());
    }

    /* renamed from: b */
    public static int m4837b(double d, double d2, double d3, double d4) {
        double d5 = 0.01745329251994329d * d;
        double d6 = 0.01745329251994329d * d2;
        double d7 = 0.01745329251994329d * d3;
        double d8 = 0.01745329251994329d * d4;
        double sin = Math.sin(d5);
        double sin2 = Math.sin(d6);
        d5 = Math.cos(d5);
        d6 = Math.cos(d6);
        double sin3 = Math.sin(d7);
        double sin4 = Math.sin(d8);
        d7 = Math.cos(d7);
        d8 = Math.cos(d8);
        double[] dArr = new double[]{(d5 * d6) - (d7 * d8), (d6 * sin) - (d8 * sin3), sin2 - sin4};
        return (int) (Math.asin(Math.sqrt(((dArr[0] * dArr[0]) + (dArr[1] * dArr[1])) + (dArr[2] * dArr[2])) / 2.0d) * 1.27420015798544E7d);
    }

    /* renamed from: a */
    public static void m4833a(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
            f3786b = 0.5f;
        } else if (i <= 160) {
            f3786b = 0.6f;
        } else if (i <= 240) {
            f3786b = 0.8f;
        } else if (i <= ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE) {
            f3786b = 0.9f;
        } else {
            f3786b = 1.0f;
        }
    }

    /* renamed from: a */
    public static int m4825a(Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
