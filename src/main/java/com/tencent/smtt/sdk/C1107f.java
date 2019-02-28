package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;

/* renamed from: com.tencent.smtt.sdk.f */
final class C1107f extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f5030a;
    /* renamed from: b */
    final /* synthetic */ Handler f5031b;

    C1107f(Context context, Handler handler) {
        this.f5030a = context;
        this.f5031b = handler;
    }

    public void run() {
        if (ac.m7706a().m7744c(this.f5030a) == 0) {
            ac.m7706a().m7737a(this.f5030a, true);
        }
        C1110i a = C1110i.m7845a(true);
        a.m7855a(this.f5030a, false, true);
        if (TbsShareManager.isThirdPartyApp(this.f5030a)) {
            if (!TbsShareManager.forceLoadX5FromTBSDemo(this.f5030a.getApplicationContext())) {
                TbsDownloader.needDownload(this.f5030a, false);
            }
            if (!(WebView.mSysWebviewCreated || QbSdk.f4785d)) {
                QbSdk.f4782a = false;
            }
        }
        boolean b = a.m7858b();
        this.f5031b.sendEmptyMessage(3);
        if (b) {
            this.f5031b.sendEmptyMessage(1);
        } else {
            this.f5031b.sendEmptyMessage(2);
        }
    }
}
