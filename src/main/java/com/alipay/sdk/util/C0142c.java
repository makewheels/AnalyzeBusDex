package com.alipay.sdk.util;

import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.encrypt.C0120d;
import com.alipay.sdk.encrypt.C0121e;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.util.c */
public final class C0142c {
    /* renamed from: a */
    private static String m500a(String str, String str2) {
        String a = C0120d.m364a(str, C0108a.f260c);
        String a2 = C0121e.m369a(str, str2);
        return String.format(Locale.getDefault(), "%08X%s%08X%s", new Object[]{Integer.valueOf(a.length()), a, Integer.valueOf(a2.length()), a2});
    }

    /* renamed from: a */
    public static JSONObject m501a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            for (JSONObject jSONObject4 : new JSONObject[]{jSONObject, jSONObject2}) {
                if (jSONObject4 != null) {
                    Iterator keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        jSONObject3.put(str, jSONObject4.get(str));
                    }
                }
            }
        } catch (JSONException e) {
        }
        return jSONObject3;
    }
}
