package p054u.aly;

import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TBinaryProtocol */
/* renamed from: u.aly.cr */
public class cr extends cy {
    /* renamed from: a */
    protected static final int f6439a = -65536;
    /* renamed from: b */
    protected static final int f6440b = -2147418112;
    /* renamed from: h */
    private static final dd f6441h = new dd();
    /* renamed from: c */
    protected boolean f6442c;
    /* renamed from: d */
    protected boolean f6443d;
    /* renamed from: e */
    protected int f6444e;
    /* renamed from: f */
    protected boolean f6445f;
    /* renamed from: i */
    private byte[] f6446i;
    /* renamed from: j */
    private byte[] f6447j;
    /* renamed from: k */
    private byte[] f6448k;
    /* renamed from: l */
    private byte[] f6449l;
    /* renamed from: m */
    private byte[] f6450m;
    /* renamed from: n */
    private byte[] f6451n;
    /* renamed from: o */
    private byte[] f6452o;
    /* renamed from: p */
    private byte[] f6453p;

    /* compiled from: TBinaryProtocol */
    /* renamed from: u.aly.cr$a */
    public static class C1428a implements da {
        /* renamed from: a */
        protected boolean f6435a;
        /* renamed from: b */
        protected boolean f6436b;
        /* renamed from: c */
        protected int f6437c;

        public C1428a() {
            this(false, true);
        }

        public C1428a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C1428a(boolean z, boolean z2, int i) {
            this.f6435a = false;
            this.f6436b = true;
            this.f6435a = z;
            this.f6436b = z2;
            this.f6437c = i;
        }

        /* renamed from: a */
        public cy mo1942a(dm dmVar) {
            cy crVar = new cr(dmVar, this.f6435a, this.f6436b);
            if (this.f6437c != 0) {
                crVar.m10231c(this.f6437c);
            }
            return crVar;
        }
    }

    public cr(dm dmVar) {
        this(dmVar, false, true);
    }

    public cr(dm dmVar, boolean z, boolean z2) {
        super(dmVar);
        this.f6442c = false;
        this.f6443d = true;
        this.f6445f = false;
        this.f6446i = new byte[1];
        this.f6447j = new byte[2];
        this.f6448k = new byte[4];
        this.f6449l = new byte[8];
        this.f6450m = new byte[1];
        this.f6451n = new byte[2];
        this.f6452o = new byte[4];
        this.f6453p = new byte[8];
        this.f6442c = z;
        this.f6443d = z2;
    }

    /* renamed from: a */
    public void mo1954a(cw cwVar) throws cf {
        if (this.f6443d) {
            mo1947a(f6440b | cwVar.f6493b);
            mo1949a(cwVar.f6492a);
            mo1947a(cwVar.f6494c);
            return;
        }
        mo1949a(cwVar.f6492a);
        mo1945a(cwVar.f6493b);
        mo1947a(cwVar.f6494c);
    }

    /* renamed from: a */
    public void mo1944a() {
    }

    /* renamed from: a */
    public void mo1956a(dd ddVar) {
    }

    /* renamed from: b */
    public void mo1959b() {
    }

    /* renamed from: a */
    public void mo1951a(ct ctVar) throws cf {
        mo1945a(ctVar.f6485b);
        mo1957a(ctVar.f6486c);
    }

    /* renamed from: c */
    public void mo1960c() {
    }

    /* renamed from: d */
    public void mo1961d() throws cf {
        mo1945a((byte) 0);
    }

    /* renamed from: a */
    public void mo1953a(cv cvVar) throws cf {
        mo1945a(cvVar.f6489a);
        mo1945a(cvVar.f6490b);
        mo1947a(cvVar.f6491c);
    }

    /* renamed from: e */
    public void mo1962e() {
    }

    /* renamed from: a */
    public void mo1952a(cu cuVar) throws cf {
        mo1945a(cuVar.f6487a);
        mo1947a(cuVar.f6488b);
    }

    /* renamed from: f */
    public void mo1963f() {
    }

    /* renamed from: a */
    public void mo1955a(dc dcVar) throws cf {
        mo1945a(dcVar.f6514a);
        mo1947a(dcVar.f6515b);
    }

