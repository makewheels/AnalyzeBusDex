package com.amap.api.mapcore;

import android.os.Handler;
import android.os.RemoteException;

/* compiled from: UiSettingsDelegateImp */
class bg implements ai {
    /* renamed from: a */
    final Handler f1710a = new bh(this);
    /* renamed from: b */
    private C0313u f1711b;
    /* renamed from: c */
    private boolean f1712c = true;
    /* renamed from: d */
    private boolean f1713d = true;
    /* renamed from: e */
    private boolean f1714e = true;
    /* renamed from: f */
    private boolean f1715f = false;
    /* renamed from: g */
    private boolean f1716g = true;
    /* renamed from: h */
    private boolean f1717h = true;
    /* renamed from: i */
    private boolean f1718i = true;
    /* renamed from: j */
    private boolean f1719j = false;
    /* renamed from: k */
    private int f1720k = 0;
    /* renamed from: l */
    private int f1721l = 1;

    bg(C0313u c0313u) {
        this.f1711b = c0313u;
    }

    /* renamed from: a */
    public void mo536a(boolean z) throws RemoteException {
        this.f1719j = z;
        this.f1710a.obtainMessage(1).sendToTarget();
    }

    /* renamed from: b */
    public void mo539b(boolean z) throws RemoteException {
        this.f1717h = z;
        this.f1710a.obtainMessage(0).sendToTarget();
    }

    /* renamed from: c */
    public void mo541c(boolean z) throws RemoteException {
        this.f1718i = z;
        this.f1710a.obtainMessage(2).sendToTarget();
    }

    /* renamed from: d */
    public void mo543d(boolean z) throws RemoteException {
        this.f1715f = z;
        this.f1710a.obtainMessage(3).sendToTarget();
    }

    /* renamed from: e */
    public void mo545e(boolean z) throws RemoteException {
        this.f1713d = z;
    }

    /* renamed from: f */
    public void mo547f(boolean z) throws RemoteException {
        this.f1716g = z;
    }

    /* renamed from: g */
    public void mo549g(boolean z) throws RemoteException {
        this.f1714e = z;
    }

    /* renamed from: h */
    public void mo551h(boolean z) throws RemoteException {
        this.f1712c = z;
    }

    /* renamed from: i */
    public void mo554i(boolean z) throws RemoteException {
        mo551h(z);
        mo549g(z);
        mo547f(z);
        mo545e(z);
    }

    /* renamed from: a */
    public void mo535a(int i) throws RemoteException {
        this.f1720k = i;
        this.f1711b.mo398d(i);
    }

    /* renamed from: b */
    public void mo538b(int i) throws RemoteException {
        this.f1721l = i;
        this.f1711b.mo400e(i);
    }

    /* renamed from: a */
    public boolean mo537a() throws RemoteException {
        return this.f1719j;
    }

    /* renamed from: b */
    public boolean mo540b() throws RemoteException {
        return this.f1717h;
    }

    /* renamed from: c */
    public boolean mo542c() throws RemoteException {
        return this.f1718i;
    }

    /* renamed from: d */
    public boolean mo544d() throws RemoteException {
        return this.f1715f;
    }

    /* renamed from: e */
    public boolean mo546e() throws RemoteException {
        return this.f1713d;
    }

    /* renamed from: f */
    public boolean mo548f() throws RemoteException {
        return this.f1716g;
    }

    /* renamed from: g */
    public boolean mo550g() throws RemoteException {
        return this.f1714e;
    }

    /* renamed from: h */
    public boolean mo552h() throws RemoteException {
        return this.f1712c;
    }

    /* renamed from: i */
    public int mo553i() throws RemoteException {
        return this.f1720k;
    }

    /* renamed from: j */
    public int mo555j() throws RemoteException {
        return this.f1721l;
    }
}
