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

/* compiled from: Response */
/* renamed from: u.aly.bb */
public class bb implements Serializable, Cloneable, bz<bb, C1386e> {
    /* renamed from: d */
    public static final Map<C1386e, cl> f6217d;
    /* renamed from: e */
    private static final dd f6218e = new dd("Response");
    /* renamed from: f */
    private static final ct f6219f = new ct("resp_code", (byte) 8, (short) 1);
    /* renamed from: g */
    private static final ct f6220g = new ct(C0110c.f286b, (byte) 11, (short) 2);
    /* renamed from: h */
    private static final ct f6221h = new ct("imprint", (byte) 12, (short) 3);
    /* renamed from: i */
    private static final Map<Class<? extends dg>, dh> f6222i = new HashMap();
    /* renamed from: j */
    private static final int f6223j = 0;
    /* renamed from: a */
    public int f6224a;
    /* renamed from: b */
    public String f6225b;
    /* renamed from: c */
    public at f6226c;
    /* renamed from: k */
    private byte f6227k;
    /* renamed from: l */
    private C1386e[] f6228l;

    /* compiled from: Response */
    /* renamed from: u.aly.bb$a */
    private static class C1382a extends di<bb> {
        private C1382a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9639b(cyVar, (bb) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9637a(cyVar, (bb) bzVar);
        }

