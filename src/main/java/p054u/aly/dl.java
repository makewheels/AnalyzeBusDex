package p054u.aly;

/* compiled from: TMemoryInputTransport */
/* renamed from: u.aly.dl */
public final class dl extends dm {
    /* renamed from: a */
    private byte[] f6533a;
    /* renamed from: b */
    private int f6534b;
    /* renamed from: c */
    private int f6535c;

    public dl(byte[] bArr) {
        m10364a(bArr);
    }

    public dl(byte[] bArr, int i, int i2) {
        m10369c(bArr, i, i2);
    }

    /* renamed from: a */
    public void m10364a(byte[] bArr) {
        m10369c(bArr, 0, bArr.length);
    }

    /* renamed from: c */
    public void m10369c(byte[] bArr, int i, int i2) {
        this.f6533a = bArr;
        this.f6534b = i;
        this.f6535c = i + i2;
    }

    /* renamed from: e */
    public void m10370e() {
        this.f6533a = null;
    }

    /* renamed from: c */
    public void mo1991c() {
    }

    /* renamed from: a */
    public boolean mo1988a() {
        return true;
    }

    /* renamed from: b */
    public void mo1989b() throws dn {
    }

    /* renamed from: a */
    public int mo1987a(byte[] bArr, int i, int i2) throws dn {
        int h = mo1996h();
        if (i2 > h) {
            i2 = h;
        }
        if (i2 > 0) {
            System.arraycopy(this.f6533a, this.f6534b, bArr, i, i2);
            mo1993a(i2);
        }
        return i2;
    }

    /* renamed from: b */
    public void mo1990b(byte[] bArr, int i, int i2) throws dn {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    /* renamed from: f */
    public byte[] mo1994f() {
        return this.f6533a;
    }

    /* renamed from: g */
    public int mo1995g() {
        return this.f6534b;
    }

    /* renamed from: h */
    public int mo1996h() {
        return this.f6535c - this.f6534b;
    }

    /* renamed from: a */
    public void mo1993a(int i) {
        this.f6534b += i;
    }
}
