package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

/* renamed from: com.tencent.smtt.sdk.o */
class C1117o extends FileChooserParams {
    /* renamed from: a */
    final /* synthetic */ IX5WebChromeClient.FileChooserParams f5055a;
    /* renamed from: b */
    final /* synthetic */ C1113k f5056b;

    C1117o(C1113k c1113k, IX5WebChromeClient.FileChooserParams fileChooserParams) {
        this.f5056b = c1113k;
        this.f5055a = fileChooserParams;
    }

    public Intent createIntent() {
        return this.f5055a.createIntent();
    }

    public String[] getAcceptTypes() {
        return this.f5055a.getAcceptTypes();
    }

    public String getFilenameHint() {
        return this.f5055a.getFilenameHint();
    }

    public int getMode() {
        return this.f5055a.getMode();
    }

    public CharSequence getTitle() {
        return this.f5055a.getTitle();
    }

    public boolean isCaptureEnabled() {
        return this.f5055a.isCaptureEnabled();
    }
}
