package com.amap.api.p015a;

import android.util.Log;
import com.amap.api.maps2d.AMapException;
import com.amap.api.p015a.p016a.C0184e;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: AuthManager */
/* renamed from: com.amap.api.a.k */
public class C0248k {
    /* renamed from: a */
    public static int f1036a = -1;
    /* renamed from: b */
    static String f1037b = bi_常量类.f6358b_空串;
    /* renamed from: d */
    public static HttpURLConnection f1038d = null;
    /* renamed from: c */
    int f1039c = 0;

    /* renamed from: a */
    public static synchronized boolean m1640a(android.content.Context r7) throws com.amap.api.maps2d.AMapException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.amap.api.a.k.a(android.content.Context):boolean. bs: [B:13:0x0023, B:16:0x0028, B:42:0x0069, B:45:0x006e]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = 0;
        r3 = com.amap.api.p015a.C0248k.class;
        monitor-enter(r3);
        r4 = 0;
        r0 = com.amap.api.p015a.C0248k.m1642b();	 Catch:{ all -> 0x0042 }
        r1 = com.amap.api.p015a.C0248k.m1639a();	 Catch:{ AMapException -> 0x004e, all -> 0x0090 }
        r5 = com.amap.api.p015a.p016a.C0184e.m650c(r7);	 Catch:{ AMapException -> 0x004e, all -> 0x0090 }
        r0 = com.amap.api.p015a.p016a.C0192i.m716a(r1, r0, r5);	 Catch:{ AMapException -> 0x004e, all -> 0x0090 }
        f1038d = r0;	 Catch:{ AMapException -> 0x004e, all -> 0x0090 }
        r0 = f1038d;	 Catch:{ AMapException -> 0x004e, all -> 0x0090 }
        r1 = com.amap.api.p015a.C0248k.m1638a(r0);	 Catch:{ AMapException -> 0x004e, all -> 0x0090 }
        r0 = com.amap.api.p015a.C0248k.m1641a(r1);	 Catch:{ AMapException -> 0x0093 }
        if (r1 == 0) goto L_0x0026;
    L_0x0023:
        r1.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0026:
        if (r2 == 0) goto L_0x002b;
    L_0x0028:
        r4.close();	 Catch:{ IOException -> 0x0045 }
    L_0x002b:
        r1 = f1038d;	 Catch:{ all -> 0x0042 }
        if (r1 == 0) goto L_0x0037;	 Catch:{ all -> 0x0042 }
    L_0x002f:
        r1 = f1038d;	 Catch:{ all -> 0x0042 }
        r1.disconnect();	 Catch:{ all -> 0x0042 }
        r1 = 0;	 Catch:{ all -> 0x0042 }
        f1038d = r1;	 Catch:{ all -> 0x0042 }
    L_0x0037:
        monitor-exit(r3);
        return r0;
    L_0x0039:
        r0 = move-exception;
        r0 = new com.amap.api.maps2d.AMapException;	 Catch:{ all -> 0x0042 }
        r1 = "IO 操作异常 - IOException";	 Catch:{ all -> 0x0042 }
        r0.<init>(r1);	 Catch:{ all -> 0x0042 }
        throw r0;	 Catch:{ all -> 0x0042 }
    L_0x0042:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
    L_0x0045:
        r0 = move-exception;
        r0 = new com.amap.api.maps2d.AMapException;	 Catch:{ all -> 0x0042 }
        r1 = "IO 操作异常 - IOException";	 Catch:{ all -> 0x0042 }
        r0.<init>(r1);	 Catch:{ all -> 0x0042 }
        throw r0;	 Catch:{ all -> 0x0042 }
    L_0x004e:
        r0 = move-exception;
        r1 = r2;
    L_0x0050:
        r5 = "AuthFailure";	 Catch:{ all -> 0x0066 }
        r6 = r0.getErrorMessage();	 Catch:{ all -> 0x0066 }
        android.util.Log.i(r5, r6);	 Catch:{ all -> 0x0066 }
        r0.printStackTrace();	 Catch:{ all -> 0x0066 }
        r5 = new com.amap.api.maps2d.AMapException;	 Catch:{ all -> 0x0066 }
        r0 = r0.getErrorMessage();	 Catch:{ all -> 0x0066 }
        r5.<init>(r0);	 Catch:{ all -> 0x0066 }
        throw r5;	 Catch:{ all -> 0x0066 }
    L_0x0066:
        r0 = move-exception;
    L_0x0067:
        if (r1 == 0) goto L_0x006c;
    L_0x0069:
        r1.close();	 Catch:{ IOException -> 0x007e }
    L_0x006c:
        if (r2 == 0) goto L_0x0071;
    L_0x006e:
        r4.close();	 Catch:{ IOException -> 0x0087 }
    L_0x0071:
        r1 = f1038d;	 Catch:{ all -> 0x0042 }
        if (r1 == 0) goto L_0x007d;	 Catch:{ all -> 0x0042 }
    L_0x0075:
        r1 = f1038d;	 Catch:{ all -> 0x0042 }
        r1.disconnect();	 Catch:{ all -> 0x0042 }
        r1 = 0;	 Catch:{ all -> 0x0042 }
        f1038d = r1;	 Catch:{ all -> 0x0042 }
    L_0x007d:
        throw r0;	 Catch:{ all -> 0x0042 }
    L_0x007e:
        r0 = move-exception;	 Catch:{ all -> 0x0042 }
        r0 = new com.amap.api.maps2d.AMapException;	 Catch:{ all -> 0x0042 }
        r1 = "IO 操作异常 - IOException";	 Catch:{ all -> 0x0042 }
        r0.<init>(r1);	 Catch:{ all -> 0x0042 }
        throw r0;	 Catch:{ all -> 0x0042 }
    L_0x0087:
        r0 = move-exception;	 Catch:{ all -> 0x0042 }
        r0 = new com.amap.api.maps2d.AMapException;	 Catch:{ all -> 0x0042 }
        r1 = "IO 操作异常 - IOException";	 Catch:{ all -> 0x0042 }
        r0.<init>(r1);	 Catch:{ all -> 0x0042 }
        throw r0;	 Catch:{ all -> 0x0042 }
    L_0x0090:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0067;
    L_0x0093:
        r0 = move-exception;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.k.a(android.content.Context):boolean");
    }

    /* renamed from: a */
    private static String m1639a() {
        return "http://restapi.amap.com/v3/log/init";
    }

    /* renamed from: a */
    protected static InputStream m1638a(HttpURLConnection httpURLConnection) throws AMapException {
        try {
            InputStream pushbackInputStream = new PushbackInputStream(httpURLConnection.getInputStream(), 2);
            byte[] bArr = new byte[2];
            pushbackInputStream.read(bArr);
            pushbackInputStream.unread(bArr);
            if (bArr[0] == (byte) 31 && bArr[1] == (byte) -117) {
                return new GZIPInputStream(pushbackInputStream);
            }
            return pushbackInputStream;
        } catch (ProtocolException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (UnknownHostException e2) {
            throw new AMapException("未知主机 - UnKnowHostException");
        } catch (UnknownServiceException e3) {
            throw new AMapException("服务器连接失败 - UnknownServiceException");
        } catch (IOException e4) {
            throw new AMapException("IO 操作异常 - IOException");
        }
    }

    /* renamed from: a */
    private static boolean m1641a(InputStream inputStream) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(new String(C0184e.m648a(inputStream)));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    f1036a = 1;
                } else if (i == 0) {
                    f1036a = 0;
                }
            }
            if (jSONObject.has("info")) {
                f1037b = jSONObject.getString("info");
            }
            if (f1036a == 0) {
                Log.i("AuthFailure", f1037b);
                throw new AMapException("key鉴权失败");
            } else if (f1036a != 1) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (f1036a == 1) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (f1036a != 1) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: b */
    private static byte[] m1642b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("resType=json&encode=UTF-8&ec=1");
        return C0270y.m1736b(C0270y.m1732a(stringBuffer.toString())).getBytes();
    }
}
