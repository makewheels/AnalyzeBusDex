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

/* compiled from: Ekv */
/* renamed from: u.aly.al */
public class al implements Serializable, Cloneable, bz<al, C1305e> {
    /* renamed from: f */
    public static final Map<C1305e, cl> f5948f;
    /* renamed from: g */
    private static final dd f5949g = new dd("Ekv");
    /* renamed from: h */
    private static final ct f5950h = new ct("ts", (byte) 10, (short) 1);
    /* renamed from: i */
    private static final ct f5951i = new ct(C0110c.f289e, (byte) 11, (short) 2);
    /* renamed from: j */
    private static final ct f5952j = new ct("ckv", df.f6527k, (short) 3);
    /* renamed from: k */
    private static final ct f5953k = new ct("duration", (byte) 10, (short) 4);
    /* renamed from: l */
    private static final ct f5954l = new ct("acc", (byte) 8, (short) 5);
    /* renamed from: m */
    private static final Map<Class<? extends dg>, dh> f5955m = new HashMap();
    /* renamed from: n */
    private static final int f5956n = 0;
    /* renamed from: o */
    private static final int f5957o = 1;
    /* renamed from: p */
    private static final int f5958p = 2;
    /* renamed from: a */
    public long f5959a;
    /* renamed from: b */
    public String f5960b;
    /* renamed from: c */
    public Map<String, String> f5961c;
    /* renamed from: d */
    public long f5962d;
    /* renamed from: e */
    public int f5963e;
    /* renamed from: q */
    private byte f5964q;
    /* renamed from: r */
    private C1305e[] f5965r;

    /* compiled from: Ekv */
    /* renamed from: u.aly.al$a */
    private static class C1301a extends di<al> {
        private C1301a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m8983b(cyVar, (al) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m8981a(cyVar, (al) bzVar);
        }

