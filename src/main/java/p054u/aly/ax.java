package p054u.aly;

import com.amap.api.services.district.DistrictSearchQuery;
import com.iflytek.cloud.speech.SpeechConstant;
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

/* compiled from: MiscInfo */
/* renamed from: u.aly.ax */
public class ax implements Serializable, Cloneable, bz<ax, C1365e> {
    /* renamed from: A */
    private static final int f6141A = 1;
    /* renamed from: B */
    private static final int f6142B = 2;
    /* renamed from: C */
    private static final int f6143C = 3;
    /* renamed from: l */
    public static final Map<C1365e, cl> f6144l;
    /* renamed from: m */
    private static final dd f6145m = new dd("MiscInfo");
    /* renamed from: n */
    private static final ct f6146n = new ct("time_zone", (byte) 8, (short) 1);
    /* renamed from: o */
    private static final ct f6147o = new ct(SpeechConstant.LANGUAGE, (byte) 11, (short) 2);
    /* renamed from: p */
    private static final ct f6148p = new ct(DistrictSearchQuery.KEYWORDS_COUNTRY, (byte) 11, (short) 3);
    /* renamed from: q */
    private static final ct f6149q = new ct("latitude", (byte) 4, (short) 4);
    /* renamed from: r */
    private static final ct f6150r = new ct("longitude", (byte) 4, (short) 5);
    /* renamed from: s */
    private static final ct f6151s = new ct("carrier", (byte) 11, (short) 6);
    /* renamed from: t */
    private static final ct f6152t = new ct("latency", (byte) 8, (short) 7);
    /* renamed from: u */
    private static final ct f6153u = new ct("display_name", (byte) 11, (short) 8);
    /* renamed from: v */
    private static final ct f6154v = new ct("access_type", (byte) 8, (short) 9);
    /* renamed from: w */
    private static final ct f6155w = new ct("access_subtype", (byte) 11, (short) 10);
    /* renamed from: x */
    private static final ct f6156x = new ct("user_info", (byte) 12, (short) 11);
    /* renamed from: y */
    private static final Map<Class<? extends dg>, dh> f6157y = new HashMap();
    /* renamed from: z */
    private static final int f6158z = 0;
    /* renamed from: D */
    private byte f6159D;
    /* renamed from: E */
    private C1365e[] f6160E;
    /* renamed from: a */
    public int f6161a;
    /* renamed from: b */
    public String f6162b;
    /* renamed from: c */
    public String f6163c;
    /* renamed from: d */
    public double f6164d;
    /* renamed from: e */
    public double f6165e;
    /* renamed from: f */
    public String f6166f;
    /* renamed from: g */
    public int f6167g;
    /* renamed from: h */
    public String f6168h;
    /* renamed from: i */
    public ag f6169i;
    /* renamed from: j */
    public String f6170j;
    /* renamed from: k */
    public bg f6171k;

    /* compiled from: MiscInfo */
    /* renamed from: u.aly.ax$a */
    private static class C1361a extends di<ax> {
        private C1361a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9431b(cyVar, (ax) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9429a(cyVar, (ax) bzVar);
        }

