package com.amap.api.mapcore.util;

import android.content.Context;
import com.alipay.sdk.cons.C0108a;
import com.amap.api.mapcore.C0344n;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

/* compiled from: ManifestManager */
/* renamed from: com.amap.api.mapcore.util.q */
public class C0400q extends bu {
    /* renamed from: a */
    private Context f2179a;
    /* renamed from: b */
    private String f2180b;

    public C0400q(Context context) {
        this.f2179a = context;
        this.f2180b = C0407w.m3495f(context);
    }

    /* renamed from: a */
    public C0401r m3427a() {
        String str = "feachManifest";
        try {
            bt a = bt.m3294a(false);
            m3048a(ac.m3018a(this.f2179a));
            return m3423a(a.m3304a((bu) this));
        } catch (Throwable e) {
            az.m3143a(e, "ManifestManager", str);
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m3424a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    /* renamed from: b */
    private String m3426b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(str);
    }

    /* renamed from: a */
    private boolean m3425a(String str) {
        if (str != null && str.equals(C0108a.f262e)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private C0401r m3423a(byte[] bArr) {
        String str = "loadData";
        if (bArr == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            str = jSONObject.optString("status");
            if ("0".equals(str) || !C0108a.f262e.equals(str)) {
                return null;
            }
            JSONObject a = m3424a(jSONObject, "result");
            return new C0401r(m3425a(m3426b(m3424a(m3424a(a, "common"), "commoninfo"), "com_isupload")), m3425a(m3426b(m3424a(m3424a(a, "exception"), "exceptinfo"), "ex_isupload")));
        } catch (Throwable e) {
            az.m3143a(e, "ManifestManager", "loadData");
            return null;
        }
    }

    /* renamed from: b */
    public Map<String, String> mo585b() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("User-Agent", C0344n.f1880c);
        return hashMap;
    }

    /* renamed from: c */
    public Map<String, String> mo586c() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("key", this.f2180b);
        hashMap.put("opertype", "common;exception");
        hashMap.put("plattype", "android");
        hashMap.put("product", C0344n.f1879b);
        hashMap.put("version", "V2.5.1");
        hashMap.put("ext", "standard");
        hashMap.put("output", "json");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(this.f2180b);
        stringBuffer.append("&opertype=common;exception");
        stringBuffer.append("&plattype=android");
        stringBuffer.append("&product=").append(C0344n.f1879b);
        stringBuffer.append("&version=").append("V2.5.1");
        stringBuffer.append("&ext=standard");
        stringBuffer.append("&output=json");
        String a = ae.m3039a(stringBuffer.toString());
        String a2 = C0409y.m3502a();
        hashMap.put("ts", a2);
        hashMap.put("scode", C0409y.m3506a(this.f2179a, a2, a));
        return hashMap;
    }

    /* renamed from: d */
    public String mo587d() {
        return "http://restapi.amap.com/v3/config/resource";
    }

    /* renamed from: e */
    public HttpEntity mo588e() {
        return null;
    }
}
