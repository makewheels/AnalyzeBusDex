package com.tencent.smtt.utils;

/* renamed from: com.tencent.smtt.utils.g */
class C1141g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f5134a;
    /* renamed from: b */
    final /* synthetic */ C1139e f5135b;

    C1141g(C1139e c1139e, int i) {
        this.f5135b = c1139e;
        this.f5134a = i;
    }

    public void run() {
        this.f5135b.f5131e.setText("已下载" + this.f5134a + "%");
    }
}
