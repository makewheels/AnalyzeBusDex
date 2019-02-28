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

/* compiled from: IdSnapshot */
/* renamed from: u.aly.ar */
public class ar implements Serializable, Cloneable, bz<ar, C1329e> {
    /* renamed from: d */
    public static final Map<C1329e, cl> f6020d;
    /* renamed from: e */
    private static final dd f6021e = new dd("IdSnapshot");
    /* renamed from: f */
    private static final ct f6022f = new ct("identity", (byte) 11, (short) 1);
    /* renamed from: g */
    private static final ct f6023g = new ct("ts", (byte) 10, (short) 2);
    /* renamed from: h */
    private static final ct f6024h = new ct("version", (byte) 8, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f6025i = new HashMap();
    /* renamed from: j */
    private static final int f6026j = 0;
    /* renamed from: k */
    private static final int f6027k = 1;
    /* renamed from: a */
    public String f6028a;
    /* renamed from: b */
    public long f6029b;
    /* renamed from: c */
    public int f6030c;
    /* renamed from: l */
    private byte f6031l;

    /* compiled from: IdSnapshot */
    /* renamed from: u.aly.ar$a */
    private static class C1325a extends di<ar> {
        private C1325a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9133b(cyVar, (ar) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9131a(cyVar, (ar) bzVar);
        }

        /* renamed from: a */
        public void m9131a(cy cyVar, ar arVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (!arVar.m9172i()) {
                        throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    } else if (arVar.m9175l()) {
                        arVar.m9176m();
                        return;
                    } else {
                        throw new cz("Required field 'version' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        arVar.f6028a = cyVar.mo1983z();
                        arVar.m9159a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        arVar.f6029b = cyVar.mo1981x();
                        arVar.m9163b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        arVar.f6030c = cyVar.mo1980w();
                        arVar.m9166c(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9133b(cy cyVar, ar arVar) throws cf {
            arVar.m9176m();
            cyVar.mo1956a(ar.f6021e);
            if (arVar.f6028a != null) {
                cyVar.mo1951a(ar.f6022f);
                cyVar.mo1949a(arVar.f6028a);
                cyVar.mo1960c();
            }
            cyVar.mo1951a(ar.f6023g);
            cyVar.mo1948a(arVar.f6029b);
            cyVar.mo1960c();
            cyVar.mo1951a(ar.f6024h);
            cyVar.mo1947a(arVar.f6030c);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: IdSnapshot */
    /* renamed from: u.aly.ar$b */
    private static class C1326b implements dh {
        private C1326b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9135a();
        }

        /* renamed from: a */
        public C1325a m9135a() {
            return new C1325a();
        }
    }

    /* compiled from: IdSnapshot */
    /* renamed from: u.aly.ar$c */
    private static class C1327c extends dj<ar> {
        private C1327c() {
        }

        /* renamed from: a */
        public void m9137a(cy cyVar, ar arVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1949a(arVar.f6028a);
            deVar.mo1948a(arVar.f6029b);
            deVar.mo1947a(arVar.f6030c);
        }

        /* renamed from: b */
        public void m9139b(cy cyVar, ar arVar) throws cf {
            de deVar = (de) cyVar;
            arVar.f6028a = deVar.mo1983z();
            arVar.m9159a(true);
            arVar.f6029b = deVar.mo1981x();
            arVar.m9163b(true);
            arVar.f6030c = deVar.mo1980w();
            arVar.m9166c(true);
        }
    }

    /* compiled from: IdSnapshot */
    /* renamed from: u.aly.ar$d */
    private static class C1328d implements dh {
        private C1328d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9141a();
        }

        /* renamed from: a */
        public C1327c m9141a() {
            return new C1327c();
        }
    }

    /* compiled from: IdSnapshot */
    /* renamed from: u.aly.ar$e */
    public enum C1329e implements cg {
        IDENTITY((short) 1, "identity"),
        TS((short) 2, "ts"),
        VERSION((short) 3, "version");
        
        /* renamed from: d */
        private static final Map<String, C1329e> f6016d = null;
        /* renamed from: e */
        private final short f6018e;
        /* renamed from: f */
        private final String f6019f;

        static {
            f6016d = new HashMap();
            Iterator it = EnumSet.allOf(C1329e.class).iterator();
            while (it.hasNext()) {
                C1329e c1329e = (C1329e) it.next();
                f6016d.put(c1329e.mo1932b(), c1329e);
            }
        }

        /* renamed from: a */
        public static C1329e m9143a(int i) {
            switch (i) {
                case 1:
                    return IDENTITY;
                case 2:
                    return TS;
                case 3:
                    return VERSION;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1329e m9145b(int i) {
            C1329e a = C1329e.m9143a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1329e m9144a(String str) {
            return (C1329e) f6016d.get(str);
        }

        private C1329e(short s, String str) {
            this.f6018e = s;
            this.f6019f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6018e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6019f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9165c(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9154a();
    }

    static {
        f6025i.put(di.class, new C1326b());
        f6025i.put(dj.class, new C1328d());
        Map enumMap = new EnumMap(C1329e.class);
        enumMap.put(C1329e.IDENTITY, new cl("identity", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1329e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        enumMap.put(C1329e.VERSION, new cl("version", (byte) 1, new cm((byte) 8)));
        f6020d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ar.class, f6020d);
    }

    public ar() {
        this.f6031l = (byte) 0;
    }

    public ar(String str, long j, int i) {
        this();
        this.f6028a = str;
        this.f6029b = j;
        m9163b(true);
        this.f6030c = i;
        m9166c(true);
    }

    public ar(ar arVar) {
        this.f6031l = (byte) 0;
        this.f6031l = arVar.f6031l;
        if (arVar.m9168e()) {
            this.f6028a = arVar.f6028a;
        }
        this.f6029b = arVar.f6029b;
        this.f6030c = arVar.f6030c;
    }

    /* renamed from: a */
    public ar m9154a() {
        return new ar(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6028a = null;
        m9163b(false);
        this.f6029b = 0;
        m9166c(false);
        this.f6030c = 0;
    }

    /* renamed from: c */
    public String m9164c() {
        return this.f6028a;
    }

    /* renamed from: a */
    public ar m9157a(String str) {
        this.f6028a = str;
        return this;
    }

    /* renamed from: d */
    public void m9167d() {
        this.f6028a = null;
    }

    /* renamed from: e */
    public boolean m9168e() {
        return this.f6028a != null;
    }

    /* renamed from: a */
    public void m9159a(boolean z) {
        if (!z) {
            this.f6028a = null;
        }
    }

    /* renamed from: f */
    public long m9169f() {
        return this.f6029b;
    }

    /* renamed from: a */
    public ar m9156a(long j) {
        this.f6029b = j;
        m9163b(true);
        return this;
    }

    /* renamed from: h */
    public void m9171h() {
        this.f6031l = bw.m10080b(this.f6031l, 0);
    }

    /* renamed from: i */
    public boolean m9172i() {
        return bw.m10076a(this.f6031l, 0);
    }

    /* renamed from: b */
    public void m9163b(boolean z) {
        this.f6031l = bw.m10068a(this.f6031l, 0, z);
    }

    /* renamed from: j */
    public int m9173j() {
        return this.f6030c;
    }

    /* renamed from: a */
    public ar m9155a(int i) {
        this.f6030c = i;
        m9166c(true);
        return this;
    }

    /* renamed from: k */
    public void m9174k() {
        this.f6031l = bw.m10080b(this.f6031l, 1);
    }

    /* renamed from: l */
    public boolean m9175l() {
        return bw.m10076a(this.f6031l, 1);
    }

    /* renamed from: c */
    public void m9166c(boolean z) {
        this.f6031l = bw.m10068a(this.f6031l, 1, z);
    }

    /* renamed from: c */
    public C1329e m9165c(int i) {
        return C1329e.m9143a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6025i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6025i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdSnapshot(");
        stringBuilder.append("identity:");
        if (this.f6028a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6028a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f6029b);
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.f6030c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: m */
    public void m9176m() throws cf {
        if (this.f6028a == null) {
            throw new cz("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m9149a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9148a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6031l = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
