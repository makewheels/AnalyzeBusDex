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

/* compiled from: DeviceInfo */
/* renamed from: u.aly.ak */
public class ak implements Serializable, Cloneable, bz<ak, C1299e> {
    /* renamed from: A */
    private static final ct f5897A = new ct("os_version", (byte) 11, (short) 8);
    /* renamed from: B */
    private static final ct f5898B = new ct("resolution", (byte) 12, (short) 9);
    /* renamed from: C */
    private static final ct f5899C = new ct("is_jailbroken", (byte) 2, (short) 10);
    /* renamed from: D */
    private static final ct f5900D = new ct("is_pirated", (byte) 2, (short) 11);
    /* renamed from: E */
    private static final ct f5901E = new ct("device_board", (byte) 11, (short) 12);
    /* renamed from: F */
    private static final ct f5902F = new ct("device_brand", (byte) 11, (short) 13);
    /* renamed from: G */
    private static final ct f5903G = new ct("device_manutime", (byte) 10, (short) 14);
    /* renamed from: H */
    private static final ct f5904H = new ct("device_manufacturer", (byte) 11, (short) 15);
    /* renamed from: I */
    private static final ct f5905I = new ct("device_manuid", (byte) 11, (short) 16);
    /* renamed from: J */
    private static final ct f5906J = new ct("device_name", (byte) 11, (short) 17);
    /* renamed from: K */
    private static final Map<Class<? extends dg>, dh> f5907K = new HashMap();
    /* renamed from: L */
    private static final int f5908L = 0;
    /* renamed from: M */
    private static final int f5909M = 1;
    /* renamed from: N */
    private static final int f5910N = 2;
    /* renamed from: r */
    public static final Map<C1299e, cl> f5911r;
    /* renamed from: s */
    private static final dd f5912s = new dd("DeviceInfo");
    /* renamed from: t */
    private static final ct f5913t = new ct("device_id", (byte) 11, (short) 1);
    /* renamed from: u */
    private static final ct f5914u = new ct(C1248a.f5657d, (byte) 11, (short) 2);
    /* renamed from: v */
    private static final ct f5915v = new ct("mac_address", (byte) 11, (short) 3);
    /* renamed from: w */
    private static final ct f5916w = new ct("open_udid", (byte) 11, (short) 4);
    /* renamed from: x */
    private static final ct f5917x = new ct("model", (byte) 11, (short) 5);
    /* renamed from: y */
    private static final ct f5918y = new ct("cpu", (byte) 11, (short) 6);
    /* renamed from: z */
    private static final ct f5919z = new ct("os", (byte) 11, (short) 7);
    /* renamed from: O */
    private byte f5920O;
    /* renamed from: P */
    private C1299e[] f5921P;
    /* renamed from: a */
    public String f5922a;
    /* renamed from: b */
    public String f5923b;
    /* renamed from: c */
    public String f5924c;
    /* renamed from: d */
    public String f5925d;
    /* renamed from: e */
    public String f5926e;
    /* renamed from: f */
    public String f5927f;
    /* renamed from: g */
    public String f5928g;
    /* renamed from: h */
    public String f5929h;
    /* renamed from: i */
    public ba f5930i;
    /* renamed from: j */
    public boolean f5931j;
    /* renamed from: k */
    public boolean f5932k;
    /* renamed from: l */
    public String f5933l;
    /* renamed from: m */
    public String f5934m;
    /* renamed from: n */
    public long f5935n;
    /* renamed from: o */
    public String f5936o;
    /* renamed from: p */
    public String f5937p;
    /* renamed from: q */
    public String f5938q;

    /* compiled from: DeviceInfo */
    /* renamed from: u.aly.ak$a */
    private static class C1295a extends di<ak> {
        private C1295a() {
        }

        /* renamed from: a */
        public /* synthetic */ void mo1928a(cy cyVar, bz bzVar) throws cf {
            m8874b(cyVar, (ak) bzVar);
        }

        /* renamed from: b */
        public /* synthetic */ void mo1929b(cy cyVar, bz bzVar) throws cf {
            m8872a(cyVar, (ak) bzVar);
        }