    /* renamed from: g */
    public void mo1964g() {
    }

    /* renamed from: a */
    public void mo1958a(boolean z) throws cf {
        mo1945a(z ? (byte) 1 : (byte) 0);
    }

    /* renamed from: a */
    public void mo1945a(byte b) throws cf {
        this.f6446i[0] = b;
        this.g.mo1990b(this.f6446i, 0, 1);
    }

    /* renamed from: a */
    public void mo1957a(short s) throws cf {
        this.f6447j[0] = (byte) ((s >> 8) & WebView.NORMAL_MODE_ALPHA);
        this.f6447j[1] = (byte) (s & WebView.NORMAL_MODE_ALPHA);
        this.g.mo1990b(this.f6447j, 0, 2);
    }

    /* renamed from: a */
    public void mo1947a(int i) throws cf {
        this.f6448k[0] = (byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA);
        this.f6448k[1] = (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA);
        this.f6448k[2] = (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA);
        this.f6448k[3] = (byte) (i & WebView.NORMAL_MODE_ALPHA);
        this.g.mo1990b(this.f6448k, 0, 4);
    }

    /* renamed from: a */
    public void mo1948a(long j) throws cf {
        this.f6449l[0] = (byte) ((int) ((j >> 56) & 255));
        this.f6449l[1] = (byte) ((int) ((j >> 48) & 255));
        this.f6449l[2] = (byte) ((int) ((j >> 40) & 255));
        this.f6449l[3] = (byte) ((int) ((j >> 32) & 255));
        this.f6449l[4] = (byte) ((int) ((j >> 24) & 255));
        this.f6449l[5] = (byte) ((int) ((j >> 16) & 255));
        this.f6449l[6] = (byte) ((int) ((j >> 8) & 255));
        this.f6449l[7] = (byte) ((int) (255 & j));
        this.g.mo1990b(this.f6449l, 0, 8);
    }

    /* renamed from: a */
    public void mo1946a(double d) throws cf {
        mo1948a(Double.doubleToLongBits(d));
    }

