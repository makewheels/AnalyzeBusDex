package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;
import com.tencent.smtt.sdk.WebIconDatabase.C1083a;

class as implements IconListener {
    /* renamed from: a */
    final /* synthetic */ C1083a f4988a;
    /* renamed from: b */
    final /* synthetic */ WebIconDatabase f4989b;

    as(WebIconDatabase webIconDatabase, C1083a c1083a) {
        this.f4989b = webIconDatabase;
        this.f4988a = c1083a;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        this.f4988a.m7648a(str, bitmap);
    }
}
