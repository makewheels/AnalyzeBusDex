package p054u.aly;

/* compiled from: TTransportException */
/* renamed from: u.aly.dn */
public class dn extends cf {
    /* renamed from: a */
    public static final int f6536a = 0;
    /* renamed from: b */
    public static final int f6537b = 1;
    /* renamed from: c */
    public static final int f6538c = 2;
    /* renamed from: d */
    public static final int f6539d = 3;
    /* renamed from: e */
    public static final int f6540e = 4;
    /* renamed from: g */
    private static final long f6541g = 1;
    /* renamed from: f */
    protected int f6542f = 0;

    public dn(int i) {
        this.f6542f = i;
    }

    public dn(int i, String str) {
        super(str);
        this.f6542f = i;
    }

    public dn(String str) {
        super(str);
    }

    public dn(int i, Throwable th) {
        super(th);
        this.f6542f = i;
    }

    public dn(Throwable th) {
        super(th);
    }

    public dn(String str, Throwable th) {
        super(str, th);
    }

    public dn(int i, String str, Throwable th) {
        super(str, th);
        this.f6542f = i;
    }

    /* renamed from: a */
    public int m10374a() {
        return this.f6542f;
    }
}
