package p054u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: UMEnvelope */
/* renamed from: u.aly.bh */
public class bh implements Serializable, Cloneable, bz<bh, C1416e> {
    /* renamed from: j */
    public static final Map<C1416e, cl> f6332j;
    /* renamed from: k */
    private static final dd f6333k = new dd("UMEnvelope");
    /* renamed from: l */
    private static final ct f6334l = new ct("version", (byte) 11, (short) 1);
    /* renamed from: m */
    private static final ct f6335m = new ct("address", (byte) 11, (short) 2);
    /* renamed from: n */
    private static final ct f6336n = new ct("signature", (byte) 11, (short) 3);
    /* renamed from: o */
    private static final ct f6337o = new ct("serial_num", (byte) 8, (short) 4);
    /* renamed from: p */
    private static final ct f6338p = new ct("ts_secs", (byte) 8, (short) 5);
    /* renamed from: q */
    private static final ct f6339q = new ct("length", (byte) 8, (short) 6);
    /* renamed from: r */
    private static final ct f6340r = new ct("entity", (byte) 11, (short) 7);
    /* renamed from: s */
    private static final ct f6341s = new ct("guid", (byte) 11, (short) 8);
    /* renamed from: t */
    private static final ct f6342t = new ct("checksum", (byte) 11, (short) 9);
    /* renamed from: u */
    private static final Map<Class<? extends dg>, dh> f6343u = new HashMap();
    /* renamed from: v */
    private static final int f6344v = 0;
    /* renamed from: w */
    private static final int f6345w = 1;
    /* renamed from: x */
    private static final int f6346x = 2;
    /* renamed from: a */
    public String f6347a;
    /* renamed from: b */
    public String f6348b;
    /* renamed from: c */
    public String f6349c;
    /* renamed from: d */
    public int f6350d;
    /* renamed from: e */
    public int f6351e;
    /* renamed from: f */
    public int f6352f;
    /* renamed from: g */
    public ByteBuffer f6353g;
    /* renamed from: h */
    public String f6354h;
    /* renamed from: i */
    public String f6355i;
    /* renamed from: y */
    private byte f6356y;

    /* compiled from: UMEnvelope */
    /* renamed from: u.aly.bh$a */
    private static class C1412a extends di<bh> {
        private C1412a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9884b(cyVar, (bh) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9882a(cyVar, (bh) bzVar);
        }

