package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

/* renamed from: com.tencent.smtt.sdk.n */
class C1116n implements ValueCallback<Uri[]> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f5053a;
    /* renamed from: b */
    final /* synthetic */ C1113k f5054b;

    C1116n(C1113k c1113k, ValueCallback valueCallback) {
        this.f5054b = c1113k;
        this.f5053a = valueCallback;
    }

    /* renamed from: a */
    public void m7866a(Uri[] uriArr) {
        this.f5053a.onReceiveValue(uriArr);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        m7866a((Uri[]) obj);
    }
}
