package p054u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ActivateMsg */
/* renamed from: u.aly.ah */
public class ah implements Serializable, Cloneable, bz<ah, C1281e> {
    /* renamed from: b */
    public static final Map<C1281e, cl> f5807b;
    /* renamed from: c */
    private static final dd f5808c = new dd("ActivateMsg");
    /* renamed from: d */
    private static final ct f5809d = new ct("ts", (byte) 10, (short) 1);
    /* renamed from: e */
    private static final Map<Class<? extends dg>, dh> f5810e = new HashMap();
    /* renamed from: f */
    private static final int f5811f = 0;
    /* renamed from: a */
    public long f5812a;
    /* renamed from: g */
    private byte f5813g;

    /* compiled from: ActivateMsg */
    /* renamed from: u.aly.ah$a */
    private static class C1277a extends di<ah> {
        private C1277a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m8703b(cyVar, (ah) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m8701a(cyVar, (ah) bzVar);
        }

        /* renamed from: a */
        public void m8701a(cy cyVar, ah ahVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (ahVar.m8735e()) {
                        ahVar.m8736f();
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
                        ahVar.f5812a = cyVar.mo1981x();
                        ahVar.m8729a(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m8703b(cy cyVar, ah ahVar) throws cf {
            ahVar.m8736f();
            cyVar.mo1956a(ah.f5808c);
            cyVar.mo1951a(ah.f5809d);
            cyVar.mo1948a(ahVar.f5812a);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: ActivateMsg */
    /* renamed from: u.aly.ah$b */
    private static class C1278b implements dh {
        private C1278b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8706a();
        }

        /* renamed from: a */
        public C1277a m8706a() {
            return new C1277a();
        }
    }

    /* compiled from: ActivateMsg */
    /* renamed from: u.aly.ah$c */
    private static class C1279c extends dj<ah> {
        private C1279c() {
        }

        /* renamed from: a */
        public void m8708a(cy cyVar, ah ahVar) throws cf {
            ((de) cyVar).mo1948a(ahVar.f5812a);
        }

        /* renamed from: b */
        public void m8710b(cy cyVar, ah ahVar) throws cf {
            ahVar.f5812a = ((de) cyVar).mo1981x();
            ahVar.m8729a(true);
        }
    }

    /* compiled from: ActivateMsg */
    /* renamed from: u.aly.ah$d */
    private static class C1280d implements dh {
        private C1280d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8712a();
        }

        /* renamed from: a */
        public C1279c m8712a() {
            return new C1279c();
        }
    }

    /* compiled from: ActivateMsg */
    /* renamed from: u.aly.ah$e */
    public enum C1281e implements cg {
        TS((short) 1, "ts");
        
        /* renamed from: b */
        private static final Map<String, C1281e> f5803b = null;
        /* renamed from: c */
        private final short f5805c;
        /* renamed from: d */
        private final String f5806d;

        static {
            f5803b = new HashMap();
            Iterator it = EnumSet.allOf(C1281e.class).iterator();
            while (it.hasNext()) {
                C1281e c1281e = (C1281e) it.next();
                f5803b.put(c1281e.mo1932b(), c1281e);
            }
        }

        /* renamed from: a */
        public static C1281e m8716a(int i) {
            switch (i) {
                case 1:
                    return TS;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1281e m8718b(int i) {
            C1281e a = C1281e.m8716a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1281e m8717a(String str) {
            return (C1281e) f5803b.get(str);
        }

        private C1281e(short s, String str) {
            this.f5805c = s;
            this.f5806d = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5805c;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5806d;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8725a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8726a();
    }

    static {
        f5810e.put(di.class, new C1278b());
        f5810e.put(dj.class, new C1280d());
        Map enumMap = new EnumMap(C1281e.class);
        enumMap.put(C1281e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        f5807b = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ah.class, f5807b);
    }

    public ah() {
        this.f5813g = (byte) 0;
    }

    public ah(long j) {
        this();
        this.f5812a = j;
        m8729a(true);
    }

    public ah(ah ahVar) {
        this.f5813g = (byte) 0;
        this.f5813g = ahVar.f5813g;
        this.f5812a = ahVar.f5812a;
    }

    /* renamed from: a */
    public ah m8726a() {
        return new ah(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m8729a(false);
        this.f5812a = 0;
    }

    /* renamed from: c */
    public long m8733c() {
        return this.f5812a;
    }

    /* renamed from: a */
    public ah m8727a(long j) {
        this.f5812a = j;
        m8729a(true);
        return this;
    }

    /* renamed from: d */
    public void m8734d() {
        this.f5813g = bw.m10080b(this.f5813g, 0);
    }

    /* renamed from: e */
    public boolean m8735e() {
        return bw.m10076a(this.f5813g, 0);
    }

    /* renamed from: a */
    public void m8729a(boolean z) {
        this.f5813g = bw.m10068a(this.f5813g, 0, z);
    }

    /* renamed from: a */
    public C1281e m8725a(int i) {
        return C1281e.m8716a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5810e.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5810e.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActivateMsg(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f5812a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: f */
    public void m8736f() throws cf {
    }

    /* renamed from: a */
    private void m8722a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8721a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5813g = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
