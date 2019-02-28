package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.onlineconfig.C1248a;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import java.util.HashMap;
import java.util.Map;
import p054u.aly.C1242t;
import p054u.aly.C1444k;
import p054u.aly.C1446m;
import p054u.aly.C1447n;
import p054u.aly.C1451u;
import p054u.aly.C1452v;
import p054u.aly.C1456z;
import p054u.aly.ac;
import p054u.aly.bi_常量类;
import p054u.aly.bj;

/* compiled from: InternalAgent */
/* renamed from: com.umeng.analytics.c */
public class C1243c implements C1242t {
    /* renamed from: a */
    private final C1248a f5617a = new C1248a();
    /* renamed from: b */
    private Context f5618b = null;
    /* renamed from: c */
    private C1234b f5619c;
    /* renamed from: d */
    private C1446m f5620d = new C1446m();
    /* renamed from: e */
    private C1456z f5621e = new C1456z();
    /* renamed from: f */
    private C1452v f5622f = new C1452v();
    /* renamed from: g */
    private C1447n f5623g;
    /* renamed from: h */
    private C1444k f5624h;
    /* renamed from: i */
    private boolean f5625i = false;

    C1243c() {
        this.f5620d.m10428a((C1242t) this);
    }

    /* renamed from: f */
    private void m8380f(Context context) {
        if (!this.f5625i) {
            this.f5618b = context.getApplicationContext();
            this.f5623g = new C1447n(this.f5618b);
            this.f5624h = C1444k.m10413a(this.f5618b);
            this.f5625i = true;
        }
    }

    /* renamed from: a */
    void m8394a(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f5621e.m10491a(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    void m8399b(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f5621e.m10492b(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m8392a(C1234b c1234b) {
        this.f5619c = c1234b;
    }

    /* renamed from: a */
    public void m8383a(int i) {
        AnalyticsConfig.mVerticalType = i;
    }

    /* renamed from: a */
    public void m8395a(String str, String str2) {
        AnalyticsConfig.mWrapperType = str;
        AnalyticsConfig.mWrapperVersion = str2;
    }

    /* renamed from: a */
    void m8384a(Context context) {
        if (context == null) {
            bj.m10002b(C1233a.f5589e, "unexpected null context in onResume");
            return;
        }
        this.f5617a.m8456a(context);
        try {
            C1444k.m10413a(context).m10416a(this.f5617a);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    void m8393a(UmengOnlineConfigureListener umengOnlineConfigureListener) {
        this.f5617a.m8457a(umengOnlineConfigureListener);
    }

    /* renamed from: b */
    void m8397b(final Context context) {
        if (context == null) {
            bj.m10002b(C1233a.f5589e, "unexpected null context in onResume");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f5621e.m10491a(context.getClass().getName());
        }
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            C1244d.m8405a(new C1235e(this) {
                /* renamed from: b */
                final /* synthetic */ C1243c f5601b;

                /* renamed from: a */
                public void mo1916a() {
                    this.f5601b.m8381g(context.getApplicationContext());
                }
            });
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, "Exception occurred in Mobclick.onResume(). ", e);
        }
    }

    /* renamed from: c */
    void m8400c(final Context context) {
        if (context == null) {
            bj.m10002b(C1233a.f5589e, "unexpected null context in onPause");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f5621e.m10492b(context.getClass().getName());
        }
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            C1244d.m8405a(new C1235e(this) {
                /* renamed from: b */
                final /* synthetic */ C1243c f5603b;

                /* renamed from: a */
                public void mo1916a() {
                    this.f5603b.m8382h(context.getApplicationContext());
                }
            });
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, "Exception occurred in Mobclick.onRause(). ", e);
        }
    }

    /* renamed from: a */
    public void m8388a(Context context, String str, HashMap<String, Object> hashMap) {
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            this.f5623g.m10434a(str, (Map) hashMap);
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: a */
    void m8385a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                bj.m10002b(C1233a.f5589e, "unexpected null context in reportError");
                return;
            }
            try {
                if (!this.f5625i) {
                    m8380f(context);
                }
                this.f5624h.mo1999a(new ac(str).m8608a(false));
            } catch (Exception e) {
                bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
            }
        }
    }

    /* renamed from: a */
    void m8391a(Context context, Throwable th) {
        if (context != null && th != null) {
            try {
                if (!this.f5625i) {
                    m8380f(context);
                }
                this.f5624h.mo1999a(new ac(th).m8608a(false));
            } catch (Exception e) {
                bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
            }
        }
    }

    /* renamed from: g */
    private void m8381g(Context context) {
        this.f5622f.m10472c(context);
        if (this.f5619c != null) {
            this.f5619c.m8367a();
        }
    }

    /* renamed from: h */
    private void m8382h(Context context) {
        this.f5622f.m10473d(context);
        this.f5621e.m10490a(context);
        if (this.f5619c != null) {
            this.f5619c.m8368b();
        }
        this.f5624h.mo2000b();
    }

    /* renamed from: d */
    void m8402d(Context context) {
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            this.f5624h.mo1997a();
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: a */
    public void m8387a(Context context, String str, String str2, long j, int i) {
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            this.f5623g.m10433a(str, str2, j, i);
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: a */
    void m8390a(Context context, String str, Map<String, Object> map, long j) {
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            this.f5623g.m10435a(str, (Map) map, j);
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: a */
    void m8386a(Context context, final String str, final String str2) {
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            C1244d.m8405a(new C1235e(this) {
                /* renamed from: c */
                final /* synthetic */ C1243c f5606c;

                /* renamed from: a */
                public void mo1916a() {
                    this.f5606c.f5623g.m10432a(str, str2);
                }
            });
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: b */
    void m8398b(Context context, final String str, final String str2) {
        try {
            C1244d.m8405a(new C1235e(this) {
                /* renamed from: c */
                final /* synthetic */ C1243c f5609c;

                /* renamed from: a */
                public void mo1916a() {
                    this.f5609c.f5623g.m10437b(str, str2);
                }
            });
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: a */
    void m8389a(Context context, final String str, final HashMap<String, Object> hashMap, final String str2) {
        try {
            if (!this.f5625i) {
                m8380f(context);
            }
            C1244d.m8405a(new C1235e(this) {
                /* renamed from: d */
                final /* synthetic */ C1243c f5613d;

                /* renamed from: a */
                public void mo1916a() {
                    this.f5613d.f5623g.m10436a(str, hashMap, str2);
                }
            });
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: c */
    void m8401c(Context context, final String str, final String str2) {
        try {
            C1244d.m8405a(new C1235e(this) {
                /* renamed from: c */
                final /* synthetic */ C1243c f5616c;

                /* renamed from: a */
                public void mo1916a() {
                    this.f5616c.f5623g.m10438c(str, str2);
                }
            });
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, bi_常量类.f6358b_空串, e);
        }
    }

    /* renamed from: e */
    void m8403e(Context context) {
        try {
            this.f5621e.m10489a();
            m8382h(context);
            C1451u.m10465a(context).edit().commit();
            C1244d.m8404a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo1917a(Throwable th) {
        try {
            this.f5621e.m10489a();
            if (this.f5618b != null) {
                if (!(th == null || this.f5624h == null)) {
                    this.f5624h.mo2001b(new ac(th));
                }
                m8382h(this.f5618b);
                C1451u.m10465a(this.f5618b).edit().commit();
            }
            C1244d.m8404a();
        } catch (Exception e) {
            bj.m10001a(C1233a.f5589e, "Exception in onAppCrash", e);
        }
    }
}