        /* renamed from: a */
        public void m9429a(cy cyVar, ax axVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    axVar.m9470K();
                    return;
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6161a = cyVar.mo1980w();
                        axVar.m9478a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6162b = cyVar.mo1983z();
                        axVar.m9484b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6163c = cyVar.mo1983z();
                        axVar.m9488c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 4) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6164d = cyVar.mo1982y();
                        axVar.m9492d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != (byte) 4) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6165e = cyVar.mo1982y();
                        axVar.m9494e(true);
                        break;
                    case (short) 6:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6166f = cyVar.mo1983z();
                        axVar.m9497f(true);
                        break;
                    case (short) 7:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6167g = cyVar.mo1980w();
                        axVar.m9499g(true);
                        break;
                    case (short) 8:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6168h = cyVar.mo1983z();
                        axVar.m9501h(true);
                        break;
                    case (short) 9:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6169i = ag.m8697a(cyVar.mo1980w());
                        axVar.m9502i(true);
                        break;
                    case (short) 10:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6170j = cyVar.mo1983z();
                        axVar.m9505j(true);
                        break;
                    case (short) 11:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        axVar.f6171k = new bg();
                        axVar.f6171k.mo1921a(cyVar);
                        axVar.m9507k(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9431b(cy cyVar, ax axVar) throws cf {
            axVar.m9470K();
            cyVar.mo1956a(ax.f6145m);
            if (axVar.m9495e()) {
                cyVar.mo1951a(ax.f6146n);
                cyVar.mo1947a(axVar.f6161a);
                cyVar.mo1960c();
            }
            if (axVar.f6162b != null && axVar.m9503i()) {
                cyVar.mo1951a(ax.f6147o);
                cyVar.mo1949a(axVar.f6162b);
                cyVar.mo1960c();
            }
            if (axVar.f6163c != null && axVar.m9508l()) {
                cyVar.mo1951a(ax.f6148p);
                cyVar.mo1949a(axVar.f6163c);
                cyVar.mo1960c();
            }
            if (axVar.m9511o()) {
                cyVar.mo1951a(ax.f6149q);
                cyVar.mo1946a(axVar.f6164d);
                cyVar.mo1960c();
            }
            if (axVar.m9514r()) {
                cyVar.mo1951a(ax.f6150r);
                cyVar.mo1946a(axVar.f6165e);
                cyVar.mo1960c();
            }
            if (axVar.f6166f != null && axVar.m9517u()) {
                cyVar.mo1951a(ax.f6151s);
                cyVar.mo1949a(axVar.f6166f);
                cyVar.mo1960c();
            }
            if (axVar.m9520x()) {
                cyVar.mo1951a(ax.f6152t);
                cyVar.mo1947a(axVar.f6167g);
                cyVar.mo1960c();
            }
            if (axVar.f6168h != null && axVar.m9460A()) {
                cyVar.mo1951a(ax.f6153u);
                cyVar.mo1949a(axVar.f6168h);
                cyVar.mo1960c();
            }
            if (axVar.f6169i != null && axVar.m9463D()) {
                cyVar.mo1951a(ax.f6154v);
                cyVar.mo1947a(axVar.f6169i.mo1927a());
                cyVar.mo1960c();
            }
            if (axVar.f6170j != null && axVar.m9466G()) {
                cyVar.mo1951a(ax.f6155w);
                cyVar.mo1949a(axVar.f6170j);
                cyVar.mo1960c();
            }
            if (axVar.f6171k != null && axVar.m9469J()) {
                cyVar.mo1951a(ax.f6156x);
                axVar.f6171k.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: MiscInfo */
    /* renamed from: u.aly.ax$b */
    private static class C1362b implements dh {
        private C1362b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9433a();
        }

        /* renamed from: a */
        public C1361a m9433a() {
            return new C1361a();
        }
    }

    /* compiled from: MiscInfo */
    /* renamed from: u.aly.ax$c */
    private static class C1363c extends dj<ax> {
        private C1363c() {
        }

        /* renamed from: a */
        public void m9435a(cy cyVar, ax axVar) throws cf {
            cyVar = (de) cyVar;
            BitSet bitSet = new BitSet();
            if (axVar.m9495e()) {
                bitSet.set(0);
            }
            if (axVar.m9503i()) {
                bitSet.set(1);
            }
            if (axVar.m9508l()) {
                bitSet.set(2);
            }
            if (axVar.m9511o()) {
                bitSet.set(3);
            }
            if (axVar.m9514r()) {
                bitSet.set(4);
            }
            if (axVar.m9517u()) {
                bitSet.set(5);
            }
            if (axVar.m9520x()) {
                bitSet.set(6);
            }
            if (axVar.m9460A()) {
                bitSet.set(7);
            }
            if (axVar.m9463D()) {
                bitSet.set(8);
            }
            if (axVar.m9466G()) {
                bitSet.set(9);
            }
            if (axVar.m9469J()) {
                bitSet.set(10);
            }
            cyVar.m10341a(bitSet, 11);
            if (axVar.m9495e()) {
                cyVar.mo1947a(axVar.f6161a);
            }
            if (axVar.m9503i()) {
                cyVar.mo1949a(axVar.f6162b);
            }
            if (axVar.m9508l()) {
                cyVar.mo1949a(axVar.f6163c);
            }
            if (axVar.m9511o()) {
                cyVar.mo1946a(axVar.f6164d);
            }
            if (axVar.m9514r()) {
                cyVar.mo1946a(axVar.f6165e);
            }
            if (axVar.m9517u()) {
                cyVar.mo1949a(axVar.f6166f);
            }
            if (axVar.m9520x()) {
                cyVar.mo1947a(axVar.f6167g);
            }
            if (axVar.m9460A()) {
                cyVar.mo1949a(axVar.f6168h);
            }
            if (axVar.m9463D()) {
                cyVar.mo1947a(axVar.f6169i.mo1927a());
            }
            if (axVar.m9466G()) {
                cyVar.mo1949a(axVar.f6170j);
            }
            if (axVar.m9469J()) {
                axVar.f6171k.mo1924b(cyVar);
            }
        }

        /* renamed from: b */
        public void m9437b(cy cyVar, ax axVar) throws cf {
            cyVar = (de) cyVar;
            BitSet b = cyVar.mo1986b(11);
            if (b.get(0)) {
                axVar.f6161a = cyVar.mo1980w();
                axVar.m9478a(true);
            }
            if (b.get(1)) {
                axVar.f6162b = cyVar.mo1983z();
                axVar.m9484b(true);
            }
            if (b.get(2)) {
                axVar.f6163c = cyVar.mo1983z();
                axVar.m9488c(true);
            }
            if (b.get(3)) {
                axVar.f6164d = cyVar.mo1982y();
                axVar.m9492d(true);
            }
            if (b.get(4)) {
                axVar.f6165e = cyVar.mo1982y();
                axVar.m9494e(true);
            }
            if (b.get(5)) {
                axVar.f6166f = cyVar.mo1983z();
                axVar.m9497f(true);
            }
            if (b.get(6)) {
                axVar.f6167g = cyVar.mo1980w();
                axVar.m9499g(true);
            }
            if (b.get(7)) {
                axVar.f6168h = cyVar.mo1983z();
                axVar.m9501h(true);
            }
            if (b.get(8)) {
                axVar.f6169i = ag.m8697a(cyVar.mo1980w());
                axVar.m9502i(true);
            }
            if (b.get(9)) {
                axVar.f6170j = cyVar.mo1983z();
                axVar.m9505j(true);
            }
            if (b.get(10)) {
                axVar.f6171k = new bg();
                axVar.f6171k.mo1921a(cyVar);
                axVar.m9507k(true);
            }
        }
    }

    /* compiled from: MiscInfo */
    /* renamed from: u.aly.ax$d */
    private static class C1364d implements dh {
        private C1364d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9439a();
        }

        /* renamed from: a */
        public C1363c m9439a() {
            return new C1363c();
        }
    }

    /* compiled from: MiscInfo */
    /* renamed from: u.aly.ax$e */
    public enum C1365e implements cg {
        TIME_ZONE((short) 1, "time_zone"),
        LANGUAGE((short) 2, SpeechConstant.LANGUAGE),
        COUNTRY((short) 3, DistrictSearchQuery.KEYWORDS_COUNTRY),
        LATITUDE((short) 4, "latitude"),
        LONGITUDE((short) 5, "longitude"),
        CARRIER((short) 6, "carrier"),
        LATENCY((short) 7, "latency"),
        DISPLAY_NAME((short) 8, "display_name"),
        ACCESS_TYPE((short) 9, "access_type"),
        ACCESS_SUBTYPE((short) 10, "access_subtype"),
        USER_INFO((short) 11, "user_info");
        
        /* renamed from: l */
        private static final Map<String, C1365e> f6137l = null;
        /* renamed from: m */
        private final short f6139m;
        /* renamed from: n */
        private final String f6140n;

        static {
            f6137l = new HashMap();
            Iterator it = EnumSet.allOf(C1365e.class).iterator();
            while (it.hasNext()) {
                C1365e c1365e = (C1365e) it.next();
                f6137l.put(c1365e.mo1932b(), c1365e);
            }
        }

        /* renamed from: a */
        public static C1365e m9441a(int i) {
            switch (i) {
                case 1:
                    return TIME_ZONE;
                case 2:
                    return LANGUAGE;
                case 3:
                    return COUNTRY;
                case 4:
                    return LATITUDE;
                case 5:
                    return LONGITUDE;
                case 6:
                    return CARRIER;
                case 7:
                    return LATENCY;
                case 8:
                    return DISPLAY_NAME;
                case 9:
                    return ACCESS_TYPE;
                case 10:
                    return ACCESS_SUBTYPE;
                case 11:
                    return USER_INFO;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1365e m9443b(int i) {
            C1365e a = C1365e.m9441a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1365e m9442a(String str) {
            return (C1365e) f6137l.get(str);
        }

        private C1365e(short s, String str) {
            this.f6139m = s;
            this.f6140n = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6139m;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6140n;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9489d(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9471a();
    }

    static {
        f6157y.put(di.class, new C1362b());
        f6157y.put(dj.class, new C1364d());
        Map enumMap = new EnumMap(C1365e.class);
        enumMap.put(C1365e.TIME_ZONE, new cl("time_zone", (byte) 2, new cm((byte) 8)));
        enumMap.put(C1365e.LANGUAGE, new cl(SpeechConstant.LANGUAGE, (byte) 2, new cm((byte) 11)));
        enumMap.put(C1365e.COUNTRY, new cl(DistrictSearchQuery.KEYWORDS_COUNTRY, (byte) 2, new cm((byte) 11)));
        enumMap.put(C1365e.LATITUDE, new cl("latitude", (byte) 2, new cm((byte) 4)));
        enumMap.put(C1365e.LONGITUDE, new cl("longitude", (byte) 2, new cm((byte) 4)));
        enumMap.put(C1365e.CARRIER, new cl("carrier", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1365e.LATENCY, new cl("latency", (byte) 2, new cm((byte) 8)));
        enumMap.put(C1365e.DISPLAY_NAME, new cl("display_name", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1365e.ACCESS_TYPE, new cl("access_type", (byte) 2, new ck(df.f6530n, ag.class)));
        enumMap.put(C1365e.ACCESS_SUBTYPE, new cl("access_subtype", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1365e.USER_INFO, new cl("user_info", (byte) 2, new cq((byte) 12, bg.class)));
        f6144l = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ax.class, f6144l);
    }

    public ax() {
        this.f6159D = (byte) 0;
        this.f6160E = new C1365e[]{C1365e.TIME_ZONE, C1365e.LANGUAGE, C1365e.COUNTRY, C1365e.LATITUDE, C1365e.LONGITUDE, C1365e.CARRIER, C1365e.LATENCY, C1365e.DISPLAY_NAME, C1365e.ACCESS_TYPE, C1365e.ACCESS_SUBTYPE, C1365e.USER_INFO};
    }

    public ax(ax axVar) {
        this.f6159D = (byte) 0;
        this.f6160E = new C1365e[]{C1365e.TIME_ZONE, C1365e.LANGUAGE, C1365e.COUNTRY, C1365e.LATITUDE, C1365e.LONGITUDE, C1365e.CARRIER, C1365e.LATENCY, C1365e.DISPLAY_NAME, C1365e.ACCESS_TYPE, C1365e.ACCESS_SUBTYPE, C1365e.USER_INFO};
        this.f6159D = axVar.f6159D;
        this.f6161a = axVar.f6161a;
        if (axVar.m9503i()) {
            this.f6162b = axVar.f6162b;
        }
        if (axVar.m9508l()) {
            this.f6163c = axVar.f6163c;
        }
        this.f6164d = axVar.f6164d;
        this.f6165e = axVar.f6165e;
        if (axVar.m9517u()) {
            this.f6166f = axVar.f6166f;
        }
        this.f6167g = axVar.f6167g;
        if (axVar.m9460A()) {
            this.f6168h = axVar.f6168h;
        }
        if (axVar.m9463D()) {
            this.f6169i = axVar.f6169i;
        }
        if (axVar.m9466G()) {
            this.f6170j = axVar.f6170j;
        }
        if (axVar.m9469J()) {
            this.f6171k = new bg(axVar.f6171k);
        }
    }

    /* renamed from: a */
    public ax m9471a() {
        return new ax(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m9478a(false);
        this.f6161a = 0;
        this.f6162b = null;
        this.f6163c = null;
        m9492d(false);
        this.f6164d = 0.0d;
        m9494e(false);
        this.f6165e = 0.0d;
        this.f6166f = null;
        m9499g(false);
        this.f6167g = 0;
        this.f6168h = null;
        this.f6169i = null;
        this.f6170j = null;
        this.f6171k = null;
    }

    /* renamed from: c */
    public int m9485c() {
        return this.f6161a;
    }

    /* renamed from: a */
    public ax m9473a(int i) {
        this.f6161a = i;
        m9478a(true);
        return this;
    }

    /* renamed from: d */
    public void m9491d() {
        this.f6159D = bw.m10080b(this.f6159D, 0);
    }

    /* renamed from: e */
    public boolean m9495e() {
        return bw.m10076a(this.f6159D, 0);
    }

    /* renamed from: a */
    public void m9478a(boolean z) {
        this.f6159D = bw.m10068a(this.f6159D, 0, z);
    }

    /* renamed from: f */
    public String m9496f() {
        return this.f6162b;
    }

    /* renamed from: a */
    public ax m9474a(String str) {
        this.f6162b = str;
        return this;
    }

    /* renamed from: h */
    public void m9500h() {
        this.f6162b = null;
    }

    /* renamed from: i */
    public boolean m9503i() {
        return this.f6162b != null;
    }

    /* renamed from: b */
    public void m9484b(boolean z) {
        if (!z) {
            this.f6162b = null;
        }
    }

    /* renamed from: j */
    public String m9504j() {
        return this.f6163c;
    }

    /* renamed from: b */
    public ax m9480b(String str) {
        this.f6163c = str;
        return this;
    }

    /* renamed from: k */
    public void m9506k() {
        this.f6163c = null;
    }

    /* renamed from: l */
    public boolean m9508l() {
        return this.f6163c != null;
    }

    /* renamed from: c */
    public void m9488c(boolean z) {
        if (!z) {
            this.f6163c = null;
        }
    }

    /* renamed from: m */
    public double m9509m() {
        return this.f6164d;
    }

    /* renamed from: a */
    public ax m9472a(double d) {
        this.f6164d = d;
        m9492d(true);
        return this;
    }

    /* renamed from: n */
    public void m9510n() {
        this.f6159D = bw.m10080b(this.f6159D, 1);
    }

    /* renamed from: o */
    public boolean m9511o() {
        return bw.m10076a(this.f6159D, 1);
    }

    /* renamed from: d */
    public void m9492d(boolean z) {
        this.f6159D = bw.m10068a(this.f6159D, 1, z);
    }

    /* renamed from: p */
    public double m9512p() {
        return this.f6165e;
    }

    /* renamed from: b */
    public ax m9479b(double d) {
        this.f6165e = d;
        m9494e(true);
        return this;
    }

    /* renamed from: q */
    public void m9513q() {
        this.f6159D = bw.m10080b(this.f6159D, 2);
    }

    /* renamed from: r */
    public boolean m9514r() {
        return bw.m10076a(this.f6159D, 2);
    }

    /* renamed from: e */
    public void m9494e(boolean z) {
        this.f6159D = bw.m10068a(this.f6159D, 2, z);
    }

    /* renamed from: s */
    public String m9515s() {
        return this.f6166f;
    }

    /* renamed from: c */
    public ax m9487c(String str) {
        this.f6166f = str;
        return this;
    }

    /* renamed from: t */
    public void m9516t() {
        this.f6166f = null;
    }

    /* renamed from: u */
    public boolean m9517u() {
        return this.f6166f != null;
    }

    /* renamed from: f */
    public void m9497f(boolean z) {
        if (!z) {
            this.f6166f = null;
        }
    }

    /* renamed from: v */
    public int m9518v() {
        return this.f6167g;
    }

    /* renamed from: c */
    public ax m9486c(int i) {
        this.f6167g = i;
        m9499g(true);
        return this;
    }

    /* renamed from: w */
    public void m9519w() {
        this.f6159D = bw.m10080b(this.f6159D, 3);
    }

    /* renamed from: x */
    public boolean m9520x() {
        return bw.m10076a(this.f6159D, 3);
    }

    /* renamed from: g */
    public void m9499g(boolean z) {
        this.f6159D = bw.m10068a(this.f6159D, 3, z);
    }

    /* renamed from: y */
    public String m9521y() {
        return this.f6168h;
    }

    /* renamed from: d */
    public ax m9490d(String str) {
        this.f6168h = str;
        return this;
    }

    /* renamed from: z */
    public void m9522z() {
        this.f6168h = null;
    }

    /* renamed from: A */
    public boolean m9460A() {
        return this.f6168h != null;
    }

    /* renamed from: h */
    public void m9501h(boolean z) {
        if (!z) {
            this.f6168h = null;
        }
    }

    /* renamed from: B */
    public ag m9461B() {
        return this.f6169i;
    }

    /* renamed from: a */
    public ax m9475a(ag agVar) {
        this.f6169i = agVar;
        return this;
    }

    /* renamed from: C */
    public void m9462C() {
        this.f6169i = null;
    }

    /* renamed from: D */
    public boolean m9463D() {
        return this.f6169i != null;
    }

    /* renamed from: i */
    public void m9502i(boolean z) {
        if (!z) {
            this.f6169i = null;
        }
    }

    /* renamed from: E */
    public String m9464E() {
        return this.f6170j;
    }

    /* renamed from: e */
    public ax m9493e(String str) {
        this.f6170j = str;
        return this;
    }

    /* renamed from: F */
    public void m9465F() {
        this.f6170j = null;
    }

    /* renamed from: G */
    public boolean m9466G() {
        return this.f6170j != null;
    }

    /* renamed from: j */
    public void m9505j(boolean z) {
        if (!z) {
            this.f6170j = null;
        }
    }

    /* renamed from: H */
    public bg m9467H() {
        return this.f6171k;
    }

    /* renamed from: a */
    public ax m9476a(bg bgVar) {
        this.f6171k = bgVar;
        return this;
    }

    /* renamed from: I */
    public void m9468I() {
        this.f6171k = null;
    }

    /* renamed from: J */
    public boolean m9469J() {
        return this.f6171k != null;
    }

    /* renamed from: k */
    public void m9507k(boolean z) {
        if (!z) {
            this.f6171k = null;
        }
    }

    /* renamed from: d */
    public C1365e m9489d(int i) {
        return C1365e.m9441a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6157y.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6157y.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("MiscInfo(");
        Object obj2 = 1;
        if (m9495e()) {
            stringBuilder.append("time_zone:");
            stringBuilder.append(this.f6161a);
            obj2 = null;
        }
        if (m9503i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("language:");
            if (this.f6162b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6162b);
            }
            obj2 = null;
        }
        if (m9508l()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("country:");
            if (this.f6163c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6163c);
            }
            obj2 = null;
        }
        if (m9511o()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("latitude:");
            stringBuilder.append(this.f6164d);
            obj2 = null;
        }
        if (m9514r()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("longitude:");
            stringBuilder.append(this.f6165e);
            obj2 = null;
        }
        if (m9517u()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("carrier:");
            if (this.f6166f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6166f);
            }
            obj2 = null;
        }
        if (m9520x()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("latency:");
            stringBuilder.append(this.f6167g);
            obj2 = null;
        }
        if (m9460A()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("display_name:");
            if (this.f6168h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6168h);
            }
            obj2 = null;
        }
        if (m9463D()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("access_type:");
            if (this.f6169i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6169i);
            }
            obj2 = null;
        }
        if (m9466G()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("access_subtype:");
            if (this.f6170j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6170j);
            }
        } else {
            obj = obj2;
        }
        if (m9469J()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("user_info:");
            if (this.f6171k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6171k);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: K */
    public void m9470K() throws cf {
        if (this.f6171k != null) {
            this.f6171k.m9881p();
        }
    }

    /* renamed from: a */
    private void m9459a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9458a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6159D = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
