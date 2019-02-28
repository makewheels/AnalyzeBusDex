package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;

/* renamed from: com.tencent.smtt.sdk.q */
class C1119q implements ValueCallback<String[]> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f5060a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f5061b;

    C1119q(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.f5061b = systemWebChromeClient;
        this.f5060a = valueCallback;
    }

    /* renamed from: a */
    public void m7869a(String[] strArr) {
        this.f5060a.onReceiveValue(strArr);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        m7869a((String[]) obj);
    }
}
