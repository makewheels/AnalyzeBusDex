package com.umeng.analytics.social;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0110c;
import com.umeng.analytics.C1233a;
import com.umeng.analytics.onlineconfig.C1248a;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: UMUtils */
/* renamed from: com.umeng.analytics.social.f */
public abstract class C1269f {
    /* renamed from: a */
    private static Map<String, String> f5717a;

    /* renamed from: a */
    protected static String[] m8493a(Context context, String str, UMPlatformData... uMPlatformDataArr) throws C1264a {
        if (uMPlatformDataArr == null || uMPlatformDataArr.length == 0) {
            throw new C1264a("platform data is null");
        }
        Object a = C1269f.m8489a(context);
        if (TextUtils.isEmpty(a)) {
            throw new C1264a("can`t get appkey.");
        }
        List arrayList = new ArrayList();
        String str2 = "http://log.umsns.com/share/api/" + a + "/";
        if (f5717a == null || f5717a.isEmpty()) {
            f5717a = C1269f.m8496c(context);
        }
        if (!(f5717a == null || f5717a.isEmpty())) {
            for (Entry entry : f5717a.entrySet()) {
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        arrayList.add(new BasicNameValuePair("date", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair(C1248a.f5656c, C1268e.f5699e));
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new BasicNameValuePair("topic", str));
        }
        arrayList.addAll(C1269f.m8491a(uMPlatformDataArr));
        String b = C1269f.m8494b(uMPlatformDataArr);
        if (b == null) {
            b = "null";
        }
        C1265b.m8473c(C1233a.f5589e, "URL:" + (str2 + "?" + C1269f.m8490a(arrayList)));
        C1265b.m8473c(C1233a.f5589e, "BODY:" + b);
        return new String[]{r1, b};
    }

    /* renamed from: a */
    private static String m8490a(List<NameValuePair> list) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new UrlEncodedFormEntity(list, "UTF-8").writeTo(byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static List<NameValuePair> m8491a(UMPlatformData... uMPlatformDataArr) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            stringBuilder.append(uMPlatformData.getMeida().toString());
            stringBuilder.append(',');
            stringBuilder2.append(uMPlatformData.getUsid());
            stringBuilder2.append(',');
            stringBuilder3.append(uMPlatformData.getWeiboId());
            stringBuilder3.append(',');
        }
        if (uMPlatformDataArr.length > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            stringBuilder3.deleteCharAt(stringBuilder3.length() - 1);
        }
        List<NameValuePair> arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("platform", stringBuilder.toString()));
        arrayList.add(new BasicNameValuePair("usid", stringBuilder2.toString()));
        if (stringBuilder3.length() > 0) {
            arrayList.add(new BasicNameValuePair("weiboid", stringBuilder3.toString()));
        }
        return arrayList;
    }

    /* renamed from: b */
    private static String m8494b(UMPlatformData... uMPlatformDataArr) {
        JSONObject jSONObject = new JSONObject();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            GENDER gender = uMPlatformData.getGender();
            CharSequence name = uMPlatformData.getName();
            if (gender == null) {
                try {
                    if (TextUtils.isEmpty(name)) {
                    }
                } catch (Throwable e) {
                    throw new C1264a("build body exception", e);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("gender", gender == null ? bi_常量类.f6358b_空串 : String.valueOf(gender.value));
            jSONObject2.put(C0110c.f289e, name == null ? bi_常量类.f6358b_空串 : String.valueOf(name));
            jSONObject.put(uMPlatformData.getMeida().toString(), jSONObject2);
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: c */
    private static Map<String, String> m8496c(Context context) throws C1264a {
        Map<String, String> hashMap = new HashMap();
        Map b = C1269f.m8495b(context);
        if (b == null || b.isEmpty()) {
            throw new C1264a("can`t get device id.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry entry : b.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getValue())) {
                stringBuilder2.append((String) entry.getKey()).append(",");
                stringBuilder.append((String) entry.getValue()).append(",");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            hashMap.put("deviceid", stringBuilder.toString());
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            hashMap.put("idtype", stringBuilder2.toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    protected static String m8489a(Context context) {
        Object obj = C1268e.f5698d;
        if (TextUtils.isEmpty(obj)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                    if (string != null) {
                        return string.trim();
                    }
                    C1265b.m8471b(C1233a.f5589e, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
                }
            } catch (Exception e) {
                C1265b.m8472b(C1233a.f5589e, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", e);
            }
            return null;
        }
        C1265b.m8471b(C1233a.f5589e, "use usefully appkey from constant field.");
        return obj;
    }

    /* renamed from: b */
    public static Map<String, String> m8495b(Context context) {
        CharSequence deviceId;
        CharSequence d;
        CharSequence string;
        Map<String, String> hashMap = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            C1265b.m8477e(C1233a.f5589e, "No IMEI.");
        }
        try {
            if (C1269f.m8492a(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = telephonyManager.getDeviceId();
                d = C1269f.m8497d(context);
                string = Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(d)) {
                    hashMap.put("mac", d);
                }
                if (!TextUtils.isEmpty(deviceId)) {
                    hashMap.put("imei", deviceId);
                }
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put("android_id", string);
                }
                return hashMap;
            }
        } catch (Exception e) {
            C1265b.m8478e(C1233a.f5589e, "No IMEI.", e);
        }
        deviceId = null;
        d = C1269f.m8497d(context);
        string = Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(d)) {
            hashMap.put("mac", d);
        }
        if (TextUtils.isEmpty(deviceId)) {
            hashMap.put("imei", deviceId);
        }
        if (TextUtils.isEmpty(string)) {
            hashMap.put("android_id", string);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static boolean m8492a(Context context, String str) {
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private static String m8497d(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (C1269f.m8492a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            C1265b.m8477e(C1233a.f5589e, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return bi_常量类.f6358b_空串;
        } catch (Exception e) {
            C1265b.m8477e(C1233a.f5589e, "Could not get mac address." + e.toString());
        }
    }
}
