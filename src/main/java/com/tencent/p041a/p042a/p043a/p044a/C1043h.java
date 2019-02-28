package com.tencent.p041a.p042a.p043a.p044a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.tencent.wxop.stat.common.C1187f;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.a.a.a.a.h */
public final class C1043h {
    /* renamed from: a */
    static String m7495a(Context context) {
        try {
            if (C1043h.m7498a(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
            Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            Log.w("MID", th);
        }
        return bi_常量类.f6358b_空串;
    }

    /* renamed from: a */
    private static void m7496a(String str, Throwable th) {
        Log.e("MID", str, th);
    }

    /* renamed from: a */
    static void m7497a(JSONObject jSONObject, String str, String str2) {
        if (C1043h.m7500b(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /* renamed from: a */
    static boolean m7498a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            C1043h.m7496a("checkPermission error", th);
            return false;
        }
    }

    /* renamed from: b */
    static String m7499b(Context context) {
        if (C1043h.m7498a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? bi_常量类.f6358b_空串 : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                Log.i("MID", "get wifi address error" + e);
                return bi_常量类.f6358b_空串;
            }
        }
        Log.i("MID", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return bi_常量类.f6358b_空串;
    }

    /* renamed from: b */
    static boolean m7500b(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* renamed from: c */
    public static boolean m7501c(String str) {
        return str != null && str.trim().length() >= 40;
    }

    /* renamed from: f */
    static String m7502f(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C1187f.m8259b(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", bi_常量类.f6358b_空串).replace("\n", bi_常量类.f6358b_空串).replace("\r", bi_常量类.f6358b_空串);
        } catch (Throwable th) {
            C1043h.m7496a("decode error", th);
            return str;
        }
    }

    /* renamed from: g */
    static String m7503g(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(C1187f.m8257a(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", bi_常量类.f6358b_空串).replace("\n", bi_常量类.f6358b_空串).replace("\r", bi_常量类.f6358b_空串);
        } catch (Throwable th) {
            C1043h.m7496a("decode error", th);
            return str;
        }
    }
}
