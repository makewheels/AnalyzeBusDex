package p054u.aly;

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

/* compiled from: IdJournal */
/* renamed from: u.aly.aq */
public class aq implements Serializable, Cloneable, bz<aq, C1323e> {
    /* renamed from: e */
    public static final Map<C1323e, cl> f5999e;
    /* renamed from: f */
    private static final dd f6000f = new dd("IdJournal");
    /* renamed from: g */
    private static final ct f6001g = new ct(SpeechConstant.DOMAIN, (byte) 11, (short) 1);
    /* renamed from: h */
    private static final ct f6002h = new ct("old_id", (byte) 11, (short) 2);
    /* renamed from: i */
    private static final ct f6003i = new ct("new_id", (byte) 11, (short) 3);
    /* renamed from: j */
    private static final ct f6004j = new ct("ts", (byte) 10, (short) 4);
    /* renamed from: k */
    private static final Map<Class<? extends dg>, dh> f6005k = new HashMap();
    /* renamed from: l */
    private static final int f6006l = 0;
    /* renamed from: a */
    public String f6007a;
    /* renamed from: b */
    public String f6008b;
    /* renamed from: c */
    public String f6009c;
    /* renamed from: d */
    public long f6010d;
    /* renamed from: m */
    private byte f6011m;
    /* renamed from: n */
    private C1323e[] f6012n;

    /* compiled from: IdJournal */
    /* renamed from: u.aly.aq$a */
    private static class C1319a extends di<aq> {
        private C1319a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9081b(cyVar, (aq) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9079a(cyVar, (aq) bzVar);
        }

