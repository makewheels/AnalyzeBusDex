package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.C1165a;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

class am {
    /* renamed from: e */
    private static am f4967e = null;
    /* renamed from: a */
    ao f4968a = null;
    /* renamed from: b */
    Context f4969b;
    /* renamed from: c */
    C1165a f4970c;
    /* renamed from: d */
    IUserStateChangedListener f4971d;

    private am(Context context) {
        this.f4969b = context.getApplicationContext();
        this.f4968a = new ao(this.f4969b);
    }

    /* renamed from: a */
    public static synchronized am m7753a(Context context) {
        am amVar;
        synchronized (am.class) {
            if (f4967e == null) {
                f4967e = new am(context);
            }
            amVar = f4967e;
        }
        return amVar;
    }

    /* renamed from: a */
    public void m7754a(int i, int i2, Intent intent) {
        if (this.f4970c != null) {
            this.f4970c.m8084a(i, i2, intent);
        }
    }

    /* renamed from: a */
    void m7755a(Activity activity, int i) {
        this.f4968a.m7761a(activity, i);
    }

    /* renamed from: a */
    public boolean m7756a() {
        this.f4968a.m7759a();
        return this.f4968a.m7763b();
    }

    /* renamed from: a */
    public boolean m7757a(String str, Bundle bundle, C1165a c1165a) {
        Object obj;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (c1165a != null) {
            this.f4968a.m7759a();
            if (!this.f4968a.m7763b()) {
                return false;
            }
            this.f4970c = c1165a;
            this.f4971d = new an(this);
            this.f4970c.m8085a(this.f4971d);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        ao aoVar = this.f4968a;
        if (c1165a == null) {
            obj = null;
        }
        aoVar.m7762a(bundle, obj);
        return true;
    }
}
