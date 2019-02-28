package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* renamed from: com.alipay.android.phone.mrpc.core.o */
public final class C0041o extends C0040t {
    /* renamed from: b */
    private String f56b;
    /* renamed from: c */
    private byte[] f57c;
    /* renamed from: d */
    private String f58d = "application/x-www-form-urlencoded";
    /* renamed from: e */
    private ArrayList<Header> f59e = new ArrayList();
    /* renamed from: f */
    private Map<String, String> f60f = new HashMap();
    /* renamed from: g */
    private boolean f61g;

    public C0041o(String str) {
        this.f56b = str;
    }

    /* renamed from: a */
    public final String m90a() {
        return this.f56b;
    }

    /* renamed from: a */
    public final void m91a(String str) {
        this.f58d = str;
    }

    /* renamed from: a */
    public final void m92a(String str, String str2) {
        if (this.f60f == null) {
            this.f60f = new HashMap();
        }
        this.f60f.put(str, str2);
    }

    /* renamed from: a */
    public final void m93a(Header header) {
        this.f59e.add(header);
    }

    /* renamed from: a */
    public final void m94a(boolean z) {
        this.f61g = z;
    }

    /* renamed from: a */
    public final void m95a(byte[] bArr) {
        this.f57c = bArr;
    }

    /* renamed from: b */
    public final String m96b(String str) {
        return this.f60f == null ? null : (String) this.f60f.get(str);
    }

    /* renamed from: b */
    public final byte[] m97b() {
        return this.f57c;
    }

    /* renamed from: c */
    public final String m98c() {
        return this.f58d;
    }

    /* renamed from: d */
    public final ArrayList<Header> m99d() {
        return this.f59e;
    }

    /* renamed from: e */
    public final boolean m100e() {
        return this.f61g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0041o c0041o = (C0041o) obj;
        if (this.f57c == null) {
            if (c0041o.f57c != null) {
                return false;
            }
        } else if (!this.f57c.equals(c0041o.f57c)) {
            return false;
        }
        return this.f56b == null ? c0041o.f56b == null : this.f56b.equals(c0041o.f56b);
    }

    public final int hashCode() {
        int i = 1;
        if (this.f60f != null && this.f60f.containsKey("id")) {
            i = ((String) this.f60f.get("id")).hashCode() + 31;
        }
        return (this.f56b == null ? 0 : this.f56b.hashCode()) + (i * 31);
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", new Object[]{this.f56b, this.f59e});
    }
}