        /* renamed from: a */
        public void m9079a(cy cyVar, aq aqVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (aqVar.m9129o()) {
                        aqVar.m9130p();
                        return;
                    }
                    throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aqVar.f6007a = cyVar.mo1983z();
                        aqVar.m9108a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aqVar.f6008b = cyVar.mo1983z();
                        aqVar.m9113b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aqVar.f6009c = cyVar.mo1983z();
                        aqVar.m9116c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        aqVar.f6010d = cyVar.mo1981x();
                        aqVar.m9118d(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9081b(cy cyVar, aq aqVar) throws cf {
            aqVar.m9130p();
            cyVar.mo1956a(aq.f6000f);
            if (aqVar.f6007a != null) {
                cyVar.mo1951a(aq.f6001g);
                cyVar.mo1949a(aqVar.f6007a);
                cyVar.mo1960c();
            }
            if (aqVar.f6008b != null && aqVar.m9123i()) {
                cyVar.mo1951a(aq.f6002h);
                cyVar.mo1949a(aqVar.f6008b);
                cyVar.mo1960c();
            }
            if (aqVar.f6009c != null) {
                cyVar.mo1951a(aq.f6003i);
                cyVar.mo1949a(aqVar.f6009c);
                cyVar.mo1960c();
            }
            cyVar.mo1951a(aq.f6004j);
            cyVar.mo1948a(aqVar.f6010d);
            cyVar.mo1960c();
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: IdJournal */
    /* renamed from: u.aly.aq$b */
    private static class C1320b implements dh {
        private C1320b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9083a();
        }

        /* renamed from: a */
        public C1319a m9083a() {
            return new C1319a();
        }
    }

    /* compiled from: IdJournal */
    /* renamed from: u.aly.aq$c */
    private static class C1321c extends dj<aq> {
        private C1321c() {
        }

        /* renamed from: a */
        public void m9085a(cy cyVar, aq aqVar) throws cf {
            de deVar = (de) cyVar;
            deVar.mo1949a(aqVar.f6007a);
            deVar.mo1949a(aqVar.f6009c);
            deVar.mo1948a(aqVar.f6010d);
            BitSet bitSet = new BitSet();
            if (aqVar.m9123i()) {
                bitSet.set(0);
            }
            deVar.m10341a(bitSet, 1);
            if (aqVar.m9123i()) {
                deVar.mo1949a(aqVar.f6008b);
            }
        }

        /* renamed from: b */
        public void m9087b(cy cyVar, aq aqVar) throws cf {
            de deVar = (de) cyVar;
            aqVar.f6007a = deVar.mo1983z();
            aqVar.m9108a(true);
            aqVar.f6009c = deVar.mo1983z();
            aqVar.m9116c(true);
            aqVar.f6010d = deVar.mo1981x();
            aqVar.m9118d(true);
            if (deVar.mo1986b(1).get(0)) {
                aqVar.f6008b = deVar.mo1983z();
                aqVar.m9113b(true);
            }
        }
    }

    /* compiled from: IdJournal */
    /* renamed from: u.aly.aq$d */
    private static class C1322d implements dh {
        private C1322d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9089a();
        }

        /* renamed from: a */
        public C1321c m9089a() {
            return new C1321c();
        }
    }

    /* compiled from: IdJournal */
    /* renamed from: u.aly.aq$e */
    public enum C1323e implements cg {
        DOMAIN((short) 1, SpeechConstant.DOMAIN),
        OLD_ID((short) 2, "old_id"),
        NEW_ID((short) 3, "new_id"),
        TS((short) 4, "ts");
        
        /* renamed from: e */
        private static final Map<String, C1323e> f5995e = null;
        /* renamed from: f */
        private final short f5997f;
        /* renamed from: g */
        private final String f5998g;

        static {
            f5995e = new HashMap();
            Iterator it = EnumSet.allOf(C1323e.class).iterator();
            while (it.hasNext()) {
                C1323e c1323e = (C1323e) it.next();
                f5995e.put(c1323e.mo1932b(), c1323e);
            }
        }

        /* renamed from: a */
        public static C1323e m9091a(int i) {
            switch (i) {
                case 1:
                    return DOMAIN;
                case 2:
                    return OLD_ID;
                case 3:
                    return NEW_ID;
                case 4:
                    return TS;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1323e m9093b(int i) {
            C1323e a = C1323e.m9091a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1323e m9092a(String str) {
            return (C1323e) f5995e.get(str);
        }

        private C1323e(short s, String str) {
            this.f5997f = s;
            this.f5998g = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5997f;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5998g;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9103a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9104a();
    }

    static {
        f6005k.put(di.class, new C1320b());
        f6005k.put(dj.class, new C1322d());
        Map enumMap = new EnumMap(C1323e.class);
        enumMap.put(C1323e.DOMAIN, new cl(SpeechConstant.DOMAIN, (byte) 1, new cm((byte) 11)));
        enumMap.put(C1323e.OLD_ID, new cl("old_id", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1323e.NEW_ID, new cl("new_id", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1323e.TS, new cl("ts", (byte) 1, new cm((byte) 10)));
        f5999e = Collections.unmodifiableMap(enumMap);
        cl.m10164a(aq.class, f5999e);
    }

    public aq() {
        this.f6011m = (byte) 0;
        this.f6012n = new C1323e[]{C1323e.OLD_ID};
    }

    public aq(String str, String str2, long j) {
        this();
        this.f6007a = str;
        this.f6009c = str2;
        this.f6010d = j;
        m9118d(true);
    }

    public aq(aq aqVar) {
        this.f6011m = (byte) 0;
        this.f6012n = new C1323e[]{C1323e.OLD_ID};
        this.f6011m = aqVar.f6011m;
        if (aqVar.m9119e()) {
            this.f6007a = aqVar.f6007a;
        }
        if (aqVar.m9123i()) {
            this.f6008b = aqVar.f6008b;
        }
        if (aqVar.m9126l()) {
            this.f6009c = aqVar.f6009c;
        }
        this.f6010d = aqVar.f6010d;
    }

    /* renamed from: a */
    public aq m9104a() {
        return new aq(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6007a = null;
        this.f6008b = null;
        this.f6009c = null;
        m9118d(false);
        this.f6010d = 0;
    }

    /* renamed from: c */
    public String m9114c() {
        return this.f6007a;
    }

    /* renamed from: a */
    public aq m9106a(String str) {
        this.f6007a = str;
        return this;
    }

    /* renamed from: d */
    public void m9117d() {
        this.f6007a = null;
    }

    /* renamed from: e */
    public boolean m9119e() {
        return this.f6007a != null;
    }

    /* renamed from: a */
    public void m9108a(boolean z) {
        if (!z) {
            this.f6007a = null;
        }
    }

    /* renamed from: f */
    public String m9120f() {
        return this.f6008b;
    }

    /* renamed from: b */
    public aq m9109b(String str) {
        this.f6008b = str;
        return this;
    }

    /* renamed from: h */
    public void m9122h() {
        this.f6008b = null;
    }

    /* renamed from: i */
    public boolean m9123i() {
        return this.f6008b != null;
    }

    /* renamed from: b */
    public void m9113b(boolean z) {
        if (!z) {
            this.f6008b = null;
        }
    }

    /* renamed from: j */
    public String m9124j() {
        return this.f6009c;
    }

    /* renamed from: c */
    public aq m9115c(String str) {
        this.f6009c = str;
        return this;
    }

    /* renamed from: k */
    public void m9125k() {
        this.f6009c = null;
    }

    /* renamed from: l */
    public boolean m9126l() {
        return this.f6009c != null;
    }

    /* renamed from: c */
    public void m9116c(boolean z) {
        if (!z) {
            this.f6009c = null;
        }
    }

    /* renamed from: m */
    public long m9127m() {
        return this.f6010d;
    }

    /* renamed from: a */
    public aq m9105a(long j) {
        this.f6010d = j;
        m9118d(true);
        return this;
    }

    /* renamed from: n */
    public void m9128n() {
        this.f6011m = bw.m10080b(this.f6011m, 0);
    }

    /* renamed from: o */
    public boolean m9129o() {
        return bw.m10076a(this.f6011m, 0);
    }

    /* renamed from: d */
    public void m9118d(boolean z) {
        this.f6011m = bw.m10068a(this.f6011m, 0, z);
    }

    /* renamed from: a */
    public C1323e m9103a(int i) {
        return C1323e.m9091a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6005k.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6005k.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdJournal(");
        stringBuilder.append("domain:");
        if (this.f6007a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6007a);
        }
        if (m9123i()) {
            stringBuilder.append(", ");
            stringBuilder.append("old_id:");
            if (this.f6008b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6008b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("new_id:");
        if (this.f6009c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6009c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f6010d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: p */
    public void m9130p() throws cf {
        if (this.f6007a == null) {
            throw new cz("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.f6009c == null) {
            throw new cz("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m9097a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9096a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6011m = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
