package p054u.aly;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TCompactProtocol */
/* renamed from: u.aly.cs */
public class cs extends cy {
    /* renamed from: d */
    private static final dd f6467d = new dd(bi_常量类.f6358b);
    /* renamed from: e */
    private static final ct f6468e = new ct(bi_常量类.f6358b, (byte) 0, (short) 0);
    /* renamed from: f */
    private static final byte[] f6469f = new byte[16];
    /* renamed from: h */
    private static final byte f6470h = (byte) -126;
    /* renamed from: i */
    private static final byte f6471i = (byte) 1;
    /* renamed from: j */
    private static final byte f6472j = (byte) 31;
    /* renamed from: k */
    private static final byte f6473k = (byte) -32;
    /* renamed from: l */
    private static final int f6474l = 5;
    /* renamed from: a */
    byte[] f6475a;
    /* renamed from: b */
    byte[] f6476b;
    /* renamed from: c */
    byte[] f6477c;
    /* renamed from: m */
    private bx f6478m;
    /* renamed from: n */
    private short f6479n;
    /* renamed from: o */
    private ct f6480o;
    /* renamed from: p */
    private Boolean f6481p;
    /* renamed from: q */
    private final long f6482q;
    /* renamed from: r */
    private byte[] f6483r;

    /* compiled from: TCompactProtocol */
    /* renamed from: u.aly.cs$a */
    public static class C1429a implements da {
        /* renamed from: a */
        private final long f6454a;

        public C1429a() {
            this.f6454a = -1;
        }

        public C1429a(int i) {
            this.f6454a = (long) i;
        }

        /* renamed from: a */
        public cy mo1942a(dm dmVar) {
            return new cs(dmVar, this.f6454a);
        }
    }

    /* compiled from: TCompactProtocol */
    /* renamed from: u.aly.cs$b */
    private static class C1430b {
        /* renamed from: a */
        public static final byte f6455a = (byte) 1;
        /* renamed from: b */
        public static final byte f6456b = (byte) 2;
        /* renamed from: c */
        public static final byte f6457c = (byte) 3;
        /* renamed from: d */
        public static final byte f6458d = (byte) 4;
        /* renamed from: e */
        public static final byte f6459e = (byte) 5;
        /* renamed from: f */
        public static final byte f6460f = (byte) 6;
        /* renamed from: g */
        public static final byte f6461g = (byte) 7;
        /* renamed from: h */
        public static final byte f6462h = (byte) 8;
        /* renamed from: i */
        public static final byte f6463i = (byte) 9;
        /* renamed from: j */
        public static final byte f6464j = (byte) 10;
        /* renamed from: k */
        public static final byte f6465k = (byte) 11;
        /* renamed from: l */
        public static final byte f6466l = (byte) 12;

        private C1430b() {
        }
    }

    static {
        f6469f[0] = (byte) 0;
        f6469f[2] = (byte) 1;
        f6469f[3] = (byte) 3;
        f6469f[6] = (byte) 4;
        f6469f[8] = (byte) 5;
        f6469f[10] = (byte) 6;
        f6469f[4] = (byte) 7;
        f6469f[11] = (byte) 8;
        f6469f[15] = (byte) 9;
        f6469f[14] = (byte) 10;
        f6469f[13] = (byte) 11;
        f6469f[12] = (byte) 12;
    }

    public cs(dm dmVar, long j) {
        super(dmVar);
        this.f6478m = new bx(15);
        this.f6479n = (short) 0;
        this.f6480o = null;
        this.f6481p = null;
        this.f6475a = new byte[5];
        this.f6476b = new byte[10];
        this.f6483r = new byte[1];
        this.f6477c = new byte[1];
        this.f6482q = j;
    }

    public cs(dm dmVar) {
        this(dmVar, -1);
    }

    /* renamed from: B */
    public void mo1984B() {
        this.f6478m.m10088c();
        this.f6479n = (short) 0;
    }

    /* renamed from: a */
    public void mo1954a(cw cwVar) throws cf {
        m10263b((byte) f6470h);
        m10271d(((cwVar.f6493b << 5) & -32) | 1);
        mo1986b(cwVar.f6494c);
        mo1949a(cwVar.f6492a);
    }

