package com.alipay.sdk.widget;

import android.app.Activity;
import android.app.ProgressDialog;

/* renamed from: com.alipay.sdk.widget.a */
public final class C0151a {
    /* renamed from: a */
    Activity f468a;
    /* renamed from: b */
    ProgressDialog f469b;

    public C0151a(Activity activity) {
        this.f468a = activity;
    }

    /* renamed from: a */
    private void m541a(CharSequence charSequence) {
        m545c();
        Runnable c0152b = new C0152b(this, charSequence);
        if (this.f468a != null && !this.f468a.isFinishing()) {
            this.f468a.runOnUiThread(c0152b);
        }
    }

    /* renamed from: a */
    public final boolean m543a() {
        return this.f469b != null && this.f469b.isShowing();
    }

    /* renamed from: b */
    public final void m544b() {
        m545c();
        Runnable c0152b = new C0152b(this, "正在加载");
        if (this.f468a != null && !this.f468a.isFinishing()) {
            this.f468a.runOnUiThread(c0152b);
        }
    }

    /* renamed from: c */
    public final void m545c() {
        Runnable c0153c = new C0153c(this);
        if (this.f468a != null && !this.f468a.isFinishing()) {
            this.f468a.runOnUiThread(c0153c);
        }
    }
}
