package com.tencent.smtt.sdk;

import android.content.Intent;
import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.DownloadListener;
import com.tencent.smtt.sdk.p051a.C1091d;

/* renamed from: com.tencent.smtt.sdk.b */
class C1103b implements DownloadListener {
    /* renamed from: a */
    private DownloadListener f5021a;
    /* renamed from: b */
    private WebView f5022b;

    public C1103b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.f5021a = downloadListener;
        this.f5022b = webView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }

    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        if (this.f5021a != null) {
            this.f5021a.onDownloadStart(str, str3, str4, str5, j);
        } else if (QbSdk.canOpenMimeFileType(this.f5022b.getContext(), str5)) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(268435456);
            intent.putExtra("key_reader_sdk_url", str);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str));
            this.f5022b.getContext().startActivity(intent);
        } else {
            C1091d.m7698b(this.f5022b.getContext(), str, null);
        }
    }

    public void onDownloadVideo(String str, long j, int i) {
    }
}
