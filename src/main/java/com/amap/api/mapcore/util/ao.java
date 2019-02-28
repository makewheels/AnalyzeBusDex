package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public class ao {
    /* renamed from: a */
    private aj f1969a = m3098a(this.f1970b);
    /* renamed from: b */
    private Context f1970b;

    public ao(Context context) {
        this.f1970b = context;
    }

    /* renamed from: a */
    private aj m3098a(Context context) {
        try {
            return new aj(context);
        } catch (Throwable th) {
            az.m3143a(th, "SDKDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m3100a(ad adVar) {
        if (adVar != null) {
            try {
                if (this.f1969a == null) {
                    this.f1969a = m3098a(this.f1970b);
                }
                aq apVar = new ap();
                apVar.mo589a(adVar);
                String a = ap.m3101a(adVar.m3033a());
                List c = this.f1969a.m3079c(a, new ap());
                if (c == null || c.size() == 0) {
                    this.f1969a.m3076a(apVar);
                } else {
                    this.f1969a.m3078b(a, apVar);
                }
            } catch (Throwable th) {
                az.m3143a(th, "SDKDB", "insert");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public List<ad> m3099a() {
        List<ad> list = null;
        try {
            aq apVar = new ap();
            list = this.f1969a.m3079c(ap.m3104c(), apVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }
}
