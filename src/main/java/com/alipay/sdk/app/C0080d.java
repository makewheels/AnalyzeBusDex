package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.alipay.sdk.app.d */
final class C0080d implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0079c f180a;

    C0080d(C0079c c0079c) {
        this.f180a = c0079c;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f180a.f179b.f159a.f163d = true;
        this.f180a.f178a.proceed();
        dialogInterface.dismiss();
    }
}
