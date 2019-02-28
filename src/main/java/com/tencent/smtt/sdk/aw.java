package com.tencent.smtt.sdk;

import android.graphics.Picture;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;

class aw implements PictureListener {
    /* renamed from: a */
    final /* synthetic */ WebView.PictureListener f4995a;
    /* renamed from: b */
    final /* synthetic */ WebView f4996b;

    aw(WebView webView, WebView.PictureListener pictureListener) {
        this.f4996b = webView;
        this.f4995a = pictureListener;
    }

    public void onNewPicture(WebView webView, Picture picture) {
        this.f4996b.m7672a(webView);
        this.f4995a.onNewPicture(this.f4996b, picture);
    }
}
