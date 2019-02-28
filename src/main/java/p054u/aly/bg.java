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

/* compiled from: UserInfo */
/* renamed from: u.aly.bg */
public class bg implements Serializable, Cloneable, bz<bg, C1410e> {
    /* renamed from: e */
    public static final Map<C1410e, cl> f6305e;
    /* renamed from: f */
    private static final dd f6306f = new dd("UserInfo");
    /* renamed from: g */
    private static final ct f6307g = new ct("gender", (byte) 8, (short) 1);
    /* renamed from: h */
    private static final ct f6308h = new ct("age", (byte) 8, (short) 2);
    /* renamed from: i */
    private static final ct f6309i = new ct("id", (byte) 11, (short) 3);
    /* renamed from: j */
    private static final ct f6310j = new ct("source", (byte) 11, (short) 4);
    /* renamed from: k */
    private static final Map<Class<? extends dg>, dh> f6311k = new HashMap();
    /* renamed from: l */
    private static final int f6312l = 0;
    /* renamed from: a */
    public ap f6313a;
    /* renamed from: b */
    public int f6314b;
    /* renamed from: c */
    public String f6315c;
    /* renamed from: d */
    public String f6316d;
    /* renamed from: m */
    private byte f6317m;
    /* renamed from: n */
    private C1410e[] f6318n;

    /* compiled from: UserInfo */
    /* renamed from: u.aly.bg$a */
    private static class C1406a extends di<bg> {
        private C1406a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9832b(cyVar, (bg) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9830a(cyVar, (bg) bzVar);
        }

