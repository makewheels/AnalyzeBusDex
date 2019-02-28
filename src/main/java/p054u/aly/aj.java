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

/* compiled from: ClientStats */
/* renamed from: u.aly.aj */
public class aj implements Serializable, Cloneable, bz<aj, C1293e> {
    /* renamed from: d */
    public static final Map<C1293e, cl> f5862d;
    /* renamed from: e */
    private static final dd f5863e = new dd("ClientStats");
    /* renamed from: f */
    private static final ct f5864f = new ct("successful_requests", (byte) 8, (short) 1);
    /* renamed from: g */
    private static final ct f5865g = new ct("failed_requests", (byte) 8, (short) 2);
    /* renamed from: h */
    private static final ct f5866h = new ct("last_request_spent_ms", (byte) 8, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f5867i = new HashMap();
    /* renamed from: j */
    private static final int f5868j = 0;
    /* renamed from: k */
    private static final int f5869k = 1;
    /* renamed from: l */
    private static final int f5870l = 2;
    /* renamed from: a */
    public int f5871a;
    /* renamed from: b */
    public int f5872b;
    /* renamed from: c */
    public int f5873c;
    /* renamed from: m */
    private byte f5874m;
    /* renamed from: n */
    private C1293e[] f5875n;

    /* compiled from: ClientStats */
    /* renamed from: u.aly.aj$a */
    private static class C1289a extends di<aj> {
        private C1289a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m8828b(cyVar, (aj) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m8826a(cyVar, (aj) bzVar);
        }

        /* renamed from: a */
        public void m8826a(cy cyVar, aj ajVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (!ajVar.m8863e()) {
                        throw new cz("Required field 'successful_requests' was not found in serialized data! Struct: " + toString());
                    } else if (ajVar.m8867i()) {
                        ajVar.m8871m();
                        return;
                    } else {
                        throw new cz("Required field 'failed_requests' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        ajVar.f5871a = cyVar.mo1980w();
                        ajVar.m8852a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        ajVar.f5872b = cyVar.mo1980w();
                        ajVar.m8856b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        ajVar.f5873c = cyVar.mo1980w();
                        ajVar.m8859c(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m8828b(cy cyVar, aj ajVar) throws cf {
            ajVar.m8871m();
            cyVar.mo1956a(aj.f5863e);
            cyVar.mo1951a(aj.f5864f);
            cyVar.mo1947a(ajVar.f5871a);
            cyVar.mo1960c();
            cyVar.mo1951a(aj.f5865g);
            cyVar.mo1947a(ajVar.f5872b);
            cyVar.mo1960c();
            if (ajVar.m8870l()) {
                cyVar.mo1951a(aj.f5866h);
                cyVar.mo1947a(ajVar.f5873c);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: ClientStats */
    /* renamed from: u.aly.aj$b */
    private static class C1290b implements dh {
        private C1290b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8830a();
        }

        /* renamed from: a */
        public C1289a m8830a() {
            return new C1289a();
        }
    }

    /* compiled from: ClientStats */
    /* renamed from: u.aly.aj$c */
    private static class C1291c extends dj<aj> {
        private C1291c() {
        }

        /* renamed from: a */
        public void m8832a(cy cyVar, aj ajVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1947a(ajVar.f5871a);
            deVar.mo1947a(ajVar.f5872b);
            BitSet bitSet = new BitSet();
            if (ajVar.m8870l()) {
                bitSet.set(0);
            }
            deVar.m10341a(bitSet, 1);
            if (ajVar.m8870l()) {
                deVar.mo1947a(ajVar.f5873c);
            }
        }

        /* renamed from: b */
        public void m8834b(cy cyVar, aj ajVar) throws cf {
            de deVar = (de) cyVar;
            ajVar.f5871a = deVar.mo1980w();
            ajVar.m8852a(true);
            ajVar.f5872b = deVar.mo1980w();
            ajVar.m8856b(true);
            if (deVar.mo1986b(1).get(0)) {
                ajVar.f5873c = deVar.mo1980w();
                ajVar.m8859c(true);
            }
        }
    }

    /* compiled from: ClientStats */
    /* renamed from: u.aly.aj$d */
    private static class C1292d implements dh {
        private C1292d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8836a();
        }

        /* renamed from: a */
        public C1291c m8836a() {
            return new C1291c();
        }
    }

    /* compiled from: ClientStats */
    /* renamed from: u.aly.aj$e */
    public enum C1293e implements cg {
        SUCCESSFUL_REQUESTS((short) 1, "successful_requests"),
        FAILED_REQUESTS((short) 2, "failed_requests"),
        LAST_REQUEST_SPENT_MS((short) 3, "last_request_spent_ms");
        
        /* renamed from: d */
        private static final Map<String, C1293e> f5858d = null;
        /* renamed from: e */
        private final short f5860e;
        /* renamed from: f */
        private final String f5861f;

        static {
            f5858d = new HashMap();
            Iterator it = EnumSet.allOf(C1293e.class).iterator();
            while (it.hasNext()) {
                C1293e c1293e = (C1293e) it.next();
                f5858d.put(c1293e.mo1932b(), c1293e);
            }
        }

        /* renamed from: a */
        public static C1293e m8838a(int i) {
            switch (i) {
                case 1:
                    return SUCCESSFUL_REQUESTS;
                case 2:
                    return FAILED_REQUESTS;
                case 3:
                    return LAST_REQUEST_SPENT_MS;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1293e m8840b(int i) {
            C1293e a = C1293e.m8838a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1293e m8839a(String str) {
            return (C1293e) f5858d.get(str);
        }

        private C1293e(short s, String str) {
            this.f5860e = s;
            this.f5861f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5860e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5861f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8862e(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8849a();
    }

    static {
        f5867i.put(di.class, new C1290b());
        f5867i.put(dj.class, new C1292d());
        Map enumMap = new EnumMap(C1293e.class);
        enumMap.put(C1293e.SUCCESSFUL_REQUESTS, new cl("successful_requests", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1293e.FAILED_REQUESTS, new cl("failed_requests", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1293e.LAST_REQUEST_SPENT_MS, new cl("last_request_spent_ms", (byte) 2, new cm((byte) 8)));
        f5862d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(aj.class, f5862d);
    }

    public aj() {
        this.f5874m = (byte) 0;
        this.f5875n = new C1293e[]{C1293e.LAST_REQUEST_SPENT_MS};
        this.f5871a = 0;
        this.f5872b = 0;
    }

    public aj(int i, int i2) {
        this();
        this.f5871a = i;
        m8852a(true);
        this.f5872b = i2;
        m8856b(true);
    }

    public aj(aj ajVar) {
        this.f5874m = (byte) 0;
        this.f5875n = new C1293e[]{C1293e.LAST_REQUEST_SPENT_MS};
        this.f5874m = ajVar.f5874m;
        this.f5871a = ajVar.f5871a;
        this.f5872b = ajVar.f5872b;
        this.f5873c = ajVar.f5873c;
    }

    /* renamed from: a */
    public aj m8849a() {
        return new aj(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f5871a = 0;
        this.f5872b = 0;
        m8859c(false);
        this.f5873c = 0;
    }

    /* renamed from: c */
    public int m8857c() {
        return this.f5871a;
    }

    /* renamed from: a */
    public aj m8850a(int i) {
        this.f5871a = i;
        m8852a(true);
        return this;
    }

    /* renamed from: d */
    public void m8861d() {
        this.f5874m = bw.m10080b(this.f5874m, 0);
    }

    /* renamed from: e */
    public boolean m8863e() {
        return bw.m10076a(this.f5874m, 0);
    }

    /* renamed from: a */
    public void m8852a(boolean z) {
        this.f5874m = bw.m10068a(this.f5874m, 0, z);
    }

    /* renamed from: f */
    public int m8864f() {
        return this.f5872b;
    }

    /* renamed from: c */
    public aj m8858c(int i) {
        this.f5872b = i;
        m8856b(true);
        return this;
    }

    /* renamed from: h */
    public void m8866h() {
        this.f5874m = bw.m10080b(this.f5874m, 1);
    }

    /* renamed from: i */
    public boolean m8867i() {
        return bw.m10076a(this.f5874m, 1);
    }

    /* renamed from: b */
    public void m8856b(boolean z) {
        this.f5874m = bw.m10068a(this.f5874m, 1, z);
    }

    /* renamed from: j */
    public int m8868j() {
        return this.f5873c;
    }

    /* renamed from: d */
    public aj m8860d(int i) {
        this.f5873c = i;
        m8859c(true);
        return this;
    }

    /* renamed from: k */
    public void m8869k() {
        this.f5874m = bw.m10080b(this.f5874m, 2);
    }

    /* renamed from: l */
    public boolean m8870l() {
        return bw.m10076a(this.f5874m, 2);
    }

    /* renamed from: c */
    public void m8859c(boolean z) {
        this.f5874m = bw.m10068a(this.f5874m, 2, z);
    }

    /* renamed from: e */
    public C1293e m8862e(int i) {
        return C1293e.m8838a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5867i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5867i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ClientStats(");
        stringBuilder.append("successful_requests:");
        stringBuilder.append(this.f5871a);
        stringBuilder.append(", ");
        stringBuilder.append("failed_requests:");
        stringBuilder.append(this.f5872b);
        if (m8870l()) {
            stringBuilder.append(", ");
            stringBuilder.append("last_request_spent_ms:");
            stringBuilder.append(this.f5873c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: m */
    public void m8871m() throws cf {
    }

    /* renamed from: a */
    private void m8844a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8843a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5874m = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
