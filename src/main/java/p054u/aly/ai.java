package p054u.aly;

import com.umeng.analytics.onlineconfig.C1248a;
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

/* compiled from: AppInfo */
/* renamed from: u.aly.ai */
public class ai implements Serializable, Cloneable, bz<ai, C1287e> {
    /* renamed from: k */
    public static final Map<C1287e, cl> f5828k;
    /* renamed from: l */
    private static final dd f5829l = new dd("AppInfo");
    /* renamed from: m */
    private static final ct f5830m = new ct("key", (byte) 11, (short) 1);
    /* renamed from: n */
    private static final ct f5831n = new ct("version", (byte) 11, (short) 2);
    /* renamed from: o */
    private static final ct f5832o = new ct("version_index", (byte) 8, (short) 3);
    /* renamed from: p */
    private static final ct f5833p = new ct("package_name", (byte) 11, (short) 4);
    /* renamed from: q */
    private static final ct f5834q = new ct("sdk_type", (byte) 8, (short) 5);
    /* renamed from: r */
    private static final ct f5835r = new ct(C1248a.f5660g, (byte) 11, (short) 6);
    /* renamed from: s */
    private static final ct f5836s = new ct(C1248a.f5656c, (byte) 11, (short) 7);
    /* renamed from: t */
    private static final ct f5837t = new ct("wrapper_type", (byte) 11, (short) 8);
    /* renamed from: u */
    private static final ct f5838u = new ct("wrapper_version", (byte) 11, (short) 9);
    /* renamed from: v */
    private static final ct f5839v = new ct("vertical_type", (byte) 8, (short) 10);
    /* renamed from: w */
    private static final Map<Class<? extends dg>, dh> f5840w = new HashMap();
    /* renamed from: x */
    private static final int f5841x = 0;
    /* renamed from: y */
    private static final int f5842y = 1;
    /* renamed from: A */
    private C1287e[] f5843A;
    /* renamed from: a */
    public String f5844a;
    /* renamed from: b */
    public String f5845b;
    /* renamed from: c */
    public int f5846c;
    /* renamed from: d */
    public String f5847d;
    /* renamed from: e */
    public bc f5848e;
    /* renamed from: f */
    public String f5849f;
    /* renamed from: g */
    public String f5850g;
    /* renamed from: h */
    public String f5851h;
    /* renamed from: i */
    public String f5852i;
    /* renamed from: j */
    public int f5853j;
    /* renamed from: z */
    private byte f5854z;

    /* compiled from: AppInfo */
    /* renamed from: u.aly.ai$a */
    private static class C1283a extends di<ai> {
        private C1283a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m8740b(cyVar, (ai) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m8738a(cyVar, (ai) bzVar);
        }

