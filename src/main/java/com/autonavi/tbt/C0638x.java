package com.autonavi.tbt;

import android.content.Context;
import java.util.List;

/* compiled from: LogDBOperation */
/* renamed from: com.autonavi.tbt.x */
public class C0638x {
    /* renamed from: a */
    private C0636v f3873a;

    public C0638x(Context context) {
        this.f3873a = new C0636v(context);
    }

    /* renamed from: a */
    private C0632y m4972a(int i) {
        switch (i) {
            case 0:
                return new C0634t();
            case 1:
                return new C0637w();
            case 2:
                return new C0633s();
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void m4977a(String str, int i) {
        try {
            m4975b(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m4975b(String str, int i) {
        this.f3873a.m4968a(C0632y.m4958a(str), m4972a(i));
    }

    /* renamed from: a */
    public void m4976a(C0639z c0639z, int i) {
        try {
            C0632y a = m4972a(i);
            switch (i) {
                case 0:
                    m4973a(c0639z, a);
                    return;
                case 1:
                    m4974b(c0639z, a);
                    return;
                case 2:
                    m4974b(c0639z, a);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    /* renamed from: a */
    private void m4973a(C0639z c0639z, C0632y c0632y) {
        c0632y.m4960a(c0639z);
        this.f3873a.m4967a(c0632y);
    }

    /* renamed from: b */
    private void m4974b(C0639z c0639z, C0632y c0632y) {
        String a = C0632y.m4958a(c0639z.m4981b());
        List c = this.f3873a.m4970c(a, c0632y);
        if (c == null || c.size() == 0) {
            c0632y.m4960a(c0639z);
            this.f3873a.m4967a(c0632y);
            return;
        }
        C0639z c0639z2 = (C0639z) c.get(0);
        if (c0639z.m4978a() == 0) {
            c0639z2.m4982b(c0639z2.m4985d() + 1);
        } else {
            c0639z2.m4982b(0);
        }
        c0632y.m4960a(c0639z2);
        this.f3873a.m4969b(a, c0632y);
    }
}
