package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* renamed from: com.alipay.android.phone.mrpc.core.s */
public final class C0046s {
    /* renamed from: a */
    private static Boolean f87a = null;

    /* renamed from: a */
    public static final boolean m123a(Context context) {
        if (f87a != null) {
            return f87a.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f87a = valueOf;
            return valueOf.booleanValue();
        } catch (Exception e) {
            return false;
        }
    }
}
