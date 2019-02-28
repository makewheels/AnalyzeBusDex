package com.ta.utdid2.p036a;

import android.content.Context;
import android.util.Log;
import com.ta.utdid2.p037b.p038a.C1017e;
import com.ta.utdid2.p037b.p038a.C1020h;
import com.ta.utdid2.p037b.p038a.C1021i;
import com.ut.device.AidCallback;
import p054u.aly.bi_常量类;

/* compiled from: AidManager */
/* renamed from: com.ta.utdid2.a.a */
public class C1006a {
    /* renamed from: a */
    private static C1006a f4664a = null;
    /* renamed from: b */
    private static final String f4665b = C1006a.class.getName();
    /* renamed from: c */
    private Context f4666c;

    /* renamed from: a */
    public static synchronized C1006a m7348a(Context context) {
        C1006a c1006a;
        synchronized (C1006a.class) {
            if (f4664a == null) {
                f4664a = new C1006a(context);
            }
            c1006a = f4664a;
        }
        return c1006a;
    }

    private C1006a(Context context) {
        this.f4666c = context;
    }

    /* renamed from: a */
    public final void m7351a(String str, String str2, String str3, AidCallback aidCallback) {
        boolean z = true;
        if (aidCallback == null) {
            Log.e(f4665b, "callback is null!");
        } else if (this.f4666c == null || C1020h.m7383a(str) || C1020h.m7383a(str2)) {
            boolean z2;
            String str4 = f4665b;
            StringBuilder append = new StringBuilder("mContext:").append(this.f4666c).append("; callback:").append(aidCallback).append("; has appName:");
            if (C1020h.m7383a(str)) {
                z2 = false;
            } else {
                z2 = true;
            }
            StringBuilder append2 = append.append(z2).append("; has token:");
            if (C1020h.m7383a(str2)) {
                z = false;
            }
            Log.e(str4, append2.append(z).toString());
            aidCallback.onAidEventChanged(1002, bi_常量类.f6358b);
        } else {
            String a = C1009c.m7362a(this.f4666c, str, str2);
            if (!C1020h.m7383a(a) && C1021i.m7385a(C1009c.m7365b(this.f4666c, str, str2))) {
                aidCallback.onAidEventChanged(1001, a);
            } else if (C1017e.m7376a(this.f4666c)) {
                C1008b.m7353a(this.f4666c).m7361a(str, str2, str3, a, aidCallback);
            } else {
                aidCallback.onAidEventChanged(1003, a);
            }
        }
    }

    /* renamed from: a */
    public final String m7350a(String str, String str2, String str3) {
        boolean z = true;
        if (this.f4666c == null || C1020h.m7383a(str) || C1020h.m7383a(str2)) {
            String str4 = f4665b;
            StringBuilder append = new StringBuilder("mContext:").append(this.f4666c).append("; has appName:").append(!C1020h.m7383a(str)).append("; has token:");
            if (C1020h.m7383a(str2)) {
                z = false;
            }
            Log.e(str4, append.append(z).toString());
            return bi_常量类.f6358b;
        }
        String a = C1009c.m7362a(this.f4666c, str, str2);
        if ((C1020h.m7383a(a) || !C1021i.m7385a(C1009c.m7365b(this.f4666c, str, str2))) && C1017e.m7376a(this.f4666c)) {
            return m7349b(str, str2, str3);
        }
        return a;
    }

    /* renamed from: b */
    private synchronized String m7349b(String str, String str2, String str3) {
        String str4;
        if (this.f4666c == null) {
            Log.e(f4665b, "no context!");
            str4 = bi_常量类.f6358b;
        } else {
            str4 = bi_常量类.f6358b;
            if (C1017e.m7376a(this.f4666c)) {
                str4 = C1008b.m7353a(this.f4666c).m7360a(str, str2, str3, C1009c.m7362a(this.f4666c, str, str2));
            }
            C1009c.m7364a(this.f4666c, str, str4, str2);
        }
        return str4;
    }
}
