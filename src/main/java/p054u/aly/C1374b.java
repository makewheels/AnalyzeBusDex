package p054u.aly;

import android.content.Context;
import android.provider.Settings.Secure;

/* compiled from: AndroidIdTracker */
/* renamed from: u.aly.b */
public class C1374b extends C1274a {
    /* renamed from: a */
    private static final String f6192a = "android_id";
    /* renamed from: b */
    private Context f6193b;

    public C1374b(Context context) {
        super(f6192a);
        this.f6193b = context;
    }

    /* renamed from: f */
    public String mo1941f() {
        String str = null;
        try {
            str = Secure.getString(this.f6193b.getContentResolver(), f6192a);
        } catch (Exception e) {
        }
        return str;
    }
}
