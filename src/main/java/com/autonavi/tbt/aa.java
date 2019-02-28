package com.autonavi.tbt;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public class aa {
    /* renamed from: a */
    private C0636v f3674a = m4655a(this.f3675b);
    /* renamed from: b */
    private Context f3675b;

    public aa(Context context) {
        this.f3675b = context;
    }

    /* renamed from: a */
    private C0636v m4655a(Context context) {
        try {
            return new C0636v(context);
        } catch (Throwable th) {
            ae.m4671a(th, "SDKDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List<C0629p> m4656a() {
        List<C0629p> list = null;
        try {
            ac abVar = new ab();
            list = this.f3674a.m4970c(ab.m4662c(), abVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }
}
