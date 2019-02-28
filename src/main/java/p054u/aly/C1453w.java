package p054u.aly;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: StatTracer */
/* renamed from: u.aly.w */
public class C1453w {
    /* renamed from: h */
    private static final String f6606h = "successful_request";
    /* renamed from: i */
    private static final String f6607i = "failed_requests ";
    /* renamed from: j */
    private static final String f6608j = "last_request_spent_ms";
    /* renamed from: k */
    private static final String f6609k = "last_request_time";
    /* renamed from: l */
    private static final String f6610l = "first_activate_time";
    /* renamed from: a */
    public int f6611a;
    /* renamed from: b */
    public int f6612b;
    /* renamed from: c */
    public long f6613c;
    /* renamed from: d */
    private final int f6614d = 3600000;
    /* renamed from: e */
    private int f6615e;
    /* renamed from: f */
    private long f6616f = 0;
    /* renamed from: g */
    private long f6617g = 0;
    /* renamed from: m */
    private Context f6618m;

    public C1453w(Context context) {
        m10475b(context);
    }

    /* renamed from: b */
    private void m10475b(Context context) {
        this.f6618m = context.getApplicationContext();
        SharedPreferences a = C1451u.m10465a(context);
        this.f6611a = a.getInt(f6606h, 0);
        this.f6612b = a.getInt(f6607i, 0);
        this.f6615e = a.getInt(f6608j, 0);
        this.f6613c = a.getLong(f6609k, 0);
    }

    /* renamed from: a */
    public int m10476a() {
        return this.f6615e > 3600000 ? 3600000 : this.f6615e;
    }

    /* renamed from: b */
    public boolean m10477b() {
        return this.f6613c == 0;
    }

    /* renamed from: c */
    public void m10478c() {
        this.f6611a++;
        this.f6613c = this.f6616f;
    }

    /* renamed from: d */
    public void m10479d() {
        this.f6612b++;
    }

    /* renamed from: e */
    public void m10480e() {
        this.f6616f = System.currentTimeMillis();
    }

    /* renamed from: f */
    public void m10481f() {
        this.f6615e = (int) (System.currentTimeMillis() - this.f6616f);
    }

    /* renamed from: g */
    public void m10482g() {
        C1451u.m10465a(this.f6618m).edit().putInt(f6606h, this.f6611a).putInt(f6607i, this.f6612b).putInt(f6608j, this.f6615e).putLong(f6609k, this.f6613c).commit();
    }

    /* renamed from: h */
    public void m10483h() {
        C1451u.m10465a(this.f6618m).edit().putLong(f6610l, System.currentTimeMillis()).commit();
    }

    /* renamed from: i */
    public boolean m10484i() {
        if (this.f6617g == 0) {
            this.f6617g = C1451u.m10465a(this.f6618m).getLong(f6610l, 0);
        }
        return this.f6617g == 0;
    }

    /* renamed from: j */
    public long m10485j() {
        return m10484i() ? System.currentTimeMillis() : this.f6617g;
    }

    /* renamed from: a */
    public static aj m10474a(Context context) {
        SharedPreferences a = C1451u.m10465a(context);
        aj ajVar = new aj();
        ajVar.m8858c(a.getInt(f6607i, 0));
        ajVar.m8860d(a.getInt(f6608j, 0));
        ajVar.m8850a(a.getInt(f6606h, 0));
        return ajVar;
    }
}
