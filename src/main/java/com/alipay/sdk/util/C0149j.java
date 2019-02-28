package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback.Stub;

/* renamed from: com.alipay.sdk.util.j */
final class C0149j extends Stub {
    /* renamed from: a */
    final /* synthetic */ C0147h f464a;

    C0149j(C0147h c0147h) {
        this.f464a = c0147h;
    }

    public final boolean isHideLoadingScreen() throws RemoteException {
        return false;
    }

    public final void payEnd(boolean z, String str) throws RemoteException {
    }

    public final void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putInt("CallingPid", i);
            intent.putExtras(bundle);
        } catch (Exception e) {
        }
        intent.setClassName(str, str2);
        ((Activity) this.f464a.f453b.get()).startActivity(intent);
    }
}
