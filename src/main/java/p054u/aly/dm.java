package p054u.aly;

/* compiled from: TTransport */
/* renamed from: u.aly.dm */
public abstract class dm {
    /* renamed from: a */
    public abstract int mo1987a(byte[] bArr, int i, int i2) throws dn;

    /* renamed from: a */
    public abstract boolean mo1988a();

    /* renamed from: b */
    public abstract void mo1989b() throws dn;

    /* renamed from: b */
    public abstract void mo1990b(byte[] bArr, int i, int i2) throws dn;

    /* renamed from: c */
    public abstract void mo1991c();

    /* renamed from: i */
    public boolean m10355i() {
        return mo1988a();
    }

    /* renamed from: d */
    public int m10350d(byte[] bArr, int i, int i2) throws dn {
        int i3 = 0;
        while (i3 < i2) {
            int a = mo1987a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new dn("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += a;
        }
        return i3;
    }

    /* renamed from: b */
    public void m10347b(byte[] bArr) throws dn {
        mo1990b(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public void mo1992d() throws dn {
    }

    /* renamed from: f */
    public byte[] mo1994f() {
        return null;
    }

    /* renamed from: g */
    public int mo1995g() {
        return 0;
    }

    /* renamed from: h */
    public int mo1996h() {
        return -1;
    }

    /* renamed from: a */
    public void mo1993a(int i) {
    }
}
