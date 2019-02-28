package com.alipay.sdk.net;

import android.os.Build.VERSION;
import com.alipay.sdk.cons.C0109b;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.sdk.net.b */
public final class C0123b {
    /* renamed from: a */
    public static final String f351a = "msp";
    /* renamed from: b */
    public static C0123b f352b;
    /* renamed from: c */
    final DefaultHttpClient f353c;

    private C0123b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.f353c = new DefaultHttpClient(clientConnectionManager, httpParams);
    }

    private C0123b(HttpParams httpParams) {
        this.f353c = new DefaultHttpClient(httpParams);
    }

    /* renamed from: a */
    public static C0123b m382a() {
        if (f352b == null) {
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
            basicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
            ConnManagerParams.setMaxTotalConnections(basicHttpParams, 50);
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(30));
            ConnManagerParams.setTimeout(basicHttpParams, 1000);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 16384);
            HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
            HttpClientParams.setRedirecting(basicHttpParams, true);
            HttpClientParams.setAuthenticating(basicHttpParams, false);
            HttpProtocolParams.setUserAgent(basicHttpParams, f351a);
            try {
                SocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                Scheme scheme = new Scheme(C0109b.f275a, socketFactory, 443);
                Scheme scheme2 = new Scheme("http", PlainSocketFactory.getSocketFactory(), 80);
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(scheme);
                schemeRegistry.register(scheme2);
                f352b = new C0123b(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
            } catch (Exception e) {
                f352b = new C0123b(basicHttpParams);
            }
        }
        return f352b;
    }

    /* renamed from: a */
    private <T> T m383a(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws Exception {
        try {
            return this.f353c.execute(httpHost, httpRequest, responseHandler);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: a */
    private <T> T m384a(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws Exception {
        try {
            return this.f353c.execute(httpHost, httpRequest, responseHandler, httpContext);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: a */
    private <T> T m385a(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws Exception {
        try {
            return this.f353c.execute(httpUriRequest, responseHandler);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: a */
    private <T> T m386a(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws Exception {
        try {
            return this.f353c.execute(httpUriRequest, responseHandler, httpContext);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: a */
    private HttpResponse m387a(HttpHost httpHost, HttpRequest httpRequest) throws Exception {
        try {
            return this.f353c.execute(httpHost, httpRequest);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: a */
    private HttpResponse m388a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws Exception {
        try {
            return this.f353c.execute(httpHost, httpRequest, httpContext);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: a */
    private HttpResponse m389a(HttpUriRequest httpUriRequest, HttpContext httpContext) throws Exception {
        try {
            return this.f353c.execute(httpUriRequest, httpContext);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: c */
    private static C0123b m390c() {
        return f352b;
    }

    /* renamed from: d */
    private static void m391d() {
        f352b = null;
    }

    /* renamed from: e */
    private void m392e() {
        ClientConnectionManager connectionManager = this.f353c.getConnectionManager();
        if (connectionManager != null) {
            connectionManager.closeExpiredConnections();
            if (VERSION.SDK_INT >= 9) {
                connectionManager.closeIdleConnections(30, TimeUnit.MINUTES);
            }
        }
    }

    /* renamed from: f */
    private HttpParams m393f() {
        return this.f353c.getParams();
    }

    /* renamed from: g */
    private ClientConnectionManager m394g() {
        return this.f353c.getConnectionManager();
    }

    /* renamed from: a */
    public final HttpResponse m395a(HttpUriRequest httpUriRequest) throws Exception {
        try {
            return this.f353c.execute(httpUriRequest);
        } catch (Throwable e) {
            throw new Exception(e);
        }
    }

    /* renamed from: b */
    public final void m396b() {
        ClientConnectionManager connectionManager = this.f353c.getConnectionManager();
        if (connectionManager != null) {
            connectionManager.shutdown();
            f352b = null;
        }
    }
}
