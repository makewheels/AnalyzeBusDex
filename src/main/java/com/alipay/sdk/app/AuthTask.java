package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0110c;
import com.alipay.sdk.data.C0112b;
import com.alipay.sdk.data.C0113c;
import com.alipay.sdk.data.C0114d;
import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.net.C0125d;
import com.alipay.sdk.protocol.C0126a;
import com.alipay.sdk.protocol.C0127b;
import com.alipay.sdk.protocol.C0128c;
import com.alipay.sdk.sys.C0135a;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.util.C0140a;
import com.alipay.sdk.util.C0147h;
import com.alipay.sdk.util.C0150k;
import com.alipay.sdk.widget.C0151a;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class AuthTask {
    /* renamed from: a */
    static final Object f155a = C0147h.class;
    /* renamed from: b */
    private static final int f156b = 73;
    /* renamed from: c */
    private static final int f157c = 77;
    /* renamed from: d */
    private Activity f158d;

    public AuthTask(Activity activity) {
        this.f158d = activity;
    }

    /* renamed from: a */
    private String m195a(Activity activity, String str) {
        if (!m197a((Context) activity)) {
            return m198b(activity, str);
        }
        Object a = new C0147h(activity).m519a(str);
        return TextUtils.equals(a, C0147h.f452a) ? m198b(activity, str) : TextUtils.isEmpty(a) ? C0088l.m224a() : a;
    }

    /* renamed from: a */
    private String m196a(C0126a c0126a) {
        String[] a = C0140a.m489a(c0126a.m415e());
        Bundle bundle = new Bundle();
        bundle.putString("url", a[0]);
        Intent intent = new Intent(this.f158d, H5AuthActivity.class);
        intent.putExtras(bundle);
        this.f158d.startActivity(intent);
        synchronized (f155a) {
            try {
                f155a.wait();
            } catch (InterruptedException e) {
                return C0088l.m224a();
            }
        }
        Object obj = C0088l.f189a;
        return TextUtils.isEmpty(obj) ? C0088l.m224a() : obj;
    }

    /* renamed from: a */
    private static boolean m197a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(C0150k.f466b, 128);
            return packageInfo != null && packageInfo.versionCode >= 73;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: b */
    private String m198b(Activity activity, String str) {
        C0151a c0151a;
        C0115e a;
        int i;
        C0089m c0089m;
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    c0151a = new C0151a(activity);
                    c0151a.m544b();
                    C0136b.m459a().m466a(this.f158d, C0114d.m315a());
                    a = C0112b.m297a(new C0113c(), str.toString(), new JSONObject());
                    a.f316a.f300b = "com.alipay.mobilecashier";
                    a.f316a.f303e = "com.alipay.mcpay";
                    a.f316a.f302d = "4.0.3";
                    a.f316a.f301c = "/cashier/main";
                    C0128c a2 = new C0125d(new C0113c()).m407a((Context) activity, a, false);
                    if (c0151a != null) {
                        c0151a.m545c();
                        Object obj = null;
                    }
                    for (C0126a c0126a : C0126a.m408a(C0127b.m426a(a2.f393c.optJSONObject(C0110c.f287c), C0110c.f288d))) {
                        if (c0126a == C0126a.WapPay) {
                            return m196a(c0126a);
                        }
                    }
                    c0089m = null;
                    if (c0089m == null) {
                        c0089m = C0089m.m229a(C0089m.FAILED.m232a());
                    }
                    return C0088l.m225a(c0089m.m232a(), c0089m.m233b(), bi_常量类.f6358b_空串);
                }
            } catch (Exception e) {
                c0151a = null;
            }
        }
        c0151a = null;
        C0136b.m459a().m466a(this.f158d, C0114d.m315a());
        a = C0112b.m297a(new C0113c(), str.toString(), new JSONObject());
        a.f316a.f300b = "com.alipay.mobilecashier";
        a.f316a.f303e = "com.alipay.mcpay";
        a.f316a.f302d = "4.0.3";
        a.f316a.f301c = "/cashier/main";
        try {
            C0128c a22 = new C0125d(new C0113c()).m407a((Context) activity, a, false);
            if (c0151a != null) {
                c0151a.m545c();
                Object obj2 = null;
            }
            for (i = 0; i < r4; i++) {
                if (c0126a == C0126a.WapPay) {
                    return m196a(c0126a);
                }
            }
            c0089m = null;
        } catch (NetErrorException e2) {
            r1 = C0089m.m229a(C0089m.NETWORK_ERROR.m232a());
            C0089m a3;
            if (c0151a != null) {
                c0151a.m545c();
                c0089m = a3;
            } else {
                c0089m = a3;
            }
        } catch (Exception e3) {
            if (c0151a != null) {
                c0151a.m545c();
                c0089m = null;
            } else {
                c0089m = null;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            r1 = c0151a;
            Throwable th3 = th2;
            C0151a c0151a2;
            if (c0151a2 != null) {
                c0151a2.m545c();
            }
        }
        if (c0089m == null) {
            c0089m = C0089m.m229a(C0089m.FAILED.m232a());
        }
        return C0088l.m225a(c0089m.m232a(), c0089m.m233b(), bi_常量类.f6358b_空串);
    }

    /* renamed from: b */
    private static boolean m199b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(C0150k.f466b, 128);
            return packageInfo != null && packageInfo.versionCode >= 77;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public synchronized String auth(String str) {
        String a;
        if (!str.contains("bizcontext=")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&bizcontext=\"");
            stringBuilder.append(new C0135a(this.f158d).toString());
            stringBuilder.append("\"");
            str = stringBuilder.toString();
        }
        Context context = this.f158d;
        if (m197a(context)) {
            a = new C0147h(context).m519a(str);
            if (!TextUtils.equals(a, C0147h.f452a)) {
                if (TextUtils.isEmpty(a)) {
                    a = C0088l.m224a();
                }
            }
        }
        a = m198b(context, str);
        return a;
    }
}
