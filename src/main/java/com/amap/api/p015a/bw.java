package com.amap.api.p015a;

import android.content.Context;
import com.amap.api.maps2d.AMapException;
import com.amap.api.p015a.C0253m.C0252a;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TileServer */
/* renamed from: com.amap.api.a.bw */
class bw extends C0236h<C0252a, C0252a> implements ce {
    /* renamed from: g */
    private ar f962g;

    /* renamed from: g */
    public void mo228g() {
    }

    /* renamed from: a */
    public void mo220a() {
        super.mo220a();
        this.f962g.clear();
    }

    public bw(bf bfVar, Context context) {
        super(bfVar, context);
        this.f962g = new ar();
        this.c = new bt();
        bfVar.f837b.m1386a((ce) this);
    }

    /* renamed from: a */
    protected ArrayList<C0252a> mo224a(ArrayList<C0252a> arrayList, Proxy proxy) throws AMapException {
        if (arrayList == null || arrayList.size() == 0 || this.e == null || this.e.f839d == null || this.e.f839d.f807a == null || ((C0252a) arrayList.get(0)).f1049e >= this.e.f839d.f807a.size()) {
            return null;
        }
        m1560a((List) arrayList);
        if (arrayList.size() == 0 || this.e.f839d.f807a.size() == 0) {
            return null;
        }
        ArrayList<C0252a> arrayList2;
        if (((as) this.e.f839d.f807a.get(((C0252a) arrayList.get(0)).f1049e)).f645j != null) {
            bx bxVar = new bx(arrayList, proxy, null, null);
            bxVar.m1569a((as) this.e.f839d.f807a.get(((C0252a) arrayList.get(0)).f1049e));
            arrayList2 = (ArrayList) bxVar.m1493d();
            bxVar.m1569a(null);
        } else {
            arrayList2 = null;
        }
        m1555b(arrayList);
        if (this.e == null || this.e.f839d == null) {
            return arrayList2;
        }
        this.e.f839d.m1363a();
        return arrayList2;
    }

    /* renamed from: a */
    public void m1560a(List<C0252a> list) {
        if (list != null) {
            int size = list.size();
            if (size != 0) {
                int i = 0;
                while (i < size) {
                    int i2;
                    if (this.f962g.m1059b((C0252a) list.get(i))) {
                        i2 = i;
                        i = size;
                    } else {
                        list.remove(i);
                        i2 = i - 1;
                        i = size - 1;
                    }
                    size = i;
                    i = i2 + 1;
                }
            }
        }
    }

