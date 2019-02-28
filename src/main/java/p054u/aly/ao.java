package p054u.aly;

import com.alipay.sdk.cons.C0110c;
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
import java.util.Map.Entry;

/* compiled from: Event */
/* renamed from: u.aly.ao */
public class ao implements Serializable, Cloneable, bz<ao, C1317e> {
    /* renamed from: f */
    public static final Map<C1317e, cl> f5735f;
    /* renamed from: g */
    private static final dd f5736g = new dd("Event");
    /* renamed from: h */
    private static final ct f5737h = new ct(C0110c.f289e, (byte) 11, (short) 1);
    /* renamed from: i */
    private static final ct f5738i = new ct("properties", df.f6527k, (short) 2);
    /* renamed from: j */
    private static final ct f5739j = new ct("duration", (byte) 10, (short) 3);
    /* renamed from: k */
    private static final ct f5740k = new ct("acc", (byte) 8, (short) 4);
    /* renamed from: l */
    private static final ct f5741l = new ct("ts", (byte) 10, (short) 5);
    /* renamed from: m */
    private static final Map<Class<? extends dg>, dh> f5742m = new HashMap();
    /* renamed from: n */
    private static final int f5743n = 0;
    /* renamed from: o */
    private static final int f5744o = 1;
    /* renamed from: p */
    private static final int f5745p = 2;
    /* renamed from: a */
    public String f5746a;
    /* renamed from: b */
    public Map<String, az> f5747b;
    /* renamed from: c */
    public long f5748c;
    /* renamed from: d */
    public int f5749d;
    /* renamed from: e */
    public long f5750e;
    /* renamed from: q */
    private byte f5751q;
    /* renamed from: r */
    private C1317e[] f5752r;

    /* compiled from: Event */
    /* renamed from: u.aly.ao$a */
    private static class C1313a extends di<ao> {
        private C1313a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9062b(cyVar, (ao) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9060a(cyVar, (ao) bzVar);
        }

