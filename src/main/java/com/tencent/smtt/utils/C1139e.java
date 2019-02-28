package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.C1138d.C1137a;

/* renamed from: com.tencent.smtt.utils.e */
class C1139e implements C1137a {
    /* renamed from: a */
    final /* synthetic */ WebView f5127a;
    /* renamed from: b */
    final /* synthetic */ Context f5128b;
    /* renamed from: c */
    final /* synthetic */ RelativeLayout f5129c;
    /* renamed from: d */
    final /* synthetic */ String f5130d;
    /* renamed from: e */
    final /* synthetic */ TextView f5131e;
    /* renamed from: f */
    final /* synthetic */ C1138d f5132f;

    C1139e(C1138d c1138d, WebView webView, Context context, RelativeLayout relativeLayout, String str, TextView textView) {
        this.f5132f = c1138d;
        this.f5127a = webView;
        this.f5128b = context;
        this.f5129c = relativeLayout;
        this.f5130d = str;
        this.f5131e = textView;
    }

    /* renamed from: a */
    public void mo1906a() {
        this.f5127a.post(new C1140f(this));
    }

    /* renamed from: a */
    public void mo1907a(int i) {
        this.f5127a.post(new C1141g(this, i));
    }

    /* renamed from: a */
    public void mo1908a(Throwable th) {
        this.f5127a.post(new C1142h(this));
    }
}