        /* renamed from: a */
        public void m8738a(cy cyVar, ai aiVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    aiVar.m8775H();
                    return;
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5844a = cyVar.mo1983z();
                        aiVar.m8781a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5845b = cyVar.mo1983z();
                        aiVar.m8786b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5846c = cyVar.mo1980w();
                        aiVar.m8790c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5847d = cyVar.mo1983z();
                        aiVar.m8794d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5848e = bc.m9683a(cyVar.mo1980w());
                        aiVar.m8796e(true);
                        break;
                    case (short) 6:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5849f = cyVar.mo1983z();
                        aiVar.m8800f(true);
                        break;
                    case (short) 7:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5850g = cyVar.mo1983z();
                        aiVar.m8803g(true);
                        break;
                    case (short) 8:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5851h = cyVar.mo1983z();
                        aiVar.m8805h(true);
                        break;
                    case (short) 9:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5852i = cyVar.mo1983z();
                        aiVar.m8806i(true);
                        break;
                    case (short) 10:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aiVar.f5853j = cyVar.mo1980w();
                        aiVar.m8809j(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m8740b(cy cyVar, ai aiVar) throws cf {
            aiVar.m8775H();
            cyVar.mo1956a(ai.f5829l);
            if (aiVar.f5844a != null) {
                cyVar.mo1951a(ai.f5830m);
                cyVar.mo1949a(aiVar.f5844a);
                cyVar.mo1960c();
            }
            if (aiVar.f5845b != null && aiVar.m8807i()) {
                cyVar.mo1951a(ai.f5831n);
                cyVar.mo1949a(aiVar.f5845b);
                cyVar.mo1960c();
            }
            if (aiVar.m8811l()) {
                cyVar.mo1951a(ai.f5832o);
                cyVar.mo1947a(aiVar.f5846c);
                cyVar.mo1960c();
            }
            if (aiVar.f5847d != null && aiVar.m8814o()) {
                cyVar.mo1951a(ai.f5833p);
                cyVar.mo1949a(aiVar.f5847d);
                cyVar.mo1960c();
            }
            if (aiVar.f5848e != null) {
                cyVar.mo1951a(ai.f5834q);
                cyVar.mo1947a(aiVar.f5848e.mo1927a());
                cyVar.mo1960c();
            }
            if (aiVar.f5849f != null) {
                cyVar.mo1951a(ai.f5835r);
                cyVar.mo1949a(aiVar.f5849f);
                cyVar.mo1960c();
            }
            if (aiVar.f5850g != null) {
                cyVar.mo1951a(ai.f5836s);
                cyVar.mo1949a(aiVar.f5850g);
                cyVar.mo1960c();
            }
            if (aiVar.f5851h != null && aiVar.m8768A()) {
                cyVar.mo1951a(ai.f5837t);
                cyVar.mo1949a(aiVar.f5851h);
                cyVar.mo1960c();
            }
            if (aiVar.f5852i != null && aiVar.m8771D()) {
                cyVar.mo1951a(ai.f5838u);
                cyVar.mo1949a(aiVar.f5852i);
                cyVar.mo1960c();
            }
            if (aiVar.m8774G()) {
                cyVar.mo1951a(ai.f5839v);
                cyVar.mo1947a(aiVar.f5853j);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: AppInfo */
    /* renamed from: u.aly.ai$b */
    private static class C1284b implements dh {
        private C1284b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8742a();
        }

        /* renamed from: a */
        public C1283a m8742a() {
            return new C1283a();
        }
    }

    /* compiled from: AppInfo */
    /* renamed from: u.aly.ai$c */
    private static class C1285c extends dj<ai> {
        private C1285c() {
        }

        /* renamed from: a */
        public void m8744a(cy cyVar, ai aiVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1949a(aiVar.f5844a);
            deVar.mo1947a(aiVar.f5848e.mo1927a());
            deVar.mo1949a(aiVar.f5849f);
            deVar.mo1949a(aiVar.f5850g);
            BitSet bitSet = new BitSet();
            if (aiVar.m8807i()) {
                bitSet.set(0);
            }
            if (aiVar.m8811l()) {
                bitSet.set(1);
            }
            if (aiVar.m8814o()) {
                bitSet.set(2);
            }
            if (aiVar.m8768A()) {
                bitSet.set(3);
            }
            if (aiVar.m8771D()) {
                bitSet.set(4);
            }
            if (aiVar.m8774G()) {
                bitSet.set(5);
            }
            deVar.m10341a(bitSet, 6);
            if (aiVar.m8807i()) {
                deVar.mo1949a(aiVar.f5845b);
            }
            if (aiVar.m8811l()) {
                deVar.mo1947a(aiVar.f5846c);
            }
            if (aiVar.m8814o()) {
                deVar.mo1949a(aiVar.f5847d);
            }
            if (aiVar.m8768A()) {
                deVar.mo1949a(aiVar.f5851h);
            }
            if (aiVar.m8771D()) {
                deVar.mo1949a(aiVar.f5852i);
            }
            if (aiVar.m8774G()) {
                deVar.mo1947a(aiVar.f5853j);
            }
        }

        /* renamed from: b */
        public void m8746b(cy cyVar, ai aiVar) throws cf {
            de deVar = (de) cyVar;
            aiVar.f5844a = deVar.mo1983z();
            aiVar.m8781a(true);
            aiVar.f5848e = bc.m9683a(deVar.mo1980w());
            aiVar.m8796e(true);
            aiVar.f5849f = deVar.mo1983z();
            aiVar.m8800f(true);
            aiVar.f5850g = deVar.mo1983z();
            aiVar.m8803g(true);
            BitSet b = deVar.mo1986b(6);
            if (b.get(0)) {
                aiVar.f5845b = deVar.mo1983z();
                aiVar.m8786b(true);
            }
            if (b.get(1)) {
                aiVar.f5846c = deVar.mo1980w();
                aiVar.m8790c(true);
            }
            if (b.get(2)) {
                aiVar.f5847d = deVar.mo1983z();
                aiVar.m8794d(true);
            }
            if (b.get(3)) {
                aiVar.f5851h = deVar.mo1983z();
                aiVar.m8805h(true);
            }
            if (b.get(4)) {
                aiVar.f5852i = deVar.mo1983z();
                aiVar.m8806i(true);
            }
            if (b.get(5)) {
                aiVar.f5853j = deVar.mo1980w();
                aiVar.m8809j(true);
            }
        }
    }

    /* compiled from: AppInfo */
    /* renamed from: u.aly.ai$d */
    private static class C1286d implements dh {
        private C1286d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8748a();
        }

        /* renamed from: a */
        public C1285c m8748a() {
            return new C1285c();
        }
    }

    /* compiled from: AppInfo */
    /* renamed from: u.aly.ai$e */
    public enum C1287e implements cg {
        KEY((short) 1, "key"),
        VERSION((short) 2, "version"),
        VERSION_INDEX((short) 3, "version_index"),
        PACKAGE_NAME((short) 4, "package_name"),
        SDK_TYPE((short) 5, "sdk_type"),
        SDK_VERSION((short) 6, C1248a.f5660g),
        CHANNEL((short) 7, C1248a.f5656c),
        WRAPPER_TYPE((short) 8, "wrapper_type"),
        WRAPPER_VERSION((short) 9, "wrapper_version"),
        VERTICAL_TYPE((short) 10, "vertical_type");
        
        /* renamed from: k */
        private static final Map<String, C1287e> f5824k = null;
        /* renamed from: l */
        private final short f5826l;
        /* renamed from: m */
        private final String f5827m;

        static {
            f5824k = new HashMap();
            Iterator it = EnumSet.allOf(C1287e.class).iterator();
            while (it.hasNext()) {
                C1287e c1287e = (C1287e) it.next();
                f5824k.put(c1287e.mo1932b(), c1287e);
            }
        }

        /* renamed from: a */
        public static C1287e m8750a(int i) {
            switch (i) {
                case 1:
                    return KEY;
                case 2:
                    return VERSION;
                case 3:
                    return VERSION_INDEX;
                case 4:
                    return PACKAGE_NAME;
                case 5:
                    return SDK_TYPE;
                case 6:
                    return SDK_VERSION;
                case 7:
                    return CHANNEL;
                case 8:
                    return WRAPPER_TYPE;
                case 9:
                    return WRAPPER_VERSION;
                case 10:
                    return VERTICAL_TYPE;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1287e m8752b(int i) {
            C1287e a = C1287e.m8750a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1287e m8751a(String str) {
            return (C1287e) f5824k.get(str);
        }

        private C1287e(short s, String str) {
            this.f5826l = s;
            this.f5827m = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5826l;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5827m;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8791d(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8776a();
    }

    static {
        f5840w.put(di.class, new C1284b());
        f5840w.put(dj.class, new C1286d());
        Map enumMap = new EnumMap(C1287e.class);
        enumMap.put(C1287e.KEY, new cl("key", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1287e.VERSION, new cl("version", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1287e.VERSION_INDEX, new cl("version_index", (byte) 2, new cm((byte) 8)));
        enumMap.put(C1287e.PACKAGE_NAME, new cl("package_name", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1287e.SDK_TYPE, new cl("sdk_type", (byte) 1, new ck(df.f6530n, bc.class)));
        enumMap.put(C1287e.SDK_VERSION, new cl(C1248a.f5660g, (byte) 1, new cm((byte) 11)));
        enumMap.put(C1287e.CHANNEL, new cl(C1248a.f5656c, (byte) 1, new cm((byte) 11)));
        enumMap.put(C1287e.WRAPPER_TYPE, new cl("wrapper_type", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1287e.WRAPPER_VERSION, new cl("wrapper_version", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1287e.VERTICAL_TYPE, new cl("vertical_type", (byte) 2, new cm((byte) 8)));
        f5828k = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ai.class, f5828k);
    }

    public ai() {
        this.f5854z = (byte) 0;
        this.f5843A = new C1287e[]{C1287e.VERSION, C1287e.VERSION_INDEX, C1287e.PACKAGE_NAME, C1287e.WRAPPER_TYPE, C1287e.WRAPPER_VERSION, C1287e.VERTICAL_TYPE};
    }

    public ai(String str, bc bcVar, String str2, String str3) {
        this();
        this.f5844a = str;
        this.f5848e = bcVar;
        this.f5849f = str2;
        this.f5850g = str3;
    }

    public ai(ai aiVar) {
        this.f5854z = (byte) 0;
        this.f5843A = new C1287e[]{C1287e.VERSION, C1287e.VERSION_INDEX, C1287e.PACKAGE_NAME, C1287e.WRAPPER_TYPE, C1287e.WRAPPER_VERSION, C1287e.VERTICAL_TYPE};
        this.f5854z = aiVar.f5854z;
        if (aiVar.m8797e()) {
            this.f5844a = aiVar.f5844a;
        }
        if (aiVar.m8807i()) {
            this.f5845b = aiVar.f5845b;
        }
        this.f5846c = aiVar.f5846c;
        if (aiVar.m8814o()) {
            this.f5847d = aiVar.f5847d;
        }
        if (aiVar.m8817r()) {
            this.f5848e = aiVar.f5848e;
        }
        if (aiVar.m8820u()) {
            this.f5849f = aiVar.f5849f;
        }
        if (aiVar.m8823x()) {
            this.f5850g = aiVar.f5850g;
        }
        if (aiVar.m8768A()) {
            this.f5851h = aiVar.f5851h;
        }
        if (aiVar.m8771D()) {
            this.f5852i = aiVar.f5852i;
        }
        this.f5853j = aiVar.f5853j;
    }

    /* renamed from: a */
    public ai m8776a() {
        return new ai(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f5844a = null;
        this.f5845b = null;
        m8790c(false);
        this.f5846c = 0;
        this.f5847d = null;
        this.f5848e = null;
        this.f5849f = null;
        this.f5850g = null;
        this.f5851h = null;
        this.f5852i = null;
        m8809j(false);
        this.f5853j = 0;
    }

    /* renamed from: c */
    public String m8787c() {
        return this.f5844a;
    }

    /* renamed from: a */
    public ai m8778a(String str) {
        this.f5844a = str;
        return this;
    }

    /* renamed from: d */
    public void m8793d() {
        this.f5844a = null;
    }

    /* renamed from: e */
    public boolean m8797e() {
        return this.f5844a != null;
    }

    /* renamed from: a */
    public void m8781a(boolean z) {
        if (!z) {
            this.f5844a = null;
        }
    }

    /* renamed from: f */
    public String m8798f() {
        return this.f5845b;
    }

    /* renamed from: b */
    public ai m8782b(String str) {
        this.f5845b = str;
        return this;
    }

    /* renamed from: h */
    public void m8804h() {
        this.f5845b = null;
    }

    /* renamed from: i */
    public boolean m8807i() {
        return this.f5845b != null;
    }

    /* renamed from: b */
    public void m8786b(boolean z) {
        if (!z) {
            this.f5845b = null;
        }
    }

    /* renamed from: j */
    public int m8808j() {
        return this.f5846c;
    }

    /* renamed from: a */
    public ai m8777a(int i) {
        this.f5846c = i;
        m8790c(true);
        return this;
    }

    /* renamed from: k */
    public void m8810k() {
        this.f5854z = bw.m10080b(this.f5854z, 0);
    }

    /* renamed from: l */
    public boolean m8811l() {
        return bw.m10076a(this.f5854z, 0);
    }

    /* renamed from: c */
    public void m8790c(boolean z) {
        this.f5854z = bw.m10068a(this.f5854z, 0, z);
    }

    /* renamed from: m */
    public String m8812m() {
        return this.f5847d;
    }

    /* renamed from: c */
    public ai m8789c(String str) {
        this.f5847d = str;
        return this;
    }

    /* renamed from: n */
    public void m8813n() {
        this.f5847d = null;
    }

    /* renamed from: o */
    public boolean m8814o() {
        return this.f5847d != null;
    }

    /* renamed from: d */
    public void m8794d(boolean z) {
        if (!z) {
            this.f5847d = null;
        }
    }

    /* renamed from: p */
    public bc m8815p() {
        return this.f5848e;
    }

    /* renamed from: a */
    public ai m8779a(bc bcVar) {
        this.f5848e = bcVar;
        return this;
    }

    /* renamed from: q */
    public void m8816q() {
        this.f5848e = null;
    }

    /* renamed from: r */
    public boolean m8817r() {
        return this.f5848e != null;
    }

    /* renamed from: e */
    public void m8796e(boolean z) {
        if (!z) {
            this.f5848e = null;
        }
    }

    /* renamed from: s */
    public String m8818s() {
        return this.f5849f;
    }

    /* renamed from: d */
    public ai m8792d(String str) {
        this.f5849f = str;
        return this;
    }

    /* renamed from: t */
    public void m8819t() {
        this.f5849f = null;
    }

    /* renamed from: u */
    public boolean m8820u() {
        return this.f5849f != null;
    }

    /* renamed from: f */
    public void m8800f(boolean z) {
        if (!z) {
            this.f5849f = null;
        }
    }

    /* renamed from: v */
    public String m8821v() {
        return this.f5850g;
    }

    /* renamed from: e */
    public ai m8795e(String str) {
        this.f5850g = str;
        return this;
    }

    /* renamed from: w */
    public void m8822w() {
        this.f5850g = null;
    }

    /* renamed from: x */
    public boolean m8823x() {
        return this.f5850g != null;
    }

    /* renamed from: g */
    public void m8803g(boolean z) {
        if (!z) {
            this.f5850g = null;
        }
    }

    /* renamed from: y */
    public String m8824y() {
        return this.f5851h;
    }

    /* renamed from: f */
    public ai m8799f(String str) {
        this.f5851h = str;
        return this;
    }

    /* renamed from: z */
    public void m8825z() {
        this.f5851h = null;
    }

    /* renamed from: A */
    public boolean m8768A() {
        return this.f5851h != null;
    }

    /* renamed from: h */
    public void m8805h(boolean z) {
        if (!z) {
            this.f5851h = null;
        }
    }

    /* renamed from: B */
    public String m8769B() {
        return this.f5852i;
    }

    /* renamed from: g */
    public ai m8801g(String str) {
        this.f5852i = str;
        return this;
    }

    /* renamed from: C */
    public void m8770C() {
        this.f5852i = null;
    }

    /* renamed from: D */
    public boolean m8771D() {
        return this.f5852i != null;
    }

    /* renamed from: i */
    public void m8806i(boolean z) {
        if (!z) {
            this.f5852i = null;
        }
    }

    /* renamed from: E */
    public int m8772E() {
        return this.f5853j;
    }

    /* renamed from: c */
    public ai m8788c(int i) {
        this.f5853j = i;
        m8809j(true);
        return this;
    }

    /* renamed from: F */
    public void m8773F() {
        this.f5854z = bw.m10080b(this.f5854z, 1);
    }

    /* renamed from: G */
    public boolean m8774G() {
        return bw.m10076a(this.f5854z, 1);
    }

    /* renamed from: j */
    public void m8809j(boolean z) {
        this.f5854z = bw.m10068a(this.f5854z, 1, z);
    }

    /* renamed from: d */
    public C1287e m8791d(int i) {
        return C1287e.m8750a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5840w.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5840w.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppInfo(");
        stringBuilder.append("key:");
        if (this.f5844a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5844a);
        }
        if (m8807i()) {
            stringBuilder.append(", ");
            stringBuilder.append("version:");
            if (this.f5845b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5845b);
            }
        }
        if (m8811l()) {
            stringBuilder.append(", ");
            stringBuilder.append("version_index:");
            stringBuilder.append(this.f5846c);
        }
        if (m8814o()) {
            stringBuilder.append(", ");
            stringBuilder.append("package_name:");
            if (this.f5847d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5847d);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("sdk_type:");
        if (this.f5848e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5848e);
        }
        stringBuilder.append(", ");
        stringBuilder.append("sdk_version:");
        if (this.f5849f == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5849f);
        }
        stringBuilder.append(", ");
        stringBuilder.append("channel:");
        if (this.f5850g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f5850g);
        }
        if (m8768A()) {
            stringBuilder.append(", ");
            stringBuilder.append("wrapper_type:");
            if (this.f5851h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5851h);
            }
        }
        if (m8771D()) {
            stringBuilder.append(", ");
            stringBuilder.append("wrapper_version:");
            if (this.f5852i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5852i);
            }
        }
        if (m8774G()) {
            stringBuilder.append(", ");
            stringBuilder.append("vertical_type:");
            stringBuilder.append(this.f5853j);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: H */
    public void m8775H() throws cf {
        if (this.f5844a == null) {
            throw new cz("Required field 'key' was not present! Struct: " + toString());
        } else if (this.f5848e == null) {
            throw new cz("Required field 'sdk_type' was not present! Struct: " + toString());
        } else if (this.f5849f == null) {
            throw new cz("Required field 'sdk_version' was not present! Struct: " + toString());
        } else if (this.f5850g == null) {
            throw new cz("Required field 'channel' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m8767a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8766a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5854z = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
