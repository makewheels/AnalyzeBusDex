package com.amap.api.p015a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/* compiled from: TaskPool */
/* renamed from: com.amap.api.a.br */
class br<T> {
    /* renamed from: a */
    protected LinkedList<T> f920a = new LinkedList();
    /* renamed from: b */
    protected final Semaphore f921b = new Semaphore(0, false);
    /* renamed from: c */
    protected boolean f922c = true;

    br() {
    }

    /* renamed from: a */
    public void m1503a() {
        this.f922c = false;
        this.f921b.release(100);
    }

    /* renamed from: a */
    public synchronized void m1504a(List<T> list, boolean z) {
        if (this.f920a != null) {
            if (z) {
                this.f920a.clear();
            }
            if (list != null) {
                this.f920a.addAll(list);
            }
            m1506b();
        }
    }

    /* renamed from: b */
    protected void m1506b() {
        if (this.f920a != null && this.f922c && this.f920a.size() != 0) {
            this.f921b.release();
        }
    }

    /* renamed from: c */
    public void m1507c() {
        if (this.f920a != null) {
            this.f920a.clear();
        }
    }

    /* renamed from: a */
    public ArrayList<T> m1502a(int i, boolean z) {
        ArrayList<T> arrayList = null;
        if (this.f920a != null) {
            try {
                this.f921b.acquire();
            } catch (InterruptedException e) {
            }
            try {
                if (this.f922c) {
                    arrayList = mo208b(i, z);
                }
            } catch (Exception e2) {
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    protected synchronized ArrayList<T> mo208b(int i, boolean z) {
        ArrayList<T> arrayList;
        synchronized (this) {
            if (this.f920a == null) {
                arrayList = null;
            } else {
                int size = this.f920a.size();
                if (i > size) {
                    i = size;
                }
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(this.f920a.get(0));
                    this.f920a.removeFirst();
                }
                m1506b();
            }
        }
        return arrayList;
    }
}
