package com.tencent.mm.sdk.diffdev.p050a;

import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.diffdev.a.c */
final class C1066c implements Runnable {
    final /* synthetic */ C1065b ah;

    C1066c(C1065b c1065b) {
        this.ah = c1065b;
    }

    public final void run() {
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.ah.ag.ad);
        for (OAuthListener onQrcodeScanned : arrayList) {
            onQrcodeScanned.onQrcodeScanned();
        }
    }
}
