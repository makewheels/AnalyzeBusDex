package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.q */
public final class C0044q implements Callable<C0042u> {
    /* renamed from: e */
    private static final HttpRequestRetryHandler f70e = new ad();
    /* renamed from: a */
    protected C0037l f71a;
    /* renamed from: b */
    protected Context f72b;
    /* renamed from: c */
    protected C0041o f73c;
    /* renamed from: d */
    String f74d;
    /* renamed from: f */
    private HttpUriRequest f75f;
    /* renamed from: g */
    private HttpContext f76g = new BasicHttpContext();
    /* renamed from: h */
    private CookieStore f77h = new BasicCookieStore();
    /* renamed from: i */
    private CookieManager f78i;
    /* renamed from: j */
    private AbstractHttpEntity f79j;
    /* renamed from: k */
    private HttpHost f80k;
    /* renamed from: l */
    private URL f81l;
    /* renamed from: m */
    private int f82m = 0;
    /* renamed from: n */
    private boolean f83n = false;
    /* renamed from: o */
    private boolean f84o = false;
    /* renamed from: p */
    private String f85p = null;
    /* renamed from: q */
    private String f86q;

    public C0044q(C0037l c0037l, C0041o c0041o) {
        this.f71a = c0037l;
        this.f72b = this.f71a.f44a;
        this.f73c = c0041o;
    }

    /* renamed from: a */
    private static long m107a(String[] strArr) {
        int i = 0;
        while (i < strArr.length) {
            if ("max-age".equalsIgnoreCase(strArr[i]) && strArr[i + 1] != null) {
                try {
                    return Long.parseLong(strArr[i + 1]);
                } catch (Exception e) {
                }
            }
            i++;
        }
        return 0;
    }

