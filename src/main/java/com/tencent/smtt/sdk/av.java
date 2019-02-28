package com.tencent.smtt.sdk;

import android.webkit.DownloadListener;
import com.tencent.smtt.sdk.p051a.C1091d;

class av implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ DownloadListener f4993a;
    /* renamed from: b */
    final /* synthetic */ WebView f4994b;

    av(WebView webView, DownloadListener downloadListener) {
        this.f4994b = webView;
        this.f4993a = downloadListener;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.f4993a == null) {
            C1091d.m7698b(this.f4994b.f4909j, str, null);
        } else {
            this.f4993a.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
