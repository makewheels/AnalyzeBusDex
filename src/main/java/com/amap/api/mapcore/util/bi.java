package com.amap.api.mapcore.util;

import com.alipay.sdk.cons.C0108a;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

/* compiled from: LogUpdateRequest */
public class bi extends bu {
    /* renamed from: a */
    private byte[] f2040a;

    public bi(byte[] bArr) {
        this.f2040a = (byte[]) bArr.clone();
    }

    /* renamed from: f */
    private String m3219f() {
        Object bytes = av.f1987a.getBytes();
        byte[] bArr = new byte[(bytes.length + 50)];
        System.arraycopy(this.f2040a, 0, bArr, 0, 50);
        System.arraycopy(bytes, 0, bArr, 50, bytes.length);
        return ab.m3011a(bArr);
    }

    /* renamed from: b */
    public Map<String, String> mo585b() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f2040a.length));
        return hashMap;
    }

    /* renamed from: c */
    public Map<String, String> mo586c() {
        return null;
    }

    /* renamed from: d */
    public String mo587d() {
        return String.format(av.f1988b, new Object[]{C0108a.f262e, C0108a.f262e, C0108a.f262e, "open", m3219f()});
    }

    public byte[] a_() {
        return this.f2040a;
    }

    /* renamed from: e */
    public HttpEntity mo588e() {
        return null;
    }
}
