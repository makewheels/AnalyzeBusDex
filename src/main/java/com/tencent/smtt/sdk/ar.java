package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.WebIconDatabase.C1083a;

class ar implements IconListener {
    /* renamed from: a */
    final /* synthetic */ C1083a f4986a;
    /* renamed from: b */
    final /* synthetic */ WebIconDatabase f4987b;

    ar(WebIconDatabase webIconDatabase, C1083a c1083a) {
        this.f4987b = webIconDatabase;
        this.f4986a = c1083a;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        this.f4986a.m7648a(str, bitmap);
    }
}
