package p054u.aly;

import android.content.Context;
import com.umeng.analytics.C1233a;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IdTracker */
/* renamed from: u.aly.d */
public class C1431d {
    /* renamed from: a */
    private final String f6507a = "umeng_it.cache";
    /* renamed from: b */
    private File f6508b;
    /* renamed from: c */
    private as f6509c = null;
    /* renamed from: d */
    private long f6510d;
    /* renamed from: e */
    private long f6511e;
    /* renamed from: f */
    private Set<C1274a> f6512f = new HashSet();

    public C1431d(Context context) {
        this.f6508b = new File(context.getFilesDir(), "umeng_it.cache");
        this.f6511e = C1233a.f5597m;
    }

    /* renamed from: a */
    public void m10327a(C1274a c1274a) {
        this.f6512f.add(c1274a);
    }

    /* renamed from: a */
    public void m10326a(long j) {
        this.f6511e = j;
    }

    /* renamed from: a */
    public void m10325a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6510d >= this.f6511e) {
            Object obj = null;
            for (C1274a c1274a : this.f6512f) {
                if (c1274a.m8520c()) {
                    Object obj2;
                    if (c1274a.m8518a()) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                m10323g();
                m10332f();
            }
            this.f6510d = currentTimeMillis;
        }
    }

    /* renamed from: b */
    public as m10328b() {
        return this.f6509c;
    }

    /* renamed from: g */
    private void m10323g() {
        as asVar = new as();
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (C1274a c1274a : this.f6512f) {
            if (c1274a.m8520c()) {
                if (c1274a.m8521d() != null) {
                    hashMap.put(c1274a.m8519b(), c1274a.m8521d());
                }
                if (!(c1274a.m8522e() == null || c1274a.m8522e().isEmpty())) {
                    arrayList.addAll(c1274a.m8522e());
                }
            }
        }
        asVar.m9203a(arrayList);
        asVar.m9204a(hashMap);
        synchronized (this) {
            this.f6509c = asVar;
        }
    }

    /* renamed from: c */
    public String m10329c() {
        return null;
    }

    /* renamed from: d */
    public void m10330d() {
        boolean z = false;
        for (C1274a c1274a : this.f6512f) {
            if (c1274a.m8520c()) {
                boolean z2;
                if (c1274a.m8522e() == null || c1274a.m8522e().isEmpty()) {
                    z2 = z;
                } else {
                    c1274a.m8515a(null);
                    z2 = true;
                }
                z = z2;
            }
        }
        if (z) {
            this.f6509c.m9212b(false);
            m10332f();
        }
    }

    /* renamed from: e */
    public void m10331e() {
        as h = m10324h();
        if (h != null) {
            List<C1274a> arrayList = new ArrayList(this.f6512f.size());
            synchronized (this) {
                this.f6509c = h;
                for (C1274a c1274a : this.f6512f) {
                    c1274a.m8517a(this.f6509c);
                    if (!c1274a.m8520c()) {
                        arrayList.add(c1274a);
                    }
                }
                for (C1274a c1274a2 : arrayList) {
                    this.f6512f.remove(c1274a2);
                }
            }
            m10323g();
        }
    }

    /* renamed from: f */
    public void m10332f() {
        if (this.f6509c != null) {
            m10322a(this.f6509c);
        }
    }

    /* renamed from: h */
    private as m10324h() {
        InputStream fileInputStream;
        Exception e;
        Throwable th;
        if (!this.f6508b.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(this.f6508b);
            try {
                byte[] b = bv.m10063b(fileInputStream);
                bz asVar = new as();
                new cc().m10132a(asVar, b);
                bv.m10065c(fileInputStream);
                return asVar;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    bv.m10065c(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bv.m10065c(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            bv.m10065c(fileInputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            bv.m10065c(fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private void m10322a(as asVar) {
        if (asVar != null) {
            try {
                byte[] a;
                synchronized (this) {
                    a = new ci().m10144a(asVar);
                }
                if (a != null) {
                    bv.m10059a(this.f6508b, a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
