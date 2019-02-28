package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

/* renamed from: com.tencent.smtt.sdk.s */
class C1121s implements ValueCallback<Uri> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f5065a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f5066b;

    C1121s(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.f5066b = systemWebChromeClient;
        this.f5065a = valueCallback;
    }

    /* renamed from: a */
    public void m7870a(Uri uri) {
        this.f5065a.onReceiveValue(uri);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        m7870a((Uri) obj);
    }
}
