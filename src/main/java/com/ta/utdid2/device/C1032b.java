package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.p037b.p038a.C1018f;
import com.ta.utdid2.p037b.p038a.C1020h;
import java.util.zip.Adler32;

/* compiled from: DeviceInfo */
/* renamed from: com.ta.utdid2.device.b */
public final class C1032b {
    /* renamed from: a */
    static String f4746a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    /* renamed from: b */
    static final Object f4747b = new Object();
    /* renamed from: c */
    private static C1031a f4748c = null;

    /* renamed from: b */
    private static C1031a m7458b(Context context) {
        if (context != null) {
            C1031a c1031a = new C1031a();
            synchronized (f4747b) {
                String a = C1033c.m7459a(context).m7466a();
                if (!C1020h.m7383a(a)) {
                    String substring;
                    long j;
                    if (a.endsWith("\n")) {
                        substring = a.substring(0, a.length() - 1);
                    } else {
                        substring = a;
                    }
                    c1031a = new C1031a();
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = C1018f.m7380a(context);
                    String b = C1018f.m7381b(context);
                    c1031a.m7453c(a2);
                    c1031a.m7448a(a2);
                    c1031a.m7450b(currentTimeMillis);
                    c1031a.m7451b(b);
                    c1031a.m7455d(substring);
                    substring = String.format("%s%s%s%s%s", new Object[]{c1031a.m7456e(), c1031a.m7454d(), Long.valueOf(c1031a.m7446a()), c1031a.m7452c(), c1031a.m7449b()});
                    if (C1020h.m7383a(substring)) {
                        j = 0;
                    } else {
                        Adler32 adler32 = new Adler32();
                        adler32.reset();
                        adler32.update(substring.getBytes());
                        j = adler32.getValue();
                    }
                    c1031a.m7447a(j);
                    return c1031a;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized C1031a m7457a(Context context) {
        C1031a c1031a;
        synchronized (C1032b.class) {
            if (f4748c != null) {
                c1031a = f4748c;
            } else if (context != null) {
                c1031a = C1032b.m7458b(context);
                f4748c = c1031a;
            } else {
                c1031a = null;
            }
        }
        return c1031a;
    }
}
