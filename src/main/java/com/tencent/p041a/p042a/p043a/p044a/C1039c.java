package com.tencent.p041a.p042a.p043a.p044a;

import android.util.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.a.a.a.a.c */
public final class C1039c {
    /* renamed from: T */
    long f4764T = 0;
    /* renamed from: a */
    String f4765a = null;
    /* renamed from: b */
    String f4766b = null;
    /* renamed from: c */
    String f4767c = "0";

    /* renamed from: e */
    static C1039c m7482e(String str) {
        C1039c c1039c = new C1039c();
        if (C1043h.m7500b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    c1039c.f4765a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    c1039c.f4766b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    c1039c.f4767c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    c1039c.f4764T = jSONObject.getLong("ts");
                }
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
        return c1039c;
    }

    /* renamed from: n */
    private JSONObject m7483n() {
        JSONObject jSONObject = new JSONObject();
        try {
            C1043h.m7497a(jSONObject, "ui", this.f4765a);
            C1043h.m7497a(jSONObject, "mc", this.f4766b);
            C1043h.m7497a(jSONObject, "mid", this.f4767c);
            jSONObject.put("ts", this.f4764T);
        } catch (Throwable e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final String m7484a() {
        return this.f4767c;
    }

    public final String toString() {
        return m7483n().toString();
    }
}
