package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.app.H5AuthActivity.C0075a;
import com.alipay.sdk.widget.C0154d;

/* renamed from: com.alipay.sdk.app.c */
final class C0079c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f178a;
    /* renamed from: b */
    final /* synthetic */ C0075a f179b;

    C0079c(C0075a c0075a, SslErrorHandler sslErrorHandler) {
        this.f179b = c0075a;
        this.f178a = sslErrorHandler;
    }

    public final void run() {
        C0154d.m547a(this.f179b.f159a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new C0080d(this), "退出", new C0081e(this));
    }
}
