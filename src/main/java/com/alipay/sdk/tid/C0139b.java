package com.alipay.sdk.tid;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.util.C0141b;

/* renamed from: com.alipay.sdk.tid.b */
public final class C0139b {
    /* renamed from: c */
    private static C0139b f421c;
    /* renamed from: a */
    public String f422a;
    /* renamed from: b */
    public String f423b;

    private C0139b() {
    }

    /* renamed from: a */
    public static synchronized C0139b m480a() {
        C0139b c0139b;
        synchronized (C0139b.class) {
            if (f421c == null) {
                f421c = new C0139b();
                Context context = C0136b.m459a().f414a;
                C0138a c0138a = new C0138a(context);
                String a = C0141b.m491a(context).m497a();
                String b = C0141b.m491a(context).m498b();
                f421c.f422a = c0138a.m478b(a, b);
                f421c.f423b = c0138a.m479c(a, b);
                if (TextUtils.isEmpty(f421c.f423b)) {
                    C0139b c0139b2 = f421c;
                    String toHexString = Long.toHexString(System.currentTimeMillis());
                    if (toHexString.length() > 10) {
                        toHexString = toHexString.substring(toHexString.length() - 10);
                    }
                    c0139b2.f423b = toHexString;
                }
                c0138a.m477a(a, b, f421c.f422a, f421c.f423b);
            }
            c0139b = f421c;
        }
        return c0139b;
    }

    /* renamed from: a */
    private void m481a(Context context) {
        C0138a c0138a = new C0138a(context);
        try {
            c0138a.m477a(C0141b.m491a(context).m497a(), C0141b.m491a(context).m498b(), this.f422a, this.f423b);
        } catch (Exception e) {
        } finally {
            c0138a.close();
        }
    }

    /* renamed from: a */
    private void m482a(String str) {
        this.f422a = str;
    }

    /* renamed from: b */
    private String m483b() {
        return this.f422a;
    }

    /* renamed from: b */
    private void m484b(String str) {
        this.f423b = str;
    }

    /* renamed from: c */
    private String m485c() {
        return this.f423b;
    }

    /* renamed from: d */
    private boolean m486d() {
        return TextUtils.isEmpty(this.f422a);
    }

    /* renamed from: e */
    private static void m487e() {
        Context context = C0136b.m459a().f414a;
        String a = C0141b.m491a(context).m497a();
        String b = C0141b.m491a(context).m498b();
        C0138a c0138a = new C0138a(context);
        c0138a.m476a(a, b);
        c0138a.close();
    }

    /* renamed from: f */
    private static String m488f() {
        String toHexString = Long.toHexString(System.currentTimeMillis());
        return toHexString.length() > 10 ? toHexString.substring(toHexString.length() - 10) : toHexString;
    }
}
