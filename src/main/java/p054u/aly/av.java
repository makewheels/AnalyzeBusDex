package p054u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: InstantMsg */
/* renamed from: u.aly.av */
public class av implements Serializable, Cloneable, bz<av, C1353e> {
    /* renamed from: e */
    public static final Map<C1353e, cl> f6094e;
    /* renamed from: f */
    private static final dd f6095f = new dd("InstantMsg");
    /* renamed from: g */
    private static final ct f6096g = new ct("id", (byte) 11, (short) 1);
    /* renamed from: h */
    private static final ct f6097h = new ct("errors", df.f6529m, (short) 2);
    /* renamed from: i */
    private static final ct f6098i = new ct("events", df.f6529m, (short) 3);
    /* renamed from: j */
    private static final ct f6099j = new ct("game_events", df.f6529m, (short) 4);
    /* renamed from: k */
    private static final Map<Class<? extends dg>, dh> f6100k = new HashMap();
    /* renamed from: a */
    public String f6101a;
    /* renamed from: b */
    public List<am> f6102b;
    /* renamed from: c */
    public List<ao> f6103c;
    /* renamed from: d */
    public List<ao> f6104d;
    /* renamed from: l */
    private C1353e[] f6105l;

    /* compiled from: InstantMsg */
    /* renamed from: u.aly.av$a */
    private static class C1349a extends di<av> {
        private C1349a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9324b(cyVar, (av) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9322a(cyVar, (av) bzVar);
        }