    /* renamed from: a */
    public void mo1956a(dd ddVar) throws cf {
        this.f6478m.m10086a(this.f6479n);
        this.f6479n = (short) 0;
    }

    /* renamed from: b */
    public void mo1959b() throws cf {
        this.f6479n = this.f6478m.m10085a();
    }

    /* renamed from: a */
    public void mo1951a(ct ctVar) throws cf {
        if (ctVar.f6485b == (byte) 2) {
            this.f6480o = ctVar;
        } else {
            m10261a(ctVar, (byte) -1);
        }
    }

    /* renamed from: a */
    private void m10261a(ct ctVar, byte b) throws cf {
        if (b == (byte) -1) {
            b = m10272e(ctVar.f6485b);
        }
        if (ctVar.f6486c <= this.f6479n || ctVar.f6486c - this.f6479n > 15) {
            m10263b(b);
            mo1957a(ctVar.f6486c);
        } else {
            m10271d(((ctVar.f6486c - this.f6479n) << 4) | b);
        }
        this.f6479n = ctVar.f6486c;
    }

    /* renamed from: d */
    public void mo1961d() throws cf {
        m10263b((byte) 0);
    }

    /* renamed from: a */
    public void mo1953a(cv cvVar) throws cf {
        if (cvVar.f6491c == 0) {
            m10271d(0);
            return;
        }
        mo1986b(cvVar.f6491c);
        m10271d((m10272e(cvVar.f6489a) << 4) | m10272e(cvVar.f6490b));
    }

    /* renamed from: a */
    public void mo1952a(cu cuVar) throws cf {
        m10280a(cuVar.f6487a, cuVar.f6488b);
    }

    /* renamed from: a */
    public void mo1955a(dc dcVar) throws cf {
        m10280a(dcVar.f6514a, dcVar.f6515b);
    }

    /* renamed from: a */
    public void mo1958a(boolean z) throws cf {
        byte b = (byte) 1;
        if (this.f6480o != null) {
            ct ctVar = this.f6480o;
            if (!z) {
                b = (byte) 2;
            }
            m10261a(ctVar, b);
            this.f6480o = null;
            return;
        }
        if (!z) {
            b = (byte) 2;
        }
        m10263b(b);
    }

    /* renamed from: a */
    public void mo1945a(byte b) throws cf {
        m10263b(b);
    }

    /* renamed from: a */
    public void mo1957a(short s) throws cf {
        mo1986b(m10266c((int) s));
    }

    /* renamed from: a */
    public void mo1947a(int i) throws cf {
        mo1986b(m10266c(i));
    }

    /* renamed from: a */
    public void mo1948a(long j) throws cf {
        m10265b(m10267c(j));
    }

    /* renamed from: a */
    public void mo1946a(double d) throws cf {
        byte[] bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        m10260a(Double.doubleToLongBits(d), bArr, 0);
        this.g.m10347b(bArr);
    }

