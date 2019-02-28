package p054u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: PropertyValue */
/* renamed from: u.aly.az */
public class az extends cj<az, C1373a> {
    /* renamed from: a */
    public static final Map<C1373a, cl> f6188a;
    /* renamed from: d */
    private static final dd f6189d = new dd("PropertyValue");
    /* renamed from: e */
    private static final ct f6190e = new ct("string_value", (byte) 11, (short) 1);
    /* renamed from: f */
    private static final ct f6191f = new ct("long_value", (byte) 10, (short) 2);

    /* compiled from: PropertyValue */
    /* renamed from: u.aly.az$a */
    public enum C1373a implements cg {
        STRING_VALUE((short) 1, "string_value"),
        LONG_VALUE((short) 2, "long_value");
        
        /* renamed from: c */
        private static final Map<String, C1373a> f6181c = null;
        /* renamed from: d */
        private final short f6183d;
        /* renamed from: e */
        private final String f6184e;

        static {
            f6181c = new HashMap();
            Iterator it = EnumSet.allOf(C1373a.class).iterator();
            while (it.hasNext()) {
                C1373a c1373a = (C1373a) it.next();
                f6181c.put(c1373a.mo1932b(), c1373a);
            }
        }

        /* renamed from: a */
        public static C1373a m9540a(int i) {
            switch (i) {
                case 1:
                    return STRING_VALUE;
                case 2:
                    return LONG_VALUE;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1373a m9542b(int i) {
            C1373a a = C1373a.m9540a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1373a m9541a(String str) {
            return (C1373a) f6181c.get(str);
        }

        private C1373a(short s, String str) {
            this.f6183d = s;
            this.f6184e = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6183d;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6184e;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9575a(i);
    }

    /* renamed from: b */
    protected /* synthetic */ cg mo1937b(short s) {
        return m9576a(s);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9577a();
    }

    static {
        Map enumMap = new EnumMap(C1373a.class);
        enumMap.put(C1373a.STRING_VALUE, new cl("string_value", (byte) 3, new cm((byte) 11)));
        enumMap.put(C1373a.LONG_VALUE, new cl("long_value", (byte) 3, new cm((byte) 10)));
        f6188a = Collections.unmodifiableMap(enumMap);
        cl.m10164a(az.class, f6188a);
    }

    public az(C1373a c1373a, Object obj) {
        super(c1373a, obj);
    }

    public az(az azVar) {
        super(azVar);
    }

    /* renamed from: a */
    public az m9577a() {
        return new az(this);
    }

    /* renamed from: a */
    public static az m9570a(String str) {
        az azVar = new az();
        azVar.m9587b(str);
        return azVar;
    }

    /* renamed from: a */
    public static az m9569a(long j) {
        az azVar = new az();
        azVar.m9586b(j);
        return azVar;
    }

    /* renamed from: a */
    protected void m9580a(C1373a c1373a, Object obj) throws ClassCastException {
        switch (c1373a) {
            case STRING_VALUE:
                if (!(obj instanceof String)) {
                    throw new ClassCastException("Was expecting value of type String for field 'string_value', but got " + obj.getClass().getSimpleName());
                }
                return;
            case LONG_VALUE:
                if (!(obj instanceof Long)) {
                    throw new ClassCastException("Was expecting value of type Long for field 'long_value', but got " + obj.getClass().getSimpleName());
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown field id " + c1373a);
        }
    }

    /* renamed from: a */
    protected Object mo1933a(cy cyVar, ct ctVar) throws cf {
        C1373a a = C1373a.m9540a(ctVar.f6486c);
        if (a == null) {
            return null;
        }
        switch (a) {
            case STRING_VALUE:
                if (ctVar.f6485b == f6190e.f6485b) {
                    return cyVar.mo1983z();
                }
                db.m10335a(cyVar, ctVar.f6485b);
                return null;
            case LONG_VALUE:
                if (ctVar.f6485b == f6191f.f6485b) {
                    return Long.valueOf(cyVar.mo1981x());
                }
                db.m10335a(cyVar, ctVar.f6485b);
                return null;
            default:
                throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
        }
    }

    /* renamed from: c */
    protected void mo1939c(cy cyVar) throws cf {
        switch ((C1373a) this.c) {
            case STRING_VALUE:
                cyVar.mo1949a((String) this.b);
                return;
            case LONG_VALUE:
                cyVar.mo1948a(((Long) this.b).longValue());
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
        }
    }

    /* renamed from: a */
    protected Object mo1934a(cy cyVar, short s) throws cf {
        C1373a a = C1373a.m9540a((int) s);
        if (a != null) {
            switch (a) {
                case STRING_VALUE:
                    return cyVar.mo1983z();
                case LONG_VALUE:
                    return Long.valueOf(cyVar.mo1981x());
                default:
                    throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
            }
        }
        throw new cz("Couldn't find a field with field id " + s);
    }

    /* renamed from: d */
    protected void mo1940d(cy cyVar) throws cf {
        switch ((C1373a) this.c) {
            case STRING_VALUE:
                cyVar.mo1949a((String) this.b);
                return;
            case LONG_VALUE:
                cyVar.mo1948a(((Long) this.b).longValue());
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
        }
    }

    /* renamed from: a */
    protected ct m9578a(C1373a c1373a) {
        switch (c1373a) {
            case STRING_VALUE:
                return f6190e;
            case LONG_VALUE:
                return f6191f;
            default:
                throw new IllegalArgumentException("Unknown field id " + c1373a);
        }
    }

    /* renamed from: c */
    protected dd mo1938c() {
        return f6189d;
    }

    /* renamed from: a */
    protected C1373a m9576a(short s) {
        return C1373a.m9542b(s);
    }

    /* renamed from: a */
    public C1373a m9575a(int i) {
        return C1373a.m9540a(i);
    }

    /* renamed from: d */
    public String m9590d() {
        if (m9566i() == C1373a.STRING_VALUE) {
            return (String) m9567j();
        }
        throw new RuntimeException("Cannot get field 'string_value' because union is currently set to " + m9578a((C1373a) m9566i()).f6484a);
    }

    /* renamed from: b */
    public void m9587b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.c = C1373a.STRING_VALUE;
        this.b = str;
    }

    /* renamed from: e */
    public long m9592e() {
        if (m9566i() == C1373a.LONG_VALUE) {
            return ((Long) m9567j()).longValue();
        }
        throw new RuntimeException("Cannot get field 'long_value' because union is currently set to " + m9578a((C1373a) m9566i()).f6484a);
    }

    /* renamed from: b */
    public void m9586b(long j) {
        this.c = C1373a.LONG_VALUE;
        this.b = Long.valueOf(j);
    }

    /* renamed from: f */
    public boolean m9593f() {
        return this.c == C1373a.STRING_VALUE;
    }

    /* renamed from: h */
    public boolean m9595h() {
        return this.c == C1373a.LONG_VALUE;
    }

    public boolean equals(Object obj) {
        if (obj instanceof az) {
            return m9582a((az) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m9582a(az azVar) {
        return azVar != null && m9566i() == azVar.m9566i() && m9567j().equals(azVar.m9567j());
    }

    /* renamed from: b */
    public int m9583b(az azVar) {
        int a = ca.m10108a((Comparable) m9566i(), (Comparable) azVar.m9566i());
        if (a == 0) {
            return ca.m10109a(m9567j(), azVar.m9567j());
        }
        return a;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: a */
    private void m9572a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9571a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