        /* renamed from: a */
        public void m9322a(cy cyVar, av avVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    avVar.m9382v();
                    return;
                }
                cu p;
                int i;
                ao aoVar;
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        avVar.f6101a = cyVar.mo1983z();
                        avVar.m9353a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        p = cyVar.mo1973p();
                        avVar.f6102b = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            am amVar = new am();
                            amVar.mo1921a(cyVar);
                            avVar.f6102b.add(amVar);
                        }
                        cyVar.mo1974q();
                        avVar.m9359b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        p = cyVar.mo1973p();
                        avVar.f6103c = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            aoVar = new ao();
                            aoVar.mo1921a(cyVar);
                            avVar.f6103c.add(aoVar);
                        }
                        cyVar.mo1974q();
                        avVar.m9362c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        p = cyVar.mo1973p();
                        avVar.f6104d = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            aoVar = new ao();
                            aoVar.mo1921a(cyVar);
                            avVar.f6104d.add(aoVar);
                        }
                        cyVar.mo1974q();
                        avVar.m9364d(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9324b(cy cyVar, av avVar) throws cf {
            avVar.m9382v();
            cyVar.mo1956a(av.f6095f);
            if (avVar.f6101a != null) {
                cyVar.mo1951a(av.f6096g);
                cyVar.mo1949a(avVar.f6101a);
                cyVar.mo1960c();
            }
            if (avVar.f6102b != null && avVar.m9371k()) {
                cyVar.mo1951a(av.f6097h);
                cyVar.mo1952a(new cu((byte) 12, avVar.f6102b.size()));
                for (am b : avVar.f6102b) {
                    b.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            if (avVar.f6103c != null && avVar.m9376p()) {
                cyVar.mo1951a(av.f6098i);
                cyVar.mo1952a(new cu((byte) 12, avVar.f6103c.size()));
                for (ao b2 : avVar.f6103c) {
                    b2.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            if (avVar.f6104d != null && avVar.m9381u()) {
                cyVar.mo1951a(av.f6099j);
                cyVar.mo1952a(new cu((byte) 12, avVar.f6104d.size()));
                for (ao b22 : avVar.f6104d) {
                    b22.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: InstantMsg */
    /* renamed from: u.aly.av$b */
    private static class C1350b implements dh {
        private C1350b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9326a();
        }

        /* renamed from: a */
        public C1349a m9326a() {
            return new C1349a();
        }
    }

    /* compiled from: InstantMsg */
    /* renamed from: u.aly.av$c */
    private static class C1351c extends dj<av> {
        private C1351c() {
        }

        /* renamed from: a */
        public void m9328a(cy cyVar, av avVar) throws cf {
            cyVar = (de) cyVar;
            cyVar.mo1949a(avVar.f6101a);
            BitSet bitSet = new BitSet();
            if (avVar.m9371k()) {
                bitSet.set(0);
            }
            if (avVar.m9376p()) {
                bitSet.set(1);
            }
            if (avVar.m9381u()) {
                bitSet.set(2);
            }
            cyVar.m10341a(bitSet, 3);
            if (avVar.m9371k()) {
                cyVar.mo1947a(avVar.f6102b.size());
                for (am b : avVar.f6102b) {
                    b.mo1924b(cyVar);
                }
            }
            if (avVar.m9376p()) {
                cyVar.mo1947a(avVar.f6103c.size());
                for (ao b2 : avVar.f6103c) {
                    b2.mo1924b(cyVar);
                }
            }
            if (avVar.m9381u()) {
                cyVar.mo1947a(avVar.f6104d.size());
                for (ao b22 : avVar.f6104d) {
                    b22.mo1924b(cyVar);
                }
            }
        }

        /* renamed from: b */
        public void m9330b(cy cyVar, av avVar) throws cf {
            int i;
            int i2 = 0;
            cyVar = (de) cyVar;
            avVar.f6101a = cyVar.mo1983z();
            avVar.m9353a(true);
            BitSet b = cyVar.mo1986b(3);
            if (b.get(0)) {
                cu cuVar;
                cuVar = new cu((byte) 12, cyVar.mo1980w());
                avVar.f6102b = new ArrayList(cuVar.f6488b);
                for (i = 0; i < cuVar.f6488b; i++) {
                    am amVar = new am();
                    amVar.mo1921a(cyVar);
                    avVar.f6102b.add(amVar);
                }
                avVar.m9359b(true);
            }
            if (b.get(1)) {
                cuVar = new cu((byte) 12, cyVar.mo1980w());
                avVar.f6103c = new ArrayList(cuVar.f6488b);
                for (i = 0; i < cuVar.f6488b; i++) {
                    ao aoVar = new ao();
                    aoVar.mo1921a(cyVar);
                    avVar.f6103c.add(aoVar);
                }
                avVar.m9362c(true);
            }
            if (b.get(2)) {
                cu cuVar2 = new cu((byte) 12, cyVar.mo1980w());
                avVar.f6104d = new ArrayList(cuVar2.f6488b);
                while (i2 < cuVar2.f6488b) {
                    ao aoVar2 = new ao();
                    aoVar2.mo1921a(cyVar);
                    avVar.f6104d.add(aoVar2);
                    i2++;
                }
                avVar.m9364d(true);
            }
        }
    }

    /* compiled from: InstantMsg */
    /* renamed from: u.aly.av$d */
    private static class C1352d implements dh {
        private C1352d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9332a();
        }

        /* renamed from: a */
        public C1351c m9332a() {
            return new C1351c();
        }
    }

    /* compiled from: InstantMsg */
    /* renamed from: u.aly.av$e */
    public enum C1353e implements cg {
        ID((short) 1, "id"),
        ERRORS((short) 2, "errors"),
        EVENTS((short) 3, "events"),
        GAME_EVENTS((short) 4, "game_events");
        
        /* renamed from: e */
        private static final Map<String, C1353e> f6090e = null;
        /* renamed from: f */
        private final short f6092f;
        /* renamed from: g */
        private final String f6093g;

        static {
            f6090e = new HashMap();
            Iterator it = EnumSet.allOf(C1353e.class).iterator();
            while (it.hasNext()) {
                C1353e c1353e = (C1353e) it.next();
                f6090e.put(c1353e.mo1932b(), c1353e);
            }
        }

        /* renamed from: a */
        public static C1353e m9334a(int i) {
            switch (i) {
                case 1:
                    return ID;
                case 2:
                    return ERRORS;
                case 3:
                    return EVENTS;
                case 4:
                    return GAME_EVENTS;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1353e m9336b(int i) {
            C1353e a = C1353e.m9334a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1353e m9335a(String str) {
            return (C1353e) f6090e.get(str);
        }

        private C1353e(short s, String str) {
            this.f6092f = s;
            this.f6093g = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6092f;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6093g;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9346a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9347a();
    }

    static {
        f6100k.put(di.class, new C1350b());
        f6100k.put(dj.class, new C1352d());
        Map enumMap = new EnumMap(C1353e.class);
        enumMap.put(C1353e.ID, new cl("id", (byte) 1, new cm((byte) 11)));
        enumMap.put(C1353e.ERRORS, new cl("errors", (byte) 2, new cn(df.f6529m, new cq((byte) 12, am.class))));
        enumMap.put(C1353e.EVENTS, new cl("events", (byte) 2, new cn(df.f6529m, new cq((byte) 12, ao.class))));
        enumMap.put(C1353e.GAME_EVENTS, new cl("game_events", (byte) 2, new cn(df.f6529m, new cq((byte) 12, ao.class))));
        f6094e = Collections.unmodifiableMap(enumMap);
        cl.m10164a(av.class, f6094e);
    }

    public av() {
        this.f6105l = new C1353e[]{C1353e.ERRORS, C1353e.EVENTS, C1353e.GAME_EVENTS};
    }

    public av(String str) {
        this();
        this.f6101a = str;
    }

    public av(av avVar) {
        List arrayList;
        this.f6105l = new C1353e[]{C1353e.ERRORS, C1353e.EVENTS, C1353e.GAME_EVENTS};
        if (avVar.m9365e()) {
            this.f6101a = avVar.f6101a;
        }
        if (avVar.m9371k()) {
            arrayList = new ArrayList();
            for (am amVar : avVar.f6102b) {
                arrayList.add(new am(amVar));
            }
            this.f6102b = arrayList;
        }
        if (avVar.m9376p()) {
            arrayList = new ArrayList();
            for (ao aoVar : avVar.f6103c) {
                arrayList.add(new ao(aoVar));
            }
            this.f6103c = arrayList;
        }
        if (avVar.m9381u()) {
            arrayList = new ArrayList();
            for (ao aoVar2 : avVar.f6104d) {
                arrayList.add(new ao(aoVar2));
            }
            this.f6104d = arrayList;
        }
    }

    /* renamed from: a */
    public av m9347a() {
        return new av(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6101a = null;
        this.f6102b = null;
        this.f6103c = null;
        this.f6104d = null;
    }

    /* renamed from: c */
    public String m9360c() {
        return this.f6101a;
    }

    /* renamed from: a */
    public av m9348a(String str) {
        this.f6101a = str;
        return this;
    }

    /* renamed from: d */
    public void m9363d() {
        this.f6101a = null;
    }

    /* renamed from: e */
    public boolean m9365e() {
        return this.f6101a != null;
    }

    /* renamed from: a */
    public void m9353a(boolean z) {
        if (!z) {
            this.f6101a = null;
        }
    }

    /* renamed from: f */
    public int m9366f() {
        return this.f6102b == null ? 0 : this.f6102b.size();
    }

    /* renamed from: h */
    public Iterator<am> m9368h() {
        return this.f6102b == null ? null : this.f6102b.iterator();
    }

    /* renamed from: a */
    public void m9350a(am amVar) {
        if (this.f6102b == null) {
            this.f6102b = new ArrayList();
        }
        this.f6102b.add(amVar);
    }

    /* renamed from: i */
    public List<am> m9369i() {
        return this.f6102b;
    }

    /* renamed from: a */
    public av m9349a(List<am> list) {
        this.f6102b = list;
        return this;
    }

    /* renamed from: j */
    public void m9370j() {
        this.f6102b = null;
    }

    /* renamed from: k */
    public boolean m9371k() {
        return this.f6102b != null;
    }

    /* renamed from: b */
    public void m9359b(boolean z) {
        if (!z) {
            this.f6102b = null;
        }
    }

    /* renamed from: l */
    public int m9372l() {
        return this.f6103c == null ? 0 : this.f6103c.size();
    }

    /* renamed from: m */
    public Iterator<ao> m9373m() {
        return this.f6103c == null ? null : this.f6103c.iterator();
    }

    /* renamed from: a */
    public void m9351a(ao aoVar) {
        if (this.f6103c == null) {
            this.f6103c = new ArrayList();
        }
        this.f6103c.add(aoVar);
    }

    /* renamed from: n */
    public List<ao> m9374n() {
        return this.f6103c;
    }

    /* renamed from: b */
    public av m9354b(List<ao> list) {
        this.f6103c = list;
        return this;
    }

    /* renamed from: o */
    public void m9375o() {
        this.f6103c = null;
    }

    /* renamed from: p */
    public boolean m9376p() {
        return this.f6103c != null;
    }

    /* renamed from: c */
    public void m9362c(boolean z) {
        if (!z) {
            this.f6103c = null;
        }
    }

    /* renamed from: q */
    public int m9377q() {
        return this.f6104d == null ? 0 : this.f6104d.size();
    }

    /* renamed from: r */
    public Iterator<ao> m9378r() {
        return this.f6104d == null ? null : this.f6104d.iterator();
    }

    /* renamed from: b */
    public void m9357b(ao aoVar) {
        if (this.f6104d == null) {
            this.f6104d = new ArrayList();
        }
        this.f6104d.add(aoVar);
    }

    /* renamed from: s */
    public List<ao> m9379s() {
        return this.f6104d;
    }

    /* renamed from: c */
    public av m9361c(List<ao> list) {
        this.f6104d = list;
        return this;
    }

    /* renamed from: t */
    public void m9380t() {
        this.f6104d = null;
    }

    /* renamed from: u */
    public boolean m9381u() {
        return this.f6104d != null;
    }

    /* renamed from: d */
    public void m9364d(boolean z) {
        if (!z) {
            this.f6104d = null;
        }
    }

    /* renamed from: a */
    public C1353e m9346a(int i) {
        return C1353e.m9334a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6100k.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6100k.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("InstantMsg(");
        stringBuilder.append("id:");
        if (this.f6101a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6101a);
        }
        if (m9371k()) {
            stringBuilder.append(", ");
            stringBuilder.append("errors:");
            if (this.f6102b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6102b);
            }
        }
        if (m9376p()) {
            stringBuilder.append(", ");
            stringBuilder.append("events:");
            if (this.f6103c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6103c);
            }
        }
        if (m9381u()) {
            stringBuilder.append(", ");
            stringBuilder.append("game_events:");
            if (this.f6104d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6104d);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: v */
    public void m9382v() throws cf {
        if (this.f6101a == null) {
            throw new cz("Required field 'id' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m9341a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9340a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
