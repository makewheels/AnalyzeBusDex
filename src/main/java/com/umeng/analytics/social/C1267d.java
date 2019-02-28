package com.umeng.analytics.social;

import p054u.aly.bi_常量类;

/* compiled from: UMResult */
/* renamed from: com.umeng.analytics.social.d */
public class C1267d {
    /* renamed from: a */
    private int f5691a = -1;
    /* renamed from: b */
    private String f5692b = bi_常量类.f6358b_空串;
    /* renamed from: c */
    private String f5693c = bi_常量类.f6358b_空串;
    /* renamed from: d */
    private Exception f5694d = null;

    public C1267d(int i) {
        this.f5691a = i;
    }

    public C1267d(int i, Exception exception) {
        this.f5691a = i;
        this.f5694d = exception;
    }

    /* renamed from: a */
    public Exception m8482a() {
        return this.f5694d;
    }

    /* renamed from: b */
    public int m8485b() {
        return this.f5691a;
    }

    /* renamed from: a */
    public void m8483a(int i) {
        this.f5691a = i;
    }

    /* renamed from: c */
    public String m8487c() {
        return this.f5692b;
    }

    /* renamed from: a */
    public void m8484a(String str) {
        this.f5692b = str;
    }

    /* renamed from: d */
    public String m8488d() {
        return this.f5693c;
    }

    /* renamed from: b */
    public void m8486b(String str) {
        this.f5693c = str;
    }

    public String toString() {
        return "status=" + this.f5691a + "\r\n" + "msg:  " + this.f5692b + "\r\n" + "data:  " + this.f5693c;
    }
}
