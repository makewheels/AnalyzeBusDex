package com.iflytek.cloud.util.p032a.p035b;

import android.content.Context;
import android.net.Uri;
import android.provider.Contacts.People;
import com.alipay.sdk.cons.C0110c;
import com.iflytek.cloud.util.p032a.p034c.C0983a;
import com.umeng.analytics.onlineconfig.C1248a;

/* renamed from: com.iflytek.cloud.util.a.b.a */
public class C0984a extends C0983a {
    /* renamed from: d */
    private static final String[] f4631d = new String[]{"_id", C0110c.f289e};
    /* renamed from: e */
    private static final String[] f4632e = new String[]{C0110c.f289e, "number", "_id"};
    /* renamed from: f */
    private static final String[] f4633f = new String[]{"person"};
    /* renamed from: g */
    private static final String[] f4634g = new String[]{"display_name"};
    /* renamed from: h */
    private static final String[] f4635h = new String[]{"number", C1248a.f5654a, C0110c.f289e};
    /* renamed from: i */
    private static final String[] f4636i = new String[]{"_id", C0110c.f289e, "number", C1248a.f5654a};
    /* renamed from: j */
    private static final String[] f4637j = new String[]{"number"};

    public C0984a(Context context) {
        super(context);
        m7316a(context);
    }

    /* renamed from: a */
    public Uri mo1612a() {
        return People.CONTENT_URI;
    }

    /* renamed from: b */
    protected String[] mo1613b() {
        return f4631d;
    }

    /* renamed from: c */
    protected String mo1614c() {
        return C0110c.f289e;
    }
}
