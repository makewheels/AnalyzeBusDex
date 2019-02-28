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

/* compiled from: Location */
/* renamed from: u.aly.aw */
public class aw implements Serializable, Cloneable, bz<aw, C1359e> {
    /* renamed from: d */
    public static final Map<C1359e, cl> f6113d;
    /* renamed from: e */
    private static final dd f6114e = new dd("Location");
    /* renamed from: f */
    private static final ct f6115f = new ct("lat", (byte) 4, (short) 1);
    /* renamed from: g */
    private static final ct f6116g = new ct("lng", (byte) 4, (short) 2);
    /* renamed from: h */
    private static final ct f6117h = new ct("ts", (byte) 10, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f6118i = new HashMap();
    /* renamed from: j */
    private static final int f6119j = 0;
    /* renamed from: k */
    private static final int f6120k = 1;
    /* renamed from: l */
    private static final int f6121l = 2;
    /* renamed from: a */
    public double f6122a;
    /* renamed from: b */
    public double f6123b;
    /* renamed from: c */
    public long f6124c;
    /* renamed from: m */
    private byte f6125m;

    /* compiled from: Location */
    /* renamed from: u.aly.aw$a */
    private static class C1355a extends di<aw> {
        private C1355a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9385b(cyVar, (aw) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9383a(cyVar, (aw) bzVar);
        }

        /* renamed from: a */
        public void m9383a(cy cyVar, aw awVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (!awVar.m9420e()) {
                        throw new cz("Required field 'lat' was not found in serialized data! Struct: " + toString());
                    } else if (!awVar.m9424i()) {
                        throw new cz("Required field 'lng' was not found in serialized data! Struct: " + toString());
                    } else if (awVar.m9427l()) {
                        awVar.m9428m();
                        return;
                    } else {
                        throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 4) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        awVar.f6122a = cyVar.mo1982y();
                        awVar.m9411a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 4) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        awVar.f6123b = cyVar.mo1982y();
                        awVar.m9416b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        awVar.f6124c = cyVar.mo1981x();
                        awVar.m9418c(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9385b(cy cyVar, aw awVar) throws cf {
            awVar.m9428m();
            cyVar.mo1956a(aw.f6114e);
            cyVar.mo1951a(aw.f6115f);
            cyVar.mo1946a(awVar.f6122a);
            cyVar.mo1960c();
            cyVar.mo1951a(aw.f6116g);
            cyVar.mo1946a(awVar.f6123b);
            cyVar.mo1960c();
            cyVar.mo1951a(aw.f6117h);
            cyVar.mo1948a(awVar.f6124c);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Location */
    /* renamed from: u.aly.aw$b */
    private static class C1356b implements dh {
        private C1356b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9387a();
        }

        /* renamed from: a */
        public C1355a m9387a() {
            return new C1355a();
        }
    }

    /* compiled from: Location */
    /* renamed from: u.aly.aw$c */
    private static class C1357c extends dj<aw> {
        private C1357c() {
        }

        /* renamed from: a */
        public void m9389a(cy cyVar, aw awVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1946a(awVar.f6122a);
            deVar.mo1946a(awVar.f6123b);
            deVar.mo1948a(awVar.f6124c);
        }

        /* renamed from: b */
        public void m9391b(cy cyVar, aw awVar) throws cf {
            de deVar = (de) cyVar;
            awVar.f6122a = deVar.mo1982y();
            awVar.m9411a(true);
            awVar.f6123b = deVar.mo1982y();
            awVar.m9416b(true);
            awVar.f6124c = deVar.mo1981x();
            awVar.m9418c(true);
        }
    }

    /* compiled from: Location */
    /* renamed from: u.aly.aw$d */
    private static class C1358d implements dh {
        private C1358d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9393a();
        }

        /* renamed from: a */
        public C1357c m9393a() {
            return new C1357c();
        }
    }

    /* compiled from: Location */
    /* renamed from: u.aly.aw$e */
    public enum C1359e implements cg {
        LAT((short) 1, "lat"),
        LNG((short) 2, "lng"),
        TS((short) 3, "ts");
        
        /* renamed from: d */
        private static final Map<String, C1359e> f6109d = null;
        /* renamed from: e */
        private final short f6111e;
        /* renamed from: f */
        private final String f6112f;

        static {
            f6109d = new HashMap();
            Iterator it = EnumSet.allOf(C1359e.class).iterator();
            while (it.hasNext()) {
                C1359e c1359e = (C1359e) it.next();
                f6109d.put(c1359e.mo1932b(), c1359e);
            }
        }

        /* renamed from: a */
        public static C1359e m9395a(int i) {
            switch (i) {
                case 1:
                    return LAT;
                case 2:
                    return LNG;
                case 3:
                    return TS;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1359e m9397b(int i) {
            C1359e a = C1359e.m9395a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1359e m9396a(String str) {
            return (C1359e) f6109d.get(str);
        }

        private C1359e(short s, String str) {
            this.f6111e = s;
            this.f6112f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6111e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6112f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9406a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9407a();
    }

    static {
        f6118i.put(di.class, new C1356b());
        f6118i.put(dj.class, new C1358d());
        Map enumMap = new EnumMap(C1359e.class);
        enumMap.put(C1359e.LAT, new cl("lat", (byte) 1, new cm((byte) 4)));
        enumMap.put(C1359e.LNG, new cl("lng", (byte) 1, new cm((byte) 4)));
        enumMap.put(C1359e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        f6113d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(aw.class, f6113d);
    }

    public aw() {
        this.f6125m = (byte) 0;
    }

    public aw(double d, double d2, long j) {
        this();
        this.f6122a = d;
        m9411a(true);
        this.f6123b = d2;
        m9416b(true);
        this.f6124c = j;
        m9418c(true);
    }

    public aw(aw awVar) {
        this.f6125m = (byte) 0;
        this.f6125m = awVar.f6125m;
        this.f6122a = awVar.f6122a;
        this.f6123b = awVar.f6123b;
        this.f6124c = awVar.f6124c;
    }

    /* renamed from: a */
    public aw m9407a() {
        return new aw(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m9411a(false);
        this.f6122a = 0.0d;
        m9416b(false);
        this.f6123b = 0.0d;
        m9418c(false);
        this.f6124c = 0;
    }

    /* renamed from: c */
    public double m9417c() {
        return this.f6122a;
    }

    /* renamed from: a */
    public aw m9408a(double d) {
        this.f6122a = d;
        m9411a(true);
        return this;
    }

    /* renamed from: d */
    public void m9419d() {
        this.f6125m = bw.m10080b(this.f6125m, 0);
    }

    /* renamed from: e */
    public boolean m9420e() {
        return bw.m10076a(this.f6125m, 0);
    }

    /* renamed from: a */
    public void m9411a(boolean z) {
        this.f6125m = bw.m10068a(this.f6125m, 0, z);
    }

    /* renamed from: f */
    public double m9421f() {
        return this.f6123b;
    }

    /* renamed from: b */
    public aw m9412b(double d) {
        this.f6123b = d;
        m9416b(true);
        return this;
    }

    /* renamed from: h */
    public void m9423h() {
        this.f6125m = bw.m10080b(this.f6125m, 1);
    }

    /* renamed from: i */
    public boolean m9424i() {
        return bw.m10076a(this.f6125m, 1);
    }

    /* renamed from: b */
    public void m9416b(boolean z) {
        this.f6125m = bw.m10068a(this.f6125m, 1, z);
    }

    /* renamed from: j */
    public long m9425j() {
        return this.f6124c;
    }

    /* renamed from: a */
    public aw m9409a(long j) {
        this.f6124c = j;
        m9418c(true);
        return this;
    }

    /* renamed from: k */
    public void m9426k() {
        this.f6125m = bw.m10080b(this.f6125m, 2);
    }

    /* renamed from: l */
    public boolean m9427l() {
        return bw.m10076a(this.f6125m, 2);
    }

    /* renamed from: c */
    public void m9418c(boolean z) {
        this.f6125m = bw.m10068a(this.f6125m, 2, z);
    }

    /* renamed from: a */
    public C1359e m9406a(int i) {
        return C1359e.m9395a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6118i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6118i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Location(");
        stringBuilder.append("lat:");
        stringBuilder.append(this.f6122a);
        stringBuilder.append(", ");
        stringBuilder.append("lng:");
        stringBuilder.append(this.f6123b);
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f6124c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: m */
    public void m9428m() throws cf {
    }

    /* renamed from: a */
    private void m9401a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9400a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6125m = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
