package com.ta.utdid2.p037b.p038a;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

/* compiled from: PhoneInfoUtils */
/* renamed from: com.ta.utdid2.b.a.f */
public final class C1018f {
    /* renamed from: a */
    private static String m7379a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        Object a = C1016d.m7375a(currentTimeMillis);
        Object a2 = C1016d.m7375a(nanoTime);
        Object a3 = C1016d.m7375a(nextInt);
        Object a4 = C1016d.m7375a(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(a, 0, obj, 0, 4);
        System.arraycopy(a2, 0, obj, 4, 4);
        System.arraycopy(a3, 0, obj, 8, 4);
        System.arraycopy(a4, 0, obj, 12, 4);
        return C1014b.m7372a(obj, 2);
    }

    /* renamed from: a */
    public static String m7380a(Context context) {
        String str = null;
        if (context != null) {
            try {
                String deviceId;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                } else {
                    deviceId = null;
                }
                str = deviceId;
            } catch (Exception e) {
            }
        }
        if (C1020h.m7383a(str)) {
            return C1018f.m7379a();
        }
        return str;
    }

    /* renamed from: b */
    public static String m7381b(Context context) {
        String str = null;
        if (context != null) {
            try {
                String subscriberId;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                } else {
                    subscriberId = null;
                }
                str = subscriberId;
            } catch (Exception e) {
            }
        }
        if (C1020h.m7383a(str)) {
            return C1018f.m7379a();
        }
        return str;
    }
}
