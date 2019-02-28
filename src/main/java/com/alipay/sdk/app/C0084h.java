package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.app.H5PayActivity.C0076a;
import com.alipay.sdk.widget.C0154d;

/* renamed from: com.alipay.sdk.app.h */
final class C0084h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SslErrorHandler f184a;
    /* renamed from: b */
    final /* synthetic */ C0076a f185b;

    C0084h(C0076a c0076a, SslErrorHandler sslErrorHandler) {
        this.f185b = c0076a;
        this.f184a = sslErrorHandler;
    }

    public final void run() {
        C0154d.m547a(this.f185b.f166a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new C0085i(this), "退出", new C0086j(this));
    }
}
