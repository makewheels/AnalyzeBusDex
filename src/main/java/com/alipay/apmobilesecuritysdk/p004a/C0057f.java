package com.alipay.apmobilesecuritysdk.p004a;

import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;

/* renamed from: com.alipay.apmobilesecuritysdk.a.f */
public final class C0057f {
    /* renamed from: a */
    private boolean f110a = false;
    /* renamed from: b */
    private String f111b;
    /* renamed from: c */
    private String f112c;

    public C0057f(AppListResult appListResult) {
        if (appListResult != null) {
            this.f110a = appListResult.success;
            this.f111b = appListResult.appListData;
            this.f112c = appListResult.appListVer;
        }
    }

    /* renamed from: a */
    public final boolean m151a() {
        return this.f110a;
    }

    /* renamed from: b */
    public final String m152b() {
        return this.f111b;
    }

    /* renamed from: c */
    public final String m153c() {
        return this.f112c;
    }
}
