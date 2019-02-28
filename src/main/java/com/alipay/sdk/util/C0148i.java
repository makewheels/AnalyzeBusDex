package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay.Stub;

/* renamed from: com.alipay.sdk.util.i */
final class C0148i implements ServiceConnection {
    /* renamed from: a */
    final /* synthetic */ C0147h f463a;

    C0148i(C0147h c0147h) {
        this.f463a = c0147h;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f463a.f455d) {
            this.f463a.f454c = Stub.asInterface(iBinder);
            this.f463a.f455d.notify();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f463a.f454c = null;
    }
}
