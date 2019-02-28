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

/* compiled from: Session */
/* renamed from: u.aly.bd */
public class bd implements Serializable, Cloneable, bz<bd, C1392e> {
    /* renamed from: h */
    public static final Map<C1392e, cl> f5774h;
    /* renamed from: i */
    private static final dd f5775i = new dd("Session");
    /* renamed from: j */
    private static final ct f5776j = new ct("id", (byte) 11, (short) 1);
    /* renamed from: k */
    private static final ct f5777k = new ct("start_time", (byte) 10, (short) 2);
    /* renamed from: l */
    private static final ct f5778l = new ct("end_time", (byte) 10, (short) 3);
    /* renamed from: m */
    private static final ct f5779m = new ct("duration", (byte) 10, (short) 4);
    /* renamed from: n */
    private static final ct f5780n = new ct("pages", df.f6529m, (short) 5);
    /* renamed from: o */
    private static final ct f5781o = new ct("locations", df.f6529m, (short) 6);
    /* renamed from: p */
    private static final ct f5782p = new ct("traffic", (byte) 12, (short) 7);
    /* renamed from: q */
    private static final Map<Class<? extends dg>, dh> f5783q = new HashMap();
    /* renamed from: r */
    private static final int f5784r = 0;
    /* renamed from: s */
    private static final int f5785s = 1;
    /* renamed from: t */
    private static final int f5786t = 2;
    /* renamed from: a */
    public String f5787a;
    /* renamed from: b */
    public long f5788b;
    /* renamed from: c */
    public long f5789c;
    /* renamed from: d */
    public long f5790d;
    /* renamed from: e */
    public List<ay> f5791e;
    /* renamed from: f */
    public List<aw> f5792f;
    /* renamed from: g */
    public be f5793g;
    /* renamed from: u */
    private byte f5794u;
    /* renamed from: v */
    private C1392e[] f5795v;

    /* compiled from: Session */
    /* renamed from: u.aly.bd$a */
    private static class C1388a extends di<bd> {
        private C1388a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9687b(cyVar, (bd) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9685a(cyVar, (bd) bzVar);
        }

