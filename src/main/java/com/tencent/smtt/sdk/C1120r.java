package com.tencent.smtt.sdk;

import android.os.Message;
import android.webkit.WebView;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* renamed from: com.tencent.smtt.sdk.r */
class C1120r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ WebViewTransport f5062a;
    /* renamed from: b */
    final /* synthetic */ Message f5063b;
    /* renamed from: c */
    final /* synthetic */ SystemWebChromeClient f5064c;

    C1120r(SystemWebChromeClient systemWebChromeClient, WebViewTransport webViewTransport, Message message) {
        this.f5064c = systemWebChromeClient;
        this.f5062a = webViewTransport;
        this.f5063b = message;
    }

    public void run() {
        WebView webView = this.f5062a.getWebView();
        if (webView != null) {
            ((WebView.WebViewTransport) this.f5063b.obj).setWebView(webView.m7670a());
        }
        this.f5063b.sendToTarget();
    }
}
