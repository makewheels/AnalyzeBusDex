package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;

class au implements FindListener {
    /* renamed from: a */
    final /* synthetic */ IX5WebViewBase.FindListener f4991a;
    /* renamed from: b */
    final /* synthetic */ WebView f4992b;

    au(WebView webView, IX5WebViewBase.FindListener findListener) {
        this.f4992b = webView;
        this.f4991a = findListener;
    }

    public void onFindResultReceived(int i, int i2, boolean z) {
        this.f4991a.onFindResultReceived(i, i2, z);
    }
}
