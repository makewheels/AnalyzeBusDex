package p054u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ImprintValue */
/* renamed from: u.aly.au */
public class au implements Serializable, Cloneable, bz<au, C1347e> {
    /* renamed from: d */
    public static final Map<C1347e, cl> f6074d;
    /* renamed from: e */
    private static final dd f6075e = new dd("ImprintValue");
    /* renamed from: f */
    private static final ct f6076f = new ct("value", (byte) 11, (short) 1);
    /* renamed from: g */
    private static final ct f6077g = new ct("ts", (byte) 10, (short) 2);
    /* renamed from: h */
    private static final ct f6078h = new ct("guid", (byte) 11, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f6079i = new HashMap();
    /* renamed from: j */
    private static final int f6080j = 0;
    /* renamed from: a */
    public String f6081a;
    /* renamed from: b */
    public long f6082b;
    /* renamed from: c */
    public String f6083c;
    /* renamed from: k */
    private byte f6084k;
    /* renamed from: l */
    private C1347e[] f6085l;

    /* compiled from: ImprintValue */
    /* renamed from: u.aly.au$a */
    private static class C1343a extends di<au> {
        private C1343a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9278b(cyVar, (au) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9276a(cyVar, (au) bzVar);
        }

        /* renamed from: a */
        public void m9276a(cy cyVar, au auVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (auVar.m9317i()) {
                        auVar.m9321m();
                        return;
                    }
                    throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        auVar.f6081a = cyVar.mo1983z();
                        auVar.m9304a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        auVar.f6082b = cyVar.mo1981x();
                        auVar.m9309b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        auVar.f6083c = cyVar.mo1983z();
                        auVar.m9311c(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9278b(cy cyVar, au auVar) throws cf {
            auVar.m9321m();
            cyVar.mo1956a(au.f6075e);
            if (auVar.f6081a != null && auVar.m9313e()) {
                cyVar.mo1951a(au.f6076f);
                cyVar.mo1949a(auVar.f6081a);
                cyVar.mo1960c();
            }
            cyVar.mo1951a(au.f6077g);
            cyVar.mo1948a(auVar.f6082b);
            cyVar.mo1960c();
            if (auVar.f6083c != null) {
                cyVar.mo1951a(au.f6078h);
                cyVar.mo1949a(auVar.f6083c);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: ImprintValue */
    /* renamed from: u.aly.au$b */
    private static class C1344b implements dh {
        private C1344b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9280a();
        }

        /* renamed from: a */
        public C1343a m9280a() {
            return new C1343a();
        }
    }

    /* compiled from: ImprintValue */
    /* renamed from: u.aly.au$c */
    private static class C1345c extends dj<au> {
        private C1345c() {
        }

        /* renamed from: a */
        public void m9282a(cy cyVar, au auVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1948a(auVar.f6082b);
            deVar.mo1949a(auVar.f6083c);
            BitSet bitSet = new BitSet();
            if (auVar.m9313e()) {
                bitSet.set(0);
            }
            deVar.m10341a(bitSet, 1);
            if (auVar.m9313e()) {
                deVar.mo1949a(auVar.f6081a);
            }
        }

        /* renamed from: b */
        public void m9284b(cy cyVar, au auVar) throws cf {
            de deVar = (de) cyVar;
            auVar.f6082b = deVar.mo1981x();
            auVar.m9309b(true);
            auVar.f6083c = deVar.mo1983z();
            auVar.m9311c(true);
            if (deVar.mo1986b(1).get(0)) {
                auVar.f6081a = deVar.mo1983z();
                auVar.m9304a(true);
            }
        }
    }

    /* compiled from: ImprintValue */
    /* renamed from: u.aly.au$d */
    private static class C1346d implements dh {
        private C1346d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9286a();
        }

        /* renamed from: a */
        public C1345c m9286a() {
            return new C1345c();
        }
    }

    /* compiled from: ImprintValue */
    /* renamed from: u.aly.au$e */
    public enum C1347e implements cg {
        VALUE((short) 1, "value"),
        TS((short) 2, "ts"),
        GUID((short) 3, "guid");
        
        /* renamed from: d */
        private static final Map<String, C1347e> f6070d = null;
        /* renamed from: e */
        private final short f6072e;
        /* renamed from: f */
        private final String f6073f;

        static {
            f6070d = new HashMap();
            Iterator it = EnumSet.allOf(C1347e.class).iterator();
            while (it.hasNext()) {
                C1347e c1347e = (C1347e) it.next();
                f6070d.put(c1347e.mo1932b(), c1347e);
            }
        }

        /* renamed from: a */
        public static C1347e m9288a(int i) {
            switch (i) {
                case 1:
                    return VALUE;
                case 2:
                    return TS;
                case 3:
                    return GUID;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1347e m9290b(int i) {
            C1347e a = C1347e.m9288a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1347e m9289a(String str) {
            return (C1347e) f6070d.get(str);
        }

        private C1347e(short s, String str) {
            this.f6072e = s;
            this.f6073f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6072e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6073f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9299a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9300a();
    }

    static {
        f6079i.put(di.class, new C1344b());
        f6079i.put(dj.class, new C1346d());
        Map enumMap = new EnumMap(C1347e.class);
        enumMap.put(C1347e.VALUE, new cl("value", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1347e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        enumMap.put(C1347e.GUID, new cl("guid", (byte) 1, new cm((byte) 11)));
        f6074d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(au.class, f6074d);
    }

    public au() {
        this.f6084k = (byte) 0;
        this.f6085l = new C1347e[]{C1347e.VALUE};
    }

    public au(long j, String str) {
        this();
        this.f6082b = j;
        m9309b(true);
        this.f6083c = str;
    }

    public au(au auVar) {
        this.f6084k = (byte) 0;
        this.f6085l = new C1347e[]{C1347e.VALUE};
        this.f6084k = auVar.f6084k;
        if (auVar.m9313e()) {
            this.f6081a = auVar.f6081a;
        }
        this.f6082b = auVar.f6082b;
        if (auVar.m9320l()) {
            this.f6083c = auVar.f6083c;
        }
    }

    /* renamed from: a */
    public au m9300a() {
        return new au(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6081a = null;
        m9309b(false);
        this.f6082b = 0;
        this.f6083c = null;
    }

    /* renamed from: c */
    public String m9310c() {
        return this.f6081a;
    }

    /* renamed from: a */
    public au m9302a(String str) {
        this.f6081a = str;
        return this;
    }

    /* renamed from: d */
    public void m9312d() {
        this.f6081a = null;
    }

    /* renamed from: e */
    public boolean m9313e() {
        return this.f6081a != null;
    }

    /* renamed from: a */
    public void m9304a(boolean z) {
        if (!z) {
            this.f6081a = null;
        }
    }

    /* renamed from: f */
    public long m9314f() {
        return this.f6082b;
    }

    /* renamed from: a */
    public au m9301a(long j) {
        this.f6082b = j;
        m9309b(true);
        return this;
    }

    /* renamed from: h */
    public void m9316h() {
        this.f6084k = bw.m10080b(this.f6084k, 0);
    }

    /* renamed from: i */
    public boolean m9317i() {
        return bw.m10076a(this.f6084k, 0);
    }

    /* renamed from: b */
    public void m9309b(boolean z) {
        this.f6084k = bw.m10068a(this.f6084k, 0, z);
    }

    /* renamed from: j */
    public String m9318j() {
        return this.f6083c;
    }

    /* renamed from: b */
    public au m9305b(String str) {
        this.f6083c = str;
        return this;
    }

    /* renamed from: k */
    public void m9319k() {
        this.f6083c = null;
    }

    /* renamed from: l */
    public boolean m9320l() {
        return this.f6083c != null;
    }

    /* renamed from: c */
    public void m9311c(boolean z) {
        if (!z) {
            this.f6083c = null;
        }
    }

    /* renamed from: a */
    public C1347e m9299a(int i) {
        return C1347e.m9288a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6079i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6079i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImprintValue(");
        Object obj = 1;
        if (m9313e()) {
            stringBuilder.append("value:");
            if (this.f6081a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6081a);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("ts:");
        stringBuilder.append(this.f6082b);
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.f6083c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6083c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: m */
    public void m9321m() throws cf {
        if (this.f6083c == null) {
            throw new cz("Required field 'guid' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m9294a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9293a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6084k = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
