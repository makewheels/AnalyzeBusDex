package com.amap.api.p015a;

import android.os.Handler;
import android.os.RemoteException;

/* compiled from: UiSettingsDelegateImp */
/* renamed from: com.amap.api.a.cb */
class cb implements aq {
    /* renamed from: a */
    final Handler f983a = new cc(this);
    /* renamed from: b */
    private af f984b;
    /* renamed from: c */
    private boolean f985c = true;
    /* renamed from: d */
    private boolean f986d = false;
    /* renamed from: e */
    private boolean f987e = true;
    /* renamed from: f */
    private boolean f988f = true;
    /* renamed from: g */
    private boolean f989g = true;
    /* renamed from: h */
    private boolean f990h = false;
    /* renamed from: i */
    private int f991i = 0;
    /* renamed from: j */
    private int f992j = 0;

    cb(af afVar) {
        this.f984b = afVar;
    }

    /* renamed from: a */
    public void mo239a(boolean z) throws RemoteException {
        this.f990h = z;
        this.f983a.obtainMessage(1).sendToTarget();
    }

    /* renamed from: b */
    public void mo242b(boolean z) throws RemoteException {
        this.f988f = z;
        this.f983a.obtainMessage(0).sendToTarget();
    }

    /* renamed from: c */
    public void mo244c(boolean z) throws RemoteException {
        this.f989g = z;
        this.f983a.obtainMessage(2).sendToTarget();
    }

    /* renamed from: d */
    public void mo246d(boolean z) throws RemoteException {
        this.f986d = z;
        this.f983a.obtainMessage(3).sendToTarget();
    }

    /* renamed from: e */
    public void mo248e(boolean z) throws RemoteException {
        this.f985c = z;
    }

    /* renamed from: f */
    public void mo250f(boolean z) throws RemoteException {
        this.f987e = z;
    }

    /* renamed from: g */
    public void mo253g(boolean z) throws RemoteException {
        mo250f(z);
        mo248e(z);
    }

    /* renamed from: a */
    public void mo238a(int i) throws RemoteException {
        this.f991i = i;
        this.f984b.mo122c(i);
    }

    /* renamed from: b */
    public void mo241b(int i) throws RemoteException {
        this.f992j = i;
        this.f984b.mo126d(i);
    }

    /* renamed from: a */
    public boolean mo240a() throws RemoteException {
        return this.f990h;
    }

    /* renamed from: b */
    public boolean mo243b() throws RemoteException {
        return this.f988f;
    }

    /* renamed from: c */
    public boolean mo245c() throws RemoteException {
        return this.f989g;
    }

    /* renamed from: d */
    public boolean mo247d() throws RemoteException {
        return this.f986d;
    }

    /* renamed from: e */
    public boolean mo249e() throws RemoteException {
        return this.f985c;
    }

    /* renamed from: f */
    public boolean mo251f() throws RemoteException {
        return this.f987e;
    }

    /* renamed from: g */
    public int mo252g() throws RemoteException {
        return this.f991i;
    }

    /* renamed from: h */
    public int mo254h() throws RemoteException {
        return this.f992j;
    }
}
