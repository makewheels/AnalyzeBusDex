package com.iflytek.cloud.util.p032a;

import android.content.Context;
import com.iflytek.cloud.util.p032a.p033a.C0978a;
import com.iflytek.cloud.util.p032a.p034c.C0983a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.iflytek.cloud.util.a.a */
public class C0980a {
    /* renamed from: a */
    protected Context f4617a;
    /* renamed from: b */
    private C0983a f4618b;
    /* renamed from: c */
    private String[] f4619c = null;
    /* renamed from: d */
    private String[] f4620d = null;
    /* renamed from: e */
    private HashMap<String, String> f4621e = new HashMap();
    /* renamed from: f */
    private HashMap<String, String> f4622f = new HashMap();
    /* renamed from: g */
    private List<C0978a> f4623g = new ArrayList();
    /* renamed from: h */
    private HashMap<String, String> f4624h = new HashMap();
    /* renamed from: i */
    private HashMap<String, String> f4625i = new HashMap();

    public C0980a(Context context, C0983a c0983a) {
        this.f4618b = c0983a;
        this.f4617a = context;
    }

    /* renamed from: b */
    private void m7311b() {
        if (this.f4622f.size() > 0) {
            this.f4622f = null;
            this.f4622f = new HashMap();
        }
        if (this.f4625i.size() > 0) {
            this.f4625i = null;
            this.f4625i = new HashMap();
        }
        if (this.f4621e.size() > 0) {
            this.f4621e = null;
            this.f4621e = new HashMap();
        }
        if (this.f4619c != null && this.f4619c.length > 0) {
            this.f4619c = null;
        }
    }

    /* renamed from: a */
    public void m7312a(int i) {
        if (this.f4624h != null && this.f4624h.size() > 0) {
            this.f4624h.clear();
        }
        if (this.f4618b != null) {
            this.f4624h = this.f4618b.m7315a(i);
        }
    }

    /* renamed from: a */
    public String[] m7313a() {
        m7311b();
        Collection arrayList = new ArrayList();
        HashMap d = this.f4618b.m7319d();
        List<C0978a> e = this.f4618b.m7320e();
        for (String str : d.keySet()) {
            String str2 = (String) d.get(str);
            this.f4621e.put(str + "p", str2);
            arrayList.add(str2);
            if (str2.contains("\u0000")) {
                this.f4625i.put(str2.replace("\u0000", " "), str2);
            }
        }
        for (C0978a c0978a : e) {
            String a = c0978a.m7306a();
            String c = c0978a.m7308c();
            String b = c0978a.m7307b();
            this.f4622f.put(a + "s", c);
            this.f4621e.put(a + "s", b);
            arrayList.add(b);
            if (b.contains("\u0000")) {
                this.f4625i.put(b.replace("\u0000", " "), b);
            }
            this.f4623g.add(c0978a);
        }
        Set hashSet = new HashSet(arrayList);
        this.f4619c = (String[]) hashSet.toArray(new String[hashSet.size()]);
        return this.f4619c;
    }
}
