package p054u.aly;

import android.content.Context;
import android.telephony.TelephonyManager;

/* compiled from: ImeiTracker */
/* renamed from: u.aly.e */
public class C1434e extends C1274a {
    /* renamed from: a */
    private static final String f6543a = "imei";
    /* renamed from: b */
    private Context f6544b;

    public C1434e(Context context) {
        super(f6543a);
        this.f6544b = context;
    }

    /* renamed from: f */
    public String mo1941f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f6544b.getSystemService("phone");
        if (telephonyManager == null) {
        }
        try {
            if (bi_常量类.m9972a(this.f6544b, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getDeviceId();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
