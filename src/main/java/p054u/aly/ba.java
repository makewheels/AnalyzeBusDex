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

/* compiled from: Resolution */
/* renamed from: u.aly.ba */
public class ba implements Serializable, Cloneable, bz<ba, C1380e> {
    /* renamed from: c */
    public static final Map<C1380e, cl> f6200c;
    /* renamed from: d */
    private static final dd f6201d = new dd("Resolution");
    /* renamed from: e */
    private static final ct f6202e = new ct("height", (byte) 8, (short) 1);
    /* renamed from: f */
    private static final ct f6203f = new ct("width", (byte) 8, (short) 2);
    /* renamed from: g */
    private static final Map<Class<? extends dg>, dh> f6204g = new HashMap();
    /* renamed from: h */
    private static final int f6205h = 0;
    /* renamed from: i */
    private static final int f6206i = 1;
    /* renamed from: a */
    public int f6207a;
    /* renamed from: b */
    public int f6208b;
    /* renamed from: j */
    private byte f6209j;

    /* compiled from: Resolution */
    /* renamed from: u.aly.ba$a */
    private static class C1376a extends di<ba> {
        private C1376a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9599b(cyVar, (ba) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9597a(cyVar, (ba) bzVar);
        }

        /* renamed from: a */
        public void m9597a(cy cyVar, ba baVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (!baVar.m9631e()) {
                        throw new cz("Required field 'height' was not found in serialized data! Struct: " + toString());
                    } else if (baVar.m9635i()) {
                        baVar.m9636j();
                        return;
                    } else {
                        throw new cz("Required field 'width' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        baVar.f6207a = cyVar.mo1980w();
                        baVar.m9622a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        baVar.f6208b = cyVar.mo1980w();
                        baVar.m9626b(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9599b(cy cyVar, ba baVar) throws cf {
            baVar.m9636j();
            cyVar.mo1956a(ba.f6201d);
            cyVar.mo1951a(ba.f6202e);
            cyVar.mo1947a(baVar.f6207a);
            cyVar.mo1960c();
            cyVar.mo1951a(ba.f6203f);
            cyVar.mo1947a(baVar.f6208b);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Resolution */
    /* renamed from: u.aly.ba$b */
    private static class C1377b implements dh {
        private C1377b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9601a();
        }

        /* renamed from: a */
        public C1376a m9601a() {
            return new C1376a();
        }
    }

    /* compiled from: Resolution */
    /* renamed from: u.aly.ba$c */
    private static class C1378c extends dj<ba> {
        private C1378c() {
        }

        /* renamed from: a */
        public void m9603a(cy cyVar, ba baVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1947a(baVar.f6207a);
            deVar.mo1947a(baVar.f6208b);
        }

        /* renamed from: b */
        public void m9605b(cy cyVar, ba baVar) throws cf {
            de deVar = (de) cyVar;
            baVar.f6207a = deVar.mo1980w();
            baVar.m9622a(true);
            baVar.f6208b = deVar.mo1980w();
            baVar.m9626b(true);
        }
    }

    /* compiled from: Resolution */
    /* renamed from: u.aly.ba$d */
    private static class C1379d implements dh {
        private C1379d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9607a();
        }

        /* renamed from: a */
        public C1378c m9607a() {
            return new C1378c();
        }
    }

    /* compiled from: Resolution */
    /* renamed from: u.aly.ba$e */
    public enum C1380e implements cg {
        HEIGHT((short) 1, "height"),
        WIDTH((short) 2, "width");
        
        /* renamed from: c */
        private static final Map<String, C1380e> f6196c = null;
        /* renamed from: d */
        private final short f6198d;
        /* renamed from: e */
        private final String f6199e;

        static {
            f6196c = new HashMap();
            Iterator it = EnumSet.allOf(C1380e.class).iterator();
            while (it.hasNext()) {
                C1380e c1380e = (C1380e) it.next();
                f6196c.put(c1380e.mo1932b(), c1380e);
            }
        }

        /* renamed from: a */
        public static C1380e m9609a(int i) {
            switch (i) {
                case 1:
                    return HEIGHT;
                case 2:
                    return WIDTH;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1380e m9611b(int i) {
            C1380e a = C1380e.m9609a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1380e m9610a(String str) {
            return (C1380e) f6196c.get(str);
        }

        private C1380e(short s, String str) {
            this.f6198d = s;
            this.f6199e = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6198d;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6199e;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9629d(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9619a();
    }

    static {
        f6204g.put(di.class, new C1377b());
        f6204g.put(dj.class, new C1379d());
        Map enumMap = new EnumMap(C1380e.class);
        enumMap.put(C1380e.HEIGHT, new cl("height", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1380e.WIDTH, new cl("width", (byte) 1, new cm((byte) 8)));
        f6200c = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ba.class, f6200c);
    }

    public ba() {
        this.f6209j = (byte) 0;
    }

    public ba(int i, int i2) {
        this();
        this.f6207a = i;
        m9622a(true);
        this.f6208b = i2;
        m9626b(true);
    }

    public ba(ba baVar) {
        this.f6209j = (byte) 0;
        this.f6209j = baVar.f6209j;
        this.f6207a = baVar.f6207a;
        this.f6208b = baVar.f6208b;
    }

    /* renamed from: a */
    public ba m9619a() {
        return new ba(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m9622a(false);
        this.f6207a = 0;
        m9626b(false);
        this.f6208b = 0;
    }

    /* renamed from: c */
    public int m9627c() {
        return this.f6207a;
    }

    /* renamed from: a */
    public ba m9620a(int i) {
        this.f6207a = i;
        m9622a(true);
        return this;
    }

    /* renamed from: d */
    public void m9630d() {
        this.f6209j = bw.m10080b(this.f6209j, 0);
    }

    /* renamed from: e */
    public boolean m9631e() {
        return bw.m10076a(this.f6209j, 0);
    }

    /* renamed from: a */
    public void m9622a(boolean z) {
        this.f6209j = bw.m10068a(this.f6209j, 0, z);
    }

    /* renamed from: f */
    public int m9632f() {
        return this.f6208b;
    }

    /* renamed from: c */
    public ba m9628c(int i) {
        this.f6208b = i;
        m9626b(true);
        return this;
    }

    /* renamed from: h */
    public void m9634h() {
        this.f6209j = bw.m10080b(this.f6209j, 1);
    }

    /* renamed from: i */
    public boolean m9635i() {
        return bw.m10076a(this.f6209j, 1);
    }

    /* renamed from: b */
    public void m9626b(boolean z) {
        this.f6209j = bw.m10068a(this.f6209j, 1, z);
    }

    /* renamed from: d */
    public C1380e m9629d(int i) {
        return C1380e.m9609a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6204g.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6204g.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Resolution(");
        stringBuilder.append("height:");
        stringBuilder.append(this.f6207a);
        stringBuilder.append(", ");
        stringBuilder.append("width:");
        stringBuilder.append(this.f6208b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: j */
    public void m9636j() throws cf {
    }

    /* renamed from: a */
    private void m9615a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9614a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6209j = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
