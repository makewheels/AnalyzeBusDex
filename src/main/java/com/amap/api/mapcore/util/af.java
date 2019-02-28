package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

/* compiled from: AuthRequest */
class af extends bu {
    /* renamed from: a */
    private Map<String, String> f1934a = new HashMap();
    /* renamed from: b */
    private String f1935b;
    /* renamed from: c */
    private Map<String, String> f1936c = new HashMap();

    af() {
    }

    /* renamed from: a */
    void m3055a(Map<String, String> map) {
        this.f1934a.clear();
        this.f1934a.putAll(map);
    }

    /* renamed from: a */
    void m3054a(String str) {
        this.f1935b = str;
    }

    /* renamed from: b */
    void m3057b(Map<String, String> map) {
        this.f1936c.clear();
        this.f1936c.putAll(map);
    }

    /* renamed from: d */
    public String mo587d() {
        return this.f1935b;
    }

    /* renamed from: b */
    public Map<String, String> mo585b() {
        return this.f1934a;
    }

    /* renamed from: c */
    public Map<String, String> mo586c() {
        return this.f1936c;
    }

    /* renamed from: e */
    public HttpEntity mo588e() {
        return null;
    }
}
