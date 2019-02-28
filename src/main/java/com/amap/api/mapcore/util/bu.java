package com.amap.api.mapcore.util;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;

/* compiled from: Request */
public abstract class bu {
    /* renamed from: g */
    int f1931g = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    /* renamed from: h */
    int f1932h = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    /* renamed from: i */
    HttpHost f1933i = null;

    /* renamed from: b */
    public abstract Map<String, String> mo585b();

    /* renamed from: c */
    public abstract Map<String, String> mo586c();

    /* renamed from: d */
    public abstract String mo587d();

    /* renamed from: e */
    public abstract HttpEntity mo588e();

    /* renamed from: a */
    public final void m3047a(int i) {
        this.f1931g = i;
    }

    /* renamed from: b */
    public final void m3050b(int i) {
        this.f1932h = i;
    }

    public byte[] a_() {
        return null;
    }

    /* renamed from: a */
    public final void m3048a(HttpHost httpHost) {
        this.f1933i = httpHost;
    }
}
