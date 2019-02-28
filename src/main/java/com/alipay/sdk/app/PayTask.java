package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.cons.C0110c;
import com.alipay.sdk.data.C0112b;
import com.alipay.sdk.data.C0113c;
import com.alipay.sdk.data.C0114d;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.net.C0125d;
import com.alipay.sdk.protocol.C0126a;
import com.alipay.sdk.protocol.C0127b;
import com.alipay.sdk.sys.C0135a;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.tid.C0138a;
import com.alipay.sdk.tid.C0139b;
import com.alipay.sdk.util.C0140a;
import com.alipay.sdk.util.C0141b;
import com.alipay.sdk.util.C0147h;
import com.alipay.sdk.util.C0150k;
import com.alipay.sdk.widget.C0151a;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class PayTask {
    /* renamed from: a */
    static final Object f173a = C0147h.class;
    /* renamed from: b */
    private Activity f174b;
    /* renamed from: c */
    private C0151a f175c = null;

    public PayTask(Activity activity) {
        this.f174b = activity;
    }

    /* renamed from: a */
    private String m220a(C0126a c0126a) {
        String[] a = C0140a.m489a(c0126a.m415e());
        Intent intent = new Intent(this.f174b, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", a[0]);
        if (a.length == 2) {
            bundle.putString("cookie", a[1]);
        }
        intent.putExtras(bundle);
        this.f174b.startActivity(intent);
        synchronized (f173a) {
            try {
                f173a.wait();
            } catch (InterruptedException e) {
                return C0088l.m224a();
            }
        }
        Object obj = C0088l.f189a;
        return TextUtils.isEmpty(obj) ? C0088l.m224a() : obj;
    }

    /* renamed from: a */
    private String m221a(String str) {
        return new C0147h(this.f174b).m519a(str);
    }

    /* renamed from: b */
    private String m222b(String str) {
        try {
            if (!(this.f174b == null || this.f174b.isFinishing())) {
                this.f175c = new C0151a(this.f174b);
                this.f175c.m544b();
                C0136b.m459a().m466a(this.f174b, C0114d.m315a());
            }
        } catch (Exception e) {
            this.f175c = null;
        }
        return m223c(str);
    }

    /* renamed from: c */
    private String m223c(String str) {
        C0089m c0089m;
        int i = 0;
        C0138a c0138a;
        try {
            C0126a[] a = C0126a.m408a(C0127b.m426a(new C0125d(new C0113c()).m407a(this.f174b, C0112b.m297a(new C0113c(), str, new JSONObject()), false).f393c.optJSONObject(C0110c.f287c), C0110c.f288d));
            for (C0126a c0126a : a) {
                if (c0126a == C0126a.Update) {
                    String[] a2 = C0140a.m489a(c0126a.m415e());
                    if (a2.length == 3 && TextUtils.equals(C0109b.f277c, a2[0])) {
                        Context context = C0136b.m459a().f414a;
                        C0139b a3 = C0139b.m480a();
                        if (!(TextUtils.isEmpty(a2[1]) || TextUtils.isEmpty(a2[2]))) {
                            a3.f422a = a2[1];
                            a3.f423b = a2[2];
                            c0138a = new C0138a(context);
                            c0138a.m477a(C0141b.m491a(context).m497a(), C0141b.m491a(context).m498b(), a3.f422a, a3.f423b);
                            c0138a.close();
                        }
                    }
                }
            }
            if (this.f175c != null) {
                this.f175c.m545c();
            }
            int length = a.length;
            while (i < length) {
                C0126a c0126a2 = a[i];
                if (c0126a2 == C0126a.WapPay) {
                    String a4 = m220a(c0126a2);
                    if (this.f175c == null) {
                        return a4;
                    }
                    this.f175c.m545c();
                    return a4;
                }
                i++;
            }
            if (this.f175c != null) {
                this.f175c.m545c();
                c0089m = null;
                if (c0089m == null) {
                    c0089m = C0089m.m229a(C0089m.FAILED.m232a());
                }
                return C0088l.m225a(c0089m.m232a(), c0089m.m233b(), bi_常量类.f6358b);
            }
        } catch (Exception e) {
            c0138a.close();
        } catch (NetErrorException e2) {
            c0089m = C0089m.m229a(C0089m.NETWORK_ERROR.m232a());
            if (this.f175c != null) {
                this.f175c.m545c();
            }
        } catch (Exception e3) {
            if (this.f175c != null) {
                this.f175c.m545c();
                c0089m = null;
            }
        } catch (Throwable th) {
            if (this.f175c != null) {
                this.f175c.m545c();
            }
        }
        c0089m = null;
        if (c0089m == null) {
            c0089m = C0089m.m229a(C0089m.FAILED.m232a());
        }
        return C0088l.m225a(c0089m.m232a(), c0089m.m233b(), bi_常量类.f6358b);
    }

    public boolean checkAccountIfExist() {
        boolean z = false;
        try {
            z = new C0125d().m407a(this.f174b, C0112b.m296a(), true).f393c.optBoolean("hasAccount", false);
        } catch (Exception e) {
        }
        return z;
    }

    public String getVersion() {
        return C0108a.f264g;
    }

    public synchronized String pay(String str) {
        String b;
        if (!str.contains("bizcontext=")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&bizcontext=\"");
            stringBuilder.append(new C0135a(this.f174b).toString());
            stringBuilder.append("\"");
            str = stringBuilder.toString();
        }
        if (str.contains("paymethod=\"expressGateway\"")) {
            b = m222b(str);
        } else if (C0150k.m528b(this.f174b)) {
            b = new C0147h(this.f174b).m519a(str);
            if (TextUtils.equals(b, C0147h.f452a)) {
                b = m222b(str);
            } else if (TextUtils.isEmpty(b)) {
                b = C0088l.m224a();
            }
        } else {
            b = m222b(str);
        }
        return b;
    }
}
