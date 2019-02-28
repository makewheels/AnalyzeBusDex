package p054u.aly;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: TUnion */
/* renamed from: u.aly.cj */
public abstract class cj<T extends cj<?, ?>, F extends cg> implements bz<T, F> {
    /* renamed from: a */
    private static final Map<Class<? extends dg>, dh> f6185a = new HashMap();
    /* renamed from: b */
    protected Object f6186b;
    /* renamed from: c */
    protected F f6187c;

    /* compiled from: TUnion */
    /* renamed from: u.aly.cj$a */
    private static class C1424a extends di<cj> {
        private C1424a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m10149b(cyVar, (cj) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m10147a(cyVar, (cj) bzVar);
        }

        /* renamed from: a */
        public void m10147a(cy cyVar, cj cjVar) throws cf {
            cjVar.f6187c = null;
            cjVar.f6186b = null;
            cyVar.mo1967j();
            ct l = cyVar.mo1969l();
            cjVar.f6186b = cjVar.mo1933a(cyVar, l);
            if (cjVar.f6186b != null) {
                cjVar.f6187c = cjVar.mo1937b(l.f6486c);
            }
            cyVar.mo1970m();
            cyVar.mo1969l();
            cyVar.mo1968k();
        }

        /* renamed from: b */
        public void m10149b(cy cyVar, cj cjVar) throws cf {
            if (cjVar.m9566i() == null || cjVar.m9567j() == null) {
                throw new cz("Cannot write a TUnion with no set value!");
            }
            cyVar.mo1956a(cjVar.mo1938c());
            cyVar.mo1951a(cjVar.mo1935a(cjVar.f6187c));
            cjVar.mo1939c(cyVar);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: TUnion */
    /* renamed from: u.aly.cj$b */
    private static class C1425b implements dh {
        private C1425b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m10150a();
        }

        /* renamed from: a */
        public C1424a m10150a() {
            return new C1424a();
        }
    }

    /* compiled from: TUnion */
    /* renamed from: u.aly.cj$c */
    private static class C1426c extends dj<cj> {
        private C1426c() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m10155b(cyVar, (cj) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m10153a(cyVar, (cj) bzVar);
        }

        /* renamed from: a */
        public void m10153a(cy cyVar, cj cjVar) throws cf {
            cjVar.f6187c = null;
            cjVar.f6186b = null;
            short v = cyVar.mo1979v();
            cjVar.f6186b = cjVar.mo1934a(cyVar, v);
            if (cjVar.f6186b != null) {
                cjVar.f6187c = cjVar.mo1937b(v);
            }
        }

        /* renamed from: b */
        public void m10155b(cy cyVar, cj cjVar) throws cf {
            if (cjVar.m9566i() == null || cjVar.m9567j() == null) {
                throw new cz("Cannot write a TUnion with no set value!");
            }
            cyVar.mo1957a(cjVar.f6187c.mo1931a());
            cjVar.mo1940d(cyVar);
        }
    }

    /* compiled from: TUnion */
    /* renamed from: u.aly.cj$d */
    private static class C1427d implements dh {
        private C1427d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m10156a();
        }

        /* renamed from: a */
        public C1426c m10156a() {
            return new C1426c();
        }
    }

    /* renamed from: a */
    protected abstract Object mo1933a(cy cyVar, ct ctVar) throws cf;

    /* renamed from: a */
    protected abstract Object mo1934a(cy cyVar, short s) throws cf;

    /* renamed from: a */
    protected abstract ct mo1935a(F f);

    /* renamed from: a */
    protected abstract void mo1936a(F f, Object obj) throws ClassCastException;

    /* renamed from: b */
    protected abstract F mo1937b(short s);

    /* renamed from: c */
    protected abstract dd mo1938c();

    /* renamed from: c */
    protected abstract void mo1939c(cy cyVar) throws cf;

    /* renamed from: d */
    protected abstract void mo1940d(cy cyVar) throws cf;

    protected cj() {
        this.f6187c = null;
        this.f6186b = null;
    }

    static {
        f6185a.put(di.class, new C1425b());
        f6185a.put(dj.class, new C1427d());
    }

    protected cj(F f, Object obj) {
        m9558b(f, obj);
    }

    protected cj(cj<T, F> cjVar) {
        if (cjVar.getClass().equals(getClass())) {
            this.f6187c = cjVar.f6187c;
            this.f6186b = cj.m9545a(cjVar.f6186b);
            return;
        }
        throw new ClassCastException();
    }

    /* renamed from: a */
    private static Object m9545a(Object obj) {
        if (obj instanceof bz) {
            return ((bz) obj).mo1925g();
        }
        if (obj instanceof ByteBuffer) {
            return ca.m10124d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return cj.m9546a((List) obj);
        }
        if (obj instanceof Set) {
            return cj.m9548a((Set) obj);
        }
        if (obj instanceof Map) {
            return cj.m9547a((Map) obj);
        }
        return obj;
    }

    /* renamed from: a */
    private static Map m9547a(Map<Object, Object> map) {
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(cj.m9545a(entry.getKey()), cj.m9545a(entry.getValue()));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Set m9548a(Set set) {
        Set hashSet = new HashSet();
        for (Object a : set) {
            hashSet.add(cj.m9545a(a));
        }
        return hashSet;
    }

    /* renamed from: a */
    private static List m9546a(List list) {
        List arrayList = new ArrayList(list.size());
        for (Object a : list) {
            arrayList.add(cj.m9545a(a));
        }
        return arrayList;
    }

    /* renamed from: i */
    public F m9566i() {
        return this.f6187c;
    }

    /* renamed from: j */
    public Object m9567j() {
        return this.f6186b;
    }

    /* renamed from: b */
    public Object m9555b(F f) {
        if (f == this.f6187c) {
            return m9567j();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.f6187c);
    }

    /* renamed from: c */
    public Object m9560c(int i) {
        return m9555b(mo1937b((short) i));
    }

    /* renamed from: k */
    public boolean m9568k() {
        return this.f6187c != null;
    }

    /* renamed from: c */
    public boolean m9563c(F f) {
        return this.f6187c == f;
    }

    /* renamed from: d */
    public boolean m9565d(int i) {
        return m9563c(mo1937b((short) i));
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6185a.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void m9558b(F f, Object obj) {
        mo1936a((cg) f, obj);
        this.f6187c = f;
        this.f6186b = obj;
    }

    /* renamed from: a */
    public void m9552a(int i, Object obj) {
        m9558b(mo1937b((short) i), obj);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6185a.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" ");
        if (m9566i() != null) {
            Object j = m9567j();
            stringBuilder.append(mo1935a(m9566i()).f6484a);
            stringBuilder.append(":");
            if (j instanceof ByteBuffer) {
                ca.m10119a((ByteBuffer) j, stringBuilder);
            } else {
                stringBuilder.append(j.toString());
            }
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public final void mo1923b() {
        this.f6187c = null;
        this.f6186b = null;
    }
}
