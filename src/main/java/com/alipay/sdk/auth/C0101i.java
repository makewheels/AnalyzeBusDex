package com.alipay.sdk.auth;

import android.app.Activity;
import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.net.C0125d;

/* renamed from: com.alipay.sdk.auth.i */
final class C0101i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0125d f227a;
    /* renamed from: b */
    final /* synthetic */ Activity f228b;
    /* renamed from: c */
    final /* synthetic */ C0115e f229c;
    /* renamed from: d */
    final /* synthetic */ APAuthInfo f230d;

    C0101i(C0125d c0125d, Activity activity, C0115e c0115e, APAuthInfo aPAuthInfo) {
        this.f227a = c0125d;
        this.f228b = activity;
        this.f229c = c0115e;
        this.f230d = aPAuthInfo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0051 in list [B:12:0x004a]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r1 = 0;
        r2 = 0;
        r0 = r6.f227a;	 Catch:{ NetErrorException -> 0x0052 }
        r3 = r6.f228b;	 Catch:{ NetErrorException -> 0x0052 }
        r4 = r6.f229c;	 Catch:{ NetErrorException -> 0x0052 }
        r5 = 0;	 Catch:{ NetErrorException -> 0x0052 }
        r0 = r0.m407a(r3, r4, r5);	 Catch:{ NetErrorException -> 0x0052 }
    L_0x000d:
        r2 = com.alipay.sdk.auth.C0100h.f225c;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        if (r2 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x0013:
        r2 = com.alipay.sdk.auth.C0100h.f225c;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2.m545c();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        com.alipay.sdk.auth.C0100h.f225c = null;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x001d:
        if (r0 != 0) goto L_0x0058;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x001f:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0.<init>();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = r6.f230d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = r1.getRedirectUri();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = "?resultCode=202";	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        com.alipay.sdk.auth.C0100h.f226d = r0;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r6.f228b;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = com.alipay.sdk.auth.C0100h.f226d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        com.alipay.sdk.auth.C0100h.m256a(r0, r1);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        if (r0 == 0) goto L_0x0051;
    L_0x004a:
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        r0.m545c();
    L_0x0051:
        return;
    L_0x0052:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r2;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        goto L_0x000d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x0058:
        r0 = r0.f393c;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2 = "form";	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0.optJSONObject(r2);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2 = "onload";	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = com.alipay.sdk.protocol.C0127b.m426a(r0, r2);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2 = com.alipay.sdk.protocol.C0126a.m408a(r0);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r3 = r2.length;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r1;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x006c:
        if (r0 >= r3) goto L_0x0082;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x006e:
        r1 = r2[r0];	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r4 = com.alipay.sdk.protocol.C0126a.WapPay;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        if (r1 != r4) goto L_0x00bf;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x0074:
        r0 = r1.m415e();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = com.alipay.sdk.util.C0140a.m489a(r0);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = 0;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0[r1];	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        com.alipay.sdk.auth.C0100h.f226d = r0;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x0082:
        r0 = com.alipay.sdk.auth.C0100h.f226d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        if (r0 == 0) goto L_0x00c2;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
    L_0x008c:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0.<init>();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = r6.f230d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = r1.getRedirectUri();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = "?resultCode=202";	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        com.alipay.sdk.auth.C0100h.f226d = r0;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = r6.f228b;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = com.alipay.sdk.auth.C0100h.f226d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        com.alipay.sdk.auth.C0100h.m256a(r0, r1);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        if (r0 == 0) goto L_0x0051;
    L_0x00b7:
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        r0.m545c();
        goto L_0x0051;
    L_0x00bf:
        r0 = r0 + 1;
        goto L_0x006c;
    L_0x00c2:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = r6.f228b;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2 = com.alipay.sdk.auth.AuthActivity.class;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = "params";	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2 = com.alipay.sdk.auth.C0100h.f226d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0.putExtra(r1, r2);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = "redirectUri";	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2 = r6.f230d;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r2 = r2.getRedirectUri();	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0.putExtra(r1, r2);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1 = r6.f228b;	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r1.startActivity(r0);	 Catch:{ Exception -> 0x00f3, all -> 0x0103 }
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        if (r0 == 0) goto L_0x0051;
    L_0x00ea:
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        r0.m545c();
        goto L_0x0051;
    L_0x00f3:
        r0 = move-exception;
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        if (r0 == 0) goto L_0x0051;
    L_0x00fa:
        r0 = com.alipay.sdk.auth.C0100h.f225c;
        r0.m545c();
        goto L_0x0051;
    L_0x0103:
        r0 = move-exception;
        r1 = com.alipay.sdk.auth.C0100h.f225c;
        if (r1 == 0) goto L_0x0111;
    L_0x010a:
        r1 = com.alipay.sdk.auth.C0100h.f225c;
        r1.m545c();
    L_0x0111:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.i.run():void");
    }
}
