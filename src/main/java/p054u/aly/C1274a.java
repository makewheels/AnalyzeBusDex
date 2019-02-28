package p054u.aly;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: AbstractIdTracker */
/* renamed from: u.aly.a */
public abstract class C1274a {
    /* renamed from: a */
    private final int f5725a = 10;
    /* renamed from: b */
    private final int f5726b = 20;
    /* renamed from: c */
    private final String f5727c;
    /* renamed from: d */
    private List<aq> f5728d;
    /* renamed from: e */
    private ar f5729e;

    /* renamed from: f */
    public abstract String mo1941f();

    public C1274a(String str) {
        this.f5727c = str;
    }

    /* renamed from: a */
    public boolean m8518a() {
        return m8513g();
    }

    /* renamed from: b */
    public String m8519b() {
        return this.f5727c;
    }

    /* renamed from: c */
    public boolean m8520c() {
        if (this.f5729e == null || this.f5729e.m9173j() <= 20) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    private boolean m8513g() {
        ar arVar = this.f5729e;
        String c = arVar == null ? null : arVar.m9164c();
        int j = arVar == null ? 0 : arVar.m9173j();
        String a = m8514a(mo1941f());
        if (a == null || a.equals(c)) {
            return false;
        }
        if (arVar == null) {
            arVar = new ar();
        }
        arVar.m9157a(a);
        arVar.m9156a(System.currentTimeMillis());
        arVar.m9155a(j + 1);
        aq aqVar = new aq();
        aqVar.m9106a(this.f5727c);
        aqVar.m9115c(a);
        aqVar.m9109b(c);
        aqVar.m9105a(arVar.m9169f());
        if (this.f5728d == null) {
            this.f5728d = new ArrayList(2);
        }
        this.f5728d.add(aqVar);
        if (this.f5728d.size() > 10) {
            this.f5728d.remove(0);
        }
        this.f5729e = arVar;
        return true;
    }

    /* renamed from: d */
    public ar m8521d() {
        return this.f5729e;
    }

    /* renamed from: a */
    public void m8516a(ar arVar) {
        this.f5729e = arVar;
    }

    /* renamed from: e */
    public List<aq> m8522e() {
        return this.f5728d;
    }

    /* renamed from: a */
    public void m8515a(List<aq> list) {
        this.f5728d = list;
    }

    /* renamed from: a */
    public String m8514a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    /* renamed from: a */
    public void m8517a(as asVar) {
        this.f5729e = (ar) asVar.m9215d().get("mName");
        List<aq> j = asVar.m9221j();
        if (j != null && j.size() > 0) {
            if (this.f5728d == null) {
                this.f5728d = new ArrayList();
            }
            for (aq aqVar : j) {
                if (this.f5727c.equals(aqVar.f6007a)) {
                    this.f5728d.add(aqVar);
                }
            }
        }
    }
}
