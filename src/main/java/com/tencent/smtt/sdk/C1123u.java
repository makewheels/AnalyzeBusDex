package com.tencent.smtt.sdk;

import android.content.Intent;
import android.webkit.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

/* renamed from: com.tencent.smtt.sdk.u */
class C1123u extends FileChooserParams {
    /* renamed from: a */
    final /* synthetic */ WebChromeClient.FileChooserParams f5069a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f5070b;

    C1123u(SystemWebChromeClient systemWebChromeClient, WebChromeClient.FileChooserParams fileChooserParams) {
        this.f5070b = systemWebChromeClient;
        this.f5069a = fileChooserParams;
    }

    public Intent createIntent() {
        return this.f5069a.createIntent();
    }

    public String[] getAcceptTypes() {
        return this.f5069a.getAcceptTypes();
    }

    public String getFilenameHint() {
        return this.f5069a.getFilenameHint();
    }

    public int getMode() {
        return this.f5069a.getMode();
    }

    public CharSequence getTitle() {
        return this.f5069a.getTitle();
    }

    public boolean isCaptureEnabled() {
        return this.f5069a.isCaptureEnabled();
    }
}
