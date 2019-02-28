package p054u.aly;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1233a;
import com.umeng.analytics.C1245f;
import com.umeng.analytics.ReportPolicy.C1227e;
import com.umeng.analytics.ReportPolicy.C1228a;
import com.umeng.analytics.ReportPolicy.C1229b;
import com.umeng.analytics.ReportPolicy.C1230c;
import com.umeng.analytics.ReportPolicy.C1231d;
import com.umeng.analytics.ReportPolicy.C1232f;
import com.umeng.analytics.onlineconfig.C1250c;

/* compiled from: CacheImpl */
/* renamed from: u.aly.j */
public final class C1440j implements C1250c, C1439o {
    /* renamed from: a */
    private C1448q f6557a = null;
    /* renamed from: b */
    private C1449r f6558b = null;
    /* renamed from: c */
    private C1227e f6559c = null;
    /* renamed from: d */
    private C1245f f6560d = null;
    /* renamed from: e */
    private C1453w f6561e = null;
    /* renamed from: f */
    private C1431d f6562f = null;
    /* renamed from: g */
    private int f6563g = 10;
    /* renamed from: h */
    private Context f6564h;

    public C1440j(Context context) {
        this.f6564h = context;
        this.f6557a = new C1448q(context);
        this.f6562f = C1437h.m10387a(context);
        this.f6561e = new C1453w(context);
        this.f6558b = new C1449r(context);
        this.f6558b.m10460a(this.f6561e);
        this.f6560d = C1245f.m8407a(context);
        int[] reportPolicy = AnalyticsConfig.getReportPolicy(this.f6564h);
        m10398a(reportPolicy[0], reportPolicy[1]);
    }

    /* renamed from: a */
    public void mo1997a() {
        if (bi_常量类.m9987l(this.f6564h)) {
            m10402e();
        } else if (bj.f6362a) {
            bj.m10004c(C1233a.f5589e, "network is unavailable");
        }
    }

    /* renamed from: a */
    public void mo1999a(C1275p c1275p) {
        if (c1275p != null) {
            this.f6557a.m10446a(c1275p);
        }
        if (m10399a(c1275p instanceof bd)) {
            m10402e();
        } else if (m10401d()) {
            mo2000b();
        }
    }

    /* renamed from: b */
    public void mo2001b(C1275p c1275p) {
        this.f6557a.m10446a(c1275p);
    }

    /* renamed from: b */
    public void mo2000b() {
        if (this.f6557a.m10448b() > 0) {
            try {
                byte[] c = m10409c();
                if (c != null) {
                    this.f6560d.m8415a(c);
                }
            } catch (Throwable th) {
                if (th instanceof OutOfMemoryError) {
                    this.f6560d.m8420c();
                }
                if (th != null) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: c */
    protected byte[] m10409c() {
        try {
            if (TextUtils.isEmpty(AnalyticsConfig.getAppkey(this.f6564h))) {
                bj.m10002b(C1233a.f5589e, "Appkey is missing ,Please check AndroidManifest.xml");
                return null;
            }
            byte[] b = C1245f.m8407a(this.f6564h).m8418b();
            bf a = b == null ? null : m10397a(b);
            if (a == null && this.f6557a.m10448b() == 0) {
                return null;
            }
            bf bfVar;
            if (a == null) {
                bfVar = new bf();
            } else {
                bfVar = a;
            }
            this.f6557a.m10445a(bfVar);
            if (bj.f6362a && bfVar.m9772B()) {
                Object obj = null;
                for (bd p : bfVar.m9829z()) {
                    Object obj2;
                    if (p.m8684p() > 0) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
                if (obj == null) {
                    bj.m10008e(C1233a.f5589e, "missing Activities or PageViews");
                }
            }
            try {
                b = m10400a(bfVar);
                try {
                    if (!bj.f6362a) {
                        return b;
                    }
                    bj.m10004c(C1233a.f5589e, bfVar.toString());
                    return b;
                } catch (Exception e) {
                    bj.m10002b(C1233a.f5589e, "Fail to serialize log ...");
                    return b;
                }
            } catch (Exception e2) {
                b = null;
                bj.m10002b(C1233a.f5589e, "Fail to serialize log ...");
                return b;
            }
        } catch (Exception e3) {
            bj.m10003b(C1233a.f5589e, "Fail to construct message ...", e3);
            C1245f.m8407a(this.f6564h).m8420c();
            return null;
        }
    }

    /* renamed from: a */
    private bf m10397a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            bz bfVar = new bf();
            new cc().m10132a(bfVar, bArr);
            return bfVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private byte[] m10400a(bf bfVar) {
        try {
            return new ci().m10144a(bfVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private boolean m10399a(boolean z) {
        if (!bi_常量类.m9987l(this.f6564h)) {
            if (bj.f6362a) {
                bj.m10004c(C1233a.f5589e, "network is unavailable");
            }
            return false;
        } else if (this.f6561e.m10477b()) {
            return true;
        } else {
            if (bj.f6362a && bi_常量类.m9998w(this.f6564h)) {
                return true;
            }
            return this.f6559c.mo1915a(z);
        }
    }

    /* renamed from: d */
    private boolean m10401d() {
        return this.f6557a.m10448b() > this.f6563g;
    }

    /* renamed from: e */
    private void m10402e() {
        try {
            if (this.f6561e.m10477b()) {
                this.f6557a.m10444a(new ah(this.f6561e.m10485j()));
            }
            m10403f();
        } catch (Throwable th) {
            if (th instanceof OutOfMemoryError) {
                if (th != null) {
                    th.printStackTrace();
                }
            } else if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: f */
    private void m10403f() {
        byte[] d;
        C1245f a = C1245f.m8407a(this.f6564h);
        boolean f = a.m8423f();
        if (f) {
            d = a.m8421d();
        } else {
            this.f6562f.m10325a();
            d = m10409c();
            if (d == null) {
                bj.m10008e(C1233a.f5589e, "message is null");
                return;
            } else {
                d = C1420c.m10092a(this.f6564h, AnalyticsConfig.getAppkey(this.f6564h), d).m10103c();
                a.m8420c();
            }
        }
        switch (this.f6558b.m10459a(d)) {
            case 1:
                if (!f) {
                    a.m8417b(d);
                }
                bj.m10002b(C1233a.f5589e, "connection error");
                return;
            case 2:
                if (this.f6561e.m10484i()) {
                    this.f6561e.m10483h();
                }
                this.f6562f.m10330d();
                this.f6561e.m10482g();
                if (f) {
                    a.m8422e();
                    return;
                }
                return;
            case 3:
                this.f6561e.m10482g();
                if (f) {
                    a.m8422e();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m10398a(int i, int i2) {
        switch (i) {
            case 0:
                this.f6559c = new C1227e();
                break;
            case 1:
                this.f6559c = new C1228a();
                break;
            case 4:
                this.f6559c = new C1231d(this.f6561e);
                break;
            case 5:
                this.f6559c = new C1232f(this.f6564h);
                break;
            case 6:
                this.f6559c = new C1229b(this.f6561e, (long) i2);
                break;
            case 7:
                this.f6559c = new C1230c(this.f6557a, i2);
                break;
            default:
                this.f6559c = new C1228a();
                break;
        }
        bj.m10004c(C1233a.f5589e, "report policy:" + i + " interval:" + i2);
    }

    /* renamed from: a */
    public void mo1998a(int i, long j) {
        AnalyticsConfig.setReportPolicy(i, (int) j);
        m10398a(i, (int) j);
    }
}
