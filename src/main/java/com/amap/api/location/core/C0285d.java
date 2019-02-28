package com.amap.api.location.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import com.alipay.sdk.cons.C0108a;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.services.district.DistrictSearchQuery;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: CoreUtil */
/* renamed from: com.amap.api.location.core.d */
public class C0285d {
    /* renamed from: a */
    static int f1310a = 2048;
    /* renamed from: b */
    static String f1311b = null;
    /* renamed from: c */
    private static SharedPreferences f1312c = null;
    /* renamed from: d */
    private static Editor f1313d = null;
    /* renamed from: e */
    private static Method f1314e;

    /* renamed from: a */
    public static boolean m1846a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            State state = activeNetworkInfo.getState();
            if (state == null || state == State.DISCONNECTED || state == State.DISCONNECTING) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static AMapLocation m1847b(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("last_know_location", 0);
            AMapLocation aMapLocation = new AMapLocation(bi_常量类.f6358b_空串);
            aMapLocation.setProvider(LocationProviderProxy.AMapNetwork);
            double parseDouble = Double.parseDouble(sharedPreferences.getString("last_know_lat", "0.0"));
            double parseDouble2 = Double.parseDouble(sharedPreferences.getString("last_know_lng", "0.0"));
            aMapLocation.setLatitude(parseDouble);
            aMapLocation.setLongitude(parseDouble2);
            aMapLocation.setProvince(sharedPreferences.getString(DistrictSearchQuery.KEYWORDS_PROVINCE, bi_常量类.f6358b_空串));
            aMapLocation.setCity(sharedPreferences.getString(DistrictSearchQuery.KEYWORDS_CITY, bi_常量类.f6358b_空串));
            aMapLocation.setDistrict(sharedPreferences.getString(DistrictSearchQuery.KEYWORDS_DISTRICT, bi_常量类.f6358b_空串));
            aMapLocation.setCityCode(sharedPreferences.getString("cityCode", bi_常量类.f6358b_空串));
            aMapLocation.setAdCode(sharedPreferences.getString("adCode", bi_常量类.f6358b_空串));
            aMapLocation.setAccuracy(sharedPreferences.getFloat("accuracy", 0.0f));
            aMapLocation.setTime(sharedPreferences.getLong("time", 0));
            return aMapLocation;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m1843a(Context context, AMapLocation aMapLocation) {
        try {
            if (f1312c == null) {
                f1312c = context.getSharedPreferences("last_know_location", 0);
            }
            if (f1313d == null) {
                f1313d = f1312c.edit();
            }
            f1313d.putString("last_know_lat", String.valueOf(aMapLocation.getLatitude()));
            f1313d.putString("last_know_lng", String.valueOf(aMapLocation.getLongitude()));
            f1313d.putString(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
            f1313d.putString(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
            f1313d.putString(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
            f1313d.putString("cityCode", aMapLocation.getCityCode());
            f1313d.putString("adCode", aMapLocation.getAdCode());
            f1313d.putFloat("accuracy", aMapLocation.getAccuracy());
            f1313d.putLong("time", aMapLocation.getTime());
            C0285d.m1844a(f1313d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m1844a(Editor editor) {
        if (editor != null) {
            if (VERSION.SDK_INT >= 9) {
                try {
                    if (f1314e == null) {
                        f1314e = Editor.class.getDeclaredMethod("apply", new Class[0]);
                    }
                    f1314e.invoke(editor, new Object[0]);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    editor.commit();
                    return;
                }
            }
            editor.commit();
        }
    }

    /* renamed from: a */
    public static String m1841a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = C0108a.f262e;
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m1842a(String str, String str2) {
        String str3 = null;
        try {
            if (f1311b == null || f1311b.length() == 0) {
                f1311b = C0284c.m1822a(null).m1840i();
            }
            str3 = C0288g.m1860a(f1311b + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str3;
    }

    /* renamed from: a */
    public static void m1845a(String str) throws AMapLocException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") && jSONObject.has("info")) {
                String string = jSONObject.getString("status");
                String string2 = jSONObject.getString("info");
                if (!string.equals(C0108a.f262e) && string.equals("0")) {
                    if (string2.equals("INVALID_USER_KEY") || string2.equals("INSUFFICIENT_PRIVILEGES") || string2.equals("USERKEY_PLAT_NOMATCH") || string2.equals("INVALID_USER_SCODE")) {
                        throw new AMapLocException("key鉴权失败");
                    } else if (string2.equals("SERVICE_NOT_EXIST") || string2.equals("SERVICE_RESPONSE_ERROR") || string2.equals("OVER_QUOTA") || string2.equals("UNKNOWN_ERROR")) {
                        throw new AMapLocException("未知的错误");
                    } else if (string2.equals("INVALID_PARAMS")) {
                        throw new AMapLocException("无效的参数 - IllegalArgumentException");
                    }
                }
            }
        } catch (JSONException e) {
        }
    }
}
