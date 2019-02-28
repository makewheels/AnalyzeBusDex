package com.alipay.sdk.widget;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;

/* renamed from: com.alipay.sdk.widget.b */
final class C0152b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f470a = false;
    /* renamed from: b */
    final /* synthetic */ OnCancelListener f471b = null;
    /* renamed from: c */
    final /* synthetic */ CharSequence f472c;
    /* renamed from: d */
    final /* synthetic */ C0151a f473d;

    C0152b(C0151a c0151a, CharSequence charSequence) {
        this.f473d = c0151a;
        this.f472c = charSequence;
    }

    public final void run() {
        if (this.f473d.f469b == null) {
            this.f473d.f469b = new ProgressDialog(this.f473d.f468a);
        }
        this.f473d.f469b.setCancelable(this.f470a);
        this.f473d.f469b.setOnCancelListener(this.f471b);
        this.f473d.f469b.setMessage(this.f472c);
        try {
            this.f473d.f469b.show();
        } catch (Exception e) {
            this.f473d.f469b = null;
        }
    }
}
