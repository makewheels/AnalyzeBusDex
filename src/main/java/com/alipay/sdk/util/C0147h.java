package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.C0088l;
import com.alipay.sdk.cons.C0108a;
import java.lang.ref.WeakReference;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.util.h */
public class C0147h {
    /* renamed from: a */
    public static final String f452a = "failed";
    /* renamed from: b */
    private WeakReference<Activity> f453b;
    /* renamed from: c */
    private IAlixPay f454c;
    /* renamed from: d */
    private final Object f455d = IAlixPay.class;
    /* renamed from: e */
    private boolean f456e = false;
    /* renamed from: f */
    private boolean f457f;
    /* renamed from: g */
    private String f458g;
    /* renamed from: h */
    private String f459h;
    /* renamed from: i */
    private String f460i = null;
    /* renamed from: j */
    private ServiceConnection f461j = new C0148i(this);
    /* renamed from: k */
    private IRemoteServiceCallback f462k = new C0149j(this);

    public C0147h(Activity activity) {
        this.f453b = new WeakReference(activity);
    }

    /* renamed from: a */
    private String m517a(String str, Intent intent) {
        this.f460i = null;
        if (this.f456e) {
            return bi_常量类.f6358b;
        }
        String str2;
        this.f456e = true;
        this.f458g = C0150k.m536f((Context) this.f453b.get());
        ((Activity) this.f453b.get()).getApplicationContext().bindService(intent, this.f461j, 1);
        synchronized (this.f455d) {
            if (this.f454c == null) {
                try {
                    this.f455d.wait(5000);
                } catch (InterruptedException e) {
                }
            }
        }
        try {
            if (this.f454c == null) {
                this.f459h = C0150k.m536f((Context) this.f453b.get());
                this.f460i = "b|" + this.f458g + "|a|" + this.f459h + "|" + Build.MANUFACTURER.replace(";", "1688").replace("#", "2688") + "|" + Build.MODEL.replace(";", "1688").replace("#", "1688");
                if (this.f458g != null || this.f459h == null) {
                    this.f460i += "|" + C0150k.m537g((Context) this.f453b.get());
                }
                String str3 = this.f460i;
                this.f453b.get();
                C0143d.m503a(str3);
                str2 = f452a;
                try {
                    ((Activity) this.f453b.get()).unbindService(this.f461j);
                } catch (Throwable th) {
                }
                this.f462k = null;
                this.f461j = null;
                this.f454c = null;
                this.f456e = false;
                if (this.f457f) {
                    ((Activity) this.f453b.get()).setRequestedOrientation(0);
                    this.f457f = false;
                }
                return str2;
            }
            if (((Activity) this.f453b.get()).getRequestedOrientation() == 0) {
                ((Activity) this.f453b.get()).setRequestedOrientation(1);
                this.f457f = true;
            }
            this.f454c.registerCallback(this.f462k);
            str2 = this.f454c.Pay(str);
            this.f454c.unregisterCallback(this.f462k);
            try {
                ((Activity) this.f453b.get()).unbindService(this.f461j);
            } catch (Throwable th2) {
            }
            this.f462k = null;
            this.f461j = null;
            this.f454c = null;
            this.f456e = false;
            if (this.f457f) {
                ((Activity) this.f453b.get()).setRequestedOrientation(0);
                this.f457f = false;
            }
            return str2;
        } catch (Exception e2) {
            this.f460i += "|e|" + e2.getMessage();
            str2 = f452a;
            ((Activity) this.f453b.get()).unbindService(this.f461j);
        } catch (Throwable th3) {
        }
        this.f462k = null;
        this.f461j = null;
        this.f454c = null;
        this.f456e = false;
        if (this.f457f) {
            ((Activity) this.f453b.get()).setRequestedOrientation(0);
            this.f457f = false;
        }
        return str2;
    }

    /* renamed from: a */
    public final String m519a(String str) {
        byte[] toByteArray;
        Context context = (Context) this.f453b.get();
        String str2 = C0150k.f466b;
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
            if (packageInfo.packageName.equals(str2)) {
                toByteArray = packageInfo.signatures[0].toByteArray();
                break;
            }
        }
        toByteArray = null;
        CharSequence a = C0150k.m522a(toByteArray);
        if (a != null && !TextUtils.equals(a, C0108a.f265h)) {
            return C0088l.m227b();
        }
        Intent intent = new Intent();
        intent.setPackage(C0150k.f466b);
        intent.setAction("com.eg.android.AlipayGphone.IAlixPay");
        return m517a(str, intent);
    }
}
