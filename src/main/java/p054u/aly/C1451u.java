package p054u.aly;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferenceWrapper */
/* renamed from: u.aly.u */
public class C1451u {
    /* renamed from: a */
    private static final String f6599a = "umeng_general_config";

    private C1451u() {
    }

    /* renamed from: a */
    public static SharedPreferences m10466a(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public static SharedPreferences m10465a(Context context) {
        return context.getSharedPreferences(f6599a, 0);
    }
}
