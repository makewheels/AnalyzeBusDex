package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.alipay.sdk.app.j */
final class C0086j implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0084h f187a;

    C0086j(C0084h c0084h) {
        this.f187a = c0084h;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f187a.f184a.cancel();
        this.f187a.f185b.f166a.f171e = false;
        C0088l.f189a = C0088l.m224a();
        this.f187a.f185b.f166a.finish();
    }
}
