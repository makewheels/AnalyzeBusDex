package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.sys.C0137c;
import com.alipay.sdk.tid.C0139b;
import com.alipay.sdk.util.C0141b;
import com.alipay.sdk.util.C0150k;
import com.ta.utdid2.device.UTDevice;
import java.util.HashMap;
import java.util.Random;
import p054u.aly.bi;

/* renamed from: com.alipay.sdk.data.d */
public final class C0114d {
    /* renamed from: d */
    private static final String f309d = "virtualImeiAndImsi";
    /* renamed from: e */
    private static final String f310e = "virtual_imei";
    /* renamed from: f */
    private static final String f311f = "virtual_imsi";
    /* renamed from: g */
    private static C0114d f312g;
    /* renamed from: a */
    String f313a;
    /* renamed from: b */
    String f314b = "sdk-and-lite";
    /* renamed from: c */
    String f315c;

    private C0114d() {
    }

    /* renamed from: a */
    public static synchronized C0114d m315a() {
        C0114d c0114d;
        synchronized (C0114d.class) {
            if (f312g == null) {
                f312g = new C0114d();
            }
            c0114d = f312g;
        }
        return c0114d;
    }

    /* renamed from: a */
    private static String m316a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    /* renamed from: a */
    static String m317a(Context context, HashMap<String, String> hashMap) {
        String str = bi.f6358b;
        try {
            str = SecurityClientMobile.GetApdid(context, hashMap);
        } catch (Exception e) {
        }
        "apdid:" + str;
        return str;
    }

    /* renamed from: a */
    private String m318a(C0139b c0139b) {
        String d;
        String str;
        Context context = C0136b.m459a().f414a;
        C0141b a = C0141b.m491a(context);
        if (TextUtils.isEmpty(this.f313a)) {
            String a2 = C0150k.m521a();
            String b = C0150k.m527b();
            d = C0150k.m532d(context);
            str = C0108a.f259b;
            this.f313a = "Msp/10.0.0" + " (" + a2 + ";" + b + ";" + d + ";" + str.substring(0, str.indexOf("://")) + ";" + C0150k.m534e(context) + ";" + Float.toString(new TextView(context).getTextSize());
        }
        d = C0141b.m493b(context).m514a();
        str = "-1;-1";
        String str2 = C0108a.f262e;
        String a3 = a.m497a();
        String b2 = a.m498b();
        Context context2 = C0136b.m459a().f414a;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(f309d, 0);
        CharSequence string = sharedPreferences.getString(f311f, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(C0139b.m480a().f422a)) {
                Object utdid = UTDevice.getUtdid(C0136b.m459a().f414a);
                string = TextUtils.isEmpty(utdid) ? C0114d.m319b() : utdid.substring(3, 18);
            } else {
                string = C0141b.m491a(context2).m497a();
            }
            sharedPreferences.edit().putString(f311f, string).commit();
        }
        CharSequence charSequence = string;
        Context context3 = C0136b.m459a().f414a;
        SharedPreferences sharedPreferences2 = context3.getSharedPreferences(f309d, 0);
        string = sharedPreferences2.getString(f310e, null);
        if (TextUtils.isEmpty(string)) {
            string = TextUtils.isEmpty(C0139b.m480a().f422a) ? C0114d.m319b() : C0141b.m491a(context3).m498b();
            sharedPreferences2.edit().putString(f310e, string).commit();
        }
        CharSequence charSequence2 = string;
        if (c0139b != null) {
            this.f315c = c0139b.f423b;
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean b3 = C0136b.m461b();
        String c = a.m499c();
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo != null ? connectionInfo.getSSID() : "-1";
        connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        String bssid = connectionInfo != null ? connectionInfo.getBSSID() : "00";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f313a).append(";").append(d).append(";").append(str).append(";").append(str2).append(";").append(a3).append(";").append(b2).append(";").append(this.f315c).append(";").append(replace).append(";").append(replace2).append(";").append(b3).append(";").append(c).append(";").append(C0137c.m467a()).append(";").append(this.f314b).append(";").append(charSequence).append(";").append(charSequence2).append(";").append(ssid).append(";").append(bssid);
        if (c0139b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(C0109b.f277c, c0139b.f422a);
            hashMap.put(C0109b.f281g, UTDevice.getUtdid(C0136b.m459a().f414a));
            utdid = C0114d.m317a(context, hashMap);
            if (!TextUtils.isEmpty(utdid)) {
                stringBuilder.append(";").append(utdid);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    static String m319b() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    /* renamed from: b */
    private static String m320b(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    /* renamed from: c */
    private String m321c() {
        return this.f315c;
    }

    /* renamed from: c */
    private static String m322c(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    /* renamed from: d */
    private static String m323d() {
        return C0108a.f262e;
    }

    /* renamed from: e */
    private static String m324e() {
        Context context = C0136b.m459a().f414a;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f309d, 0);
        String string = sharedPreferences.getString(f310e, null);
        if (TextUtils.isEmpty(string)) {
            string = TextUtils.isEmpty(C0139b.m480a().f422a) ? C0114d.m319b() : C0141b.m491a(context).m498b();
            sharedPreferences.edit().putString(f310e, string).commit();
        }
        return string;
    }

    /* renamed from: f */
    private static String m325f() {
        Context context = C0136b.m459a().f414a;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f309d, 0);
        String string = sharedPreferences.getString(f311f, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(C0139b.m480a().f422a)) {
                Object utdid = UTDevice.getUtdid(C0136b.m459a().f414a);
                string = TextUtils.isEmpty(utdid) ? C0114d.m319b() : utdid.substring(3, 18);
            } else {
                string = C0141b.m491a(context).m497a();
            }
            sharedPreferences.edit().putString(f311f, string).commit();
        }
        return string;
    }

    /* renamed from: a */
    public final synchronized void m326a(String str) {
        if (!TextUtils.isEmpty(str)) {
            PreferenceManager.getDefaultSharedPreferences(C0136b.m459a().f414a).edit().putString(C0109b.f283i, str).commit();
            C0108a.f260c = str;
        }
    }
}
