package p054u.aly;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import p054u.aly.cs.C1429a;

/* compiled from: TDeserializer */
/* renamed from: u.aly.cc */
public class cc {
    /* renamed from: a */
    private final cy f6413a;
    /* renamed from: b */
    private final dl f6414b;

    public cc() {
        this(new C1429a());
    }

    public cc(da daVar) {
        this.f6414b = new dl();
        this.f6413a = daVar.mo1942a(this.f6414b);
    }

    /* renamed from: a */
    public void m10132a(bz bzVar, byte[] bArr) throws cf {
        try {
            this.f6414b.m10364a(bArr);
            bzVar.mo1921a(this.f6413a);
        } finally {
            this.f6414b.m10370e();
            this.f6413a.mo1984B();
        }
    }

    /* renamed from: a */
    public void m10131a(bz bzVar, String str, String str2) throws cf {
        try {
            m10132a(bzVar, str.getBytes(str2));
            this.f6413a.mo1984B();
        } catch (UnsupportedEncodingException e) {
            throw new cf("JVM DOES NOT SUPPORT ENCODING: " + str2);
        } catch (Throwable th) {
            this.f6413a.mo1984B();
        }
    }

    /* renamed from: a */
    public void m10133a(bz bzVar, byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        try {
            if (m10128j(bArr, cgVar, cgVarArr) != null) {
                bzVar.mo1921a(this.f6413a);
            }
            this.f6414b.m10370e();
            this.f6413a.mo1984B();
        } catch (Throwable e) {
            throw new cf(e);
        } catch (Throwable th) {
            this.f6414b.m10370e();
            this.f6413a.mo1984B();
        }
    }

    /* renamed from: a */
    public Boolean m10129a(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (Boolean) m10127a((byte) 2, bArr, cgVar, cgVarArr);
    }

    /* renamed from: b */
    public Byte m10134b(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (Byte) m10127a((byte) 3, bArr, cgVar, cgVarArr);
    }

    /* renamed from: c */
    public Double m10135c(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (Double) m10127a((byte) 4, bArr, cgVar, cgVarArr);
    }

    /* renamed from: d */
    public Short m10136d(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (Short) m10127a((byte) 6, bArr, cgVar, cgVarArr);
    }

    /* renamed from: e */
    public Integer m10137e(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (Integer) m10127a((byte) 8, bArr, cgVar, cgVarArr);
    }

    /* renamed from: f */
    public Long m10138f(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (Long) m10127a((byte) 10, bArr, cgVar, cgVarArr);
    }

    /* renamed from: g */
    public String m10139g(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (String) m10127a((byte) 11, bArr, cgVar, cgVarArr);
    }

    /* renamed from: h */
    public ByteBuffer m10140h(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        return (ByteBuffer) m10127a((byte) 100, bArr, cgVar, cgVarArr);
    }

    /* renamed from: i */
    public Short m10141i(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        try {
            if (m10128j(bArr, cgVar, cgVarArr) != null) {
                this.f6413a.mo1967j();
                Short valueOf = Short.valueOf(this.f6413a.mo1969l().f6486c);
                this.f6414b.m10370e();
                this.f6413a.mo1984B();
                return valueOf;
            }
            this.f6414b.m10370e();
            this.f6413a.mo1984B();
            return null;
        } catch (Throwable e) {
            throw new cf(e);
        } catch (Throwable th) {
            this.f6414b.m10370e();
            this.f6413a.mo1984B();
        }
    }

    /* renamed from: a */
    private Object m10127a(byte b, byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        try {
            ct j = m10128j(bArr, cgVar, cgVarArr);
            if (j != null) {
                Object valueOf;
                switch (b) {
                    case (byte) 2:
                        if (j.f6485b == (byte) 2) {
                            valueOf = Boolean.valueOf(this.f6413a.mo1977t());
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                    case (byte) 3:
                        if (j.f6485b == (byte) 3) {
                            valueOf = Byte.valueOf(this.f6413a.mo1978u());
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                    case (byte) 4:
                        if (j.f6485b == (byte) 4) {
                            valueOf = Double.valueOf(this.f6413a.mo1982y());
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                    case (byte) 6:
                        if (j.f6485b == (byte) 6) {
                            valueOf = Short.valueOf(this.f6413a.mo1979v());
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                    case (byte) 8:
                        if (j.f6485b == (byte) 8) {
                            valueOf = Integer.valueOf(this.f6413a.mo1980w());
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                    case (byte) 10:
                        if (j.f6485b == (byte) 10) {
                            valueOf = Long.valueOf(this.f6413a.mo1981x());
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                    case (byte) 11:
                        if (j.f6485b == (byte) 11) {
                            valueOf = this.f6413a.mo1983z();
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                    case (byte) 100:
                        if (j.f6485b == (byte) 11) {
                            valueOf = this.f6413a.mo1943A();
                            this.f6414b.m10370e();
                            this.f6413a.mo1984B();
                            return valueOf;
                        }
                        break;
                }
            }
            this.f6414b.m10370e();
            this.f6413a.mo1984B();
            return null;
        } catch (Throwable e) {
            throw new cf(e);
        } catch (Throwable th) {
            this.f6414b.m10370e();
            this.f6413a.mo1984B();
        }
    }

    /* renamed from: j */
    private ct m10128j(byte[] bArr, cg cgVar, cg... cgVarArr) throws cf {
        int i = 0;
        this.f6414b.m10364a(bArr);
        cg[] cgVarArr2 = new cg[(cgVarArr.length + 1)];
        cgVarArr2[0] = cgVar;
        for (int i2 = 0; i2 < cgVarArr.length; i2++) {
            cgVarArr2[i2 + 1] = cgVarArr[i2];
        }
        this.f6413a.mo1967j();
        ct ctVar = null;
        while (i < cgVarArr2.length) {
            ctVar = this.f6413a.mo1969l();
            if (ctVar.f6485b == (byte) 0 || ctVar.f6486c > cgVarArr2[i].mo1931a()) {
                return null;
            }
            if (ctVar.f6486c != cgVarArr2[i].mo1931a()) {
                db.m10335a(this.f6413a, ctVar.f6485b);
                this.f6413a.mo1970m();
            } else {
                i++;
                if (i < cgVarArr2.length) {
                    this.f6413a.mo1967j();
                }
            }
        }
        return ctVar;
    }

    /* renamed from: a */
    public void m10130a(bz bzVar, String str) throws cf {
        m10132a(bzVar, str.getBytes());
    }
}
