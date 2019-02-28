package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.f */
final class C0029f implements ConnectionKeepAliveStrategy {
    /* renamed from: a */
    final /* synthetic */ C0027d f32a;

    C0029f(C0027d c0027d) {
        this.f32a = c0027d;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000;
    }
}