        /* renamed from: a */
        public void m8872a(cy cyVar, ak akVar) throws cf {
            cyVar.mo1967j();
            while (true) {
                ct l = cyVar.mo1969l();
                if (l.f6485b == (byte) 0) {
                    cyVar.mo1968k();
                    akVar.ac();
                    return;
                }
                switch (l.f6486c) {
                    case (short) 1:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5922a = cyVar.mo1983z();
                        akVar.m8923a(true);
                        break;
                    case (short) 2:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5923b = cyVar.mo1983z();
                        akVar.m8928b(true);
                        break;
                    case (short) 3:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5924c = cyVar.mo1983z();
                        akVar.m8931c(true);
                        break;
                    case (short) 4:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5925d = cyVar.mo1983z();
                        akVar.m8934d(true);
                        break;
                    case (short) 5:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5926e = cyVar.mo1983z();
                        akVar.m8936e(true);
                        break;
                    case (short) 6:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5927f = cyVar.mo1983z();
                        akVar.m8940f(true);
                        break;
                    case (short) 7:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5928g = cyVar.mo1983z();
                        akVar.m8943g(true);
                        break;
                    case (short) 8:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5929h = cyVar.mo1983z();
                        akVar.m8946h(true);
                        break;
                    case (short) 9:
                        if (l.f6485b != (byte) 12) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5930i = new ba();
                        akVar.f5930i.mo1921a(cyVar);
                        akVar.m8948i(true);
                        break;
                    case (short) 10:
                        if (l.f6485b != (byte) 2) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5931j = cyVar.mo1977t();
                        akVar.m8955k(true);
                        break;
                    case (short) 11:
                        if (l.f6485b != (byte) 2) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5932k = cyVar.mo1977t();
                        akVar.m8961m(true);
                        break;
                    case (short) 12:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5933l = cyVar.mo1983z();
                        akVar.m8963n(true);
                        break;
                    case (short) 13:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5934m = cyVar.mo1983z();
                        akVar.m8964o(true);
                        break;
                    case (short) 14:
                        if (l.f6485b != (byte) 10) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5935n = cyVar.mo1981x();
                        akVar.m8967p(true);
                        break;
                    case (short) 15:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5936o = cyVar.mo1983z();
                        akVar.m8969q(true);
                        break;
                    case (short) 16:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5937p = cyVar.mo1983z();
                        akVar.m8970r(true);
                        break;
                    case (short) 17:
                        if (l.f6485b != (byte) 11) {
                            db.m10335a(cyVar, l.f6485b);
                            break;
                        }
                        akVar.f5938q = cyVar.mo1983z();
                        akVar.m8973s(true);
                        break;
                    default:
                        db.m10335a(cyVar, l.f6485b);
                        break;
                }
                cyVar.mo1970m();
            }
        }

        /* renamed from: b */
        public void m8874b(cy cyVar, ak akVar) throws cf {
            akVar.ac();
            cyVar.mo1956a(ak.f5912s);
            if (akVar.f5922a != null && akVar.m8937e()) {
                cyVar.mo1951a(ak.f5913t);
                cyVar.mo1949a(akVar.f5922a);
                cyVar.mo1960c();
            }
            if (akVar.f5923b != null && akVar.m8949i()) {
                cyVar.mo1951a(ak.f5914u);
                cyVar.mo1949a(akVar.f5923b);
                cyVar.mo1960c();
            }
            if (akVar.f5924c != null && akVar.m8958l()) {
                cyVar.mo1951a(ak.f5915v);
                cyVar.mo1949a(akVar.f5924c);
                cyVar.mo1960c();
            }
            if (akVar.f5925d != null && akVar.m8965o()) {
                cyVar.mo1951a(ak.f5916w);
                cyVar.mo1949a(akVar.f5925d);
                cyVar.mo1960c();
            }
            if (akVar.f5926e != null && akVar.m8971r()) {
                cyVar.mo1951a(ak.f5917x);
                cyVar.mo1949a(akVar.f5926e);
                cyVar.mo1960c();
            }
            if (akVar.f5927f != null && akVar.m8975u()) {
                cyVar.mo1951a(ak.f5918y);
                cyVar.mo1949a(akVar.f5927f);
                cyVar.mo1960c();
            }
            if (akVar.f5928g != null && akVar.m8978x()) {
                cyVar.mo1951a(ak.f5919z);
                cyVar.mo1949a(akVar.f5928g);
                cyVar.mo1960c();
            }
            if (akVar.f5929h != null && akVar.m8891A()) {
                cyVar.mo1951a(ak.f5897A);
                cyVar.mo1949a(akVar.f5929h);
                cyVar.mo1960c();
            }
            if (akVar.f5930i != null && akVar.m8894D()) {
                cyVar.mo1951a(ak.f5898B);
                akVar.f5930i.mo1924b(cyVar);
                cyVar.mo1960c();
            }
            if (akVar.m8897G()) {
                cyVar.mo1951a(ak.f5899C);
                cyVar.mo1958a(akVar.f5931j);
                cyVar.mo1960c();
            }
            if (akVar.m8900J()) {
                cyVar.mo1951a(ak.f5900D);
                cyVar.mo1958a(akVar.f5932k);
                cyVar.mo1960c();
            }
            if (akVar.f5933l != null && akVar.m8903M()) {
                cyVar.mo1951a(ak.f5901E);
                cyVar.mo1949a(akVar.f5933l);
                cyVar.mo1960c();
            }
            if (akVar.f5934m != null && akVar.m8906P()) {
                cyVar.mo1951a(ak.f5902F);
                cyVar.mo1949a(akVar.f5934m);
                cyVar.mo1960c();
            }
            if (akVar.m8909S()) {
                cyVar.mo1951a(ak.f5903G);
                cyVar.mo1948a(akVar.f5935n);
                cyVar.mo1960c();
            }
            if (akVar.f5936o != null && akVar.m8912V()) {
                cyVar.mo1951a(ak.f5904H);
                cyVar.mo1949a(akVar.f5936o);
                cyVar.mo1960c();
            }
            if (akVar.f5937p != null && akVar.m8915Y()) {
                cyVar.mo1951a(ak.f5905I);
                cyVar.mo1949a(akVar.f5937p);
                cyVar.mo1960c();
            }
            if (akVar.f5938q != null && akVar.ab()) {
                cyVar.mo1951a(ak.f5906J);
                cyVar.mo1949a(akVar.f5938q);
                cyVar.mo1960c();
            }
            cyVar.mo1961d();
            cyVar.mo1959b();
        }
    }

