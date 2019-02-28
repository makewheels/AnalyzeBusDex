package com.amap.api.p015a;

/* compiled from: AsyncServer */
/* renamed from: com.amap.api.a.i */
class C0246i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0236h f1034a;

    C0246i(C0236h c0236h) {
        this.f1034a = c0236h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r5 = this;
        r0 = 0;
        r1 = java.lang.Thread.currentThread();
        r2 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r2 = r2.f957b;	 Catch:{ Exception -> 0x0025 }
        if (r2 == 0) goto L_0x0012;
    L_0x000b:
        r2 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r2 = r2.f957b;	 Catch:{ Exception -> 0x0025 }
        r2.add(r1);	 Catch:{ Exception -> 0x0025 }
    L_0x0012:
        r2 = r0;
    L_0x0013:
        r1 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r1 = r1.f956a;	 Catch:{ Exception -> 0x0025 }
        if (r1 == 0) goto L_0x0026;
    L_0x0019:
        r1 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r1 = r1.e;	 Catch:{ Exception -> 0x0025 }
        if (r1 != 0) goto L_0x0027;
    L_0x001f:
        r1 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r3 = 0;
        r1.f956a = r3;	 Catch:{ Exception -> 0x0025 }
        goto L_0x0013;
    L_0x0025:
        r0 = move-exception;
    L_0x0026:
        return;
    L_0x0027:
        r1 = com.amap.api.maps2d.MapsInitializer.getNetworkEnable();	 Catch:{ Exception -> 0x0025 }
        if (r1 != 0) goto L_0x003c;
    L_0x002d:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        java.lang.Thread.sleep(r3);	 Catch:{ Exception -> 0x0033 }
        goto L_0x0013;
    L_0x0033:
        r1 = move-exception;
        r1 = java.lang.Thread.currentThread();	 Catch:{ Exception -> 0x0025 }
        r1.interrupt();	 Catch:{ Exception -> 0x0025 }
        goto L_0x0013;
    L_0x003c:
        r1 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r1 = r1.f958c;	 Catch:{ Exception -> 0x0025 }
        if (r1 == 0) goto L_0x00c1;
    L_0x0042:
        r0 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.f958c;	 Catch:{ Exception -> 0x0025 }
        r1 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r1 = r1.mo227f();	 Catch:{ Exception -> 0x0025 }
        r3 = 0;
        r0 = r0.m1502a(r1, r3);	 Catch:{ Exception -> 0x0025 }
        r1 = r0;
    L_0x0052:
        if (r1 == 0) goto L_0x005c;
    L_0x0054:
        r0 = r1.size();	 Catch:{ Exception -> 0x0025 }
        if (r0 != 0) goto L_0x005c;
    L_0x005a:
        r0 = r1;
        goto L_0x0013;
    L_0x005c:
        r0 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.f956a;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0026;
    L_0x0062:
        if (r1 == 0) goto L_0x00bf;
    L_0x0064:
        r0 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.f956a;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0026;
    L_0x006a:
        r0 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.e;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x00bc;
    L_0x0070:
        r0 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.e;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.f840e;	 Catch:{ Exception -> 0x0025 }
        if (r0 != 0) goto L_0x007a;
    L_0x0078:
        r0 = r1;
        goto L_0x0013;
    L_0x007a:
        r0 = r5.f1034a;	 Catch:{ AMapException -> 0x00aa }
        r3 = r5.f1034a;	 Catch:{ AMapException -> 0x00aa }
        r3 = r3.e;	 Catch:{ AMapException -> 0x00aa }
        r3 = r3.f840e;	 Catch:{ AMapException -> 0x00aa }
        r3 = r3.m1380a();	 Catch:{ AMapException -> 0x00aa }
        r0 = r0.mo224a(r1, r3);	 Catch:{ AMapException -> 0x00aa }
    L_0x008a:
        if (r0 == 0) goto L_0x009a;
    L_0x008c:
        r2 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r2 = r2.f958c;	 Catch:{ Exception -> 0x0025 }
        if (r2 == 0) goto L_0x009a;
    L_0x0092:
        r2 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r2 = r2.f958c;	 Catch:{ Exception -> 0x0025 }
        r3 = 0;
        r2.m1504a(r0, r3);	 Catch:{ Exception -> 0x0025 }
    L_0x009a:
        r2 = r5.f1034a;	 Catch:{ Exception -> 0x0025 }
        r2 = r2.f956a;	 Catch:{ Exception -> 0x0025 }
        r3 = 1;
        if (r2 != r3) goto L_0x00c3;
    L_0x00a1:
        r2 = 50;
        java.lang.Thread.sleep(r2);	 Catch:{ Exception -> 0x00b0 }
        r2 = r0;
        r0 = r1;
        goto L_0x0013;
    L_0x00aa:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0025 }
        r0 = r2;
        goto L_0x008a;
    L_0x00b0:
        r2 = move-exception;
        r2 = java.lang.Thread.currentThread();	 Catch:{ Exception -> 0x0025 }
        r2.interrupt();	 Catch:{ Exception -> 0x0025 }
        r2 = r0;
        r0 = r1;
        goto L_0x0013;
    L_0x00bc:
        r0 = r1;
        goto L_0x0013;
    L_0x00bf:
        r0 = r2;
        goto L_0x009a;
    L_0x00c1:
        r1 = r0;
        goto L_0x0052;
    L_0x00c3:
        r2 = r0;
        r0 = r1;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.i.run():void");
    }
}
