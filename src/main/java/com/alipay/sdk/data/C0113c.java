package com.alipay.sdk.data;

import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* renamed from: com.alipay.sdk.data.c */
public final class C0113c {
    /* renamed from: a */
    public static final String f305a = "application/octet-stream;binary/octet-stream";
    /* renamed from: b */
    public Header[] f306b = null;
    /* renamed from: c */
    public String f307c = null;
    /* renamed from: d */
    public String f308d = null;

    /* renamed from: a */
    private void m307a(String str) {
        this.f307c = str;
    }

    /* renamed from: a */
    private void m308a(Header[] headerArr) {
        this.f306b = headerArr;
    }

    /* renamed from: b */
    private void m309b(String str) {
        this.f308d = str;
    }

    /* renamed from: b */
    private Header[] m310b() {
        return this.f306b;
    }

    /* renamed from: c */
    private String m311c() {
        return this.f307c;
    }

    /* renamed from: d */
    private String m312d() {
        return this.f308d;
    }

    /* renamed from: e */
    private void m313e() {
        this.f308d = null;
        this.f307c = null;
    }

    /* renamed from: a */
    public final ArrayList<BasicHeader> m314a() {
        if (this.f306b == null || this.f306b.length == 0) {
            return null;
        }
        ArrayList<BasicHeader> arrayList = new ArrayList();
        for (Header header : this.f306b) {
            arrayList.add(new BasicHeader(header.getName(), header.getValue()));
        }
        return arrayList;
    }
}
