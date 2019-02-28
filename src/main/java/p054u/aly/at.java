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
import java.util.Map.Entry;

/* compiled from: Imprint */
/* renamed from: u.aly.at */
public class at implements Serializable, Cloneable, bz<at, C1341e> {
    /* renamed from: d */
    public static final Map<C1341e, cl> f6056d;
    /* renamed from: e */
    private static final dd f6057e = new dd("Imprint");
    /* renamed from: f */
    private static final ct f6058f = new ct("property", df.f6527k, (short) 1);
    /* renamed from: g */
    private static final ct f6059g = new ct("version", (byte) 8, (short) 2);
    /* renamed from: h */
    private static final ct f6060h = new ct("checksum", (byte) 11, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f6061i = new HashMap();
    /* renamed from: j */
    private static final int f6062j = 0;
    /* renamed from: a */
    public Map<String, au> f6063a;
    /* renamed from: b */
    public int f6064b;
    /* renamed from: c */
    public String f6065c;
    /* renamed from: k */
    private byte f6066k;

    /* compiled from: Imprint */
    /* renamed from: u.aly.at$a */
    private static class C1337a extends di<at> {
        private C1337a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9230b(cyVar, (at) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9228a(cyVar, (at) bzVar);
        }

        /* renamed from: a */
        public void m9228a(cy cyVar, at atVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (atVar.m9271j()) {
                        atVar.m9275n();
                        return;
                    }
                    throw new cz("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != df.f6527k) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        cv n = cyVar.mo1971n();
                        atVar.f6063a = new HashMap(n.f6491c * 2);
                        for (int i = 0; i < n.f6491c; i++) {
                            String z = cyVar.mo1983z();
                            au auVar = new au();
                            auVar.mo1921a(cyVar);
                            atVar.f6063a.put(z, auVar);
                        }
                        cyVar.mo1972o();
                        atVar.m9257a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        atVar.f6064b = cyVar.mo1980w();
                        atVar.m9261b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        atVar.f6065c = cyVar.mo1983z();
                        atVar.m9264c(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9230b(cy cyVar, at atVar) throws cf {
            atVar.m9275n();
            cyVar.mo1956a(at.f6057e);
            if (atVar.f6063a != null) {
                cyVar.mo1951a(at.f6058f);
                cyVar.mo1953a(new cv((byte) 11, (byte) 12, atVar.f6063a.size()));
                for (Entry entry : atVar.f6063a.entrySet()) {
                    cyVar.mo1949a((String) entry.getKey());
                    ((au) entry.getValue()).mo1924b(cyVar);
                }
                cyVar.mo1962e();
                cyVar.mo1960c();
            }
            cyVar.mo1951a(at.f6059g);
            cyVar.mo1947a(atVar.f6064b);
            cyVar.mo1960c();
            if (atVar.f6065c != null) {
                cyVar.mo1951a(at.f6060h);
                cyVar.mo1949a(atVar.f6065c);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Imprint */
    /* renamed from: u.aly.at$b */
    private static class C1338b implements dh {
        private C1338b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9232a();
        }

        /* renamed from: a */
        public C1337a m9232a() {
            return new C1337a();
        }
    }

    /* compiled from: Imprint */
    /* renamed from: u.aly.at$c */
    private static class C1339c extends dj<at> {
        private C1339c() {
        }

        /* renamed from: a */
        public void m9234a(cy cyVar, at atVar) throws cf {
            cyVar = (de) cyVar;
            cyVar.mo1947a(atVar.f6063a.size());
            for (Entry entry : atVar.f6063a.entrySet()) {
                cyVar.mo1949a((String) entry.getKey());
                ((au) entry.getValue()).mo1924b(cyVar);
            }
            cyVar.mo1947a(atVar.f6064b);
            cyVar.mo1949a(atVar.f6065c);
        }

        /* renamed from: b */
        public void m9236b(cy cyVar, at atVar) throws cf {
            cyVar = (de) cyVar;
            cv cvVar = new cv((byte) 11, (byte) 12, cyVar.mo1980w());
            atVar.f6063a = new HashMap(cvVar.f6491c * 2);
            for (int i = 0; i < cvVar.f6491c; i++) {
                String z = cyVar.mo1983z();
                au auVar = new au();
                auVar.mo1921a(cyVar);
                atVar.f6063a.put(z, auVar);
            }
            atVar.m9257a(true);
            atVar.f6064b = cyVar.mo1980w();
            atVar.m9261b(true);
            atVar.f6065c = cyVar.mo1983z();
            atVar.m9264c(true);
        }
    }

    /* compiled from: Imprint */
    /* renamed from: u.aly.at$d */
    private static class C1340d implements dh {
        private C1340d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9238a();
        }

        /* renamed from: a */
        public C1339c m9238a() {
            return new C1339c();
        }
    }

    /* compiled from: Imprint */
    /* renamed from: u.aly.at$e */
    public enum C1341e implements cg {
        PROPERTY((short) 1, "property"),
        VERSION((short) 2, "version"),
        CHECKSUM((short) 3, "checksum");
        
        /* renamed from: d */
        private static final Map<String, C1341e> f6052d = null;
        /* renamed from: e */
        private final short f6054e;
        /* renamed from: f */
        private final String f6055f;

        static {
            f6052d = new HashMap();
            Iterator it = EnumSet.allOf(C1341e.class).iterator();
            while (it.hasNext()) {
                C1341e c1341e = (C1341e) it.next();
                f6052d.put(c1341e.mo1932b(), c1341e);
            }
        }

        /* renamed from: a */
        public static C1341e m9240a(int i) {
            switch (i) {
                case 1:
                    return PROPERTY;
                case 2:
                    return VERSION;
                case 3:
                    return CHECKSUM;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1341e m9242b(int i) {
            C1341e a = C1341e.m9240a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1341e m9241a(String str) {
            return (C1341e) f6052d.get(str);
        }

        private C1341e(short s, String str) {
            this.f6054e = s;
            this.f6055f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6054e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6055f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9263c(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9251a();
    }

    static {
        f6061i.put(di.class, new C1338b());
        f6061i.put(dj.class, new C1340d());
        Map enumMap = new EnumMap(C1341e.class);
        enumMap.put(C1341e.PROPERTY, new cl("property", (byte) 1, new co(df.f6527k, new cm((byte) 11), new cq((byte) 12, au.class))));
        enumMap.put(C1341e.VERSION, new cl("version", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1341e.CHECKSUM, new cl("checksum", (byte) 1, new cm((byte) 11)));
        f6056d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(at.class, f6056d);
    }

    public at() {
        this.f6066k = (byte) 0;
    }

    public at(Map<String, au> map, int i, String str) {
        this();
        this.f6063a = map;
        this.f6064b = i;
        m9261b(true);
        this.f6065c = str;
    }

    public at(at atVar) {
        this.f6066k = (byte) 0;
        this.f6066k = atVar.f6066k;
        if (atVar.m9267f()) {
            Map hashMap = new HashMap();
            for (Entry entry : atVar.f6063a.entrySet()) {
                hashMap.put((String) entry.getKey(), new au((au) entry.getValue()));
            }
            this.f6063a = hashMap;
        }
        this.f6064b = atVar.f6064b;
        if (atVar.m9274m()) {
            this.f6065c = atVar.f6065c;
        }
    }

    /* renamed from: a */
    public at m9251a() {
        return new at(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6063a = null;
        m9261b(false);
        this.f6064b = 0;
        this.f6065c = null;
    }

    /* renamed from: c */
    public int m9262c() {
        return this.f6063a == null ? 0 : this.f6063a.size();
    }

    /* renamed from: a */
    public void m9255a(String str, au auVar) {
        if (this.f6063a == null) {
            this.f6063a = new HashMap();
        }
        this.f6063a.put(str, auVar);
    }

    /* renamed from: d */
    public Map<String, au> m9265d() {
        return this.f6063a;
    }

    /* renamed from: a */
    public at m9254a(Map<String, au> map) {
        this.f6063a = map;
        return this;
    }

    /* renamed from: e */
    public void m9266e() {
        this.f6063a = null;
    }

    /* renamed from: f */
    public boolean m9267f() {
        return this.f6063a != null;
    }

    /* renamed from: a */
    public void m9257a(boolean z) {
        if (!z) {
            this.f6063a = null;
        }
    }

    /* renamed from: h */
    public int m9269h() {
        return this.f6064b;
    }

    /* renamed from: a */
    public at m9252a(int i) {
        this.f6064b = i;
        m9261b(true);
        return this;
    }

    /* renamed from: i */
    public void m9270i() {
        this.f6066k = bw.m10080b(this.f6066k, 0);
    }

    /* renamed from: j */
    public boolean m9271j() {
        return bw.m10076a(this.f6066k, 0);
    }

    /* renamed from: b */
    public void m9261b(boolean z) {
        this.f6066k = bw.m10068a(this.f6066k, 0, z);
    }

    /* renamed from: k */
    public String m9272k() {
        return this.f6065c;
    }

    /* renamed from: a */
    public at m9253a(String str) {
        this.f6065c = str;
        return this;
    }

    /* renamed from: l */
    public void m9273l() {
        this.f6065c = null;
    }

    /* renamed from: m */
    public boolean m9274m() {
        return this.f6065c != null;
    }

    /* renamed from: c */
    public void m9264c(boolean z) {
        if (!z) {
            this.f6065c = null;
        }
    }

    /* renamed from: c */
    public C1341e m9263c(int i) {
        return C1341e.m9240a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6061i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6061i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Imprint(");
        stringBuilder.append("property:");
        if (this.f6063a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6063a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.f6064b);
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.f6065c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6065c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: n */
    public void m9275n() throws cf {
        if (this.f6063a == null) {
            throw new cz("Required field 'property' was not present! Struct: " + toString());
        } else if (this.f6065c == null) {
            throw new cz("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m9246a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9245a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6066k = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
