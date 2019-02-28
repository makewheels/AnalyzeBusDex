package com.tencent.smtt.utils;

import android.widget.Toast;

/* renamed from: com.tencent.smtt.utils.f */
class C1140f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1139e f5133a;

    C1140f(C1139e c1139e) {
        this.f5133a = c1139e;
    }

    public void run() {
        Toast.makeText(this.f5133a.f5128b, "下载成功", 0).show();
        this.f5133a.f5129c.setVisibility(4);
        this.f5133a.f5132f.m7966b(this.f5133a.f5130d, this.f5133a.f5127a, this.f5133a.f5128b);
    }
}
