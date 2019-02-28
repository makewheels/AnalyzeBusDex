package p054u.aly;

import com.umeng.analytics.onlineconfig.C1248a;

/* compiled from: TApplicationException */
/* renamed from: u.aly.by */
public class by extends cf {
    /* renamed from: a */
    public static final int f6388a = 0;
    /* renamed from: b */
    public static final int f6389b = 1;
    /* renamed from: c */
    public static final int f6390c = 2;
    /* renamed from: d */
    public static final int f6391d = 3;
    /* renamed from: e */
    public static final int f6392e = 4;
    /* renamed from: f */
    public static final int f6393f = 5;
    /* renamed from: g */
    public static final int f6394g = 6;
    /* renamed from: h */
    public static final int f6395h = 7;
    /* renamed from: j */
    private static final dd f6396j = new dd("TApplicationException");
    /* renamed from: k */
    private static final ct f6397k = new ct("message", (byte) 11, (short) 1);
    /* renamed from: l */
    private static final ct f6398l = new ct(C1248a.f5654a, (byte) 8, (short) 2);
    /* renamed from: m */
    private static final long f6399m = 1;
    /* renamed from: i */
    protected int f6400i = 0;

    public by(int i) {
        this.f6400i = i;
    }

    public by(int i, String str) {
        super(str);
        this.f6400i = i;
    }

    public by(String str) {
        super(str);
    }

    /* renamed from: a */
    public int m10090a() {
        return this.f6400i;
    }

    /* renamed from: a */
    public static by m10089a(cy cyVar) throws cf {
        cyVar.mo1967j();
        String str = null;
        int i = 0;
        while (true) {
            ct l = cyVar.mo1969l();
            if (l.f6485b == (byte) 0) {
                cyVar.mo1968k();
                return new by(i, str);
            }
            switch (l.f6486c) {
                case (short) 1:
                    if (l.f6485b != (byte) 11) {
                        db.m10335a(cyVar, l.f6485b);
                        break;
                    }
                    str = cyVar.mo1983z();
                    break;
                case (short) 2:
                    if (l.f6485b != (byte) 8) {
                        db.m10335a(cyVar, l.f6485b);
                        break;
                    }
                    i = cyVar.mo1980w();
                    break;
                default:
                    db.m10335a(cyVar, l.f6485b);
                    break;
            }
            cyVar.mo1970m();
        }
    }

    /* renamed from: b */
    public void m10091b(cy cyVar) throws cf {
        cyVar.mo1956a(f6396j);
        if (getMessage() != null) {
            cyVar.mo1951a(f6397k);
            cyVar.mo1949a(getMessage());
            cyVar.mo1960c();
        }
        cyVar.mo1951a(f6398l);
        cyVar.mo1947a(this.f6400i);
        cyVar.mo1960c();
        cyVar.mo1961d();
        cyVar.mo1959b();
    }
}
