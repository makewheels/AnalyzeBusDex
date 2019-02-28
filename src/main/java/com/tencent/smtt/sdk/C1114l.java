package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* renamed from: com.tencent.smtt.sdk.l */
class C1114l implements Runnable {
    /* renamed from: a */
    final /* synthetic */ WebViewTransport f5048a;
    /* renamed from: b */
    final /* synthetic */ Message f5049b;
    /* renamed from: c */
    final /* synthetic */ C1113k f5050c;

    C1114l(C1113k c1113k, WebViewTransport webViewTransport, Message message) {
        this.f5050c = c1113k;
        this.f5048a = webViewTransport;
        this.f5049b = message;
    }

    public void run() {
        WebView webView = this.f5048a.getWebView();
        if (webView != null) {
            ((IX5WebViewBase.WebViewTransport) this.f5049b.obj).setWebView(webView.m7674b());
        }
        this.f5049b.sendToTarget();
    }
}
