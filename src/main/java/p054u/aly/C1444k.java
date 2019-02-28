package p054u.aly;

import android.content.Context;
import com.umeng.analytics.C1235e;
import com.umeng.analytics.C1244d;
import com.umeng.analytics.onlineconfig.C1248a;
import com.umeng.analytics.onlineconfig.C1250c;

/* compiled from: CacheService */
/* renamed from: u.aly.k */
public final class C1444k implements C1439o {
    /* renamed from: c */
    private static C1444k f6569c;
    /* renamed from: a */
    private C1439o f6570a = new C1440j(this.f6571b);
    /* renamed from: b */
    private Context f6571b;

    /* compiled from: CacheService */
    /* renamed from: u.aly.k$2 */
    class C14422 extends C1235e {
        /* renamed from: a */
        final /* synthetic */ C1444k f6567a;

        C14422(C1444k c1444k) {
            this.f6567a = c1444k;
        }

        /* renamed from: a */
        public void mo1916a() {
            this.f6567a.f6570a.mo1997a();
        }
    }

    /* compiled from: CacheService */
    /* renamed from: u.aly.k$3 */
    class C14433 extends C1235e {
        /* renamed from: a */
        final /* synthetic */ C1444k f6568a;

        C14433(C1444k c1444k) {
            this.f6568a = c1444k;
        }

        /* renamed from: a */
        public void mo1916a() {
            this.f6568a.f6570a.mo2000b();
        }
    }

    private C1444k(Context context) {
        this.f6571b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static synchronized C1444k m10413a(Context context) {
        C1444k c1444k;
        synchronized (C1444k.class) {
            if (f6569c == null && context != null) {
                f6569c = new C1444k(context);
            }
            c1444k = f6569c;
        }
        return c1444k;
    }

    /* renamed from: a */
    public void m10417a(C1439o c1439o) {
        this.f6570a = c1439o;
    }

    /* renamed from: a */
    public void m10416a(C1248a c1248a) {
        if (c1248a != null && this.f6570a != null) {
            c1248a.m8458a((C1250c) this.f6570a);
        }
    }

    /* renamed from: a */
    public void mo1999a(final C1275p c1275p) {
        C1244d.m8406b(new C1235e(this) {
            /* renamed from: b */
            final /* synthetic */ C1444k f6566b;

            /* renamed from: a */
            public void mo1916a() {
                this.f6566b.f6570a.mo1999a(c1275p);
            }
        });
    }

    /* renamed from: b */
    public void mo2001b(C1275p c1275p) {
        this.f6570a.mo2001b(c1275p);
    }

    /* renamed from: a */
    public void mo1997a() {
        C1244d.m8406b(new C14422(this));
    }

    /* renamed from: b */
    public void mo2000b() {
        C1244d.m8406b(new C14433(this));
    }
}
