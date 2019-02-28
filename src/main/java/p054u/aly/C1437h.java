package p054u.aly;

import android.content.Context;

/* compiled from: SDKContext */
/* renamed from: u.aly.h */
public class C1437h {
    /* renamed from: a */
    private static C1431d f6551a = null;
    /* renamed from: b */
    private static C1435f f6552b = null;

    /* renamed from: a */
    public static synchronized C1431d m10387a(Context context) {
        C1431d c1431d;
        synchronized (C1437h.class) {
            if (f6551a == null) {
                f6551a = new C1431d(context);
                f6551a.m10327a(new C1434e(context));
                f6551a.m10327a(new C1436g(context));
                f6551a.m10327a(new C1374b(context));
                f6551a.m10327a(new C1438i(context));
                f6551a.m10331e();
            }
            c1431d = f6551a;
        }
        return c1431d;
    }

    /* renamed from: b */
    public static synchronized C1435f m10388b(Context context) {
        C1435f c1435f;
        synchronized (C1437h.class) {
            if (f6552b == null) {
                f6552b = new C1435f(context);
                f6552b.m10382b();
            }
            c1435f = f6552b;
        }
        return c1435f;
    }
}