    /* renamed from: a */
    public void mo1949a(String str) throws cf {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo1947a(bytes.length);
            this.g.mo1990b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new cf("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a */
    public void mo1950a(ByteBuffer byteBuffer) throws cf {
        int limit = byteBuffer.limit() - byteBuffer.position();
        mo1947a(limit);
        this.g.mo1990b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    /* renamed from: h */
    public cw mo1965h() throws cf {
        int w = mo1980w();
        if (w < 0) {
            if ((-65536 & w) == f6440b) {
                return new cw(mo1983z(), (byte) (w & WebView.NORMAL_MODE_ALPHA), mo1980w());
            }
            throw new cz(4, "Bad version in readMessageBegin");
        } else if (!this.f6442c) {
            return new cw(m10228b(w), mo1978u(), mo1980w());
        } else {
            throw new cz(4, "Missing version in readMessageBegin, old client?");
        }
    }

    /* renamed from: i */
    public void mo1966i() {
    }

    /* renamed from: j */
    public dd mo1967j() {
        return f6441h;
    }

    /* renamed from: k */
    public void mo1968k() {
    }

    /* renamed from: l */
    public ct mo1969l() throws cf {
        byte u = mo1978u();
        return new ct(bi_常量类.f6358b, u, u == (byte) 0 ? (short) 0 : mo1979v());
    }

    /* renamed from: m */
    public void mo1970m() {
    }

    /* renamed from: n */
    public cv mo1971n() throws cf {
        return new cv(mo1978u(), mo1978u(), mo1980w());
    }

    /* renamed from: o */
    public void mo1972o() {
    }

    /* renamed from: p */
    public cu mo1973p() throws cf {
        return new cu(mo1978u(), mo1980w());
    }

    /* renamed from: q */
    public void mo1974q() {
    }

    /* renamed from: r */
    public dc mo1975r() throws cf {
        return new dc(mo1978u(), mo1980w());
    }

    /* renamed from: s */
    public void mo1976s() {
    }

    /* renamed from: t */
    public boolean mo1977t() throws cf {
        return mo1978u() == (byte) 1;
    }

    /* renamed from: u */
    public byte mo1978u() throws cf {
        if (this.g.mo1996h() >= 1) {
            byte b = this.g.mo1994f()[this.g.mo1995g()];
            this.g.mo1993a(1);
            return b;
        }
        m10211a(this.f6450m, 0, 1);
        return this.f6450m[0];
    }

    /* renamed from: v */
    public short mo1979v() throws cf {
        int i = 0;
        byte[] bArr = this.f6451n;
        if (this.g.mo1996h() >= 2) {
            bArr = this.g.mo1994f();
            i = this.g.mo1995g();
            this.g.mo1993a(2);
        } else {
            m10211a(this.f6451n, 0, 2);
        }
        return (short) ((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) | ((bArr[i] & WebView.NORMAL_MODE_ALPHA) << 8));
    }

    /* renamed from: w */
    public int mo1980w() throws cf {
        int i = 0;
        byte[] bArr = this.f6452o;
        if (this.g.mo1996h() >= 4) {
            bArr = this.g.mo1994f();
            i = this.g.mo1995g();
            this.g.mo1993a(4);
        } else {
            m10211a(this.f6452o, 0, 4);
        }
        return (bArr[i + 3] & WebView.NORMAL_MODE_ALPHA) | ((((bArr[i] & WebView.NORMAL_MODE_ALPHA) << 24) | ((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) << 16)) | ((bArr[i + 2] & WebView.NORMAL_MODE_ALPHA) << 8));
    }

    /* renamed from: x */
    public long mo1981x() throws cf {
        int i = 0;
        byte[] bArr = this.f6453p;
        if (this.g.mo1996h() >= 8) {
            bArr = this.g.mo1994f();
            i = this.g.mo1995g();
            this.g.mo1993a(8);
        } else {
            m10211a(this.f6453p, 0, 8);
        }
        return ((long) (bArr[i + 7] & WebView.NORMAL_MODE_ALPHA)) | (((((((((long) (bArr[i] & WebView.NORMAL_MODE_ALPHA)) << 56) | (((long) (bArr[i + 1] & WebView.NORMAL_MODE_ALPHA)) << 48)) | (((long) (bArr[i + 2] & WebView.NORMAL_MODE_ALPHA)) << 40)) | (((long) (bArr[i + 3] & WebView.NORMAL_MODE_ALPHA)) << 32)) | (((long) (bArr[i + 4] & WebView.NORMAL_MODE_ALPHA)) << 24)) | (((long) (bArr[i + 5] & WebView.NORMAL_MODE_ALPHA)) << 16)) | (((long) (bArr[i + 6] & WebView.NORMAL_MODE_ALPHA)) << 8));
    }

    /* renamed from: y */
    public double mo1982y() throws cf {
        return Double.longBitsToDouble(mo1981x());
    }

    /* renamed from: z */
    public String mo1983z() throws cf {
        int w = mo1980w();
        if (this.g.mo1996h() < w) {
            return m10228b(w);
        }
        try {
            String str = new String(this.g.mo1994f(), this.g.mo1995g(), w, "UTF-8");
            this.g.mo1993a(w);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new cf("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: b */
    public String m10228b(int i) throws cf {
        try {
            m10233d(i);
            byte[] bArr = new byte[i];
            this.g.m10350d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new cf("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: A */
    public ByteBuffer mo1943A() throws cf {
        int w = mo1980w();
        m10233d(w);
        if (this.g.mo1996h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.g.mo1994f(), this.g.mo1995g(), w);
            this.g.mo1993a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.g.m10350d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private int m10211a(byte[] bArr, int i, int i2) throws cf {
        m10233d(i2);
        return this.g.m10350d(bArr, i, i2);
    }

    /* renamed from: c */
    public void m10231c(int i) {
        this.f6444e = i;
        this.f6445f = true;
    }

    /* renamed from: d */
    protected void m10233d(int i) throws cf {
        if (i < 0) {
            throw new cz("Negative length: " + i);
        } else if (this.f6445f) {
            this.f6444e -= i;
            if (this.f6444e < 0) {
                throw new cz("Message length exceeded: " + i);
            }
        }
    }
}
