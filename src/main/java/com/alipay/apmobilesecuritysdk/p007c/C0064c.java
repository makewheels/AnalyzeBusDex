package com.alipay.apmobilesecuritysdk.p007c;

import com.alipay.security.mobile.module.p010a.C0161c;

/* renamed from: com.alipay.apmobilesecuritysdk.c.c */
final class C0064c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0063b f133a;

    C0064c(C0063b c0063b) {
        this.f133a = c0063b;
    }

    public final void run() {
        try {
            this.f133a.m172a();
        } catch (Throwable th) {
            C0161c.m563a(th);
        }
    }
}