        /* renamed from: a */
        public void m9882a(cy cyVar, bh bhVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (!bhVar.m9954o()) {
                        throw new cz("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!bhVar.m9957r()) {
                        throw new cz("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (bhVar.m9960u()) {
                        bhVar.m9916F();
                        return;
                    } else {
                        throw new cz("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6347a = cyVar.mo1983z();
                        bhVar.m9923a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6348b = cyVar.mo1983z();
                        bhVar.m9928b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6349c = cyVar.mo1983z();
                        bhVar.m9932c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6350d = cyVar.mo1980w();
                        bhVar.m9936d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6351e = cyVar.mo1980w();
                        bhVar.m9939e(true);
                        break;
                    case (short) 6:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6352f = cyVar.mo1980w();
                        bhVar.m9942f(true);
                        break;
                    case (short) 7:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6353g = cyVar.mo1943A();
                        bhVar.m9944g(true);
                        break;
                    case (short) 8:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6354h = cyVar.mo1983z();
                        bhVar.m9946h(true);
                        break;
                    case (short) 9:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bhVar.f6355i = cyVar.mo1983z();
                        bhVar.m9947i(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9884b(cy cyVar, bh bhVar) throws cf {
            bhVar.m9916F();
            cyVar.mo1956a(bh.f6333k);
            if (bhVar.f6347a != null) {
                cyVar.mo1951a(bh.f6334l);
                cyVar.mo1949a(bhVar.f6347a);
                cyVar.mo1960c();
            }
            if (bhVar.f6348b != null) {
                cyVar.mo1951a(bh.f6335m);
                cyVar.mo1949a(bhVar.f6348b);
                cyVar.mo1960c();
            }
            if (bhVar.f6349c != null) {
                cyVar.mo1951a(bh.f6336n);
                cyVar.mo1949a(bhVar.f6349c);
                cyVar.mo1960c();
            }
            cyVar.mo1951a(bh.f6337o);
            cyVar.mo1947a(bhVar.f6350d);
            cyVar.mo1960c();
            cyVar.mo1951a(bh.f6338p);
            cyVar.mo1947a(bhVar.f6351e);
            cyVar.mo1960c();
            cyVar.mo1951a(bh.f6339q);
            cyVar.mo1947a(bhVar.f6352f);
            cyVar.mo1960c();
            if (bhVar.f6353g != null) {
                cyVar.mo1951a(bh.f6340r);
                cyVar.mo1950a(bhVar.f6353g);
                cyVar.mo1960c();
            }
            if (bhVar.f6354h != null) {
                cyVar.mo1951a(bh.f6341s);
                cyVar.mo1949a(bhVar.f6354h);
                cyVar.mo1960c();
            }
            if (bhVar.f6355i != null) {
                cyVar.mo1951a(bh.f6342t);
                cyVar.mo1949a(bhVar.f6355i);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: UMEnvelope */
    /* renamed from: u.aly.bh$b */
    private static class C1413b implements dh {
        private C1413b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9886a();
        }

        /* renamed from: a */
        public C1412a m9886a() {
            return new C1412a();
        }
    }

    /* compiled from: UMEnvelope */
    /* renamed from: u.aly.bh$c */
    private static class C1414c extends dj<bh> {
        private C1414c() {
        }

        /* renamed from: a */
        public void m9888a(cy cyVar, bh bhVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1949a(bhVar.f6347a);
            deVar.mo1949a(bhVar.f6348b);
            deVar.mo1949a(bhVar.f6349c);
            deVar.mo1947a(bhVar.f6350d);
            deVar.mo1947a(bhVar.f6351e);
            deVar.mo1947a(bhVar.f6352f);
            deVar.mo1950a(bhVar.f6353g);
            deVar.mo1949a(bhVar.f6354h);
            deVar.mo1949a(bhVar.f6355i);
        }

        /* renamed from: b */
        public void m9890b(cy cyVar, bh bhVar) throws cf {
            de deVar = (de) cyVar;
            bhVar.f6347a = deVar.mo1983z();
            bhVar.m9923a(true);
            bhVar.f6348b = deVar.mo1983z();
            bhVar.m9928b(true);
            bhVar.f6349c = deVar.mo1983z();
            bhVar.m9932c(true);
            bhVar.f6350d = deVar.mo1980w();
            bhVar.m9936d(true);
            bhVar.f6351e = deVar.mo1980w();
            bhVar.m9939e(true);
            bhVar.f6352f = deVar.mo1980w();
            bhVar.m9942f(true);
            bhVar.f6353g = deVar.mo1943A();
            bhVar.m9944g(true);
            bhVar.f6354h = deVar.mo1983z();
            bhVar.m9946h(true);
            bhVar.f6355i = deVar.mo1983z();
            bhVar.m9947i(true);
        }
    }

    /* compiled from: UMEnvelope */
    /* renamed from: u.aly.bh$d */
    private static class C1415d implements dh {
        private C1415d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9892a();
        }

        /* renamed from: a */
        public C1414c m9892a() {
            return new C1414c();
        }
    }

    /* compiled from: UMEnvelope */
    /* renamed from: u.aly.bh$e */
    public enum C1416e implements cg {
        VERSION((short) 1, "version"),
        ADDRESS((short) 2, "address"),
        SIGNATURE((short) 3, "signature"),
        SERIAL_NUM((short) 4, "serial_num"),
        TS_SECS((short) 5, "ts_secs"),
        LENGTH((short) 6, "length"),
        ENTITY((short) 7, "entity"),
        GUID((short) 8, "guid"),
        CHECKSUM((short) 9, "checksum");
        
        /* renamed from: j */
        private static final Map<String, C1416e> f6328j = null;
        /* renamed from: k */
        private final short f6330k;
        /* renamed from: l */
        private final String f6331l;

        static {
            f6328j = new HashMap();
            Iterator it = EnumSet.allOf(C1416e.class).iterator();
            while (it.hasNext()) {
                C1416e c1416e = (C1416e) it.next();
                f6328j.put(c1416e.mo1932b(), c1416e);
            }
        }

        /* renamed from: a */
        public static C1416e m9894a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1416e m9896b(int i) {
            C1416e a = C1416e.m9894a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1416e m9895a(String str) {
            return (C1416e) f6328j.get(str);
        }

        private C1416e(short s, String str) {
            this.f6330k = s;
            this.f6331l = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6330k;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6331l;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9937e(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9917a();
    }

    static {
        f6343u.put(di.class, new C1413b());
        f6343u.put(dj.class, new C1415d());
        Map enumMap = new EnumMap(C1416e.class);
        enumMap.put(C1416e.VERSION, new cl("version", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1416e.ADDRESS, new cl("address", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1416e.SIGNATURE, new cl("signature", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1416e.SERIAL_NUM, new cl("serial_num", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1416e.TS_SECS, new cl("ts_secs", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1416e.LENGTH, new cl("length", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1416e.ENTITY, new cl("entity", (byte) 1, new cm((byte) 11, true)));
        enumMap.put(C1416e.GUID, new cl("guid", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1416e.CHECKSUM, new cl("checksum", (byte) 1, new cm((byte) 11)));
        f6332j = Collections.unmodifiableMap(enumMap);
        cl.m10164a(bh.class, f6332j);
    }

    public bh() {
        this.f6356y = (byte) 0;
    }

    public bh(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f6347a = str;
        this.f6348b = str2;
        this.f6349c = str3;
        this.f6350d = i;
        m9936d(true);
        this.f6351e = i2;
        m9939e(true);
        this.f6352f = i3;
        m9942f(true);
        this.f6353g = byteBuffer;
        this.f6354h = str4;
        this.f6355i = str5;
    }

    public bh(bh bhVar) {
        this.f6356y = (byte) 0;
        this.f6356y = bhVar.f6356y;
        if (bhVar.m9940e()) {
            this.f6347a = bhVar.f6347a;
        }
        if (bhVar.m9948i()) {
            this.f6348b = bhVar.f6348b;
        }
        if (bhVar.m9951l()) {
            this.f6349c = bhVar.f6349c;
        }
        this.f6350d = bhVar.f6350d;
        this.f6351e = bhVar.f6351e;
        this.f6352f = bhVar.f6352f;
        if (bhVar.m9964y()) {
            this.f6353g = ca.m10124d(bhVar.f6353g);
        }
        if (bhVar.m9912B()) {
            this.f6354h = bhVar.f6354h;
        }
        if (bhVar.m9915E()) {
            this.f6355i = bhVar.f6355i;
        }
    }

    /* renamed from: a */
    public bh m9917a() {
        return new bh(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6347a = null;
        this.f6348b = null;
        this.f6349c = null;
        m9936d(false);
        this.f6350d = 0;
        m9939e(false);
        this.f6351e = 0;
        m9942f(false);
        this.f6352f = 0;
        this.f6353g = null;
        this.f6354h = null;
        this.f6355i = null;
    }

    /* renamed from: c */
    public String m9929c() {
        return this.f6347a;
    }

    /* renamed from: a */
    public bh m9919a(String str) {
        this.f6347a = str;
        return this;
    }

    /* renamed from: d */
    public void m9935d() {
        this.f6347a = null;
    }

    /* renamed from: e */
    public boolean m9940e() {
        return this.f6347a != null;
    }

    /* renamed from: a */
    public void m9923a(boolean z) {
        if (!z) {
            this.f6347a = null;
        }
    }

    /* renamed from: f */
    public String m9941f() {
        return this.f6348b;
    }

    /* renamed from: b */
    public bh m9924b(String str) {
        this.f6348b = str;
        return this;
    }

    /* renamed from: h */
    public void m9945h() {
        this.f6348b = null;
    }

    /* renamed from: i */
    public boolean m9948i() {
        return this.f6348b != null;
    }

    /* renamed from: b */
    public void m9928b(boolean z) {
        if (!z) {
            this.f6348b = null;
        }
    }

    /* renamed from: j */
    public String m9949j() {
        return this.f6349c;
    }

    /* renamed from: c */
    public bh m9931c(String str) {
        this.f6349c = str;
        return this;
    }

    /* renamed from: k */
    public void m9950k() {
        this.f6349c = null;
    }

    /* renamed from: l */
    public boolean m9951l() {
        return this.f6349c != null;
    }

    /* renamed from: c */
    public void m9932c(boolean z) {
        if (!z) {
            this.f6349c = null;
        }
    }

    /* renamed from: m */
    public int m9952m() {
        return this.f6350d;
    }

    /* renamed from: a */
    public bh m9918a(int i) {
        this.f6350d = i;
        m9936d(true);
        return this;
    }

    /* renamed from: n */
    public void m9953n() {
        this.f6356y = bw.m10080b(this.f6356y, 0);
    }

    /* renamed from: o */
    public boolean m9954o() {
        return bw.m10076a(this.f6356y, 0);
    }

    /* renamed from: d */
    public void m9936d(boolean z) {
        this.f6356y = bw.m10068a(this.f6356y, 0, z);
    }

    /* renamed from: p */
    public int m9955p() {
        return this.f6351e;
    }

    /* renamed from: c */
    public bh m9930c(int i) {
        this.f6351e = i;
        m9939e(true);
        return this;
    }

    /* renamed from: q */
    public void m9956q() {
        this.f6356y = bw.m10080b(this.f6356y, 1);
    }

    /* renamed from: r */
    public boolean m9957r() {
        return bw.m10076a(this.f6356y, 1);
    }

    /* renamed from: e */
    public void m9939e(boolean z) {
        this.f6356y = bw.m10068a(this.f6356y, 1, z);
    }

    /* renamed from: s */
    public int m9958s() {
        return this.f6352f;
    }

    /* renamed from: d */
    public bh m9933d(int i) {
        this.f6352f = i;
        m9942f(true);
        return this;
    }

    /* renamed from: t */
    public void m9959t() {
        this.f6356y = bw.m10080b(this.f6356y, 2);
    }

    /* renamed from: u */
    public boolean m9960u() {
        return bw.m10076a(this.f6356y, 2);
    }

    /* renamed from: f */
    public void m9942f(boolean z) {
        this.f6356y = bw.m10068a(this.f6356y, 2, z);
    }

    /* renamed from: v */
    public byte[] m9961v() {
        m9920a(ca.m10123c(this.f6353g));
        return this.f6353g == null ? null : this.f6353g.array();
    }

    /* renamed from: w */
    public ByteBuffer m9962w() {
        return this.f6353g;
    }

    /* renamed from: a */
    public bh m9921a(byte[] bArr) {
        m9920a(bArr == null ? (ByteBuffer) null : ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public bh m9920a(ByteBuffer byteBuffer) {
        this.f6353g = byteBuffer;
        return this;
    }

    /* renamed from: x */
    public void m9963x() {
        this.f6353g = null;
    }

    /* renamed from: y */
    public boolean m9964y() {
        return this.f6353g != null;
    }

    /* renamed from: g */
    public void m9944g(boolean z) {
        if (!z) {
            this.f6353g = null;
        }
    }

    /* renamed from: z */
    public String m9965z() {
        return this.f6354h;
    }

    /* renamed from: d */
    public bh m9934d(String str) {
        this.f6354h = str;
        return this;
    }

    /* renamed from: A */
    public void m9911A() {
        this.f6354h = null;
    }

    /* renamed from: B */
    public boolean m9912B() {
        return this.f6354h != null;
    }

    /* renamed from: h */
    public void m9946h(boolean z) {
        if (!z) {
            this.f6354h = null;
        }
    }

    /* renamed from: C */
    public String m9913C() {
        return this.f6355i;
    }

    /* renamed from: e */
    public bh m9938e(String str) {
        this.f6355i = str;
        return this;
    }

    /* renamed from: D */
    public void m9914D() {
        this.f6355i = null;
    }

    /* renamed from: E */
    public boolean m9915E() {
        return this.f6355i != null;
    }

    /* renamed from: i */
    public void m9947i(boolean z) {
        if (!z) {
            this.f6355i = null;
        }
    }

    /* renamed from: e */
    public C1416e m9937e(int i) {
        return C1416e.m9894a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6343u.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6343u.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UMEnvelope(");
        stringBuilder.append("version:");
        if (this.f6347a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6347a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("address:");
        if (this.f6348b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6348b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("signature:");
        if (this.f6349c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6349c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("serial_num:");
        stringBuilder.append(this.f6350d);
        stringBuilder.append(", ");
        stringBuilder.append("ts_secs:");
        stringBuilder.append(this.f6351e);
        stringBuilder.append(", ");
        stringBuilder.append("length:");
        stringBuilder.append(this.f6352f);
        stringBuilder.append(", ");
        stringBuilder.append("entity:");
        if (this.f6353g == null) {
            stringBuilder.append("null");
        } else {
            ca.m10119a(this.f6353g, stringBuilder);
        }
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.f6354h == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6354h);
        }
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.f6355i == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6355i);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: F */
    public void m9916F() throws cf {
        if (this.f6347a == null) {
            throw new cz("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f6348b == null) {
            throw new cz("Required field 'address' was not present! Struct: " + toString());
        } else if (this.f6349c == null) {
            throw new cz("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.f6353g == null) {
            throw new cz("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.f6354h == null) {
            throw new cz("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.f6355i == null) {
            throw new cz("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m9910a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9909a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6356y = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