        /* renamed from: a */
        public void m9637a(cy cyVar, bb bbVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    if (bbVar.m9674e()) {
                        bbVar.m9682m();
                        return;
                    }
                    throw new cz("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 8) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bbVar.f6224a = cyVar.mo1980w();
                        bbVar.m9665a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bbVar.f6225b = cyVar.mo1983z();
                        bbVar.m9669b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bbVar.f6226c = new at();
                        bbVar.f6226c.mo1921a(cyVar);
                        bbVar.m9672c(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9639b(cy cyVar, bb bbVar) throws cf {
            bbVar.m9682m();
            cyVar.mo1956a(bb.f6218e);
            cyVar.mo1951a(bb.f6219f);
            cyVar.mo1947a(bbVar.f6224a);
            cyVar.mo1960c();
            if (bbVar.f6225b != null && bbVar.m9678i()) {
                cyVar.mo1951a(bb.f6220g);
                cyVar.mo1949a(bbVar.f6225b);
                cyVar.mo1960c();
            }
            if (bbVar.f6226c != null && bbVar.m9681l()) {
                cyVar.mo1951a(bb.f6221h);
                bbVar.f6226c.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: Response */
    /* renamed from: u.aly.bb$b */
    private static class C1383b implements dh {
        private C1383b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9641a();
        }

        /* renamed from: a */
        public C1382a m9641a() {
            return new C1382a();
        }
    }

    /* compiled from: Response */
    /* renamed from: u.aly.bb$c */
    private static class C1384c extends dj<bb> {
        private C1384c() {
        }

        /* renamed from: a */
        public void m9643a(cy cyVar, bb bbVar) throws cf {
            cyVar = (de) cyVar;
            cyVar.mo1947a(bbVar.f6224a);
            BitSet bitSet = new BitSet();
            if (bbVar.m9678i()) {
                bitSet.set(0);
            }
            if (bbVar.m9681l()) {
                bitSet.set(1);
            }
            cyVar.m10341a(bitSet, 2);
            if (bbVar.m9678i()) {
                cyVar.mo1949a(bbVar.f6225b);
            }
            if (bbVar.m9681l()) {
                bbVar.f6226c.mo1924b(cyVar);
            }
        }

        /* renamed from: b */
        public void m9645b(cy cyVar, bb bbVar) throws cf {
            cyVar = (de) cyVar;
            bbVar.f6224a = cyVar.mo1980w();
            bbVar.m9665a(true);
            BitSet b = cyVar.mo1986b(2);
            if (b.get(0)) {
                bbVar.f6225b = cyVar.mo1983z();
                bbVar.m9669b(true);
            }
            if (b.get(1)) {
                bbVar.f6226c = new at();
                bbVar.f6226c.mo1921a(cyVar);
                bbVar.m9672c(true);
            }
        }
    }

    /* compiled from: Response */
    /* renamed from: u.aly.bb$d */
    private static class C1385d implements dh {
        private C1385d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9647a();
        }

        /* renamed from: a */
        public C1384c m9647a() {
            return new C1384c();
        }
    }

    /* compiled from: Response */
    /* renamed from: u.aly.bb$e */
    public enum C1386e implements cg {
        RESP_CODE((short) 1, "resp_code"),
        MSG((short) 2, C0110c.f286b),
        IMPRINT((short) 3, "imprint");
        
        /* renamed from: d */
        private static final Map<String, C1386e> f6213d = null;
        /* renamed from: e */
        private final short f6215e;
        /* renamed from: f */
        private final String f6216f;

        static {
            f6213d = new HashMap();
            Iterator it = EnumSet.allOf(C1386e.class).iterator();
            while (it.hasNext()) {
                C1386e c1386e = (C1386e) it.next();
                f6213d.put(c1386e.mo1932b(), c1386e);
            }
        }

        /* renamed from: a */
        public static C1386e m9649a(int i) {
            switch (i) {
                case 1:
                    return RESP_CODE;
                case 2:
                    return MSG;
                case 3:
                    return IMPRINT;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1386e m9651b(int i) {
            C1386e a = C1386e.m9649a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1386e m9650a(String str) {
            return (C1386e) f6213d.get(str);
        }

        private C1386e(short s, String str) {
            this.f6215e = s;
            this.f6216f = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6215e;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6216f;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9671c(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9660a();
    }

    static {
        f6222i.put(di.class, new C1383b());
        f6222i.put(dj.class, new C1385d());
        Map enumMap = new EnumMap(C1386e.class);
        enumMap.put(C1386e.RESP_CODE, new cl("resp_code", (byte) 1, new cm((byte) 8)));
        enumMap.put(C1386e.MSG, new cl(C0110c.f286b, (byte) 2, new cm((byte) 11)));
        enumMap.put(C1386e.IMPRINT, new cl("imprint", (byte) 2, new cq((byte) 12, at.class)));
        f6217d = Collections.unmodifiableMap(enumMap);
        cl.m10164a(bb.class, f6217d);
    }

    public bb() {
        this.f6227k = (byte) 0;
        this.f6228l = new C1386e[]{C1386e.MSG, C1386e.IMPRINT};
    }

    public bb(int i) {
        this();
        this.f6224a = i;
        m9665a(true);
    }

    public bb(bb bbVar) {
        this.f6227k = (byte) 0;
        this.f6228l = new C1386e[]{C1386e.MSG, C1386e.IMPRINT};
        this.f6227k = bbVar.f6227k;
        this.f6224a = bbVar.f6224a;
        if (bbVar.m9678i()) {
            this.f6225b = bbVar.f6225b;
        }
        if (bbVar.m9681l()) {
            this.f6226c = new at(bbVar.f6226c);
        }
    }

    /* renamed from: a */
    public bb m9660a() {
        return new bb(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        m9665a(false);
        this.f6224a = 0;
        this.f6225b = null;
        this.f6226c = null;
    }

    /* renamed from: c */
    public int m9670c() {
        return this.f6224a;
    }

    /* renamed from: a */
    public bb m9661a(int i) {
        this.f6224a = i;
        m9665a(true);
        return this;
    }

    /* renamed from: d */
    public void m9673d() {
        this.f6227k = bw.m10080b(this.f6227k, 0);
    }

    /* renamed from: e */
    public boolean m9674e() {
        return bw.m10076a(this.f6227k, 0);
    }

    /* renamed from: a */
    public void m9665a(boolean z) {
        this.f6227k = bw.m10068a(this.f6227k, 0, z);
    }

    /* renamed from: f */
    public String m9675f() {
        return this.f6225b;
    }

    /* renamed from: a */
    public bb m9662a(String str) {
        this.f6225b = str;
        return this;
    }

    /* renamed from: h */
    public void m9677h() {
        this.f6225b = null;
    }

    /* renamed from: i */
    public boolean m9678i() {
        return this.f6225b != null;
    }

    /* renamed from: b */
    public void m9669b(boolean z) {
        if (!z) {
            this.f6225b = null;
        }
    }

    /* renamed from: j */
    public at m9679j() {
        return this.f6226c;
    }

    /* renamed from: a */
    public bb m9663a(at atVar) {
        this.f6226c = atVar;
        return this;
    }

    /* renamed from: k */
    public void m9680k() {
        this.f6226c = null;
    }

    /* renamed from: l */
    public boolean m9681l() {
        return this.f6226c != null;
    }

    /* renamed from: c */
    public void m9672c(boolean z) {
        if (!z) {
            this.f6226c = null;
        }
    }

    /* renamed from: c */
    public C1386e m9671c(int i) {
        return C1386e.m9649a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6222i.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6222i.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response(");
        stringBuilder.append("resp_code:");
        stringBuilder.append(this.f6224a);
        if (m9678i()) {
            stringBuilder.append(", ");
            stringBuilder.append("msg:");
            if (this.f6225b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6225b);
            }
        }
        if (m9681l()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.f6226c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6226c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: m */
    public void m9682m() throws cf {
        if (this.f6226c != null) {
            this.f6226c.m9275n();
        }
    }

    /* renamed from: a */
    private void m9655a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9654a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f6227k = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
