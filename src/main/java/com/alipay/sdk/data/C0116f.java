package com.alipay.sdk.data;

import org.apache.http.Header;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.data.f */
public final class C0116f {
    /* renamed from: a */
    public static final int f323a = 1000;
    /* renamed from: b */
    public static final int f324b = 503;
    /* renamed from: c */
    public int f325c = 0;
    /* renamed from: d */
    public String f326d = bi_常量类.f6358b;
    /* renamed from: e */
    public long f327e = 0;
    /* renamed from: f */
    public String f328f = bi_常量类.f6358b;
    /* renamed from: g */
    public String f329g = null;
    /* renamed from: h */
    public String f330h = null;
    /* renamed from: i */
    public JSONObject f331i = null;
    /* renamed from: j */
    public String f332j;
    /* renamed from: k */
    public boolean f333k = true;
    /* renamed from: l */
    public C0111a f334l = null;
    /* renamed from: m */
    Header[] f335m = null;

    /* renamed from: a */
    private C0111a m339a() {
        return this.f334l;
    }

    /* renamed from: a */
    private void m340a(int i) {
        this.f325c = i;
    }

    /* renamed from: a */
    private void m341a(long j) {
        this.f327e = j;
    }

    /* renamed from: a */
    private void m342a(C0111a c0111a) {
        this.f334l = c0111a;
    }

    /* renamed from: a */
    private void m343a(String str) {
        this.f326d = str;
    }

    /* renamed from: a */
    private void m344a(JSONObject jSONObject) {
        this.f331i = jSONObject;
    }

    /* renamed from: b */
    private void m345b() {
        this.f333k = false;
    }

    /* renamed from: b */
    private void m346b(String str) {
        this.f328f = str;
    }

    /* renamed from: c */
    private int m347c() {
        return this.f325c;
    }

    /* renamed from: c */
    private void m348c(String str) {
        this.f329g = str;
    }

    /* renamed from: d */
    private String m349d() {
        return this.f328f;
    }

    /* renamed from: d */
    private void m350d(String str) {
        this.f330h = str;
    }

    /* renamed from: e */
    private void m351e(String str) {
        this.f332j = str;
    }
}
