package com.alipay.apmobilesecuritysdk.p004a;

/* renamed from: com.alipay.apmobilesecuritysdk.a.c */
final class C0054c extends Thread {
    /* renamed from: a */
    final /* synthetic */ String f102a;
    /* renamed from: b */
    final /* synthetic */ String f103b;
    /* renamed from: c */
    final /* synthetic */ String f104c;
    /* renamed from: d */
    final /* synthetic */ C0052a f105d;

    C0054c(C0052a c0052a, String str, String str2, String str3) {
        this.f105d = c0052a;
        this.f102a = str;
        this.f103b = str2;
        this.f104c = str3;
    }

    public final void run() {
        C0052a.m135a(this.f105d, this.f102a, this.f103b, this.f104c);
    }
}
