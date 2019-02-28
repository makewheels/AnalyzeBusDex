package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;

class at extends X5ProxyWebViewClientExtension {
    /* renamed from: a */
    final /* synthetic */ WebView f4990a;

    at(WebView webView, IX5WebViewClientExtension iX5WebViewClientExtension) {
        this.f4990a = webView;
        super(iX5WebViewClientExtension);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.f4990a.onScrollChanged(i3, i4, i, i2);
    }
}