    /* renamed from: a */
    public void mo1949a(String str) throws cf {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m10262a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new cf("UTF-8 not supported!");
        }
    }

    /* renamed from: a */
    public void mo1950a(ByteBuffer byteBuffer) throws cf {
        m10262a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    /* renamed from: a */
    private void m10262a(byte[] bArr, int i, int i2) throws cf {
        mo1986b(i2);
        this.g.mo1990b(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo1944a() throws cf {
    }

    /* renamed from: e */
    public void mo1962e() throws cf {
    }

    /* renamed from: f */
    public void mo1963f() throws cf {
    }

    /* renamed from: g */
    public void mo1964g() throws cf {
    }

    /* renamed from: c */
    public void mo1960c() throws cf {
    }

    /* renamed from: a */
    protected void m10280a(byte b, int i) throws cf {
        if (i <= 14) {
            m10271d((i << 4) | m10272e(b));
            return;
        }
        m10271d(m10272e(b) | 240);
        mo1986b(i);
    }

    /* renamed from: b */
    private void mo1986b(int i) throws cf {
        int i2 = 0;
        while ((i & -128) != 0) {
            int i3 = i2 + 1;
            this.f6475a[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2 = i3;
        }
        int i4 = i2 + 1;
        this.f6475a[i2] = (byte) i;
        this.g.mo1990b(this.f6475a, 0, i4);
    }

    /* renamed from: b */
    private void m10265b(long j) throws cf {
        int i = 0;
        while ((-128 & j) != 0) {
            int i2 = i + 1;
            this.f6476b[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i = i2;
        }
        int i3 = i + 1;
        this.f6476b[i] = (byte) ((int) j);
        this.g.mo1990b(this.f6476b, 0, i3);
    }

    /* renamed from: c */
    private long m10267c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: c */
    private int m10266c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* renamed from: a */
    private void m10260a(long j, byte[] bArr, int i) {
        bArr[i + 0] = (byte) ((int) (j & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 7] = (byte) ((int) ((j >> 56) & 255));
    }

    /* renamed from: b */
    private void m10263b(byte b) throws cf {
        this.f6483r[0] = b;
        this.g.m10347b(this.f6483r);
    }

    /* renamed from: d */
    private void m10271d(int i) throws cf {
        m10263b((byte) i);
    }

    /* renamed from: h */
    public cw mo1965h() throws cf {
        byte u = mo1978u();
        if (u != f6470h) {
            throw new cz("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
        }
        u = mo1978u();
        byte b = (byte) (u & 31);
        if (b != (byte) 1) {
            throw new cz("Expected version 1 but got " + b);
        }
        return new cw(mo1983z(), (byte) ((u >> 5) & 3), m10257E());
    }

    /* renamed from: j */
    public dd mo1967j() throws cf {
        this.f6478m.m10086a(this.f6479n);
        this.f6479n = (short) 0;
        return f6467d;
    }

    /* renamed from: k */
    public void mo1968k() throws cf {
        this.f6479n = this.f6478m.m10085a();
    }

    /* renamed from: l */
    public ct mo1969l() throws cf {
        byte u = mo1978u();
        if (u == (byte) 0) {
            return f6468e;
        }
        short s = (short) ((u & 240) >> 4);
        if (s == (short) 0) {
            s = mo1979v();
        } else {
            s = (short) (s + this.f6479n);
        }
        ct ctVar = new ct(bi_常量类.f6358b, m10269d((byte) (u & 15)), s);
        if (m10268c(u)) {
            this.f6481p = ((byte) (u & 15)) == (byte) 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f6479n = ctVar.f6486c;
        return ctVar;
    }

    /* renamed from: n */
    public cv mo1971n() throws cf {
        int E = m10257E();
        int u = E == 0 ? 0 : mo1978u();
        return new cv(m10269d((byte) (u >> 4)), m10269d((byte) (u & 15)), E);
    }

    /* renamed from: p */
    public cu mo1973p() throws cf {
        byte u = mo1978u();
        int i = (u >> 4) & 15;
        if (i == 15) {
            i = m10257E();
        }
        return new cu(m10269d(u), i);
    }

    /* renamed from: r */
    public dc mo1975r() throws cf {
        return new dc(mo1973p());
    }

    /* renamed from: t */
    public boolean mo1977t() throws cf {
        if (this.f6481p != null) {
            boolean booleanValue = this.f6481p.booleanValue();
            this.f6481p = null;
            return booleanValue;
        } else if (mo1978u() != (byte) 1) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: u */
    public byte mo1978u() throws cf {
        if (this.g.mo1996h() > 0) {
            byte b = this.g.mo1994f()[this.g.mo1995g()];
            this.g.mo1993a(1);
            return b;
        }
        this.g.m10350d(this.f6477c, 0, 1);
        return this.f6477c[0];
    }

    /* renamed from: v */
    public short mo1979v() throws cf {
        return (short) m10275g(m10257E());
    }

    /* renamed from: w */
    public int mo1980w() throws cf {
        return m10275g(m10257E());
    }

    /* renamed from: x */
    public long mo1981x() throws cf {
        return m10270d(m10258F());
    }

    /* renamed from: y */
    public double mo1982y() throws cf {
        byte[] bArr = new byte[8];
        this.g.m10350d(bArr, 0, 8);
        return Double.longBitsToDouble(m10259a(bArr));
    }

    /* renamed from: z */
    public String mo1983z() throws cf {
        int E = m10257E();
        m10274f(E);
        if (E == 0) {
            return bi_常量类.f6358b;
        }
        try {
            if (this.g.mo1996h() < E) {
                return new String(m10273e(E), "UTF-8");
            }
            String str = new String(this.g.mo1994f(), this.g.mo1995g(), E, "UTF-8");
            this.g.mo1993a(E);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new cf("UTF-8 not supported!");
        }
    }

    /* renamed from: A */
    public ByteBuffer mo1943A() throws cf {
        int E = m10257E();
        m10274f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.m10350d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: e */
    private byte[] m10273e(int i) throws cf {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.g.m10350d(bArr, 0, i);
        return bArr;
    }

    /* renamed from: f */
    private void m10274f(int i) throws cz {
        if (i < 0) {
            throw new cz("Negative length: " + i);
        } else if (this.f6482q != -1 && ((long) i) > this.f6482q) {
            throw new cz("Length exceeded max allowed: " + i);
        }
    }

    /* renamed from: i */
    public void mo1966i() throws cf {
    }

    /* renamed from: m */
    public void mo1970m() throws cf {
    }

    /* renamed from: o */
    public void mo1972o() throws cf {
    }

    /* renamed from: q */
    public void mo1974q() throws cf {
    }

    /* renamed from: s */
    public void mo1976s() throws cf {
    }

    /* renamed from: E */
    private int m10257E() throws cf {
        int i = 0;
        int i2;
        if (this.g.mo1996h() >= 5) {
            byte[] f = this.g.mo1994f();
            int g = this.g.mo1995g();
            i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = f[g + i];
                i3 |= (b & 127) << i2;
                if ((b & 128) != 128) {
                    this.g.mo1993a(i + 1);
                    return i3;
                }
                i2 += 7;
                i++;
            }
        } else {
            i2 = 0;
            while (true) {
                byte u = mo1978u();
                i2 |= (u & 127) << i;
                if ((u & 128) != 128) {
                    return i2;
                }
                i += 7;
            }
        }
    }

    /* renamed from: F */
    private long m10258F() throws cf {
        long j = null;
        long j2 = 0;
        if (this.g.mo1996h() >= 10) {
            int i;
            byte[] f = this.g.mo1994f();
            int g = this.g.mo1995g();
            long j3 = 0;
            while (true) {
                byte b = f[g + i];
                j2 |= ((long) (b & 127)) << j3;
                if ((b & 128) != 128) {
                    break;
                }
                j3 += 7;
                i++;
            }
            this.g.mo1993a(i + 1);
        } else {
            while (true) {
                byte u = mo1978u();
                j2 |= ((long) (u & 127)) << j;
                if ((u & 128) != 128) {
                    break;
                }
                j += 7;
            }
        }
        return j2;
    }

    /* renamed from: g */
    private int m10275g(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    /* renamed from: d */
    private long m10270d(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    /* renamed from: a */
    private long m10259a(byte[] bArr) {
        return ((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[5]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)) | (((long) bArr[0]) & 255);
    }

    /* renamed from: c */
    private boolean m10268c(byte b) {
        int i = b & 15;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private byte m10269d(byte b) throws cz {
        switch ((byte) (b & 15)) {
            case (byte) 0:
                return (byte) 0;
            case (byte) 1:
            case (byte) 2:
                return (byte) 2;
            case (byte) 3:
                return (byte) 3;
            case (byte) 4:
                return (byte) 6;
            case (byte) 5:
                return (byte) 8;
            case (byte) 6:
                return (byte) 10;
            case (byte) 7:
                return (byte) 4;
            case (byte) 8:
                return (byte) 11;
            case (byte) 9:
                return df.f6529m;
            case (byte) 10:
                return df.f6528l;
            case (byte) 11:
                return df.f6527k;
            case (byte) 12:
                return (byte) 12;
            default:
                throw new cz("don't know what type: " + ((byte) (b & 15)));
        }
    }

    /* renamed from: e */
    private byte m10272e(byte b) {
        return f6469f[b];
    }
}
