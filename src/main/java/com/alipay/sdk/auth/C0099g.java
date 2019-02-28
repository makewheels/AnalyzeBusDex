package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.alipay.sdk.auth.g */
final class C0099g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0097e f222a;

    C0099g(C0097e c0097e) {
        this.f222a = c0097e;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f222a.f219a.cancel();
        this.f222a.f220b.f204a.f211g = false;
        C0100h.m256a(this.f222a.f220b.f204a, this.f222a.f220b.f204a.f208d + "?resultCode=150");
        this.f222a.f220b.f204a.finish();
    }
}
