package com.alipay.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* renamed from: com.alipay.sdk.auth.a */
final class C0092a implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ AuthActivity f214a;

    C0092a(AuthActivity authActivity) {
        this.f214a = authActivity;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.f214a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
