package com.iflytek.cloud.util.p032a.p035b;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.iflytek.cloud.util.p032a.p034c.C0983a;

/* renamed from: com.iflytek.cloud.util.a.b.b */
public class C0985b extends C0983a {
    /* renamed from: d */
    private static final String[] f4638d = new String[]{"display_name", "_id"};
    /* renamed from: e */
    private static final String[] f4639e = new String[]{"display_name", "data1", "contact_id"};
    /* renamed from: f */
    private static final String[] f4640f = new String[]{"_id", "has_phone_number"};
    /* renamed from: g */
    private static final String[] f4641g = new String[]{"contact_id"};
    /* renamed from: h */
    private static final String[] f4642h = new String[]{"display_name"};
    /* renamed from: i */
    private static final String[] f4643i = new String[]{"data1", "data2", "display_name"};
    /* renamed from: j */
    private static final String[] f4644j = new String[]{"has_phone_number"};

    public C0985b(Context context) {
        super(context);
        m7316a(context);
    }

    /* renamed from: a */
    public Uri mo1612a() {
        return Contacts.CONTENT_URI;
    }

    /* renamed from: b */
    protected String[] mo1613b() {
        return f4638d;
    }

    /* renamed from: c */
    protected String mo1614c() {
        return Integer.parseInt(VERSION.SDK) >= 8 ? "sort_key" : "display_name";
    }
}
