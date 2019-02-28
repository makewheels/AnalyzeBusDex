package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.p041a.p042a.p043a.p044a.C1042g;
import com.tencent.p041a.p042a.p043a.p044a.C1043h;
import com.tencent.wxop.stat.common.C1186e;
import com.tencent.wxop.stat.common.C1187f;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.p053a.C1166e;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.i */
class C1204i {
    /* renamed from: d */
    private static StatLogger f5515d = C1192k.m8283b();
    /* renamed from: e */
    private static C1204i f5516e = null;
    /* renamed from: f */
    private static Context f5517f = null;
    /* renamed from: a */
    DefaultHttpClient f5518a = null;
    /* renamed from: b */
    C1186e f5519b = null;
    /* renamed from: c */
    StringBuilder f5520c = new StringBuilder(4096);
    /* renamed from: g */
    private long f5521g = 0;

    private C1204i(Context context) {
        try {
            f5517f = context.getApplicationContext();
            this.f5521g = System.currentTimeMillis() / 1000;
            this.f5519b = new C1186e();
            if (StatConfig.isDebugEnable()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.f5518a = new DefaultHttpClient(basicHttpParams);
            this.f5518a.setKeepAliveStrategy(new C1205j(this));
        } catch (Throwable th2) {
            f5515d.m8242e(th2);
        }
    }

    /* renamed from: a */
    static Context m8350a() {
        return f5517f;
    }

    /* renamed from: a */
    static void m8351a(Context context) {
        f5517f = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m8352a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("mid");
            if (C1043h.m7501c(optString)) {
                if (StatConfig.isDebugEnable()) {
                    f5515d.m8243i("update mid:" + optString);
                }
                C1042g.m7491E(f5517f).m7493a(optString);
            }
            if (!jSONObject.isNull("cfg")) {
                StatConfig.m8094a(f5517f, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (StatConfig.isDebugEnable()) {
                    f5515d.m8243i("server time:" + i + ", diff time:" + currentTimeMillis);
                }
                C1192k.m8315z(f5517f);
                C1192k.m8279a(f5517f, currentTimeMillis);
            }
        } catch (Throwable th) {
            f5515d.m8245w(th);
        }
    }

    /* renamed from: b */
    static C1204i m8353b(Context context) {
        if (f5516e == null) {
            synchronized (C1204i.class) {
                if (f5516e == null) {
                    f5516e = new C1204i(context);
                }
            }
        }
        return f5516e;
    }

    /* renamed from: a */
    void m8354a(C1166e c1166e, C1179h c1179h) {
        m8356b(Arrays.asList(new String[]{c1166e.m8140g()}), c1179h);
    }

    /* renamed from: a */
    void m8355a(List<?> list, C1179h c1179h) {
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            Throwable th;
            try {
                String str;
                this.f5520c.delete(0, this.f5520c.length());
                this.f5520c.append("[");
                String str2 = "rc4";
                for (int i2 = 0; i2 < size; i2++) {
                    this.f5520c.append(list.get(i2).toString());
                    if (i2 != size - 1) {
                        this.f5520c.append(",");
                    }
                }
                this.f5520c.append("]");
                String stringBuilder = this.f5520c.toString();
                size = stringBuilder.length();
                String str3 = StatConfig.getStatReportUrl() + "/?index=" + this.f5521g;
                this.f5521g++;
                if (StatConfig.isDebugEnable()) {
                    f5515d.m8243i("[" + str3 + "]Send request(" + size + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost a = C1178a.m8165a(f5517f).m8172a();
                httpPost.addHeader("Content-Encoding", str2);
                if (a == null) {
                    this.f5518a.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (StatConfig.isDebugEnable()) {
                        f5515d.m8240d("proxy:" + a.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    this.f5518a.getParams().setParameter("http.route.default-proxy", a);
                    httpPost.addHeader("X-Online-Host", StatConfig.f5238k);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder.getBytes("UTF-8");
                int length = bytes.length;
                if (size > StatConfig.f5242o) {
                    i = 1;
                }
                if (i != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (a != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (StatConfig.isDebugEnable()) {
                        f5515d.m8240d("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(C1187f.m8257a(bytes)));
                HttpResponse execute = this.f5518a.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (StatConfig.isDebugEnable()) {
                    f5515d.m8243i("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    f5515d.m8241e((Object) "Server response no data.");
                    if (c1179h != null) {
                        c1179h.mo1914b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = C1187f.m8259b(C1192k.m8281a(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = C1192k.m8281a(C1187f.m8259b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = C1192k.m8281a(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = C1187f.m8259b(bytes);
                        }
                    }
                    str = new String(bytes, "UTF-8");
                    if (StatConfig.isDebugEnable()) {
                        f5515d.m8243i("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == 200) {
                        m8352a(jSONObject);
                        if (c1179h != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                c1179h.mo1913a();
                            } else {
                                f5515d.error((Object) "response error data.");
                                c1179h.mo1914b();
                            }
                        }
                    } else {
                        f5515d.error("Server response error code:" + size + ", error:" + new String(bytes, "UTF-8"));
                        if (c1179h != null) {
                            c1179h.mo1914b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    f5515d.error(th);
                    if (c1179h != null) {
                        try {
                            c1179h.mo1914b();
                        } catch (Throwable th2) {
                            f5515d.m8242e(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        this.f5520c = null;
                        this.f5520c = new StringBuilder(2048);
                    }
                    C1178a.m8165a(f5517f).m8176d();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* renamed from: b */
    void m8356b(List<?> list, C1179h c1179h) {
        if (this.f5519b != null) {
            this.f5519b.m8255a(new C1206k(this, list, c1179h));
        }
    }
}
