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

/* compiled from: Error */
/* renamed from: u.aly.am */
public class am implements Serializable, Cloneable, bz<am, C1311e> {
    /* renamed from: d */
    public static final Map<C1311e, cl> f5753d;
    /* renamed from: e */
    private static final dd f5754e = new dd("Error");
    /* renamed from: f */
    private static final ct f5755f = new ct("ts", (byte) 10, (short) 1);
    /* renamed from: g */
    private static final ct f5756g = new ct("context", (byte) 11, (short) 2);
    /* renamed from: h */
    private static final ct f5757h = new ct("source", (byte) 8, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f5758i = new HashMap();
    /* renamed from: j */
    private static final int f5759j = 0;
    /* renamed from: a */
    public long f5760a;
    /* renamed from: b */
    public String f5761b;
    /* renamed from: c */
    public an f5762c;
    /* renamed from: k */
    private byte f5763k;
    /* renamed from: l */
    private C1311e[] f5764l;

    /* compiled from: Error */
    /* renamed from: u.aly.am$a */
    private static class C1307a extends di<am> {
        private C1307a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9043b(cyVar, (am) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9041a(cyVar, (am) bzVar);
        }

        /* renamed from: a */
        public void m9041a(cy cyVar, am amVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (amVar.m8598e()) {
                        amVar.m8606m();
                        return;
                    }
                    throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        amVar.f5760a = cyVar.mo1981x();
                        amVar.m8593b(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        amVar.f5761b = cyVar.mo1983z();
                        amVar.m8595c(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        amVar.f5762c = an.m9058a(cyVar.mo1980w());
                        amVar.m8597d(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9043b(cy cyVar, am amVar) throws cf {
            amVar.m8606m();
            cyVar.mo1956a(am.f5754e);
            cyVar.mo1951a(am.f5755f);
            cyVar.mo1948a(amVar.f5760a);
            cyVar.mo1960c();
            if (amVar.f5761b != null) {
                cyVar.mo1951a(am.f5756g);
                cyVar.mo1949a(amVar.f5761b);
                cyVar.mo1960c();
            }
            if (amVar.f5762c != null && amVar.m8605l()) {
                cyVar.mo1951a(am.f5757h);
                cyVar.mo1947a(amVar.f5762c.mo1927a());
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Error */
    /* renamed from: u.aly.am$b */
    private static class C1308b implements dh {
        private C1308b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9045a();
        }

        /* renamed from: a */
        public C1307a m9045a() {
            return new C1307a();
        }
    }

    /* compiled from: Error */
    /* renamed from: u.aly.am$c */
    private static class C1309c extends dj<am> {
        private C1309c() {
        }

        /* renamed from: a */
        public void m9047a(cy cyVar, am amVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1948a(amVar.f5760a);
            deVar.mo1949a(amVar.f5761b);
            BitSet bitSet = new BitSet();
            if (amVar.m8605l()) {
                bitSet.set(0);
            }
            deVar.m10341a(bitSet, 1);
            if (amVar.m8605l()) {
                deVar.mo1947a(amVar.f5762c.mo1927a());
            }
        }

        /* renamed from: b */
        public void m9049b(cy cyVar, am amVar) throws cf {
            de deVar = (de) cyVar;
            amVar.f5760a = deVar.mo1981x();
            amVar.m8593b(true);
            amVar.f5761b = deVar.mo1983z();
            amVar.m8595c(true);
            if (deVar.mo1986b(1).get(0)) {
                amVar.f5762c = an.m9058a(deVar.mo1980w());
                amVar.m8597d(true);
            }
        }
    }

    /* compiled from: Error */
    /* renamed from: u.aly.am$d */
    private static class C1310d implements dh {
        private C1310d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9051a();
        }

        /* renamed from: a */
        public C1309c m9051a() {
            return new C1309c();
        }
    }

    /* compiled from: Error */
    /* renamed from: u.aly.am$e */
    public enum C1311e implements cg {
        TS((short) 1, "ts"),
        CONTEXT((short) 2, "context"),
        SOURCE((short) 3, "source");
        
        /* renamed from: d */
        private static final Map<String, C1311e> f5969d = null;
        /* renamed from: e */
        private final short f5971e;
        /* renamed from: f */
        private final String f5972f;

        static {
            f5969d = new HashMap();
            Iterator it = EnumSet.allOf(C1311e.class).iterator();
            while (it.hasNext()) {
                C1311e c1311e = (C1311e) it.next();
                f5969d.put(c1311e.mo1932b(), c1311e);
            }
        }

        /* renamed from: a */
        public static C1311e m9053a(int i) {
            switch (i) {
                case 1:
                    return TS;
                case 2:
                    return CONTEXT;
                case 3:
                    return SOURCE;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1311e m9055b(int i) {
            C1311e a = C1311e.m9053a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1311e m9054a(String str) {
            return (C1311e) f5969d.get(str);
        }

        private C1311e(short s, String str) {
            this.f5971e = s;
            this.f5972f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5971e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5972f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8584a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8585a();
    }

    static {
        f5758i.put(di.class, new C1308b());
        f5758i.put(dj.class, new C1310d());
        Map enumMap = new EnumMap(C1311e.class);
        enumMap.put(C1311e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        enumMap.put(C1311e.CONTEXT, new cl("context", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1311e.SOURCE, new cl("source", (byte) 2, new ck(df.f6530n, an.class)));
        f5753d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(am.class, f5753d);
    }

    public am() {
        this.f5763k = (byte) 0;
        this.f5764l = new C1311e[]{C1311e.SOURCE};
    }

    public am(long j, String str) {
        this();
        this.f5760a = j;
        m8593b(true);
        this.f5761b = str;
    }

    public am(am amVar) {
        this.f5763k = (byte) 0;
        this.f5764l = new C1311e[]{C1311e.SOURCE};
        this.f5763k = amVar.f5763k;
        this.f5760a = amVar.f5760a;
        if (amVar.m8602i()) {
            this.f5761b = amVar.f5761b;
        }
        if (amVar.m8605l()) {
            this.f5762c = amVar.f5762c;
        }
    }

    /* renamed from: a */
    public am m8585a() {
        return new am(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m8593b(false);
        this.f5760a = 0;
        this.f5761b = null;
        this.f5762c = null;
    }

    /* renamed from: c */
    public long m8594c() {
        return this.f5760a;
    }

    /* renamed from: a */
    public am m8586a(long j) {
        this.f5760a = j;
        m8593b(true);
        return this;
    }

    /* renamed from: d */
    public void m8596d() {
        this.f5763k = bw.m10080b(this.f5763k, 0);
    }

    /* renamed from: e */
    public boolean m8598e() {
        return bw.m10076a(this.f5763k, 0);
    }

    /* renamed from: b */
    public void m8593b(boolean z) {
        this.f5763k = bw.m10068a(this.f5763k, 0, z);
    }

    /* renamed from: f */
    public String m8599f() {
        return this.f5761b;
    }

    /* renamed from: a */
    public am m8587a(String str) {
        this.f5761b = str;
        return this;
    }

    /* renamed from: h */
    public void m8601h() {
        this.f5761b = null;
    }

    /* renamed from: i */
    public boolean m8602i() {
        return this.f5761b != null;
    }

    /* renamed from: c */
    public void m8595c(boolean z) {
        if (!z) {
            this.f5761b = null;
        }
    }

    /* renamed from: j */
    public an m8603j() {
        return this.f5762c;
    }

    /* renamed from: a */
    public am m8588a(an anVar) {
        this.f5762c = anVar;
        return this;
    }

    /* renamed from: k */
    public void m8604k() {
        this.f5762c = null;
    }

    /* renamed from: l */
    public boolean m8605l() {
        return this.f5762c != null;
    }

    /* renamed from: d */
    public void m8597d(boolean z) {
        if (!z) {
            this.f5762c = null;
        }
    }

    /* renamed from: a */
    public C1311e m8584a(int i) {
        return C1311e.m9053a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5758i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5758i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Error(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f5760a);
        stringBuilder.append(", ");
        stringBuilder.append("context:");
        if (this.f5761b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5761b);
        }
        if (m8605l()) {
            stringBuilder.append(", ");
            stringBuilder.append("source:");
            if (this.f5762c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5762c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: m */
    public void m8606m() throws cf {
        if (this.f5761b == null) {
            throw new cz("Required field 'context' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m8579a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8578a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5763k = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
