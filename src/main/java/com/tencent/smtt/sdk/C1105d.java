package com.tencent.smtt.sdk;

/* renamed from: com.tencent.smtt.sdk.d */
class C1105d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f5026a;
    /* renamed from: b */
    final /* synthetic */ C1104c f5027b;

    C1105d(C1104c c1104c, boolean z) {
        this.f5027b = c1104c;
        this.f5026a = z;
    }

    public void run() {
        this.f5027b.f5025c.onReceiveValue(Boolean.valueOf(this.f5026a));
    }
}
