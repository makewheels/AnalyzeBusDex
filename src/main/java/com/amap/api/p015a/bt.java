package com.amap.api.p015a;

import com.amap.api.p015a.C0253m.C0252a;
import java.util.ArrayList;

/* compiled from: TaskPool */
/* renamed from: com.amap.api.a.bt */
class bt extends br<C0252a> {
    bt() {
    }

    /* renamed from: b */
    protected synchronized ArrayList<C0252a> mo208b(int i, boolean z) {
        ArrayList<C0252a> arrayList;
        int i2 = 0;
        synchronized (this) {
            if (this.a == null) {
                arrayList = null;
            } else {
                int size = this.a.size();
                if (i > size) {
                    i = size;
                }
                ArrayList<C0252a> arrayList2 = new ArrayList(i);
                int i3 = 0;
                while (i2 < size) {
                    if (this.a == null) {
                        arrayList = null;
                        break;
                    }
                    int i4;
                    C0252a c0252a = (C0252a) this.a.get(i2);
                    if (c0252a == null) {
                        i4 = i2;
                        i2 = i3;
                        i3 = size;
                    } else {
                        int i5 = c0252a.f1045a;
                        if (z) {
                            if (i5 == 0) {
                                arrayList2.add(c0252a);
                                this.a.remove(i2);
                                i4 = i2 - 1;
                                i2 = i3 + 1;
                                i3 = size - 1;
                            }
                            i4 = i2;
                            i2 = i3;
                            i3 = size;
                        } else {
                            if (i5 < 0) {
                                arrayList2.add(c0252a);
                                this.a.remove(i2);
                                i4 = i2 - 1;
                                i2 = i3 + 1;
                                i3 = size - 1;
                            }
                            i4 = i2;
                            i2 = i3;
                            i3 = size;
                        }
                        if (i2 >= i) {
                            break;
                        }
                    }
                    size = i3;
                    i3 = i2;
                    i2 = i4 + 1;
                }
                m1506b();
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }
}