    /* compiled from: DeviceInfo */
    /* renamed from: u.aly.ak$b */
    private static class C1296b implements dh {
        private C1296b() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8876a();
        }

        /* renamed from: a */
        public C1295a m8876a() {
            return new C1295a();
        }
    }

    /* compiled from: DeviceInfo */
    /* renamed from: u.aly.ak$c */
    private static class C1297c extends dj<ak> {
        private C1297c() {
        }

        /* renamed from: a */
        public void m8878a(cy cyVar, ak akVar) throws cf {
            cyVar = (de) cyVar;
            BitSet bitSet = new BitSet();
            if (akVar.m8937e()) {
                bitSet.set(0);
            }
            if (akVar.m8949i()) {
                bitSet.set(1);
            }
            if (akVar.m8958l()) {
                bitSet.set(2);
            }
            if (akVar.m8965o()) {
                bitSet.set(3);
            }
            if (akVar.m8971r()) {
                bitSet.set(4);
            }
            if (akVar.m8975u()) {
                bitSet.set(5);
            }
            if (akVar.m8978x()) {
                bitSet.set(6);
            }
            if (akVar.m8891A()) {
                bitSet.set(7);
            }
            if (akVar.m8894D()) {
                bitSet.set(8);
            }
            if (akVar.m8897G()) {
                bitSet.set(9);
            }
            if (akVar.m8900J()) {
                bitSet.set(10);
            }
            if (akVar.m8903M()) {
                bitSet.set(11);
            }
            if (akVar.m8906P()) {
                bitSet.set(12);
            }
            if (akVar.m8909S()) {
                bitSet.set(13);
            }
            if (akVar.m8912V()) {
                bitSet.set(14);
            }
            if (akVar.m8915Y()) {
                bitSet.set(15);
            }
            if (akVar.ab()) {
                bitSet.set(16);
            }
            cyVar.m10341a(bitSet, 17);
            if (akVar.m8937e()) {
                cyVar.mo1949a(akVar.f5922a);
            }
            if (akVar.m8949i()) {
                cyVar.mo1949a(akVar.f5923b);
            }
            if (akVar.m8958l()) {
                cyVar.mo1949a(akVar.f5924c);
            }
            if (akVar.m8965o()) {
                cyVar.mo1949a(akVar.f5925d);
            }
            if (akVar.m8971r()) {
                cyVar.mo1949a(akVar.f5926e);
            }
            if (akVar.m8975u()) {
                cyVar.mo1949a(akVar.f5927f);
            }
            if (akVar.m8978x()) {
                cyVar.mo1949a(akVar.f5928g);
            }
            if (akVar.m8891A()) {
                cyVar.mo1949a(akVar.f5929h);
            }
            if (akVar.m8894D()) {
                akVar.f5930i.mo1924b(cyVar);
            }
            if (akVar.m8897G()) {
                cyVar.mo1958a(akVar.f5931j);
            }
            if (akVar.m8900J()) {
                cyVar.mo1958a(akVar.f5932k);
            }
            if (akVar.m8903M()) {
                cyVar.mo1949a(akVar.f5933l);
            }
            if (akVar.m8906P()) {
                cyVar.mo1949a(akVar.f5934m);
            }
            if (akVar.m8909S()) {
                cyVar.mo1948a(akVar.f5935n);
            }
            if (akVar.m8912V()) {
                cyVar.mo1949a(akVar.f5936o);
            }
            if (akVar.m8915Y()) {
                cyVar.mo1949a(akVar.f5937p);
            }
            if (akVar.ab()) {
                cyVar.mo1949a(akVar.f5938q);
            }
        }

        /* renamed from: b */
        public void m8880b(cy cyVar, ak akVar) throws cf {
            cyVar = (de) cyVar;
            BitSet b = cyVar.mo1986b(17);
            if (b.get(0)) {
                akVar.f5922a = cyVar.mo1983z();
                akVar.m8923a(true);
            }
            if (b.get(1)) {
                akVar.f5923b = cyVar.mo1983z();
                akVar.m8928b(true);
            }
            if (b.get(2)) {
                akVar.f5924c = cyVar.mo1983z();
                akVar.m8931c(true);
            }
            if (b.get(3)) {
                akVar.f5925d = cyVar.mo1983z();
                akVar.m8934d(true);
            }
            if (b.get(4)) {
                akVar.f5926e = cyVar.mo1983z();
                akVar.m8936e(true);
            }
            if (b.get(5)) {
                akVar.f5927f = cyVar.mo1983z();
                akVar.m8940f(true);
            }
            if (b.get(6)) {
                akVar.f5928g = cyVar.mo1983z();
                akVar.m8943g(true);
            }
            if (b.get(7)) {
                akVar.f5929h = cyVar.mo1983z();
                akVar.m8946h(true);
            }
            if (b.get(8)) {
                akVar.f5930i = new ba();
                akVar.f5930i.mo1921a(cyVar);
                akVar.m8948i(true);
            }
            if (b.get(9)) {
                akVar.f5931j = cyVar.mo1977t();
                akVar.m8955k(true);
            }
            if (b.get(10)) {
                akVar.f5932k = cyVar.mo1977t();
                akVar.m8961m(true);
            }
            if (b.get(11)) {
                akVar.f5933l = cyVar.mo1983z();
                akVar.m8963n(true);
            }
            if (b.get(12)) {
                akVar.f5934m = cyVar.mo1983z();
                akVar.m8964o(true);
            }
            if (b.get(13)) {
                akVar.f5935n = cyVar.mo1981x();
                akVar.m8967p(true);
            }
            if (b.get(14)) {
                akVar.f5936o = cyVar.mo1983z();
                akVar.m8969q(true);
            }
            if (b.get(15)) {
                akVar.f5937p = cyVar.mo1983z();
                akVar.m8970r(true);
            }
            if (b.get(16)) {
                akVar.f5938q = cyVar.mo1983z();
                akVar.m8973s(true);
            }
        }
    }

    /* compiled from: DeviceInfo */
    /* renamed from: u.aly.ak$d */
    private static class C1298d implements dh {
        private C1298d() {
        }

        /* renamed from: b */
        public /* synthetic */ dg mo1930b() {
            return m8882a();
        }

        /* renamed from: a */
        public C1297c m8882a() {
            return new C1297c();
        }
    }

    /* compiled from: DeviceInfo */
    /* renamed from: u.aly.ak$e */
    public enum C1299e implements cg {
        DEVICE_ID((short) 1, "device_id"),
        IDMD5((short) 2, C1248a.f5657d),
        MAC_ADDRESS((short) 3, "mac_address"),
        OPEN_UDID((short) 4, "open_udid"),
        MODEL((short) 5, "model"),
        CPU((short) 6, "cpu"),
        OS((short) 7, "os"),
        OS_VERSION((short) 8, "os_version"),
        RESOLUTION((short) 9, "resolution"),
        IS_JAILBROKEN((short) 10, "is_jailbroken"),
        IS_PIRATED((short) 11, "is_pirated"),
        DEVICE_BOARD((short) 12, "device_board"),
        DEVICE_BRAND((short) 13, "device_brand"),
        DEVICE_MANUTIME((short) 14, "device_manutime"),
        DEVICE_MANUFACTURER((short) 15, "device_manufacturer"),
        DEVICE_MANUID((short) 16, "device_manuid"),
        DEVICE_NAME((short) 17, "device_name");
        
        /* renamed from: r */
        private static final Map<String, C1299e> f5893r = null;
        /* renamed from: s */
        private final short f5895s;
        /* renamed from: t */
        private final String f5896t;

        static {
            f5893r = new HashMap();
            Iterator it = EnumSet.allOf(C1299e.class).iterator();
            while (it.hasNext()) {
                C1299e c1299e = (C1299e) it.next();
                f5893r.put(c1299e.mo1932b(), c1299e);
            }
        }

        /* renamed from: a */
        public static C1299e m8884a(int i) {
            switch (i) {
                case 1:
                    return DEVICE_ID;
                case 2:
                    return IDMD5;
                case 3:
                    return MAC_ADDRESS;
                case 4:
                    return OPEN_UDID;
                case 5:
                    return MODEL;
                case 6:
                    return CPU;
                case 7:
                    return OS;
                case 8:
                    return OS_VERSION;
                case 9:
                    return RESOLUTION;
                case 10:
                    return IS_JAILBROKEN;
                case 11:
                    return IS_PIRATED;
                case 12:
                    return DEVICE_BOARD;
                case 13:
                    return DEVICE_BRAND;
                case 14:
                    return DEVICE_MANUTIME;
                case 15:
                    return DEVICE_MANUFACTURER;
                case 16:
                    return DEVICE_MANUID;
                case 17:
                    return DEVICE_NAME;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static C1299e m8886b(int i) {
            C1299e a = C1299e.m8884a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static C1299e m8885a(String str) {
            return (C1299e) f5893r.get(str);
        }

        private C1299e(short s, String str) {
            this.f5895s = s;
            this.f5896t = str;
        }

        /* renamed from: a */
        public short mo1931a() {
            return this.f5895s;
        }

        /* renamed from: b */
        public String mo1932b() {
            return this.f5896t;
        }
    }

    /* renamed from: b */
    public /* synthetic */ cg mo1922b(int i) {
        return m8917a(i);
    }

    /* renamed from: g */
    public /* synthetic */ bz mo1925g() {
        return m8918a();
    }

    static {
        f5907K.put(di.class, new C1296b());
        f5907K.put(dj.class, new C1298d());
        Map enumMap = new EnumMap(C1299e.class);
        enumMap.put(C1299e.DEVICE_ID, new cl("device_id", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.IDMD5, new cl(C1248a.f5657d, (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.MAC_ADDRESS, new cl("mac_address", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.OPEN_UDID, new cl("open_udid", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.MODEL, new cl("model", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.CPU, new cl("cpu", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.OS, new cl("os", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.OS_VERSION, new cl("os_version", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.RESOLUTION, new cl("resolution", (byte) 2, new cq((byte) 12, ba.class)));
        enumMap.put(C1299e.IS_JAILBROKEN, new cl("is_jailbroken", (byte) 2, new cm((byte) 2)));
        enumMap.put(C1299e.IS_PIRATED, new cl("is_pirated", (byte) 2, new cm((byte) 2)));
        enumMap.put(C1299e.DEVICE_BOARD, new cl("device_board", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.DEVICE_BRAND, new cl("device_brand", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.DEVICE_MANUTIME, new cl("device_manutime", (byte) 2, new cm((byte) 10)));
        enumMap.put(C1299e.DEVICE_MANUFACTURER, new cl("device_manufacturer", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.DEVICE_MANUID, new cl("device_manuid", (byte) 2, new cm((byte) 11)));
        enumMap.put(C1299e.DEVICE_NAME, new cl("device_name", (byte) 2, new cm((byte) 11)));
        f5911r = Collections.unmodifiableMap(enumMap);
        cl.m10164a(ak.class, f5911r);
    }

    public ak() {
        this.f5920O = (byte) 0;
        this.f5921P = new C1299e[]{C1299e.DEVICE_ID, C1299e.IDMD5, C1299e.MAC_ADDRESS, C1299e.OPEN_UDID, C1299e.MODEL, C1299e.CPU, C1299e.OS, C1299e.OS_VERSION, C1299e.RESOLUTION, C1299e.IS_JAILBROKEN, C1299e.IS_PIRATED, C1299e.DEVICE_BOARD, C1299e.DEVICE_BRAND, C1299e.DEVICE_MANUTIME, C1299e.DEVICE_MANUFACTURER, C1299e.DEVICE_MANUID, C1299e.DEVICE_NAME};
    }

    public ak(ak akVar) {
        this.f5920O = (byte) 0;
        this.f5921P = new C1299e[]{C1299e.DEVICE_ID, C1299e.IDMD5, C1299e.MAC_ADDRESS, C1299e.OPEN_UDID, C1299e.MODEL, C1299e.CPU, C1299e.OS, C1299e.OS_VERSION, C1299e.RESOLUTION, C1299e.IS_JAILBROKEN, C1299e.IS_PIRATED, C1299e.DEVICE_BOARD, C1299e.DEVICE_BRAND, C1299e.DEVICE_MANUTIME, C1299e.DEVICE_MANUFACTURER, C1299e.DEVICE_MANUID, C1299e.DEVICE_NAME};
        this.f5920O = akVar.f5920O;
        if (akVar.m8937e()) {
            this.f5922a = akVar.f5922a;
        }
        if (akVar.m8949i()) {
            this.f5923b = akVar.f5923b;
        }
        if (akVar.m8958l()) {
            this.f5924c = akVar.f5924c;
        }
        if (akVar.m8965o()) {
            this.f5925d = akVar.f5925d;
        }
        if (akVar.m8971r()) {
            this.f5926e = akVar.f5926e;
        }
        if (akVar.m8975u()) {
            this.f5927f = akVar.f5927f;
        }
        if (akVar.m8978x()) {
            this.f5928g = akVar.f5928g;
        }
        if (akVar.m8891A()) {
            this.f5929h = akVar.f5929h;
        }
        if (akVar.m8894D()) {
            this.f5930i = new ba(akVar.f5930i);
        }
        this.f5931j = akVar.f5931j;
        this.f5932k = akVar.f5932k;
        if (akVar.m8903M()) {
            this.f5933l = akVar.f5933l;
        }
        if (akVar.m8906P()) {
            this.f5934m = akVar.f5934m;
        }
        this.f5935n = akVar.f5935n;
        if (akVar.m8912V()) {
            this.f5936o = akVar.f5936o;
        }
        if (akVar.m8915Y()) {
            this.f5937p = akVar.f5937p;
        }
        if (akVar.ab()) {
            this.f5938q = akVar.f5938q;
        }
    }

    /* renamed from: a */
    public ak m8918a() {
        return new ak(this);
    }

    /* renamed from: b */
    public void mo1923b() {
        this.f5922a = null;
        this.f5923b = null;
        this.f5924c = null;
        this.f5925d = null;
        this.f5926e = null;
        this.f5927f = null;
        this.f5928g = null;
        this.f5929h = null;
        this.f5930i = null;
        m8955k(false);
        this.f5931j = false;
        m8961m(false);
        this.f5932k = false;
        this.f5933l = null;
        this.f5934m = null;
        m8967p(false);
        this.f5935n = 0;
        this.f5936o = null;
        this.f5937p = null;
        this.f5938q = null;
    }

    /* renamed from: c */
    public String m8929c() {
        return this.f5922a;
    }

    /* renamed from: a */
    public ak m8920a(String str) {
        this.f5922a = str;
        return this;
    }

    /* renamed from: d */
    public void m8933d() {
        this.f5922a = null;
    }

    /* renamed from: e */
    public boolean m8937e() {
        return this.f5922a != null;
    }

    /* renamed from: a */
    public void m8923a(boolean z) {
        if (!z) {
            this.f5922a = null;
        }
    }

    /* renamed from: f */
    public String m8938f() {
        return this.f5923b;
    }

    /* renamed from: b */
    public ak m8924b(String str) {
        this.f5923b = str;
        return this;
    }

    /* renamed from: h */
    public void m8945h() {
        this.f5923b = null;
    }

    /* renamed from: i */
    public boolean m8949i() {
        return this.f5923b != null;
    }

    /* renamed from: b */
    public void m8928b(boolean z) {
        if (!z) {
            this.f5923b = null;
        }
    }

    /* renamed from: j */
    public String m8950j() {
        return this.f5924c;
    }

    /* renamed from: c */
    public ak m8930c(String str) {
        this.f5924c = str;
        return this;
    }

    /* renamed from: k */
    public void m8954k() {
        this.f5924c = null;
    }

    /* renamed from: l */
    public boolean m8958l() {
        return this.f5924c != null;
    }

    /* renamed from: c */
    public void m8931c(boolean z) {
        if (!z) {
            this.f5924c = null;
        }
    }

    /* renamed from: m */
    public String m8959m() {
        return this.f5925d;
    }

    /* renamed from: d */
    public ak m8932d(String str) {
        this.f5925d = str;
        return this;
    }

    /* renamed from: n */
    public void m8962n() {
        this.f5925d = null;
    }

    /* renamed from: o */
    public boolean m8965o() {
        return this.f5925d != null;
    }

    /* renamed from: d */
    public void m8934d(boolean z) {
        if (!z) {
            this.f5925d = null;
        }
    }

    /* renamed from: p */
    public String m8966p() {
        return this.f5926e;
    }

    /* renamed from: e */
    public ak m8935e(String str) {
        this.f5926e = str;
        return this;
    }

    /* renamed from: q */
    public void m8968q() {
        this.f5926e = null;
    }

    /* renamed from: r */
    public boolean m8971r() {
        return this.f5926e != null;
    }

    /* renamed from: e */
    public void m8936e(boolean z) {
        if (!z) {
            this.f5926e = null;
        }
    }

    /* renamed from: s */
    public String m8972s() {
        return this.f5927f;
    }

    /* renamed from: f */
    public ak m8939f(String str) {
        this.f5927f = str;
        return this;
    }

    /* renamed from: t */
    public void m8974t() {
        this.f5927f = null;
    }

    /* renamed from: u */
    public boolean m8975u() {
        return this.f5927f != null;
    }

    /* renamed from: f */
    public void m8940f(boolean z) {
        if (!z) {
            this.f5927f = null;
        }
    }

    /* renamed from: v */
    public String m8976v() {
        return this.f5928g;
    }

    /* renamed from: g */
    public ak m8941g(String str) {
        this.f5928g = str;
        return this;
    }

    /* renamed from: w */
    public void m8977w() {
        this.f5928g = null;
    }

    /* renamed from: x */
    public boolean m8978x() {
        return this.f5928g != null;
    }

    /* renamed from: g */
    public void m8943g(boolean z) {
        if (!z) {
            this.f5928g = null;
        }
    }

    /* renamed from: y */
    public String m8979y() {
        return this.f5929h;
    }

    /* renamed from: h */
    public ak m8944h(String str) {
        this.f5929h = str;
        return this;
    }

    /* renamed from: z */
    public void m8980z() {
        this.f5929h = null;
    }

    /* renamed from: A */
    public boolean m8891A() {
        return this.f5929h != null;
    }

    /* renamed from: h */
    public void m8946h(boolean z) {
        if (!z) {
            this.f5929h = null;
        }
    }

    /* renamed from: B */
    public ba m8892B() {
        return this.f5930i;
    }

    /* renamed from: a */
    public ak m8921a(ba baVar) {
        this.f5930i = baVar;
        return this;
    }

    /* renamed from: C */
    public void m8893C() {
        this.f5930i = null;
    }

    /* renamed from: D */
    public boolean m8894D() {
        return this.f5930i != null;
    }

    /* renamed from: i */
    public void m8948i(boolean z) {
        if (!z) {
            this.f5930i = null;
        }
    }

    /* renamed from: E */
    public boolean m8895E() {
        return this.f5931j;
    }

    /* renamed from: j */
    public ak m8952j(boolean z) {
        this.f5931j = z;
        m8955k(true);
        return this;
    }

    /* renamed from: F */
    public void m8896F() {
        this.f5920O = bw.m10080b(this.f5920O, 0);
    }

    /* renamed from: G */
    public boolean m8897G() {
        return bw.m10076a(this.f5920O, 0);
    }

    /* renamed from: k */
    public void m8955k(boolean z) {
        this.f5920O = bw.m10068a(this.f5920O, 0, z);
    }

    /* renamed from: H */
    public boolean m8898H() {
        return this.f5932k;
    }

    /* renamed from: l */
    public ak m8957l(boolean z) {
        this.f5932k = z;
        m8961m(true);
        return this;
    }

    /* renamed from: I */
    public void m8899I() {
        this.f5920O = bw.m10080b(this.f5920O, 1);
    }

    /* renamed from: J */
    public boolean m8900J() {
        return bw.m10076a(this.f5920O, 1);
    }

    /* renamed from: m */
    public void m8961m(boolean z) {
        this.f5920O = bw.m10068a(this.f5920O, 1, z);
    }

    /* renamed from: K */
    public String m8901K() {
        return this.f5933l;
    }

    /* renamed from: i */
    public ak m8947i(String str) {
        this.f5933l = str;
        return this;
    }

    /* renamed from: L */
    public void m8902L() {
        this.f5933l = null;
    }

    /* renamed from: M */
    public boolean m8903M() {
        return this.f5933l != null;
    }

    /* renamed from: n */
    public void m8963n(boolean z) {
        if (!z) {
            this.f5933l = null;
        }
    }

    /* renamed from: N */
    public String m8904N() {
        return this.f5934m;
    }

    /* renamed from: j */
    public ak m8951j(String str) {
        this.f5934m = str;
        return this;
    }

    /* renamed from: O */
    public void m8905O() {
        this.f5934m = null;
    }

    /* renamed from: P */
    public boolean m8906P() {
        return this.f5934m != null;
    }

    /* renamed from: o */
    public void m8964o(boolean z) {
        if (!z) {
            this.f5934m = null;
        }
    }

    /* renamed from: Q */
    public long m8907Q() {
        return this.f5935n;
    }

    /* renamed from: a */
    public ak m8919a(long j) {
        this.f5935n = j;
        m8967p(true);
        return this;
    }

    /* renamed from: R */
    public void m8908R() {
        this.f5920O = bw.m10080b(this.f5920O, 2);
    }

    /* renamed from: S */
    public boolean m8909S() {
        return bw.m10076a(this.f5920O, 2);
    }

    /* renamed from: p */
    public void m8967p(boolean z) {
        this.f5920O = bw.m10068a(this.f5920O, 2, z);
    }

    /* renamed from: T */
    public String m8910T() {
        return this.f5936o;
    }

    /* renamed from: k */
    public ak m8953k(String str) {
        this.f5936o = str;
        return this;
    }

    /* renamed from: U */
    public void m8911U() {
        this.f5936o = null;
    }

    /* renamed from: V */
    public boolean m8912V() {
        return this.f5936o != null;
    }

    /* renamed from: q */
    public void m8969q(boolean z) {
        if (!z) {
            this.f5936o = null;
        }
    }

    /* renamed from: W */
    public String m8913W() {
        return this.f5937p;
    }

    /* renamed from: l */
    public ak m8956l(String str) {
        this.f5937p = str;
        return this;
    }

    /* renamed from: X */
    public void m8914X() {
        this.f5937p = null;
    }

    /* renamed from: Y */
    public boolean m8915Y() {
        return this.f5937p != null;
    }

    /* renamed from: r */
    public void m8970r(boolean z) {
        if (!z) {
            this.f5937p = null;
        }
    }

    /* renamed from: Z */
    public String m8916Z() {
        return this.f5938q;
    }

    /* renamed from: m */
    public ak m8960m(String str) {
        this.f5938q = str;
        return this;
    }

    public void aa() {
        this.f5938q = null;
    }

    public boolean ab() {
        return this.f5938q != null;
    }

    /* renamed from: s */
    public void m8973s(boolean z) {
        if (!z) {
            this.f5938q = null;
        }
    }

    /* renamed from: a */
    public C1299e m8917a(int i) {
        return C1299e.m8884a(i);
    }

    /* renamed from: a */
    public void mo1921a(cy cyVar) throws cf {
        ((dh) f5907K.get(cyVar.mo1985D())).mo1930b().mo1929b(cyVar, this);
    }

    /* renamed from: b */
    public void mo1924b(cy cyVar) throws cf {
        ((dh) f5907K.get(cyVar.mo1985D())).mo1930b().mo1928a(cyVar, this);
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("DeviceInfo(");
        Object obj2 = 1;
        if (m8937e()) {
            stringBuilder.append("device_id:");
            if (this.f5922a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5922a);
            }
            obj2 = null;
        }
        if (m8949i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("idmd5:");
            if (this.f5923b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5923b);
            }
            obj2 = null;
        }
        if (m8958l()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("mac_address:");
            if (this.f5924c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5924c);
            }
            obj2 = null;
        }
        if (m8965o()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("open_udid:");
            if (this.f5925d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5925d);
            }
            obj2 = null;
        }
        if (m8971r()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("model:");
            if (this.f5926e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5926e);
            }
            obj2 = null;
        }
        if (m8975u()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("cpu:");
            if (this.f5927f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5927f);
            }
            obj2 = null;
        }
        if (m8978x()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("os:");
            if (this.f5928g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5928g);
            }
            obj2 = null;
        }
        if (m8891A()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("os_version:");
            if (this.f5929h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5929h);
            }
            obj2 = null;
        }
        if (m8894D()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("resolution:");
            if (this.f5930i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5930i);
            }
            obj2 = null;
        }
        if (m8897G()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("is_jailbroken:");
            stringBuilder.append(this.f5931j);
            obj2 = null;
        }
        if (m8900J()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("is_pirated:");
            stringBuilder.append(this.f5932k);
            obj2 = null;
        }
        if (m8903M()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_board:");
            if (this.f5933l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5933l);
            }
            obj2 = null;
        }
        if (m8906P()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_brand:");
            if (this.f5934m == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5934m);
            }
            obj2 = null;
        }
        if (m8909S()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manutime:");
            stringBuilder.append(this.f5935n);
            obj2 = null;
        }
        if (m8912V()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manufacturer:");
            if (this.f5936o == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5936o);
            }
            obj2 = null;
        }
        if (m8915Y()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manuid:");
            if (this.f5937p == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5937p);
            }
        } else {
            obj = obj2;
        }
        if (ab()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_name:");
            if (this.f5938q == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f5938q);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void ac() throws cf {
        if (this.f5930i != null) {
            this.f5930i.m9636j();
        }
    }

    /* renamed from: a */
    private void m8890a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo1924b(new cs(new dk((OutputStream) objectOutputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m8889a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f5920O = (byte) 0;
            mo1921a(new cs(new dk((InputStream) objectInputStream)));
        } catch (cf e) {
            throw new IOException(e.getMessage());
        }
    }
}
