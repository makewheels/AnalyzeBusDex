package com.tencent.wxop.stat.common;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.common.a */
public class C1182a {
    /* renamed from: a */
    private String f5430a = null;
    /* renamed from: b */
    private String f5431b = null;
    /* renamed from: c */
    private String f5432c = null;
    /* renamed from: d */
    private String f5433d = "0";
    /* renamed from: e */
    private int f5434e;
    /* renamed from: f */
    private int f5435f = 0;
    /* renamed from: g */
    private long f5436g = 0;

    public C1182a(String str, String str2, int i) {
        this.f5430a = str;
        this.f5431b = str2;
        this.f5434e = i;
    }

    /* renamed from: a */
    JSONObject m8246a() {
        JSONObject jSONObject = new JSONObject();
        try {
            C1198q.m8331a(jSONObject, "ui", this.f5430a);
            C1198q.m8331a(jSONObject, "mc", this.f5431b);
            C1198q.m8331a(jSONObject, "mid", this.f5433d);
            C1198q.m8331a(jSONObject, "aid", this.f5432c);
            jSONObject.put("ts", this.f5436g);
            jSONObject.put("ver", this.f5435f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m8247a(int i) {
        this.f5434e = i;
    }

    /* renamed from: b */
    public String m8248b() {
        return this.f5430a;
    }

    /* renamed from: c */
    public String m8249c() {
        return this.f5431b;
    }

    /* renamed from: d */
    public int m8250d() {
        return this.f5434e;
    }

    public String toString() {
        return m8246a().toString();
    }
}
