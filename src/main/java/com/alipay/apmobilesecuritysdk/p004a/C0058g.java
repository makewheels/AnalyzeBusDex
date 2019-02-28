package com.alipay.apmobilesecuritysdk.p004a;

import com.alipay.sdk.cons.C0108a;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

/* renamed from: com.alipay.apmobilesecuritysdk.a.g */
public final class C0058g {
    /* renamed from: a */
    private boolean f113a = false;
    /* renamed from: b */
    private String f114b;
    /* renamed from: c */
    private String f115c;
    /* renamed from: d */
    private String f116d;
    /* renamed from: e */
    private String f117e;
    /* renamed from: f */
    private boolean f118f = true;
    /* renamed from: g */
    private String f119g;

    public C0058g(DeviceDataReportResult deviceDataReportResult) {
        boolean z = true;
        if (deviceDataReportResult != null) {
            this.f117e = deviceDataReportResult.resultCode;
            this.f113a = deviceDataReportResult.success;
            this.f114b = deviceDataReportResult.apdid;
            this.f115c = deviceDataReportResult.token;
            this.f116d = deviceDataReportResult.currentTime;
            this.f119g = deviceDataReportResult.appListVer;
            if (!C0108a.f262e.equals(deviceDataReportResult.bugTrackSwitch)) {
                z = false;
            }
            this.f118f = z;
        }
    }

    /* renamed from: a */
    public final boolean m154a() {
        return !C0159a.m556a(this.f114b) ? this.f113a : false;
    }

    /* renamed from: b */
    public final String m155b() {
        return this.f114b;
    }

    /* renamed from: c */
    public final String m156c() {
        return this.f115c;
    }

    /* renamed from: d */
    public final String m157d() {
        return this.f116d;
    }

    /* renamed from: e */
    public final String m158e() {
        return this.f117e;
    }

    /* renamed from: f */
    public final boolean m159f() {
        return this.f118f;
    }

    /* renamed from: g */
    public final String m160g() {
        return this.f119g;
    }
}
