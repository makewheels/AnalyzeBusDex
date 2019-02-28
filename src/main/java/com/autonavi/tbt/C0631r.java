package com.autonavi.tbt;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

/* compiled from: AuthRequest */
/* renamed from: com.autonavi.tbt.r */
class C0631r extends au {
    /* renamed from: a */
    private Map<String, String> f3843a = new HashMap();
    /* renamed from: b */
    private String f3844b;
    /* renamed from: c */
    private Map<String, String> f3845c = new HashMap();

    C0631r() {
    }

    /* renamed from: a */
    void m4953a(Map<String, String> map) {
        this.f3843a.clear();
        this.f3843a.putAll(map);
    }

    /* renamed from: a */
    void m4952a(String str) {
        this.f3844b = str;
    }

    /* renamed from: b */
    void m4955b(Map<String, String> map) {
        this.f3845c.clear();
        this.f3845c.putAll(map);
    }

    /* renamed from: c */
    public String mo750c() {
        return this.f3844b;
    }

    /* renamed from: a */
    public Map<String, String> mo748a() {
        return this.f3843a;
    }

    /* renamed from: b */
    public Map<String, String> mo749b() {
        return this.f3845c;
    }

    /* renamed from: d */
    public HttpEntity mo751d() {
        return null;
    }
}
