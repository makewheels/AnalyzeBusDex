package com.tencent.mm.sdk.p048b;

import android.os.Looper;
import com.tencent.mm.sdk.p048b.C1057e.C1054a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.sdk.b.d */
public final class C1055d implements C1054a {
    private C1057e aJ;
    private ConcurrentHashMap<Runnable, WeakReference<C1059g>> aK;
    private int aL;
    private LinkedList<WeakReference<C1059g>> aM;

    public C1055d() {
        this.aK = new ConcurrentHashMap();
        this.aM = new LinkedList();
        this.aJ = new C1057e(this);
        if (this.aJ.getLooper().getThread().getName().equals("initThread")) {
            C1052b.m7514a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", C1060h.m7531u());
        }
    }

    public C1055d(Looper looper) {
        this.aK = new ConcurrentHashMap();
        this.aM = new LinkedList();
        this.aJ = new C1057e(looper, this);
        if (looper.getThread().getName().equals("initThread")) {
            C1052b.m7514a("MicroMsg.MMHandler", "MMHandler can not init handler with initThread looper, stack %s", C1060h.m7531u());
        }
    }

    /* renamed from: a */
    public final void mo1712a(Runnable runnable, C1059g c1059g) {
        this.aK.put(runnable, new WeakReference(c1059g));
    }

    /* renamed from: b */
    public final void mo1713b(Runnable runnable, C1059g c1059g) {
        WeakReference weakReference = (WeakReference) this.aK.get(runnable);
        if (weakReference != null && weakReference.get() != null && weakReference.get() == c1059g) {
            this.aK.remove(runnable);
            if (this.aL > 0) {
                if (this.aM.size() == this.aL) {
                    this.aM.pop();
                }
                this.aM.add(weakReference);
            }
        }
    }

    public final boolean post(Runnable runnable) {
        return this.aJ.post(runnable);
    }

    public final String toString() {
        return "MMHandler(" + getClass().getName() + ")";
    }
}
