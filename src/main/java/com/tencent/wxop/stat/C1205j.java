package com.tencent.wxop.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.tencent.wxop.stat.j */
class C1205j extends DefaultConnectionKeepAliveStrategy {
    /* renamed from: a */
    final /* synthetic */ C1204i f5522a;

    C1205j(C1204i c1204i) {
        this.f5522a = c1204i;
    }

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        return keepAliveDuration == -1 ? 30000 : keepAliveDuration;
    }
}
