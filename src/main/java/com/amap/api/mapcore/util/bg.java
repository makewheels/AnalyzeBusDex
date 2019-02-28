package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public class bg {
    /* renamed from: a */
    static final String f2036a = "/a/";
    /* renamed from: b */
    static final String f2037b = "b";
    /* renamed from: c */
    static final String f2038c = "c";
    /* renamed from: d */
    static final String f2039d = "d";

    /* renamed from: a */
    static void m3217a(Context context, Throwable th, int i, String str, String str2) {
        try {
            ExecutorService a = az.m3140a();
            if (a != null && !a.isShutdown()) {
                final int i2 = i;
                final Context context2 = context;
                final Throwable th2 = th;
                final String str3 = str;
                final String str4 = str2;
                a.submit(new Runnable() {
                    public void run() {
                        try {
                            bj a = bj.m3171a(i2);
                            if (a != null) {
                                a.m3187a(context2, th2, str3, str4);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m3216a(Context context) {
        try {
            bj a = bj.m3171a(2);
            if (a != null) {
                a.m3186a(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    static void m3218b(final Context context) {
        try {
            ExecutorService a = az.m3140a();
            if (a != null && !a.isShutdown()) {
                a.submit(new Runnable() {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r7 = this;
                        r0 = 0;
                        r1 = r3;	 Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0035, all -> 0x0055 }
                        r2 = 0;
                        r2 = com.amap.api.mapcore.util.bh.m3152a(r1, r2);	 Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0035, all -> 0x0055 }
                        r1 = r3;	 Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x0092, all -> 0x007b }
                        r3 = 1;
                        r1 = com.amap.api.mapcore.util.bh.m3152a(r1, r3);	 Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x0092, all -> 0x007b }
                        r3 = r3;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x0099, all -> 0x0082 }
                        r4 = 2;
                        r0 = com.amap.api.mapcore.util.bh.m3152a(r3, r4);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x0099, all -> 0x0082 }
                        r3 = r3;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
                        r2.m3164b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
                        r3 = r3;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
                        r1.m3164b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
                        r3 = r3;	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
                        r0.m3164b(r3);	 Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x00a0, all -> 0x0089 }
                        if (r2 == 0) goto L_0x002a;
                    L_0x0027:
                        r2.m3165c();
                    L_0x002a:
                        if (r1 == 0) goto L_0x002f;
                    L_0x002c:
                        r1.m3165c();
                    L_0x002f:
                        if (r0 == 0) goto L_0x0034;
                    L_0x0031:
                        r0.m3165c();
                    L_0x0034:
                        return;
                    L_0x0035:
                        r1 = move-exception;
                        r2 = r0;
                        r3 = r0;
                        r6 = r1;
                        r1 = r0;
                        r0 = r6;
                    L_0x003b:
                        r4 = "Log";
                        r5 = "processLog";
                        com.amap.api.mapcore.util.az.m3143a(r0, r4, r5);	 Catch:{ all -> 0x0090 }
                        r0.printStackTrace();	 Catch:{ all -> 0x0090 }
                        if (r3 == 0) goto L_0x004a;
                    L_0x0047:
                        r3.m3165c();
                    L_0x004a:
                        if (r2 == 0) goto L_0x004f;
                    L_0x004c:
                        r2.m3165c();
                    L_0x004f:
                        if (r1 == 0) goto L_0x0034;
                    L_0x0051:
                        r1.m3165c();
                        goto L_0x0034;
                    L_0x0055:
                        r1 = move-exception;
                        r2 = r0;
                        r3 = r0;
                        r6 = r1;
                        r1 = r0;
                        r0 = r6;
                    L_0x005b:
                        if (r3 == 0) goto L_0x0060;
                    L_0x005d:
                        r3.m3165c();
                    L_0x0060:
                        if (r2 == 0) goto L_0x0065;
                    L_0x0062:
                        r2.m3165c();
                    L_0x0065:
                        if (r1 == 0) goto L_0x006a;
                    L_0x0067:
                        r1.m3165c();
                    L_0x006a:
                        throw r0;
                    L_0x006b:
                        r1 = move-exception;
                        r1 = r0;
                        r2 = r0;
                    L_0x006e:
                        if (r2 == 0) goto L_0x0073;
                    L_0x0070:
                        r2.m3165c();
                    L_0x0073:
                        if (r1 == 0) goto L_0x0078;
                    L_0x0075:
                        r1.m3165c();
                    L_0x0078:
                        if (r0 == 0) goto L_0x0034;
                    L_0x007a:
                        goto L_0x0031;
                    L_0x007b:
                        r1 = move-exception;
                        r3 = r2;
                        r2 = r0;
                        r6 = r0;
                        r0 = r1;
                        r1 = r6;
                        goto L_0x005b;
                    L_0x0082:
                        r3 = move-exception;
                        r6 = r3;
                        r3 = r2;
                        r2 = r1;
                        r1 = r0;
                        r0 = r6;
                        goto L_0x005b;
                    L_0x0089:
                        r3 = move-exception;
                        r6 = r3;
                        r3 = r2;
                        r2 = r1;
                        r1 = r0;
                        r0 = r6;
                        goto L_0x005b;
                    L_0x0090:
                        r0 = move-exception;
                        goto L_0x005b;
                    L_0x0092:
                        r1 = move-exception;
                        r3 = r2;
                        r2 = r0;
                        r6 = r0;
                        r0 = r1;
                        r1 = r6;
                        goto L_0x003b;
                    L_0x0099:
                        r3 = move-exception;
                        r6 = r3;
                        r3 = r2;
                        r2 = r1;
                        r1 = r0;
                        r0 = r6;
                        goto L_0x003b;
                    L_0x00a0:
                        r3 = move-exception;
                        r6 = r3;
                        r3 = r2;
                        r2 = r1;
                        r1 = r0;
                        r0 = r6;
                        goto L_0x003b;
                    L_0x00a7:
                        r1 = move-exception;
                        r1 = r0;
                        goto L_0x006e;
                    L_0x00aa:
                        r3 = move-exception;
                        goto L_0x006e;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bg.2.run():void");
                    }
                });
            }
        } catch (Throwable th) {
            az.m3143a(th, "Log", "processLog");
            th.printStackTrace();
        }
    }
}
