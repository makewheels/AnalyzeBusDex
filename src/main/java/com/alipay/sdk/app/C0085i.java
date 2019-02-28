package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.alipay.sdk.app.i */
final class C0085i implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0084h f186a;

    C0085i(C0084h c0084h) {
        this.f186a = c0084h;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f186a.f185b.f166a.f171e = true;
        this.f186a.f184a.proceed();
        dialogInterface.dismiss();
    }
}