        /* renamed from: a */
        public void m9060a(cy cyVar, ao aoVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (aoVar.m8571s()) {
                        aoVar.m8572t();
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
                        aoVar.f5746a = cyVar.mo1983z();
                        aoVar.m8545a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != df.f6527k) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        cv n = cyVar.mo1971n();
                        aoVar.f5747b = new HashMap(n.f6491c * 2);
                        for (int i = 0; i < n.f6491c; i++) {
                            String z = cyVar.mo1983z();
                            az azVar = new az();
                            azVar.mo1921a(cyVar);
                            aoVar.f5747b.put(z, azVar);
                        }
                        cyVar.mo1972o();
                        aoVar.m8550b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aoVar.f5748c = cyVar.mo1981x();
                        aoVar.m8553c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aoVar.f5749d = cyVar.mo1980w();
                        aoVar.m8555d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aoVar.f5750e = cyVar.mo1981x();
                        aoVar.m8556e(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9062b(cy cyVar, ao aoVar) throws cf {
            aoVar.m8572t();
            cyVar.mo1956a(ao.f5736g);
            if (aoVar.f5746a != null) {
                cyVar.mo1951a(ao.f5737h);
                cyVar.mo1949a(aoVar.f5746a);
                cyVar.mo1960c();
            }
            if (aoVar.f5747b != null) {
                cyVar.mo1951a(ao.f5738i);
                cyVar.mo1953a(new cv((byte) 11, (byte) 12, aoVar.f5747b.size()));
                for (Entry entry : aoVar.f5747b.entrySet()) {
                    cyVar.mo1949a((String) entry.getKey());
                    ((az) entry.getValue()).mo1924b(cyVar);
                }
                cyVar.mo1962e();
                cyVar.mo1960c();
            }
            if (aoVar.m8565m()) {
                cyVar.mo1951a(ao.f5739j);
                cyVar.mo1948a(aoVar.f5748c);
                cyVar.mo1960c();
            }
            if (aoVar.m8568p()) {
                cyVar.mo1951a(ao.f5740k);
                cyVar.mo1947a(aoVar.f5749d);
                cyVar.mo1960c();
            }
            cyVar.mo1951a(ao.f5741l);
            cyVar.mo1948a(aoVar.f5750e);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Event */
    /* renamed from: u.aly.ao$b */
    private static class C1314b implements dh {
        private C1314b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9064a();
        }

        /* renamed from: a */
        public C1313a m9064a() {
            return new C1313a();
        }
    }

    /* compiled from: Event */
    /* renamed from: u.aly.ao$c */
    private static class C1315c extends dj<ao> {
        private C1315c() {
        }

        /* renamed from: a */
        public void m9066a(cy cyVar, ao aoVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1949a(aoVar.f5746a);
            deVar.mo1947a(aoVar.f5747b.size());
            for (Entry entry : aoVar.f5747b.entrySet()) {
                deVar.mo1949a((String) entry.getKey());
                ((az) entry.getValue()).mo1924b((cy) deVar);
            }
            deVar.mo1948a(aoVar.f5750e);
            BitSet bitSet = new BitSet();
            if (aoVar.m8565m()) {
                bitSet.set(0);
            }
            if (aoVar.m8568p()) {
                bitSet.set(1);
            }
            deVar.m10341a(bitSet, 2);
            if (aoVar.m8565m()) {
                deVar.mo1948a(aoVar.f5748c);
            }
            if (aoVar.m8568p()) {
                deVar.mo1947a(aoVar.f5749d);
            }
        }

        /* renamed from: b */
        public void m9068b(cy cyVar, ao aoVar) throws cf {
            de deVar = (de) cyVar;
            aoVar.f5746a = deVar.mo1983z();
            aoVar.m8545a(true);
            cv cvVar = new cv((byte) 11, (byte) 12, deVar.mo1980w());
            aoVar.f5747b = new HashMap(cvVar.f6491c * 2);
            for (int i = 0; i < cvVar.f6491c; i++) {
                String z = deVar.mo1983z();
                az azVar = new az();
                azVar.mo1921a((cy) deVar);
                aoVar.f5747b.put(z, azVar);
            }
            aoVar.m8550b(true);
            aoVar.f5750e = deVar.mo1981x();
            aoVar.m8556e(true);
            BitSet b = deVar.mo1986b(2);
            if (b.get(0)) {
                aoVar.f5748c = deVar.mo1981x();
                aoVar.m8553c(true);
            }
            if (b.get(1)) {
                aoVar.f5749d = deVar.mo1980w();
                aoVar.m8555d(true);
            }
        }
    }

    /* compiled from: Event */
    /* renamed from: u.aly.ao$d */
    private static class C1316d implements dh {
        private C1316d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9070a();
        }

        /* renamed from: a */
        public C1315c m9070a() {
            return new C1315c();
        }
    }

    /* compiled from: Event */
    /* renamed from: u.aly.ao$e */
    public enum C1317e implements cg {
        NAME((short) 1, C0110c.f289e),
        PROPERTIES((short) 2, "properties"),
        DURATION((short) 3, "duration"),
        ACC((short) 4, "acc"),
        TS((short) 5, "ts");
        
        /* renamed from: f */
        private static final Map<String, C1317e> f5982f = null;
        /* renamed from: g */
        private final short f5984g;
        /* renamed from: h */
        private final String f5985h;

        static {
            f5982f = new HashMap();
            Iterator it = EnumSet.allOf(C1317e.class).iterator();
            while (it.hasNext()) {
                C1317e c1317e = (C1317e) it.next();
                f5982f.put(c1317e.mo1932b(), c1317e);
            }
        }

        /* renamed from: a */
        public static C1317e m9072a(int i) {
            switch (i) {
                case 1:
                    return NAME;
                case 2:
                    return PROPERTIES;
                case 3:
                    return DURATION;
                case 4:
                    return ACC;
                case 5:
                    return TS;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1317e m9074b(int i) {
            C1317e a = C1317e.m9072a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1317e m9073a(String str) {
            return (C1317e) f5982f.get(str);
        }

        private C1317e(short s, String str) {
            this.f5984g = s;
            this.f5985h = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5984g;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5985h;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8552c(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8538a();
    }

    static {
        f5742m.put(di.class, new C1314b());
        f5742m.put(dj.class, new C1316d());
        Map enumMap = new EnumMap(C1317e.class);
        enumMap.put(C1317e.NAME, new cl(C0110c.f289e, (byte) 1, new cm((byte) 11)));
        enumMap.put(C1317e.PROPERTIES, new cl("properties", (byte) 1, new co(df.f6527k, new cm((byte) 11), new cq((byte) 12, az.class))));
        enumMap.put(C1317e.DURATION, new cl("duration", (byte) 2, new cm((byte) 10)));
        enumMap.put(C1317e.ACC, new cl("acc", (byte) 2, new cm((byte) 8)));
        enumMap.put(C1317e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        f5735f = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ao.class, f5735f);
    }

    public ao() {
        this.f5751q = (byte) 0;
        this.f5752r = new C1317e[]{C1317e.DURATION, C1317e.ACC};
    }

    public ao(String str, Map<String, az> map, long j) {
        this();
        this.f5746a = str;
        this.f5747b = map;
        this.f5750e = j;
        m8556e(true);
    }

    public ao(ao aoVar) {
        this.f5751q = (byte) 0;
        this.f5752r = new C1317e[]{C1317e.DURATION, C1317e.ACC};
        this.f5751q = aoVar.f5751q;
        if (aoVar.m8557e()) {
            this.f5746a = aoVar.f5746a;
        }
        if (aoVar.m8562j()) {
            Map hashMap = new HashMap();
            for (Entry entry : aoVar.f5747b.entrySet()) {
                hashMap.put((String) entry.getKey(), new az((az) entry.getValue()));
            }
            this.f5747b = hashMap;
        }
        this.f5748c = aoVar.f5748c;
        this.f5749d = aoVar.f5749d;
        this.f5750e = aoVar.f5750e;
    }

    /* renamed from: a */
    public ao m8538a() {
        return new ao(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f5746a = null;
        this.f5747b = null;
        m8553c(false);
        this.f5748c = 0;
        m8555d(false);
        this.f5749d = 0;
        m8556e(false);
        this.f5750e = 0;
    }

    /* renamed from: c */
    public String m8551c() {
        return this.f5746a;
    }

    /* renamed from: a */
    public ao m8541a(String str) {
        this.f5746a = str;
        return this;
    }

    /* renamed from: d */
    public void m8554d() {
        this.f5746a = null;
    }

    /* renamed from: e */
    public boolean m8557e() {
        return this.f5746a != null;
    }

    /* renamed from: a */
    public void m8545a(boolean z) {
        if (!z) {
            this.f5746a = null;
        }
    }

    /* renamed from: f */
    public int m8558f() {
        return this.f5747b == null ? 0 : this.f5747b.size();
    }

    /* renamed from: a */
    public void m8543a(String str, az azVar) {
        if (this.f5747b == null) {
            this.f5747b = new HashMap();
        }
        this.f5747b.put(str, azVar);
    }

    /* renamed from: h */
    public Map<String, az> m8560h() {
        return this.f5747b;
    }

    /* renamed from: a */
    public ao m8542a(Map<String, az> map) {
        this.f5747b = map;
        return this;
    }

    /* renamed from: i */
    public void m8561i() {
        this.f5747b = null;
    }

    /* renamed from: j */
    public boolean m8562j() {
        return this.f5747b != null;
    }

    /* renamed from: b */
    public void m8550b(boolean z) {
        if (!z) {
            this.f5747b = null;
        }
    }

    /* renamed from: k */
    public long m8563k() {
        return this.f5748c;
    }

    /* renamed from: a */
    public ao m8540a(long j) {
        this.f5748c = j;
        m8553c(true);
        return this;
    }

    /* renamed from: l */
    public void m8564l() {
        this.f5751q = bw.m10080b(this.f5751q, 0);
    }

    /* renamed from: m */
    public boolean m8565m() {
        return bw.m10076a(this.f5751q, 0);
    }

    /* renamed from: c */
    public void m8553c(boolean z) {
        this.f5751q = bw.m10068a(this.f5751q, 0, z);
    }

    /* renamed from: n */
    public int m8566n() {
        return this.f5749d;
    }

    /* renamed from: a */
    public ao m8539a(int i) {
        this.f5749d = i;
        m8555d(true);
        return this;
    }

    /* renamed from: o */
    public void m8567o() {
        this.f5751q = bw.m10080b(this.f5751q, 1);
    }

    /* renamed from: p */
    public boolean m8568p() {
        return bw.m10076a(this.f5751q, 1);
    }

    /* renamed from: d */
    public void m8555d(boolean z) {
        this.f5751q = bw.m10068a(this.f5751q, 1, z);
    }

    /* renamed from: q */
    public long m8569q() {
        return this.f5750e;
    }

    /* renamed from: b */
    public ao m8546b(long j) {
        this.f5750e = j;
        m8556e(true);
        return this;
    }

    /* renamed from: r */
    public void m8570r() {
        this.f5751q = bw.m10080b(this.f5751q, 2);
    }

    /* renamed from: s */
    public boolean m8571s() {
        return bw.m10076a(this.f5751q, 2);
    }

    /* renamed from: e */
    public void m8556e(boolean z) {
        this.f5751q = bw.m10068a(this.f5751q, 2, z);
    }

    /* renamed from: c */
    public C1317e m8552c(int i) {
        return C1317e.m9072a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5742m.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5742m.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Event(");
        stringBuilder.append("name:");
        if (this.f5746a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5746a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("properties:");
        if (this.f5747b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5747b);
        }
        if (m8565m()) {
            stringBuilder.append(", ");
            stringBuilder.append("duration:");
            stringBuilder.append(this.f5748c);
        }
        if (m8568p()) {
            stringBuilder.append(", ");
            stringBuilder.append("acc:");
            stringBuilder.append(this.f5749d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f5750e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: t */
    public void m8572t() throws cf {
        if (this.f5746a == null) {
            throw new cz("Required field 'name' was not present! Struct: " + toString());
        } else if (this.f5747b == null) {
            throw new cz("Required field 'properties' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m8531a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8530a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5751q = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
