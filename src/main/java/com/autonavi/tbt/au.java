package com.autonavi.tbt;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;

/* compiled from: Request */
public abstract class au {
    /* renamed from: e */
    int f3766e = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    /* renamed from: f */
    int f3767f = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    /* renamed from: g */
    HttpHost f3768g = null;

    /* renamed from: a */
    public abstract Map<String, String> mo748a();

    /* renamed from: b */
    public abstract Map<String, String> mo749b();

    /* renamed from: c */
    public abstract String mo750c();

    /* renamed from: d */
    public abstract HttpEntity mo751d();

    /* renamed from: a */
    public final void m4791a(int i) {
        this.f3766e = i;
    }

    /* renamed from: b */
    public final void m4794b(int i) {
        this.f3767f = i;
    }

    /* renamed from: e */
    public byte[] m4797e() {
        return null;
    }

    /* renamed from: a */
    public final void m4792a(HttpHost httpHost) {
        this.f3768g = httpHost;
    }
}
