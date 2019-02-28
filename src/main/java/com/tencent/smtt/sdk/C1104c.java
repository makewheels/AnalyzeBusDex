package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* renamed from: com.tencent.smtt.sdk.c */
final class C1104c extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f5023a;
    /* renamed from: b */
    final /* synthetic */ String f5024b;
    /* renamed from: c */
    final /* synthetic */ ValueCallback f5025c;

    C1104c(Context context, String str, ValueCallback valueCallback) {
        this.f5023a = context;
        this.f5024b = str;
        this.f5025c = valueCallback;
    }

    public void run() {
        C1110i a = C1110i.m7845a(true);
        a.m7853a(this.f5023a);
        boolean z = false;
        if (a.m7858b()) {
            z = a.m7852a().m7778a(this.f5023a, this.f5024b);
        }
        new Handler(Looper.getMainLooper()).post(new C1105d(this, z));
    }
}
