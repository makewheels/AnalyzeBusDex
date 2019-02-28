package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* renamed from: com.alipay.sdk.app.a */
final class C0077a implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ H5AuthActivity f176a;

    C0077a(H5AuthActivity h5AuthActivity) {
        this.f176a = h5AuthActivity;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.f176a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
