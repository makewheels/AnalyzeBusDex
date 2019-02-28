package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;

class ax implements PictureListener {
    /* renamed from: a */
    final /* synthetic */ WebView.PictureListener f4997a;
    /* renamed from: b */
    final /* synthetic */ WebView f4998b;

    ax(WebView webView, WebView.PictureListener pictureListener) {
        this.f4998b = webView;
        this.f4997a = pictureListener;
    }

    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
        this.f4998b.m7673a(iX5WebViewBase);
        this.f4997a.onNewPicture(this.f4998b, picture);
    }

    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
    }
}
