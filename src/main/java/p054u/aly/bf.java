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

/* compiled from: UALogEntry */
/* renamed from: u.aly.bf */
public class bf implements Serializable, Cloneable, bz<bf, C1404e> {
    /* renamed from: j */
    public static final Map<C1404e, cl> f6275j;
    /* renamed from: k */
    private static final dd f6276k = new dd("UALogEntry");
    /* renamed from: l */
    private static final ct f6277l = new ct("client_stats", (byte) 12, (short) 1);
    /* renamed from: m */
    private static final ct f6278m = new ct("app_info", (byte) 12, (short) 2);
    /* renamed from: n */
    private static final ct f6279n = new ct("device_info", (byte) 12, (short) 3);
    /* renamed from: o */
    private static final ct f6280o = new ct("misc_info", (byte) 12, (short) 4);
    /* renamed from: p */
    private static final ct f6281p = new ct("activate_msg", (byte) 12, (short) 5);
    /* renamed from: q */
    private static final ct f6282q = new ct("instant_msgs", df.f6529m, (short) 6);
    /* renamed from: r */
    private static final ct f6283r = new ct("sessions", df.f6529m, (short) 7);
    /* renamed from: s */
    private static final ct f6284s = new ct("imprint", (byte) 12, (short) 8);
    /* renamed from: t */
    private static final ct f6285t = new ct("id_tracking", (byte) 12, (short) 9);
    /* renamed from: u */
    private static final Map<Class<? extends dg>, dh> f6286u = new HashMap();
    /* renamed from: a */
    public aj f6287a;
    /* renamed from: b */
    public ai f6288b;
    /* renamed from: c */
    public ak f6289c;
    /* renamed from: d */
    public ax f6290d;
    /* renamed from: e */
    public ah f6291e;
    /* renamed from: f */
    public List<av> f6292f;
    /* renamed from: g */
    public List<bd> f6293g;
    /* renamed from: h */
    public at f6294h;
    /* renamed from: i */
    public as f6295i;
    /* renamed from: v */
    private C1404e[] f6296v;

    /* compiled from: UALogEntry */
    /* renamed from: u.aly.bf$a */
    private static class C1400a extends di<bf> {
        private C1400a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m9744b(cyVar, (bf) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m9742a(cyVar, (bf) bzVar);
        }

