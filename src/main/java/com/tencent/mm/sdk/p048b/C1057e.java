package com.tencent.mm.sdk.p048b;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.p048b.C1059g.C1056a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.b.e */
final class C1057e extends Handler implements C1056a {
    private Looper aN = getLooper();
    private Callback aO;
    C1054a aP;

    /* renamed from: com.tencent.mm.sdk.b.e$a */
    public interface C1054a {
        /* renamed from: a */
        void mo1712a(Runnable runnable, C1059g c1059g);

        /* renamed from: b */
        void mo1713b(Runnable runnable, C1059g c1059g);
    }

    C1057e(Looper looper, C1054a c1054a) {
        super(looper);
        this.aP = c1054a;
    }

    C1057e(C1054a c1054a) {
        this.aP = c1054a;
    }

    /* renamed from: c */
    public final void mo1714c(Runnable runnable, C1059g c1059g) {
        if (this.aP != null) {
            this.aP.mo1713b(runnable, c1059g);
        }
    }

    public final void dispatchMessage(Message message) {
        if (message.getCallback() == null && this.aO == null) {
            System.currentTimeMillis();
            Debug.threadCpuTimeNanos();
            handleMessage(message);
            if (this.aP != null) {
                this.aN.getThread();
                System.currentTimeMillis();
                Debug.threadCpuTimeNanos();
                return;
            }
            return;
        }
        super.dispatchMessage(message);
    }

    public final void handleMessage(Message message) {
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Assert.assertTrue("msg is null", message != null);
        Runnable callback = message.getCallback();
        if (callback == null) {
            return super.sendMessageAtTime(message, j);
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        C1059g c1059g = new C1059g(this.aN.getThread(), message.getTarget() == null ? this : message.getTarget(), callback, message.obj, this);
        if (uptimeMillis > 0) {
            c1059g.aY = uptimeMillis;
        }
        Message obtain = Message.obtain(message.getTarget(), c1059g);
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.setData(message.getData());
        message.recycle();
        if (this.aP != null) {
            this.aP.mo1712a(callback, c1059g);
        }
        boolean sendMessageAtTime = super.sendMessageAtTime(obtain, j);
        if (!(sendMessageAtTime || this.aP == null)) {
            this.aP.mo1713b(callback, c1059g);
        }
        return sendMessageAtTime;
    }

    public final String toString() {
        return "MMInnerHandler{listener = " + this.aP + "}";
    }
}
