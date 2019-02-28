package com.tencent.smtt.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.b */
public class C1135b {
    /* renamed from: a */
    public static String f5119a = bi_常量类.f6358b;
    /* renamed from: b */
    public static String f5120b = bi_常量类.f6358b;
    /* renamed from: c */
    public static String f5121c = bi_常量类.f6358b;
    /* renamed from: d */
    public static String f5122d = bi_常量类.f6358b;
    /* renamed from: e */
    public static String f5123e = bi_常量类.f6358b;

    /* renamed from: a */
    public static String m7947a() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        BufferedReader bufferedReader2 = null;
        if (!TextUtils.isEmpty(f5121c)) {
            return f5121c;
        }
        String a;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Throwable th22) {
                th = th22;
                try {
                    a = C1135b.m7950a(System.getProperty("os.arch"));
                    th.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                        }
                    }
                    if (inputStreamReader != null) {
                        return a;
                    }
                    inputStreamReader.close();
                    return a;
                } catch (Throwable th3) {
                    th22 = th3;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th22;
                }
            }
            try {
                a = bufferedReader.readLine().contains("x86") ? C1135b.m7950a("i686") : C1135b.m7950a(System.getProperty("os.arch"));
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                if (inputStreamReader == null) {
                    return a;
                }
                try {
                    inputStreamReader.close();
                    return a;
                } catch (IOException e5) {
                    return a;
                }
            } catch (Throwable th4) {
                th22 = th4;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                throw th22;
            }
        } catch (Throwable th5) {
            th22 = th5;
            inputStreamReader = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th22;
        }
    }

    /* renamed from: a */
    public static String m7948a(Context context) {
        String str = null;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: a */
    public static String m7949a(Context context, String str) {
        String str2 = null;
        try {
            try {
                str2 = String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str)))));
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
        return str2;
    }

    /* renamed from: a */
    private static String m7950a(String str) {
        return str == null ? bi_常量类.f6358b : str;
    }

    /* renamed from: b */
    public static int m7951b(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: c */
    public static String m7952c(Context context) {
        String str = bi_常量类.f6358b;
        if (!TextUtils.isEmpty(f5119a)) {
            return f5119a;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: d */
    public static String m7953d(Context context) {
        String str = bi_常量类.f6358b;
        if (!TextUtils.isEmpty(f5120b)) {
            return f5120b;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: e */
    public static String m7954e(Context context) {
        String str = bi_常量类.f6358b;
        if (!TextUtils.isEmpty(f5122d)) {
            return f5122d;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            return connectionInfo == null ? bi_常量类.f6358b : connectionInfo.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: f */
    public static String m7955f(Context context) {
        if (!TextUtils.isEmpty(f5123e)) {
            return f5123e;
        }
        try {
            f5123e = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f5123e;
    }
}
