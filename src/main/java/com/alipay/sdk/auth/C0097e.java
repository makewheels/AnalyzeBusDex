package com.alipay.sdk.auth;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.auth.AuthActivity.C0091b;
import com.alipay.sdk.widget.C0154d;

/* renamed from: com.alipay.sdk.auth.e */
final class C0097e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f219a;
    /* renamed from: b */
    final /* synthetic */ C0091b f220b;

    C0097e(C0091b c0091b, SslErrorHandler sslErrorHandler) {
        this.f220b = c0091b;
        this.f219a = sslErrorHandler;
    }

    public final void run() {
        C0154d.m547a(this.f220b.f204a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new C0098f(this), "退出", new C0099g(this));
    }
}