    /* renamed from: b */
    private void m1555b(ArrayList<C0252a> arrayList) {
        if (arrayList != null && this.f962g != null) {
            int size = arrayList.size();
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    this.f962g.m1058a((C0252a) arrayList.get(i));
                }
            }
        }
    }

    /* renamed from: a */
    private void m1553a(ArrayList<C0252a> arrayList, boolean z) {
        if (this.c != null && arrayList != null && arrayList.size() != 0) {
            this.c.m1504a((List) arrayList, z);
        }
    }

    /* renamed from: h */
    private boolean m1556h() {
        if (this.e == null || this.e.f839d == null) {
            return false;
        }
        if (this.e.f839d.f807a == null) {
            return false;
        }
        int size = this.e.f839d.f807a.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            as asVar = (as) this.e.f839d.f807a.get(i);
            if (asVar != null && asVar.f641f) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private ArrayList<C0252a> m1552a(ArrayList<C0252a> arrayList, as asVar, int i, boolean z) {
        if (arrayList == null || asVar == null || !asVar.f641f || asVar.f650o == null) {
            return null;
        }
        asVar.f650o.clear();
        if (i > asVar.f637b || i < asVar.f638c) {
            return null;
        }
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        ArrayList<C0252a> arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            C0252a c0252a = (C0252a) arrayList.get(i2);
            if (c0252a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c0252a.f1046b);
                stringBuilder.append("-");
                stringBuilder.append(c0252a.f1047c);
                stringBuilder.append("-");
                stringBuilder.append(c0252a.f1048d);
                int a = asVar.f648m.m1658a(stringBuilder.toString());
                C0252a c0252a2 = new C0252a(c0252a.f1046b, c0252a.f1047c, c0252a.f1048d, asVar.f646k);
                c0252a2.f1051g = a;
                c0252a2.f1050f = c0252a.f1050f;
                asVar.f650o.add(c0252a2);
                if (!(!m1554a(c0252a2) || z || this.f962g.contains(c0252a2))) {
                    if (!asVar.f642g) {
                        c0252a2.f1045a = -1;
                    }
                    arrayList2.add(c0252a2);
                }
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    public void mo225a(boolean z, boolean z2) {
        if (m1556h()) {
            ArrayList a = this.e.f843h.m1289a(this.e.f843h.f761j, this.e.f843h.f758g, this.e.f837b.m1391c(), this.e.f837b.m1393d());
            if (a != null && a.size() > 0) {
                int size = this.e.f839d.f807a.size();
                int i = 0;
                boolean z3 = true;
                while (i < size) {
                    boolean z4;
                    ArrayList a2 = m1552a(a, (as) this.e.f839d.f807a.get(i), this.e.f837b.m1394e(), z2);
                    if (a2 != null) {
                        m1553a(a2, z3);
                        if (z3) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        a2.clear();
                    } else {
                        z4 = z3;
                    }
                    i++;
                    z3 = z4;
                }
                a.clear();
                this.e.f837b.m1396g().invalidate();
            }
        }
    }

    /* renamed from: a */
    private boolean m1554a(C0252a c0252a) {
        return c0252a == null || c0252a.f1051g < 0;
    }

    /* renamed from: f */
    protected int mo227f() {
        return 1;
    }

    /* renamed from: e */
    protected int mo226e() {
        return 4;
    }

    /* renamed from: a */
    protected ArrayList<C0252a> mo223a(ArrayList<C0252a> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        int i = 0;
        ArrayList<C0252a> arrayList2 = null;
        while (i < size) {
            int i2;
            ArrayList<C0252a> arrayList3;
            C0252a c0252a = (C0252a) arrayList.get(i);
            if (c0252a == null) {
                i2 = i;
                arrayList3 = arrayList2;
                i = size;
            } else if (this.e == null || this.e.f839d == null || this.e.f839d.f807a == null) {
                return null;
            } else {
                if (c0252a.f1049e >= this.e.f839d.f807a.size()) {
                    i2 = i;
                    arrayList3 = arrayList2;
                    i = size;
                } else if (((as) this.e.f839d.f807a.get(c0252a.f1049e)).f642g) {
                    int a = ((as) this.e.f839d.f807a.get(c0252a.f1049e)).f649n.m1668a(c0252a);
                    if (a >= 0) {
                        arrayList.remove(i);
                        size--;
                        i--;
                        bq bqVar = ((as) this.e.f839d.f807a.get(c0252a.f1049e)).f650o;
                        if (bqVar == null) {
                            i2 = i;
                            arrayList3 = arrayList2;
                            i = size;
                        } else {
                            int size2 = bqVar.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                C0252a c0252a2 = (C0252a) bqVar.get(i3);
                                if (c0252a2 != null && c0252a2.equals(c0252a)) {
                                    c0252a2.f1051g = a;
                                    this.e.f839d.m1363a();
                                    break;
                                }
                            }
                            i2 = i;
                            arrayList3 = arrayList2;
                            i = size;
                        }
                    } else {
                        if (arrayList2 == null) {
                            arrayList3 = new ArrayList();
                        } else {
                            arrayList3 = arrayList2;
                        }
                        C0252a c0252a3 = new C0252a(c0252a);
                        c0252a3.f1045a = -1;
                        arrayList3.add(c0252a3);
                        i2 = i;
                        i = size;
                    }
                } else {
                    i2 = i;
                    arrayList3 = arrayList2;
                    i = size;
                }
            }
            arrayList2 = arrayList3;
            size = i;
            i = i2 + 1;
        }
        return arrayList2;
    }
}
