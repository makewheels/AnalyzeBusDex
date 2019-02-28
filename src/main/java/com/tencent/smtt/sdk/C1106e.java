package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

/* renamed from: com.tencent.smtt.sdk.e */
final class C1106e extends Handler {
    /* renamed from: a */
    final /* synthetic */ Context f5028a;
    /* renamed from: b */
    final /* synthetic */ PreInitCallback f5029b;

    C1106e(Looper looper, Context context, PreInitCallback preInitCallback) {
        this.f5028a = context;
        this.f5029b = preInitCallback;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ap a = C1110i.m7845a(true).m7852a();
                if (a != null) {
                    a.m7769a(this.f5028a);
                }
                if (this.f5029b != null) {
                    this.f5029b.onViewInitFinished();
                    return;
                }
                return;
            case 2:
                WebView webView = new WebView(this.f5028a);
                if (this.f5029b != null) {
                    this.f5029b.onViewInitFinished();
                    return;
                }
                return;
            case 3:
                if (this.f5029b != null) {
                    this.f5029b.onCoreInitFinished();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
