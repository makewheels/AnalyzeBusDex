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

/* compiled from: Page */
/* renamed from: u.aly.ay */
public class ay implements Serializable, Cloneable, bz<ay, C1371e> {
    /* renamed from: c */
    public static final Map<C1371e, cl> f5765c;
    /* renamed from: d */
    private static final dd f5766d = new dd("Page");
    /* renamed from: e */
    private static final ct f5767e = new ct("page_name", (byte) 11, (short) 1);
    /* renamed from: f */
    private static final ct f5768f = new ct("duration", (byte) 10, (short) 2);
    /* renamed from: g */
    private static final Map<Class<? extends dg>, dh> f5769g = new HashMap();
    /* renamed from: h */
    private static final int f5770h = 0;
    /* renamed from: a */
    public String f5771a;
    /* renamed from: b */
    public long f5772b;
    /* renamed from: i */
    private byte f5773i;

    /* compiled from: Page */
    /* renamed from: u.aly.ay$a */
    private static class C1367a extends di<ay> {
        private C1367a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9525b(cyVar, (ay) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9523a(cyVar, (ay) bzVar);
        }

        /* renamed from: a */
        public void m9523a(cy cyVar, ay ayVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (ayVar.m8633i()) {
                        ayVar.m8634j();
                        return;
                    }
                    throw new cz("Required field 'duration' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        ayVar.f5771a = cyVar.mo1983z();
                        ayVar.m8622a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        ayVar.f5772b = cyVar.mo1981x();
                        ayVar.m8626b(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9525b(cy cyVar, ay ayVar) throws cf {
            ayVar.m8634j();
            cyVar.mo1956a(ay.f5766d);
            if (ayVar.f5771a != null) {
                cyVar.mo1951a(ay.f5767e);
                cyVar.mo1949a(ayVar.f5771a);
                cyVar.mo1960c();
            }
            cyVar.mo1951a(ay.f5768f);
            cyVar.mo1948a(ayVar.f5772b);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Page */
    /* renamed from: u.aly.ay$b */
    private static class C1368b implements dh {
        private C1368b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9527a();
        }

        /* renamed from: a */
        public C1367a m9527a() {
            return new C1367a();
        }
    }

    /* compiled from: Page */
    /* renamed from: u.aly.ay$c */
    private static class C1369c extends dj<ay> {
        private C1369c() {
        }

        /* renamed from: a */
        public void m9529a(cy cyVar, ay ayVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1949a(ayVar.f5771a);
            deVar.mo1948a(ayVar.f5772b);
        }

        /* renamed from: b */
        public void m9531b(cy cyVar, ay ayVar) throws cf {
            de deVar = (de) cyVar;
            ayVar.f5771a = deVar.mo1983z();
            ayVar.m8622a(true);
            ayVar.f5772b = deVar.mo1981x();
            ayVar.m8626b(true);
        }
    }

    /* compiled from: Page */
    /* renamed from: u.aly.ay$d */
    private static class C1370d implements dh {
        private C1370d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9533a();
        }

        /* renamed from: a */
        public C1369c m9533a() {
            return new C1369c();
        }
    }

    /* compiled from: Page */
    /* renamed from: u.aly.ay$e */
    public enum C1371e implements cg {
        PAGE_NAME((short) 1, "page_name"),
        DURATION((short) 2, "duration");
        
        /* renamed from: c */
        private static final Map<String, C1371e> f6174c = null;
        /* renamed from: d */
        private final short f6176d;
        /* renamed from: e */
        private final String f6177e;

        static {
            f6174c = new HashMap();
            Iterator it = EnumSet.allOf(C1371e.class).iterator();
            while (it.hasNext()) {
                C1371e c1371e = (C1371e) it.next();
                f6174c.put(c1371e.mo1932b(), c1371e);
            }
        }

        /* renamed from: a */
        public static C1371e m9535a(int i) {
            switch (i) {
                case 1:
                    return PAGE_NAME;
                case 2:
                    return DURATION;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1371e m9537b(int i) {
            C1371e a = C1371e.m9535a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1371e m9536a(String str) {
            return (C1371e) f6174c.get(str);
        }

        private C1371e(short s, String str) {
            this.f6176d = s;
            this.f6177e = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6176d;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6177e;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8617a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8618a();
    }

    static {
        f5769g.put(di.class, new C1368b());
        f5769g.put(dj.class, new C1370d());
        Map enumMap = new EnumMap(C1371e.class);
        enumMap.put(C1371e.PAGE_NAME, new cl("page_name", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1371e.DURATION, new cl("duration", (byte) 1, new cm((byte) 10)));
        f5765c = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ay.class, f5765c);
    }

    public ay() {
        this.f5773i = (byte) 0;
    }

    public ay(String str, long j) {
        this();
        this.f5771a = str;
        this.f5772b = j;
        m8626b(true);
    }

    public ay(ay ayVar) {
        this.f5773i = (byte) 0;
        this.f5773i = ayVar.f5773i;
        if (ayVar.m8629e()) {
            this.f5771a = ayVar.f5771a;
        }
        this.f5772b = ayVar.f5772b;
    }

    /* renamed from: a */
    public ay m8618a() {
        return new ay(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f5771a = null;
        m8626b(false);
        this.f5772b = 0;
    }

    /* renamed from: c */
    public String m8627c() {
        return this.f5771a;
    }

    /* renamed from: a */
    public ay m8620a(String str) {
        this.f5771a = str;
        return this;
    }

    /* renamed from: d */
    public void m8628d() {
        this.f5771a = null;
    }

    /* renamed from: e */
    public boolean m8629e() {
        return this.f5771a != null;
    }

    /* renamed from: a */
    public void m8622a(boolean z) {
        if (!z) {
            this.f5771a = null;
        }
    }

    /* renamed from: f */
    public long m8630f() {
        return this.f5772b;
    }

    /* renamed from: a */
    public ay m8619a(long j) {
        this.f5772b = j;
        m8626b(true);
        return this;
    }

    /* renamed from: h */
    public void m8632h() {
        this.f5773i = bw.m10080b(this.f5773i, 0);
    }

    /* renamed from: i */
    public boolean m8633i() {
        return bw.m10076a(this.f5773i, 0);
    }

    /* renamed from: b */
    public void m8626b(boolean z) {
        this.f5773i = bw.m10068a(this.f5773i, 0, z);
    }

    /* renamed from: a */
    public C1371e m8617a(int i) {
        return C1371e.m9535a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5769g.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5769g.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Page(");
        stringBuilder.append("page_name:");
        if (this.f5771a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5771a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("duration:");
        stringBuilder.append(this.f5772b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: j */
    public void m8634j() throws cf {
        if (this.f5771a == null) {
            throw new cz("Required field 'page_name' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m8613a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8612a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5773i = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