        /* renamed from: a */
        public void m9830a(cy cyVar, bg bgVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    bgVar.m9881p();
                    return;
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bgVar.f6313a = ap.m9077a(cyVar.mo1980w());
                        bgVar.m9859a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bgVar.f6314b = cyVar.mo1980w();
                        bgVar.m9864b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bgVar.f6315c = cyVar.mo1983z();
                        bgVar.m9867c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bgVar.f6316d = cyVar.mo1983z();
                        bgVar.m9869d(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9832b(cy cyVar, bg bgVar) throws cf {
            bgVar.m9881p();
            cyVar.mo1956a(bg.f6306f);
            if (bgVar.f6313a != null && bgVar.m9870e()) {
                cyVar.mo1951a(bg.f6307g);
                cyVar.mo1947a(bgVar.f6313a.mo1927a());
                cyVar.mo1960c();
            }
            if (bgVar.m9874i()) {
                cyVar.mo1951a(bg.f6308h);
                cyVar.mo1947a(bgVar.f6314b);
                cyVar.mo1960c();
            }
            if (bgVar.f6315c != null && bgVar.m9877l()) {
                cyVar.mo1951a(bg.f6309i);
                cyVar.mo1949a(bgVar.f6315c);
                cyVar.mo1960c();
            }
            if (bgVar.f6316d != null && bgVar.m9880o()) {
                cyVar.mo1951a(bg.f6310j);
                cyVar.mo1949a(bgVar.f6316d);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: UserInfo */
    /* renamed from: u.aly.bg$b */
    private static class C1407b implements dh {
        private C1407b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9834a();
        }

        /* renamed from: a */
        public C1406a m9834a() {
            return new C1406a();
        }
    }

    /* compiled from: UserInfo */
    /* renamed from: u.aly.bg$c */
    private static class C1408c extends dj<bg> {
        private C1408c() {
        }

        /* renamed from: a */
        public void m9836a(cy cyVar, bg bgVar) throws cf {
            de deVar = (de) cyVar;
            BitSet bitSet = new BitSet();
            if (bgVar.m9870e()) {
                bitSet.set(0);
            }
            if (bgVar.m9874i()) {
                bitSet.set(1);
            }
            if (bgVar.m9877l()) {
                bitSet.set(2);
            }
            if (bgVar.m9880o()) {
                bitSet.set(3);
            }
            deVar.m10341a(bitSet, 4);
            if (bgVar.m9870e()) {
                deVar.mo1947a(bgVar.f6313a.mo1927a());
            }
            if (bgVar.m9874i()) {
                deVar.mo1947a(bgVar.f6314b);
            }
            if (bgVar.m9877l()) {
                deVar.mo1949a(bgVar.f6315c);
            }
            if (bgVar.m9880o()) {
                deVar.mo1949a(bgVar.f6316d);
            }
        }

        /* renamed from: b */
        public void m9838b(cy cyVar, bg bgVar) throws cf {
            de deVar = (de) cyVar;
            BitSet b = deVar.mo1986b(4);
            if (b.get(0)) {
                bgVar.f6313a = ap.m9077a(deVar.mo1980w());
                bgVar.m9859a(true);
            }
            if (b.get(1)) {
                bgVar.f6314b = deVar.mo1980w();
                bgVar.m9864b(true);
            }
            if (b.get(2)) {
                bgVar.f6315c = deVar.mo1983z();
                bgVar.m9867c(true);
            }
            if (b.get(3)) {
                bgVar.f6316d = deVar.mo1983z();
                bgVar.m9869d(true);
            }
        }
    }

    /* compiled from: UserInfo */
    /* renamed from: u.aly.bg$d */
    private static class C1409d implements dh {
        private C1409d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9840a();
        }

        /* renamed from: a */
        public C1408c m9840a() {
            return new C1408c();
        }
    }

    /* compiled from: UserInfo */
    /* renamed from: u.aly.bg$e */
    public enum C1410e implements cg {
        GENDER((short) 1, "gender"),
        AGE((short) 2, "age"),
        ID((short) 3, "id"),
        SOURCE((short) 4, "source");
        
        /* renamed from: e */
        private static final Map<String, C1410e> f6301e = null;
        /* renamed from: f */
        private final short f6303f;
        /* renamed from: g */
        private final String f6304g;

        static {
            f6301e = new HashMap();
            Iterator it = EnumSet.allOf(C1410e.class).iterator();
            while (it.hasNext()) {
                C1410e c1410e = (C1410e) it.next();
                f6301e.put(c1410e.mo1932b(), c1410e);
            }
        }

        /* renamed from: a */
        public static C1410e m9842a(int i) {
            switch (i) {
                case 1:
                    return GENDER;
                case 2:
                    return AGE;
                case 3:
                    return ID;
                case 4:
                    return SOURCE;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1410e m9844b(int i) {
            C1410e a = C1410e.m9842a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1410e m9843a(String str) {
            return (C1410e) f6301e.get(str);
        }

        private C1410e(short s, String str) {
            this.f6303f = s;
            this.f6304g = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6303f;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6304g;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9866c(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9854a();
    }

    static {
        f6311k.put(di.class, new C1407b());
        f6311k.put(dj.class, new C1409d());
        Map enumMap = new EnumMap(C1410e.class);
        enumMap.put(C1410e.GENDER, new cl("gender", (byte) 2, new ck(df.f6530n, ap.class)));
        enumMap.put(C1410e.AGE, new cl("age", (byte) 2, new cm((byte) 8)));
        enumMap.put(C1410e.ID, new cl("id", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1410e.SOURCE, new cl("source", (byte) 2, new cm((byte) 11)));
        f6305e = Collections.unmodifiableMap(enumMap);
        cl.m10164a(bg.class, f6305e);
    }

    public bg() {
        this.f6317m = (byte) 0;
        this.f6318n = new C1410e[]{C1410e.GENDER, C1410e.AGE, C1410e.ID, C1410e.SOURCE};
    }

    public bg(bg bgVar) {
        this.f6317m = (byte) 0;
        this.f6318n = new C1410e[]{C1410e.GENDER, C1410e.AGE, C1410e.ID, C1410e.SOURCE};
        this.f6317m = bgVar.f6317m;
        if (bgVar.m9870e()) {
            this.f6313a = bgVar.f6313a;
        }
        this.f6314b = bgVar.f6314b;
        if (bgVar.m9877l()) {
            this.f6315c = bgVar.f6315c;
        }
        if (bgVar.m9880o()) {
            this.f6316d = bgVar.f6316d;
        }
    }

    /* renamed from: a */
    public bg m9854a() {
        return new bg(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6313a = null;
        m9864b(false);
        this.f6314b = 0;
        this.f6315c = null;
        this.f6316d = null;
    }

    /* renamed from: c */
    public ap m9865c() {
        return this.f6313a;
    }

    /* renamed from: a */
    public bg m9857a(ap apVar) {
        this.f6313a = apVar;
        return this;
    }

    /* renamed from: d */
    public void m9868d() {
        this.f6313a = null;
    }

    /* renamed from: e */
    public boolean m9870e() {
        return this.f6313a != null;
    }

    /* renamed from: a */
    public void m9859a(boolean z) {
        if (!z) {
            this.f6313a = null;
        }
    }

    /* renamed from: f */
    public int m9871f() {
        return this.f6314b;
    }

    /* renamed from: a */
    public bg m9855a(int i) {
        this.f6314b = i;
        m9864b(true);
        return this;
    }

    /* renamed from: h */
    public void m9873h() {
        this.f6317m = bw.m10080b(this.f6317m, 0);
    }

    /* renamed from: i */
    public boolean m9874i() {
        return bw.m10076a(this.f6317m, 0);
    }

    /* renamed from: b */
    public void m9864b(boolean z) {
        this.f6317m = bw.m10068a(this.f6317m, 0, z);
    }

    /* renamed from: j */
    public String m9875j() {
        return this.f6315c;
    }

    /* renamed from: a */
    public bg m9856a(String str) {
        this.f6315c = str;
        return this;
    }

    /* renamed from: k */
    public void m9876k() {
        this.f6315c = null;
    }

    /* renamed from: l */
    public boolean m9877l() {
        return this.f6315c != null;
    }

    /* renamed from: c */
    public void m9867c(boolean z) {
        if (!z) {
            this.f6315c = null;
        }
    }

    /* renamed from: m */
    public String m9878m() {
        return this.f6316d;
    }

    /* renamed from: b */
    public bg m9860b(String str) {
        this.f6316d = str;
        return this;
    }

    /* renamed from: n */
    public void m9879n() {
        this.f6316d = null;
    }

    /* renamed from: o */
    public boolean m9880o() {
        return this.f6316d != null;
    }

    /* renamed from: d */
    public void m9869d(boolean z) {
        if (!z) {
            this.f6316d = null;
        }
    }

    /* renamed from: c */
    public C1410e m9866c(int i) {
        return C1410e.m9842a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6311k.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6311k.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("UserInfo(");
        Object obj2 = 1;
        if (m9870e()) {
            stringBuilder.append("gender:");
            if (this.f6313a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6313a);
            }
            obj2 = null;
        }
        if (m9874i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("age:");
            stringBuilder.append(this.f6314b);
            obj2 = null;
        }
        if (m9877l()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("id:");
            if (this.f6315c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6315c);
            }
        } else {
            obj = obj2;
        }
        if (m9880o()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("source:");
            if (this.f6316d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6316d);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: p */
    public void m9881p() throws cf {
    }

    /* renamed from: a */
    private void m9848a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9847a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6317m = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
