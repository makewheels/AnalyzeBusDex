package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

/* renamed from: com.tencent.smtt.sdk.t */
class C1122t implements ValueCallback<Uri[]> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f5067a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f5068b;

    C1122t(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.f5068b = systemWebChromeClient;
        this.f5067a = valueCallback;
    }

    /* renamed from: a */
    public void m7871a(Uri[] uriArr) {
        this.f5067a.onReceiveValue(uriArr);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        m7871a((Uri[]) obj);
    }
}
