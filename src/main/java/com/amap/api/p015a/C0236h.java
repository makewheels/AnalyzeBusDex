package com.amap.api.p015a;

import android.content.Context;
import com.amap.api.maps2d.AMapException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Vector;

/* compiled from: AsyncServer */
/* renamed from: com.amap.api.a.h */
abstract class C0236h<T, V> extends bc {
    /* renamed from: a */
    protected volatile boolean f956a = true;
    /* renamed from: b */
    protected Vector<Thread> f957b = null;
    /* renamed from: c */
    protected br<T> f958c;
    /* renamed from: d */
    protected bs f959d;
    /* renamed from: g */
    private Runnable f960g = new C0246i(this);
    /* renamed from: h */
    private Runnable f961h = new C0247j(this);

    /* renamed from: a */
    protected abstract ArrayList<T> mo223a(ArrayList<T> arrayList) throws AMapException;

    /* renamed from: a */
    protected abstract ArrayList<T> mo224a(ArrayList<T> arrayList, Proxy proxy) throws AMapException;

    /* renamed from: e */
    protected abstract int mo226e();

    /* renamed from: f */
    protected abstract int mo227f();

    public C0236h(bf bfVar, Context context) {
        super(bfVar, context);
        if (this.f957b == null) {
            this.f957b = new Vector();
        }
        this.f959d = new bs(mo226e(), this.f961h, this.f960g);
        this.f959d.m1508a();
    }

    /* renamed from: a */
    public void mo220a() {
        this.f958c.m1503a();
        m1548d();
        this.f958c.m1507c();
        this.f958c = null;
        this.e = null;
        this.f = null;
    }

    /* renamed from: b */
    public void mo221b() {
        super.mo221b();
        m1548d();
    }

    /* renamed from: c */
    public void mo222c() {
        this.f956a = true;
        if (this.f957b == null) {
            this.f957b = new Vector();
        }
        if (this.f959d == null) {
            this.f959d = new bs(mo226e(), this.f961h, this.f960g);
            this.f959d.m1508a();
        }
    }

    /* renamed from: d */
    public void m1548d() {
        this.f956a = false;
        if (this.f957b != null) {
            int size = this.f957b.size();
            for (int i = 0; i < size; i++) {
                Thread thread = (Thread) this.f957b.get(0);
                if (thread != null) {
                    thread.interrupt();
                    this.f957b.remove(0);
                }
            }
            this.f957b = null;
        }
        if (this.f959d != null) {
            this.f959d.m1509b();
            this.f959d = null;
        }
    }
}
