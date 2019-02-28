package com.tencent.p041a.p042a.p043a.p044a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.a.a.a.a.g */
public final class C1042g {
    /* renamed from: V */
    private static C1042g f4768V = null;
    /* renamed from: U */
    private Map<Integer, C1037f> f4769U = null;
    /* renamed from: b */
    private int f4770b = 0;
    /* renamed from: c */
    private Context f4771c = null;

    private C1042g(Context context) {
        this.f4771c = context.getApplicationContext();
        this.f4769U = new HashMap(3);
        this.f4769U.put(Integer.valueOf(1), new C1041e(context));
        this.f4769U.put(Integer.valueOf(2), new C1038b(context));
        this.f4769U.put(Integer.valueOf(4), new C1040d(context));
    }

    /* renamed from: E */
    public static synchronized C1042g m7491E(Context context) {
        C1042g c1042g;
        synchronized (C1042g.class) {
            if (f4768V == null) {
                f4768V = new C1042g(context);
            }
            c1042g = f4768V;
        }
        return c1042g;
    }

    /* renamed from: b */
    private C1039c m7492b(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                C1037f c1037f = (C1037f) this.f4769U.get(num);
                if (c1037f != null) {
                    C1039c o = c1037f.m7478o();
                    if (o != null && C1043h.m7501c(o.f4767c)) {
                        return o;
                    }
                }
            }
        }
        return new C1039c();
    }

    /* renamed from: a */
    public final void m7493a(String str) {
        C1039c p = m7494p();
        p.f4767c = str;
        if (!C1043h.m7500b(p.f4765a)) {
            p.f4765a = C1043h.m7495a(this.f4771c);
        }
        if (!C1043h.m7500b(p.f4766b)) {
            p.f4766b = C1043h.m7499b(this.f4771c);
        }
        p.f4764T = System.currentTimeMillis();
        for (Entry value : this.f4769U.entrySet()) {
            ((C1037f) value.getValue()).m7474a(p);
        }
    }

    /* renamed from: p */
    public final C1039c m7494p() {
        return m7492b(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }
}
