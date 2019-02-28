package com.amap.api.maps.offlinemap;

import android.content.Context;
import com.alipay.sdk.cons.C0108a;
import com.amap.api.mapcore.util.C0407w;
import com.amap.api.mapcore.util.C0409y;
import com.amap.api.mapcore.util.ae;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: OfflineInitHandler */
/* renamed from: com.amap.api.maps.offlinemap.g */
class C0429g extends C0428k<String, C0427f> {
    /* renamed from: b */
    protected /* synthetic */ Object mo623b(String str) throws AMapException {
        return m3688a(str);
    }

    public C0429g(Context context, String str) {
        super(context, str);
        getClass();
        m3047a(5000);
        getClass();
        m3050b(50000);
    }

    /* renamed from: d */
    public String mo587d() {
        return "http://apimanifest.amap.com/r/init";
    }

    /* renamed from: a */
    protected C0427f m3688a(String str) throws AMapException {
        C0427f c0427f = new C0427f();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("offlinemap")) {
                jSONObject = jSONObject.getJSONObject("offlinemap");
                String optString = jSONObject.optString("update", bi_常量类.f6358b);
                if (optString.equals("0")) {
                    c0427f.m3678a(false);
                } else if (optString.equals(C0108a.f262e)) {
                    c0427f.m3678a(true);
                }
                c0427f.m3677a(jSONObject.optString("version", bi_常量类.f6358b));
            }
        } catch (Throwable th) {
            az.m3143a(th, "OfflineInitHandler", "loadData parseJson");
            th.printStackTrace();
        }
        return c0427f;
    }

    /* renamed from: c */
    public Map<String, String> mo586c() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("mapver", this.a);
        hashMap.put("output", "json");
        hashMap.put("key", C0407w.m3495f(this.d));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mapver=").append((String) this.a);
        stringBuffer.append("&output=json");
        stringBuffer.append("&key=").append(C0407w.m3495f(this.d));
        String a = ae.m3039a(stringBuffer.toString());
        String a2 = C0409y.m3502a();
        hashMap.put("ts", a2);
        hashMap.put("scode", C0409y.m3506a(this.d, a2, a));
        return hashMap;
    }
}
