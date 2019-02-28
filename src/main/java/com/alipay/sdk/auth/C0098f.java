package com.alipay.sdk.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.alipay.sdk.auth.f */
final class C0098f implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0097e f221a;

    C0098f(C0097e c0097e) {
        this.f221a = c0097e;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f221a.f220b.f204a.f211g = true;
        this.f221a.f219a.proceed();
        dialogInterface.dismiss();
    }
}