        /* renamed from: a */
        public void m9742a(cy cyVar, bf bfVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    bfVar.m9779I();
                    return;
                }
                cu p;
                int i;
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bfVar.f6287a = new aj();
                        bfVar.f6287a.mo1921a(cyVar);
                        bfVar.m9793a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bfVar.f6288b = new ai();
                        bfVar.f6288b.mo1921a(cyVar);
                        bfVar.m9798b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bfVar.f6289c = new ak();
                        bfVar.f6289c.mo1921a(cyVar);
                        bfVar.m9800c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bfVar.f6290d = new ax();
                        bfVar.f6290d.mo1921a(cyVar);
                        bfVar.m9802d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bfVar.f6291e = new ah();
                        bfVar.f6291e.mo1921a(cyVar);
                        bfVar.m9803e(true);
                        break;
                    case (short) 6:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        p = cyVar.mo1973p();
                        bfVar.f6292f = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            av avVar = new av();
                            avVar.mo1921a(cyVar);
                            bfVar.f6292f.add(avVar);
                        }
                        cyVar.mo1974q();
                        bfVar.m9806f(true);
                        break;
                    case (short) 7:
                        if (l.f6485b != df.f6529m) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        p = cyVar.mo1973p();
                        bfVar.f6293g = new ArrayList(p.f6488b);
                        for (i = 0; i < p.f6488b; i++) {
                            bd bdVar = new bd();
                            bdVar.mo1921a(cyVar);
                            bfVar.f6293g.add(bdVar);
                        }
                        cyVar.mo1974q();
                        bfVar.m9808g(true);
                        break;
                    case (short) 8:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bfVar.f6294h = new at();
                        bfVar.f6294h.mo1921a(cyVar);
                        bfVar.m9810h(true);
                        break;
                    case (short) 9:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        bfVar.f6295i = new as();
                        bfVar.f6295i.mo1921a(cyVar);
                        bfVar.m9811i(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m9744b(cy cyVar, bf bfVar) throws cf {
            bfVar.m9779I();
            cyVar.mo1956a(bf.f6276k);
            if (bfVar.f6287a != null) {
                cyVar.mo1951a(bf.f6277l);
                bfVar.f6287a.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            if (bfVar.f6288b != null) {
                cyVar.mo1951a(bf.f6278m);
                bfVar.f6288b.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            if (bfVar.f6289c != null) {
                cyVar.mo1951a(bf.f6279n);
                bfVar.f6289c.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            if (bfVar.f6290d != null) {
                cyVar.mo1951a(bf.f6280o);
                bfVar.f6290d.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            if (bfVar.f6291e != null && bfVar.m9821r()) {
                cyVar.mo1951a(bf.f6281p);
                bfVar.f6291e.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            if (bfVar.f6292f != null && bfVar.m9826w()) {
                cyVar.mo1951a(bf.f6282q);
                cyVar.mo1952a(new cu((byte) 12, bfVar.f6292f.size()));
                for (av b : bfVar.f6292f) {
                    b.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            if (bfVar.f6293g != null && bfVar.m9772B()) {
                cyVar.mo1951a(bf.f6283r);
                cyVar.mo1952a(new cu((byte) 12, bfVar.f6293g.size()));
                for (bd b2 : bfVar.f6293g) {
                    b2.mo1924b(cyVar);
                }
                cyVar.mo1963f();
                cyVar.mo1960c();
            }
            if (bfVar.f6294h != null && bfVar.m9775E()) {
                cyVar.mo1951a(bf.f6284s);
                bfVar.f6294h.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            if (bfVar.f6295i != null && bfVar.m9778H()) {
                cyVar.mo1951a(bf.f6285t);
                bfVar.f6295i.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: UALogEntry */
    /* renamed from: u.aly.bf$b */
    private static class C1401b implements dh {
        private C1401b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9746a();
        }

        /* renamed from: a */
        public C1400a m9746a() {
            return new C1400a();
        }
    }

    /* compiled from: UALogEntry */
    /* renamed from: u.aly.bf$c */
    private static class C1402c extends dj<bf> {
        private C1402c() {
        }

        /* renamed from: a */
        public void m9748a(cy cyVar, bf bfVar) throws cf {
            cyVar = (de) cyVar;
            bfVar.f6287a.mo1924b(cyVar);
            bfVar.f6288b.mo1924b(cyVar);
            bfVar.f6289c.mo1924b(cyVar);
            bfVar.f6290d.mo1924b(cyVar);
            BitSet bitSet = new BitSet();
            if (bfVar.m9821r()) {
                bitSet.set(0);
            }
            if (bfVar.m9826w()) {
                bitSet.set(1);
            }
            if (bfVar.m9772B()) {
                bitSet.set(2);
            }
            if (bfVar.m9775E()) {
                bitSet.set(3);
            }
            if (bfVar.m9778H()) {
                bitSet.set(4);
            }
            cyVar.m10341a(bitSet, 5);
            if (bfVar.m9821r()) {
                bfVar.f6291e.mo1924b(cyVar);
            }
            if (bfVar.m9826w()) {
                cyVar.mo1947a(bfVar.f6292f.size());
                for (av b : bfVar.f6292f) {
                    b.mo1924b(cyVar);
                }
            }
            if (bfVar.m9772B()) {
                cyVar.mo1947a(bfVar.f6293g.size());
                for (bd b2 : bfVar.f6293g) {
                    b2.mo1924b(cyVar);
                }
            }
            if (bfVar.m9775E()) {
                bfVar.f6294h.mo1924b(cyVar);
            }
            if (bfVar.m9778H()) {
                bfVar.f6295i.mo1924b(cyVar);
            }
        }

        /* renamed from: b */
        public void m9750b(cy cyVar, bf bfVar) throws cf {
            int i = 0;
            cyVar = (de) cyVar;
            bfVar.f6287a = new aj();
            bfVar.f6287a.mo1921a(cyVar);
            bfVar.m9793a(true);
            bfVar.f6288b = new ai();
            bfVar.f6288b.mo1921a(cyVar);
            bfVar.m9798b(true);
            bfVar.f6289c = new ak();
            bfVar.f6289c.mo1921a(cyVar);
            bfVar.m9800c(true);
            bfVar.f6290d = new ax();
            bfVar.f6290d.mo1921a(cyVar);
            bfVar.m9802d(true);
            BitSet b = cyVar.mo1986b(5);
            if (b.get(0)) {
                bfVar.f6291e = new ah();
                bfVar.f6291e.mo1921a(cyVar);
                bfVar.m9803e(true);
            }
            if (b.get(1)) {
                cu cuVar = new cu((byte) 12, cyVar.mo1980w());
                bfVar.f6292f = new ArrayList(cuVar.f6488b);
                for (int i2 = 0; i2 < cuVar.f6488b; i2++) {
                    av avVar = new av();
                    avVar.mo1921a(cyVar);
                    bfVar.f6292f.add(avVar);
                }
                bfVar.m9806f(true);
            }
            if (b.get(2)) {
                cu cuVar2 = new cu((byte) 12, cyVar.mo1980w());
                bfVar.f6293g = new ArrayList(cuVar2.f6488b);
                while (i < cuVar2.f6488b) {
                    bd bdVar = new bd();
                    bdVar.mo1921a(cyVar);
                    bfVar.f6293g.add(bdVar);
                    i++;
                }
                bfVar.m9808g(true);
            }
            if (b.get(3)) {
                bfVar.f6294h = new at();
                bfVar.f6294h.mo1921a(cyVar);
                bfVar.m9810h(true);
            }
            if (b.get(4)) {
                bfVar.f6295i = new as();
                bfVar.f6295i.mo1921a(cyVar);
                bfVar.m9811i(true);
            }
        }
    }

    /* compiled from: UALogEntry */
    /* renamed from: u.aly.bf$d */
    private static class C1403d implements dh {
        private C1403d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m9752a();
        }

        /* renamed from: a */
        public C1402c m9752a() {
            return new C1402c();
        }
    }

    /* compiled from: UALogEntry */
    /* renamed from: u.aly.bf$e */
    public enum C1404e implements cg {
        CLIENT_STATS((short) 1, "client_stats"),
        APP_INFO((short) 2, "app_info"),
        DEVICE_INFO((short) 3, "device_info"),
        MISC_INFO((short) 4, "misc_info"),
        ACTIVATE_MSG((short) 5, "activate_msg"),
        INSTANT_MSGS((short) 6, "instant_msgs"),
        SESSIONS((short) 7, "sessions"),
        IMPRINT((short) 8, "imprint"),
        ID_TRACKING((short) 9, "id_tracking");
        
        /* renamed from: j */
        private static final Map<String, C1404e> f6271j = null;
        /* renamed from: k */
        private final short f6273k;
        /* renamed from: l */
        private final String f6274l;

        static {
            f6271j = new HashMap();
            Iterator it = EnumSet.allOf(C1404e.class).iterator();
            while (it.hasNext()) {
                C1404e c1404e = (C1404e) it.next();
                f6271j.put(c1404e.mo1932b(), c1404e);
            }
        }

        /* renamed from: a */
        public static C1404e m9754a(int i) {
            switch (i) {
                case 1:
                    return CLIENT_STATS;
                case 2:
                    return APP_INFO;
                case 3:
                    return DEVICE_INFO;
                case 4:
                    return MISC_INFO;
                case 5:
                    return ACTIVATE_MSG;
                case 6:
                    return INSTANT_MSGS;
                case 7:
                    return SESSIONS;
                case 8:
                    return IMPRINT;
                case 9:
                    return ID_TRACKING;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1404e m9756b(int i) {
            C1404e a = C1404e.m9754a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1404e m9755a(String str) {
            return (C1404e) f6271j.get(str);
        }

        private C1404e(short s, String str) {
            this.f6273k = s;
            this.f6274l = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f6273k;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f6274l;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m9780a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m9781a();
    }

    static {
        f6286u.put(di.class, new C1401b());
        f6286u.put(dj.class, new C1403d());
        Map enumMap = new EnumMap(C1404e.class);
        enumMap.put(C1404e.CLIENT_STATS, new cl("client_stats", (byte) 1, new cq((byte) 12, aj.class)));
        enumMap.put(C1404e.APP_INFO, new cl("app_info", (byte) 1, new cq((byte) 12, ai.class)));
        enumMap.put(C1404e.DEVICE_INFO, new cl("device_info", (byte) 1, new cq((byte) 12, ak.class)));
        enumMap.put(C1404e.MISC_INFO, new cl("misc_info", (byte) 1, new cq((byte) 12, ax.class)));
        enumMap.put(C1404e.ACTIVATE_MSG, new cl("activate_msg", (byte) 2, new cq((byte) 12, ah.class)));
        enumMap.put(C1404e.INSTANT_MSGS, new cl("instant_msgs", (byte) 2, new cn(df.f6529m, new cq((byte) 12, av.class))));
        enumMap.put(C1404e.SESSIONS, new cl("sessions", (byte) 2, new cn(df.f6529m, new cq((byte) 12, bd.class))));
        enumMap.put(C1404e.IMPRINT, new cl("imprint", (byte) 2, new cq((byte) 12, at.class)));
        enumMap.put(C1404e.ID_TRACKING, new cl("id_tracking", (byte) 2, new cq((byte) 12, as.class)));
        f6275j = Collections.unmodifiableMap(enumMap);
        cl.m10164a(bf.class, f6275j);
    }

    public bf() {
        this.f6296v = new C1404e[]{C1404e.ACTIVATE_MSG, C1404e.INSTANT_MSGS, C1404e.SESSIONS, C1404e.IMPRINT, C1404e.ID_TRACKING};
    }

    public bf(aj ajVar, ai aiVar, ak akVar, ax axVar) {
        this();
        this.f6287a = ajVar;
        this.f6288b = aiVar;
        this.f6289c = akVar;
        this.f6290d = axVar;
    }

    public bf(bf bfVar) {
        List arrayList;
        this.f6296v = new C1404e[]{C1404e.ACTIVATE_MSG, C1404e.INSTANT_MSGS, C1404e.SESSIONS, C1404e.IMPRINT, C1404e.ID_TRACKING};
        if (bfVar.m9804e()) {
            this.f6287a = new aj(bfVar.f6287a);
        }
        if (bfVar.m9812i()) {
            this.f6288b = new ai(bfVar.f6288b);
        }
        if (bfVar.m9815l()) {
            this.f6289c = new ak(bfVar.f6289c);
        }
        if (bfVar.m9818o()) {
            this.f6290d = new ax(bfVar.f6290d);
        }
        if (bfVar.m9821r()) {
            this.f6291e = new ah(bfVar.f6291e);
        }
        if (bfVar.m9826w()) {
            arrayList = new ArrayList();
            for (av avVar : bfVar.f6292f) {
                arrayList.add(new av(avVar));
            }
            this.f6292f = arrayList;
        }
        if (bfVar.m9772B()) {
            arrayList = new ArrayList();
            for (bd bdVar : bfVar.f6293g) {
                arrayList.add(new bd(bdVar));
            }
            this.f6293g = arrayList;
        }
        if (bfVar.m9775E()) {
            this.f6294h = new at(bfVar.f6294h);
        }
        if (bfVar.m9778H()) {
            this.f6295i = new as(bfVar.f6295i);
        }
    }

    /* renamed from: a */
    public bf m9781a() {
        return new bf(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f6287a = null;
        this.f6288b = null;
        this.f6289c = null;
        this.f6290d = null;
        this.f6291e = null;
        this.f6292f = null;
        this.f6293g = null;
        this.f6294h = null;
        this.f6295i = null;
    }

    /* renamed from: c */
    public aj m9799c() {
        return this.f6287a;
    }

    /* renamed from: a */
    public bf m9785a(aj ajVar) {
        this.f6287a = ajVar;
        return this;
    }

    /* renamed from: d */
    public void m9801d() {
        this.f6287a = null;
    }

    /* renamed from: e */
    public boolean m9804e() {
        return this.f6287a != null;
    }

    /* renamed from: a */
    public void m9793a(boolean z) {
        if (!z) {
            this.f6287a = null;
        }
    }

    /* renamed from: f */
    public ai m9805f() {
        return this.f6288b;
    }

    /* renamed from: a */
    public bf m9784a(ai aiVar) {
        this.f6288b = aiVar;
        return this;
    }

    /* renamed from: h */
    public void m9809h() {
        this.f6288b = null;
    }

    /* renamed from: i */
    public boolean m9812i() {
        return this.f6288b != null;
    }

    /* renamed from: b */
    public void m9798b(boolean z) {
        if (!z) {
            this.f6288b = null;
        }
    }

    /* renamed from: j */
    public ak m9813j() {
        return this.f6289c;
    }

    /* renamed from: a */
    public bf m9786a(ak akVar) {
        this.f6289c = akVar;
        return this;
    }

    /* renamed from: k */
    public void m9814k() {
        this.f6289c = null;
    }

    /* renamed from: l */
    public boolean m9815l() {
        return this.f6289c != null;
    }

    /* renamed from: c */
    public void m9800c(boolean z) {
        if (!z) {
            this.f6289c = null;
        }
    }

    /* renamed from: m */
    public ax m9816m() {
        return this.f6290d;
    }

    /* renamed from: a */
    public bf m9789a(ax axVar) {
        this.f6290d = axVar;
        return this;
    }

    /* renamed from: n */
    public void m9817n() {
        this.f6290d = null;
    }

    /* renamed from: o */
    public boolean m9818o() {
        return this.f6290d != null;
    }

    /* renamed from: d */
    public void m9802d(boolean z) {
        if (!z) {
            this.f6290d = null;
        }
    }

    /* renamed from: p */
    public ah m9819p() {
        return this.f6291e;
    }

    /* renamed from: a */
    public bf m9783a(ah ahVar) {
        this.f6291e = ahVar;
        return this;
    }

    /* renamed from: q */
    public void m9820q() {
        this.f6291e = null;
    }

    /* renamed from: r */
    public boolean m9821r() {
        return this.f6291e != null;
    }

    /* renamed from: e */
    public void m9803e(boolean z) {
        if (!z) {
            this.f6291e = null;
        }
    }

    /* renamed from: s */
    public int m9822s() {
        return this.f6292f == null ? 0 : this.f6292f.size();
    }

    /* renamed from: t */
    public Iterator<av> m9823t() {
        return this.f6292f == null ? null : this.f6292f.iterator();
    }

    /* renamed from: a */
    public void m9790a(av avVar) {
        if (this.f6292f == null) {
            this.f6292f = new ArrayList();
        }
        this.f6292f.add(avVar);
    }

    /* renamed from: u */
    public List<av> m9824u() {
        return this.f6292f;
    }

    /* renamed from: a */
    public bf m9782a(List<av> list) {
        this.f6292f = list;
        return this;
    }

    /* renamed from: v */
    public void m9825v() {
        this.f6292f = null;
    }

    /* renamed from: w */
    public boolean m9826w() {
        return this.f6292f != null;
    }

    /* renamed from: f */
    public void m9806f(boolean z) {
        if (!z) {
            this.f6292f = null;
        }
    }

    /* renamed from: x */
    public int m9827x() {
        return this.f6293g == null ? 0 : this.f6293g.size();
    }

    /* renamed from: y */
    public Iterator<bd> m9828y() {
        return this.f6293g == null ? null : this.f6293g.iterator();
    }

    /* renamed from: a */
    public void m9791a(bd bdVar) {
        if (this.f6293g == null) {
            this.f6293g = new ArrayList();
        }
        this.f6293g.add(bdVar);
    }

    /* renamed from: z */
    public List<bd> m9829z() {
        return this.f6293g;
    }

    /* renamed from: b */
    public bf m9794b(List<bd> list) {
        this.f6293g = list;
        return this;
    }

    /* renamed from: A */
    public void m9771A() {
        this.f6293g = null;
    }

    /* renamed from: B */
    public boolean m9772B() {
        return this.f6293g != null;
    }

    /* renamed from: g */
    public void m9808g(boolean z) {
        if (!z) {
            this.f6293g = null;
        }
    }

    /* renamed from: C */
    public at m9773C() {
        return this.f6294h;
    }

    /* renamed from: a */
    public bf m9788a(at atVar) {
        this.f6294h = atVar;
        return this;
    }

    /* renamed from: D */
    public void m9774D() {
        this.f6294h = null;
    }

    /* renamed from: E */
    public boolean m9775E() {
        return this.f6294h != null;
    }

    /* renamed from: h */
    public void m9810h(boolean z) {
        if (!z) {
            this.f6294h = null;
        }
    }

    /* renamed from: F */
    public as m9776F() {
        return this.f6295i;
    }

    /* renamed from: a */
    public bf m9787a(as asVar) {
        this.f6295i = asVar;
        return this;
    }

    /* renamed from: G */
    public void m9777G() {
        this.f6295i = null;
    }

    /* renamed from: H */
    public boolean m9778H() {
        return this.f6295i != null;
    }

    /* renamed from: i */
    public void m9811i(boolean z) {
        if (!z) {
            this.f6295i = null;
        }
    }

    /* renamed from: a */
    public C1404e m9780a(int i) {
        return C1404e.m9754a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f6286u.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f6286u.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UALogEntry(");
        stringBuilder.append("client_stats:");
        if (this.f6287a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6287a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("app_info:");
        if (this.f6288b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6288b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("device_info:");
        if (this.f6289c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6289c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("misc_info:");
        if (this.f6290d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f6290d);
        }
        if (m9821r()) {
            stringBuilder.append(", ");
            stringBuilder.append("activate_msg:");
            if (this.f6291e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6291e);
            }
        }
        if (m9826w()) {
            stringBuilder.append(", ");
            stringBuilder.append("instant_msgs:");
            if (this.f6292f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6292f);
            }
        }
        if (m9772B()) {
            stringBuilder.append(", ");
            stringBuilder.append("sessions:");
            if (this.f6293g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6293g);
            }
        }
        if (m9775E()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.f6294h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6294h);
            }
        }
        if (m9778H()) {
            stringBuilder.append(", ");
            stringBuilder.append("id_tracking:");
            if (this.f6295i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f6295i);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: I */
    public void m9779I() throws cf {
        if (this.f6287a == null) {
            throw new cz("Required field 'client_stats' was not present! Struct: " + toString());
        } else if (this.f6288b == null) {
            throw new cz("Required field 'app_info' was not present! Struct: " + toString());
        } else if (this.f6289c == null) {
            throw new cz("Required field 'device_info' was not present! Struct: " + toString());
        } else if (this.f6290d == null) {
            throw new cz("Required field 'misc_info' was not present! Struct: " + toString());
        } else {
            if (this.f6287a != null) {
                this.f6287a.m8871m();
            }
            if (this.f6288b != null) {
                this.f6288b.m8775H();
            }
            if (this.f6289c != null) {
                this.f6289c.ac();
            }
            if (this.f6290d != null) {
                this.f6290d.m9470K();
            }
            if (this.f6291e != null) {
                this.f6291e.m8736f();
            }
            if (this.f6294h != null) {
                this.f6294h.m9275n();
            }
            if (this.f6295i != null) {
                this.f6295i.m9227p();
            }
        }
    }

    /* renamed from: a */
    private void m9770a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m9769a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
