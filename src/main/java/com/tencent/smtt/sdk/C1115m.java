package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

/* renamed from: com.tencent.smtt.sdk.m */
class C1115m implements ValueCallback<Uri> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f5051a;
    /* renamed from: b */
    final /* synthetic */ C1113k f5052b;

    C1115m(C1113k c1113k, ValueCallback valueCallback) {
        this.f5052b = c1113k;
        this.f5051a = valueCallback;
    }

    /* renamed from: a */
    public void m7865a(Uri uri) {
        this.f5051a.onReceiveValue(new Uri[]{uri});
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        m7865a((Uri) obj);
    }
}
