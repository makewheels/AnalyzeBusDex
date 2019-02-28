package com.amap.api.p015a;

import com.amap.api.maps2d.AMapException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AsyncServer */
/* renamed from: com.amap.api.a.j */
class C0247j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0236h f1035a;

    C0247j(C0236h c0236h) {
        this.f1035a = c0236h;
    }

    public void run() {
        List a;
        ArrayList arrayList = null;
        Thread currentThread = Thread.currentThread();
        if (this.f1035a.f957b != null) {
            this.f1035a.f957b.add(currentThread);
        }
        List list = null;
        while (this.f1035a.f956a) {
            if (this.f1035a.e == null) {
                this.f1035a.f956a = false;
            } else {
                ArrayList a2;
                if (this.f1035a.f958c != null) {
                    a2 = this.f1035a.f958c.m1502a(this.f1035a.mo227f(), true);
                } else {
                    a2 = arrayList;
                }
                if (a2 != null && a2.size() == 0) {
                    arrayList = a2;
                } else if (this.f1035a.f956a) {
                    try {
                        a = this.f1035a.mo223a(a2);
                    } catch (AMapException e) {
                        try {
                            e.printStackTrace();
                            a = list;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    if (a != null) {
                        if (this.f1035a.f958c != null) {
                            this.f1035a.f958c.m1504a(a, false);
                        }
                    }
                    if (this.f1035a.f956a) {
                        try {
                            Thread.sleep(50);
                            list = a;
                            arrayList = a2;
                        } catch (Exception e3) {
                            Thread.currentThread().interrupt();
                            list = a;
                            arrayList = a2;
                        }
                    } else {
                        list = a;
                        arrayList = a2;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
