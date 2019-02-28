package com.alipay.sdk.app;

/* renamed from: com.alipay.sdk.app.m */
public enum C0089m {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    PAY_WAITTING(8000, "支付结果确认中");
    
    /* renamed from: g */
    private int f197g;
    /* renamed from: h */
    private String f198h;

    private C0089m(int i, String str) {
        this.f197g = i;
        this.f198h = str;
    }

    /* renamed from: a */
    public static C0089m m229a(int i) {
        switch (i) {
            case 4001:
                return PARAMS_ERROR;
            case 6001:
                return CANCELED;
            case 6002:
                return NETWORK_ERROR;
            case 8000:
                return PAY_WAITTING;
            case 9000:
                return SUCCEEDED;
            default:
                return FAILED;
        }
    }

    /* renamed from: a */
    private void m230a(String str) {
        this.f198h = str;
    }

    /* renamed from: b */
    private void m231b(int i) {
        this.f197g = i;
    }

    /* renamed from: a */
    public final int m232a() {
        return this.f197g;
    }

    /* renamed from: b */
    public final String m233b() {
        return this.f198h;
    }
}
