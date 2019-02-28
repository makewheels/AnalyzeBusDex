package com.tencent.smtt.utils;

import android.widget.Toast;

/* renamed from: com.tencent.smtt.utils.h */
class C1142h implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1139e f5136a;

    C1142h(C1139e c1139e) {
        this.f5136a = c1139e;
    }

    public void run() {
        Toast.makeText(this.f5136a.f5128b, "下载失败，请检查网络", 0).show();
    }
}
