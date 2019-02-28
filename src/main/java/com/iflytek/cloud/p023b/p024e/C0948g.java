package com.iflytek.cloud.p023b.p024e;

import android.text.TextUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

/* renamed from: com.iflytek.cloud.b.e.g */
public class C0948g extends Thread {
    /* renamed from: a */
    private int f4494a = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    /* renamed from: b */
    private C0917a f4495b = null;
    /* renamed from: c */
    private volatile boolean f4496c = false;
    /* renamed from: d */
    private URL f4497d = null;
    /* renamed from: e */
    private ArrayList<byte[]> f4498e = new ArrayList();
    /* renamed from: f */
    private Object f4499f = null;
    /* renamed from: g */
    private int f4500g = 0;

    /* renamed from: com.iflytek.cloud.b.e.g$a */
    public interface C0917a {
        /* renamed from: a */
        void mo1563a(C0948g c0948g, byte[] bArr);

        /* renamed from: a */
        void mo1564a(Exception exception);

        /* renamed from: a */
        void mo1565a(byte[] bArr);
    }

    /* renamed from: a */
    public static URL m7151a(String str, String str2) throws MalformedURLException {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            str = str + str2;
        }
        return new URL(str);
    }

    /* renamed from: a */
    private void m7152a(Exception exception) {
        if (this.f4495b != null && !this.f4496c) {
            this.f4495b.mo1564a(exception);
        }
    }

    /* renamed from: a */
    public static boolean m7153a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("rsp") && jSONObject.getJSONObject("rsp").getInt("code") != 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: a */
    private byte[] m7154a(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(1024);
        byte[] bArr = new byte[1024];
        while (!this.f4496c) {
            int read = bufferedInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                break;
            }
            byteArrayBuffer.append(bArr, 0, read);
            if (this.f4495b != null) {
                this.f4495b.mo1565a(byteArrayBuffer.toByteArray());
            }
        }
        return byteArrayBuffer.toByteArray();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m7155b() {
        /*
        r6 = this;
        r2 = 0;
        r0 = "Start connect server";
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);	 Catch:{ Exception -> 0x00ac, all -> 0x0093 }
        r0 = r6.f4497d;	 Catch:{ Exception -> 0x00ac, all -> 0x0093 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x00ac, all -> 0x0093 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x00ac, all -> 0x0093 }
        r1 = r6.f4494a;	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r1 = r6.f4494a;	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r1 = "GET";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r3.<init>();	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r4 = "responseCode = ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r3 = r3.append(r1);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r3);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r1) goto L_0x0051;
    L_0x003b:
        r2 = r0.getInputStream();	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r1 = r6.m7154a(r2);	 Catch:{ Exception -> 0x00af, all -> 0x00a2 }
        r6.m7156b(r1);	 Catch:{ Exception -> 0x00af, all -> 0x00a2 }
    L_0x0046:
        if (r2 == 0) goto L_0x004b;
    L_0x0048:
        r2.close();	 Catch:{ Exception -> 0x00b5 }
    L_0x004b:
        if (r0 == 0) goto L_0x0050;
    L_0x004d:
        r0.disconnect();	 Catch:{ Exception -> 0x00b5 }
    L_0x0050:
        return;
    L_0x0051:
        r1 = "MscHttpRequest connect error";
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r1);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r1 = new java.lang.Exception;	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r3 = "HttpRequest Failed.";
        r1.<init>(r3);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        r6.m7152a(r1);	 Catch:{ Exception -> 0x0061, all -> 0x00a2 }
        goto L_0x0046;
    L_0x0061:
        r1 = move-exception;
        r5 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r5;
    L_0x0066:
        r0.printStackTrace();	 Catch:{ all -> 0x00a7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a7 }
        r3.<init>();	 Catch:{ all -> 0x00a7 }
        r4 = "MscHttpRequest error:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00a7 }
        r4 = r0.toString();	 Catch:{ all -> 0x00a7 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00a7 }
        r3 = r3.toString();	 Catch:{ all -> 0x00a7 }
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r3);	 Catch:{ all -> 0x00a7 }
        r6.m7152a(r0);	 Catch:{ all -> 0x00a7 }
        if (r1 == 0) goto L_0x008b;
    L_0x0088:
        r1.close();	 Catch:{ Exception -> 0x0091 }
    L_0x008b:
        if (r2 == 0) goto L_0x0050;
    L_0x008d:
        r2.disconnect();	 Catch:{ Exception -> 0x0091 }
        goto L_0x0050;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0050;
    L_0x0093:
        r0 = move-exception;
        r1 = r2;
    L_0x0095:
        if (r2 == 0) goto L_0x009a;
    L_0x0097:
        r2.close();	 Catch:{ Exception -> 0x00a0 }
    L_0x009a:
        if (r1 == 0) goto L_0x009f;
    L_0x009c:
        r1.disconnect();	 Catch:{ Exception -> 0x00a0 }
    L_0x009f:
        throw r0;
    L_0x00a0:
        r1 = move-exception;
        goto L_0x009f;
    L_0x00a2:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0095;
    L_0x00a7:
        r0 = move-exception;
        r5 = r1;
        r1 = r2;
        r2 = r5;
        goto L_0x0095;
    L_0x00ac:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0066;
    L_0x00af:
        r1 = move-exception;
        r5 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0066;
    L_0x00b5:
        r0 = move-exception;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.b.e.g.b():void");
    }

    /* renamed from: b */
    private void m7156b(byte[] bArr) {
        if (this.f4495b != null && !this.f4496c) {
            this.f4495b.mo1563a(this, bArr);
        }
    }

    /* renamed from: c */
    private int m7157c() {
        int i = 0;
        for (int i2 = 0; i2 < this.f4498e.size(); i2++) {
            i += ((byte[]) this.f4498e.get(i2)).length;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m7158a() {
        /*
        r6 = this;
        r2 = 0;
        r0 = "MscHttpRequest start Post";
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);	 Catch:{ Exception -> 0x00f2, all -> 0x00e8 }
        r0 = r6.f4497d;	 Catch:{ Exception -> 0x00f2, all -> 0x00e8 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x00f2, all -> 0x00e8 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x00f2, all -> 0x00e8 }
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = 1;
        r0.setDoInput(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = "POST";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = r6.f4494a;	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = r6.f4494a;	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = "Content-length";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3.<init>();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r4 = "";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r4 = r6.m7157c();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = "Connection";
        r3 = "Keep-Alive";
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = "Charset";
        r3 = "utf-8";
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = "Content-Type";
        r3 = "application/x-gzip";
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = r6.f4498e;	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r4 = r1.iterator();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
    L_0x0064:
        r1 = r4.hasNext();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        if (r1 == 0) goto L_0x00a1;
    L_0x006a:
        r1 = r4.next();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3.write(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        goto L_0x0064;
    L_0x0074:
        r1 = move-exception;
        r5 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r5;
    L_0x0079:
        r6.m7152a(r0);	 Catch:{ all -> 0x00eb }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r3.<init>();	 Catch:{ all -> 0x00eb }
        r4 = "MscHttpRequest error:";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00eb }
        r0 = r0.toString();	 Catch:{ all -> 0x00eb }
        r0 = r3.append(r0);	 Catch:{ all -> 0x00eb }
        r0 = r0.toString();	 Catch:{ all -> 0x00eb }
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x009b;
    L_0x0098:
        r1.close();	 Catch:{ Exception -> 0x00f0 }
    L_0x009b:
        if (r2 == 0) goto L_0x00a0;
    L_0x009d:
        r2.disconnect();	 Catch:{ Exception -> 0x00f0 }
    L_0x00a0:
        return;
    L_0x00a1:
        r3.flush();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3.close();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r1) goto L_0x00c7;
    L_0x00af:
        r2 = r0.getInputStream();	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = r6.m7154a(r2);	 Catch:{ Exception -> 0x00f5, all -> 0x00d7 }
        r6.m7156b(r1);	 Catch:{ Exception -> 0x00f5, all -> 0x00d7 }
    L_0x00ba:
        if (r2 == 0) goto L_0x00bf;
    L_0x00bc:
        r2.close();	 Catch:{ Exception -> 0x00c5 }
    L_0x00bf:
        if (r0 == 0) goto L_0x00a0;
    L_0x00c1:
        r0.disconnect();	 Catch:{ Exception -> 0x00c5 }
        goto L_0x00a0;
    L_0x00c5:
        r0 = move-exception;
        goto L_0x00a0;
    L_0x00c7:
        r1 = "Http Request Failed.";
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r1 = new java.lang.Exception;	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r3 = "Http Request Failed.";
        r1.<init>(r3);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        r6.m7152a(r1);	 Catch:{ Exception -> 0x0074, all -> 0x00d7 }
        goto L_0x00ba;
    L_0x00d7:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x00db:
        if (r2 == 0) goto L_0x00e0;
    L_0x00dd:
        r2.close();	 Catch:{ Exception -> 0x00e6 }
    L_0x00e0:
        if (r1 == 0) goto L_0x00e5;
    L_0x00e2:
        r1.disconnect();	 Catch:{ Exception -> 0x00e6 }
    L_0x00e5:
        throw r0;
    L_0x00e6:
        r1 = move-exception;
        goto L_0x00e5;
    L_0x00e8:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00db;
    L_0x00eb:
        r0 = move-exception;
        r5 = r1;
        r1 = r2;
        r2 = r5;
        goto L_0x00db;
    L_0x00f0:
        r0 = move-exception;
        goto L_0x00a0;
    L_0x00f2:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0079;
    L_0x00f5:
        r1 = move-exception;
        r5 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.b.e.g.a():void");
    }

    /* renamed from: a */
    public void m7159a(int i) {
        this.f4500g = i;
    }

    /* renamed from: a */
    public void m7160a(C0917a c0917a) {
        this.f4495b = c0917a;
        start();
    }

    /* renamed from: a */
    public void m7161a(String str, String str2, byte[] bArr) {
        this.f4498e.clear();
        m7162a(bArr);
        try {
            this.f4497d = C0948g.m7151a(str, str2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m7162a(byte[] bArr) {
        if (bArr != null) {
            this.f4498e.add(bArr);
        }
    }

    public void run() {
        if (this.f4500g == 1) {
            m7158a();
        } else {
            m7155b();
        }
    }
}
