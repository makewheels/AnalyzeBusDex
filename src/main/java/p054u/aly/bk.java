package p054u.aly;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: Res */
/* renamed from: u.aly.bk */
public class bk {
    /* renamed from: a */
    private static final String f6363a = bk.class.getName();
    /* renamed from: b */
    private static bk f6364b = null;
    /* renamed from: c */
    private Resources f6365c;
    /* renamed from: d */
    private final String f6366d;
    /* renamed from: e */
    private final String f6367e = "drawable";
    /* renamed from: f */
    private final String f6368f = "id";
    /* renamed from: g */
    private final String f6369g = "layout";
    /* renamed from: h */
    private final String f6370h = "anim";
    /* renamed from: i */
    private final String f6371i = "style";
    /* renamed from: j */
    private final String f6372j = "string";
    /* renamed from: k */
    private final String f6373k = "array";

    private bk(Context context) {
        this.f6365c = context.getResources();
        this.f6366d = context.getPackageName();
    }

    /* renamed from: a */
    public static synchronized bk m10011a(Context context) {
        bk bkVar;
        synchronized (bk.class) {
            if (f6364b == null) {
                f6364b = new bk(context.getApplicationContext());
            }
            bkVar = f6364b;
        }
        return bkVar;
    }

    /* renamed from: a */
    public int m10012a(String str) {
        return m10010a(str, "anim");
    }

    /* renamed from: b */
    public int m10013b(String str) {
        return m10010a(str, "id");
    }

    /* renamed from: c */
    public int m10014c(String str) {
        return m10010a(str, "drawable");
    }

    /* renamed from: d */
    public int m10015d(String str) {
        return m10010a(str, "layout");
    }

    /* renamed from: e */
    public int m10016e(String str) {
        return m10010a(str, "style");
    }

    /* renamed from: f */
    public int m10017f(String str) {
        return m10010a(str, "string");
    }

    /* renamed from: g */
    public int m10018g(String str) {
        return m10010a(str, "array");
    }

    /* renamed from: a */
    private int m10010a(String str, String str2) {
        int identifier = this.f6365c.getIdentifier(str, str2, this.f6366d);
        if (identifier != 0) {
            return identifier;
        }
        bj.m10002b(f6363a, "getRes(" + str2 + "/ " + str + ")");
        bj.m10002b(f6363a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
        return 0;
    }
}
