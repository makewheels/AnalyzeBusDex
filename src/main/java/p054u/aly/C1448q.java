package p054u.aly;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1233a;
import com.umeng.analytics.Gender;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MemoCache */
/* renamed from: u.aly.q */
public class C1448q {
    /* renamed from: a */
    private List<C1275p> f6583a = new ArrayList();
    /* renamed from: b */
    private ah f6584b = null;
    /* renamed from: c */
    private ai f6585c = null;
    /* renamed from: d */
    private ak f6586d = null;
    /* renamed from: e */
    private ax f6587e = null;
    /* renamed from: f */
    private Context f6588f = null;

    public C1448q(Context context) {
        this.f6588f = context;
    }

    /* renamed from: a */
    public Context m10443a() {
        return this.f6588f;
    }

    /* renamed from: a */
    protected boolean m10447a(int i) {
        return true;
    }

    /* renamed from: b */
    public synchronized int m10448b() {
        int size;
        size = this.f6583a.size();
        if (this.f6584b != null) {
            size++;
        }
        return size;
    }

    /* renamed from: a */
    public synchronized void m10446a(C1275p c1275p) {
        this.f6583a.add(c1275p);
    }

    /* renamed from: a */
    public void m10445a(bf bfVar) {
        String i = m10442i();
        if (i != null) {
            synchronized (this) {
                for (C1275p a : this.f6583a) {
                    a.mo1926a(bfVar, i);
                }
                this.f6583a.clear();
                if (this.f6584b != null) {
                    bfVar.m9783a(this.f6584b);
                    this.f6584b = null;
                }
            }
            bfVar.m9784a(m10449c());
            bfVar.m9786a(m10450d());
            bfVar.m9789a(m10451e());
            bfVar.m9785a(m10454h());
            bfVar.m9788a(m10452f());
            bfVar.m9787a(m10453g());
        }
    }

    /* renamed from: i */
    private String m10442i() {
        return C1451u.m10465a(this.f6588f).getString("session_id", null);
    }

    /* renamed from: a */
    public synchronized void m10444a(ah ahVar) {
        this.f6584b = ahVar;
    }

    /* renamed from: c */
    public synchronized ai m10449c() {
        if (this.f6585c == null) {
            this.f6585c = new ai();
            m10439a(this.f6588f);
        }
        return this.f6585c;
    }

    /* renamed from: d */
    public synchronized ak m10450d() {
        if (this.f6586d == null) {
            this.f6586d = new ak();
            m10440b(this.f6588f);
        }
        return this.f6586d;
    }

    /* renamed from: e */
    public synchronized ax m10451e() {
        if (this.f6587e == null) {
            this.f6587e = new ax();
            m10441c(this.f6588f);
        }
        return this.f6587e;
    }

    /* renamed from: f */
    public at m10452f() {
        try {
            return C1437h.m10388b(this.f6588f).m10380a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    public as m10453g() {
        try {
            return C1437h.m10387a(this.f6588f).m10328b();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    public aj m10454h() {
        try {
            return C1453w.m10474a(this.f6588f);
        } catch (Exception e) {
            e.printStackTrace();
            return new aj();
        }
    }

    /* renamed from: a */
    private void m10439a(Context context) {
        try {
            this.f6585c.m8778a(AnalyticsConfig.getAppkey(context));
            this.f6585c.m8795e(AnalyticsConfig.getChannel(context));
            if (!(AnalyticsConfig.mWrapperType == null || AnalyticsConfig.mWrapperVersion == null)) {
                this.f6585c.m8799f(AnalyticsConfig.mWrapperType);
                this.f6585c.m8801g(AnalyticsConfig.mWrapperVersion);
            }
            this.f6585c.m8789c(bi_常量类.m9996u(context));
            this.f6585c.m8779a(bc.ANDROID);
            this.f6585c.m8792d(C1233a.f5587c);
            this.f6585c.m8782b(bi_常量类.m9979d(context));
            this.f6585c.m8777a(Integer.parseInt(bi_常量类.m9978c(context)));
            if (AnalyticsConfig.mVerticalType == 1) {
                this.f6585c.m8788c(AnalyticsConfig.mVerticalType);
                this.f6585c.m8792d(C1233a.f5588d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m10440b(Context context) {
        try {
            this.f6586d.m8939f(bi_常量类.m9968a());
            this.f6586d.m8920a(bi_常量类.m9981f(context));
            this.f6586d.m8924b(bi_常量类.m9982g(context));
            this.f6586d.m8930c(bi_常量类.m9991p(context));
            this.f6586d.m8935e(Build.MODEL);
            this.f6586d.m8941g("Android");
            this.f6586d.m8944h(VERSION.RELEASE);
            int[] r = bi_常量类.m9993r(context);
            if (r != null) {
                this.f6586d.m8921a(new ba(r[1], r[0]));
            }
            if (AnalyticsConfig.GPU_RENDERER == null || AnalyticsConfig.GPU_VENDER != null) {
                this.f6586d.m8947i(Build.BOARD);
                this.f6586d.m8951j(Build.BRAND);
                this.f6586d.m8919a(Build.TIME);
                this.f6586d.m8953k(Build.MANUFACTURER);
                this.f6586d.m8956l(Build.ID);
                this.f6586d.m8960m(Build.DEVICE);
            } else {
                this.f6586d.m8947i(Build.BOARD);
                this.f6586d.m8951j(Build.BRAND);
                this.f6586d.m8919a(Build.TIME);
                this.f6586d.m8953k(Build.MANUFACTURER);
                this.f6586d.m8956l(Build.ID);
                this.f6586d.m8960m(Build.DEVICE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m10441c(Context context) {
        try {
            String[] j = bi_常量类.m9985j(context);
            if (bi_常量类.f6360d.equals(j[0])) {
                this.f6587e.m9475a(ag.ACCESS_TYPE_WIFI);
            } else if (bi_常量类.f6359c.equals(j[0])) {
                this.f6587e.m9475a(ag.ACCESS_TYPE_2G_3G);
            } else {
                this.f6587e.m9475a(ag.ACCESS_TYPE_UNKNOWN);
            }
            if (!bi_常量类.f6358b.equals(j[1])) {
                this.f6587e.m9493e(j[1]);
            }
            this.f6587e.m9487c(bi_常量类.m9994s(context));
            j = bi_常量类.m9989n(context);
            this.f6587e.m9480b(j[0]);
            this.f6587e.m9474a(j[1]);
            this.f6587e.m9473a(bi_常量类.m9988m(context));
            if (AnalyticsConfig.sAge != 0 || AnalyticsConfig.sGender != null || AnalyticsConfig.sId != null || AnalyticsConfig.sSource != null) {
                bg bgVar = new bg();
                bgVar.m9855a(AnalyticsConfig.sAge);
                bgVar.m9857a(Gender.transGender(AnalyticsConfig.sGender));
                bgVar.m9856a(AnalyticsConfig.sId);
                bgVar.m9860b(AnalyticsConfig.sSource);
                this.f6587e.m9476a(bgVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