        /* renamed from: a */
        public void m8981a(cy cyVar, al alVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (alVar.m9025e()) {
                        alVar.m9040t();
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
                        alVar.f5959a = cyVar.mo1981x();
                        alVar.m9013a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        alVar.f5960b = cyVar.mo1983z();
                        alVar.m9018b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != df.f6527k) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        cv n = cyVar.mo1971n();
                        alVar.f5961c = new HashMap(n.f6491c * 2);
                        for (int i = 0; i < n.f6491c; i++) {
                            alVar.f5961c.put(cyVar.mo1983z(), cyVar.mo1983z());
                        }
                        cyVar.mo1972o();
                        alVar.m9021c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        alVar.f5962d = cyVar.mo1981x();
                        alVar.m9023d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        alVar.f5963e = cyVar.mo1980w();
                        alVar.m9024e(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m8983b(cy cyVar, al alVar) throws cf {
            alVar.m9040t();
            cyVar.mo1956a(al.f5949g);
            cyVar.mo1951a(al.f5950h);
            cyVar.mo1948a(alVar.f5959a);
            cyVar.mo1960c();
            if (alVar.f5960b != null) {
                cyVar.mo1951a(al.f5951i);
                cyVar.mo1949a(alVar.f5960b);
                cyVar.mo1960c();
            }
            if (alVar.f5961c != null) {
                cyVar.mo1951a(al.f5952j);
                cyVar.mo1953a(new cv((byte) 11, (byte) 11, alVar.f5961c.size()));
                for (Entry entry : alVar.f5961c.entrySet()) {
                    cyVar.mo1949a((String) entry.getKey());
                    cyVar.mo1949a((String) entry.getValue());
                }
                cyVar.mo1962e();
                cyVar.mo1960c();
            }
            if (alVar.m9036p()) {
                cyVar.mo1951a(al.f5953k);
                cyVar.mo1948a(alVar.f5962d);
                cyVar.mo1960c();
            }
            if (alVar.m9039s()) {
                cyVar.mo1951a(al.f5954l);
                cyVar.mo1947a(alVar.f5963e);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Ekv */
    /* renamed from: u.aly.al$b */
    private static class C1302b implements dh {
        private C1302b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8985a();
        }

        /* renamed from: a */
        public C1301a m8985a() {
            return new C1301a();
        }
    }

    /* compiled from: Ekv */
    /* renamed from: u.aly.al$c */
    private static class C1303c extends dj<al> {
        private C1303c() {
        }

        /* renamed from: a */
        public void m8987a(cy cyVar, al alVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1948a(alVar.f5959a);
            deVar.mo1949a(alVar.f5960b);
            deVar.mo1947a(alVar.f5961c.size());
            for (Entry entry : alVar.f5961c.entrySet()) {
                deVar.mo1949a((String) entry.getKey());
                deVar.mo1949a((String) entry.getValue());
            }
            BitSet bitSet = new BitSet();
            if (alVar.m9036p()) {
                bitSet.set(0);
            }
            if (alVar.m9039s()) {
                bitSet.set(1);
            }
            deVar.m10341a(bitSet, 2);
            if (alVar.m9036p()) {
                deVar.mo1948a(alVar.f5962d);
            }
            if (alVar.m9039s()) {
                deVar.mo1947a(alVar.f5963e);
            }
        }

        /* renamed from: b */
        public void m8989b(cy cyVar, al alVar) throws cf {
            de deVar = (de) cyVar;
            alVar.f5959a = deVar.mo1981x();
            alVar.m9013a(true);
            alVar.f5960b = deVar.mo1983z();
            alVar.m9018b(true);
            cv cvVar = new cv((byte) 11, (byte) 11, deVar.mo1980w());
            alVar.f5961c = new HashMap(cvVar.f6491c * 2);
            for (int i = 0; i < cvVar.f6491c; i++) {
                alVar.f5961c.put(deVar.mo1983z(), deVar.mo1983z());
            }
            alVar.m9021c(true);
            BitSet b = deVar.mo1986b(2);
            if (b.get(0)) {
                alVar.f5962d = deVar.mo1981x();
                alVar.m9023d(true);
            }
            if (b.get(1)) {
                alVar.f5963e = deVar.mo1980w();
                alVar.m9024e(true);
            }
        }
    }

    /* compiled from: Ekv */
    /* renamed from: u.aly.al$d */
    private static class C1304d implements dh {
        private C1304d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8991a();
        }

        /* renamed from: a */
        public C1303c m8991a() {
            return new C1303c();
        }
    }

    /* compiled from: Ekv */
    /* renamed from: u.aly.al$e */
    public enum C1305e implements cg {
        TS((short) 1, "ts"),
        NAME((short) 2, C0110c.f289e),
        CKV((short) 3, "ckv"),
        DURATION((short) 4, "duration"),
        ACC((short) 5, "acc");
        
        /* renamed from: f */
        private static final Map<String, C1305e> f5944f = null;
        /* renamed from: g */
        private final short f5946g;
        /* renamed from: h */
        private final String f5947h;

        static {
            f5944f = new HashMap();
            Iterator it = EnumSet.allOf(C1305e.class).iterator();
            while (it.hasNext()) {
                C1305e c1305e = (C1305e) it.next();
                f5944f.put(c1305e.mo1932b(), c1305e);
            }
        }

        /* renamed from: a */
        public static C1305e m8993a(int i) {
            switch (i) {
                case 1:
                    return TS;
                case 2:
                    return NAME;
                case 3:
                    return CKV;
                case 4:
                    return DURATION;
                case 5:
                    return ACC;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1305e m8995b(int i) {
            C1305e a = C1305e.m8993a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1305e m8994a(String str) {
            return (C1305e) f5944f.get(str);
        }

        private C1305e(short s, String str) {
            this.f5946g = s;
            this.f5947h = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5946g;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5947h;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9020c(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9006a();
    }

    static {
        f5955m.put(di.class, new C1302b());
        f5955m.put(dj.class, new C1304d());
        Map enumMap = new EnumMap(C1305e.class);
        enumMap.put(C1305e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        enumMap.put(C1305e.NAME, new cl(C0110c.f289e, (byte) 1, new cm((byte) 11)));
        enumMap.put(C1305e.CKV, new cl("ckv", (byte) 1, new co(df.f6527k, new cm((byte) 11), new cm((byte) 11))));
        enumMap.put(C1305e.DURATION, new cl("duration", (byte) 2, new cm((byte) 10)));
        enumMap.put(C1305e.ACC, new cl("acc", (byte) 2, new cm((byte) 8)));
        f5948f = Collections.unmodifiableMap(enumMap);
        cl.m10164a(al.class, f5948f);
    }

    public al() {
        this.f5964q = (byte) 0;
        this.f5965r = new C1305e[]{C1305e.DURATION, C1305e.ACC};
    }

    public al(long j, String str, Map<String, String> map) {
        this();
        this.f5959a = j;
        m9013a(true);
        this.f5960b = str;
        this.f5961c = map;
    }

    public al(al alVar) {
        this.f5964q = (byte) 0;
        this.f5965r = new C1305e[]{C1305e.DURATION, C1305e.ACC};
        this.f5964q = alVar.f5964q;
        this.f5959a = alVar.f5959a;
        if (alVar.m9029i()) {
            this.f5960b = alVar.f5960b;
        }
        if (alVar.m9033m()) {
            Map hashMap = new HashMap();
            for (Entry entry : alVar.f5961c.entrySet()) {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
            this.f5961c = hashMap;
        }
        this.f5962d = alVar.f5962d;
        this.f5963e = alVar.f5963e;
    }

    /* renamed from: a */
    public al m9006a() {
        return new al(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m9013a(false);
        this.f5959a = 0;
        this.f5960b = null;
        this.f5961c = null;
        m9023d(false);
        this.f5962d = 0;
        m9024e(false);
        this.f5963e = 0;
    }

    /* renamed from: c */
    public long m9019c() {
        return this.f5959a;
    }

    /* renamed from: a */
    public al m9008a(long j) {
        this.f5959a = j;
        m9013a(true);
        return this;
    }

    /* renamed from: d */
    public void m9022d() {
        this.f5964q = bw.m10080b(this.f5964q, 0);
    }

    /* renamed from: e */
    public boolean m9025e() {
        return bw.m10076a(this.f5964q, 0);
    }

    /* renamed from: a */
    public void m9013a(boolean z) {
        this.f5964q = bw.m10068a(this.f5964q, 0, z);
    }

    /* renamed from: f */
    public String m9026f() {
        return this.f5960b;
    }

    /* renamed from: a */
    public al m9009a(String str) {
        this.f5960b = str;
        return this;
    }

    /* renamed from: h */
    public void m9028h() {
        this.f5960b = null;
    }

    /* renamed from: i */
    public boolean m9029i() {
        return this.f5960b != null;
    }

    /* renamed from: b */
    public void m9018b(boolean z) {
        if (!z) {
            this.f5960b = null;
        }
    }

    /* renamed from: j */
    public int m9030j() {
        return this.f5961c == null ? 0 : this.f5961c.size();
    }

    /* renamed from: a */
    public void m9011a(String str, String str2) {
        if (this.f5961c == null) {
            this.f5961c = new HashMap();
        }
        this.f5961c.put(str, str2);
    }

    /* renamed from: k */
    public Map<String, String> m9031k() {
        return this.f5961c;
    }

    /* renamed from: a */
    public al m9010a(Map<String, String> map) {
        this.f5961c = map;
        return this;
    }

    /* renamed from: l */
    public void m9032l() {
        this.f5961c = null;
    }

    /* renamed from: m */
    public boolean m9033m() {
        return this.f5961c != null;
    }

    /* renamed from: c */
    public void m9021c(boolean z) {
        if (!z) {
            this.f5961c = null;
        }
    }

    /* renamed from: n */
    public long m9034n() {
        return this.f5962d;
    }

    /* renamed from: b */
    public al m9014b(long j) {
        this.f5962d = j;
        m9023d(true);
        return this;
    }

    /* renamed from: o */
    public void m9035o() {
        this.f5964q = bw.m10080b(this.f5964q, 1);
    }

    /* renamed from: p */
    public boolean m9036p() {
        return bw.m10076a(this.f5964q, 1);
    }

    /* renamed from: d */
    public void m9023d(boolean z) {
        this.f5964q = bw.m10068a(this.f5964q, 1, z);
    }

    /* renamed from: q */
    public int m9037q() {
        return this.f5963e;
    }

    /* renamed from: a */
    public al m9007a(int i) {
        this.f5963e = i;
        m9024e(true);
        return this;
    }

    /* renamed from: r */
    public void m9038r() {
        this.f5964q = bw.m10080b(this.f5964q, 2);
    }

    /* renamed from: s */
    public boolean m9039s() {
        return bw.m10076a(this.f5964q, 2);
    }

    /* renamed from: e */
    public void m9024e(boolean z) {
        this.f5964q = bw.m10068a(this.f5964q, 2, z);
    }

    /* renamed from: c */
    public C1305e m9020c(int i) {
        return C1305e.m8993a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5955m.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5955m.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Ekv(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f5959a);
        stringBuilder.append(", ");
        stringBuilder.append("name:");
        if (this.f5960b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5960b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ckv:");
        if (this.f5961c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5961c);
        }
        if (m9036p()) {
            stringBuilder.append(", ");
            stringBuilder.append("duration:");
            stringBuilder.append(this.f5962d);
        }
        if (m9039s()) {
            stringBuilder.append(", ");
            stringBuilder.append("acc:");
            stringBuilder.append(this.f5963e);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: t */
    public void m9040t() throws cf {
        if (this.f5960b == null) {
            throw new cz("Required field 'name' was not present! Struct: " + toString());
        } else if (this.f5961c == null) {
            throw new cz("Required field 'ckv' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m8999a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8998a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5964q = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