    /* renamed from: a */
    private static HttpUrlHeader m108a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    /* renamed from: a */
    private C0042u m109a(HttpResponse httpResponse, int i, String str) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2 = null;
        new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && httpResponse.getStatusLine().getStatusCode() == 200) {
            new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
            try {
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    String str3;
                    long currentTimeMillis = System.currentTimeMillis();
                    m111a(entity, byteArrayOutputStream2);
                    byte[] toByteArray = byteArrayOutputStream2.toByteArray();
                    this.f84o = false;
                    this.f71a.m86c(System.currentTimeMillis() - currentTimeMillis);
                    this.f71a.m84a((long) toByteArray.length);
                    new StringBuilder("res:").append(toByteArray.length);
                    C0042u c0043p = new C0043p(C0044q.m108a(httpResponse), i, str, toByteArray);
                    currentTimeMillis = C0044q.m112b(httpResponse);
                    Header contentType = httpResponse.getEntity().getContentType();
                    if (contentType != null) {
                        HashMap a = C0044q.m110a(contentType.getValue());
                        str2 = (String) a.get("charset");
                        str3 = (String) a.get("Content-Type");
                    } else {
                        str3 = null;
                    }
                    c0043p.m101b(str3);
                    c0043p.m105a(str2);
                    c0043p.m104a(System.currentTimeMillis());
                    c0043p.m106b(currentTimeMillis);
                    try {
                        byteArrayOutputStream2.close();
                        return c0043p;
                    } catch (IOException e) {
                        throw new RuntimeException("ArrayOutputStream close error!", e.getCause());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    OutputStream outputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                byteArrayOutputStream = null;
                th = th4;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } else if (entity != null) {
            return null;
        } else {
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
    }

    /* renamed from: a */
    private static HashMap<String, String> m110a(String str) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str2 : str.split(";")) {
            String[] split = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m111a(HttpEntity httpEntity, OutputStream outputStream) {
        Closeable a = C0025b.m54a(httpEntity);
        long contentLength = httpEntity.getContentLength();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = a.read(bArr);
                if (read == -1 || this.f73c.m89h()) {
                    outputStream.flush();
                } else {
                    outputStream.write(bArr, 0, read);
                    if (this.f73c.m87f() != null && contentLength > 0) {
                        this.f73c.m87f();
                        C0041o c0041o = this.f73c;
                    }
                }
            }
            outputStream.flush();
            C0045r.m122a(a);
        } catch (Exception e) {
            e.getCause();
            throw new IOException("HttpWorker Request Error!" + e.getLocalizedMessage());
        } catch (Throwable th) {
            C0045r.m122a(a);
        }
    }

    /* renamed from: b */
    private static long m112b(HttpResponse httpResponse) {
        long j = 0;
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return C0044q.m107a(split);
                } catch (NumberFormatException e) {
                }
            }
        }
        firstHeader = httpResponse.getFirstHeader("Expires");
        return firstHeader != null ? C0025b.m59b(firstHeader.getValue()) - System.currentTimeMillis() : j;
    }

    /* renamed from: b */
    private URI m113b() {
        String a = this.f73c.m90a();
        if (this.f74d != null) {
            a = this.f74d;
        }
        if (a != null) {
            return new URI(a);
        }
        throw new RuntimeException("url should not be null");
    }

    /* renamed from: c */
    private HttpUriRequest m114c() {
        if (this.f75f != null) {
            return this.f75f;
        }
        if (this.f79j == null) {
            byte[] b = this.f73c.m97b();
            CharSequence b2 = this.f73c.m96b("gzip");
            if (b != null) {
                if (TextUtils.equals(b2, "true")) {
                    this.f79j = C0025b.m57a(b);
                } else {
                    this.f79j = new ByteArrayEntity(b);
                }
                this.f79j.setContentType(this.f73c.m98c());
            }
        }
        HttpEntity httpEntity = this.f79j;
        if (httpEntity != null) {
            HttpUriRequest httpPost = new HttpPost(m113b());
            httpPost.setEntity(httpEntity);
            this.f75f = httpPost;
        } else {
            this.f75f = new HttpGet(m113b());
        }
        return this.f75f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    private com.alipay.android.phone.mrpc.core.C0042u m115d() {
        /*
        r14 = this;
        r13 = 6;
        r12 = 3;
        r11 = 2;
        r3 = 1;
        r4 = 0;
    L_0x0005:
        r1 = r14.f72b;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = "connectivity";
        r1 = r1.getSystemService(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = (android.net.ConnectivityManager) r1;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r1.getAllNetworkInfo();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r2 != 0) goto L_0x0047;
    L_0x0015:
        r1 = r4;
    L_0x0016:
        if (r1 != 0) goto L_0x0060;
    L_0x0018:
        r1 = new com.alipay.android.phone.mrpc.core.HttpException;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = 1;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = "The network is not available";
        r1.<init>(r2, r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        throw r1;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0025:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x003e;
    L_0x0031:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r1.getCode();
        r1.getMsg();
    L_0x003e:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        throw r1;
    L_0x0047:
        r5 = r2.length;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r4;
    L_0x0049:
        if (r1 >= r5) goto L_0x04ec;
    L_0x004b:
        r6 = r2[r1];	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r6 == 0) goto L_0x005d;
    L_0x004f:
        r7 = r6.isAvailable();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r7 == 0) goto L_0x005d;
    L_0x0055:
        r6 = r6.isConnectedOrConnecting();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r6 == 0) goto L_0x005d;
    L_0x005b:
        r1 = r3;
        goto L_0x0016;
    L_0x005d:
        r1 = r1 + 1;
        goto L_0x0049;
    L_0x0060:
        r1 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.m87f();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x006f;
    L_0x0068:
        r1 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.m87f();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x006f:
        r1 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.m99d();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x00a2;
    L_0x0077:
        r2 = r1.isEmpty();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r2 != 0) goto L_0x00a2;
    L_0x007d:
        r2 = r1.iterator();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0081:
        r1 = r2.hasNext();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x00a2;
    L_0x0087:
        r1 = r2.next();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = (org.apache.http.Header) r1;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r14.m114c();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5.addHeader(r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        goto L_0x0081;
    L_0x0095:
        r1 = move-exception;
        r2 = new java.lang.RuntimeException;
        r3 = "Url parser error!";
        r1 = r1.getCause();
        r2.<init>(r3, r1);
        throw r2;
    L_0x00a2:
        r1 = r14.m114c();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        com.alipay.android.phone.mrpc.core.C0025b.m58a(r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.m114c();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        com.alipay.android.phone.mrpc.core.C0025b.m60b(r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.m114c();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = "cookie";
        r5 = r14.m120i();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r6.m90a();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r5.getCookie(r6);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.addHeader(r2, r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f76g;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = "http.cookie-store";
        r5 = r14.f77h;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.setAttribute(r2, r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f71a;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.m82a();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = f70e;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.m62a(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = "By Http/Https to request. operationType=";
        r1.<init>(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r14.m117f();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.append(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = " url=";
        r1 = r1.append(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r14.f75f;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r2.getURI();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r2.toString();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.append(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f71a;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.m82a();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r1.getParams();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r8 = "http.route.default-proxy";
        r1 = r14.f72b;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = 0;
        r9 = "connectivity";
        r1 = r1.getSystemService(r9);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = (android.net.ConnectivityManager) r1;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.getActiveNetworkInfo();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x04e9;
    L_0x011e:
        r1 = r1.isAvailable();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x04e9;
    L_0x0124:
        r9 = android.net.Proxy.getDefaultHost();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r10 = android.net.Proxy.getDefaultPort();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r9 == 0) goto L_0x04e9;
    L_0x012e:
        r1 = new org.apache.http.HttpHost;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.<init>(r9, r10);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0133:
        if (r1 == 0) goto L_0x014a;
    L_0x0135:
        r2 = r1.getHostName();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r9 = "127.0.0.1";
        r2 = android.text.TextUtils.equals(r2, r9);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r2 == 0) goto L_0x014a;
    L_0x0141:
        r2 = r1.getPort();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r9 = 8087; // 0x1f97 float:1.1332E-41 double:3.9955E-320;
        if (r2 != r9) goto L_0x014a;
    L_0x0149:
        r1 = 0;
    L_0x014a:
        r7.setParameter(r8, r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f80k;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x0231;
    L_0x0151:
        r1 = r14.f80k;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0153:
        r2 = r14.m118g();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = 80;
        if (r2 != r7) goto L_0x0168;
    L_0x015b:
        r1 = new org.apache.http.HttpHost;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r14.m119h();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r2.getHost();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.<init>(r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0168:
        r2 = r14.f71a;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r2.m82a();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r14.f75f;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r8 = r14.f76g;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r2.execute(r1, r7, r8);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f71a;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r7 - r5;
        r1.m85b(r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f77h;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.getCookies();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r5.m100e();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r5 == 0) goto L_0x0196;
    L_0x018f:
        r5 = r14.m120i();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5.removeAllCookie();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0196:
        r5 = r1.isEmpty();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r5 != 0) goto L_0x024f;
    L_0x019c:
        r5 = r1.iterator();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x01a0:
        r1 = r5.hasNext();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x024f;
    L_0x01a6:
        r1 = r5.next();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = (org.apache.http.cookie.Cookie) r1;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r1.getDomain();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r6 == 0) goto L_0x01a0;
    L_0x01b2:
        r6 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6.<init>();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r1.getName();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r6.append(r7);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = "=";
        r6 = r6.append(r7);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r1.getValue();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r6.append(r7);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = "; domain=";
        r6 = r6.append(r7);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r1.getDomain();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r6.append(r7);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.isSecure();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x024c;
    L_0x01e1:
        r1 = "; Secure";
    L_0x01e3:
        r1 = r6.append(r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.toString();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r14.m120i();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r7.m90a();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6.setCookie(r7, r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = android.webkit.CookieSyncManager.getInstance();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.sync();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        goto L_0x01a0;
    L_0x0200:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x021b;
    L_0x020c:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x021b:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r11);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x0231:
        r1 = r14.m119h();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = new org.apache.http.HttpHost;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r7 = r1.getHost();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r8 = r14.m118g();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.getProtocol();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2.<init>(r7, r8, r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r14.f80k = r2;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r14.f80k;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        goto L_0x0153;
    L_0x024c:
        r1 = "";
        goto L_0x01e3;
    L_0x024f:
        r1 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r2.getStatusLine();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r1.getStatusCode();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r2.getStatusLine();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r6 = r1.getReasonPhrase();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r1) goto L_0x02b9;
    L_0x0265:
        r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r5 != r1) goto L_0x02b7;
    L_0x0269:
        r1 = r3;
    L_0x026a:
        if (r1 != 0) goto L_0x02b9;
    L_0x026c:
        r1 = new com.alipay.android.phone.mrpc.core.HttpException;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r2.getStatusLine();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r5.getStatusCode();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r2.getStatusLine();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r2 = r2.getReasonPhrase();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.<init>(r5, r2);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        throw r1;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0286:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x02a1;
    L_0x0292:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x02a1:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r11);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x02b7:
        r1 = r4;
        goto L_0x026a;
    L_0x02b9:
        r2 = r14.m109a(r2, r5, r6);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = -1;
        if (r2 == 0) goto L_0x02cd;
    L_0x02c1:
        r1 = r2.m102b();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x02cd;
    L_0x02c7:
        r1 = r2.m102b();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.length;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = (long) r1;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x02cd:
        r7 = -1;
        r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r1 != 0) goto L_0x02e8;
    L_0x02d3:
        r1 = r2 instanceof com.alipay.android.phone.mrpc.core.C0043p;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x02e8;
    L_0x02d7:
        r0 = r2;
        r0 = (com.alipay.android.phone.mrpc.core.C0043p) r0;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r0;
        r1 = r1.m103a();	 Catch:{ Exception -> 0x04e6, HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497 }
        r5 = "Content-Length";
        r1 = r1.getHead(r5);	 Catch:{ Exception -> 0x04e6, HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497 }
        java.lang.Long.parseLong(r1);	 Catch:{ Exception -> 0x04e6, HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497 }
    L_0x02e8:
        r1 = r14.f73c;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r1.m90a();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r1 == 0) goto L_0x0310;
    L_0x02f0:
        r5 = r14.m117f();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        if (r5 != 0) goto L_0x0310;
    L_0x02fa:
        r5 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5.<init>();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1 = r5.append(r1);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = "#";
        r1 = r1.append(r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r5 = r14.m117f();	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
        r1.append(r5);	 Catch:{ HttpException -> 0x0025, URISyntaxException -> 0x0095, SSLHandshakeException -> 0x0200, SSLPeerUnverifiedException -> 0x0286, SSLException -> 0x0311, ConnectionPoolTimeoutException -> 0x0342, ConnectTimeoutException -> 0x0373, SocketTimeoutException -> 0x03a4, NoHttpResponseException -> 0x03d6, HttpHostConnectException -> 0x0408, UnknownHostException -> 0x0433, IOException -> 0x0466, NullPointerException -> 0x0497, Exception -> 0x04bd }
    L_0x0310:
        return r2;
    L_0x0311:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x032c;
    L_0x031d:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x032c:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r13);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x0342:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x035d;
    L_0x034e:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x035d:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r12);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x0373:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x038e;
    L_0x037f:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x038e:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r12);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x03a4:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x03bf;
    L_0x03b0:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x03bf:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = 4;
        r3 = java.lang.Integer.valueOf(r3);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x03d6:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x03f1;
    L_0x03e2:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x03f1:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = 5;
        r3 = java.lang.Integer.valueOf(r3);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x0408:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x0423;
    L_0x0414:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x0423:
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = 8;
        r3 = java.lang.Integer.valueOf(r3);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x0433:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x044e;
    L_0x043f:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x044e:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = 9;
        r3 = java.lang.Integer.valueOf(r3);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x0466:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x0481;
    L_0x0472:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x0481:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r13);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x0497:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f82m;
        if (r2 > 0) goto L_0x04a7;
    L_0x049f:
        r1 = r14.f82m;
        r1 = r1 + 1;
        r14.f82m = r1;
        goto L_0x0005;
    L_0x04a7:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r4);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x04bd:
        r1 = move-exception;
        r14.m116e();
        r2 = r14.f73c;
        r2 = r2.m87f();
        if (r2 == 0) goto L_0x04d8;
    L_0x04c9:
        r2 = r14.f73c;
        r2.m87f();
        r2 = r14.f73c;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
    L_0x04d8:
        r2 = new com.alipay.android.phone.mrpc.core.HttpException;
        r3 = java.lang.Integer.valueOf(r4);
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        throw r2;
    L_0x04e6:
        r1 = move-exception;
        goto L_0x02e8;
    L_0x04e9:
        r1 = r2;
        goto L_0x0133;
    L_0x04ec:
        r1 = r4;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.q.d():com.alipay.android.phone.mrpc.core.u");
    }

    /* renamed from: e */
    private void m116e() {
        if (this.f75f != null) {
            this.f75f.abort();
        }
    }

    /* renamed from: f */
    private String m117f() {
        if (!TextUtils.isEmpty(this.f86q)) {
            return this.f86q;
        }
        this.f86q = this.f73c.m96b("operationType");
        return this.f86q;
    }

    /* renamed from: g */
    private int m118g() {
        URL h = m119h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    /* renamed from: h */
    private URL m119h() {
        if (this.f81l != null) {
            return this.f81l;
        }
        this.f81l = new URL(this.f73c.m90a());
        return this.f81l;
    }

    /* renamed from: i */
    private CookieManager m120i() {
        if (this.f78i != null) {
            return this.f78i;
        }
        this.f78i = CookieManager.getInstance();
        return this.f78i;
    }

    /* renamed from: a */
    public final C0041o m121a() {
        return this.f73c;
    }

    public final /* synthetic */ Object call() {
        return m115d();
    }
}