        /* renamed from: a */
        public void m9685a(cy cyVar, bd bdVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (!bdVar.m8677i()) {
                        throw new cz("Required field 'start_time' was not found in serialized data! Struct: " + toString());
                    } else if (!bdVar.m8680l()) {
                        throw new cz("Required field 'end_time' was not found in serialized data! Struct: " + toString());
                    } else if (bdVar.m8683o()) {
                        bdVar.m8648C();
                        return;
                    } else {
                        throw new cz("Required field 'duration' was not found in serialized data! Struct: " + toString());
                    }
                }
                cu p;
                int i;
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bdVar.f5787a = cyVar.mo1983z();
                        bdVar.m8658a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bdVar.f5788b = cyVar.mo1981x();
                        bdVar.m8664b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bdVar.f5789c = cyVar.mo1981x();
                        bdVar.m8667c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bdVar.f5790d = cyVar.mo1981x();
                        bdVar.m8669d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        p = cyVar.mo1973p();
                        bdVar.f5791e = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            ay ayVar = new ay();
                            ayVar.mo1921a(cyVar);
                            bdVar.f5791e.add(ayVar);
                        }
                        cyVar.mo1974q();
                        bdVar.m8670e(true);
                        break;
                    case (short) 6:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        p = cyVar.mo1973p();
                        bdVar.f5792f = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            aw awVar = new aw();
                            awVar.mo1921a(cyVar);
                            bdVar.f5792f.add(awVar);
                        }
                        cyVar.mo1974q();
                        bdVar.m8673f(true);
                        break;
                    case (short) 7:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bdVar.f5793g = new be();
                        bdVar.f5793g.mo1921a(cyVar);
                        bdVar.m8675g(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9687b(cy cyVar, bd bdVar) throws cf {
            bdVar.m8648C();
            cyVar.mo1956a(bd.f5775i);
            if (bdVar.f5787a != null) {
                cyVar.mo1951a(bd.f5776j);
                cyVar.mo1949a(bdVar.f5787a);
                cyVar.mo1960c();
            }
            cyVar.mo1951a(bd.f5777k);
            cyVar.mo1948a(bdVar.f5788b);
            cyVar.mo1960c();
            cyVar.mo1951a(bd.f5778l);
            cyVar.mo1948a(bdVar.f5789c);
            cyVar.mo1960c();
            cyVar.mo1951a(bd.f5779m);
            cyVar.mo1948a(bdVar.f5790d);
            cyVar.mo1960c();
            if (bdVar.f5791e != null && bdVar.m8688t()) {
                cyVar.mo1951a(bd.f5780n);
                cyVar.mo1952a(new cu((byte) 12, bdVar.f5791e.size()));
                for (ay b : bdVar.f5791e) {
                    b.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            if (bdVar.f5792f != null && bdVar.m8693y()) {
                cyVar.mo1951a(bd.f5781o);
                cyVar.mo1952a(new cu((byte) 12, bdVar.f5792f.size()));
                for (aw b2 : bdVar.f5792f) {
                    b2.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            if (bdVar.f5793g != null && bdVar.m8647B()) {
                cyVar.mo1951a(bd.f5782p);
                bdVar.f5793g.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Session */
    /* renamed from: u.aly.bd$b */
    private static class C1389b implements dh {
        private C1389b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9689a();
        }

        /* renamed from: a */
        public C1388a m9689a() {
            return new C1388a();
        }
    }

    /* compiled from: Session */
    /* renamed from: u.aly.bd$c */
    private static class C1390c extends dj<bd> {
        private C1390c() {
        }

        /* renamed from: a */
        public void m9691a(cy cyVar, bd bdVar) throws cf {
            cyVar = (de) cyVar;
            cyVar.mo1949a(bdVar.f5787a);
            cyVar.mo1948a(bdVar.f5788b);
            cyVar.mo1948a(bdVar.f5789c);
            cyVar.mo1948a(bdVar.f5790d);
            BitSet bitSet = new BitSet();
            if (bdVar.m8688t()) {
                bitSet.set(0);
            }
            if (bdVar.m8693y()) {
                bitSet.set(1);
            }
            if (bdVar.m8647B()) {
                bitSet.set(2);
            }
            cyVar.m10341a(bitSet, 3);
            if (bdVar.m8688t()) {
                cyVar.mo1947a(bdVar.f5791e.size());
                for (ay b : bdVar.f5791e) {
                    b.mo1924b(cyVar);
                }
            }
            if (bdVar.m8693y()) {
                cyVar.mo1947a(bdVar.f5792f.size());
                for (aw b2 : bdVar.f5792f) {
                    b2.mo1924b(cyVar);
                }
            }
            if (bdVar.m8647B()) {
                bdVar.f5793g.mo1924b(cyVar);
            }
        }

        /* renamed from: b */
        public void m9693b(cy cyVar, bd bdVar) throws cf {
            int i = 0;
            cyVar = (de) cyVar;
            bdVar.f5787a = cyVar.mo1983z();
            bdVar.m8658a(true);
            bdVar.f5788b = cyVar.mo1981x();
            bdVar.m8664b(true);
            bdVar.f5789c = cyVar.mo1981x();
            bdVar.m8667c(true);
            bdVar.f5790d = cyVar.mo1981x();
            bdVar.m8669d(true);
            BitSet b = cyVar.mo1986b(3);
            if (b.get(0)) {
                cu cuVar = new cu((byte) 12, cyVar.mo1980w());
                bdVar.f5791e = new ArrayList(cuVar.f6488b);
                for (int i2 = 0; i2 < cuVar.f6488b; i2++) {
                    ay ayVar = new ay();
                    ayVar.mo1921a(cyVar);
                    bdVar.f5791e.add(ayVar);
                }
                bdVar.m8670e(true);
            }
            if (b.get(1)) {
                cu cuVar2 = new cu((byte) 12, cyVar.mo1980w());
                bdVar.f5792f = new ArrayList(cuVar2.f6488b);
                while (i < cuVar2.f6488b) {
                    aw awVar = new aw();
                    awVar.mo1921a(cyVar);
                    bdVar.f5792f.add(awVar);
                    i++;
                }
                bdVar.m8673f(true);
            }
            if (b.get(2)) {
                bdVar.f5793g = new be();
                bdVar.f5793g.mo1921a(cyVar);
                bdVar.m8675g(true);
            }
        }
    }

    /* compiled from: Session */
    /* renamed from: u.aly.bd$d */
    private static class C1391d implements dh {
        private C1391d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9695a();
        }

        /* renamed from: a */
        public C1390c m9695a() {
            return new C1390c();
        }
    }

    /* compiled from: Session */
    /* renamed from: u.aly.bd$e */
    public enum C1392e implements cg {
        ID((short) 1, "id"),
        START_TIME((short) 2, "start_time"),
        END_TIME((short) 3, "end_time"),
        DURATION((short) 4, "duration"),
        PAGES((short) 5, "pages"),
        LOCATIONS((short) 6, "locations"),
        TRAFFIC((short) 7, "traffic");
        
        /* renamed from: h */
        private static final Map<String, C1392e> f6242h = null;
        /* renamed from: i */
        private final short f6244i;
        /* renamed from: j */
        private final String f6245j;

        static {
            f6242h = new HashMap();
            Iterator it = EnumSet.allOf(C1392e.class).iterator();
            while (it.hasNext()) {
                C1392e c1392e = (C1392e) it.next();
                f6242h.put(c1392e.mo1932b(), c1392e);
            }
        }

        /* renamed from: a */
        public static C1392e m9697a(int i) {
            switch (i) {
                case 1:
                    return ID;
                case 2:
                    return START_TIME;
                case 3:
                    return END_TIME;
                case 4:
                    return DURATION;
                case 5:
                    return PAGES;
                case 6:
                    return LOCATIONS;
                case 7:
                    return TRAFFIC;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1392e m9699b(int i) {
            C1392e a = C1392e.m9697a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1392e m9698a(String str) {
            return (C1392e) f6242h.get(str);
        }

        private C1392e(short s, String str) {
            this.f6244i = s;
            this.f6245j = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6244i;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6245j;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8649a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8650a();
    }

    static {
        f5783q.put(di.class, new C1389b());
        f5783q.put(dj.class, new C1391d());
        Map enumMap = new EnumMap(C1392e.class);
        enumMap.put(C1392e.ID, new cl("id", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1392e.START_TIME, new cl("start_time", (byte) 1, new cm((byte) 10)));
        enumMap.put(C1392e.END_TIME, new cl("end_time", (byte) 1, new cm((byte) 10)));
        enumMap.put(C1392e.DURATION, new cl("duration", (byte) 1, new cm((byte) 10)));
        enumMap.put(C1392e.PAGES, new cl("pages", (byte) 2, new cn(df.f6529m, new cq((byte) 12, ay.class))));
        enumMap.put(C1392e.LOCATIONS, new cl("locations", (byte) 2, new cn(df.f6529m, new cq((byte) 12, aw.class))));
        enumMap.put(C1392e.TRAFFIC, new cl("traffic", (byte) 2, new cq((byte) 12, be.class)));
        f5774h = Collections.unmodifiableMap(enumMap);
        cl.m10164a(bd.class, f5774h);
    }

    public bd() {
        this.f5794u = (byte) 0;
        this.f5795v = new C1392e[]{C1392e.PAGES, C1392e.LOCATIONS, C1392e.TRAFFIC};
    }

    public bd(String str, long j, long j2, long j3) {
        this();
        this.f5787a = str;
        this.f5788b = j;
        m8664b(true);
        this.f5789c = j2;
        m8667c(true);
        this.f5790d = j3;
        m8669d(true);
    }

    public bd(bd bdVar) {
        List arrayList;
        this.f5794u = (byte) 0;
        this.f5795v = new C1392e[]{C1392e.PAGES, C1392e.LOCATIONS, C1392e.TRAFFIC};
        this.f5794u = bdVar.f5794u;
        if (bdVar.m8671e()) {
            this.f5787a = bdVar.f5787a;
        }
        this.f5788b = bdVar.f5788b;
        this.f5789c = bdVar.f5789c;
        this.f5790d = bdVar.f5790d;
        if (bdVar.m8688t()) {
            arrayList = new ArrayList();
            for (ay ayVar : bdVar.f5791e) {
                arrayList.add(new ay(ayVar));
            }
            this.f5791e = arrayList;
        }
        if (bdVar.m8693y()) {
            arrayList = new ArrayList();
            for (aw awVar : bdVar.f5792f) {
                arrayList.add(new aw(awVar));
            }
            this.f5792f = arrayList;
        }
        if (bdVar.m8647B()) {
            this.f5793g = new be(bdVar.f5793g);
        }
    }

    /* renamed from: a */
    public bd m8650a() {
        return new bd(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f5787a = null;
        m8664b(false);
        this.f5788b = 0;
        m8667c(false);
        this.f5789c = 0;
        m8669d(false);
        this.f5790d = 0;
        this.f5791e = null;
        this.f5792f = null;
        this.f5793g = null;
    }

    /* renamed from: c */
    public String m8665c() {
        return this.f5787a;
    }

    /* renamed from: a */
    public bd m8652a(String str) {
        this.f5787a = str;
        return this;
    }

    /* renamed from: d */
    public void m8668d() {
        this.f5787a = null;
    }

    /* renamed from: e */
    public boolean m8671e() {
        return this.f5787a != null;
    }

    /* renamed from: a */
    public void m8658a(boolean z) {
        if (!z) {
            this.f5787a = null;
        }
    }

    /* renamed from: f */
    public long m8672f() {
        return this.f5788b;
    }

    /* renamed from: a */
    public bd m8651a(long j) {
        this.f5788b = j;
        m8664b(true);
        return this;
    }

    /* renamed from: h */
    public void m8676h() {
        this.f5794u = bw.m10080b(this.f5794u, 0);
    }

    /* renamed from: i */
    public boolean m8677i() {
        return bw.m10076a(this.f5794u, 0);
    }

    /* renamed from: b */
    public void m8664b(boolean z) {
        this.f5794u = bw.m10068a(this.f5794u, 0, z);
    }

    /* renamed from: j */
    public long m8678j() {
        return this.f5789c;
    }

    /* renamed from: b */
    public bd m8659b(long j) {
        this.f5789c = j;
        m8667c(true);
        return this;
    }

    /* renamed from: k */
    public void m8679k() {
        this.f5794u = bw.m10080b(this.f5794u, 1);
    }

    /* renamed from: l */
    public boolean m8680l() {
        return bw.m10076a(this.f5794u, 1);
    }

    /* renamed from: c */
    public void m8667c(boolean z) {
        this.f5794u = bw.m10068a(this.f5794u, 1, z);
    }

    /* renamed from: m */
    public long m8681m() {
        return this.f5790d;
    }

    /* renamed from: c */
    public bd m8666c(long j) {
        this.f5790d = j;
        m8669d(true);
        return this;
    }

    /* renamed from: n */
    public void m8682n() {
        this.f5794u = bw.m10080b(this.f5794u, 2);
    }

    /* renamed from: o */
    public boolean m8683o() {
        return bw.m10076a(this.f5794u, 2);
    }

    /* renamed from: d */
    public void m8669d(boolean z) {
        this.f5794u = bw.m10068a(this.f5794u, 2, z);
    }

    /* renamed from: p */
    public int m8684p() {
        return this.f5791e == null ? 0 : this.f5791e.size();
    }

    /* renamed from: q */
    public Iterator<ay> m8685q() {
        return this.f5791e == null ? null : this.f5791e.iterator();
    }

    /* renamed from: a */
    public void m8656a(ay ayVar) {
        if (this.f5791e == null) {
            this.f5791e = new ArrayList();
        }
        this.f5791e.add(ayVar);
    }

    /* renamed from: r */
    public List<ay> m8686r() {
        return this.f5791e;
    }

    /* renamed from: a */
    public bd m8653a(List<ay> list) {
        this.f5791e = list;
        return this;
    }

    /* renamed from: s */
    public void m8687s() {
        this.f5791e = null;
    }

    /* renamed from: t */
    public boolean m8688t() {
        return this.f5791e != null;
    }

    /* renamed from: e */
    public void m8670e(boolean z) {
        if (!z) {
            this.f5791e = null;
        }
    }

    /* renamed from: u */
    public int m8689u() {
        return this.f5792f == null ? 0 : this.f5792f.size();
    }

    /* renamed from: v */
    public Iterator<aw> m8690v() {
        return this.f5792f == null ? null : this.f5792f.iterator();
    }

    /* renamed from: a */
    public void m8655a(aw awVar) {
        if (this.f5792f == null) {
            this.f5792f = new ArrayList();
        }
        this.f5792f.add(awVar);
    }

    /* renamed from: w */
    public List<aw> m8691w() {
        return this.f5792f;
    }

    /* renamed from: b */
    public bd m8660b(List<aw> list) {
        this.f5792f = list;
        return this;
    }

    /* renamed from: x */
    public void m8692x() {
        this.f5792f = null;
    }

    /* renamed from: y */
    public boolean m8693y() {
        return this.f5792f != null;
    }

    /* renamed from: f */
    public void m8673f(boolean z) {
        if (!z) {
            this.f5792f = null;
        }
    }

    /* renamed from: z */
    public be m8694z() {
        return this.f5793g;
    }

    /* renamed from: a */
    public bd m8654a(be beVar) {
        this.f5793g = beVar;
        return this;
    }

    /* renamed from: A */
    public void m8646A() {
        this.f5793g = null;
    }

    /* renamed from: B */
    public boolean m8647B() {
        return this.f5793g != null;
    }

    /* renamed from: g */
    public void m8675g(boolean z) {
        if (!z) {
            this.f5793g = null;
        }
    }

    /* renamed from: a */
    public C1392e m8649a(int i) {
        return C1392e.m9697a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5783q.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5783q.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Session(");
        stringBuilder.append("id:");
        if (this.f5787a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5787a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("start_time:");
        stringBuilder.append(this.f5788b);
        stringBuilder.append(", ");
        stringBuilder.append("end_time:");
        stringBuilder.append(this.f5789c);
        stringBuilder.append(", ");
        stringBuilder.append("duration:");
        stringBuilder.append(this.f5790d);
        if (m8688t()) {
            stringBuilder.append(", ");
            stringBuilder.append("pages:");
            if (this.f5791e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5791e);
            }
        }
        if (m8693y()) {
            stringBuilder.append(", ");
            stringBuilder.append("locations:");
            if (this.f5792f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5792f);
            }
        }
        if (m8647B()) {
            stringBuilder.append(", ");
            stringBuilder.append("traffic:");
            if (this.f5793g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5793g);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: C */
    public void m8648C() throws cf {
        if (this.f5787a == null) {
            throw new cz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5793g != null) {
            this.f5793g.m9741j();
        }
    }

    /* renamed from: a */
    private void m8645a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8644a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5794u = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
