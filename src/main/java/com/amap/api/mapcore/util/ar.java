package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* compiled from: UpdateLogDBOperation */
public class ar {
    /* renamed from: a */
    private aj f1978a = m3111a(this.f1979b);
    /* renamed from: b */
    private Context f1979b;

    public ar(Context context) {
        this.f1979b = context;
    }

    /* renamed from: a */
    private aj m3111a(Context context) {
        try {
            return new aj(context);
        } catch (Throwable th) {
            az.m3143a(th, "UpdateLogDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public at m3112a() {
        try {
            if (this.f1978a == null) {
                this.f1978a = m3111a(this.f1979b);
            }
            List c = this.f1978a.m3079c("1=1", new as());
            if (c.size() > 0) {
                return (at) c.get(0);
            }
        } catch (Throwable th) {
            az.m3143a(th, "UpdateLogDB", "getUpdateLog");
            th.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public void m3113a(at atVar) {
        if (atVar != null) {
            try {
                if (this.f1978a == null) {
                    this.f1978a = m3111a(this.f1979b);
                }
                aq asVar = new as();
                asVar.mo589a(atVar);
                String str = "1=1";
                List c = this.f1978a.m3079c(str, new as());
                if (c == null || c.size() == 0) {
                    this.f1978a.m3076a(asVar);
                } else {
                    this.f1978a.m3078b(str, asVar);
                }
            } catch (Throwable th) {
                az.m3143a(th, "UpdateLogDB", "updateLog");
                th.printStackTrace();
            }
        }
    }
}
