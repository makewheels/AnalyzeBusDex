package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.sys.C0137c;
import com.alipay.sdk.tid.C0139b;
import com.alipay.sdk.util.C0141b;
import com.alipay.sdk.util.C0142c;
import com.alipay.sdk.util.C0150k;
import com.ta.utdid2.device.UTDevice;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.data.b */
public final class C0112b {
    /* renamed from: a */
    private static final String f304a = "Msp-Param";

    /* renamed from: a */
    public static C0115e m296a() {
        C0111a c0111a = new C0111a();
        c0111a.f299a = C0108a.f259b;
        c0111a.f300b = "com.alipay.mobilecashier";
        c0111a.f301c = "/device/findAccount";
        c0111a.f302d = "3.0.0";
        C0136b a = C0136b.m459a();
        C0139b a2 = C0139b.m480a();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(a2.f422a)) {
                jSONObject.put(C0109b.f277c, a2.f422a);
            }
            jSONObject.put(C0109b.f281g, UTDevice.getUtdid(a.f414a));
            jSONObject.put(C0109b.f282h, C0108a.f261d);
            jSONObject.put(C0109b.f284j, a2.f423b);
            jSONObject.put("imei", C0141b.m491a(a.f414a).m498b());
            jSONObject.put("imsi", C0141b.m491a(a.f414a).m497a());
        } catch (JSONException e) {
        }
        return new C0115e(c0111a, jSONObject);
    }

    /* renamed from: a */
    public static C0115e m297a(C0113c c0113c, String str, JSONObject jSONObject) {
        C0136b a = C0136b.m459a();
        C0139b a2 = C0139b.m480a();
        JSONObject a3 = C0142c.m501a(null, jSONObject);
        try {
            String d;
            String str2;
            Object utdid;
            a3.put(C0109b.f277c, a2.f422a);
            String str3 = C0109b.f276b;
            C0114d c0114d = a.f415b;
            Context context = C0136b.m459a().f414a;
            C0141b a4 = C0141b.m491a(context);
            if (TextUtils.isEmpty(c0114d.f313a)) {
                String a5 = C0150k.m521a();
                String b = C0150k.m527b();
                d = C0150k.m532d(context);
                str2 = C0108a.f259b;
                c0114d.f313a = "Msp/10.0.0" + " (" + a5 + ";" + b + ";" + d + ";" + str2.substring(0, str2.indexOf("://")) + ";" + C0150k.m534e(context) + ";" + Float.toString(new TextView(context).getTextSize());
            }
            d = C0141b.m493b(context).m514a();
            str2 = "-1;-1";
            String str4 = C0108a.f262e;
            String a6 = a4.m497a();
            String b2 = a4.m498b();
            Context context2 = C0136b.m459a().f414a;
            SharedPreferences sharedPreferences = context2.getSharedPreferences("virtualImeiAndImsi", 0);
            CharSequence string = sharedPreferences.getString("virtual_imsi", null);
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(C0139b.m480a().f422a)) {
                    utdid = UTDevice.getUtdid(C0136b.m459a().f414a);
                    string = TextUtils.isEmpty(utdid) ? C0114d.m319b() : utdid.substring(3, 18);
                } else {
                    string = C0141b.m491a(context2).m497a();
                }
                sharedPreferences.edit().putString("virtual_imsi", string).commit();
            }
            CharSequence charSequence = string;
            context2 = C0136b.m459a().f414a;
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("virtualImeiAndImsi", 0);
            string = sharedPreferences2.getString("virtual_imei", null);
            if (TextUtils.isEmpty(string)) {
                string = TextUtils.isEmpty(C0139b.m480a().f422a) ? C0114d.m319b() : C0141b.m491a(context2).m498b();
                sharedPreferences2.edit().putString("virtual_imei", string).commit();
            }
            CharSequence charSequence2 = string;
            if (a2 != null) {
                c0114d.f315c = a2.f423b;
            }
            String replace = Build.MANUFACTURER.replace(";", " ");
            String replace2 = Build.MODEL.replace(";", " ");
            boolean b3 = C0136b.m461b();
            String c = a4.m499c();
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            String ssid = connectionInfo != null ? connectionInfo.getSSID() : "-1";
            connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            String bssid = connectionInfo != null ? connectionInfo.getBSSID() : "00";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c0114d.f313a).append(";").append(d).append(";").append(str2).append(";").append(str4).append(";").append(a6).append(";").append(b2).append(";").append(c0114d.f315c).append(";").append(replace).append(";").append(replace2).append(";").append(b3).append(";").append(c).append(";").append(C0137c.m467a()).append(";").append(c0114d.f314b).append(";").append(charSequence).append(";").append(charSequence2).append(";").append(ssid).append(";").append(bssid);
            if (a2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(C0109b.f277c, a2.f422a);
                hashMap.put(C0109b.f281g, UTDevice.getUtdid(C0136b.m459a().f414a));
                utdid = C0114d.m317a(context, hashMap);
                if (!TextUtils.isEmpty(utdid)) {
                    stringBuilder.append(";").append(utdid);
                }
            }
            stringBuilder.append(")");
            a3.put(str3, stringBuilder.toString());
            a3.put(C0109b.f279e, C0150k.m528b(a.f414a));
            a3.put(C0109b.f280f, C0150k.m523a(a.f414a));
            a3.put(C0109b.f278d, str);
            a3.put(C0109b.f282h, C0108a.f261d);
            a3.put(C0109b.f281g, UTDevice.getUtdid(a.f414a));
            a3.put(C0109b.f284j, a2.f423b);
        } catch (JSONException e) {
        }
        C0111a c0111a = new C0111a();
        c0111a.f299a = C0108a.f259b;
        c0111a.f300b = "com.alipay.mobilecashier";
        c0111a.f301c = "/cashier/main";
        c0111a.f302d = "4.0.2";
        C0115e c0115e = null;
        if (a3 != null) {
            c0115e = new C0115e(c0111a, a3);
            c0115e.f319d = true;
        }
        if (c0115e != null) {
            C0112b.m300a(c0113c, c0115e, str);
        }
        return c0115e;
    }

    /* renamed from: a */
    private static C0115e m298a(JSONObject jSONObject, boolean z) {
        C0111a c0111a = new C0111a();
        c0111a.f299a = C0108a.f259b;
        c0111a.f300b = "com.alipay.mobilecashier";
        c0111a.f301c = "/cashier/main";
        c0111a.f302d = "4.0.2";
        if (jSONObject == null) {
            return null;
        }
        C0115e c0115e = new C0115e(c0111a, jSONObject);
        c0115e.f319d = z;
        return c0115e;
    }

    /* renamed from: a */
    private static String m299a(String str) {
        return !str.contains("biz_type") ? null : C0112b.m305d(str);
    }

    /* renamed from: a */
    private static void m300a(C0113c c0113c, C0115e c0115e, String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("&");
            if (split.length != 0) {
                Object obj = null;
                Object obj2 = null;
                Object obj3 = null;
                Object obj4 = null;
                for (String str2 : split) {
                    if (TextUtils.isEmpty(obj4)) {
                        obj4 = !str2.contains("biz_type") ? null : C0112b.m305d(str2);
                    }
                    if (TextUtils.isEmpty(obj3)) {
                        obj3 = !str2.contains("biz_no") ? null : C0112b.m305d(str2);
                    }
                    if (TextUtils.isEmpty(obj2)) {
                        obj2 = (!str2.contains("trade_no") || str2.startsWith("out_trade_no")) ? null : C0112b.m305d(str2);
                    }
                    if (TextUtils.isEmpty(obj)) {
                        obj = !str2.contains("app_userid") ? null : C0112b.m305d(str2);
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                if (!TextUtils.isEmpty(obj4)) {
                    stringBuilder.append("biz_type=" + obj4 + ";");
                }
                if (!TextUtils.isEmpty(obj3)) {
                    stringBuilder.append("biz_no=" + obj3 + ";");
                }
                if (!TextUtils.isEmpty(obj2)) {
                    stringBuilder.append("trade_no=" + obj2 + ";");
                }
                if (!TextUtils.isEmpty(obj)) {
                    stringBuilder.append("app_userid=" + obj + ";");
                }
                if (stringBuilder.length() != 0) {
                    String stringBuilder2 = stringBuilder.toString();
                    if (stringBuilder2.endsWith(";")) {
                        stringBuilder2 = stringBuilder2.substring(0, stringBuilder2.length() - 1);
                    }
                    c0113c.f306b = new Header[]{new BasicHeader(f304a, stringBuilder2)};
                    c0115e.f317b = new WeakReference(c0113c);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m301a(C0113c c0113c, HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders(f304a);
        if (c0113c != null && headers.length > 0) {
            c0113c.f306b = headers;
        }
    }

    /* renamed from: a */
    public static byte[] m302a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[4096];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, bArr3.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            gZIPInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e) {
        }
        return bArr2;
    }

    /* renamed from: b */
    private static String m303b(String str) {
        return !str.contains("biz_no") ? null : C0112b.m305d(str);
    }

    /* renamed from: c */
    private static String m304c(String str) {
        return (!str.contains("trade_no") || str.startsWith("out_trade_no")) ? null : C0112b.m305d(str);
    }

    /* renamed from: d */
    private static String m305d(String str) {
        String[] split = str.split("=");
        if (split.length <= 1) {
            return null;
        }
        String str2 = split[1];
        return str2.contains("\"") ? str2.replaceAll("\"", bi_常量类.f6358b) : str2;
    }

    /* renamed from: e */
    private static String m306e(String str) {
        return !str.contains("app_userid") ? null : C0112b.m305d(str);
    }
}
