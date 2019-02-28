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

/* compiled from: Traffic */
/* renamed from: u.aly.be */
public class be implements Serializable, Cloneable, bz<be, C1398e> {
    /* renamed from: c */
    public static final Map<C1398e, cl> f6252c;
    /* renamed from: d */
    private static final dd f6253d = new dd("Traffic");
    /* renamed from: e */
    private static final ct f6254e = new ct("upload_traffic", (byte) 8, (short) 1);
    /* renamed from: f */
    private static final ct f6255f = new ct("download_traffic", (byte) 8, (short) 2);
    /* renamed from: g */
    private static final Map<Class<? extends dg>, dh> f6256g = new HashMap();
    /* renamed from: h */
    private static final int f6257h = 0;
    /* renamed from: i */
    private static final int f6258i = 1;
    /* renamed from: a */
    public int f6259a;
    /* renamed from: b */
    public int f6260b;
    /* renamed from: j */
    private byte f6261j;

    /* compiled from: Traffic */
    /* renamed from: u.aly.be$a */
    private static class C1394a extends di<be> {
        private C1394a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9704b(cyVar, (be) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9702a(cyVar, (be) bzVar);
        }

        /* renamed from: a */
        public void m9702a(cy cyVar, be beVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (!beVar.m9736e()) {
                        throw new cz("Required field 'upload_traffic' was not found in serialized data! Struct: " + toString());
                    } else if (beVar.m9740i()) {
                        beVar.m9741j();
                        return;
                    } else {
                        throw new cz("Required field 'download_traffic' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        beVar.f6259a = cyVar.mo1980w();
                        beVar.m9727a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        beVar.f6260b = cyVar.mo1980w();
                        beVar.m9731b(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9704b(cy cyVar, be beVar) throws cf {
            beVar.m9741j();
            cyVar.mo1956a(be.f6253d);
            cyVar.mo1951a(be.f6254e);
            cyVar.mo1947a(beVar.f6259a);
            cyVar.mo1960c();
            cyVar.mo1951a(be.f6255f);
            cyVar.mo1947a(beVar.f6260b);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Traffic */
    /* renamed from: u.aly.be$b */
    private static class C1395b implements dh {
        private C1395b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9706a();
        }

        /* renamed from: a */
        public C1394a m9706a() {
            return new C1394a();
        }
    }

    /* compiled from: Traffic */
    /* renamed from: u.aly.be$c */
    private static class C1396c extends dj<be> {
        private C1396c() {
        }

        /* renamed from: a */
        public void m9708a(cy cyVar, be beVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1947a(beVar.f6259a);
            deVar.mo1947a(beVar.f6260b);
        }

        /* renamed from: b */
        public void m9710b(cy cyVar, be beVar) throws cf {
            de deVar = (de) cyVar;
            beVar.f6259a = deVar.mo1980w();
            beVar.m9727a(true);
            beVar.f6260b = deVar.mo1980w();
            beVar.m9731b(true);
        }
    }

    /* compiled from: Traffic */
    /* renamed from: u.aly.be$d */
    private static class C1397d implements dh {
        private C1397d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9712a();
        }

        /* renamed from: a */
        public C1396c m9712a() {
            return new C1396c();
        }
    }

    /* compiled from: Traffic */
    /* renamed from: u.aly.be$e */
    public enum C1398e implements cg {
        UPLOAD_TRAFFIC((short) 1, "upload_traffic"),
        DOWNLOAD_TRAFFIC((short) 2, "download_traffic");
        
        /* renamed from: c */
        private static final Map<String, C1398e> f6248c = null;
        /* renamed from: d */
        private final short f6250d;
        /* renamed from: e */
        private final String f6251e;

        static {
            f6248c = new HashMap();
            Iterator it = EnumSet.allOf(C1398e.class).iterator();
            while (it.hasNext()) {
                C1398e c1398e = (C1398e) it.next();
                f6248c.put(c1398e.mo1932b(), c1398e);
            }
        }

        /* renamed from: a */
        public static C1398e m9714a(int i) {
            switch (i) {
                case 1:
                    return UPLOAD_TRAFFIC;
                case 2:
                    return DOWNLOAD_TRAFFIC;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1398e m9716b(int i) {
            C1398e a = C1398e.m9714a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1398e m9715a(String str) {
            return (C1398e) f6248c.get(str);
        }

        private C1398e(short s, String str) {
            this.f6250d = s;
            this.f6251e = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6250d;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6251e;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9734d(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9724a();
    }

    static {
        f6256g.put(di.class, new C1395b());
        f6256g.put(dj.class, new C1397d());
        Map enumMap = new EnumMap(C1398e.class);
        enumMap.put(C1398e.UPLOAD_TRAFFIC, new cl("upload_traffic", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1398e.DOWNLOAD_TRAFFIC, new cl("download_traffic", (byte) 1, new cm((byte) 8)));
        f6252c = Collections.unmodifiableMap(enumMap);
        cl.m10164a(be.class, f6252c);
    }

    public be() {
        this.f6261j = (byte) 0;
    }

    public be(int i, int i2) {
        this();
        this.f6259a = i;
        m9727a(true);
        this.f6260b = i2;
        m9731b(true);
    }

    public be(be beVar) {
        this.f6261j = (byte) 0;
        this.f6261j = beVar.f6261j;
        this.f6259a = beVar.f6259a;
        this.f6260b = beVar.f6260b;
    }

    /* renamed from: a */
    public be m9724a() {
        return new be(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m9727a(false);
        this.f6259a = 0;
        m9731b(false);
        this.f6260b = 0;
    }

    /* renamed from: c */
    public int m9732c() {
        return this.f6259a;
    }

    /* renamed from: a */
    public be m9725a(int i) {
        this.f6259a = i;
        m9727a(true);
        return this;
    }

    /* renamed from: d */
    public void m9735d() {
        this.f6261j = bw.m10080b(this.f6261j, 0);
    }

    /* renamed from: e */
    public boolean m9736e() {
        return bw.m10076a(this.f6261j, 0);
    }

    /* renamed from: a */
    public void m9727a(boolean z) {
        this.f6261j = bw.m10068a(this.f6261j, 0, z);
    }

    /* renamed from: f */
    public int m9737f() {
        return this.f6260b;
    }

    /* renamed from: c */
    public be m9733c(int i) {
        this.f6260b = i;
        m9731b(true);
        return this;
    }

    /* renamed from: h */
    public void m9739h() {
        this.f6261j = bw.m10080b(this.f6261j, 1);
    }

    /* renamed from: i */
    public boolean m9740i() {
        return bw.m10076a(this.f6261j, 1);
    }

    /* renamed from: b */
    public void m9731b(boolean z) {
        this.f6261j = bw.m10068a(this.f6261j, 1, z);
    }

    /* renamed from: d */
    public C1398e m9734d(int i) {
        return C1398e.m9714a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6256g.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6256g.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Traffic(");
        stringBuilder.append("upload_traffic:");
        stringBuilder.append(this.f6259a);
        stringBuilder.append(", ");
        stringBuilder.append("download_traffic:");
        stringBuilder.append(this.f6260b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: j */
    public void m9741j() throws cf {
    }

    /* renamed from: a */
    private void m9720a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9719a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6261j = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
