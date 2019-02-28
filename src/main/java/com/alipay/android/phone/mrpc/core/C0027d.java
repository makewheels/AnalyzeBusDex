package com.alipay.android.phone.mrpc.core;

import com.alipay.android.phone.mrpc.core.C0025b.C0023a;
import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.d */
final class C0027d extends DefaultHttpClient {
    /* renamed from: a */
    final /* synthetic */ C0025b f29a;

    C0027d(C0025b c0025b, ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.f29a = c0025b;
        super(clientConnectionManager, httpParams);
    }

    protected final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new C0029f(this);
    }

    protected final HttpContext createHttpContext() {
        HttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basicHttpContext;
    }

    protected final BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
        createHttpProcessor.addRequestInterceptor(C0025b.f25c);
        createHttpProcessor.addRequestInterceptor(new C0023a());
        return createHttpProcessor;
    }

    protected final RedirectHandler createRedirectHandler() {
        return new C0028e(this);
    }
}
