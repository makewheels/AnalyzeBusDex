package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.data.C0113c;
import com.alipay.sdk.exception.NetErrorException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpParams;

/* renamed from: com.alipay.sdk.net.a */
public final class C0122a {
    /* renamed from: a */
    String f349a;
    /* renamed from: b */
    private Context f350b;

    private C0122a(Context context) {
        this(context, null);
    }

    public C0122a(Context context, String str) {
        this.f350b = context;
        this.f349a = str;
    }

    /* renamed from: a */
    private String m371a() {
        return this.f349a;
    }

    /* renamed from: a */
    private static ByteArrayEntity m372a(C0113c c0113c, String str) throws IOException {
        String str2 = null;
        if (c0113c != null) {
            str2 = c0113c.f307c;
            if (!TextUtils.isEmpty(c0113c.f308d)) {
                str = c0113c.f308d + "=" + str;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = C0113c.f305a;
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(str.getBytes("utf-8"));
        byteArrayEntity.setContentType(str2);
        return byteArrayEntity;
    }

    /* renamed from: a */
    private void m373a(String str) {
        this.f349a = str;
    }

    /* renamed from: b */
    private URL m374b() {
        try {
            return new URL(this.f349a);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private HttpResponse m375b(String str) throws NetErrorException {
        return m381a(str, null);
    }

    /* renamed from: c */
    private HttpHost m376c() {
        String g;
        if (VERSION.SDK_INT >= 11) {
            g = m380g();
            if (g != null && !g.contains("wap")) {
                return null;
            }
            URL b = m374b();
            if (b == null) {
                return null;
            }
            C0109b.f275a.equalsIgnoreCase(b.getProtocol());
            Object property = System.getProperty("https.proxyHost");
            return !TextUtils.isEmpty(property) ? new HttpHost(property, Integer.parseInt(System.getProperty("https.proxyPort"))) : null;
        } else {
            NetworkInfo f = m379f();
            if (f == null || !f.isAvailable() || f.getType() != 0) {
                return null;
            }
            g = Proxy.getDefaultHost();
            return g != null ? new HttpHost(g, Proxy.getDefaultPort()) : null;
        }
    }

    /* renamed from: d */
    private HttpHost m377d() {
        NetworkInfo f = m379f();
        if (f == null || !f.isAvailable() || f.getType() != 0) {
            return null;
        }
        String defaultHost = Proxy.getDefaultHost();
        return defaultHost != null ? new HttpHost(defaultHost, Proxy.getDefaultPort()) : null;
    }

    /* renamed from: e */
    private HttpHost m378e() {
        String g = m380g();
        if (g != null && !g.contains("wap")) {
            return null;
        }
        URL b = m374b();
        if (b == null) {
            return null;
        }
        C0109b.f275a.equalsIgnoreCase(b.getProtocol());
        Object property = System.getProperty("https.proxyHost");
        return !TextUtils.isEmpty(property) ? new HttpHost(property, Integer.parseInt(System.getProperty("https.proxyPort"))) : null;
    }

    /* renamed from: f */
    private NetworkInfo m379f() {
        try {
            return ((ConnectivityManager) this.f350b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: g */
    private String m380g() {
        try {
            NetworkInfo f = m379f();
            return (f == null || !f.isAvailable()) ? "none" : f.getType() == 1 ? "wifi" : f.getExtraInfo().toLowerCase();
        } catch (Exception e) {
            return "none";
        }
    }

    /* renamed from: a */
    public final HttpResponse m381a(String str, C0113c c0113c) throws NetErrorException {
        HttpResponse httpResponse = null;
        C0123b a = C0123b.m382a();
        if (a != null) {
            try {
                String g;
                Object httpHost;
                HttpUriRequest httpGet;
                HttpParams params = a.f353c.getParams();
                if (VERSION.SDK_INT >= 11) {
                    g = m380g();
                    if (g == null || g.contains("wap")) {
                        URL b = m374b();
                        if (b != null) {
                            C0109b.f275a.equalsIgnoreCase(b.getProtocol());
                            Object property = System.getProperty("https.proxyHost");
                            String property2 = System.getProperty("https.proxyPort");
                            if (!TextUtils.isEmpty(property)) {
                                httpHost = new HttpHost(property, Integer.parseInt(property2));
                            }
                        }
                        httpHost = null;
                    } else {
                        httpHost = null;
                    }
                } else {
                    NetworkInfo f = m379f();
                    if (f != null && f.isAvailable() && f.getType() == 0) {
                        String defaultHost = Proxy.getDefaultHost();
                        int defaultPort = Proxy.getDefaultPort();
                        if (defaultHost != null) {
                            httpHost = new HttpHost(defaultHost, defaultPort);
                        }
                    }
                    httpHost = null;
                }
                if (httpHost != null) {
                    params.setParameter("http.route.default-proxy", httpHost);
                }
                "requestUrl : " + this.f349a;
                if (TextUtils.isEmpty(str)) {
                    httpGet = new HttpGet(this.f349a);
                } else {
                    httpGet = new HttpPost(this.f349a);
                    if (c0113c != null) {
                        g = c0113c.f307c;
                        if (!TextUtils.isEmpty(c0113c.f308d)) {
                            str = c0113c.f308d + "=" + str;
                        }
                    } else {
                        g = null;
                    }
                    if (TextUtils.isEmpty(g)) {
                        g = C0113c.f305a;
                    }
                    HttpEntity byteArrayEntity = new ByteArrayEntity(str.getBytes("utf-8"));
                    byteArrayEntity.setContentType(g);
                    ((HttpPost) httpGet).setEntity(byteArrayEntity);
                    httpGet.addHeader("Accept-Charset", "UTF-8");
                    httpGet.addHeader("Accept-Encoding", "gzip");
                    httpGet.addHeader("Connection", "Keep-Alive");
                    httpGet.addHeader("Keep-Alive", "timeout=180, max=100");
                }
                if (c0113c != null) {
                    ArrayList a2 = c0113c.m314a();
                    if (a2 != null) {
                        Iterator it = a2.iterator();
                        while (it.hasNext()) {
                            httpGet.addHeader((Header) it.next());
                        }
                    }
                }
                httpResponse = a.m395a(httpGet);
                Header[] headers = httpResponse.getHeaders("X-Hostname");
                if (!(headers == null || headers.length <= 0 || headers[0] == null)) {
                    httpResponse.getHeaders("X-Hostname")[0].toString();
                }
                headers = httpResponse.getHeaders("X-ExecuteTime");
                if (!(headers == null || headers.length <= 0 || headers[0] == null)) {
                    httpResponse.getHeaders("X-ExecuteTime")[0].toString();
                }
            } catch (NetErrorException e) {
                throw e;
            } catch (ConnectTimeoutException e2) {
                if (a != null) {
                    a.m396b();
                }
                throw new NetErrorException();
            } catch (SocketException e3) {
                throw new NetErrorException();
            } catch (SocketTimeoutException e4) {
                if (a != null) {
                    a.m396b();
                }
                throw new NetErrorException();
            } catch (Exception e5) {
                throw new NetErrorException();
            }
        }
        return httpResponse;
    }
}
