package com.alipay.sdk.auth;

/* renamed from: com.alipay.sdk.auth.c */
final class C0095c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f216a;
    /* renamed from: b */
    final /* synthetic */ AuthActivity f217b;

    C0095c(AuthActivity authActivity, String str) {
        this.f217b = authActivity;
        this.f216a = str;
    }

    public final void run() {
        try {
            this.f217b.f207c.loadUrl("javascript:" + this.f216a);
        } catch (Exception e) {
        }
    }
}
