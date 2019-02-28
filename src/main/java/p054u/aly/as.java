package p054u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: IdTracking */
/* renamed from: u.aly.as */
public class as implements Serializable, Cloneable, bz<as, C1335e> {
    /* renamed from: d */
    public static final Map<C1335e, cl> f6039d;
    /* renamed from: e */
    private static final dd f6040e = new dd("IdTracking");
    /* renamed from: f */
    private static final ct f6041f = new ct("snapshots", df.f6527k, (short) 1);
    /* renamed from: g */
    private static final ct f6042g = new ct("journals", df.f6529m, (short) 2);
    /* renamed from: h */
    private static final ct f6043h = new ct("checksum", (byte) 11, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f6044i = new HashMap();
    /* renamed from: a */
    public Map<String, ar> f6045a;
    /* renamed from: b */
    public List<aq> f6046b;
    /* renamed from: c */
    public String f6047c;
    /* renamed from: j */
    private C1335e[] f6048j;

    /* compiled from: IdTracking */
    /* renamed from: u.aly.as$a */
    private static class C1331a extends di<as> {
        private C1331a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9179b(cyVar, (as) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9177a(cyVar, (as) bzVar);
        }

        /* renamed from: a */
        public void m9177a(cy cyVar, as asVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    asVar.m9227p();
                    return;
                }
                int i;
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != df.f6527k) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        cv n = cyVar.mo1971n();
                        asVar.f6045a = new HashMap(n.f6491c * 2);
                        for (i = 0; i < n.f6491c; i++) {
                            String z = cyVar.mo1983z();
                            ar arVar = new ar();
                            arVar.mo1921a(cyVar);
                            asVar.f6045a.put(z, arVar);
                        }
                        cyVar.mo1972o();
                        asVar.m9208a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        cu p = cyVar.mo1973p();
                        asVar.f6046b = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            aq aqVar = new aq();
                            aqVar.mo1921a(cyVar);
                            asVar.f6046b.add(aqVar);
                        }
                        cyVar.mo1974q();
                        asVar.m9212b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        asVar.f6047c = cyVar.mo1983z();
                        asVar.m9214c(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9179b(cy cyVar, as asVar) throws cf {
            asVar.m9227p();
            cyVar.mo1956a(as.f6040e);
            if (asVar.f6045a != null) {
                cyVar.mo1951a(as.f6041f);
                cyVar.mo1953a(new cv((byte) 11, (byte) 12, asVar.f6045a.size()));
                for (Entry entry : asVar.f6045a.entrySet()) {
                    cyVar.mo1949a((String) entry.getKey());
                    ((ar) entry.getValue()).mo1924b(cyVar);
                }
                cyVar.mo1962e();
                cyVar.mo1960c();
            }
            if (asVar.f6046b != null && asVar.m9223l()) {
                cyVar.mo1951a(as.f6042g);
                cyVar.mo1952a(new cu((byte) 12, asVar.f6046b.size()));
                for (aq b : asVar.f6046b) {
                    b.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            if (asVar.f6047c != null && asVar.m9226o()) {
                cyVar.mo1951a(as.f6043h);
                cyVar.mo1949a(asVar.f6047c);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: IdTracking */
    /* renamed from: u.aly.as$b */
    private static class C1332b implements dh {
        private C1332b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9181a();
        }

        /* renamed from: a */
        public C1331a m9181a() {
            return new C1331a();
        }
    }

    /* compiled from: IdTracking */
    /* renamed from: u.aly.as$c */
    private static class C1333c extends dj<as> {
        private C1333c() {
        }

        /* renamed from: a */
        public void m9183a(cy cyVar, as asVar) throws cf {
            cyVar = (de) cyVar;
            cyVar.mo1947a(asVar.f6045a.size());
            for (Entry entry : asVar.f6045a.entrySet()) {
                cyVar.mo1949a((String) entry.getKey());
                ((ar) entry.getValue()).mo1924b(cyVar);
            }
            BitSet bitSet = new BitSet();
            if (asVar.m9223l()) {
                bitSet.set(0);
            }
            if (asVar.m9226o()) {
                bitSet.set(1);
            }
            cyVar.m10341a(bitSet, 2);
            if (asVar.m9223l()) {
                cyVar.mo1947a(asVar.f6046b.size());
                for (aq b : asVar.f6046b) {
                    b.mo1924b(cyVar);
                }
            }
            if (asVar.m9226o()) {
                cyVar.mo1949a(asVar.f6047c);
            }
        }

        /* renamed from: b */
        public void m9185b(cy cyVar, as asVar) throws cf {
            int i = 0;
            cyVar = (de) cyVar;
            cv cvVar = new cv((byte) 11, (byte) 12, cyVar.mo1980w());
            asVar.f6045a = new HashMap(cvVar.f6491c * 2);
            for (int i2 = 0; i2 < cvVar.f6491c; i2++) {
                String z = cyVar.mo1983z();
                ar arVar = new ar();
                arVar.mo1921a(cyVar);
                asVar.f6045a.put(z, arVar);
            }
            asVar.m9208a(true);
            BitSet b = cyVar.mo1986b(2);
            if (b.get(0)) {
                cu cuVar = new cu((byte) 12, cyVar.mo1980w());
                asVar.f6046b = new ArrayList(cuVar.f6488b);
                while (i < cuVar.f6488b) {
                    aq aqVar = new aq();
                    aqVar.mo1921a(cyVar);
                    asVar.f6046b.add(aqVar);
                    i++;
                }
                asVar.m9212b(true);
            }
            if (b.get(1)) {
                asVar.f6047c = cyVar.mo1983z();
                asVar.m9214c(true);
            }
        }
    }

    /* compiled from: IdTracking */
    /* renamed from: u.aly.as$d */
    private static class C1334d implements dh {
        private C1334d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9187a();
        }

        /* renamed from: a */
        public C1333c m9187a() {
            return new C1333c();
        }
    }

    /* compiled from: IdTracking */
    /* renamed from: u.aly.as$e */
    public enum C1335e implements cg {
        SNAPSHOTS((short) 1, "snapshots"),
        JOURNALS((short) 2, "journals"),
        CHECKSUM((short) 3, "checksum");
        
        /* renamed from: d */
        private static final Map<String, C1335e> f6035d = null;
        /* renamed from: e */
        private final short f6037e;
        /* renamed from: f */
        private final String f6038f;

        static {
            f6035d = new HashMap();
            Iterator it = EnumSet.allOf(C1335e.class).iterator();
            while (it.hasNext()) {
                C1335e c1335e = (C1335e) it.next();
                f6035d.put(c1335e.mo1932b(), c1335e);
            }
        }

        /* renamed from: a */
        public static C1335e m9189a(int i) {
            switch (i) {
                case 1:
                    return SNAPSHOTS;
                case 2:
                    return JOURNALS;
                case 3:
                    return CHECKSUM;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1335e m9191b(int i) {
            C1335e a = C1335e.m9189a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1335e m9190a(String str) {
            return (C1335e) f6035d.get(str);
        }

        private C1335e(short s, String str) {
            this.f6037e = s;
            this.f6038f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6037e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6038f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9200a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9201a();
    }

    static {
        f6044i.put(di.class, new C1332b());
        f6044i.put(dj.class, new C1334d());
        Map enumMap = new EnumMap(C1335e.class);
        enumMap.put(C1335e.SNAPSHOTS, new cl("snapshots", (byte) 1, new co(df.f6527k, new cm((byte) 11), new cq((byte) 12, ar.class))));
        enumMap.put(C1335e.JOURNALS, new cl("journals", (byte) 2, new cn(df.f6529m, new cq((byte) 12, aq.class))));
        enumMap.put(C1335e.CHECKSUM, new cl("checksum", (byte) 2, new cm((byte) 11)));
        f6039d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(as.class, f6039d);
    }

    public as() {
        this.f6048j = new C1335e[]{C1335e.JOURNALS, C1335e.CHECKSUM};
    }

    public as(Map<String, ar> map) {
        this();
        this.f6045a = map;
    }

    public as(as asVar) {
        this.f6048j = new C1335e[]{C1335e.JOURNALS, C1335e.CHECKSUM};
        if (asVar.m9217f()) {
            Map hashMap = new HashMap();
            for (Entry entry : asVar.f6045a.entrySet()) {
                hashMap.put((String) entry.getKey(), new ar((ar) entry.getValue()));
            }
            this.f6045a = hashMap;
        }
        if (asVar.m9223l()) {
            List arrayList = new ArrayList();
            for (aq aqVar : asVar.f6046b) {
                arrayList.add(new aq(aqVar));
            }
            this.f6046b = arrayList;
        }
        if (asVar.m9226o()) {
            this.f6047c = asVar.f6047c;
        }
    }

    /* renamed from: a */
    public as m9201a() {
        return new as(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6045a = null;
        this.f6046b = null;
        this.f6047c = null;
    }

    /* renamed from: c */
    public int m9213c() {
        return this.f6045a == null ? 0 : this.f6045a.size();
    }

    /* renamed from: a */
    public void m9205a(String str, ar arVar) {
        if (this.f6045a == null) {
            this.f6045a = new HashMap();
        }
        this.f6045a.put(str, arVar);
    }

    /* renamed from: d */
    public Map<String, ar> m9215d() {
        return this.f6045a;
    }

    /* renamed from: a */
    public as m9204a(Map<String, ar> map) {
        this.f6045a = map;
        return this;
    }

    /* renamed from: e */
    public void m9216e() {
        this.f6045a = null;
    }

    /* renamed from: f */
    public boolean m9217f() {
        return this.f6045a != null;
    }

    /* renamed from: a */
    public void m9208a(boolean z) {
        if (!z) {
            this.f6045a = null;
        }
    }

    /* renamed from: h */
    public int m9219h() {
        return this.f6046b == null ? 0 : this.f6046b.size();
    }

    /* renamed from: i */
    public Iterator<aq> m9220i() {
        return this.f6046b == null ? null : this.f6046b.iterator();
    }

    /* renamed from: a */
    public void m9206a(aq aqVar) {
        if (this.f6046b == null) {
            this.f6046b = new ArrayList();
        }
        this.f6046b.add(aqVar);
    }

    /* renamed from: j */
    public List<aq> m9221j() {
        return this.f6046b;
    }

    /* renamed from: a */
    public as m9203a(List<aq> list) {
        this.f6046b = list;
        return this;
    }

    /* renamed from: k */
    public void m9222k() {
        this.f6046b = null;
    }

    /* renamed from: l */
    public boolean m9223l() {
        return this.f6046b != null;
    }

    /* renamed from: b */
    public void m9212b(boolean z) {
        if (!z) {
            this.f6046b = null;
        }
    }

    /* renamed from: m */
    public String m9224m() {
        return this.f6047c;
    }

    /* renamed from: a */
    public as m9202a(String str) {
        this.f6047c = str;
        return this;
    }

    /* renamed from: n */
    public void m9225n() {
        this.f6047c = null;
    }

    /* renamed from: o */
    public boolean m9226o() {
        return this.f6047c != null;
    }

    /* renamed from: c */
    public void m9214c(boolean z) {
        if (!z) {
            this.f6047c = null;
        }
    }

    /* renamed from: a */
    public C1335e m9200a(int i) {
        return C1335e.m9189a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6044i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6044i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdTracking(");
        stringBuilder.append("snapshots:");
        if (this.f6045a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6045a);
        }
        if (m9223l()) {
            stringBuilder.append(", ");
            stringBuilder.append("journals:");
            if (this.f6046b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6046b);
            }
        }
        if (m9226o()) {
            stringBuilder.append(", ");
            stringBuilder.append("checksum:");
            if (this.f6047c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6047c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: p */
    public void m9227p() throws cf {
        if (this.f6045a == null) {
            throw new cz("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m9195a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9194a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
