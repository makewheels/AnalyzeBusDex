package p054u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.C1233a;
import java.lang.reflect.Method;

/* compiled from: TrafficTracker */
/* renamed from: u.aly.y */
public class C1455y {
    /* renamed from: a */
    private static final String f6621a = "uptr";
    /* renamed from: b */
    private static final String f6622b = "dntr";

    /* renamed from: a */
    public static be m10486a(Context context) {
        try {
            be beVar = new be();
            long[] b = C1455y.m10487b(context);
            if (b[0] <= 0 || b[1] <= 0) {
                return null;
            }
            SharedPreferences a = C1451u.m10465a(context);
            long j = a.getLong(f6621a, -1);
            long j2 = a.getLong(f6622b, -1);
            a.edit().putLong(f6621a, b[1]).putLong(f6622b, b[0]).commit();
            if (j <= 0 || j2 <= 0) {
                return null;
            }
            b[0] = b[0] - j2;
            b[1] = b[1] - j;
            if (b[0] <= 0 || b[1] <= 0) {
                return null;
            }
            beVar.m9733c((int) b[0]);
            beVar.m9725a((int) b[1]);
            return beVar;
        } catch (Exception e) {
            bj.m10008e(C1233a.f5589e, "sdk less than 2.2 has get no traffic");
            return null;
        }
    }

    /* renamed from: b */
    private static long[] m10487b(Context context) throws Exception {
        Class cls = Class.forName("android.net.TrafficStats");
        Method method = cls.getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
        Method method2 = cls.getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
        if (context.getApplicationInfo().uid == -1) {
            return null;
        }
        r2 = new long[2];
        r2[0] = ((Long) method.invoke(null, new Object[]{Integer.valueOf(context.getApplicationInfo().uid)})).longValue();
        r2[1] = ((Long) method2.invoke(null, new Object[]{Integer.valueOf(r5)})).longValue();
        return r2;
    }
}
