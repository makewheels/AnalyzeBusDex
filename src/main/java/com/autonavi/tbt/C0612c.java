package com.autonavi.tbt;

import java.util.Map;
import org.apache.http.HttpEntity;
import p054u.aly.bi_常量类;

/* compiled from: TBTRequest */
/* renamed from: com.autonavi.tbt.c */
public class C0612c extends au {
    /* renamed from: a */
    Map<String, String> f3780a = null;
    /* renamed from: b */
    Map<String, String> f3781b = null;
    /* renamed from: c */
    String f3782c = bi_常量类.f6358b;
    /* renamed from: d */
    HttpEntity f3783d = null;

    /* renamed from: a */
    public void m4818a(Map<String, String> map) {
        this.f3780a = map;
    }

    /* renamed from: a */
    public Map<String, String> mo748a() {
        return this.f3780a;
    }

    /* renamed from: b */
    public Map<String, String> mo749b() {
        return this.f3781b;
    }

    /* renamed from: c */
    public String mo750c() {
        return this.f3782c;
    }

    /* renamed from: a */
    public void m4817a(String str) {
        this.f3782c = str;
    }

    /* renamed from: a */
    public void m4819a(HttpEntity httpEntity) {
        this.f3783d = httpEntity;
    }

    /* renamed from: d */
    public HttpEntity mo751d() {
        return this.f3783d;
    }
}
