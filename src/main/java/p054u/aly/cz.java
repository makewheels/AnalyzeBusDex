package p054u.aly;

/* compiled from: TProtocolException */
/* renamed from: u.aly.cz */
public class cz extends cf {
    /* renamed from: a */
    public static final int f6499a = 0;
    /* renamed from: b */
    public static final int f6500b = 1;
    /* renamed from: c */
    public static final int f6501c = 2;
    /* renamed from: d */
    public static final int f6502d = 3;
    /* renamed from: e */
    public static final int f6503e = 4;
    /* renamed from: f */
    public static final int f6504f = 5;
    /* renamed from: h */
    private static final long f6505h = 1;
    /* renamed from: g */
    protected int f6506g = 0;

    public cz(int i) {
        this.f6506g = i;
    }

    public cz(int i, String str) {
        super(str);
        this.f6506g = i;
    }

    public cz(String str) {
        super(str);
    }

    public cz(int i, Throwable th) {
        super(th);
        this.f6506g = i;
    }

    public cz(Throwable th) {
        super(th);
    }

    public cz(String str, Throwable th) {
        super(str, th);
    }

    public cz(int i, String str, Throwable th) {
        super(str, th);
        this.f6506g = i;
    }

    /* renamed from: a */
    public int m10321a() {
        return this.f6506g;
    }
}
