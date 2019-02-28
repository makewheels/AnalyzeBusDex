package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.alipay.sdk.app.e */
final class C0081e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0079c f181a;

    C0081e(C0079c c0079c) {
        this.f181a = c0079c;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f181a.f178a.cancel();
        this.f181a.f179b.f159a.f163d = false;
        C0088l.f189a = C0088l.m224a();
        this.f181a.f179b.f159a.finish();
    }
}
